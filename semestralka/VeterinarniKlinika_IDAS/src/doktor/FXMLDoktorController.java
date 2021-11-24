/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktor;

import dataTridy.Zakrok;
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
    private TableView<Zakrok> tableView;
    @FXML
    private TableColumn<Zakrok, String> zakroky_datum;
    @FXML
    private TableColumn<Zakrok, String> zakroky_poznamka;
    @FXML
    private TableColumn<Zakrok, String> zakroky_jmeno;
    @FXML
    private TableColumn<Zakrok, String> zakroky_druh;
    @FXML
    private TableColumn<Zakrok, String> zakroky_pohlavi;
    @FXML
    private TableColumn<Zakrok, String> zakroky_datum_narozeni;
    @FXML
    private TableColumn<Zakrok, Double> zakroky_vaha;
    @FXML
    private TableColumn<Zakrok, String> zakroky_poznamka_zvirete;
    @FXML
    private TableColumn<Zakrok, String> zakroky_typ_operace;
    @FXML
    private TableColumn<Zakrok, Double> zakroky_delka_operace;
    @FXML
    private TableColumn<Zakrok, String> zakroky_jmeno_lekare;
    @FXML
    private TableColumn<Zakrok, String> zakroky_prijmeni_lekare;
    
    public static ObservableList<Zakrok> zakrokData = FXCollections.observableArrayList();
    
    private PreparedStatement pstmt=null;
    private ResultSet rs=null; 
    @FXML
    private RadioButton rBtnZapniFiltry;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableView.setItems(zakrokData);
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

        tableView.setEditable(true);
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
    Zakrok za = new Zakrok(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),
            rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),
            rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getInt(17),
            rs.getString(18),rs.getString(19),rs.getInt(20),rs.getString(21),rs.getString(22),rs.getInt(23),
            rs.getString(24),rs.getInt(25),rs.getString(26),rs.getInt(27),rs.getString(28),rs.getString(29),
            rs.getString(30),rs.getDouble(31),rs.getString(32),rs.getString(33),rs.getString(34),rs.getString(35),
            rs.getString(36),rs.getInt(37),rs.getString(38),rs.getString(39),rs.getInt(40),rs.getString(41),
            rs.getString(42),rs.getInt(43),rs.getString(44),rs.getString(45),rs.getDouble(46),rs.getString(47));   
    zakrokData.add(za);
    }
    tableView.refresh();
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
