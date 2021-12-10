package doktor;

import dataTridy.Administratori;
import dataTridy.Adresy;
import dataTridy.Biochemie;
import dataTridy.Diagnozy;
import dataTridy.Dodavatele;
import dataTridy.Doktori;
import dataTridy.Druhy;
import dataTridy.Faktury;
import dataTridy.FotoDoktoru;
import dataTridy.KrevniObrazy;
import dataTridy.Leciva;
import dataTridy.LogTable;
import dataTridy.Majitele;
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
import dataTridy.ZakrokOld;
import dataTridy.Zakroky;
import dataTridy.Zpravy;
import dataTridy.Zvirata;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import static doktor.FXMLDoktorController.zakrokData;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import prihlasovani.PrihlasenyUzivatel;
import utils.ComboBoxy;
import utils.enumDoktoriTabulky;
import utils.enumTabulky;
import utils.enumUzivatel;
import veterinarniklinika.Bezpecnost;
import veterinarniklinika.FXMLUvodniController;
import veterinarniklinika.VeterinarniKlinika;
import static veterinarniklinika.VeterinarniKlinika.con;

public class FXMLDoktorController implements Initializable {

    @FXML
    private ComboBox<enumDoktoriTabulky> comboTabulky;
    @FXML
    private Button btnMojeUdaje;
    @FXML
    private Button btnOdhlasit;
    
    private ComboBox<enumUzivatel> comboTypUzivatele;
    @FXML
    private TableView<Administratori> tableViewAdministratori;
    @FXML
    private TableColumn<Administratori, String> administratori_jmeno;
    @FXML
    private TableColumn<Administratori, String> administratori_prijmeni;
    @FXML
    private TableColumn<Administratori, String> administratori_datum_narozeni;
    @FXML
    private TableColumn<Administratori, String> administratori_telefon;
    @FXML
    private TableColumn<Administratori, String> administratori_email;
    @FXML
    private TableColumn<Administratori, String> administratori_prihlasovaci_jmeno;
   // private TableColumn<Administratori, String> administratori_heslo;
    @FXML
    private TableView<Adresy> tableViewAdresy;
    @FXML
    private TableColumn<Adresy, String> adresy_ulice;
    @FXML
    private TableColumn<Adresy, String> adresy_cislo_popisne;
    @FXML
    private TableColumn<Adresy, ComboBox> adresy_posta;
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
    private TableColumn<Diagnozy, Integer> diagnozy_stupen_zavaznosti;
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
    //private TableColumn<Doktori, Double> doktori_plat;
    @FXML
    private TableColumn<Doktori, String> doktori_datum_narozeni;
    @FXML
    private TableColumn<Doktori, String> doktori_telefon;
    @FXML
    private TableColumn<Doktori, String> doktori_email;
    @FXML
    private TableColumn<Doktori, String> doktori_prihlasovaci_jmeno;
    //private TableColumn<Doktori, String> doktori_heslo;
    @FXML
    private TableColumn<Doktori, ComboBox> doktori_adresa;
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
    private TableColumn<LogTable, Integer> log_table_typ_uzivatele;
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
    //private TableColumn<Majitele, String> majitele_heslo;
    @FXML
    private TableColumn<Majitele, ComboBox> majitele_adresa;
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
    private TableColumn<Polozky, Integer> polozky_cena;
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
    private TableView<Zpravy> tableViewZpravy;
    @FXML
    private TableColumn<Zpravy, String> zpravy_prijemce;
    @FXML
    private TableColumn<Zpravy, String> zpravy_odesilatel;
    @FXML
    private TableColumn<Zpravy, String> zpravy_text;
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
    private Button btnVystavitFakturu;

    public static ObservableList<Administratori> administratoriData = FXCollections.observableArrayList();
    public static ObservableList<Adresy> adresyData = FXCollections.observableArrayList();
    public static ObservableList<Biochemie> biochemieData = FXCollections.observableArrayList();
    public static ObservableList<Diagnozy> diagnozyData = FXCollections.observableArrayList();
    public static ObservableList<Dodavatele> dodavateleData = FXCollections.observableArrayList();
    public static ObservableList<Doktori> doktoriData = FXCollections.observableArrayList();
    public static ObservableList<Druhy> druhyData = FXCollections.observableArrayList();
    public static ObservableList<Faktury> fakturyData = FXCollections.observableArrayList();
    public static ObservableList<FotoDoktoru> fotoDoktoruData = FXCollections.observableArrayList();
    public static ObservableList<KrevniObrazy> krevniObrazyData = FXCollections.observableArrayList();
    public static ObservableList<Leciva> lecivaData = FXCollections.observableArrayList();
    public static ObservableList<LogTable> logTableData = FXCollections.observableArrayList();
    public static ObservableList<Majitele> majiteleData = FXCollections.observableArrayList();
    public static ObservableList<Objednavky> objednavkyData = FXCollections.observableArrayList();
    public static ObservableList<Odbery> odberyData = FXCollections.observableArrayList();
    public static ObservableList<Operace> operaceData = FXCollections.observableArrayList();
    public static ObservableList<Pohlavi> pohlaviData = FXCollections.observableArrayList();
    public static ObservableList<Polozky> polozkyData = FXCollections.observableArrayList();
    public static ObservableList<Posty> postyData = FXCollections.observableArrayList();
    public static ObservableList<TypyPlatby> typyPlatbyData = FXCollections.observableArrayList();
    public static ObservableList<Vysetreni> vysetreniData = FXCollections.observableArrayList();
    public static ObservableList<Zakroky> zakrokyData = FXCollections.observableArrayList();
    public ObservableList<Zpravy> zpravyData = FXCollections.observableArrayList();
    public static ObservableList<Zvirata> zvirataData = FXCollections.observableArrayList();
    //comboboxy 
    public static ObservableList<Posty> cbPostyData = FXCollections.observableArrayList();
    public static ObservableList<Adresy> cbAdresyData = FXCollections.observableArrayList();
    public static ObservableList<Majitele> cbMajiteleData = FXCollections.observableArrayList();
    public static ObservableList<TypyPlatby> cbTypyPlatbyData = FXCollections.observableArrayList();
    public static ObservableList<Doktori> cbDoktoriData = FXCollections.observableArrayList();
    public static ObservableList<Dodavatele> cbDodavateleData = FXCollections.observableArrayList();
    public static ObservableList<Zvirata> cbZvirataData = FXCollections.observableArrayList();
    public static ObservableList<Faktury> cbFakturyData = FXCollections.observableArrayList();
    public static ObservableList<Diagnozy> cbDiagnozyData = FXCollections.observableArrayList();
    public static ObservableList<Operace> cbOperaceData = FXCollections.observableArrayList();
    public static ObservableList<Pohlavi> cbPohlaviData = FXCollections.observableArrayList();
    public static ObservableList<Druhy> cbDruhyData = FXCollections.observableArrayList();

    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @FXML
    private Button btnPridejFotku;
    @FXML
    private CheckBox chBDatum;
    @FXML
    private DatePicker dpDatum;
    @FXML
    private TextField tfFiltr;
    @FXML
    private Button btnPridat;
    @FXML
    private Button btnOdebrat;
    @FXML
    private Button btnUloz;
    @FXML
    private Button btnNapsatZpravu;
    @FXML
    private CheckBox chBFiltr;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboTabulky.setItems(FXCollections.observableArrayList(enumDoktoriTabulky.values()));
        comboTabulky.getSelectionModel().selectFirst();

        //comboTypUzivatele.setItems(FXCollections.observableArrayList(enumUzivatel.values()));
        //comboTypUzivatele.getSelectionModel().select(enumUzivatel.Doktor);

        tableViewAdministratori.setItems(administratoriData);
        administratori_jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        administratori_prijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        administratori_datum_narozeni.setCellValueFactory(new PropertyValueFactory<>("datumNarozeni"));
        administratori_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        administratori_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        administratori_prihlasovaci_jmeno.setCellValueFactory(new PropertyValueFactory<>("prihlasovaciJmeno"));
        //administratori_heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
        //administratori_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewAdministratori.setEditable(true);
        
        administratori_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_prijmeni.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_email.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_prihlasovaci_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        //administratori_heslo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tableViewAdresy.setItems(adresyData);
        adresy_ulice.setCellValueFactory(new PropertyValueFactory<>("ulice"));
        adresy_cislo_popisne.setCellValueFactory(new PropertyValueFactory<>("cisloPopisne"));
        adresy_posta.setCellValueFactory(new PropertyValueFactory<>("posty"));
        tableViewAdresy.setEditable(true);

        adresy_ulice.setCellFactory(TextFieldTableCell.forTableColumn());
        adresy_cislo_popisne.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewBiochemie.setItems(biochemieData);
        biochemie_urea.setCellValueFactory(new PropertyValueFactory<>("urea"));
        biochemie_kreatinin.setCellValueFactory(new PropertyValueFactory<>("kreatinin"));
        biochemie_bilirubin.setCellValueFactory(new PropertyValueFactory<>("bilirubin"));
        biochemie_ast.setCellValueFactory(new PropertyValueFactory<>("ast"));
        biochemie_alt.setCellValueFactory(new PropertyValueFactory<>("alt"));
        tableViewBiochemie.setEditable(true);

        biochemie_urea.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        biochemie_kreatinin.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        biochemie_bilirubin.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        biochemie_ast.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        biochemie_alt.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        tableViewDiagnozy.setItems(diagnozyData);
        diagnozy_nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        diagnozy_oznaceni.setCellValueFactory(new PropertyValueFactory<>("oznaceni"));
        diagnozy_stupen_zavaznosti.setCellValueFactory(new PropertyValueFactory<>("stupenZavaznosti"));
        tableViewDiagnozy.setEditable(true);

        diagnozy_nazev.setCellFactory(TextFieldTableCell.forTableColumn());
        diagnozy_oznaceni.setCellFactory(TextFieldTableCell.forTableColumn());
        diagnozy_stupen_zavaznosti.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tableViewDodavatele.setItems(dodavateleData);
        dodavatele_nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        dodavatele_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        dodavatele_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        dodavatele_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewDodavatele.setEditable(true);

        dodavatele_nazev.setCellFactory(TextFieldTableCell.forTableColumn());
        dodavatele_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        dodavatele_email.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewDoktori.setItems(doktoriData);
        doktori_titul.setCellValueFactory(new PropertyValueFactory<>("titul"));
        doktori_delka_uvazku.setCellValueFactory(new PropertyValueFactory<>("delkaUvazku"));
        doktori_datum_nastupu.setCellValueFactory(new PropertyValueFactory<>("datumNastupu"));
        //doktori_plat.setCellValueFactory(new PropertyValueFactory<>("plat"));
        doktori_jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        doktori_prijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        doktori_datum_narozeni.setCellValueFactory(new PropertyValueFactory<>("datumNarozeni"));
        doktori_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        doktori_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        //doktori_heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
        doktori_prihlasovaci_jmeno.setCellValueFactory(new PropertyValueFactory<>("prihlasovaciJmeno"));
        doktori_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewDoktori.setEditable(true);

        doktori_titul.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_delka_uvazku.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_datum_nastupu.setCellFactory(TextFieldTableCell.forTableColumn());
        //doktori_plat.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        doktori_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_prijmeni.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_email.setCellFactory(TextFieldTableCell.forTableColumn());
        //doktori_heslo.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_prihlasovaci_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewDruhy.setItems(druhyData);
        druhy_druh.setCellValueFactory(new PropertyValueFactory<>("druh"));
        tableViewDruhy.setEditable(true);

        druhy_druh.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewFaktury.setItems(fakturyData);
        faktury_datum_splatnosti.setCellValueFactory(new PropertyValueFactory<>("datumSplatnosti"));
        faktury_datum_vystaveni.setCellValueFactory(new PropertyValueFactory<>("datumVystaveni"));
        faktury_stav.setCellValueFactory(new PropertyValueFactory<>("stav"));
        faktury_majitel.setCellValueFactory(new PropertyValueFactory<>("majitele"));
        faktury_typ.setCellValueFactory(new PropertyValueFactory<>("typy"));
        tableViewFaktury.setEditable(true);

        faktury_datum_splatnosti.setCellFactory(TextFieldTableCell.forTableColumn());
        faktury_datum_vystaveni.setCellFactory(TextFieldTableCell.forTableColumn());
        faktury_stav.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewFotoDoktoru.setItems(fotoDoktoruData);
        foto_doktoru_nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        foto_doktoru_typ_souboru.setCellValueFactory(new PropertyValueFactory<>("typSouboru"));
        foto_doktoru_pripona.setCellValueFactory(new PropertyValueFactory<>("pripona"));
        foto_doktoru_datum_nahrani.setCellValueFactory(new PropertyValueFactory<>("datumNahrani"));
        foto_doktoru_obsah.setCellValueFactory(new PropertyValueFactory<>("obsah"));
        foto_doktoru_doktor.setCellValueFactory(new PropertyValueFactory<>("doktori"));
        tableViewFotoDoktoru.setEditable(true);

        foto_doktoru_nazev.setCellFactory(TextFieldTableCell.forTableColumn());
        foto_doktoru_typ_souboru.setCellFactory(TextFieldTableCell.forTableColumn());
        foto_doktoru_pripona.setCellFactory(TextFieldTableCell.forTableColumn());
        foto_doktoru_datum_nahrani.setCellFactory(TextFieldTableCell.forTableColumn());
        foto_doktoru_obsah.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewKrevniObrazy.setItems(krevniObrazyData);
        krevni_obrazy_erytrocyty.setCellValueFactory(new PropertyValueFactory<>("erytrocyty"));
        krevni_obrazy_leukocyty.setCellValueFactory(new PropertyValueFactory<>("leukocyty"));
        krevni_obrazy_trombocyty.setCellValueFactory(new PropertyValueFactory<>("trombocyty"));
        krevni_obrazy_hemoglobin.setCellValueFactory(new PropertyValueFactory<>("hemoglobin"));
        tableViewKrevniObrazy.setEditable(true);

        krevni_obrazy_erytrocyty.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        krevni_obrazy_leukocyty.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        krevni_obrazy_trombocyty.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        krevni_obrazy_hemoglobin.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        tableViewLeciva.setItems(lecivaData);
        leciva_datum_expirace.setCellValueFactory(new PropertyValueFactory<>("datumExpirace"));
        leciva_dodavatel.setCellValueFactory(new PropertyValueFactory<>("dodavatele"));
        leciva_nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        leciva_pocet_skladem.setCellValueFactory(new PropertyValueFactory<>("pocetSkladem"));
        leciva_popis.setCellValueFactory(new PropertyValueFactory<>("popis"));
        tableViewLeciva.setEditable(true);

        leciva_datum_expirace.setCellFactory(TextFieldTableCell.forTableColumn());
        leciva_nazev.setCellFactory(TextFieldTableCell.forTableColumn());
        leciva_pocet_skladem.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        leciva_popis.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewLogTable.setItems(logTableData);
        log_table_tabulka.setCellValueFactory(new PropertyValueFactory<>("tabulka"));
        log_table_operace.setCellValueFactory(new PropertyValueFactory<>("operace"));
        log_table_cas.setCellValueFactory(new PropertyValueFactory<>("cas"));
        log_table_uzivatel.setCellValueFactory(new PropertyValueFactory<>("uzivatel"));
        log_table_typ_uzivatele.setCellValueFactory(new PropertyValueFactory<>("typUzivatele"));
        tableViewLogTable.setEditable(false);

        log_table_tabulka.setCellFactory(TextFieldTableCell.forTableColumn());
        log_table_operace.setCellFactory(TextFieldTableCell.forTableColumn());
        log_table_cas.setCellFactory(TextFieldTableCell.forTableColumn());
        log_table_uzivatel.setCellFactory(TextFieldTableCell.forTableColumn());
        log_table_typ_uzivatele.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tableViewMajitele.setItems(majiteleData);
        majitele_datum_registrace.setCellValueFactory(new PropertyValueFactory<>("datumRegistrace"));
        majitele_jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        majitele_prijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        majitele_datum_narozeni.setCellValueFactory(new PropertyValueFactory<>("datumNarozeni"));
        majitele_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        majitele_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        //majitele_heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
        majitele_prihlasovaci_jmeno.setCellValueFactory(new PropertyValueFactory<>("prihlasovaciJmeno"));
        majitele_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewMajitele.setEditable(true);

        majitele_datum_registrace.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_prijmeni.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_email.setCellFactory(TextFieldTableCell.forTableColumn());
        //majitele_heslo.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_prihlasovaci_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewObjednavky.setItems(objednavkyData);
        objednavky_pricina.setCellValueFactory(new PropertyValueFactory<>("pricina"));
        objednavky_termin.setCellValueFactory(new PropertyValueFactory<>("termin"));
        objednavky_majitel.setCellValueFactory(new PropertyValueFactory<>("majitele"));
        tableViewObjednavky.setEditable(true);

        objednavky_pricina.setCellFactory(TextFieldTableCell.forTableColumn());
        objednavky_termin.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewOdbery.setItems(odberyData);
        odbery_datum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        odbery_poznamka.setCellValueFactory(new PropertyValueFactory<>("poznamka"));
        odbery_zvire.setCellValueFactory(new PropertyValueFactory<>("zvirata"));
        tableViewOdbery.setEditable(true);

        odbery_datum.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewOperace.setItems(operaceData);
        operace_nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        operace_oznaceni.setCellValueFactory(new PropertyValueFactory<>("oznaceni"));
        operace_delka.setCellValueFactory(new PropertyValueFactory<>("delka"));
        operace_riziko.setCellValueFactory(new PropertyValueFactory<>("riziko"));
        tableViewOperace.setEditable(true);

        operace_nazev.setCellFactory(TextFieldTableCell.forTableColumn());
        operace_oznaceni.setCellFactory(TextFieldTableCell.forTableColumn());
        operace_delka.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        operace_riziko.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewPohlavi.setItems(pohlaviData);
        pohlavi_pohlavi.setCellValueFactory(new PropertyValueFactory<>("pohlavi"));
        tableViewPohlavi.setEditable(true);

        pohlavi_pohlavi.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewPolozky.setItems(polozkyData);
        polozky_nazev.setCellValueFactory(new PropertyValueFactory<>("nazev"));
        polozky_pocet.setCellValueFactory(new PropertyValueFactory<>("pocet"));
        polozky_cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        polozky_faktura.setCellValueFactory(new PropertyValueFactory<>("faktury"));
        tableViewPolozky.setEditable(true);

        polozky_nazev.setCellFactory(TextFieldTableCell.forTableColumn());
        polozky_pocet.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        polozky_cena.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tableViewPosty.setItems(postyData);
        posty_mesto.setCellValueFactory(new PropertyValueFactory<>("mesto"));
        posty_psc.setCellValueFactory(new PropertyValueFactory<>("PSC"));
        tableViewPosty.setEditable(true);

        posty_mesto.setCellFactory(TextFieldTableCell.forTableColumn());
        posty_psc.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewTypyPlatby.setItems(typyPlatbyData);
        typy_platby_typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
        tableViewTypyPlatby.setEditable(true);

        typy_platby_typ.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewVysetreni.setItems(vysetreniData);
        vysetreni_datum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        vysetreni_poznamka.setCellValueFactory(new PropertyValueFactory<>("poznamka"));
        vysetreni_diagnoza.setCellValueFactory(new PropertyValueFactory<>("diagnozy"));
        vysetreni_zvire.setCellValueFactory(new PropertyValueFactory<>("zvirata"));
        tableViewVysetreni.setEditable(true);

        vysetreni_datum.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());

        tableViewZakroky.setItems(zakrokyData);
        zakroky_datum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        zakroky_poznamka.setCellValueFactory(new PropertyValueFactory<>("poznamka"));
        zakroky_zvire.setCellValueFactory(new PropertyValueFactory<>("zvirata"));
        zakroky_operace.setCellValueFactory(new PropertyValueFactory<>("operace"));
        tableViewZakroky.setEditable(true);

        zakroky_datum.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tableViewZvirata.setItems(zvirataData);
        zvirata_jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        zvirata_datum_narozeni.setCellValueFactory(new PropertyValueFactory<>("datumNarozeni"));
        zvirata_vaha.setCellValueFactory(new PropertyValueFactory<>("vaha"));
        zvirata_poznamka.setCellValueFactory(new PropertyValueFactory<>("poznamka"));
        zvirata_cislo_cipu.setCellValueFactory(new PropertyValueFactory<>("cisloCipu"));
        zvirata_majitel.setCellValueFactory(new PropertyValueFactory<>("majitele"));
        zvirata_pohlavi.setCellValueFactory(new PropertyValueFactory<>("pohlavi"));
        zvirata_druh.setCellValueFactory(new PropertyValueFactory<>("druhy"));
        zvirata_doktor.setCellValueFactory(new PropertyValueFactory<>("doktori"));
        tableViewZvirata.setEditable(true);
        
        tableViewZpravy.setItems(zpravyData);
        zpravy_prijemce.setCellValueFactory(new PropertyValueFactory<>("prijemce"));
        zpravy_odesilatel.setCellValueFactory(new PropertyValueFactory<>("odesilatel"));
        zpravy_text.setCellValueFactory(new PropertyValueFactory<>("text"));
        tableViewZakroky.setEditable(false);

        zpravy_prijemce.setCellFactory(TextFieldTableCell.forTableColumn());
        zpravy_odesilatel.setCellFactory(TextFieldTableCell.forTableColumn());
        zpravy_text.setCellFactory(TextFieldTableCell.forTableColumn());

        zvirata_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        zvirata_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        zvirata_vaha.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        zvirata_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());
        zvirata_cislo_cipu.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    private void button_obnovit(ActionEvent event) throws SQLException {
        obnovit();
    }

    private void obnovit() throws SQLException {

        String sql;
        switch (comboTabulky.getValue()) {
            case Administratori:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(false);
                btnOdebrat.setVisible(false);
                btnUloz.setVisible(false);
                btnNapsatZpravu.setVisible(true);
                
                tableViewAdministratori.setVisible(true);
                tableViewAdministratori.setEditable(false);
                
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Adresy> cbAdresyData = FXCollections.observableArrayList();
                administratoriData.clear();
                cbAdresyData.clear();
                sql = "SELECT * FROM PO_ADRESY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyData.add(ad);
                }

                sql = "SELECT * FROM PO_ADMINISTRATORI";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Adresy> cbAdresy = new ComboBox<Adresy>();
                    cbAdresy.setItems(cbAdresyData);
                    Administratori ad = new Administratori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getDate(4).toString(), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), cbAdresy);
                    for (Adresy adresa : cbAdresyData) {
                        if (adresa.getIdAdresy() == ad.getIdAdresy()) {
                            cbAdresy.getSelectionModel().select(adresa);
                            cbAdresy.setEditable(false);
                            break;
                        }
                    }
                    administratoriData.add(ad);
                }
                tableViewAdministratori.refresh();
                break;
             case Adresy:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(false);
                btnOdebrat.setVisible(false);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                 
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(true);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Posty> cbPostyData = FXCollections.observableArrayList();
                adresyData.clear();
                cbPostyData.clear();
                sql = "SELECT * FROM PO_POSTY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Posty ad = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                    cbPostyData.add(ad);
                }
                sql = "SELECT * FROM PO_ADRESY WHERE id_adresy = (SELECT id_adresy FROM PO_DOKTORI WHERE id_doktora=" + FXMLUvodniController.prihlasenyUzivatel.getId() + ")";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Posty> cbPosty = new ComboBox<Posty>();
                    cbPosty.setItems(cbPostyData);

                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), cbPosty);
                    for (Posty posta : cbPostyData) {
                        if (posta.getIdPosty() == ad.getIdPosty()) {
                            cbPosty.getSelectionModel().select(posta);
                            break;
                        }
                    }
                    adresyData.add(ad);
                }
                tableViewAdresy.refresh();
                break;
            case Biochemie:
                ///////////////////////////////////////////////////////////////////////
                
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(true);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);

                biochemieData.clear();
                sql = "SELECT * FROM PO_BIOCHEMIE";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Biochemie bio = new Biochemie(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                    biochemieData.add(bio);
                }
                tableViewBiochemie.refresh();
                break;
            case Diagnozy:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(true);
                
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);

                adresyData.clear();
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_DIAGNOZY WHERE nazev LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_DIAGNOZY";
                }


                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                diagnozyData.clear();
                while (rs.next()) {
                    Diagnozy di = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    diagnozyData.add(di);
                }
                tableViewDiagnozy.refresh();
                break;
            case Dodavatele:
                ///////////////////////////////////////////////////////////////////////
                
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(true);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Adresy> cbAdresyData1 = FXCollections.observableArrayList();
                dodavateleData.clear();
                cbAdresyData1.clear();
                sql = "SELECT * FROM PO_ADRESY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyData1.add(ad);
                }
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_DODAVATELE WHERE nazev LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_DODAVATELE";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Adresy> cbAdresy = new ComboBox<Adresy>();
                    cbAdresy.setItems(cbAdresyData1);
                    Dodavatele dod = new Dodavatele(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), cbAdresy);
                    for (Adresy adresa : cbAdresyData1) {
                        if (adresa.getIdAdresy() == dod.getIdAdresy()) {
                            cbAdresy.getSelectionModel().select(adresa);
                            break;
                        }
                    }

                    dodavateleData.add(dod);
                }
                tableViewDodavatele.refresh();
                break;
            case Doktori:
                ///////////////////////////////////////////////////////////////////////
                
                btnPridat.setVisible(false);
                btnOdebrat.setVisible(false);
                btnUloz.setVisible(false);
                btnNapsatZpravu.setVisible(true);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(true);
                tableViewDoktori.setEditable(false);
                
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Adresy> cbAdresyData2 = FXCollections.observableArrayList();
                ObservableList<Doktori> cbDoktoriData4 = FXCollections.observableArrayList();
                doktoriData.clear();
                cbDoktoriData4.clear();
                cbAdresyData2.clear();
                sql = "SELECT * FROM PO_ADRESY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyData2.add(ad);
                }
                ComboBox<Doktori> cbDoktori;
                cbDoktoriData4.add(new Doktori(-1,"","","",0,"","","","","",-1,"","",null,-1,null));
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_DOKTORI WHERE prijmeni LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_DOKTORI";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                    
                while (rs.next()) {
                    ComboBox<Adresy> cbAdresy = new ComboBox<Adresy>();
                    cbAdresy.setItems(cbAdresyData2);
                    
                     cbDoktori = new ComboBox<Doktori>();
                     cbDoktori.setItems(cbDoktoriData4);
                    
                    
                    Doktori dok = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getDate(4).toString(), rs.getDouble(5), rs.getString(6), rs.getString(7),
                            rs.getDate(8).toString(), rs.getString(9), rs.getString(10), rs.getInt(11),
                            rs.getString(12), rs.getString(13), cbAdresy,rs.getInt(14),cbDoktori);
                    for (Adresy adresa : cbAdresyData2) {
                        if (adresa.getIdAdresy() == dok.getIdAdresy()) {
                            cbAdresy.getSelectionModel().select(adresa);
                            cbAdresy.setDisable(true);
                            break;
                        }
                    }
                    doktoriData.add(dok);
                    cbDoktoriData4.add(dok);
                }
                for (Doktori dok1 : doktoriData) {
                    for (Doktori dok2 : doktoriData) {
                        if(dok1.getIdNadrizeneho()==dok2.getIdDoktora()){
                            dok1.getDoktori().getSelectionModel().select(dok2);
                        }  
                    }
                }
                tableViewDoktori.refresh();
                break;
            case Druhy:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(true);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);

                druhyData.clear();

                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_DRUHY WHERE druh LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_DRUHY";
                }
                
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    Druhy dr = new Druhy(rs.getInt(1), rs.getString(2));
                    druhyData.add(dr);
                }
                tableViewDruhy.refresh();
                break;
            case Faktury:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(true);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Majitele> cbMajiteleData = FXCollections.observableArrayList();
                ObservableList<TypyPlatby> cbTypyPlatbyData = FXCollections.observableArrayList();
                cbMajiteleData.clear();
                cbTypyPlatbyData.clear();
                fakturyData.clear();
                sql = "SELECT * FROM PO_MAJITELE";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3),
                            rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7),
                            rs.getInt(8), rs.getString(9), rs.getString(10), null);
                    cbMajiteleData.add(maj);
                }

                sql = "SELECT * FROM PO_TYPY_PLATBY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    TypyPlatby typ = new TypyPlatby(rs.getInt(1), rs.getString(2));
                    cbTypyPlatbyData.add(typ);
                }
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_FAKTURY WHERE ID_MAJITELE IN (SELECT id_majitele FROM PO_MAJITELE WHERE prijmeni LIKE '" + tfFiltr.getText() + "')";
                }else{ 
                    sql = "SELECT * FROM PO_FAKTURY";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Majitele> cbMajitele = new ComboBox<Majitele>();
                    cbMajitele.setItems(cbMajiteleData);
                    ComboBox<TypyPlatby> cbTypyPlatby = new ComboBox<TypyPlatby>();
                    cbTypyPlatby.setItems(cbTypyPlatbyData);
                    Faktury fak = new Faktury(rs.getInt(1), rs.getDate(2).toString(), rs.getDate(3).toString(),
                            rs.getString(4), rs.getInt(5), rs.getInt(6), cbMajitele, cbTypyPlatby);
                    for (Majitele majitel : cbMajiteleData) {
                        if (majitel.getIdMajitele() == fak.getIdMajitele()) {
                            cbMajitele.getSelectionModel().select(majitel);
                            break;
                        }
                    }
                    for (TypyPlatby typ : cbTypyPlatbyData) {
                        if (typ.getIdTypu() == fak.getIdTypu()) {
                            cbTypyPlatby.getSelectionModel().select(typ);
                            break;
                        }
                    }
                    fakturyData.add(fak);
                }
                tableViewFaktury.refresh();
                break;
            
            case KrevniObrazy:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(true);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);

                krevniObrazyData.clear();

                sql = "SELECT * FROM PO_KREVNI_OBRAZY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    KrevniObrazy data = new KrevniObrazy(rs.getInt(1), rs.getDouble(2), rs.getDouble(3),
                            rs.getDouble(4), rs.getDouble(5));

                    krevniObrazyData.add(data);
                }
                tableViewKrevniObrazy.refresh();
                break;
            case Leciva:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(true);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Dodavatele> cbDodavateleData = FXCollections.observableArrayList();
                cbDodavateleData.clear();
                lecivaData.clear();
                sql = "SELECT * FROM PO_DODAVATELE";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Dodavatele dod = new Dodavatele(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), null);
                    cbDodavateleData.add(dod);
                }
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_LECIVA WHERE nazev LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_LECIVA";
                }
                
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Dodavatele> cbDodavatele = new ComboBox<Dodavatele>();
                    cbDodavatele.setItems(cbDodavateleData);

                    Leciva lec = new Leciva(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(), rs.getInt(4), rs.getString(5), rs.getInt(6), cbDodavatele);
                    for (Dodavatele data : cbDodavateleData) {
                        if (data.getIdDodavatele() == lec.getIdDodavatele()) {
                            cbDodavatele.getSelectionModel().select(data);
                            break;
                        }
                    }

                    lecivaData.add(lec);
                }
                tableViewLeciva.refresh();
                break;
            
            case Majitele:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(false);
                btnOdebrat.setVisible(false);
                btnUloz.setVisible(false);
                btnNapsatZpravu.setVisible(true);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(true);
                tableViewMajitele.setEditable(false);
                
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Adresy> cbAdresyData3 = FXCollections.observableArrayList();
                majiteleData.clear();
                cbAdresyData3.clear();
                sql = "SELECT * FROM PO_ADRESY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyData3.add(ad);
                }
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_MAJITELE WHERE prijmeni LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_MAJITELE";
                }
                
                
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Adresy> cbAdresy = new ComboBox<Adresy>();
                    cbAdresy.setItems(cbAdresyData3);

                    Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3),
                            rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7),
                            rs.getInt(8), rs.getString(9), rs.getString(10), cbAdresy);

                    for (Adresy adresa : cbAdresyData3) {
                        if (adresa.getIdAdresy() == maj.getIdAdresy()) {
                            cbAdresy.getSelectionModel().select(adresa);
                            cbAdresy.setDisable(true);
                            break;
                        }
                    }
                    majiteleData.add(maj);
                }
                tableViewMajitele.refresh();
                break;
            case Objednavky:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(true);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Majitele> cbMajiteleData2 = FXCollections.observableArrayList();
                cbMajiteleData2.clear();
                objednavkyData.clear();
                sql = "SELECT * FROM PO_MAJITELE";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3), rs.getString(4),
                            rs.getDate(5).toString(), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), null);
                    cbMajiteleData2.add(maj);
                }
                if(chBDatum.isSelected()){ 
                    sql = "SELECT * FROM PO_OBJEDNAVKY WHERE termin = '" + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dpDatum.getValue()) + "'";
                }else{ 
                    sql = "SELECT * FROM PO_OBJEDNAVKY";
                }
                
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Majitele> cbMajitele = new ComboBox<Majitele>();
                    cbMajitele.setItems(cbMajiteleData2);

                    Objednavky obj = new Objednavky(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getInt(4), cbMajitele);

                    for (Majitele majitel : cbMajiteleData2) {
                        if (majitel.getIdMajitele() == obj.getIdMajitele()) {
                            cbMajitele.getSelectionModel().select(majitel);
                            break;
                        }
                    }

                    objednavkyData.add(obj);
                }
                tableViewObjednavky.refresh();
                break;
            case Odbery:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(true);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Zvirata> cbZvirataData = FXCollections.observableArrayList();
                odberyData.clear();
                cbZvirataData.clear();
                sql = "SELECT * FROM PO_ZVIRATA";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), null, null, null, null);
                    cbZvirataData.add(zv);
                }
                
                if(chBFiltr.isSelected()){ 
                    
                    sql = "SELECT * FROM PO_ODBERY WHERE ID_ZVIRETE IN (SELECT ID_ZVIRETE FROM PO_ZVIRATA WHERE jmeno LIKE '" + tfFiltr.getText() + "')";
                }else{ 
                    sql = "SELECT * FROM PO_ODBERY";
                }
                
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Zvirata> cbZvirata = new ComboBox<Zvirata>();
                    cbZvirata.setItems(cbZvirataData);

                    Odbery od = new Odbery(rs.getDate(1).toString(), rs.getInt(2), rs.getInt(3), rs.getString(4), cbZvirata);
                    for (Zvirata zvire : cbZvirataData) {
                        if (zvire.getIdZvirete() == od.getIdZvirete()) {
                            cbZvirata.getSelectionModel().select(zvire);
                            break;
                        }
                    }
                    odberyData.add(od);
                }
                tableViewOdbery.refresh();
                break;
            case Operace:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(true);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);

                operaceData.clear();

                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_OPERACE WHERE nazev LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_OPERACE";
                }
                
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    Operace op = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                    operaceData.add(op);
                }
                tableViewOperace.refresh();
                break;
            
            case Polozky:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(true);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Faktury> cbFakturyData = FXCollections.observableArrayList();
                polozkyData.clear();
                cbFakturyData.clear();
                sql = "SELECT * FROM PO_FAKTURY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Faktury fak = new Faktury(rs.getInt(1), rs.getDate(2).toString(), rs.getDate(3).toString(),
                            rs.getString(4), rs.getInt(5), rs.getInt(6), null, null);
                    cbFakturyData.add(fak);
                }
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_POLOZKY WHERE nazev LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_POLOZKY";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Faktury> cbFaktury = new ComboBox<Faktury>();
                    cbFaktury.setItems(cbFakturyData);

                    Polozky pol = new Polozky(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), cbFaktury);
                    for (Faktury fakt : cbFakturyData) {
                        if (fakt.getIdFaktury() == pol.getIdFaktury()) {
                            cbFaktury.getSelectionModel().select(fakt);
                            break;
                        }
                    }
                    polozkyData.add(pol);
                }
                tableViewPolozky.refresh();
                break;
            case Posty:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(true);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);

                postyData.clear();

                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_POSTY WHERE mesto LIKE'" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_POSTY";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    Posty po = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                    postyData.add(po);
                }
                tableViewPosty.refresh();
                break;
            
            case Vysetreni:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(true);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Diagnozy> cbDiagnozyData = FXCollections.observableArrayList();
                ObservableList<Zvirata> cbZvirataData2 = FXCollections.observableArrayList();
                vysetreniData.clear();
                cbDiagnozyData.clear();
                cbZvirataData2.clear();
                sql = "SELECT * FROM PO_ZVIRATA";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), null, null, null, null);
                    cbZvirataData2.add(zv);
                }
                sql = "SELECT * FROM PO_DIAGNOZY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Diagnozy di = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    cbDiagnozyData.add(di);
                }

                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_VYSETRENI WHERE ID_ZVIRETE IN (SELECT ID_ZVIRETE FROM ZVIRATA WHERE jmeno LIKE '" + tfFiltr.getText() + "')";
                }else{ 
                    sql = "SELECT * FROM PO_VYSETRENI";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Zvirata> cbZvirata = new ComboBox<Zvirata>();
                    cbZvirata.setItems(cbZvirataData2);

                    ComboBox<Diagnozy> cbDiagnozy = new ComboBox<Diagnozy>();
                    cbDiagnozy.setItems(cbDiagnozyData);

                    Vysetreni vy = new Vysetreni(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3), rs.getInt(4), rs.getInt(5), cbDiagnozy, cbZvirata);
                    for (Zvirata zvire : cbZvirataData2) {
                        if (zvire.getIdZvirete() == vy.getIdZvirete()) {
                            cbZvirata.getSelectionModel().select(zvire);
                            break;
                        }
                    }
                    for (Diagnozy diag : cbDiagnozyData) {
                        if (diag.getIdDiagnozy() == vy.getIdDiagnozy()) {
                            cbDiagnozy.getSelectionModel().select(diag);
                            break;
                        }
                    }
                    vysetreniData.add(vy);
                }
                tableViewVysetreni.refresh();
                break;
            case Zakroky:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(true);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(true);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(false);
                ObservableList<Operace> cbOperaceData = FXCollections.observableArrayList();
                ObservableList<Zvirata> cbZvirataData3 = FXCollections.observableArrayList();
                zakrokyData.clear();
                cbOperaceData.clear();
                cbZvirataData3.clear();
                sql = "SELECT * FROM PO_ZVIRATA";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), null, null, null, null);
                    cbZvirataData3.add(zv);
                }
                sql = "SELECT * FROM PO_OPERACE";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Operace op = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                    cbOperaceData.add(op);
                }

                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_ZAKROKY WHERE ID_ZVIRETE IN (SELECT ID_ZVIRETE FROM ZVIRATA WHERE jmeno LIKE '" + tfFiltr.getText() + "')";
                }else{ 
                    sql = "SELECT * FROM PO_ZAKROKY";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Zvirata> cbZvirata = new ComboBox<Zvirata>();
                    cbZvirata.setItems(cbZvirataData3);

                    ComboBox<Operace> cbOperace = new ComboBox<Operace>();
                    cbOperace.setItems(cbOperaceData);

                    Zakroky za = new Zakroky(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3), rs.getInt(4), rs.getInt(5), cbZvirata, cbOperace);
                    for (Zvirata zvire : cbZvirataData3) {
                        if (zvire.getIdZvirete() == za.getIdZvirete()) {
                            cbZvirata.getSelectionModel().select(zvire);
                            break;
                        }
                    }
                    for (Operace oper : cbOperaceData) {
                        if (oper.getIdOperace() == za.getIdOperace()) {
                            cbOperace.getSelectionModel().select(oper);
                            break;
                        }
                    }
                    zakrokyData.add(za);
                }
                tableViewZakroky.refresh();
                break;
            case Zpravy:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(false);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(false);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(true);
                tableViewZvirata.setVisible(false);
                
                zpravyData.clear();
               
                sql = "SELECT * FROM PO_ZPRAVY";
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Zpravy zpr = new Zpravy(rs.getInt(1),rs.getInt(2),"",rs.getInt(3),"",rs.getString(4),rs.getInt(5),rs.getInt(6));
                    zpravyData.add(zpr);
                }
                for(Zpravy zp :zpravyData){
                switch(zp.getTypPrijemce()){
                case 1:
                    sql = "SELECT * FROM PO_ADMINISTRATORI WHERE ID_ADMINISTRATORA = "+zp.getIdPrijemce();
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    rs.next();
                    zp.setPrijemce(rs.getString(2)+" "+rs.getString(3));
                    break;
                case 2:
                    sql = "SELECT * FROM PO_DOKTORI WHERE ID_DOKTORA = "+zp.getIdPrijemce();
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    rs.next();
                    zp.setPrijemce(rs.getString(6)+" "+rs.getString(7));
                    break;
                case 3:
                    sql = "SELECT * FROM PO_MAJITELE WHERE ID_MAJITELE = "+zp.getIdPrijemce();
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    rs.next();
                    zp.setPrijemce(rs.getString(3)+" "+rs.getString(4));
                    break;
                }
                switch(zp.getTypOdesilatele()){
                case 1:
                    sql = "SELECT * FROM PO_ADMINISTRATORI WHERE ID_ADMINISTRATORA = "+zp.getIdOdesilatele();
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    rs.next();
                    zp.setOdesilatel(rs.getString(2)+" "+rs.getString(3));
                    break;
                case 2:
                    sql = "SELECT * FROM PO_DOKTORI WHERE ID_DOKTORA = "+zp.getIdOdesilatele();
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    rs.next();
                    zp.setOdesilatel(rs.getString(6)+" "+rs.getString(7));
                    break;
                case 3:
                    sql = "SELECT * FROM PO_MAJITELE WHERE ID_MAJITELE = "+zp.getIdOdesilatele();
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    rs.next();
                    zp.setOdesilatel(rs.getString(3)+" "+rs.getString(4));
                    break;
                }
                }
                
                
                tableViewZpravy.refresh();
                
                break;
            case Zvirata:
                ///////////////////////////////////////////////////////////////////////
                btnPridat.setVisible(false);
                btnOdebrat.setVisible(true);
                btnUloz.setVisible(true);
                btnNapsatZpravu.setVisible(false);
                
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(false);
                tableViewKrevniObrazy.setVisible(false);
                tableViewLeciva.setVisible(false);
                tableViewLogTable.setVisible(false);
                tableViewMajitele.setVisible(false);
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZpravy.setVisible(false);
                tableViewZvirata.setVisible(true);
                ObservableList<Majitele> cbMajiteleData3 = FXCollections.observableArrayList();
                ObservableList<Pohlavi> cbPohlaviData = FXCollections.observableArrayList();
                ObservableList<Druhy> cbDruhyData = FXCollections.observableArrayList();
                ObservableList<Doktori> cbDoktoriData3 = FXCollections.observableArrayList();
                zvirataData.clear();
                cbMajiteleData3.clear();
                cbPohlaviData.clear();
                cbDruhyData.clear();
                cbDoktoriData3.clear();

                sql = "SELECT * FROM PO_MAJITELE";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(),
                            rs.getString(3), rs.getString(4), rs.getDate(5).toString(),
                            rs.getString(6), rs.getString(7), rs.getInt(8),
                            rs.getString(9), rs.getString(10), null);
                    cbMajiteleData3.add(maj);
                }
                sql = "SELECT * FROM PO_POHLAVI";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Pohlavi po = new Pohlavi(rs.getInt(1), rs.getString(2));
                    cbPohlaviData.add(po);
                }

                sql = "SELECT * FROM PO_DRUHY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Druhy dr = new Druhy(rs.getInt(1), rs.getString(2));
                    cbDruhyData.add(dr);
                }

                sql = "SELECT * FROM PO_DOKTORI";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Doktori dok = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getDate(4).toString(), rs.getDouble(5), rs.getString(6), rs.getString(7),
                            rs.getDate(8).toString(), rs.getString(9), rs.getString(10), rs.getInt(11),
                            rs.getString(12), rs.getString(13), null,rs.getInt(14),null);
                    cbDoktoriData3.add(dok);
                }
                
                if(chBFiltr.isSelected()){ 
                    sql = "SELECT * FROM PO_ZVIRATA WHERE jmeno LIKE '" + tfFiltr.getText() + "'";
                }else{ 
                    sql = "SELECT * FROM PO_ZVIRATA";
                }
                
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Majitele> cbMajitele = new ComboBox<Majitele>();
                    cbMajitele.setItems(cbMajiteleData3);

                    ComboBox<Pohlavi> cbPohlavi = new ComboBox<Pohlavi>();
                    cbPohlavi.setItems(cbPohlaviData);

                    ComboBox<Druhy> cbDruhy = new ComboBox<Druhy>();
                    cbDruhy.setItems(cbDruhyData);

                    ComboBox<Doktori> cbDoktori3 = new ComboBox<Doktori>();
                    cbDoktori3.setItems(cbDoktoriData3);

                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), cbMajitele, cbPohlavi, cbDruhy, cbDoktori3);

                    for (Majitele majitel : cbMajiteleData3) {
                        if (majitel.getIdMajitele() == zv.getIdMajitele()) {
                            cbMajitele.getSelectionModel().select(majitel);
                            cbMajitele.setDisable(true);
                            break;
                        }
                    }
                    for (Pohlavi poh : cbPohlaviData) {
                        if (poh.getIdPohlavi() == zv.getIdPohlavi()) {
                            cbPohlavi.getSelectionModel().select(poh);
                            break;
                        }
                    }
                    for (Druhy druh : cbDruhyData) {
                        if (druh.getIdDruhu() == zv.getIdDruhu()) {
                            cbDruhy.getSelectionModel().select(druh);
                            break;
                        }
                    }

                    for (Doktori doktor : cbDoktoriData3) {
                        if (doktor.getIdDoktora() == zv.getIdDoktora()) {
                            cbDoktori3.getSelectionModel().select(doktor);
                            break;
                        }
                    }
                    zvirataData.add(zv);
                }
                tableViewZvirata.refresh();

        }
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

    private void zobrazDialogUvodni(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/veterinarniklinika/FXMLUvodni.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    private void zobrazErrorDialog(String headText, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText(headText);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void button_pridat(ActionEvent event) throws SQLException{
String sql;
        switch (comboTabulky.getValue()) {
            case Administratori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Adresy> cbAdresyD = FXCollections.observableArrayList();
                ComboBox<Adresy> cbAdresy = new ComboBox<>(cbAdresyD);
                sql = "SELECT * FROM PO_ADRESY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyD.add(ad);
                }
                cbAdresy.getSelectionModel().selectFirst();
                Administratori ad = new Administratori(-1, "", "", "", "", "", -1, "", "", cbAdresy);
                administratoriData.add(ad);
                tableViewAdministratori.refresh();
                tableViewAdministratori.getSelectionModel().select(ad);
                break;
            case Adresy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Posty> cbPostyD = FXCollections.observableArrayList();
                ComboBox<Posty> cbPosty = new ComboBox<>(cbPostyD);
                sql = "SELECT * FROM PO_POSTY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Posty po = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                    cbPostyD.add(po);
                }
                cbPosty.getSelectionModel().selectFirst();
                Adresy adr = new Adresy(-1, "", "", -1, cbPosty);
                adresyData.add(adr);
                tableViewAdresy.refresh();
                tableViewAdresy.getSelectionModel().select(adr);
                break;
            case Biochemie:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Biochemie bio = new Biochemie(-1, 0, 0, 0, 0, 0);
                biochemieData.add(bio);
                tableViewBiochemie.refresh();
                tableViewBiochemie.getSelectionModel().select(bio);
                break;
            case Diagnozy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Diagnozy diag = new Diagnozy(-1, "", "", 0);
                diagnozyData.add(diag);
                tableViewDiagnozy.refresh();
                tableViewDiagnozy.getSelectionModel().select(diag);
                break;
            case Dodavatele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Adresy> cbAdresyD2 = FXCollections.observableArrayList();
                ComboBox<Adresy> cbAdresy2 = new ComboBox<>(cbAdresyD2);
                sql = "SELECT * FROM PO_ADRESY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Adresy ad2 = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyD2.add(ad2);
                }
                cbAdresy2.getSelectionModel().selectFirst();
                Dodavatele dod = new Dodavatele(-1, "", "", "", 0, cbAdresy2);
                dodavateleData.add(dod);
                tableViewDodavatele.refresh();
                tableViewDodavatele.getSelectionModel().select(dod);
                break;
            case Doktori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Adresy> cbAdresyD3 = FXCollections.observableArrayList();
                ComboBox<Adresy> cbAdresy3 = new ComboBox<>(cbAdresyD3);
                ObservableList<Doktori> cbDoktoriD4 = FXCollections.observableArrayList();
                ComboBox<Doktori> cbDoktori4 = new ComboBox<>(cbDoktoriD4);
                cbDoktoriD4.add(new Doktori(-1, "", "", "", 0, "", "", "", "", "", -1, "", "", null, -1, null));
                sql = "SELECT * FROM PO_ADRESY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Adresy ad3 = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyD3.add(ad3);
                }
                cbAdresy3.getSelectionModel().selectFirst();

                sql = "SELECT * FROM PO_DOKTORI";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Doktori dokt = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                            rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), null, rs.getInt(14), null);
                    cbDoktoriD4.add(dokt);
                }
                cbDoktori4.getSelectionModel().selectFirst();

                Doktori dok = new Doktori(-1, "", "", "", 0, "", "", "", "", "", 0, "", "", cbAdresy3, -1, cbDoktori4);
                doktoriData.add(dok);
                tableViewDoktori.refresh();
                tableViewDoktori.getSelectionModel().select(dok);
                break;
            case Druhy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Druhy druh = new Druhy(-1, "");
                druhyData.add(druh);
                tableViewDruhy.refresh();
                tableViewDruhy.getSelectionModel().select(druh);
                break;
            case Faktury:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Majitele> cbMajiteleD = FXCollections.observableArrayList();
                ComboBox<Majitele> cbMajitele = new ComboBox<>(cbMajiteleD);
                sql = "SELECT * FROM PO_MAJITELE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(),
                            rs.getString(3), rs.getString(4), rs.getDate(5).toString(),
                            rs.getString(6), rs.getString(7), rs.getInt(8),
                            rs.getString(9), rs.getString(10), null);
                    cbMajiteleD.add(maj);
                }
                cbMajitele.getSelectionModel().selectFirst();

                ObservableList<TypyPlatby> cbTypyPlatbyD = FXCollections.observableArrayList();
                ComboBox<TypyPlatby> cbTypyPlatby = new ComboBox<>(cbTypyPlatbyD);
                sql = "SELECT * FROM PO_TYPY_PLATBY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    TypyPlatby typ = new TypyPlatby(rs.getInt(1), rs.getString(2));
                    cbTypyPlatbyD.add(typ);
                }
                cbMajitele.getSelectionModel().selectFirst();

                Faktury fak = new Faktury(-1, "01-01-2000", "01-01-2000",
                        "", -1, -1, cbMajitele, cbTypyPlatby);
                fakturyData.add(fak);
                tableViewFaktury.refresh();
                tableViewFaktury.getSelectionModel().select(fak);
                break;

            case KrevniObrazy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                KrevniObrazy krev = new KrevniObrazy(-1, 0, 0, 0, 0);
                krevniObrazyData.add(krev);
                tableViewKrevniObrazy.refresh();
                tableViewKrevniObrazy.getSelectionModel().select(krev);
                break;
            case Leciva:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Dodavatele> cbDodavateleD = FXCollections.observableArrayList();
                ComboBox<Dodavatele> cbDodavatele = new ComboBox<>(cbDodavateleD);
                sql = "SELECT * FROM PO_DODAVATELE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Dodavatele dod1 = new Dodavatele(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), null);
                    cbDodavateleD.add(dod1);
                }
                cbDodavatele.getSelectionModel().selectFirst();
                Leciva lec = new Leciva(-1, "", "", 0, "", 0, cbDodavatele);
                lecivaData.add(lec);
                tableViewLeciva.refresh();
                tableViewLeciva.getSelectionModel().select(lec);
                break;
            case Majitele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Adresy> cbAdresyD4 = FXCollections.observableArrayList();
                ComboBox<Adresy> cbAdresy4 = new ComboBox<>(cbAdresyD4);
                sql = "SELECT * FROM PO_ADRESY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Adresy ad4 = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyD4.add(ad4);
                }
                cbAdresy4.getSelectionModel().selectFirst();
                Majitele maj = new Majitele(-1, "01-01-2000",
                        "", "", "01-01-2000",
                        "", "", -1, "", "", cbAdresy4);
                majiteleData.add(maj);
                tableViewMajitele.refresh();
                tableViewMajitele.getSelectionModel().select(maj);
                break;
            case Objednavky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Majitele> cbMajiteleD2 = FXCollections.observableArrayList();
                ComboBox<Majitele> cbMajitele2 = new ComboBox<>(cbMajiteleD2);
                sql = "SELECT * FROM PO_MAJITELE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Majitele maj2 = new Majitele(rs.getInt(1), rs.getDate(2).toString(),
                            rs.getString(3), rs.getString(4), rs.getDate(5).toString(),
                            rs.getString(6), rs.getString(7), rs.getInt(8),
                            rs.getString(9), rs.getString(10), null);
                    cbMajiteleD2.add(maj2);
                }
                cbMajitele2.getSelectionModel().selectFirst();
                Objednavky obj = new Objednavky(-1, "", "",
                        -1, cbMajitele2);
                objednavkyData.add(obj);
                tableViewObjednavky.refresh();
                tableViewObjednavky.getSelectionModel().select(obj);
                break;
            case Odbery:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Zvirata> cbZvirataD = FXCollections.observableArrayList();
                ComboBox<Zvirata> cbZvirata = new ComboBox<>(cbZvirataD);
                sql = "SELECT * FROM PO_ZVIRATA";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), null, null, null, null);
                    cbZvirataD.add(zv);
                }
                cbZvirata.getSelectionModel().selectFirst();
                Odbery od = new Odbery("01-01-2000", -1, -1, "", cbZvirata);
                odberyData.add(od);
                tableViewOdbery.refresh();
                tableViewOdbery.getSelectionModel().select(od);
                break;
            case Operace:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Operace op = new Operace(-1, "", "", 0, "");
                operaceData.add(op);
                tableViewOperace.refresh();
                tableViewOperace.getSelectionModel().select(op);
                break;

            case Polozky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Faktury> cbFakturyD = FXCollections.observableArrayList();
                ComboBox<Faktury> cbFaktury = new ComboBox<>(cbFakturyD);
                sql = "SELECT * FROM PO_FAKTURY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Faktury fakt = new Faktury(rs.getInt(1), rs.getDate(2).toString(), rs.getDate(3).toString(),
                            rs.getString(4), rs.getInt(5), rs.getInt(6), null, null);
                    cbFakturyD.add(fakt);
                }
                cbFaktury.getSelectionModel().selectFirst();
                Polozky polo = new Polozky(-1, "", 0, 0, -1, cbFaktury);
                polozkyData.add(polo);
                tableViewPolozky.refresh();
                tableViewPolozky.getSelectionModel().select(polo);
                break;
            case Posty:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                Posty post = new Posty(-1, "", "");
                postyData.add(post);
                tableViewPosty.refresh();
                tableViewPosty.getSelectionModel().select(post);
                break;
                
            case Vysetreni:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Diagnozy> cbDiagnozyD = FXCollections.observableArrayList();
                ComboBox<Diagnozy> cbDiagnozy = new ComboBox<>(cbDiagnozyD);
                sql = "SELECT * FROM PO_DIAGNOZY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Diagnozy diagn = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    cbDiagnozyD.add(diagn);
                }
                cbDiagnozy.getSelectionModel().selectFirst();

                ObservableList<Zvirata> cbZvirataD2 = FXCollections.observableArrayList();
                ComboBox<Zvirata> cbZvirata2 = new ComboBox<>(cbZvirataD2);
                sql = "SELECT * FROM PO_ZVIRATA";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), null, null, null, null);
                    cbZvirataD2.add(zv);
                }
                cbZvirata2.getSelectionModel().selectFirst();

                Vysetreni vys = new Vysetreni(-1, "01-01-2000", "",
                        -1, -1, cbDiagnozy, cbZvirata2);
                vysetreniData.add(vys);
                tableViewVysetreni.refresh();
                tableViewVysetreni.getSelectionModel().select(vys);
                break;
            case Zakroky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Operace> cbOperaceD = FXCollections.observableArrayList();
                ComboBox<Operace> cbOperace = new ComboBox<>(cbOperaceD);
                sql = "SELECT * FROM PO_OPERACE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Operace oper = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                    cbOperaceD.add(oper);
                }
                cbOperace.getSelectionModel().selectFirst();

                ObservableList<Zvirata> cbZvirataD3 = FXCollections.observableArrayList();
                ComboBox<Zvirata> cbZvirata3 = new ComboBox<>(cbZvirataD3);
                sql = "SELECT * FROM PO_ZVIRATA";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), null, null, null, null);
                    cbZvirataD3.add(zv);
                }
                cbZvirata3.getSelectionModel().selectFirst();

                Zakroky zak = new Zakroky(-1, "01-01-2000", "",
                        -1, -1, cbZvirata3, cbOperace);
                zakrokyData.add(zak);
                tableViewZakroky.refresh();
                tableViewZakroky.getSelectionModel().select(zak);
                break;
            case Zpravy:

                break;
            case Zvirata:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ObservableList<Majitele> cbMajiteleD3 = FXCollections.observableArrayList();
                ComboBox<Majitele> cbMajitele3 = new ComboBox<>(cbMajiteleD3);
                sql = "SELECT * FROM PO_MAJITELE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Majitele maj2 = new Majitele(rs.getInt(1), rs.getDate(2).toString(),
                            rs.getString(3), rs.getString(4), rs.getDate(5).toString(),
                            rs.getString(6), rs.getString(7), rs.getInt(8),
                            rs.getString(9), rs.getString(10), null);
                    cbMajiteleD3.add(maj2);
                }
                cbMajitele3.getSelectionModel().selectFirst();

                ObservableList<Pohlavi> cbPohlaviD = FXCollections.observableArrayList();
                ComboBox<Pohlavi> cbPohlavi = new ComboBox<>(cbPohlaviD);
                sql = "SELECT * FROM PO_POHLAVI";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Pohlavi poh = new Pohlavi(rs.getInt(1), rs.getString(2));
                    cbPohlaviD.add(poh);
                }
                cbPohlavi.getSelectionModel().selectFirst();

                ObservableList<Druhy> cbDruhyD = FXCollections.observableArrayList();
                ComboBox<Druhy> cbDruhy = new ComboBox<>(cbDruhyD);
                sql = "SELECT * FROM PO_DRUHY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Druhy dru = new Druhy(rs.getInt(1), rs.getString(2));
                    cbDruhyD.add(dru);
                }
                cbDruhy.getSelectionModel().selectFirst();

                ObservableList<Doktori> cbDoktoriD = FXCollections.observableArrayList();
                ComboBox<Doktori> cbDoktori = new ComboBox<>(cbDoktoriD);
                sql = "SELECT * FROM PO_DOKTORI";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Doktori dokt = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getDate(4).toString(), rs.getDouble(5), rs.getString(6), rs.getString(7),
                            rs.getDate(8).toString(), rs.getString(9), rs.getString(10), rs.getInt(11),
                            rs.getString(12), rs.getString(13), null, rs.getInt(14), null);
                    cbDoktoriD.add(dokt);
                }
                cbDoktori.getSelectionModel().selectFirst();

                Zvirata zvir = new Zvirata(-1, "", "01-01-2000", 0, "", "", -1, -1, -1, -1, cbMajitele3, cbPohlavi, cbDruhy, cbDoktori);
                zvirataData.add(zvir);
                tableViewZvirata.refresh();
                tableViewZvirata.getSelectionModel().select(zvir);
        }
    }

    @FXML
    private void button_odebrat(ActionEvent event) throws SQLException{
        CallableStatement cst = null;
        String sql;
        int idVymazat;
        switch (comboTabulky.getValue()) {
            case Administratori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Administratori> adminL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ADMINISTRATORI";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Administratori ad = new Administratori(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), null);
                        adminL.add(ad);
                    }
                    idVymazat = -1;
                    for (Administratori admin : adminL) {
                        if (admin.getIdAdministratora() == tableViewAdministratori.getSelectionModel().getSelectedItem().getIdAdministratora()) {
                            idVymazat = admin.getIdAdministratora();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ADMINISTRATORI(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    administratoriData.remove(tableViewAdministratori.getSelectionModel().getSelectedItem());
                    tableViewAdministratori.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Adresy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Adresy> adresyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ADRESY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getInt(4), null);
                        adresyL.add(ad);
                    }
                    idVymazat = -1;
                    for (Adresy datF : adresyL) {
                        if (datF.getIdAdresy() == tableViewAdresy.getSelectionModel().getSelectedItem().getIdAdresy()) {
                            idVymazat = datF.getIdAdresy();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ADRESY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    adresyData.remove(tableViewAdresy.getSelectionModel().getSelectedItem());
                    tableViewAdresy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Biochemie:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Biochemie> biochemieL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_BIOCHEMIE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Biochemie bio = new Biochemie(rs.getInt(1), rs.getDouble(2), rs.getDouble(3),
                                rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                        biochemieL.add(bio);
                    }
                    idVymazat = -1;
                    for (Biochemie datB : biochemieL) {
                        if (datB.getIdOdberu() == tableViewBiochemie.getSelectionModel().getSelectedItem().getIdOdberu()) {
                            idVymazat = datB.getIdOdberu();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_BIOCHEMIE(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    biochemieData.remove(tableViewBiochemie.getSelectionModel().getSelectedItem());
                    tableViewBiochemie.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Diagnozy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Diagnozy> diagnozyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DIAGNOZY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Diagnozy diag = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getInt(4));
                        diagnozyL.add(diag);
                    }
                    idVymazat = -1;
                    for (Diagnozy datD : diagnozyL) {
                        if (datD.getIdDiagnozy() == tableViewDiagnozy.getSelectionModel().getSelectedItem().getIdDiagnozy()) {
                            idVymazat = datD.getIdDiagnozy();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_DIAGNOZY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    diagnozyData.remove(tableViewDiagnozy.getSelectionModel().getSelectedItem());
                    tableViewDiagnozy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Dodavatele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Dodavatele> dodavateleL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DODAVATELE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Dodavatele doda = new Dodavatele(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), null);
                        dodavateleL.add(doda);
                    }
                    idVymazat = -1;
                    for (Dodavatele datD : dodavateleL) {
                        if (datD.getIdDodavatele() == tableViewDodavatele.getSelectionModel().getSelectedItem().getIdDodavatele()) {
                            idVymazat = datD.getIdDodavatele();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_DODAVATELE(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    dodavateleData.remove(tableViewDodavatele.getSelectionModel().getSelectedItem());
                    tableViewDodavatele.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Doktori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Doktori> doktoriL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DOKTORI";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Doktori dok = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                                 rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7),
                                rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), null, rs.getInt(14), null);
                        doktoriL.add(dok);
                    }
                    idVymazat = -1;
                    for (Doktori datD : doktoriL) {
                        if (datD.getIdDoktora() == tableViewDoktori.getSelectionModel().getSelectedItem().getIdDoktora()) {
                            idVymazat = datD.getIdDoktora();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_DOKTORI(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    doktoriData.remove(tableViewDoktori.getSelectionModel().getSelectedItem());
                    tableViewDoktori.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Druhy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Druhy> druhyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DRUHY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Druhy druh = new Druhy(rs.getInt(1), rs.getString(2));
                        druhyL.add(druh);
                    }
                    idVymazat = -1;
                    for (Druhy druhyD : druhyL) {
                        if (druhyD.getIdDruhu() == tableViewDruhy.getSelectionModel().getSelectedItem().getIdDruhu()) {
                            idVymazat = druhyD.getIdDruhu();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_DRUHY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    druhyData.remove(tableViewDruhy.getSelectionModel().getSelectedItem());
                    tableViewDruhy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Faktury:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Faktury> fakturyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_FAKTURY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Faktury fak = new Faktury(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), null, null);
                        fakturyL.add(fak);
                    }
                    idVymazat = -1;
                    for (Faktury fakturyD : fakturyL) {
                        if (fakturyD.getIdFaktury() == tableViewFaktury.getSelectionModel().getSelectedItem().getIdFaktury()) {
                            idVymazat = fakturyD.getIdFaktury();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_FAKTURY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    fakturyData.remove(tableViewFaktury.getSelectionModel().getSelectedItem());
                    tableViewFaktury.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;

            case KrevniObrazy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<KrevniObrazy> krevniObrazyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_KREVNI_OBRAZY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        KrevniObrazy krev = new KrevniObrazy(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
                        krevniObrazyL.add(krev);
                    }
                    idVymazat = -1;
                    for (KrevniObrazy krevD : krevniObrazyL) {
                        if (krevD.getIdOdberu() == tableViewKrevniObrazy.getSelectionModel().getSelectedItem().getIdOdberu()) {
                            idVymazat = krevD.getIdOdberu();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_KREVNI_OBRAZY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    krevniObrazyData.remove(tableViewKrevniObrazy.getSelectionModel().getSelectedItem());
                    tableViewKrevniObrazy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Leciva:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Leciva> lecivaL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_LECIVA";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Leciva leciva = new Leciva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), null);
                        lecivaL.add(leciva);
                    }
                    idVymazat = -1;
                    for (Leciva lecivaD : lecivaL) {
                        if (lecivaD.getIdLeku() == tableViewLeciva.getSelectionModel().getSelectedItem().getIdLeku()) {
                            idVymazat = lecivaD.getIdLeku();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_LECIVA(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    lecivaData.remove(tableViewLeciva.getSelectionModel().getSelectedItem());
                    tableViewLeciva.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;

            case Majitele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Majitele> majiteleL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_MAJITELE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Majitele krev = new Majitele(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                                rs.getInt(8), rs.getString(9), rs.getString(10), null);
                        majiteleL.add(krev);
                    }
                    idVymazat = -1;
                    for (Majitele majD : majiteleL) {
                        if (majD.getIdMajitele() == tableViewMajitele.getSelectionModel().getSelectedItem().getIdMajitele()) {
                            idVymazat = majD.getIdMajitele();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_MAJITELE(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    majiteleData.remove(tableViewMajitele.getSelectionModel().getSelectedItem());
                    tableViewMajitele.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Objednavky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Objednavky> objednavkyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_OBJEDNAVKY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Objednavky obj = new Objednavky(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getInt(4), null);
                        objednavkyL.add(obj);
                    }
                    idVymazat = -1;
                    for (Objednavky objD : objednavkyL) {
                        if (objD.getIdObjednavky() == tableViewObjednavky.getSelectionModel().getSelectedItem().getIdObjednavky()) {
                            idVymazat = objD.getIdObjednavky();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_OBJEDNAVKY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    objednavkyData.remove(tableViewObjednavky.getSelectionModel().getSelectedItem());
                    tableViewObjednavky.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Odbery:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Odbery> odberyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ODBERY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Odbery odb = new Odbery(rs.getString(1), rs.getInt(2), rs.getInt(3),
                                rs.getString(4), null);
                        odberyL.add(odb);
                    }
                    idVymazat = -1;
                    for (Odbery odD : odberyL) {
                        if (odD.getIdOdberu() == tableViewOdbery.getSelectionModel().getSelectedItem().getIdOdberu()) {
                            idVymazat = odD.getIdOdberu();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ODBERY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    odberyData.remove(tableViewOdbery.getSelectionModel().getSelectedItem());
                    tableViewOdbery.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Operace:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Operace> operaceL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_OPERACE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Operace opb = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getDouble(4), rs.getString(5));
                        operaceL.add(opb);
                    }
                    idVymazat = -1;
                    for (Operace opb : operaceL) {
                        if (opb.getIdOperace() == tableViewOperace.getSelectionModel().getSelectedItem().getIdOperace()) {
                            idVymazat = opb.getIdOperace();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_OPERACE(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    operaceData.remove(tableViewOperace.getSelectionModel().getSelectedItem());
                    tableViewOperace.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            
            case Polozky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Polozky> polozkyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_POLOZKY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Polozky pol = new Polozky(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), null);
                        polozkyL.add(pol);
                    }
                    idVymazat = -1;
                    for (Polozky polD : polozkyL) {
                        if (polD.getIdPolozky() == tableViewPolozky.getSelectionModel().getSelectedItem().getIdPolozky()) {
                            idVymazat = polD.getIdPolozky();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_POLOZKY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    polozkyData.remove(tableViewPolozky.getSelectionModel().getSelectedItem());
                    tableViewPolozky.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Posty:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Posty> postyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_POSTY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Posty pol = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                        postyL.add(pol);
                    }
                    idVymazat = -1;
                    for (Posty polD : postyL) {
                        if (polD.getIdPosty() == tableViewPosty.getSelectionModel().getSelectedItem().getIdPosty()) {
                            idVymazat = polD.getIdPosty();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_POSTY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    postyData.remove(tableViewPosty.getSelectionModel().getSelectedItem());
                    tableViewPosty.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            
            case Vysetreni:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Vysetreni> vysetreniL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_VYSETRENI";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Vysetreni vys = new Vysetreni(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), null, null);
                        vysetreniL.add(vys);
                    }
                    idVymazat = -1;
                    for (Vysetreni vysD : vysetreniL) {
                        if (vysD.getIdVysetreni() == tableViewVysetreni.getSelectionModel().getSelectedItem().getIdVysetreni()) {
                            idVymazat = vysD.getIdVysetreni();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_VYSETRENI(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    vysetreniData.remove(tableViewVysetreni.getSelectionModel().getSelectedItem());
                    tableViewVysetreni.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Zakroky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Zakroky> zakrokyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ZAKROKY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Zakroky zak = new Zakroky(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), null, null);
                        zakrokyL.add(zak);
                    }
                    idVymazat = -1;
                    for (Zakroky zakD : zakrokyL) {
                        if (zakD.getIdZakroku() == tableViewZakroky.getSelectionModel().getSelectedItem().getIdZakroku()) {
                            idVymazat = zakD.getIdZakroku();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ZAKROKY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    zakrokyData.remove(tableViewZakroky.getSelectionModel().getSelectedItem());
                    tableViewZakroky.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Zpravy:
                /////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Zpravy> zpravyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ZPRAVY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Zpravy zp = new Zpravy(rs.getInt(1), rs.getInt(2), "", rs.getInt(3),
                                "", rs.getString(4), rs.getInt(5), rs.getInt(6));
                        zpravyL.add(zp);
                    }
                    idVymazat = -1;
                    for (Zpravy zpD : zpravyL) {
                        if (zpD.getIdZpravy() == tableViewZpravy.getSelectionModel().getSelectedItem().getIdZpravy()) {
                            idVymazat = zpD.getIdZpravy();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ZPRAVY(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    zpravyData.remove(tableViewZpravy.getSelectionModel().getSelectedItem());
                    tableViewZpravy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
                break;
            case Zvirata:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                try {
                    ObservableList<Zvirata> zvirataL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ZVIRATA";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
                                null, null, null, null);
                        zvirataL.add(zv);
                    }
                    idVymazat = -1;
                    for (Zvirata zvD : zvirataL) {
                        if (zvD.getIdZvirete() == tableViewZvirata.getSelectionModel().getSelectedItem().getIdZvirete()) {
                            idVymazat = zvD.getIdZvirete();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ZVIRATA(?,?)}");
                    cst.setInt(1, idVymazat);
                    cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    cst.executeUpdate();
                    zvirataData.remove(tableViewZvirata.getSelectionModel().getSelectedItem());
                    tableViewZvirata.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba pri mazani, nutne odstranit nejprve zavisle tabulky");
                    }
                }
        }
    }

    @FXML
    private void button_ulozit(ActionEvent event) {
    }

    @FXML
    private void btnFotkuOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("jpg file (*jpg)", "*.jpg");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showOpenDialog(null);
              
        Image image;
        
        try{
            if(file!=null){ 
            image = new Image(file.toURI().toString());
            if(image.isError() || image==null){ 
                throw new Exception("Špatný obrazek");
            }
            try {
                CallableStatement csf = con.prepareCall("{call PROC_ADD_FOTO_DOKTORU(?,?,?,?,?,?)}");
                csf.setString(1, file.getName());
                csf.setString(2, "obrazek");
                csf.setString(3, ".jpg");
                //pstmt.setDate(4, new Date(50, 5, 5));
                //Inserting Blob type
                InputStream in;
                try {
                    in = new FileInputStream(file);
                    csf.setBlob(4, in);
                } catch (FileNotFoundException ex) {
                    zobrazErrorDialog("Chyba", "Obrazek nenalezen");
                }
                csf.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                csf.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                csf.execute();

            } catch (SQLException ex) {
                zobrazErrorDialog("Chyba", ex.getMessage());
            }
        }
        }catch(Exception e){ 
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("nezdařilo se načtení obrázku !");
            alert.showAndWait();
        }
        

    }

    @FXML
    private void cbTabulkaOnAction(ActionEvent event) {
        try {
            obnovit();
        } catch (SQLException ex) {
            zobrazErrorDialog("Chyba !", ex.getMessage());
        }
    }

    @FXML
    private void hadnleBtnNapsatZpravu(ActionEvent event) {
    }

}
