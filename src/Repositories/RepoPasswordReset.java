/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.PasswordReset;
import DTO.User;
import Helpers.MySQLConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lama
 */
public class RepoPasswordReset {
    
     private static Connection con ;// null;
    private static ResultSet rs;// = null;
    private static PreparedStatement ps ;//= null;
     private static Statement stmt;

    public RepoPasswordReset() {
        
        con = MySQLConnectionManager.getConnection();
    }
    
       
   public static boolean foundmail(String mail) throws SQLException{
      
        try{ 
            con = MySQLConnectionManager.getConnection();
            ps=con.prepareStatement("SELECT * FROM password_reset WHERE email=?;");
            ps.setString(1, mail);
            rs=ps.executeQuery();
            if(rs.next()){
                con.close();
                 return true;
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        con.close();
           return false;
           
     
          }

    
     public static boolean insert(PasswordReset pr) throws SQLException {
        try {
            
             con = MySQLConnectionManager.getConnection();
            String SQLQuery = "INSERT INTO password_reset (email,token) values (?,?);";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, pr.getEmail());
            ps.setString(2, pr.getTok());

            int rowCreate = ps.executeUpdate();
            if (rowCreate == 1) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        con.close();
        return false;
    }
     
      public static boolean setTokenNull(String mail) {
        try {
            
             con = MySQLConnectionManager.getConnection();
            String SQLQuery = "Update password_reset Set token=null where email=?;";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, mail);
          
            int rowCreate = ps.executeUpdate();
            if (rowCreate == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
     
     
                
                
                
   
     
     
    
     public static String getToken(String email){
         String tok="";
    try{
        
         con = MySQLConnectionManager.getConnection();
        String SQLQuery = "Select token from password_reset where email='"+email+"';";
         stmt=con.createStatement();
        rs=stmt.executeQuery(SQLQuery);
        if(rs.next()){
             tok=rs.getString("token");
        }
        
    }catch(SQLException ex){
        System.out.println(ex);
        
    }
     return tok;
     }
}
    
         
     

