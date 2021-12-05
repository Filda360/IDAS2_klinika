
package administrator;

import dataTridy.Adresy;
import dataTridy.Biochemie;
import dataTridy.Diagnozy;
import dataTridy.Dodavatele;
import dataTridy.Doktori;
import dataTridy.DoktoriLogHistory;
import dataTridy.Druhy;
import dataTridy.Faktury;
import dataTridy.FotoDoktoru;
import dataTridy.KrevniObrazy;
import dataTridy.Leciva;
import dataTridy.LogTable;
import dataTridy.Majitele;
import dataTridy.MajiteleLogHistory;
import dataTridy.Objednavky;
import dataTridy.Odbery;
import dataTridy.OdberyOld;
import dataTridy.Operace;
import dataTridy.Pohlavi;
import dataTridy.Polozky;
import dataTridy.Posty;
import dataTridy.TypyPlatby;
import dataTridy.Vysetreni;
import dataTridy.VysetreniOld;
import dataTridy.Zajmy;
import dataTridy.ZakrokOld;
import dataTridy.Zakroky;
import dataTridy.Zvirata;
import static doktor.FXMLDoktorController.zakrokData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import prihlasovani.PrihlasenyUzivatel;
import veterinarniklinika.FXMLUvodniController;

public class FXMLAdministratorController implements Initializable {

    @FXML
    private ComboBox<?> comboTabulky;
    @FXML
    private Button btnMojeUdaje;
    @FXML
    private Button btnOdhlasit;
    @FXML
    private TableView<Adresy> tableViewAdresy;
    @FXML
    private TableColumn<Adresy, String> adresy_ulice;
    @FXML
    private TableColumn<Adresy, String> adresy_cislo_popisne;
    @FXML
    private TableColumn<ComboBox, String> adresy_posta;
    @FXML
    private TableView<Biochemie> tableViewBiochemie;
    @FXML
    private TableColumn<Biochemie, Double> biochemie_urea;
    @FXML
    private TableColumn<Biochemie, Double> biochemie_kreatinin;
    @FXML
    private TableColumn<Biochemie, Double> biochemie_bilirubin;
    @FXML
    private TableColumn<Biochemie, Double> biochemie_ast;
    @FXML
    private TableColumn<Biochemie, Double> biochemie_alt;
    @FXML
    private TableView<Diagnozy> tableViewDiagnozy;
    @FXML
    private TableColumn<Diagnozy, String> diagnozy_nazev;
    @FXML
    private TableColumn<Diagnozy, String> diagnozy_oznaceni;
    @FXML
    private TableColumn<Diagnozy, Integer> biochemie_stupen_zavaznosti;
    @FXML
    private TableView<Dodavatele> tableViewDodavatele;
    @FXML
    private TableColumn<Dodavatele, String> dodavatele_nazev;
    @FXML
    private TableColumn<Dodavatele, String> dodavatele_telefon;
    @FXML
    private TableColumn<Dodavatele, String> dodavatele_email;
    @FXML
    private TableColumn<Dodavatele, ComboBox> dodavatele_adresa;
    @FXML
    private TableView<Doktori> tableViewDoktori;
    @FXML
    private TableColumn<Doktori, String> doktori_jmeno;
    @FXML
    private TableColumn<Doktori, String> doktori_prijmeni;
    @FXML
    private TableColumn<Doktori, String> doktori_titul;
    @FXML
    private TableColumn<Doktori, String> doktori_delka_uvazku;
    @FXML
    private TableColumn<Doktori, String> doktori_datum_nastupu;
    @FXML
    private TableColumn<Doktori, Double> doktori_plat;
    @FXML
    private TableColumn<Doktori, String> doktori_datum_narozeni;
    @FXML
    private TableColumn<Doktori, String> doktori_telefon;
    @FXML
    private TableColumn<Doktori, String> doktori_email;
    @FXML
    private TableColumn<Doktori, String> doktori_prihlasovaci_jmeno;
    @FXML
    private TableColumn<Doktori, String> doktori_heslo;
    @FXML
    private TableColumn<Doktori, ComboBox> doktori_adresa;
    @FXML
    private TableView<DoktoriLogHistory> tableViewDoktoriLogHistory;
    @FXML
    private TableColumn<DoktoriLogHistory, String> doktori_log_datum_prihlaseni;
    @FXML
    private TableColumn<DoktoriLogHistory, ComboBox> doktori_log_doktor;
    @FXML
    private TableView<Druhy> tableViewDruhy;
    @FXML
    private TableColumn<Druhy, String> druhy_druh;
    @FXML
    private TableView<Faktury> tableViewFaktury;
    @FXML
    private TableColumn<Faktury, String> faktury_datum_vystaveni;
    @FXML
    private TableColumn<Faktury, String> faktury_datum_splatnosti;
    @FXML
    private TableColumn<Faktury, String> faktury_stav;
    @FXML
    private TableColumn<Faktury, ComboBox> faktury_typ;
    @FXML
    private TableColumn<Faktury, ComboBox> faktury_majitel;
    @FXML
    private TableView<FotoDoktoru> tableViewFotoDoktoru;
    @FXML
    private TableColumn<FotoDoktoru, String> foto_doktoru_nazev;
    @FXML
    private TableColumn<FotoDoktoru, String> foto_doktoru_typ_souboru;
    @FXML
    private TableColumn<FotoDoktoru, String> foto_doktoru_pripona;
    @FXML
    private TableColumn<FotoDoktoru, String> foto_doktoru_datum_nahrani;
    @FXML
    private TableColumn<FotoDoktoru, String> foto_doktoru_obsah;
    @FXML
    private TableColumn<FotoDoktoru, ComboBox> foto_doktoru_doktor;
    @FXML
    private TableView<KrevniObrazy> tableViewKrevniObrazy;
    @FXML
    private TableColumn<KrevniObrazy, Double> krevni_obrazy_erytrocyty;
    @FXML
    private TableColumn<KrevniObrazy, Double> krevni_obrazy_leukocyty;
    @FXML
    private TableColumn<KrevniObrazy, Double> krevni_obrazy_trombocyty;
    @FXML
    private TableColumn<KrevniObrazy, Double> krevni_obrazy_hemoglobin;
    @FXML
    private TableView<Leciva> tableViewLeciva;
    @FXML
    private TableColumn<Leciva, String> leciva_nazev;
    @FXML
    private TableColumn<Leciva, String> leciva_datum_expirace;
    @FXML
    private TableColumn<Leciva, Integer> leciva_pocet_skladem;
    @FXML
    private TableColumn<Leciva, String> leciva_popis;
    @FXML
    private TableColumn<Leciva, ComboBox> leciva_dodavatel;
    @FXML
    private TableView<LogTable> tableViewLogTable;
    @FXML
    private TableColumn<LogTable, String> log_table_tabulka;
    @FXML
    private TableColumn<LogTable, String> log_table_operace;
    @FXML
    private TableColumn<LogTable, String> log_table_cas;
    @FXML
    private TableColumn<LogTable, String> log_table_uzivatel;
    @FXML
    private TableView<Majitele> tableViewMajitele;
    @FXML
    private TableColumn<Majitele, String> majitele_jmeno;
    @FXML
    private TableColumn<Majitele, String> majitele_prijmeni;
    @FXML
    private TableColumn<Majitele, String> majitele_datum_registrace;
    @FXML
    private TableColumn<Majitele, String> majitele_datum_narozeni;
    @FXML
    private TableColumn<Majitele, String> majitele_telefon;
    @FXML
    private TableColumn<Majitele, String> majitele_email;
    @FXML
    private TableColumn<Majitele, String> majitele_prihlasovaci_jmeno;
    @FXML
    private TableColumn<Majitele, String> majitele_heslo;
    @FXML
    private TableColumn<Majitele, ComboBox> majitele_adresa;
    @FXML
    private TableView<MajiteleLogHistory> tableViewMajiteleLogHistory;
    @FXML
    private TableColumn<MajiteleLogHistory, String> majitele_log_datum_prihlaseni;
    @FXML
    private TableColumn<MajiteleLogHistory, ComboBox> majitele_log_majitel;
    @FXML
    private TableView<Objednavky> tableViewObjednavky;
    @FXML
    private TableColumn<Objednavky, String> objednavky_pricina;
    @FXML
    private TableColumn<Objednavky, String> objednavky_termin;
    @FXML
    private TableColumn<Objednavky, ComboBox> objednavky_majitel;
    @FXML
    private TableView<Odbery> tableViewOdbery;
    @FXML
    private TableColumn<Odbery, String> odbery_datum;
    @FXML
    private TableColumn<Odbery, String> odbery_poznamka;
    @FXML
    private TableColumn<Odbery, ComboBox> odbery_zvire;
    @FXML
    private TableView<Operace> tableViewOperace;
    @FXML
    private TableColumn<Operace, String> operace_nazev;
    @FXML
    private TableColumn<Operace, String> operace_oznaceni;
    @FXML
    private TableColumn<Operace, Double> operace_delka;
    @FXML
    private TableColumn<Operace, String> operace_riziko;
    @FXML
    private TableView<Pohlavi> tableViewPohlavi;
    @FXML
    private TableColumn<Pohlavi, String> pohlavi_pohlavi;
    @FXML
    private TableView<Polozky> tableViewPolozky;
    @FXML
    private TableColumn<Polozky, String> polozky_nazev;
    @FXML
    private TableColumn<Polozky, Integer> polozky_pocet;
    @FXML
    private TableColumn<Polozky, Double> polozky_cena;
    @FXML
    private TableColumn<Polozky, ComboBox> polozky_faktura;
    @FXML
    private TableView<Posty> tableViewPosty;
    @FXML
    private TableColumn<Posty, String> posty_mesto;
    @FXML
    private TableColumn<Posty, String> posty_psc;
    @FXML
    private TableView<TypyPlatby> tableViewTypyPlatby;
    @FXML
    private TableColumn<TypyPlatby, String> typy_platby_typ;
    @FXML
    private TableView<Vysetreni> tableViewVysetreni;
    @FXML
    private TableColumn<Vysetreni, String> vysetreni_datum;
    @FXML
    private TableColumn<Vysetreni, String> vysetreni_poznamka;
    @FXML
    private TableColumn<Vysetreni, ComboBox> vysetreni_diagnoza;
    @FXML
    private TableColumn<Vysetreni, ComboBox> vysetreni_zvire;
    @FXML
    private TableView<Zajmy> tableViewZajmy;
    @FXML
    private TableColumn<Zajmy, String> zajmy_zajem;
    @FXML
    private TableView<Zakroky> tableViewZakroky;
    @FXML
    private TableColumn<Zakroky, String> zakroky_datum;
    @FXML
    private TableColumn<Zakroky, String> zakroky_poznamka;
    @FXML
    private TableColumn<Zakroky, ComboBox> zakroky_zvire;
    @FXML
    private TableColumn<Zakroky, ComboBox> zakroky_operace;
    @FXML
    private TableView<Zvirata> tableViewZvirata;
    @FXML
    private TableColumn<Zvirata, String> zvirata_jmeno;
    @FXML
    private TableColumn<Zvirata, String> zvirata_datum_narozeni;
    @FXML
    private TableColumn<Zvirata, Double> zvirata_vaha;
    @FXML
    private TableColumn<Zvirata, String> zvirata_poznamka;
    @FXML
    private TableColumn<Zvirata, String> zvirata_cislo_cipu;
    @FXML
    private TableColumn<Zvirata, ComboBox> zvirata_majitel;
    @FXML
    private TableColumn<Zvirata, ComboBox> zvirata_pohlavi;
    @FXML
    private TableColumn<Zvirata, ComboBox> zvirata_druh;
    @FXML
    private TableColumn<Zvirata, ComboBox> zvirata_doktor;
    @FXML
    private ComboBox<?> cbPridatPolozku;
    @FXML
    private Button btnPridatPolozku;
    @FXML
    private Button btnVystavitFakturu;

    public static ObservableList<Adresy> adresyData = FXCollections.observableArrayList();
    public static ObservableList<Biochemie> biochemieData = FXCollections.observableArrayList();
    public static ObservableList<Diagnozy> diagnozyData = FXCollections.observableArrayList();
    public static ObservableList<Dodavatele> dodavateleData = FXCollections.observableArrayList();
    public static ObservableList<Doktori> doktoriData = FXCollections.observableArrayList();
    public static ObservableList<DoktoriLogHistory> doktoriLogHistoryData = FXCollections.observableArrayList();
    public static ObservableList<Druhy> druhyData = FXCollections.observableArrayList();
    public static ObservableList<Faktury> fakturyData = FXCollections.observableArrayList();
    public static ObservableList<FotoDoktoru> fotoDoktoruData = FXCollections.observableArrayList();
    public static ObservableList<KrevniObrazy> krevniObrazyData = FXCollections.observableArrayList();
    public static ObservableList<Leciva> lecivaData = FXCollections.observableArrayList();
    public static ObservableList<LogTable> logTableData = FXCollections.observableArrayList();
    public static ObservableList<Majitele> majiteleData = FXCollections.observableArrayList();
    public static ObservableList<MajiteleLogHistory> majiteleLogHistoryData = FXCollections.observableArrayList();
    public static ObservableList<Objednavky> objednavkyData = FXCollections.observableArrayList();
    public static ObservableList<Odbery> odberyData = FXCollections.observableArrayList();
    public static ObservableList<Operace> operaceData = FXCollections.observableArrayList();
    public static ObservableList<Pohlavi> pohlaviData = FXCollections.observableArrayList();
    public static ObservableList<Polozky> polozkyData = FXCollections.observableArrayList();
    public static ObservableList<Posty> postyData = FXCollections.observableArrayList();
    public static ObservableList<TypyPlatby> typyPlatbyData = FXCollections.observableArrayList();
    public static ObservableList<Vysetreni> vysetreniData = FXCollections.observableArrayList();
    public static ObservableList<Zajmy> zajmyData = FXCollections.observableArrayList();
    public static ObservableList<Zakroky> zakrokyData = FXCollections.observableArrayList();
    public static ObservableList<Zvirata> zvirataData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableViewAdresy.setItems(adresyData);
        adresy_ulice.setCellValueFactory(new PropertyValueFactory("ulice"));
        adresy_cislo_popisne.setCellValueFactory(new PropertyValueFactory("cisloPopisne"));
        
        tableViewZakroky.setEditable(true);
        adresy_ulice.setCellFactory(TextFieldTableCell.forTableColumn());
        adresy_cislo_popisne.setCellFactory(TextFieldTableCell.forTableColumn());
    }    

    @FXML
    private void button_obnovit(ActionEvent event) {
        obnovit();
    }
    private void obnovit(){
    
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
