/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//token Filda360 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
package veterinarniklinika;

import java.io.IOException;
import registrace.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    PreparedStatement pstmt=null;
    ResultSet rs=null;   
    
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbRole.getItems().setAll(enumRole.values());
        cbRole.setValue(enumRole.UZIVATEL);
    }    
    @FXML
    private void btnPrihlasitOnAction(ActionEvent event) {

        try {
            switch(cbRole.getValue()){ 
                case DOKTOR:{
                    String jmeno = tfJmeno.getText();
                    String heslo = tfHeslo.getText();
                    String sql = "SELECT * FROM prihlasovaci_udaje_doktori WHERE prihlasovaci_jmeno LIKE '" + jmeno + "' AND heslo LIKE '" + heslo + "'";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    if(rs.next()){ 
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Succes !");
                        alert.setHeaderText("Přihlášení proběhlo úspěšně !");
                        alert.showAndWait();
                                   
                        try {
                            //TODO otevreni dailogu doktora
                            zobrazDialogDoktor(event);
                        } catch (IOException ex) {
                            zobrazErrorDialog("Chyba při přechodu do dialogu doktora !", ex.getMessage());
                        }
                                           
                    }else{
                        zobrazErrorDialog("Nepodařilo se přihlásit se zadaným jménem a heslem", "zkontroluj správnost jména a hesla!");
                    }
                }
                break;
                case UZIVATEL:{ 
                                        String jmeno = tfJmeno.getText();
                    String heslo = tfHeslo.getText();
                    String sql = "SELECT * FROM prihlasovaci_udaje_zakaznici WHERE prihlasovaci_jmeno LIKE '" + jmeno + "' AND heslo LIKE '" + heslo + "'";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    if(rs.next()){ 
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
                        
                    }else{
                        zobrazErrorDialog("Nepodařilo se přihlásit se zadaným jménem a heslem", "zkontroluj správnost jména a hesla!");
                    }
                }
                break;
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
}
