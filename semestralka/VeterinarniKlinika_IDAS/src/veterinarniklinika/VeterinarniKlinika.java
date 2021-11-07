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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        
        try{
            con=DBUtil.getConnection();
            System.out.println("pripojeno");
            con.createStatement();
            
        } catch (SQLException e) {
                System.out.println("sql exception");
                e.printStackTrace();
        }
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
