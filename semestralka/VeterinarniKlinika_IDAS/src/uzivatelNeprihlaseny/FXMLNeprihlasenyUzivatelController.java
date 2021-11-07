/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzivatelNeprihlaseny;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author 42060
 */
public class FXMLNeprihlasenyUzivatelController implements Initializable {

    @FXML
    private TextArea tAreaZprava;
    @FXML
    private Button btnOdeslat;
    @FXML
    private ListView<?> listViewDoktori;
    @FXML
    private Button btnZpet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBtnOdeslatOnAction(ActionEvent event) {
    }

    @FXML
    private void handleBtnZpetOnAction(ActionEvent event) {
    }
    
}
