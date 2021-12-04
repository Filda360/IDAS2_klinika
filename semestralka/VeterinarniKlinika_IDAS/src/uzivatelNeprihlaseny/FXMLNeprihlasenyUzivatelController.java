
package uzivatelNeprihlaseny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static veterinarniklinika.VeterinarniKlinika.con;

public class FXMLNeprihlasenyUzivatelController implements Initializable {
    

    @FXML
    private TextArea tAreaZprava;
    @FXML
    private Button btnOdeslat;
    @FXML
    private ListView<String> listViewDoktori;
    @FXML
    private Button btnZpet;
    @FXML
    private ImageView iwDoktor;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String query = "SELECT titul, jmeno, prijmeni, telefon, email FROM DOKTORI_UDAJE";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String titul = rs.getString("titul");
                String jmeno = rs.getString("jmeno");
                String prijmeni = rs.getString("prijmeni");
                String tel = rs.getString("telefon");
                String email = rs.getString("email");
                String doktor = titul + ". " + jmeno + " " + prijmeni + " tel: " + tel + " email: " + email;
                listViewDoktori.getItems().add(doktor);
            }
        } catch (SQLException e) {
            zobrazErrorDialog("Error !", "SQL error !");
        }
    }    

    //zkouska vlozeni obrazku do databaze
    @FXML
    private void handleBtnOdeslatOnAction(ActionEvent event) {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO FOTO_DOKTORU(nazev, typ_souboru, pripona, datum_nahrani, obsah, id_doktora) VALUES(?,?,?,?,?,?)");
            pstmt.setString(1, "default_image");
            pstmt.setString(2, "obrazek");
            pstmt.setString(3, ".jpg");
            pstmt.setDate(4, new Date(50, 5, 5));
            //Inserting Blob type
            InputStream in;
            try {
                in = new FileInputStream("C:\\users\\42060\\Downloads\\man.jpg");
                pstmt.setBlob(5, in);
            } catch (FileNotFoundException ex) {
                zobrazErrorDialog("Chyba", "Obrazek nenalezen");
            }
            pstmt.setInt(6, 15);
            pstmt.execute();

        } catch (SQLException ex) {
            zobrazErrorDialog("Chyba", "Chyba vlozeni obrazku");
        }
    }

    @FXML
    private void handleBtnZpetOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/veterinarniklinika/FXMLUvodni.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            zobrazErrorDialog("Error !", "Chyba při přechodu do úvodního okna !");
        }
    }
    
    private void zobrazErrorDialog(String headText, String content){ 
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText(headText);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
