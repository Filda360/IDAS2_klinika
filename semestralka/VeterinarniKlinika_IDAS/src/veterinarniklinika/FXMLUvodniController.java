/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//token Filda360 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
package veterinarniklinika;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author 42060
 */
public class FXMLUvodniController implements Initializable {
    
    PreparedStatement pstmt=null;
    Connection con=null;
    ResultSet rs=null;   
    
    @FXML
    private TextField tfJmeno;
    @FXML
    private Button btnPrihlasit;
    @FXML
    private Button btnRegistrovat;
    @FXML
    private TextField tfHeslo;
    @FXML
    private Label labelInfo;
    @FXML
    private Button btnKonec;
    
    private void handleButtonAction(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            con=DBUtil.getConnection();
            System.out.println("pripojeno");
            con.createStatement();
//            String sql = "select * from login where username=? and password=?";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1,tfJmeno.getText());
//            pstmt.setString(2, tfHeslo.getText());
//            rs = pstmt.executeQuery();
//            System.out.println(rs);
//            if(rs.next()) {
//                    labelInfo.setText("Login Sucessfully!");
//            }else{
//                    labelInfo.setText("Login Not Sucessfully!");
//            }
        } catch (SQLException e) {
                System.out.println("sql exception");
                e.printStackTrace();
        }
    }    

    @FXML
    private void btnPrihlasitOnAction(ActionEvent event) {

    }

    @FXML
    private void handleBtnRegistraceOnAction(ActionEvent event) {
        
    }

    @FXML
    private void handleBtnKonecOnAction(ActionEvent event) {
        try {
            DBUtil.closeConnection(con);
        } catch (SQLException ex) {
            System.out.println("chyba ukonceni spojeni !");
        }
    }
    
}
