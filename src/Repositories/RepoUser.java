/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.PasswordReset;
import DTO.User;
import Forms.AppHomeForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Helpers.MySQLConnectionManager;
import java.awt.Component;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

    public static void GetAll(String name) {
        try {
            
            ps = con.prepareStatement("SELECT * FROM user where firstName like ?;");
            ps.setString(1,  "%" + name + "%");
            rs = ps.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) AppHomeForm.Table.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object User[] = {rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                };
                dtm.addRow(User);
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }

    public static User Get(String mail) {
        User user = null;
        try {
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user WHERE email='" + mail + "';");
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        
        return user;

    }

    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUid(rs.getInt("userID"));
        user.setFname(rs.getString("firstName"));
        user.setLname(rs.getString("lastNAme"));
        user.setDob(rs.getString("dob"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setMajor(rs.getString("Major"));
        user.setGender(rs.getInt("gender"));
        user.setLocation(rs.getString("location"));
        user.setPP(rs.getString("profilePicture"));
      
        return user;

    }

    public static boolean updatePass(String email, String pass) {

        try {
            
            ps = con.prepareStatement("Update user Set password=SHA(?) where email=LOWER(?);");
            ps.setString(1, pass);
            ps.setString(2, email);
            int i = ps.executeUpdate();
            if (i == 1) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return true;

            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        
        return false;

    }
    
    public static boolean passwordAfterVerify(String email, String pass) throws SQLException{
    
         try {
//             con = MySQLConnectionManager.getConnection();
            ps=con.prepareStatement("Update user Set password=?,isverified=? where email=?;");
            ps.setString(1, pass);
            ps.setInt(2,0);
            ps.setString(3, email);
            int i= ps.executeUpdate();
            if (i==1){
                
                con.close();
                return true;
        
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//     con.close();
     return false;
     
    }

    private static boolean foundmail(String mail) throws SQLException {

        try {
            
            ps = con.prepareStatement("SELECT * FROM user WHERE email=Lower(?);");
            ps.setString(1, mail);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;

    }

    public boolean create(User u) {
        try {
            if (foundmail(u.getEmail())) {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "An account is already associated with this mail!",
                        "Account not found", JOptionPane.ERROR_MESSAGE);
               
                return false;
            }
            
            String SQLQuery = "INSERT INTO user (firstName,lastName,email,password,gender,isverified) values (?, ?, ?,null,?,1);";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, u.getFname());
            ps.setString(2, u.getLname());
            ps.setString(3, u.getEmail());
            //ps.setString(4, u.getPassword());
            ps.setInt(4, u.getGender());

            
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
            ps = con.prepareStatement("Select email, password from user where password = SHA(?);");
            ps.setString(1, u.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean insertProfilePicture(User u) {
        int done = 0;
        try {
            ps = con.prepareStatement("update user set ProfilePicture = (?) where email = ?;");
            ps.setString(1, u.getPP());
            ps.setString(2, u.getEmail());
            done = ps.executeUpdate();
            if (done == 1) {
                System.out.println("Done!!!!");
                
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return false;
    }
    
    
    
        public void Destroy(){
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        if(stmt!=null){
            try{
            stmt.close();
            
        }catch(SQLException ex){
                System.out.println(ex);
                }
        
        
    }
    }

   
}
