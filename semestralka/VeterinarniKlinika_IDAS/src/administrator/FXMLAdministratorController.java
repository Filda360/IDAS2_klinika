package administrator;

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
import dataTridy.Zvirata;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
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
import javafx.util.converter.IntegerStringConverter;
import oracle.net.ns.NetException;
import prihlasovani.PrihlasenyUzivatel;
import utils.ComboBoxy;
import utils.enumTabulky;
import utils.enumUzivatel;
import veterinarniklinika.Bezpecnost;
import veterinarniklinika.FXMLUvodniController;
import veterinarniklinika.VeterinarniKlinika;

public class FXMLAdministratorController implements Initializable {

    @FXML
    private ComboBox<enumTabulky> comboTabulky;
    @FXML
    private Button btnMojeUdaje;
    @FXML
    private Button btnOdhlasit;

    @FXML
    private ComboBox<enumUzivatel> comboTypUzivatele;
    @FXML
    private ComboBox<?> comboUzivatel;
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
    @FXML
    private TableColumn<Administratori, String> administratori_heslo;
    @FXML
    private TableColumn<Administratori, ComboBox> administratori_adresa;
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
    @FXML
    private TableColumn<Majitele, String> majitele_heslo;
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

    public ObservableList<Administratori> administratoriData = FXCollections.observableArrayList();
    public ObservableList<Adresy> adresyData = FXCollections.observableArrayList();
    public ObservableList<Biochemie> biochemieData = FXCollections.observableArrayList();
    public ObservableList<Diagnozy> diagnozyData = FXCollections.observableArrayList();
    public ObservableList<Dodavatele> dodavateleData = FXCollections.observableArrayList();
    public ObservableList<Doktori> doktoriData = FXCollections.observableArrayList();
    public ObservableList<Druhy> druhyData = FXCollections.observableArrayList();
    public ObservableList<Faktury> fakturyData = FXCollections.observableArrayList();
    public ObservableList<FotoDoktoru> fotoDoktoruData = FXCollections.observableArrayList();
    public ObservableList<KrevniObrazy> krevniObrazyData = FXCollections.observableArrayList();
    public ObservableList<Leciva> lecivaData = FXCollections.observableArrayList();
    public ObservableList<LogTable> logTableData = FXCollections.observableArrayList();
    public ObservableList<Majitele> majiteleData = FXCollections.observableArrayList();
    public ObservableList<Objednavky> objednavkyData = FXCollections.observableArrayList();
    public ObservableList<Odbery> odberyData = FXCollections.observableArrayList();
    public ObservableList<Operace> operaceData = FXCollections.observableArrayList();
    public ObservableList<Pohlavi> pohlaviData = FXCollections.observableArrayList();
    public ObservableList<Polozky> polozkyData = FXCollections.observableArrayList();
    public ObservableList<Posty> postyData = FXCollections.observableArrayList();
    public ObservableList<TypyPlatby> typyPlatbyData = FXCollections.observableArrayList();
    public ObservableList<Vysetreni> vysetreniData = FXCollections.observableArrayList();
    public ObservableList<Zakroky> zakrokyData = FXCollections.observableArrayList();
    public ObservableList<Zvirata> zvirataData = FXCollections.observableArrayList();
    //comboboxy 

    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboTabulky.setItems(FXCollections.observableArrayList(enumTabulky.values()));
        comboTabulky.getSelectionModel().selectFirst();
//        comboUzivatel.setItems(FXCollections.observableArrayList(enumUzivatel.values()));
//        comboUzivatel.getSelectionModel().selectFirst();
        comboTypUzivatele.setItems(FXCollections.observableArrayList(enumUzivatel.values()));
        comboTypUzivatele.getSelectionModel().selectFirst();

        tableViewAdministratori.setItems(administratoriData);
        administratori_jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        administratori_prijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        administratori_datum_narozeni.setCellValueFactory(new PropertyValueFactory<>("datumNarozeni"));
        administratori_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        administratori_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        administratori_prihlasovaci_jmeno.setCellValueFactory(new PropertyValueFactory<>("prihlasovaciJmeno"));
        administratori_heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
        administratori_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewAdministratori.setEditable(true);

        administratori_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_prijmeni.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_email.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_prihlasovaci_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        administratori_heslo.setCellFactory(TextFieldTableCell.forTableColumn());

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
        doktori_plat.setCellValueFactory(new PropertyValueFactory<>("plat"));
        doktori_jmeno.setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        doktori_prijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        doktori_datum_narozeni.setCellValueFactory(new PropertyValueFactory<>("datumNarozeni"));
        doktori_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        doktori_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        doktori_heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
        doktori_prihlasovaci_jmeno.setCellValueFactory(new PropertyValueFactory<>("prihlasovaciJmeno"));
        doktori_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewDoktori.setEditable(true);

        doktori_titul.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_delka_uvazku.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_datum_nastupu.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_plat.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        doktori_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_prijmeni.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_email.setCellFactory(TextFieldTableCell.forTableColumn());
        doktori_heslo.setCellFactory(TextFieldTableCell.forTableColumn());
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
        majitele_heslo.setCellValueFactory(new PropertyValueFactory<>("heslo"));
        majitele_prihlasovaci_jmeno.setCellValueFactory(new PropertyValueFactory<>("prihlasovaciJmeno"));
        majitele_adresa.setCellValueFactory(new PropertyValueFactory<>("adresy"));
        tableViewMajitele.setEditable(true);

        majitele_datum_registrace.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_prijmeni.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_email.setCellFactory(TextFieldTableCell.forTableColumn());
        majitele_heslo.setCellFactory(TextFieldTableCell.forTableColumn());
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
                tableViewAdministratori.setVisible(true);
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
                            break;
                        }
                    }
                    administratoriData.add(ad);
                }
                tableViewAdministratori.refresh();
                break;
            case Adresy:
                ///////////////////////////////////////////////////////////////////////
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
                sql = "SELECT * FROM PO_ADRESY";
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
                tableViewZvirata.setVisible(false);

                adresyData.clear();
                sql = "SELECT * FROM PO_DIAGNOZY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    Diagnozy di = new Diagnozy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    diagnozyData.add(di);
                }
                tableViewDiagnozy.refresh();
                break;
            case Dodavatele:
                ///////////////////////////////////////////////////////////////////////
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
                sql = "SELECT * FROM PO_DODAVATELE";
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
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(true);
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
                tableViewZvirata.setVisible(false);
                ObservableList<Adresy> cbAdresyData2 = FXCollections.observableArrayList();
                doktoriData.clear();
                cbAdresyData2.clear();
                sql = "SELECT * FROM PO_ADRESY";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Adresy ad = new Adresy(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), null);
                    cbAdresyData2.add(ad);
                }
                sql = "SELECT * FROM PO_DOKTORI";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Adresy> cbAdresy = new ComboBox<Adresy>();
                    cbAdresy.setItems(cbAdresyData2);
                    Doktori dok = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getDate(4).toString(), rs.getDouble(5), rs.getString(6), rs.getString(7),
                            rs.getDate(8).toString(), rs.getString(9), rs.getString(10), rs.getInt(11),
                            rs.getString(12), rs.getString(13), cbAdresy);
                    for (Adresy adresa : cbAdresyData2) {
                        if (adresa.getIdAdresy() == dok.getIdAdresy()) {
                            cbAdresy.getSelectionModel().select(adresa);
                            break;
                        }
                    }
                    doktoriData.add(dok);
                }
                tableViewDoktori.refresh();
                break;
            case Druhy:
                ///////////////////////////////////////////////////////////////////////
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
                tableViewZvirata.setVisible(false);

                druhyData.clear();

                sql = "SELECT * FROM PO_DRUHY";
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
                sql = "SELECT * FROM PO_FAKTURY";
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
            case FotoDoktoru:
                ///////////////////////////////////////////////////////////////////////
                tableViewAdministratori.setVisible(false);
                tableViewAdresy.setVisible(false);
                tableViewBiochemie.setVisible(false);
                tableViewDiagnozy.setVisible(false);
                tableViewDodavatele.setVisible(false);
                tableViewDoktori.setVisible(false);
                tableViewDruhy.setVisible(false);
                tableViewFaktury.setVisible(false);
                tableViewFotoDoktoru.setVisible(true);
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
                tableViewZvirata.setVisible(false);
                ObservableList<Doktori> cbDoktoriData = FXCollections.observableArrayList();
                cbDoktoriData.clear();
                fotoDoktoruData.clear();

                sql = "SELECT * FROM PO_DOKTORI";

                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Doktori dok = new Doktori(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getDate(4).toString(), rs.getDouble(5), rs.getString(6), rs.getString(7),
                            rs.getDate(8).toString(), rs.getString(9), rs.getString(10), rs.getInt(11),
                            rs.getString(12), rs.getString(13), null);
                    cbDoktoriData.add(dok);
                }
                sql = "SELECT * FROM PO_FOTO_DOKTORU";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Doktori> cbDoktori = new ComboBox<Doktori>();
                    cbDoktori.setItems(cbDoktoriData);

                    FotoDoktoru fot = new FotoDoktoru(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getDate(5).toString(), "(Blob)", rs.getInt(7), cbDoktori);
                    for (Doktori doktor : cbDoktoriData) {
                        if (doktor.getIdDoktora() == fot.getIdDoktora()) {
                            cbDoktori.getSelectionModel().select(doktor);
                            break;
                        }
                    }
                    fotoDoktoruData.add(fot);
                }
                tableViewFotoDoktoru.refresh();
                break;
            case KrevniObrazy:
                ///////////////////////////////////////////////////////////////////////
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
                sql = "SELECT * FROM PO_LECIVA";
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
            case LogTable:
                ///////////////////////////////////////////////////////////////////////
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
                tableViewLogTable.setVisible(true);
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
                tableViewZvirata.setVisible(false);

                logTableData.clear();

                sql = "SELECT * FROM PO_LOG_TABLE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    LogTable data = new LogTable(rs.getString(1), rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getInt(5), rs.getInt(6));

                    logTableData.add(data);
                }
                tableViewLogTable.refresh();
                break;
            case Majitele:
                ///////////////////////////////////////////////////////////////////////
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
                tableViewObjednavky.setVisible(false);
                tableViewOdbery.setVisible(false);
                tableViewOperace.setVisible(false);
                tableViewPohlavi.setVisible(false);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
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
                sql = "SELECT * FROM PO_MAJITELE";
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
                            break;
                        }
                    }
                    majiteleData.add(maj);
                }
                tableViewMajitele.refresh();
                break;
            case Objednavky:
                ///////////////////////////////////////////////////////////////////////
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

                sql = "SELECT * FROM PO_OBJEDNAVKY";
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
                sql = "SELECT * FROM PO_ODBERY";
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
                tableViewZvirata.setVisible(false);

                operaceData.clear();

                sql = "SELECT * FROM PO_OPERACE";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    Operace op = new Operace(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
                    operaceData.add(op);
                }
                tableViewOperace.refresh();
                break;
            case Pohlavi:
                ///////////////////////////////////////////////////////////////////////
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
                tableViewPohlavi.setVisible(true);
                tableViewPolozky.setVisible(false);
                tableViewPosty.setVisible(false);
                tableViewTypyPlatby.setVisible(false);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZvirata.setVisible(false);

                operaceData.clear();

                sql = "SELECT * FROM PO_POHLAVI";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    Pohlavi po = new Pohlavi(rs.getInt(1), rs.getString(2));
                    pohlaviData.add(po);
                }
                tableViewPohlavi.refresh();
                break;
            case Polozky:
                ///////////////////////////////////////////////////////////////////////
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
                sql = "SELECT * FROM PO_POLOZKY";
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
                tableViewZvirata.setVisible(false);

                postyData.clear();

                sql = "SELECT * FROM PO_POSTY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    Posty po = new Posty(rs.getInt(1), rs.getString(2), rs.getString(3));
                    postyData.add(po);
                }
                tableViewPosty.refresh();
                break;
            case TypyPlatby:
                ///////////////////////////////////////////////////////////////////////
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
                tableViewTypyPlatby.setVisible(true);
                tableViewVysetreni.setVisible(false);
                tableViewZakroky.setVisible(false);
                tableViewZvirata.setVisible(false);

                typyPlatbyData.clear();

                sql = "SELECT * FROM PO_TYPY_PLATBY";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {

                    TypyPlatby typ = new TypyPlatby(rs.getInt(1), rs.getString(2));
                    typyPlatbyData.add(typ);
                }
                tableViewTypyPlatby.refresh();
                break;
            case Vysetreni:
                ///////////////////////////////////////////////////////////////////////
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

                sql = "SELECT * FROM PO_VYSETRENI";
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

                sql = "SELECT * FROM PO_ZAKROKY";
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
            case Zvirata:
                ///////////////////////////////////////////////////////////////////////
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
                tableViewZvirata.setVisible(true);
                ObservableList<Majitele> cbMajiteleData3 = FXCollections.observableArrayList();
                ObservableList<Pohlavi> cbPohlaviData = FXCollections.observableArrayList();
                ObservableList<Druhy> cbDruhyData = FXCollections.observableArrayList();
                ObservableList<Doktori> cbDoktoriData2 = FXCollections.observableArrayList();
                zvirataData.clear();
                cbMajiteleData3.clear();
                cbPohlaviData.clear();
                cbDruhyData.clear();
                cbDoktoriData2.clear();

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
                            rs.getString(12), rs.getString(13), null);
                    cbDoktoriData2.add(dok);
                }

                sql = "SELECT * FROM PO_ZVIRATA";
                pstmt = VeterinarniKlinika.con.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ComboBox<Majitele> cbMajitele = new ComboBox<Majitele>();
                    cbMajitele.setItems(cbMajiteleData3);

                    ComboBox<Pohlavi> cbPohlavi = new ComboBox<Pohlavi>();
                    cbPohlavi.setItems(cbPohlaviData);

                    ComboBox<Druhy> cbDruhy = new ComboBox<Druhy>();
                    cbDruhy.setItems(cbDruhyData);

                    ComboBox<Doktori> cbDoktori = new ComboBox<Doktori>();
                    cbDoktori.setItems(cbDoktoriData2);

                    Zvirata zv = new Zvirata(rs.getInt(1), rs.getString(2), rs.getDate(3).toString(),
                            rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7),
                            rs.getInt(8), rs.getInt(9), rs.getInt(10), cbMajitele, cbPohlavi, cbDruhy, cbDoktori);

                    for (Majitele majitel : cbMajiteleData3) {
                        if (majitel.getIdMajitele() == zv.getIdMajitele()) {
                            cbMajitele.getSelectionModel().select(majitel);
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

                    for (Doktori doktor : cbDoktoriData2) {
                        if (doktor.getIdDoktora() == zv.getIdDoktora()) {
                            cbDoktori.getSelectionModel().select(doktor);
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
    private void button_pridat(ActionEvent event) throws SQLException {
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
                Adresy data = new Adresy(-1, "", "", -1, cbPosty);
                adresyData.add(data);
                tableViewAdresy.refresh();
                tableViewAdresy.getSelectionModel().select(data);
                break;
            case Biochemie:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Diagnozy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Dodavatele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Doktori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Druhy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Faktury:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case FotoDoktoru:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case KrevniObrazy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Leciva:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case LogTable:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Majitele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Objednavky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Odbery:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Operace:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Pohlavi:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Polozky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Posty:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case TypyPlatby:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Vysetreni:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Zakroky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Zvirata:
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }

    @FXML
    private void button_odebrat(ActionEvent event) throws SQLException {
        CallableStatement cst = null;
        String sql;
        int idVymazat;
        switch (comboTabulky.getValue()) {
            case Administratori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

                cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ADMINISTRATORI(?)}");
                cst.setInt(1, idVymazat);
                cst.executeUpdate();
                administratoriData.remove(tableViewAdministratori.getSelectionModel().getSelectedItem());
                tableViewAdministratori.refresh();
                break;
            case Adresy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

                cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_DEL_ADRESY(?)}");
                cst.setInt(1, idVymazat);
                cst.executeUpdate();
                adresyData.remove(tableViewAdresy.getSelectionModel().getSelectedItem());
                tableViewAdresy.refresh();
                break;
            case Biochemie:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Diagnozy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Dodavatele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Doktori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Druhy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Faktury:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case FotoDoktoru:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case KrevniObrazy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Leciva:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case LogTable:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Majitele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Objednavky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Odbery:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Operace:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Pohlavi:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Polozky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Posty:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case TypyPlatby:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Vysetreni:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Zakroky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Zvirata:
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }

    @FXML
    private void button_ulozit(ActionEvent event) throws SQLException, Exception {
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
                System.out.println(Date.valueOf(ad.getDatumNarozeni()));
                if (jePritomny) {
                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_EDIT_ADMINISTRATORI(?,?,?,?,?,?,?,?,?)}");
                    cst.setInt(1, ad.getIdAdministratora());
                    cst.setString(2, ad.getJmeno());
                    cst.setString(3, ad.getPrijmeni());
                    cst.setDate(4, Date.valueOf(ad.getDatumNarozeni()));
                    cst.setString(5, ad.getTelefon());
                    cst.setString(6, ad.getEmail());
                    cst.setInt(7, idAdresy);
                    cst.setString(8, ad.getPrihlasovaciJmeno());
                    cst.setString(9, ad.getHeslo());
                } else {

                    cst = VeterinarniKlinika.con.prepareCall("{CALL PROC_ADD_ADMINISTRATORI(?,?,?,?,?,?,?,?)}");

                    cst.setString(1, ad.getJmeno());
                    cst.setString(2, ad.getPrijmeni());
                    cst.setDate(3, Date.valueOf(ad.getDatumNarozeni()));
                    cst.setString(4, ad.getTelefon());
                    cst.setString(5, ad.getEmail());
                    cst.setInt(6, idAdresy);
                    cst.setString(7, ad.getPrihlasovaciJmeno());
                    cst.setString(8, ad.getHeslo());
                }
                cst.executeUpdate();
                tableViewAdministratori.refresh();
                } catch (Exception ex) {
                    if(!ex.getMessage().isEmpty()){
                    Bezpecnost.vypisChybu(ex.getMessage());
                    }else{
                    Bezpecnost.vypisChybu("Chybna vstupni pole");
                    }
                }
                break;
            case Adresy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Biochemie:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Diagnozy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Dodavatele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Doktori:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Druhy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Faktury:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case FotoDoktoru:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case KrevniObrazy:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Leciva:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case LogTable:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Majitele:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Objednavky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Odbery:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Operace:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Pohlavi:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Polozky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Posty:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case TypyPlatby:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Vysetreni:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Zakroky:
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                break;
            case Zvirata:
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
            tableViewAdresy.getItems().get(event.getTablePosition().getRow()).setUlice(event.getNewValue());
            tableViewAdresy.refresh();
        } catch (Exception e) {
            tableViewAdresy.refresh();
            Bezpecnost.vypisChybu(e.getMessage());
        }
    }

    @FXML
    private void biochemie_urea_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
    }

    @FXML
    private void biochemie_kreatinin_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
    }

    @FXML
    private void biochemie_bilirubin_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
    }

    @FXML
    private void biochemie_ast_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
    }

    @FXML
    private void biochemie_alt_edit(TableColumn.CellEditEvent<Biochemie, Double> event) {
    }

    @FXML
    private void diagnozy_nazev_edit(TableColumn.CellEditEvent<Diagnozy, String> event) {
    }

    @FXML
    private void diagnozy_oznaceni_edit(TableColumn.CellEditEvent<Diagnozy, String> event) {
    }

    @FXML
    private void diagnozy_stupen_zavaznosti_edit(TableColumn.CellEditEvent<Diagnozy, Integer> event) {
    }

    @FXML
    private void dodavatele_nazev_edit(TableColumn.CellEditEvent<Dodavatele, String> event) {
    }

    @FXML
    private void dodavatele_telefon_edit(TableColumn.CellEditEvent<Dodavatele, String> event) {
    }

    @FXML
    private void dodavatele_email_edit(TableColumn.CellEditEvent<Dodavatele, String> event) {
    }

    @FXML
    private void doktori_jmeno_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_prijmeni_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_titul_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_delka_uvazku_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_datum_nastupu_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_plat_edit(TableColumn.CellEditEvent<Doktori, Integer> event) {
    }

    @FXML
    private void doktori_datum_narozeni_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_telefon_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_email_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_prihlasovaci_jmeno_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void doktori_heslo_edit(TableColumn.CellEditEvent<Doktori, String> event) {
    }

    @FXML
    private void druhy_druh_edit(TableColumn.CellEditEvent<Druhy, String> event) {
    }

    @FXML
    private void faktury_datum_vystaveni_edit(TableColumn.CellEditEvent<Faktury, String> event) {
    }

    @FXML
    private void faktury_datum_splatnosti_edit(TableColumn.CellEditEvent<Faktury, String> event) {
    }

    @FXML
    private void faktury_stav_edit(TableColumn.CellEditEvent<Faktury, String> event) {
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
    }

    @FXML
    private void krevni_obrazy_leukocyty_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
    }

    @FXML
    private void krevni_obrazy_trombocyty_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
    }

    @FXML
    private void krevni_obrazy_hemoglobin_edit(TableColumn.CellEditEvent<KrevniObrazy, Double> event) {
    }

    @FXML
    private void leciva_nazev_edit(TableColumn.CellEditEvent<Leciva, String> event) {
    }

    @FXML
    private void leciva_datum_expirace_edit(TableColumn.CellEditEvent<Leciva, String> event) {
    }

    @FXML
    private void leciva_pocet_skladem_edit(TableColumn.CellEditEvent<Leciva, Integer> event) {
    }

    @FXML
    private void leciva_popis_edit(TableColumn.CellEditEvent<Leciva, String> event) {
    }

    @FXML
    private void majitele_jmeno_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_prijmeni_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_datum_registrace_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_datum_narozeni_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_telefon_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_email_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_prihlasovaci_jmeno_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void majitele_heslo_edit(TableColumn.CellEditEvent<Majitele, String> event) {
    }

    @FXML
    private void objednavky_pricina_edit(TableColumn.CellEditEvent<Objednavky, String> event) {
    }

    @FXML
    private void objednavky_termin_edit(TableColumn.CellEditEvent<Objednavky, String> event) {
    }

    @FXML
    private void odbery_datum_edit(TableColumn.CellEditEvent<Odbery, String> event) {
    }

    @FXML
    private void odbery_poznamka_edit(TableColumn.CellEditEvent<Odbery, String> event) {
    }

    @FXML
    private void operace_nazev_edit(TableColumn.CellEditEvent<Operace, String> event) {
    }

    @FXML
    private void operace_oznaceni_edit(TableColumn.CellEditEvent<Operace, String> event) {
    }

    @FXML
    private void operace_delka_edit(TableColumn.CellEditEvent<Operace, Double> event) {
    }

    @FXML
    private void operace_riziko_edit(TableColumn.CellEditEvent<Operace, String> event) {
    }

    @FXML
    private void pohlavi_pohlavi_edit(TableColumn.CellEditEvent<Pohlavi, String> event) {
    }

    @FXML
    private void polozky_nazev_edit(TableColumn.CellEditEvent<Polozky, String> event) {
    }

    @FXML
    private void polozky_pocet_edit(TableColumn.CellEditEvent<Polozky, Integer> event) {
    }

    @FXML
    private void polozky_cena_edit(TableColumn.CellEditEvent<Polozky, Integer> event) {
    }

    @FXML
    private void posty_mesto_edit(TableColumn.CellEditEvent<Posty, String> event) {
    }

    @FXML
    private void posty_psc_edit(TableColumn.CellEditEvent<Posty, String> event) {
    }

    @FXML
    private void typy_platby_typ_edit(TableColumn.CellEditEvent<TypyPlatby, String> event) {
    }

    @FXML
    private void vysetreni_datum_edit(TableColumn.CellEditEvent<Vysetreni, String> event) {
    }

    @FXML
    private void vysetreni_poznamka_edit(TableColumn.CellEditEvent<Vysetreni, String> event) {
    }

    @FXML
    private void zakroky_datum_edit(TableColumn.CellEditEvent<Zakroky, String> event) {
    }

    @FXML
    private void zakroky_poznamka_edit(TableColumn.CellEditEvent<Zakroky, String> event) {
    }

    @FXML
    private void zvirata_jmeno_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
    }

    @FXML
    private void zvirata_datum_narozeni_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
    }

    @FXML
    private void zvirata_vaha_edit(TableColumn.CellEditEvent<Zvirata, Double> event) {
    }

    @FXML
    private void zvirata_poznamka_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
    }

    @FXML
    private void zvirata_cislo_cipu_edit(TableColumn.CellEditEvent<Zvirata, String> event) {
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
