/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinarniklinika;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author 42060
 */
public class VeterinarniKlinika extends Application {
    
    PreparedStatement pstmt=null;
    static Connection con=null;
    ResultSet rs=null; 
    static Stage primaryStage;

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUvodni.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("IDAS2 - Semestralni prace - Veterinarní klinika - Filip Micka, Tomas Zlatohlavek");
        stage.setScene(scene);
        stage.show();
        
        primaryStage = stage;
        
        boolean nepripojeno = true;
        do{
            try{
                con=DBUtil.getConnection();
                con.createStatement();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Succes !");
                alert.setHeaderText("Připojení k databázi proběhlo úspěšně !");
                alert.showAndWait();
                nepripojeno = false;

            } catch (SQLException e) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Error !");
                //alert.setHeaderText("Chyba připojení k databázi, nejsi připojen k VPN - připoj se !");
                alert.setHeaderText(e.getMessage());

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    nepripojeno = true;
                } else {
                    nepripojeno = false;
                    stop();
                    Platform.exit();
                }       
            }
        }while(nepripojeno);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    // zavreni a ukonceni spojeni s databazi
    @Override
    public void stop(){
    System.out.println("Stage is closing");
        try {
            DBUtil.closeConnection(con);
            System.out.println("spojeni ukonceno !");
            // Save file
        } catch (SQLException ex) {
            System.out.println("chyba ukončení spojení s databází !");
        }
}
    
}
