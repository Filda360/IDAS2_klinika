/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktor;

import dataTridy.OdberyOld;
import dataTridy.VysetreniOld;
import dataTridy.ZakrokOld;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import veterinarniklinika.FXMLUvodniController;
import veterinarniklinika.VeterinarniKlinika;

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
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_datum;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_poznamka;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_jmeno;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_druh;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_pohlavi;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_datum_narozeni;
    @FXML
    private TableColumn<ZakrokOld, Double> zakroky_vaha;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_poznamka_zvirete;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_typ_operace;
    @FXML
    private TableColumn<ZakrokOld, Double> zakroky_delka_operace;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_jmeno_lekare;
    @FXML
    private TableColumn<ZakrokOld, String> zakroky_prijmeni_lekare;
    
     @FXML
    private RadioButton rBtnZapniFiltry;
    @FXML
    private TableView<ZakrokOld> tableViewZakroky;
    
    @FXML
    private TableColumn<OdberyOld, String> odbery_datum;
    @FXML
    private TableColumn<OdberyOld, String> odbery_poznamka;
    @FXML
    private TableColumn<OdberyOld, String> odbery_jmeno;
    @FXML
    private TableColumn<OdberyOld, String> odbery_druh;
    @FXML
    private TableColumn<OdberyOld, String> odbery_pohlavi;
    @FXML
    private TableColumn<OdberyOld, String> odbery_datum_narozeni;
    @FXML
    private TableColumn<OdberyOld, Double> odbery_vaha;
    @FXML
    private TableColumn<OdberyOld, String> odbery_poznamka_zvirete;
    @FXML
    private TableColumn<OdberyOld, String> odbery_jmeno_lekare;
    @FXML
    private TableColumn<OdberyOld, String> odbery_prijmeni_lekare;
    
    public static ObservableList<ZakrokOld> zakrokData = FXCollections.observableArrayList();
    public static ObservableList<VysetreniOld> vysetreniData = FXCollections.observableArrayList();
    public static ObservableList<OdberyOld> odberyData = FXCollections.observableArrayList();
    
    private PreparedStatement pstmt=null;
    private ResultSet rs=null; 
    @FXML
    private TableView<VysetreniOld> tableViewVysetreni;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_datum;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_poznamka;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_diagnoza;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_oznaceni;
    @FXML
    private TableColumn<VysetreniOld, Integer> vysetreni_stupen_zavaznosti;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_jmeno;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_druh;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_pohlavi;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_datum_narozeni;
    @FXML
    private TableColumn<VysetreniOld, Double> vysetreni_vaha;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_poznamka_zvirete;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_jmeno_lekare;
    @FXML
    private TableColumn<VysetreniOld, String> vysetreni_prijmeni_lekare;
    @FXML
    private TableView<OdberyOld> tableViewOdbery;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableViewZakroky.setItems(zakrokData);
        zakroky_datum.setCellValueFactory(new PropertyValueFactory("datum"));
        zakroky_poznamka.setCellValueFactory(new PropertyValueFactory("poznamka"));
        zakroky_jmeno.setCellValueFactory(new PropertyValueFactory("jmeno"));
        zakroky_druh.setCellValueFactory(new PropertyValueFactory("druh"));
        zakroky_pohlavi.setCellValueFactory(new PropertyValueFactory("pohlavi"));
        zakroky_datum_narozeni.setCellValueFactory(new PropertyValueFactory("datumNarozeni"));
        zakroky_vaha.setCellValueFactory(new PropertyValueFactory("vaha"));
        zakroky_poznamka_zvirete.setCellValueFactory(new PropertyValueFactory("zvirePoznamka"));
        zakroky_typ_operace.setCellValueFactory(new PropertyValueFactory("typOperace"));
        zakroky_delka_operace.setCellValueFactory(new PropertyValueFactory("delkaOperace"));
        zakroky_jmeno_lekare.setCellValueFactory(new PropertyValueFactory("jmenoLekare"));
        zakroky_prijmeni_lekare.setCellValueFactory(new PropertyValueFactory("prijmeniLekare"));

        tableViewZakroky.setEditable(true);
        zakroky_vaha.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        zakroky_datum.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_druh.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_pohlavi.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_poznamka_zvirete.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_typ_operace.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_jmeno_lekare.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_prijmeni_lekare.setCellFactory(TextFieldTableCell.forTableColumn());
        zakroky_delka_operace.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        
        tableViewVysetreni.setItems(vysetreniData);
        vysetreni_datum.setCellValueFactory(new PropertyValueFactory("datum"));
        vysetreni_poznamka.setCellValueFactory(new PropertyValueFactory("poznamka"));
        vysetreni_diagnoza.setCellValueFactory(new PropertyValueFactory("nazev"));
        vysetreni_oznaceni.setCellValueFactory(new PropertyValueFactory("oznaceni"));
        vysetreni_stupen_zavaznosti.setCellValueFactory(new PropertyValueFactory("stupenZavaznosti"));
        vysetreni_jmeno.setCellValueFactory(new PropertyValueFactory("jmeno"));
        vysetreni_druh.setCellValueFactory(new PropertyValueFactory("druh"));
        vysetreni_pohlavi.setCellValueFactory(new PropertyValueFactory("pohlavi"));
        vysetreni_datum_narozeni.setCellValueFactory(new PropertyValueFactory("datumNarozeni"));
        vysetreni_vaha.setCellValueFactory(new PropertyValueFactory("vaha"));
        vysetreni_poznamka_zvirete.setCellValueFactory(new PropertyValueFactory("zvirePoznamka"));
        vysetreni_jmeno_lekare.setCellValueFactory(new PropertyValueFactory("jmenoLekare"));
        vysetreni_prijmeni_lekare.setCellValueFactory(new PropertyValueFactory("prijmeniLekare"));

        tableViewVysetreni.setEditable(true);
        vysetreni_vaha.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        vysetreni_datum.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_diagnoza.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_oznaceni.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_stupen_zavaznosti.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        vysetreni_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_druh.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_pohlavi.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_poznamka_zvirete.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_jmeno_lekare.setCellFactory(TextFieldTableCell.forTableColumn());
        vysetreni_prijmeni_lekare.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tableViewOdbery.setItems(odberyData);
        odbery_datum.setCellValueFactory(new PropertyValueFactory("datum"));
        odbery_poznamka.setCellValueFactory(new PropertyValueFactory("poznamka"));
        odbery_jmeno.setCellValueFactory(new PropertyValueFactory("jmeno"));
        odbery_druh.setCellValueFactory(new PropertyValueFactory("druh"));
        odbery_pohlavi.setCellValueFactory(new PropertyValueFactory("pohlavi"));
        odbery_datum_narozeni.setCellValueFactory(new PropertyValueFactory("datumNarozeni"));
        odbery_vaha.setCellValueFactory(new PropertyValueFactory("vaha"));
        odbery_poznamka_zvirete.setCellValueFactory(new PropertyValueFactory("zvirePoznamka"));
        odbery_jmeno_lekare.setCellValueFactory(new PropertyValueFactory("jmenoLekare"));
        odbery_prijmeni_lekare.setCellValueFactory(new PropertyValueFactory("prijmeniLekare"));

        tableViewOdbery.setEditable(true);
        odbery_vaha.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        odbery_datum.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_poznamka.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_jmeno.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_druh.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_pohlavi.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_datum_narozeni.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_poznamka_zvirete.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_jmeno_lekare.setCellFactory(TextFieldTableCell.forTableColumn());
        odbery_prijmeni_lekare.setCellFactory(TextFieldTableCell.forTableColumn());
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
    private void handleBtnZakrokyOnAction(ActionEvent event) throws SQLException {
        tableViewOdbery.setVisible(false);
        tableViewVysetreni.setVisible(false);
        tableViewZakroky.setVisible(true);
        
    
    zakrokData.clear();
    String sql;
    if(tfJmenoZvirete.getText().isEmpty() || !rBtnZapniFiltry.isSelected()){
        sql = "SELECT * FROM P_ZAKROKY";
    }else{ 
        sql = "SELECT * FROM P_ZAKROKY WHERE JMENO LIKE '" + tfJmenoZvirete.getText() + "'";
    }
        
    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
    rs = pstmt.executeQuery();
    while(rs.next()){
    ZakrokOld za = new ZakrokOld(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),
            rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),
            rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getInt(17),
            rs.getString(18),rs.getString(19),rs.getInt(20),rs.getString(21),rs.getString(22),rs.getInt(23),
            rs.getString(24),rs.getInt(25),rs.getString(26),rs.getInt(27),rs.getString(28),rs.getString(29),
            rs.getString(30),rs.getDouble(31),rs.getString(32),rs.getString(33),rs.getString(34),rs.getString(35),
            rs.getString(36),rs.getInt(37),rs.getString(38),rs.getString(39),rs.getInt(40),rs.getString(41),
            rs.getString(42),rs.getInt(43),rs.getString(44),rs.getString(45),rs.getDouble(46),rs.getString(47));   
    zakrokData.add(za);
    }
    tableViewZakroky.refresh();
    }

    @FXML
    private void handleBtnOdberyOnAction(ActionEvent event) throws SQLException {
    tableViewOdbery.setVisible(true);
        tableViewVysetreni.setVisible(false);
        tableViewZakroky.setVisible(false);
        
    odberyData.clear();
    String sql;
    if(tfJmenoZvirete.getText().isEmpty() || !rBtnZapniFiltry.isSelected()){
        sql = "SELECT * FROM P_ODBERY";
    }else{ 
        sql = "SELECT * FROM P_ODBERY WHERE JMENO LIKE '" + tfJmenoZvirete.getText() + "'";
    }
        
    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
    rs = pstmt.executeQuery();
    while(rs.next()){
    OdberyOld od = new OdberyOld(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),
            rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),
            rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getInt(17),
            rs.getString(18),rs.getString(19),rs.getInt(20),rs.getString(21),rs.getString(22),rs.getInt(23),
            rs.getString(24),rs.getInt(25),rs.getString(26),rs.getInt(27),rs.getString(28),rs.getString(29),
            rs.getString(30),rs.getDouble(31),rs.getString(32),rs.getString(33),rs.getString(34),rs.getString(35),
            rs.getString(36),rs.getInt(37),rs.getString(38),rs.getString(39),rs.getInt(40),rs.getString(41),
            rs.getString(42));   
    odberyData.add(od);
    }
    tableViewOdbery.refresh();
    
    }

    @FXML
    private void handleBtnVysetreniOnAction(ActionEvent event) throws SQLException {
        tableViewOdbery.setVisible(false);
        tableViewVysetreni.setVisible(true);
        tableViewZakroky.setVisible(false);
    
    vysetreniData.clear();
    String sql;
    if(tfJmenoZvirete.getText().isEmpty() || !rBtnZapniFiltry.isSelected()){
        sql = "SELECT * FROM P_VYSETRENI";
    }else{ 
        sql = "SELECT * FROM P_ODBERY WHERE JMENO LIKE '" + tfJmenoZvirete.getText() + "'";
    }
        
    pstmt = VeterinarniKlinika.con.prepareStatement(sql);
    rs = pstmt.executeQuery();
    while(rs.next()){
    VysetreniOld vy = new VysetreniOld(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),
            rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),
            rs.getString(10),rs.getDouble(11),rs.getString(12),rs.getString(13),rs.getInt(14),rs.getString(15),
            rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getInt(21),
            rs.getString(22),rs.getString(23),rs.getInt(24),rs.getString(25),rs.getString(26),rs.getInt(27),
            rs.getString(28),rs.getInt(29),rs.getString(30),rs.getInt(31),rs.getString(32),rs.getString(33),
            rs.getString(34),rs.getDouble(35),rs.getString(36),rs.getString(37),rs.getString(38),rs.getString(39),
            rs.getString(40),rs.getInt(41),rs.getString(42),rs.getString(43),rs.getInt(44),rs.getString(45),
            rs.getString(46));   
    vysetreniData.add(vy);
    }
    tableViewVysetreni.refresh();
    
    
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
