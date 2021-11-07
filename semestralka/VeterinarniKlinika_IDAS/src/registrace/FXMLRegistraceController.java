/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrace;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 42060
 */
public class FXMLRegistraceController implements Initializable {

    @FXML
    private Button btnRegistrovat;
    @FXML
    private TextField tfJmeno;
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleBtnRegistrovatOnAction(ActionEvent event) {
    }
    
}
