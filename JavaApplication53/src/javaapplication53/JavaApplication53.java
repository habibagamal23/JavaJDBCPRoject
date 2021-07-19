/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication53;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaApplication53 {
    
    
        static Connection con;
    public static void main(String[] args) {
        ConnectClass db = new ConnectClass();
        try {
            con = db.getConnect();
            PreparedStatement ps;
            
            ps=con.prepareStatement("INSERT INTO `register`( `name`, `course`) VALUES (?,?)");
            ps.setString(1, "ragb");
            ps.setString(2, "db");
            ps.executeUpdate();
           
            
            
            System.out.println("Inserting Successfully  !");
            
            
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sql) {
                sql.getStackTrace();
            }
        }
    }

}

class ConnectClass {
    
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "jdbc_course";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String URL = String.format("jdbc:mysql://localhost/studentdsc?serverTimezone=UTC");
    static Connection con;
    
   public Connection getConnect() throws SQLException{

       con=DriverManager.getConnection(URL, USER, PASS);
       return con;
   }
    
}