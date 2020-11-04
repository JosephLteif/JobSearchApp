/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Helpers.MySQLConnectionManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lama
 */
public class RepoUser {
   
private static Connection con=null;
private static Statement stmt=null;
private static ResultSet rs=null;
private static PreparedStatement ps=null;
   
   


public RepoUser(){
   
    
    con = MySQLConnectionManager.getConnection();
}
    
    public boolean create(User u){
    try{
     String SQLQuery="INSERT INTO user (firstName,lastName,email,password,gender) values (?, ?, ?, ?, ?);";
     ps=con.prepareStatement(SQLQuery);     
     ps.setString(1, u.getFname());
     ps.setString(2, u.getLname());
     ps.setString(3, u.getEmail());
     ps.setString(4, u.getPassword());
     ps.setInt(5, u.getGender());
    
     int rowCreate=ps.executeUpdate();
     if(rowCreate==1){
         return true;
     }
     }catch(SQLException ex){
             System.out.println(ex);
             }
     return false;
    }
    
    public static boolean login(User u){
    try {
        ps = con.prepareStatement("Select firstName, password from user;");
        rs = ps.executeQuery();
        while(rs.next()){
            if(rs.getString(1).equals(u.getFname()) && rs.getString(2).equals(u.getPassword())){
                return true;
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(RepoUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }
}
