/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzivatel;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import veterinarniklinika.FXMLUvodniController;

/**
 * FXML Controller class
 *
 * @author 42060
 */
public class FXMLUzivatelController implements Initializable {

    @FXML
    private ComboBox<?> cbVyberZvirete;
    @FXML
    private Button btnMojeUdaje;
    @FXML
    private Button btnMojeFaktury;
    @FXML
    private Button btnMojeRezervace;
    @FXML
    private Button btnPridatRezervaci;
    @FXML
    private Button btnOdhlasit;
    @FXML
    private Label labelJmeno;
    @FXML
    private Label labelPohlavi;
    @FXML
    private Label labelDruh;
    @FXML
    private Label labelVaha;
    @FXML
    private Label labelCisloCipu;
    @FXML
    private Label labelDatumNarozeni;
    @FXML
    private Label labelPoznamka;
    @FXML
    private Button btnPridatZvire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCbVyberZvireOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnMojeUdajeOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Moje údaje !");
        alert.setHeaderText(FXMLUvodniController.dejPrihlasenehoUzivatele().toString());
        alert.showAndWait();
    }

    @FXML
    private void handleBtnMojeFakturyOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnMojeRezervaceOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnPridatrezervaciOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnOdhlasit(ActionEvent event) {
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
    private void handleBtnPridatZvire(ActionEvent event) {
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
