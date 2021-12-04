
package veterinarniklinika;

import java.io.IOException;
import registrace.*;
import dataTridy.Doktor;
import dataTridy.PrihlasenyUzivatel;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.Date;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author 42060
 */
public class FXMLUvodniController implements Initializable {
    
    private CallableStatement cst=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;   
    private static PrihlasenyUzivatel prihlasenyUzivatel = null;
    
    //Prvky uvodní prihlasovaci obrazovky
    @FXML
    private TextField tfJmeno;
    @FXML
    private TextField tfHeslo;
    @FXML
    private ComboBox<enumRole> cbRole;
    @FXML
    private Button btnPrihlasit;
    @FXML
    private Button btnRegistrovat;
    @FXML
    private Label labelInfo;
    @FXML
    private Button btnNeprihlaseny;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbRole.getItems().setAll(enumRole.values());
        cbRole.setValue(enumRole.UZIVATEL);
    }    
    @FXML
    private void btnPrihlasitOnAction(ActionEvent event) {
        int idPrihlasenehoUzivatele;
        try {
            switch(cbRole.getValue()){ 
                case DOKTOR:{
                    String heslo = tfHeslo.getText();
                    String hashHesla = "";
                    try {
                        hashHesla = Bezpecnost.dejHash(heslo.getBytes());
                    } catch (Exception ex) {
                        zobrazErrorDialog("Chyba při hashování hesla !", ex.getMessage());
                    }
                    
                    cst = VeterinarniKlinika.con.prepareCall("{CALL ?:=prihlasdoktora(?,?)}");
                    cst.registerOutParameter(1, Types.NUMERIC);
                    cst.setString(2, tfJmeno.getText());
                    cst.setString(3, hashHesla);
                    
                    try{ 
                        cst.executeUpdate();
                        int id = cst.getInt(1);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Succes !");
                        alert.setHeaderText("Přihlášení proběhlo úspěšně !");
                        alert.showAndWait();
                        
                        try {
                            zobrazDialogDoktor(event);
                        } catch (IOException ex) {
                            zobrazErrorDialog("Chyba při přechodu do dialogu uzivatele !", ex.getMessage());
                        }
                    }catch(Exception e){ 
                        zobrazErrorDialog("Nepodařilo se přihlásit se zadaným jménem a heslem", "zkontroluj správnost jména a hesla!");
                    }
                }
                break;
                case UZIVATEL:{ 
                    String heslo = tfHeslo.getText();
                    String hashHesla = "";
                    try {
                        hashHesla = Bezpecnost.dejHash(heslo.getBytes());
                    } catch (Exception ex) {
                        zobrazErrorDialog("Chyba při hashování hesla !", ex.getMessage());
                    }
                    
                    cst = VeterinarniKlinika.con.prepareCall("{CALL ?:=prihlasmajitele(?,?)}");
                    cst.registerOutParameter(1, Types.NUMERIC);
                    cst.setString(2, tfJmeno.getText());
                    cst.setString(3, hashHesla);

                    try{ 
                        cst.executeUpdate();
                        int id = cst.getInt(1);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Succes !");
                        alert.setHeaderText("Přihlášení proběhlo úspěšně !");
                        alert.showAndWait();
                        
                        try {
                            //TODO otevreni dailogu prihlaseneho uzivatele
                            zobrazDialogUzivatel(event);
                        } catch (IOException ex) {
                            zobrazErrorDialog("Chyba při přechodu do dialogu uzivatele !", ex.getMessage());
                        }
                    }catch(Exception e){ 
                        zobrazErrorDialog("Nepodařilo se přihlásit se zadaným jménem a heslem", "zkontroluj správnost jména a hesla!");
                    }
                }
                break;
                case ADMIN:{ 
                    
                }
            }

        } catch (SQLException ex) {
            zobrazErrorDialog(ex.getSQLState(), ex.getMessage());
        }

    }
    @FXML
    private void handleBtnRegistraceOnAction(ActionEvent event) {
        try {    
            zobrazDialogRegistrace(event);         
        } catch (IOException ex) {
            zobrazErrorDialog("Chyba při přechodu do dialogu registrace !", ex.getMessage());
        }
    }
    @FXML
    private void handleBtnNeprihlasenyOnAction(ActionEvent event) throws IOException {
        try {    
            zobrazDialogNeprihlaseny(event);         
        } catch (IOException ex) {
            zobrazErrorDialog("Chyba při přechodu do dialogu nepřihlášeného uživatele !", ex.getMessage());
        }
    }
    
    private void zobrazDialogNeprihlaseny(ActionEvent event) throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("/uzivatelNeprihlaseny/FXMLNeprihlasenyUzivatel.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    private void zobrazDialogDoktor(ActionEvent event) throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("/doktor/FXMLDoktor.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    private void zobrazDialogRegistrace(ActionEvent event) throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("/registrace/FXMLRegistrace.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    private void zobrazDialogUzivatel(ActionEvent event) throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("/uzivatel/FXMLUzivatel.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    private void zobrazErrorDialog(String headText, String content){ 
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText(headText);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void nactiPrihlasenehoDoktora(int id) throws SQLException{ 
        Doktor prihlasenyDoktor;
        String sql = "SELECT * FROM doktori_udaje WHERE id_doktora = "+ id + "";
        pstmt = VeterinarniKlinika.con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if(rs.next()){ 
            int id_doktora = rs.getInt("ID_DOKTORA");
            String jmeno = rs.getString("JMENO");
            String prijmeni = rs.getString("PRIJMENI");
            String titul = rs.getString("TITUL");
            Date datumNarozeni = rs.getDate("DATUM_NAROZENI");
            String telefon = rs.getString("TELEFON");
            String email = rs.getString("EMAIL");
            String delkaUvazku = rs.getString("DELKA_UVAZKU");
            int plat = rs.getInt("PLAT");
            Date datumNastupu = rs.getDate("DATUM_NASTUPU");
            String ulice = rs.getString("ULICE");
            String cisloPopisne = rs.getString("CISLO_POPISNE");
            String mesto = rs.getString("MESTO");
            int psc = rs.getInt("PSC");
            prihlasenyDoktor = new Doktor(id_doktora, titul, delkaUvazku, datumNastupu, plat, jmeno, prijmeni, datumNarozeni, telefon, email, ulice, cisloPopisne, mesto, psc); 
            prihlasenyUzivatel = prihlasenyDoktor;
        }     
    }
    
    public static void odhlasUzivatele(){ 
        prihlasenyUzivatel = null;
    }
    
    public static PrihlasenyUzivatel dejPrihlasenehoUzivatele(){ 
        return prihlasenyUzivatel;
    }

}
