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
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Statement;
import javax.swing.JOptionPane;

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

    public static User Get(String mail) {
        User user = null;
        try {
            con = MySQLConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user WHERE email='" + mail + "';");
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;

    }

    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUid(rs.getInt("userID"));
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;

    }

    public static boolean updatePass(String email, String pass) {

        try {
            con = MySQLConnectionManager.getConnection();
            ps = con.prepareStatement("Update user Set password=? where email=?;");
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

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;

    }

    private static boolean foundmail(String mail) throws SQLException {

        try {
            con = MySQLConnectionManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM user WHERE email=?;");
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
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return false;
            }
            String SQLQuery = "INSERT INTO user (firstName,lastName,email,password,gender) values (?, ?, ?, ?, ?);";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, u.getFname());
            ps.setString(2, u.getLname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getGender());

            int rowCreate = ps.executeUpdate();
            PasswordReset pr = new PasswordReset(u.getEmail());
            if (rowCreate == 1) {

                RepoPasswordReset.insert(pr);
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static boolean login(User u) {
        try {
            ps = con.prepareStatement("Select email, password from user;");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(u.getEmail()) && rs.getString(2).equals(u.getPassword())) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return true;
                }
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
            InputStream in = new FileInputStream(new FileChooserForm(u).chooseImage());
            try {
                ps = con.prepareStatement("update user set ProfilePicture = ?) where user.firstName = ?;");
                ps.setString(1, u.getPP());
                ps.setString(2, u.getFname());
                done = ps.executeUpdate();
                if (done == 1) {
                    System.out.println("Done!!!!");
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
