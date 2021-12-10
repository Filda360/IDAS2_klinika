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
import java.sql.SQLType;
import java.sql.Types;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import jdk.nashorn.internal.codegen.types.Type;
import prihlasovani.PrihlasenyUzivatel;
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
    @FXML
    private Button btnNadrizeni;
    @FXML
    private Button btnChudaci;
    @FXML
    private Button btnNajdiPodobna;
    

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
        tableViewZpravy.setEditable(false);

        zpravy_prijemce.setCellFactory(TextFieldTableCell.forTableColumn());
        zpravy_odesilatel.setCellFactory(TextFieldTableCell.forTableColumn());
        zpravy_text.setCellFactory(TextFieldTableCell.forTableColumn());

        zvirata_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        zvirata_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        zvirata_vaha.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        zvirata_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());
        zvirata_cislo_cipu.setCellFactory(TextFieldTableCell.forTableColumn());
        
        try {
            obnovit();
        } catch (SQLException ex) {
            zobrazErrorDialog("Chyba !", ex.getMessage());
        }
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
                btnNajdiPodobna.setVisible(false);
                
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
                tfFiltr.setVisible(false);
                chBFiltr.setVisible(false);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
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
                btnNajdiPodobna.setVisible(false);
                 
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
                tfFiltr.setVisible(false);
                chBFiltr.setVisible(false);                
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
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
                btnNajdiPodobna.setVisible(false);
                
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
                tfFiltr.setVisible(false);
                chBFiltr.setVisible(false); 
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true); 
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
                chBFiltr.setText("nazev");
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
                btnNajdiPodobna.setVisible(false);
                
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
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
                chBFiltr.setText("nazev");
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
                            cbAdresy.setDisable(true);
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
                chBFiltr.setText("přijmeni");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
                chBFiltr.setText("druh");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
                chBFiltr.setText("přijmení");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(false);
                chBFiltr.setVisible(false);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                chBFiltr.setText("nazev");
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);                
                chBFiltr.setText("nazev");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);               
                chBFiltr.setText("přijmeni");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(false);
                chBFiltr.setVisible(false);
                dpDatum.setVisible(true);
                chBDatum.setVisible(true);              
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                 tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                 dpDatum.setVisible(false);
                chBDatum.setVisible(false);               
                chBFiltr.setText("jmeno");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);                
                chBFiltr.setText("nazev");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                 dpDatum.setVisible(false);
                chBDatum.setVisible(false);               
                chBFiltr.setText("nazev");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                 dpDatum.setVisible(false);
                chBDatum.setVisible(false);               
                chBFiltr.setText("město");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);                
                chBFiltr.setText("jméno");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);              
                chBFiltr.setText("jmeno");
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
                btnNajdiPodobna.setVisible(false);
                
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
                
                tfFiltr.setVisible(false);
                chBFiltr.setVisible(false);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);               
                sql = "SELECT * FROM PO_ZPRAVY WHERE ID_PRIJEMCE = " + FXMLUvodniController.prihlasenyUzivatel.getId();
                
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
                btnNajdiPodobna.setVisible(true);
                
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
                
                tfFiltr.setVisible(true);
                chBFiltr.setVisible(true);
                dpDatum.setVisible(false);
                chBDatum.setVisible(false);
                chBFiltr.setText("jmeno");
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
                cbTypyPlatby.getSelectionModel().selectFirst();

                Faktury fak = new Faktury(-1, "2000-12-01", "2000-12-01",
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
                Majitele maj = new Majitele(-1, "2000-12-01",
                        "", "", "2000-12-01",
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
                Odbery od = new Odbery("2000-12-01", -1, -1, "", cbZvirata);
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

                Vysetreni vys = new Vysetreni(-1, "2000-12-01", "",
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

                Zakroky zak = new Zakroky(-1, "2000-12-01", "",
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

                Zvirata zvir = new Zvirata(-1, "", "2000-12-01", 0, "", "", -1, -1, -1, -1, cbMajitele3, cbPohlavi, cbDruhy, cbDoktori);
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
        CallableStatement cst = null;
        String sql;
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
                    ObservableList<Adresy> adresyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ADRESY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                        adresyL.add(ad);
                    }

                    Administratori ad = tableViewAdministratori.getSelectionModel().getSelectedItem();

                    if (ad.getJmeno().isEmpty()
                            || ad.getPrijmeni().isEmpty()
                            || ad.getDatumNarozeni().isEmpty()
                            || ad.getTelefon().isEmpty()
                            || ad.getEmail().isEmpty()
                            || ad.getPrihlasovaciJmeno().isEmpty()
                            || ad.getHeslo().isEmpty()
                            || ad.getHeslo().isEmpty()
                            || ad.getAdresy().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Administratori admin : adminL) {
                        if (admin.getIdAdministratora() == ad.getIdAdministratora()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idAdresy = -1;
                    boolean nalezena = false;
                    for (Adresy adr : adresyL) {
                        if (adr.getIdAdresy() == ad.getAdresy().getValue().getIdAdresy()) {
                            idAdresy = adr.getIdAdresy();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Adresa nenalezena");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_ADMINISTRATORI(?,?,?,?,?,?,?,?,?,?)}");
                        cst.setInt(1, ad.getIdAdministratora());
                        cst.setString(2, ad.getJmeno());
                        cst.setString(3, ad.getPrijmeni());
                        cst.setDate(4, Date.valueOf(ad.getDatumNarozeni()));
                        cst.setString(5, ad.getTelefon());
                        cst.setString(6, ad.getEmail());
                        cst.setInt(7, idAdresy);
                        cst.setString(8, ad.getPrihlasovaciJmeno());
                        cst.setString(9, ad.getHeslo());
                        cst.setInt(10, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {

                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ADMINISTRATORI(?,?,?,?,?,?,?,?,?)}");

                        cst.setString(1, ad.getJmeno());
                        cst.setString(2, ad.getPrijmeni());
                        cst.setDate(3, Date.valueOf(ad.getDatumNarozeni()));
                        cst.setString(4, ad.getTelefon());
                        cst.setString(5, ad.getEmail());
                        cst.setInt(6, idAdresy);
                        cst.setString(7, ad.getPrihlasovaciJmeno());
                        cst.setString(8, ad.getHeslo());
                        cst.setInt(9, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewAdministratori.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                        adresyL.add(ad);
                    }
                    ObservableList<Posty> postyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_POSTY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Posty post = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                        postyL.add(post);
                    }

                    Adresy adD = tableViewAdresy.getSelectionModel().getSelectedItem();

                    if (adD.getUlice().isEmpty()
                            || adD.getCisloPopisne().isEmpty()
                            || adD.getPosty().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Adresy adre : adresyL) {
                        if (adre.getIdAdresy() == adD.getIdAdresy()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idPosty = -1;
                    boolean nalezena = false;
                    for (Posty post : postyL) {
                        if (post.getIdPosty() == adD.getPosty().getValue().getIdPosty()) {
                            idPosty = post.getIdPosty();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Posta nenalezena");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_ADRESY(?,?,?,?,?)}");
                        cst.setInt(1, adD.getIdAdresy());
                        cst.setString(2, adD.getUlice());
                        cst.setString(3, adD.getCisloPopisne());
                        cst.setInt(4, idPosty);
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {

                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ADRESY(?,?,?,?)}");
                        cst.setString(1, adD.getUlice());
                        cst.setString(2, adD.getCisloPopisne());
                        cst.setInt(3, idPosty);
                        cst.setInt(4, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewAdresy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Biochemie ad = new Biochemie(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                        biochemieL.add(ad);
                    }
                    Biochemie bioD = tableViewBiochemie.getSelectionModel().getSelectedItem();

                    boolean jePritomny = false;
                    for (Biochemie bioCh : biochemieL) {
                        if (bioCh.getIdOdberu() == bioD.getIdOdberu()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_BIOCHEMIE(?,?,?,?,?,?,?)}");
                        cst.setInt(1, bioD.getIdOdberu());
                        cst.setDouble(2, bioD.getUrea());
                        cst.setDouble(3, bioD.getKreatinin());
                        cst.setDouble(4, bioD.getBilirubin());
                        cst.setDouble(5, bioD.getAst());
                        cst.setDouble(6, bioD.getAlt());
                        cst.setInt(7, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_BIOCHEMIE(?,?,?,?,?,?)}");
                        cst.setDouble(1, bioD.getUrea());
                        cst.setDouble(2, bioD.getKreatinin());
                        cst.setDouble(3, bioD.getBilirubin());
                        cst.setDouble(4, bioD.getAst());
                        cst.setDouble(5, bioD.getAlt());
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewBiochemie.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Diagnozy diag = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                        diagnozyL.add(diag);
                    }
                    Diagnozy diaD = tableViewDiagnozy.getSelectionModel().getSelectedItem();

                    boolean jePritomny = false;
                    for (Diagnozy diaG : diagnozyL) {
                        if (diaG.getIdDiagnozy() == diaD.getIdDiagnozy()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_DIAGNOZY(?,?,?,?,?)}");
                        cst.setInt(1, diaD.getIdDiagnozy());
                        cst.setString(2, diaD.getNazev());
                        cst.setString(3, diaD.getOznaceni());
                        cst.setDouble(4, diaD.getStupenZavaznosti());
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_DIAGNOZY(?,?,?,?)}");
                        cst.setString(1, diaD.getNazev());
                        cst.setString(2, diaD.getOznaceni());
                        cst.setDouble(3, diaD.getStupenZavaznosti());
                        cst.setInt(4, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewDiagnozy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Dodavatele dod = new Dodavatele(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), null);
                        dodavateleL.add(dod);
                    }
                    ObservableList<Adresy> adresyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ADRESY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                        adresyL.add(ad);
                    }

                    Dodavatele dodD = tableViewDodavatele.getSelectionModel().getSelectedItem();

                    if (dodD.getNazev().isEmpty()
                            || dodD.getEmail().isEmpty()
                            || dodD.getAdresy().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Dodavatele dodA : dodavateleL) {
                        if (dodA.getIdDodavatele() == dodD.getIdDodavatele()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idAdresy = -1;
                    boolean nalezena = false;
                    for (Adresy adr : adresyL) {
                        if (adr.getIdAdresy() == dodD.getAdresy().getValue().getIdAdresy()) {
                            idAdresy = adr.getIdAdresy();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Adresa nenalezena");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_DODAVATELE(?,?,?,?,?,?)}");
                        cst.setInt(1, dodD.getIdDodavatele());
                        cst.setString(2, dodD.getNazev());
                        cst.setString(3, dodD.getTelefon());
                        cst.setString(4, dodD.getEmail());
                        cst.setInt(5, idAdresy);
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_DODAVATELE(?,?,?,?,?)}");
                        cst.setString(1, dodD.getNazev());
                        cst.setString(2, dodD.getTelefon());
                        cst.setString(3, dodD.getEmail());
                        cst.setInt(4, idAdresy);
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewDodavatele.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Doktori dok = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
                                rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), null, rs.getInt(14), null);
                        doktoriL.add(dok);
                    }
                    ObservableList<Adresy> adresyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ADRESY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                        adresyL.add(ad);
                    }

                    Doktori dokD = tableViewDoktori.getSelectionModel().getSelectedItem();

                    if (dokD.getTitul().isEmpty()
                            || dokD.getDelkaUvazku().isEmpty()
                            || dokD.getDatumNastupu().isEmpty()
                            || dokD.getJmeno().isEmpty()
                            || dokD.getPrijmeni().isEmpty()
                            || dokD.getDatumNarozeni().isEmpty()
                            || dokD.getTelefon().isEmpty()
                            || dokD.getHeslo().isEmpty()
                            || dokD.getPrihlasovaciJmeno().isEmpty()
                            || dokD.getDoktori().getValue() == null
                            || dokD.getAdresy().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Doktori dokA : doktoriL) {
                        if (dokA.getIdDoktora() == dokD.getIdDoktora()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idAdresy = -1;
                    boolean nalezena = false;
                    for (Adresy adr : adresyL) {
                        if (adr.getIdAdresy() == dokD.getAdresy().getValue().getIdAdresy()) {
                            idAdresy = adr.getIdAdresy();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Adresa nenalezena");
                    }

                    int idDoktora = -1;
                    for (Doktori dokB : doktoriL) {
                        if (dokB.getIdNadrizeneho() == dokD.getDoktori().getValue().getIdDoktora()) {
                            idDoktora = dokB.getIdNadrizeneho();
                            break;
                        }
                    }

                    if (jePritomny) { //15
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_DOKTORI(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        cst.setInt(1, dokD.getIdDoktora());
                        cst.setString(2, dokD.getTitul());
                        cst.setString(3, dokD.getDelkaUvazku());
                        cst.setDate(4, Date.valueOf(dokD.getDatumNastupu()));
                        cst.setDouble(5, dokD.getPlat());
                        cst.setString(6, dokD.getJmeno());
                        cst.setString(7, dokD.getPrijmeni());
                        cst.setDate(8, Date.valueOf(dokD.getDatumNarozeni()));
                        cst.setString(9, dokD.getTelefon());
                        cst.setString(10, dokD.getEmail());
                        cst.setInt(11, idAdresy);
                        cst.setString(12, dokD.getHeslo());
                        cst.setString(13, dokD.getPrihlasovaciJmeno());
                        cst.setInt(14, idDoktora);
                        cst.setInt(15, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {//14
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_DOKTORI(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        cst.setString(1, dokD.getTitul());
                        cst.setString(2, dokD.getDelkaUvazku());
                        cst.setDate(3, Date.valueOf(dokD.getDatumNastupu()));
                        cst.setDouble(4, dokD.getPlat());
                        cst.setString(5, dokD.getJmeno());
                        cst.setString(6, dokD.getPrijmeni());
                        cst.setDate(7, Date.valueOf(dokD.getDatumNarozeni()));
                        cst.setString(8, dokD.getTelefon());
                        cst.setString(9, dokD.getEmail());
                        cst.setInt(10, idAdresy);
                        cst.setString(11, dokD.getHeslo());
                        cst.setString(12, dokD.getPrihlasovaciJmeno());
                        cst.setInt(13, idDoktora);
                        cst.setInt(14, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewDoktori.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                    Druhy druD = tableViewDruhy.getSelectionModel().getSelectedItem();

                    if (druD.getDruh().isEmpty()) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }

                    boolean jePritomny = false;
                    for (Druhy druH : druhyL) {
                        if (druH.getIdDruhu() == druD.getIdDruhu()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_DRUHY(?,?,?)}");
                        cst.setInt(1, druD.getIdDruhu());
                        cst.setString(2, druD.getDruh());
                        cst.setInt(3, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_DRUHY(?,?)}");
                        cst.setString(1, druD.getDruh());
                        cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewDruhy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                    ObservableList<Majitele> majiteleL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_MAJITELE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3),
                                rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7),
                                rs.getInt(8), rs.getString(9), rs.getString(10), null);
                        majiteleL.add(maj);
                    }
                    ObservableList<TypyPlatby> typyPlatbyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_TYPY_PLATBY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        TypyPlatby typy = new TypyPlatby(rs.getInt(1), rs.getString(2));
                        typyPlatbyL.add(typy);
                    }

                    Faktury fakD = tableViewFaktury.getSelectionModel().getSelectedItem();

                    if (fakD.getDatumVystaveni().isEmpty()
                            || fakD.getDatumSplatnosti().isEmpty()
                            || fakD.getStav().isEmpty()
                            || fakD.getMajitele().getValue() == null
                            || fakD.getTypy().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Faktury fakA : fakturyL) {
                        if (fakA.getIdFaktury() == fakD.getIdFaktury()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idMajitele = -1;
                    boolean nalezena = false;
                    for (Majitele majE : majiteleL) {
                        if (majE.getIdMajitele() == fakD.getMajitele().getValue().getIdMajitele()) {
                            idMajitele = majE.getIdMajitele();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Majitel nenalezen");
                    }
                    int idTypu = -1;
                    boolean nalezena2 = false;
                    for (TypyPlatby typY : typyPlatbyL) {
                        if (typY.getIdTypu() == fakD.getTypy().getValue().getIdTypu()) {
                            idTypu = typY.getIdTypu();
                            nalezena2 = true;
                            break;
                        }
                    }
                    if (!nalezena2) {
                        throw new Exception("TypPlatby nenalezen");
                    }

                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_FAKTURY(?,?,?,?,?,?,?)}");
                        cst.setInt(1, fakD.getIdFaktury());
                        cst.setDate(2, Date.valueOf(fakD.getDatumVystaveni()));
                        cst.setDate(3, Date.valueOf(fakD.getDatumSplatnosti()));
                        cst.setString(4, fakD.getStav());
                        cst.setInt(5, idMajitele);
                        cst.setInt(6, idTypu);
                        cst.setInt(7, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_FAKTURY(?,?,?,?,?,?)}");
                        cst.setDate(1, Date.valueOf(fakD.getDatumVystaveni()));
                        cst.setDate(2, Date.valueOf(fakD.getDatumSplatnosti()));
                        cst.setString(3, fakD.getStav());
                        cst.setInt(4, idMajitele);
                        cst.setInt(5, idTypu);
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewFaktury.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        KrevniObrazy krevni = new KrevniObrazy(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
                        krevniObrazyL.add(krevni);
                    }
                    KrevniObrazy krevD = tableViewKrevniObrazy.getSelectionModel().getSelectedItem();

                    boolean jePritomny = false;
                    for (KrevniObrazy krvY : krevniObrazyL) {
                        if (krvY.getIdOdberu() == krevD.getIdOdberu()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_KREVNI_OBRAZY(?,?,?,?,?,?)}");
                        cst.setInt(1, krevD.getIdOdberu());
                        cst.setDouble(2, krevD.getErytrocyty());
                        cst.setDouble(3, krevD.getLeukocyty());
                        cst.setDouble(4, krevD.getTrombocyty());
                        cst.setDouble(5, krevD.getHemoglobin());
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewKrevniObrazy.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Leciva lec = new Leciva(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), null);
                        lecivaL.add(lec);
                    }
                    ObservableList<Dodavatele> dodavateleL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DODAVATELE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Dodavatele dod = new Dodavatele(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), null);
                        dodavateleL.add(dod);
                    }

                    Leciva lecD = tableViewLeciva.getSelectionModel().getSelectedItem();

                    if (lecD.getNazev().isEmpty()
                            || lecD.getDatumExpirace().isEmpty()
                            || lecD.getDodavatele().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Leciva lecA : lecivaL) {
                        if (lecA.getIdLeku() == lecD.getIdLeku()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idDodavatele = -1;
                    boolean nalezena = false;
                    for (Dodavatele dod : dodavateleL) {
                        if (dod.getIdDodavatele() == lecD.getDodavatele().getValue().getIdDodavatele()) {
                            idDodavatele = dod.getIdDodavatele();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Dodavatel nenalezen");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_LECIVA(?,?,?,?,?,?,?)}");
                        cst.setInt(1, lecD.getIdLeku());
                        cst.setString(2, lecD.getNazev());
                        cst.setDate(3, Date.valueOf(lecD.getDatumExpirace()));
                        cst.setInt(4, lecD.getPocetSkladem());
                        cst.setString(5, lecD.getPopis());
                        cst.setInt(6, idDodavatele);
                        cst.setInt(7, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_LECIVA(?,?,?,?,?,?)}");
                        cst.setString(1, lecD.getNazev());
                        cst.setDate(2, Date.valueOf(lecD.getDatumExpirace()));
                        cst.setInt(3, lecD.getPocetSkladem());
                        cst.setString(4, lecD.getPopis());
                        cst.setInt(5, idDodavatele);
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewLeciva.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3),
                                rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7),
                                rs.getInt(8), rs.getString(9), rs.getString(10), null);
                        majiteleL.add(maj);
                    }
                    ObservableList<Adresy> adresyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_ADRESY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                        adresyL.add(ad);
                    }

                    Majitele majD = tableViewMajitele.getSelectionModel().getSelectedItem();

                    if (majD.getDatumRegistrace().isEmpty()
                            || majD.getJmeno().isEmpty()
                            || majD.getPrijmeni().isEmpty()
                            || majD.getDatumNarozeni().isEmpty()
                            || majD.getTelefon().isEmpty()
                            || majD.getHeslo().isEmpty()
                            || majD.getPrihlasovaciJmeno().isEmpty()
                            || majD.getAdresy().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Majitele majA : majiteleL) {
                        if (majA.getIdMajitele() == majD.getIdMajitele()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idAdresy = -1;
                    boolean nalezena = false;
                    for (Adresy adR : adresyL) {
                        if (adR.getIdAdresy() == majD.getAdresy().getValue().getIdAdresy()) {
                            idAdresy = adR.getIdAdresy();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Adresa nenalezena");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_MAJITELE(?,?,?,?,?,?,?,?,?,?,?)}");
                        cst.setInt(1, majD.getIdMajitele());
                        cst.setDate(2, Date.valueOf(majD.getDatumRegistrace()));
                        cst.setString(3, majD.getJmeno());
                        cst.setString(4, majD.getPrijmeni());
                        cst.setDate(5, Date.valueOf(majD.getDatumNarozeni()));
                        cst.setString(6, majD.getTelefon());
                        cst.setString(7, majD.getEmail());
                        cst.setInt(8, majD.getIdAdresy());
                        cst.setString(9, majD.getHeslo());
                        cst.setString(10, majD.getPrihlasovaciJmeno());
                        cst.setInt(11, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_MAJITELE(?,?,?,?,?,?,?,?,?,?)}");
                        cst.setDate(1, Date.valueOf(majD.getDatumRegistrace()));
                        cst.setString(2, majD.getJmeno());
                        cst.setString(3, majD.getPrijmeni());
                        cst.setDate(4, Date.valueOf(majD.getDatumNarozeni()));
                        cst.setString(5, majD.getTelefon());
                        cst.setString(6, majD.getEmail());
                        cst.setInt(7, majD.getIdAdresy());
                        cst.setString(8, majD.getHeslo());
                        cst.setString(9, majD.getPrihlasovaciJmeno());
                        cst.setInt(10, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewMajitele.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Objednavky obj = new Objednavky(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                                rs.getInt(4), null);
                        objednavkyL.add(obj);
                    }
                    ObservableList<Majitele> majiteleL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_MAJITELE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Majitele maj = new Majitele(rs.getInt(1), rs.getDate(2).toString(), rs.getString(3),
                                rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7),
                                rs.getInt(8), rs.getString(9), rs.getString(10), null);
                        majiteleL.add(maj);
                    }

                    Objednavky objD = tableViewObjednavky.getSelectionModel().getSelectedItem();

                    if (objD.getPricina().isEmpty()
                            || objD.getTermin().isEmpty()
                            || objD.getMajitele().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Objednavky objA : objednavkyL) {
                        if (objA.getIdObjednavky() == objD.getIdObjednavky()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idMajitele = -1;
                    boolean nalezena = false;
                    for (Majitele maJ : majiteleL) {
                        if (maJ.getIdMajitele() == objD.getMajitele().getValue().getIdMajitele()) {
                            idMajitele = maJ.getIdMajitele();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Majitel nenalezen");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_OBJEDNAVKY(?,?,?,?,?)}");
                        cst.setInt(1, objD.getIdObjednavky());
                        cst.setString(2, objD.getPricina());
                        cst.setDate(3, Date.valueOf(objD.getTermin()));
                        cst.setInt(4, idMajitele);
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_OBJEDNAVKY(?,?,?,?)}");
                        cst.setString(1, objD.getPricina());
                        cst.setDate(2, Date.valueOf(objD.getTermin()));
                        cst.setInt(3, idMajitele);
                        cst.setInt(4, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewObjednavky.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Odbery obj = new Odbery(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), null);
                        odberyL.add(obj);
                    }
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

                    Odbery odbD = tableViewOdbery.getSelectionModel().getSelectedItem();

                    if (odbD.getDatum().isEmpty()
                            || odbD.getZvirata().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Odbery odbA : odberyL) {
                        if (odbA.getIdOdberu() == odbD.getIdOdberu()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idZvirete = -1;
                    boolean nalezena = false;
                    for (Zvirata zvI : zvirataL) {
                        if (zvI.getIdZvirete() == odbD.getZvirata().getValue().getIdZvirete()) {
                            idZvirete = zvI.getIdZvirete();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Zvire nenalezeno");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_ODBERY(?,?,?,?,?)}");
                        cst.setInt(1, odbD.getIdOdberu());
                        cst.setInt(2, idZvirete);
                        cst.setDate(3, Date.valueOf(odbD.getDatum()));
                        cst.setString(4, odbD.getPoznamka());
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ODBERY(?,?,?,?)}");
                        cst.setInt(1, idZvirete);
                        cst.setDate(2, Date.valueOf(odbD.getDatum()));
                        cst.setString(3, odbD.getPoznamka());
                        cst.setInt(4, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewOdbery.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Operace ope = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                        operaceL.add(ope);
                    }

                    Operace opeD = tableViewOperace.getSelectionModel().getSelectedItem();

                    if (opeD.getNazev().isEmpty()
                            || opeD.getOznaceni().isEmpty()) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Operace opeA : operaceL) {
                        if (opeA.getIdOperace() == opeD.getIdOperace()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_OPERACE(?,?,?,?,?,?)}");
                        cst.setInt(1, opeD.getIdOperace());
                        cst.setString(2, opeD.getNazev());
                        cst.setString(3, opeD.getOznaceni());
                        cst.setDouble(4, opeD.getDelka());
                        cst.setString(5, opeD.getRiziko());
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_OPERACE(?,?,?,?,?)}");
                        cst.setString(1, opeD.getNazev());
                        cst.setString(2, opeD.getOznaceni());
                        cst.setDouble(3, opeD.getDelka());
                        cst.setString(4, opeD.getRiziko());
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewOperace.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                    ObservableList<Faktury> fakturyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_FAKTURY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Faktury fak = new Faktury(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), null, null);
                        fakturyL.add(fak);
                    }

                    Polozky polD = tableViewPolozky.getSelectionModel().getSelectedItem();

                    if (polD.getNazev().isEmpty()
                            || polD.getFaktury().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Polozky polA : polozkyL) {
                        if (polA.getIdPolozky() == polD.getIdPolozky()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idFaktury = -1;
                    boolean nalezena = false;
                    for (Faktury fakT : fakturyL) {
                        if (fakT.getIdFaktury() == polD.getFaktury().getValue().getIdFaktury()) {
                            idFaktury = fakT.getIdFaktury();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Faktura nenalezena");
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_POLOZKY(?,?,?,?,?,?)}");
                        cst.setInt(1, polD.getIdPolozky());
                        cst.setString(2, polD.getNazev());
                        cst.setInt(3, polD.getPocet());
                        cst.setInt(4, polD.getCena());
                        cst.setInt(5, idFaktury);
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_POLOZKY(?,?,?,?,?)}");
                        cst.setString(1, polD.getNazev());
                        cst.setInt(2, polD.getPocet());
                        cst.setInt(3, polD.getCena());
                        cst.setInt(4, idFaktury);
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewPolozky.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                        Posty post = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                        postyL.add(post);
                    }

                    Posty posD = tableViewPosty.getSelectionModel().getSelectedItem();

                    if (posD.getMesto().isEmpty()
                            || posD.getPSC().isEmpty()) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Posty posA : postyL) {
                        if (posA.getIdPosty() == posD.getIdPosty()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_POSTY(?,?,?,?)}");
                        cst.setInt(1, posD.getIdPosty());
                        cst.setString(2, posD.getMesto());
                        cst.setString(3, posD.getPSC());
                        cst.setInt(4, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_POSTY(?,?,?)}");
                        cst.setString(1, posD.getMesto());
                        cst.setString(2, posD.getPSC());
                        cst.setInt(3, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewPosty.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                    ObservableList<Diagnozy> diagnozyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DIAGNOZY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Diagnozy diag = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                        diagnozyL.add(diag);
                    }
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

                    Vysetreni vysD = tableViewVysetreni.getSelectionModel().getSelectedItem();

                    if (vysD.getDatum().isEmpty()
                            || vysD.getDiagnozy().getValue() == null
                            || vysD.getZvirata().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Vysetreni vysA : vysetreniL) {
                        if (vysA.getIdVysetreni() == vysD.getIdVysetreni()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idDiagnozy = -1;
                    boolean nalezena = false;
                    for (Diagnozy diaG : diagnozyL) {
                        if (diaG.getIdDiagnozy() == vysD.getDiagnozy().getValue().getIdDiagnozy()) {
                            idDiagnozy = diaG.getIdDiagnozy();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Diagnoza nenalezena");
                    }
                    int idZvirete = -1;
                    boolean nalezena2 = false;
                    for (Zvirata zviR : zvirataL) {
                        if (zviR.getIdZvirete() == vysD.getZvirata().getValue().getIdZvirete()) {
                            idZvirete = zviR.getIdZvirete();
                            nalezena2 = true;
                            break;
                        }
                    }
                    if (!nalezena2) {
                        throw new Exception("Zvire nenalezeno");
                    }

                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_VYSETRENI(?,?,?,?,?,?)}");
                        cst.setInt(1, vysD.getIdVysetreni());
                        cst.setDate(2, Date.valueOf(vysD.getDatum()));
                        cst.setString(3, vysD.getPoznamka());
                        cst.setInt(4, idDiagnozy);
                        cst.setInt(5, idZvirete);
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_VYSETRENI(?,?,?,?,?)}");
                        cst.setDate(1, Date.valueOf(vysD.getDatum()));
                        cst.setString(2, vysD.getPoznamka());
                        cst.setInt(3, idDiagnozy);
                        cst.setInt(4, idZvirete);
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewVysetreni.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
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
                    ObservableList<Operace> operaceL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_OPERACE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Operace ope = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                        operaceL.add(ope);
                    }

                    Zakroky zakD = tableViewZakroky.getSelectionModel().getSelectedItem();

                    if (zakD.getDatum().isEmpty()
                            || zakD.getZvirata().getValue() == null
                            || zakD.getOperace().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Zakroky zakA : zakrokyL) {
                        if (zakA.getIdZakroku() == zakD.getIdZakroku()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idOperace = -1;
                    boolean nalezena = false;
                    for (Operace opeG : operaceL) {
                        if (opeG.getIdOperace() == zakD.getOperace().getValue().getIdOperace()) {
                            idOperace = opeG.getIdOperace();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Operace nenalezena");
                    }
                    int idZvirete = -1;
                    boolean nalezena2 = false;
                    for (Zvirata zviR : zvirataL) {
                        if (zviR.getIdZvirete() == zakD.getZvirata().getValue().getIdZvirete()) {
                            idZvirete = zviR.getIdZvirete();
                            nalezena2 = true;
                            break;
                        }
                    }
                    if (!nalezena2) {
                        throw new Exception("Zvire nenalezeno");
                    }

                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_ZAKROKY(?,?,?,?,?,?)}");
                        cst.setInt(1, zakD.getIdZakroku());
                        cst.setDate(2, Date.valueOf(zakD.getDatum()));
                        cst.setString(3, zakD.getPoznamka());
                        cst.setInt(4, idZvirete);
                        cst.setInt(5, idOperace);
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ZAKROKY(?,?,?,?,?)}");
                        cst.setDate(1, Date.valueOf(zakD.getDatum()));
                        cst.setString(2, zakD.getPoznamka());
                        cst.setInt(3, idZvirete);
                        cst.setInt(4, idOperace);
                        cst.setInt(5, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewZakroky.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
                    }
                }
                break;
            case Zpravy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
                    ObservableList<Majitele> majiteleL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_MAJITELE";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Majitele maj = new Majitele(rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                                rs.getInt(8), rs.getString(9), rs.getString(10), null);
                        majiteleL.add(maj);
                    }
                    ObservableList<Pohlavi> pohlaviL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_POHLAVI";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Pohlavi poh = new Pohlavi(rs.getInt(1), rs.getString(2));
                        pohlaviL.add(poh);
                    }
                    ObservableList<Druhy> druhyL = FXCollections.observableArrayList();
                    sql = "SELECT * FROM PO_DRUHY";
                    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Druhy druh = new Druhy(rs.getInt(1), rs.getString(2));
                        druhyL.add(druh);
                    }
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

                    Zvirata zviD = tableViewZvirata.getSelectionModel().getSelectedItem();

                    if (zviD.getJmeno().isEmpty()
                            || zviD.getDatumNarozeni().isEmpty()
                            || zviD.getMajitele().getValue() == null
                            || zviD.getPohlavi().getValue() == null
                            || zviD.getDruhy().getValue() == null
                            || zviD.getDoktori().getValue() == null) {
                        throw new Exception("Formulář není řádně vyplněn, některá pole jsou prázdná !");
                    }
                    boolean jePritomny = false;
                    for (Zvirata zviA : zvirataL) {
                        if (zviA.getIdZvirete() == zviD.getIdZvirete()) {
                            jePritomny = true;
                            break;
                        }
                    }
                    int idMajitele = -1;
                    boolean nalezena = false;
                    for (Majitele maJ : majiteleL) {
                        if (maJ.getIdMajitele() == zviD.getMajitele().getValue().getIdMajitele()) {
                            idMajitele = maJ.getIdMajitele();
                            nalezena = true;
                            break;
                        }
                    }
                    if (!nalezena) {
                        throw new Exception("Majitel nenalezen");
                    }
                    int idPohlavi = -1;
                    boolean nalezena2 = false;
                    for (Pohlavi pohL : pohlaviL) {
                        if (pohL.getIdPohlavi() == zviD.getPohlavi().getValue().getIdPohlavi()) {
                            idPohlavi = pohL.getIdPohlavi();
                            nalezena2 = true;
                            break;
                        }
                    }
                    if (!nalezena2) {
                        throw new Exception("Pohlavi nenalezeno");
                    }
                    int idDruh = -1;
                    boolean nalezena3 = false;
                    for (Druhy druH : druhyL) {
                        if (druH.getIdDruhu() == zviD.getDruhy().getValue().getIdDruhu()) {
                            idDruh = druH.getIdDruhu();
                            nalezena3 = true;
                            break;
                        }
                    }
                    if (!nalezena3) {
                        throw new Exception("Pohlavi nenalezeno");
                    }
                    int idDoktor = -1;
                    boolean nalezena4 = false;
                    for (Doktori dokT : doktoriL) {
                        if (dokT.getIdDoktora() == zviD.getDoktori().getValue().getIdDoktora()) {
                            idDoktor = dokT.getIdDoktora();
                            nalezena4 = true;
                            break;
                        }
                    }
                    if (!nalezena4) {
                        throw new Exception("Doktor nenalezen");
                    }

                    if (jePritomny) {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_ZVIRATA(?,?,?,?,?,?,?,?,?,?,?)}");
                        cst.setInt(1, zviD.getIdZvirete());
                        cst.setString(2, zviD.getJmeno());
                        cst.setDate(3, Date.valueOf(zviD.getDatumNarozeni()));
                        cst.setDouble(4, zviD.getVaha());
                        cst.setString(5, zviD.getPoznamka());
                        cst.setString(6, zviD.getCisloCipu());
                        cst.setInt(7, idMajitele);
                        cst.setInt(8, idPohlavi);
                        cst.setInt(9, idDruh);
                        cst.setInt(10, idDoktor);
                        cst.setInt(11, FXMLUvodniController.prihlasenyUzivatel.getId());
                    } else {
                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ZVIRATA(?,?,?,?,?,?,?,?,?,?)}");
                        cst.setString(1, zviD.getJmeno());
                        cst.setDate(2, Date.valueOf(zviD.getDatumNarozeni()));
                        cst.setDouble(3, zviD.getVaha());
                        cst.setString(4, zviD.getPoznamka());
                        cst.setString(5, zviD.getCisloCipu());
                        cst.setInt(6, idMajitele);
                        cst.setInt(7, idPohlavi);
                        cst.setInt(8, idDruh);
                        cst.setInt(9, idDoktor);
                        cst.setInt(10, FXMLUvodniController.prihlasenyUzivatel.getId());
                    }
                    cst.executeUpdate();
                    tableViewZvirata.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chybna vstupni pole");
                    }
                }
        }
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
        chBDatum.setSelected(false);
        chBFiltr.setSelected(false);
        try {
            obnovit();
        } catch (SQLException ex) {
            zobrazErrorDialog("Chyba !", ex.getMessage());
        }
    }

    @FXML
    private void hadnleBtnNapsatZpravu(ActionEvent event) {
        CallableStatement cst = null;
        String sql;
        int idOdeslat;
        switch (comboTabulky.getValue()) {
            case Administratori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if(tableViewAdministratori.getSelectionModel().getSelectedItem() != null){
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

                        idOdeslat = -1;
                        for (Administratori admin : adminL) {
                            if (admin.getIdAdministratora() == tableViewAdministratori.getSelectionModel().getSelectedItem().getIdAdministratora()) {
                                idOdeslat = admin.getIdAdministratora();
                                break;
                            }
                        }

                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ZPRAVY(?,?,?,?,?,?)}");
                        cst.setInt(1, idOdeslat);
                        cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                        cst.setInt(3, 1);
                        cst.setInt(4, 2);

                        TextInputDialog dialog = new TextInputDialog("Zpravy");
                        dialog.getDialogPane().setMinWidth(300);
                        dialog.setTitle("Odeslani zpravy");
                        dialog.setHeaderText("Zpráva:");
                        //dialog.setContentText("zprava:");

                        // Traditional way to get the response value.
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()){
                            System.out.println("Your name: " + result.get());
                            cst.setString(5, result.get());
                        }
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());

                        cst.executeUpdate();

                        tableViewAdministratori.refresh();

                    } catch (Exception ex) {
                        if (!ex.getMessage().isEmpty()) {
                            Bezpecnost.vypisChybu(ex.getMessage());
                        } else {
                            Bezpecnost.vypisChybu("Ups, něco se nepovedlo.");
                        }
                    }
                }else{ 
                    zobrazErrorDialog("Není vybrán příjemce", "Nejprv vybe z tabulky příjemce");
                }
                break;
            
            case Doktori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if(tableViewDoktori.getSelectionModel().getSelectedItem() != null){
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
                        idOdeslat = -1;
                        for (Doktori datD : doktoriL) {
                            if (datD.getIdDoktora() == tableViewDoktori.getSelectionModel().getSelectedItem().getIdDoktora()) {
                                idOdeslat = datD.getIdDoktora();
                                break;
                            }
                        }

                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ZPRAVY(?,?,?,?,?,?)}");
                        cst.setInt(1, idOdeslat);
                        cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                        cst.setInt(3, 2);
                        cst.setInt(4, 2);

                        TextInputDialog dialog = new TextInputDialog("Zpravy");
                        dialog.getDialogPane().setMinWidth(300);
                        dialog.setTitle("Odeslani zpravy");
                        dialog.setHeaderText("Zpráva:");
                        //dialog.setContentText("zprava:");

                        // Traditional way to get the response value.
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()){
                            System.out.println("Your name: " + result.get());
                            cst.setString(5, result.get());
                        }
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());

                        cst.executeUpdate();

                        tableViewDoktori.refresh();
                    } catch (Exception ex) {
                        if (!ex.getMessage().isEmpty()) {
                            Bezpecnost.vypisChybu(ex.getMessage());
                        } else {
                            Bezpecnost.vypisChybu("Ups, něco se nepovedlo.");
                        }
                    }
                }else{ 
                    zobrazErrorDialog("Není vybrán příjemce", "Nejprv vybe z tabulky příjemce");
                }
                break;

            case Majitele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if(tableViewMajitele.getSelectionModel().getSelectedItem() != null){
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
                        idOdeslat = -1;
                        for (Majitele majD : majiteleL) {
                            if (majD.getIdMajitele() == tableViewMajitele.getSelectionModel().getSelectedItem().getIdMajitele()) {
                                idOdeslat = majD.getIdMajitele();
                                break;
                            }
                        }

                        cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ZPRAVY(?,?,?,?,?,?)}");
                        cst.setInt(1, idOdeslat);
                        cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());
                        cst.setInt(3, 3);
                        cst.setInt(4, 2);

                        TextInputDialog dialog = new TextInputDialog("Zpravy");
                        dialog.getDialogPane().setMinWidth(300);
                        dialog.setTitle("Odeslani zpravy");
                        dialog.setHeaderText("Zpráva:");
                        //dialog.setContentText("zprava:");

                        // Traditional way to get the response value.
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()){
                            System.out.println("Your name: " + result.get());
                            cst.setString(5, result.get());
                        }
                        cst.setInt(6, FXMLUvodniController.prihlasenyUzivatel.getId());

                        cst.executeUpdate();

                        tableViewMajitele.refresh();
                    } catch (Exception ex) {
                        if (!ex.getMessage().isEmpty()) {
                            Bezpecnost.vypisChybu(ex.getMessage());
                        } else {
                            Bezpecnost.vypisChybu("Ups, něco se nepovedlo.");
                        }
                    }
                }else{ 
                    zobrazErrorDialog("Není vybrán příjemce", "Nejprv vybe z tabulky příjemce");
                }
                break;
            
        }
    }
    
    //METODA PRO ZOBRAZENI NADRIZENYCH
    @FXML
    private void btnNadizeniOnAction(ActionEvent event) {
        CallableStatement cst = null;
        String sql;
        int idOdeslat;
        try {
            cst = VeterinarniKlinika.con.prepareCall("{CALL ? := NAJDINADRIZENE(?)}");
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.setInt(2, FXMLUvodniController.prihlasenyUzivatel.getId());          
            cst.executeUpdate();
            
            String s = cst.getString(1).replace(";", "\n");
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Moji nadřízení");
            alert.setHeaderText("Doktoři:");
            alert.setContentText(s);

            alert.showAndWait();

        } catch (Exception ex) {
            if (!ex.getMessage().isEmpty()) {
                Bezpecnost.vypisChybu(ex.getMessage());
            } else {
                Bezpecnost.vypisChybu("Ups, něco se nepovedlo.");
            }
        }
    }
    
    //METODA PRO ODMENENI CHUDAKU
    @FXML
    private void btnChudaciOnAction(ActionEvent event) {
        CallableStatement cst = null;
        String sql;
        int idOdeslat;
        try {
            cst = VeterinarniKlinika.con.prepareCall("{CALL ODMEN_NEJVETSI_CHUDAKY}");

            cst.executeUpdate();

        } catch (Exception ex) {
            if (!ex.getMessage().isEmpty()) {
                Bezpecnost.vypisChybu(ex.getMessage());
            } else {
                Bezpecnost.vypisChybu("Ups, něco se nepovedlo.");
            }
        }
    }
    
    //METODA PRO NALEZENI PODOBNYCH ZVIRAT
    @FXML
    private void btnNajdiPodobnaOnAction(ActionEvent event) throws SQLException {
        CallableStatement cst = null;
        String sql;
        int idHledaneho;
        int idDruhu;
        switch (comboTabulky.getValue()) {
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
                    idHledaneho = -1;
                    idDruhu = -1;
                    for (Zvirata zvD : zvirataL) {
                        if (zvD.getIdZvirete() == tableViewZvirata.getSelectionModel().getSelectedItem().getIdZvirete()) {
                            idHledaneho = zvD.getIdZvirete();
                            idDruhu = zvD.getIdDruhu();
                            break;
                        }
                    }

                    cst = VeterinarniKlinika.con.prepareCall("{CALL ZVIRATA_S_PODOBNOU_VAHOU(?,?,?)}");
                    cst.setInt(1, idHledaneho);
                    cst.setInt(2, idDruhu);
                    cst.registerOutParameter(3, Types.VARCHAR);
                    
                    cst.executeUpdate();
                    
                    String vysledek = cst.getString(3).replace(";", "\n");
                    
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Nalezená zvířata stejného druhu s podobnou váhou");
                    alert.setHeaderText("Zvířata:");
                    alert.setContentText(vysledek);

                    alert.showAndWait();
                    
                    tableViewZvirata.refresh();
                } catch (Exception ex) {
                    if (!ex.getMessage().isEmpty()) {
                        Bezpecnost.vypisChybu(ex.getMessage());
                    } else {
                        Bezpecnost.vypisChybu("Chyba při vyhledávání");
                    }
                }
        }
    }
    
    @FXML
    private void administratori_jmeno_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setJmeno(event.getNewValue());
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void administratori_prijmeni_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setPrijmeni(event.getNewValue());
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void administratori_telefon_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setTelefon(event.getNewValue());
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void administratori_email_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void administratori_prihlasovaci_jmeno_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setPrihlasovaciJmeno(event.getNewValue());
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void administratori_heslo_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            String heslo = event.getNewValue();
            if (!Bezpecnost.jeHesloDostatecne(heslo)) {
                throw new Exception("Heslo není dostatečně silné, je požadováno alespoň jedno velké písmeno, malé písmeno a číslo, minimální délka je 6 znaků !");
            }
            heslo = Bezpecnost.dejHash(heslo.getBytes());

            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setHeslo(heslo);
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void adresy_ulice_edit(TableColumn.CellEditEvent<Adresy, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdresy.getItems().get(event.getTablePosition().getRow()).setUlice(event.getNewValue());
            tableViewAdresy.refresh();
        } catch (Exception e) {
            tableViewAdresy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void adresy_cislo_popisne_edit(TableColumn.CellEditEvent<Adresy, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdresy.getItems().get(event.getTablePosition().getRow()).setCisloPopisne(event.getNewValue());
            tableViewAdresy.refresh();
        } catch (Exception e) {
            tableViewAdresy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void biochemie_urea_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
        try {
            tableViewBiochemie.getItems().get(event.getTablePosition().getRow()).setUrea(event.getNewValue());
            tableViewBiochemie.refresh();
        } catch (Exception e) {
            tableViewBiochemie.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void biochemie_kreatinin_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
        try {
            tableViewBiochemie.getItems().get(event.getTablePosition().getRow()).setKreatinin(event.getNewValue());
            tableViewBiochemie.refresh();
        } catch (Exception e) {
            tableViewBiochemie.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void biochemie_bilirubin_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
        try {
            tableViewBiochemie.getItems().get(event.getTablePosition().getRow()).setBilirubin(event.getNewValue());
            tableViewBiochemie.refresh();
        } catch (Exception e) {
            tableViewBiochemie.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void biochemie_ast_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
        try {
            tableViewBiochemie.getItems().get(event.getTablePosition().getRow()).setAst(event.getNewValue());
            tableViewBiochemie.refresh();
        } catch (Exception e) {
            tableViewBiochemie.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void biochemie_alt_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
        try {
            tableViewBiochemie.getItems().get(event.getTablePosition().getRow()).setAlt(event.getNewValue());
            tableViewBiochemie.refresh();
        } catch (Exception e) {
            tableViewBiochemie.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void diagnozy_nazev_edit(TableColumn.CellEditEvent<Diagnozy, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDiagnozy.getItems().get(event.getTablePosition().getRow()).setNazev(event.getNewValue());
            tableViewDiagnozy.refresh();
        } catch (Exception e) {
            tableViewDiagnozy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void diagnozy_oznaceni_edit(TableColumn.CellEditEvent<Diagnozy, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDiagnozy.getItems().get(event.getTablePosition().getRow()).setOznaceni(event.getNewValue());
            tableViewDiagnozy.refresh();
        } catch (Exception e) {
            tableViewDiagnozy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void diagnozy_stupen_zavaznosti_edit(TableColumn.CellEditEvent<Diagnozy, Integer> event) {
        try {
            tableViewDiagnozy.getItems().get(event.getTablePosition().getRow()).setStupenZavaznosti(event.getNewValue());
            tableViewDiagnozy.refresh();
        } catch (Exception e) {
            tableViewDiagnozy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void dodavatele_nazev_edit(TableColumn.CellEditEvent<Dodavatele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDodavatele.getItems().get(event.getTablePosition().getRow()).setNazev(event.getNewValue());
            tableViewDodavatele.refresh();
        } catch (Exception e) {
            tableViewDodavatele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void dodavatele_telefon_edit(TableColumn.CellEditEvent<Dodavatele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDodavatele.getItems().get(event.getTablePosition().getRow()).setTelefon(event.getNewValue());
            tableViewDodavatele.refresh();
        } catch (Exception e) {
            tableViewDodavatele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void dodavatele_email_edit(TableColumn.CellEditEvent<Dodavatele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDodavatele.getItems().get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
            tableViewDodavatele.refresh();
        } catch (Exception e) {
            tableViewDodavatele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_jmeno_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setJmeno(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_prijmeni_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setPrijmeni(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_titul_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setTitul(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_delka_uvazku_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setDelkaUvazku(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_datum_nastupu_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setDatumNastupu(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_plat_edit(TableColumn.CellEditEvent<Doktori, Double> event) {
        try {
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setPlat(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_datum_narozeni_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setDatumNarozeni(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_telefon_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setTelefon(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_email_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_prihlasovaci_jmeno_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setPrihlasovaciJmeno(event.getNewValue());
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void doktori_heslo_edit(TableColumn.CellEditEvent<Doktori, String> event) {
        try {
            String heslo = event.getNewValue();
            if (!Bezpecnost.jeHesloDostatecne(heslo)) {
                throw new Exception("Heslo není dostatečně silné, je požadováno alespoň jedno velké písmeno, malé písmeno a číslo, minimální délka je 6 znaků !");
            }
            heslo = Bezpecnost.dejHash(heslo.getBytes());

            tableViewDoktori.getItems().get(event.getTablePosition().getRow()).setHeslo(heslo);
            tableViewDoktori.refresh();
        } catch (Exception e) {
            tableViewDoktori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void druhy_druh_edit(TableColumn.CellEditEvent<Druhy, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewDruhy.getItems().get(event.getTablePosition().getRow()).setDruh(event.getNewValue());
            tableViewDruhy.refresh();
        } catch (Exception e) {
            tableViewDruhy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void faktury_datum_vystaveni_edit(TableColumn.CellEditEvent<Faktury, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewFaktury.getItems().get(event.getTablePosition().getRow()).setDatumVystaveni(event.getNewValue());
            tableViewFaktury.refresh();
        } catch (Exception e) {
            tableViewFaktury.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void faktury_datum_splatnosti_edit(TableColumn.CellEditEvent<Faktury, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewFaktury.getItems().get(event.getTablePosition().getRow()).setDatumSplatnosti(event.getNewValue());
            tableViewFaktury.refresh();
        } catch (Exception e) {
            tableViewFaktury.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void faktury_stav_edit(TableColumn.CellEditEvent<Faktury, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewFaktury.getItems().get(event.getTablePosition().getRow()).setStav(event.getNewValue());
            tableViewFaktury.refresh();
        } catch (Exception e) {
            tableViewFaktury.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void foto_doktoru_nazev_edit(TableColumn.CellEditEvent<FotoDoktoru, String> event) {

    }

    @FXML
    private void foto_doktoru_typ_souboru_edit(TableColumn.CellEditEvent<FotoDoktoru, String> event) {
    }

    @FXML
    private void foto_doktoru_pripona_edit(TableColumn.CellEditEvent<FotoDoktoru, String> event) {
    }

    @FXML
    private void foto_doktoru_datum_nahrani_edit(TableColumn.CellEditEvent<FotoDoktoru, String> event) {
    }

    @FXML
    private void krevni_obrazy_erytrocyty_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
        try {

            tableViewKrevniObrazy.getItems().get(event.getTablePosition().getRow()).setErytrocyty(event.getNewValue());
            tableViewKrevniObrazy.refresh();
        } catch (Exception e) {
            tableViewKrevniObrazy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void krevni_obrazy_leukocyty_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
        try {

            tableViewKrevniObrazy.getItems().get(event.getTablePosition().getRow()).setLeukocyty(event.getNewValue());
            tableViewKrevniObrazy.refresh();
        } catch (Exception e) {
            tableViewKrevniObrazy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void krevni_obrazy_trombocyty_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
        try {
            tableViewKrevniObrazy.getItems().get(event.getTablePosition().getRow()).setTrombocyty(event.getNewValue());
            tableViewKrevniObrazy.refresh();
        } catch (Exception e) {
            tableViewKrevniObrazy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void krevni_obrazy_hemoglobin_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
        try {
            tableViewKrevniObrazy.getItems().get(event.getTablePosition().getRow()).setHemoglobin(event.getNewValue());
            tableViewKrevniObrazy.refresh();
        } catch (Exception e) {
            tableViewKrevniObrazy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void leciva_nazev_edit(TableColumn.CellEditEvent<Leciva, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewLeciva.getItems().get(event.getTablePosition().getRow()).setNazev(event.getNewValue());
            tableViewLeciva.refresh();
        } catch (Exception e) {
            tableViewLeciva.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void leciva_datum_expirace_edit(TableColumn.CellEditEvent<Leciva, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewLeciva.getItems().get(event.getTablePosition().getRow()).setDatumExpirace(event.getNewValue());
            tableViewLeciva.refresh();
        } catch (Exception e) {
            tableViewLeciva.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void leciva_pocet_skladem_edit(TableColumn.CellEditEvent<Leciva, Integer> event) {
        try {

            tableViewLeciva.getItems().get(event.getTablePosition().getRow()).setPocetSkladem(event.getNewValue());
            tableViewLeciva.refresh();
        } catch (Exception e) {
            tableViewLeciva.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void leciva_popis_edit(TableColumn.CellEditEvent<Leciva, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewLeciva.getItems().get(event.getTablePosition().getRow()).setPopis(event.getNewValue());
            tableViewLeciva.refresh();
        } catch (Exception e) {
            tableViewLeciva.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_jmeno_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setJmeno(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_prijmeni_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setPrijmeni(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_datum_registrace_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setDatumRegistrace(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_datum_narozeni_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setDatumNarozeni(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_telefon_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setTelefon(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_email_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_prihlasovaci_jmeno_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setPrihlasovaciJmeno(event.getNewValue());
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void majitele_heslo_edit(TableColumn.CellEditEvent<Majitele, String> event) {
        try {
            String heslo = event.getNewValue();
            if (!Bezpecnost.jeHesloDostatecne(heslo)) {
                throw new Exception("Heslo není dostatečně silné, je požadováno alespoň jedno velké písmeno, malé písmeno a číslo, minimální délka je 6 znaků !");
            }
            heslo = Bezpecnost.dejHash(heslo.getBytes());
            tableViewMajitele.getItems().get(event.getTablePosition().getRow()).setHeslo(heslo);
            tableViewMajitele.refresh();
        } catch (Exception e) {
            tableViewMajitele.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void objednavky_pricina_edit(TableColumn.CellEditEvent<Objednavky, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewObjednavky.getItems().get(event.getTablePosition().getRow()).setPricina(event.getNewValue());
            tableViewObjednavky.refresh();
        } catch (Exception e) {
            tableViewObjednavky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void objednavky_termin_edit(TableColumn.CellEditEvent<Objednavky, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewObjednavky.getItems().get(event.getTablePosition().getRow()).setTermin(event.getNewValue());
            tableViewObjednavky.refresh();
        } catch (Exception e) {
            tableViewObjednavky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void odbery_datum_edit(TableColumn.CellEditEvent<Odbery, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewOdbery.getItems().get(event.getTablePosition().getRow()).setDatum(event.getNewValue());
            tableViewOdbery.refresh();
        } catch (Exception e) {
            tableViewOdbery.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void odbery_poznamka_edit(TableColumn.CellEditEvent<Odbery, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewOdbery.getItems().get(event.getTablePosition().getRow()).setPoznamka(event.getNewValue());
            tableViewOdbery.refresh();
        } catch (Exception e) {
            tableViewOdbery.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void operace_nazev_edit(TableColumn.CellEditEvent<Operace, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewOperace.getItems().get(event.getTablePosition().getRow()).setNazev(event.getNewValue());
            tableViewOperace.refresh();
        } catch (Exception e) {
            tableViewOperace.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void operace_oznaceni_edit(TableColumn.CellEditEvent<Operace, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewOperace.getItems().get(event.getTablePosition().getRow()).setOznaceni(event.getNewValue());
            tableViewOperace.refresh();
        } catch (Exception e) {
            tableViewOperace.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void operace_delka_edit(TableColumn.CellEditEvent<Operace, Double> event) {
        try {
            tableViewOperace.getItems().get(event.getTablePosition().getRow()).setDelka(event.getNewValue());
            tableViewOperace.refresh();
        } catch (Exception e) {
            tableViewOperace.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void operace_riziko_edit(TableColumn.CellEditEvent<Operace, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewOperace.getItems().get(event.getTablePosition().getRow()).setRiziko(event.getNewValue());
            tableViewOperace.refresh();
        } catch (Exception e) {
            tableViewOperace.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void pohlavi_pohlavi_edit(TableColumn.CellEditEvent<Pohlavi, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewPohlavi.getItems().get(event.getTablePosition().getRow()).setPohlavi(event.getNewValue());
            tableViewPohlavi.refresh();
        } catch (Exception e) {
            tableViewPohlavi.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void polozky_nazev_edit(TableColumn.CellEditEvent<Polozky, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewPolozky.getItems().get(event.getTablePosition().getRow()).setNazev(event.getNewValue());
            tableViewPolozky.refresh();
        } catch (Exception e) {
            tableViewPolozky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void polozky_pocet_edit(TableColumn.CellEditEvent<Polozky, Integer> event) {
        try {
            tableViewPolozky.getItems().get(event.getTablePosition().getRow()).setPocet(event.getNewValue());
            tableViewPolozky.refresh();
        } catch (Exception e) {
            tableViewPolozky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void polozky_cena_edit(TableColumn.CellEditEvent<Polozky, Integer> event) {
        try {
            tableViewPolozky.getItems().get(event.getTablePosition().getRow()).setCena(event.getNewValue());
            tableViewPolozky.refresh();
        } catch (Exception e) {
            tableViewPolozky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void posty_mesto_edit(TableColumn.CellEditEvent<Posty, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewPosty.getItems().get(event.getTablePosition().getRow()).setMesto(event.getNewValue());
            tableViewPosty.refresh();
        } catch (Exception e) {
            tableViewPosty.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void posty_psc_edit(TableColumn.CellEditEvent<Posty, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewPosty.getItems().get(event.getTablePosition().getRow()).setPSC(event.getNewValue());
            tableViewPosty.refresh();
        } catch (Exception e) {
            tableViewPosty.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void typy_platby_typ_edit(TableColumn.CellEditEvent<TypyPlatby, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewTypyPlatby.getItems().get(event.getTablePosition().getRow()).setTyp(event.getNewValue());
            tableViewTypyPlatby.refresh();
        } catch (Exception e) {
            tableViewTypyPlatby.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void vysetreni_datum_edit(TableColumn.CellEditEvent<Vysetreni, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewVysetreni.getItems().get(event.getTablePosition().getRow()).setDatum(event.getNewValue());
            tableViewVysetreni.refresh();
        } catch (Exception e) {
            tableViewVysetreni.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void vysetreni_poznamka_edit(TableColumn.CellEditEvent<Vysetreni, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewVysetreni.getItems().get(event.getTablePosition().getRow()).setPoznamka(event.getNewValue());
            tableViewVysetreni.refresh();
        } catch (Exception e) {
            tableViewVysetreni.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zakroky_datum_edit(TableColumn.CellEditEvent<Zakroky, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewZakroky.getItems().get(event.getTablePosition().getRow()).setDatum(event.getNewValue());
            tableViewZakroky.refresh();
        } catch (Exception e) {
            tableViewZakroky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zakroky_poznamka_edit(TableColumn.CellEditEvent<Zakroky, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewZakroky.getItems().get(event.getTablePosition().getRow()).setPoznamka(event.getNewValue());
            tableViewZakroky.refresh();
        } catch (Exception e) {
            tableViewZakroky.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zvirata_jmeno_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewZvirata.getItems().get(event.getTablePosition().getRow()).setJmeno(event.getNewValue());
            tableViewZvirata.refresh();
        } catch (Exception e) {
            tableViewZvirata.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zvirata_datum_narozeni_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewZvirata.getItems().get(event.getTablePosition().getRow()).setDatumNarozeni(event.getNewValue());
            tableViewZvirata.refresh();
        } catch (Exception e) {
            tableViewZvirata.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zvirata_vaha_edit(TableColumn.CellEditEvent<Zvirata, Double> event) {
        try {
            tableViewZvirata.getItems().get(event.getTablePosition().getRow()).setVaha(event.getNewValue());
            tableViewZvirata.refresh();
        } catch (Exception e) {
            tableViewZvirata.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zvirata_poznamka_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewZvirata.getItems().get(event.getTablePosition().getRow()).setPoznamka(event.getNewValue());
            tableViewZvirata.refresh();
        } catch (Exception e) {
            tableViewZvirata.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void zvirata_cislo_cipu_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewZvirata.getItems().get(event.getTablePosition().getRow()).setCisloCipu(event.getNewValue());
            tableViewZvirata.refresh();
        } catch (Exception e) {
            tableViewZvirata.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void administratori_datum_narozeni_edit(TableColumn.CellEditEvent<Administratori, String> event) {
        try {
            if (Bezpecnost.obsahujeNebezpecneZnaky(event.getNewValue())) {
                throw new Exception("Obsahuje nebezpecne znaky");
            }
            tableViewAdministratori.getItems().get(event.getTablePosition().getRow()).setDatumNarozeni(event.getNewValue());
            tableViewAdministratori.refresh();
        } catch (Exception e) {
            tableViewAdministratori.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

}
