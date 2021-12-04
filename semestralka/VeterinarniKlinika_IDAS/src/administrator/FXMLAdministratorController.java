
package administrator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLAdministratorController implements Initializable {

    @FXML
    private TextField tfJmenoZvirete;
    @FXML
    private ComboBox<?> cbDruh;
    @FXML
    private RadioButton rBtnZapniFiltry;
    @FXML
    private Button btnMojeUdaje;
    @FXML
    private Button btnOdhlasit;
    @FXML
    private TableView<?> tableViewZakroky;
    @FXML
    private TableColumn<?, ?> zakroky_datum;
    @FXML
    private TableColumn<?, ?> zakroky_poznamka;
    @FXML
    private TableColumn<?, ?> zakroky_jmeno;
    @FXML
    private TableColumn<?, ?> zakroky_druh;
    @FXML
    private TableColumn<?, ?> zakroky_pohlavi;
    @FXML
    private TableColumn<?, ?> zakroky_datum_narozeni;
    @FXML
    private TableColumn<?, ?> zakroky_vaha;
    @FXML
    private TableColumn<?, ?> zakroky_poznamka_zvirete;
    @FXML
    private TableColumn<?, ?> zakroky_typ_operace;
    @FXML
    private TableColumn<?, ?> zakroky_delka_operace;
    @FXML
    private TableColumn<?, ?> zakroky_jmeno_lekare;
    @FXML
    private TableColumn<?, ?> zakroky_prijmeni_lekare;
    @FXML
    private TableView<?> tableViewVysetreni;
    @FXML
    private TableColumn<?, ?> vysetreni_datum;
    @FXML
    private TableColumn<?, ?> vysetreni_poznamka;
    @FXML
    private TableColumn<?, ?> vysetreni_diagnoza;
    @FXML
    private TableColumn<?, ?> vysetreni_oznaceni;
    @FXML
    private TableColumn<?, ?> vysetreni_stupen_zavaznosti;
    @FXML
    private TableColumn<?, ?> vysetreni_jmeno;
    @FXML
    private TableColumn<?, ?> vysetreni_druh;
    @FXML
    private TableColumn<?, ?> vysetreni_pohlavi;
    @FXML
    private TableColumn<?, ?> vysetreni_datum_narozeni;
    @FXML
    private TableColumn<?, ?> vysetreni_vaha;
    @FXML
    private TableColumn<?, ?> vysetreni_poznamka_zvirete;
    @FXML
    private TableColumn<?, ?> vysetreni_jmeno_lekare;
    @FXML
    private TableColumn<?, ?> vysetreni_prijmeni_lekare;
    @FXML
    private TableView<?> tableViewOdbery;
    @FXML
    private TableColumn<?, ?> odbery_datum;
    @FXML
    private TableColumn<?, ?> odbery_poznamka;
    @FXML
    private TableColumn<?, ?> odbery_jmeno;
    @FXML
    private TableColumn<?, ?> odbery_druh;
    @FXML
    private TableColumn<?, ?> odbery_pohlavi;
    @FXML
    private TableColumn<?, ?> odbery_datum_narozeni;
    @FXML
    private TableColumn<?, ?> odbery_vaha;
    @FXML
    private TableColumn<?, ?> odbery_poznamka_zvirete;
    @FXML
    private TableColumn<?, ?> odbery_jmeno_lekare;
    @FXML
    private TableColumn<?, ?> odbery_prijmeni_lekare;
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
