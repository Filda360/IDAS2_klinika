/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktor;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import veterinarniklinika.FXMLUvodniController;

/**
 * FXML Controller class
 *
 * @author 42060
 */
public class FXMLDoktorController implements Initializable {

    @FXML
    private TextField tfJmenoZvirete;
    @FXML
    private ComboBox<?> cbDruh;
    @FXML
    private Button btnVyhledat;
    @FXML
    private Button btnMojeUdaje;
    @FXML
    private Button btnOdhlasit;
    @FXML
    private Button btnZakroky;
    @FXML
    private Button btnOdbery;
    @FXML
    private Button btnVysetreni;
    @FXML
    private ComboBox<?> cbPridatPolozku;
    @FXML
    private Button btnPridatPolozku;
    @FXML
    private Button btnVystavitFakturu;
    @FXML
    private TableView<?> tableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBtnVyhledatOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnMojeUdajeOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Moje údaje !");
        alert.setHeaderText(FXMLUvodniController.dejPrihlasenehoUzivatele().toString());
        alert.showAndWait();
    }

    @FXML
    private void handleBtnOdhlasitOnAction(ActionEvent event) {
        try {
            //odhlášení přihlášeného uživatele
            FXMLUvodniController.odhlasUzivatele();
            //přechod zpět na úvodní dialog
            zobrazDialogUvodni(event);
        } catch (IOException ex) {
            zobrazErrorDialog("Chyba odhlášení uživatele !", ex.getMessage());
        }
    }

    @FXML
    private void handleBtnZakrokyOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnOdberyOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnVysetreniOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnVystavitFakturuOnAction(ActionEvent event) {
    }
    
    private void zobrazDialogUvodni(ActionEvent event) throws IOException{ 
        Parent root = FXMLLoader.load(getClass().getResource("/veterinarniklinika/FXMLUvodni.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    private void zobrazErrorDialog(String headText, String content){ 
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText(headText);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
