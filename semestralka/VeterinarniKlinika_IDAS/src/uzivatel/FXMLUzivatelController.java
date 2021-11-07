/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzivatel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    }

    @FXML
    private void handleBtnPridatZvire(ActionEvent event) {
    }
    
}
