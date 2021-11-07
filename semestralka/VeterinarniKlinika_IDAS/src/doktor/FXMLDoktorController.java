/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    }

    @FXML
    private void handleBtnOdhlasitOnAction(ActionEvent event) {
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
    
}
