
package uzivatelNeprihlaseny;

import prihlasovani.Doktor;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static veterinarniklinika.VeterinarniKlinika.con;

public class FXMLNeprihlasenyUzivatelController implements Initializable {
    
    private ArrayList<Integer> id_doktoru;

    @FXML
    private ListView<String> listViewDoktori;
    @FXML
    private Button btnZpet;
    @FXML
    private ImageView iwDoktor;
    @FXML
    private Label labelImg;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_doktoru = new ArrayList();
        String query = "SELECT titul, jmeno, prijmeni, telefon, email, id_doktora FROM UDAJE_DOKTORI";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String titul = rs.getString("titul");
                String jmeno = rs.getString("jmeno");
                String prijmeni = rs.getString("prijmeni");
                String tel = rs.getString("telefon");
                String email = rs.getString("email");
                int id = rs.getInt("id_doktora");

                String doktor = titul + ". " + jmeno + " " + prijmeni + " tel: " + tel + " email: " + email;
                listViewDoktori.getItems().add(doktor);
                id_doktoru.add(id);
            }
        } catch (SQLException e) {
            zobrazErrorDialog("Error !", "SQL error !");
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

    @FXML
    private void handleOnMouseClicked(MouseEvent event) {
        if(listViewDoktori.getSelectionModel().getSelectedItems() != null){ 
            int index = listViewDoktori.getSelectionModel().getSelectedIndex();
            try {
                PreparedStatement pstmt = con.prepareStatement("SELECT obsah, jmeno, mesto FROM foto_doktoru JOIN doktori USING (id_doktora) JOIN adresy USING(id_adresy) JOIN posty USING(id_posty) WHERE " + "id_doktora = " + id_doktoru.get(index));
                ResultSet rs = pstmt.executeQuery();
                //pstmt.setDate(4, new Date(50, 5, 5));
                //Inserting Blob type
                if(rs.next()){ 
                    byte[] imgData = null;
                    Blob img = rs.getBlob("obsah");
                    String jm = rs.getString("jmeno");
                    String me = rs.getString("mesto");
                    labelImg.setText(jm + "\n" + me);
                    imgData = img.getBytes(1,(int)img.length());
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new ByteArrayInputStream(imgData));
                        Image i = SwingFXUtils.toFXImage(image, null);
                        iwDoktor.setImage(i);
                    } catch (IOException ex) {
                        zobrazErrorDialog("Error !", "Obrázek se nepodarilo načíst");
                    }
                }else{ 
                    iwDoktor.setImage(new Image(getClass().getResourceAsStream("man.jpg")));
                    labelImg.setText("");
                }
            } catch (SQLException ex) {
                zobrazErrorDialog("Chyba", "Chyba vlozeni obrazku");
            }
        }
        
    }
    
}
