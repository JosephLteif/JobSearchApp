package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLConnectionManager {

//   private static final String ConnectionManager = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7375263?user=sql7375263&password=Tsg9h7CIPh";
//  private static final String ConnectionManager = "jdbc:mysql://localhost:3306/jobify?user=root&password=toor";
    private static final String ConnectionManager = "jdbc:mysql://127.0.0.1:3306/ jobify?user=root";
            
    private static Connection connection = null;
    public static int numberOfOpenedConnections = 0;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(ConnectionManager);
            }
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
        numberOfOpenedConnections++;
        return connection;
    }

    public static boolean connectionIsOpen() {
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return false;
    }

    public static void close() {
        try {
            connection.close();
            numberOfOpenedConnections--;
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
    }

}
