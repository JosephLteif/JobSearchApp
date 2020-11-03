package Connection;


import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import utilities.AES;
import utilities.AES;
import Forms.appHome;
import Forms.appHome;

public class ConnectionManager {

    private static int idLoc = 6;
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private final String secret = "ssshhhhhhhhhhh!!!!";
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    private static final String connectionString = "jdbc:mysql://localhost:3306/jobsearchapp?user=root";
    private static Connection connection = null;
    public static int numberOfOpenedConnections = 0;

    public ConnectionManager() {
        getConnection();
    }
    //Open the connection
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(connectionString);
            }
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
        numberOfOpenedConnections++;
        return connection;
    }
    
    //check if the connection is opened
    public static boolean connectionIsOpen() {
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return false;
    }

    //Close the connection
    public static void close() {
        try {
            connection.close();
            numberOfOpenedConnections--;
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean login(String username, String password) {

        //code 
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select EMAIL,PASSWORD,USERNAME from USER_ACCOUNT");
            while (rs.next()) {
                if (((username.equals(rs.getString(1))) || username.equals(rs.getString(3))) && password.equals(AES.decrypt(rs.getString(2), secret))) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return false;
    }

//    public static void InsertImage(String username, String Image) {
//
//        try {
//            pstmt = con.prepareStatement("UPDATE User_Account set PROFILE_PICTURE = ? where User_Account.USERNAME = ?");
//
//            pstmt.setString(1, Image);
//            pstmt.setString(2, username);
//
//            pstmt.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
//
//    public static File getImage(String username) {
//        String path = new String("C:\\Users\\joelt\\Documents\\NetBeansProjects\\Job-Search-Project-master\\src\\javaapplication1\\Media\\Default-Profile-Picture.jpg");
//        File image = new File(path);
//        try {
//
//            pstmt = con.prepareStatement("Select PROFILE_PICTURE from User_Account where user_account.username = ?");
//
//            pstmt.setString(1, username);
//
//            rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                path = rs.getString("PROFILE_PICTURE");
//            }
//            return new File(path);
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        return image;
//    }

}
