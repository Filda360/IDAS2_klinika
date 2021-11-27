
package registrace;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLRegistraceController implements Initializable {

    @FXML
    private TextField tfPrijmeni;
    @FXML
    private TextField tfUlice;
    @FXML
    private TextField tfCp;
    @FXML
    private TextField tfMesto;
    @FXML
    private TextField tfPsc;
    @FXML
    private TextField tfTelefon;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPrihlasovaciJmeno;
    @FXML
    private Button btnZaregistrovat;
    @FXML
    private TextField tfJmenoR;
    @FXML
    private PasswordField tfHesloR;
    @FXML
    private Button btnZpet;
    @FXML
    private TextField tfDatumNarozeni;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    //přidá nového majitele do databáze
    @FXML
    private void handleBtnZaregistrovatOnAction(ActionEvent event) {
        
        //TODO overeni korektnosti dat + ulozit do tabulky majitelu novyho majitele nebo vyhodit Alert
        
        try {          
            Parent root = FXMLLoader.load(getClass().getResource("/veterinarniklinika/FXMLUvodni.fxml"));

            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(scene);
            window.show();
            
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error !");
            alert.setHeaderText("Chyba při přechodu do registračního formuláře");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error !");
            alert.setHeaderText("Chyba při přechodu do registračního formuláře");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
    
}
