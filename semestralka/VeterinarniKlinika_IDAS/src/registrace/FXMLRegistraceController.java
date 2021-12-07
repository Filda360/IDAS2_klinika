
package registrace;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import veterinarniklinika.VeterinarniKlinika;
import veterinarniklinika.Bezpecnost;


public class FXMLRegistraceController implements Initializable {

    private CallableStatement cst = null;
    
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
    private TextField tfPrihlasovaciJmeno;
    @FXML
    private Button btnZaregistrovat;
    @FXML
    private TextField tfJmenoR;
    @FXML
    private PasswordField tfHesloR;
    @FXML
    private Button btnZpet;
    private TextField tfDatumNarozeni;
    @FXML
    private DatePicker datePicker;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    //přidá nového majitele do databáze
    //v aplikaci se kontroluje prázdnost vyplněných polí, silnost hesla
    //další validace: email, psc, telefon probíhá na straně databáze
    
    @FXML
    private void handleBtnZaregistrovatOnAction(ActionEvent event){
        
        if(
                tfPrijmeni.getText().isEmpty() ||
                tfJmenoR.getText().isEmpty() ||
                tfUlice.getText().isEmpty() ||
                tfCp.getText().isEmpty() ||
                tfMesto.getText().isEmpty() ||
                tfPsc.getText().isEmpty() ||
                tfTelefon.getText().isEmpty() ||
                tfEmail.getText().isEmpty() ||
                tfPrihlasovaciJmeno.getText().isEmpty() ||
                tfHesloR.getText().isEmpty() ||
                datePicker.getValue() == null               
                ){ 
            zobrazErrorDialog("Error !", "Formulář není řádně vyplněn, některá pole jsou prázdná !" );
        }else{ 
            if(
                    Bezpecnost.obsahujeNebezpecneZnaky(tfPrijmeni.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfJmenoR.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfUlice.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfCp.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfMesto.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfPsc.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfTelefon.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfEmail.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfPrihlasovaciJmeno.getText()) ||
                    Bezpecnost.obsahujeNebezpecneZnaky(tfHesloR.getText())
                    ){ 
                zobrazErrorDialog("Error !", "některé z polí obsahuje nepovolené řetězce znaků:\nNepovolené řetězce: SELECT, DROP, --, ', UNION, CONCAT, IF, ;");
            }else{ 
                if(!Bezpecnost.jeHesloDostatecne(tfHesloR.getText())){ 
                zobrazErrorDialog("Error !", "Heslo není dostatečně silné, je požadován alespoň jedno velké písmeno, malé písmeno a číslo, minimální délka je 6 znaků !" );
                }else{ 
                    try {                
                        cst = VeterinarniKlinika.con.prepareCall("{CALL ?:=vytvor_registraci_majitele(?,?,?,?,?,?,?,?,?,?,?,?)}");

                        cst.registerOutParameter(1, Types.NUMERIC);
                        cst.setString(2, tfJmenoR.getText());
                        cst.setString(3, tfPrijmeni.getText());
                        cst.setDate(4, Date.valueOf(datePicker.getValue()));
                        cst.setString(5, tfUlice.getText());
                        cst.setString(6, tfCp.getText());
                        cst.setString(7, tfMesto.getText());
                        cst.setString(8, tfPsc.getText());
                        cst.setString(9, tfTelefon.getText());
                        cst.setString(10, tfEmail.getText());
                        cst.setString(11, tfPrihlasovaciJmeno.getText());
                        try {
                            cst.setString(12, Bezpecnost.dejHash(tfHesloR.getText().getBytes()));
                        } catch (Exception ex) {
                            zobrazErrorDialog("Error !", "Chyba při hashovani hesla !");
                        }
                        cst.registerOutParameter(13, Types.VARCHAR);

                        cst.executeUpdate();
                        int vytvoren = cst.getInt(1);
                        String zprava = cst.getString(13);

                        if(vytvoren==1){ 
                            zobrazConfDialog("Děkujeme !", zprava);
                            try {          
                                Parent root = FXMLLoader.load(getClass().getResource("/veterinarniklinika/FXMLUvodni.fxml"));

                                Scene scene = new Scene(root);
                                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                                window.setScene(scene);
                                window.show();
                            } catch (IOException ex) {
                                zobrazErrorDialog("Error !", "Chyba, nezdařil se přechod na úvodní okno !");
                            }
                        }else{ 
                            zobrazErrorDialog("Registrace se nezdařila !", zprava);
                        }

                    } catch (SQLException ex) {
                        zobrazErrorDialog("Ups neco se nepovedlo, SQL exception !",ex.getMessage());
                    }    
                }
            }                
        }
    }

    @FXML
    private void handleBtnZpetOnAction(ActionEvent event) {
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/veterinarniklinika/FXMLUvodni.fxml"));

            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(scene);
            window.show();
            
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error !");
            alert.setHeaderText("Chyba při přechodu do registračního formuláře");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
    
    
    private void zobrazErrorDialog(String headText, String content){ 
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText(headText);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void zobrazConfDialog(String headText, String content){ 
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Succes !");
        alert.setHeaderText(headText);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
