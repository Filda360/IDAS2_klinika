
package registrace;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


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
    @FXML
    private PasswordField tfHeslo;
    @FXML
    private TextField tfPrihlasovaciJmeno;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    //přidá nového majitele do databáze
    @FXML
    private void handleBtnRegistrovatOnAction(ActionEvent event) {
        
        
    }
    
}
