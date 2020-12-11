/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.PasswordReset;
import DTO.User;
import Forms.AppHomeForm;
import Forms.SignupConfirmMailForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Helpers.MySQLConnectionManager;
import java.awt.Component;
import java.sql.Statement;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilities.EmailClass;
import utilities.TokenGenerator;

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
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) AppHomeForm.Table.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Object User[] = {rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),};
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
                return user;
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
        user.setLname(rs.getString("lastName"));
        user.setDob(rs.getString("DOB"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setMajor(rs.getString("Major"));
        user.setGender(rs.getInt("gender"));
        user.setLocation(rs.getString("location"));
        user.setPP(rs.getString("profilePicture"));
        user.setUniId(rs.getInt("university_ID_UNIVERSITY"));
        
        return user;

    }

    public static boolean updatePass(String email, String pass) {

        try {

            ps = con.prepareStatement("Update user Set password=SHA(?) where email=LOWER(?);");
            ps.setString(1, pass);
            ps.setString(2, email);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;

            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        return false;

    }

    public static boolean passwordAfterVerify(String email, String pass) throws SQLException {

        try {
            ps = con.prepareStatement("Update user Set password=SHA(?),isverified=? where email=Lower(?);");
            ps.setString(1, pass);
            ps.setInt(2, 0);
            ps.setString(3, email);
            int i = ps.executeUpdate();
            if (i == 1) {

                return true;

            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
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

            String SQLQuery = "INSERT INTO user (firstName,lastName,email,password,gender,isverified) values (?, ?, Lower(?),null,?,1);";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, u.getFname());
            ps.setString(2, u.getLname());
            ps.setString(3, u.getEmail());
            ps.setInt(4, u.getGender());

            int rowCreate = ps.executeUpdate();
            if (rowCreate == 1) {

                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public static boolean login(User u) {
        try {
            ps = con.prepareStatement("Select email, password, isverified from user where password = SHA(?) and email = LOWER(?);");
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getEmail());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt(3) == 0) {
                    return true;
                } else {
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame, "Account Not Verified!\nVerification Email sent!",
                            "Sign up failed", JOptionPane.ERROR_MESSAGE);

                    String token = TokenGenerator.generatetxt();
                    PasswordReset pr = new PasswordReset(u.getEmail(), token);
                    User u2 = RepoUser.Get(u.getEmail());
                    if (new RepoPasswordReset().insert(pr)) {
                    Thread T1 = new Thread(() -> {
                        try {
                            String sub = "Sign up verfication!";
                            String body = "Dear " + u2.getFname() + " " + u2.getLname() + ",<br> We'd like to welcome you in our app!Hoping that you'll find your dream job through our app!<br> "
                                    + "But first we need to verify your email. So kindly enter this code: <br>" + pr.getTok() + "<br>"
                                    + "For any complaints, you can reach us on this email.";
                            String[] mails = new String[1];
                            mails[0] = u2.getEmail();
                            new EmailClass().sendFromGmail(mails, sub, body, null, null, null);
                            
                        } catch (MessagingException ex) {
                            System.out.println(ex.getMessage());
                        }
                    });
                    T1.start();
                    }
                    new SignupConfirmMailForm(pr.getEmail()).setVisible(true);
                    return false;
                }
            }
            JOptionPane.showMessageDialog(null, "Username or password incorrect");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean insertProfilePicture(User u) {
        int done = 0;
        try {
            ps = con.prepareStatement("update user set ProfilePicture = (?) where email = LOWER(?);");
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

    
    
    
     public boolean Update(User user){
         try {
            ps=con.prepareStatement("Update user Set firstName=?, lastName=?, DOB=?, phoneNumber=?, Major=?, location=?, university_ID_UNIVERSITY=? Where email=?;");
         

            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());

            ps.setString(3, user.getDob());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getMajor());
            ps.setString(6,user.getLocation());
            ps.setInt(7, user.getUid());
            ps.setString(8, user.getEmail());
            int i= ps.executeUpdate();
            if (i==1){

                return true;
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        return false;
    }

    public void Destroy() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }

}
