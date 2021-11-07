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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 42060
 */
public class FXMLUvodniController implements Initializable {
    
    PreparedStatement pstmt=null;
    ResultSet rs=null;   
    
    @FXML
    private TextField tfJmeno;
    @FXML
    private Button btnPrihlasit;
    @FXML
    private Button btnRegistrovat;
    @FXML
    private TextField tfHeslo;
    @FXML
    private Label labelInfo;
    @FXML
    private ComboBox<enumRole> cbRole;
    
    
    
    private void handleButtonAction(ActionEvent event) {

    }
    
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
                        
                        //TODO zavreni prihlasovaciho dialogu a otevreni dailogu doktora
                                           
                    }else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error !");
                        alert.setHeaderText("Nepodařilo se přihlásit se zadaným jménem a heslem");
                        alert.setContentText("zkontroluj správnost jména a hesla!");
                        alert.showAndWait();
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
                        
                        //TODO zavreni prihlasovaciho dialogu a otevreni dailogu prihlaseneho uzivatele
                        
                        
                    }else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error !");
                        alert.setHeaderText("Nepodařilo se přihlásit se zadaným jménem a heslem");
                        alert.setContentText("zkontroluj správnost jména a hesla!");
                        alert.showAndWait();
                    }
                }
                break;
            }

        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Chyba SQL");
            alert.setHeaderText(ex.getSQLState());
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    private void handleBtnRegistraceOnAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/registrace/FXMLRegistrace.fxml"));
            Scene scene = new Scene(root);
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error !");
            alert.setHeaderText("Nepodařilo se načíst dialog pro přihlášení");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
    
    
}
