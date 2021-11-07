
package veterinarniklinika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.sql.*;

public final class DBUtil {
    private static boolean isDriverLoaded = false;
    static{
            try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    System.out.println("Driver Loaded");
                    isDriverLoaded = true;	
            }catch(ClassNotFoundException e){
                    System.out.println("Chyba načtení driveru Oracle");
                    e.printStackTrace();
            }
    }

    private final static String url="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS =(PROTOCOL=TCP)(HOST=fei-sql1.upceucebny.cz)(PORT=1521)))(CONNECT_DATA=(SID=IDAS)))";
    private final static String user="ST61021"; //STecko
    private final static String password="Flynn177";//heslo

    public static Connection getConnection() throws SQLException{
            Connection con = null;
            if(isDriverLoaded){
                    con  = DriverManager.getConnection(url,user,password);
                    System.out.println("Connection established");
            }
            return con;
    }


    public static void closeConnection(Connection con) throws SQLException{
            if(con!=null){
                    con.close();
                    System.out.println("connection closed");
            }
    }	
}
