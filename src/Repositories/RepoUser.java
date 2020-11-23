/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.PasswordReset;
import DTO.User;
import Forms.FileChooserForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Helpers.MySQLConnectionManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lama
 */
public class RepoUser {

    private static Connection con = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static Statement stmt;
    

    public RepoUser() {
        con = MySQLConnectionManager.getConnection();
    }
    
    public static User Get(String mail){
    User user=null;
    try{
        con = MySQLConnectionManager.getConnection();
        stmt=con.createStatement();
        rs=stmt.executeQuery("SELECT * FROM user WHERE email='"+mail+"';");
        if(rs.next()){
            user=extractUserFromResultSet(rs);
        }
    }catch(SQLException ex){
        System.out.println(ex);
        
    }
    return user;
    
}

    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
       User user=new User();
       user.setUid(rs.getInt("userID"));
       return user;
       
    }
    public static boolean updatePass(String email, String pass){
    
         try {
             con = MySQLConnectionManager.getConnection();
            ps=con.prepareStatement("Update user Set password=? where email=?;");
            ps.setString(1, pass);
            ps.setString(2, email);
            int i= ps.executeUpdate();
            if (i==1){
                return true;
        
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
          
     return false;
     
    }

    public boolean create(User u) {
        try {
            String SQLQuery = "INSERT INTO user (firstName,lastName,email,password,gender) values (?, ?, ?, ?, ?);";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, u.getFname());
            ps.setString(2, u.getLname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getGender());

            
            int rowCreate = ps.executeUpdate();
            PasswordReset pr=new PasswordReset(u.getEmail());
            if (rowCreate == 1) {
                
                RepoPasswordReset.insert(pr);
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static boolean login(User u) {
        try {
            ps = con.prepareStatement("Select firstName, password from user;");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(u.getFname()) && rs.getString(2).equals(u.getPassword())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
  
 
   
   
   
    public static boolean insertProfilePicture(User u) {
        int done = 0;
        try {
            InputStream in = new FileInputStream(new FileChooserForm(u.getFname()).chooseImage());
            try {
                ps = con.prepareStatement("insert into user(ProfilePicture) values(?) where user.firstName = ?;");
                ps.setBinaryStream(1, in, done);
                ps.setString(2, u.getFname());
                done = ps.executeUpdate();
                if (done == 1) {
                    System.out.println("Done!!!!");
                    return true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RepoUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
