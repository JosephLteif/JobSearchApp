package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String connectionString = "jdbc:mysql://localhost:3306/jobsearchapp?user=root";
    private static Connection connection = null;
    public static int numberOfOpenedConnections = 0;

    public static Connection getConnection(){
        try {
            if(connection == null || connection.isClosed())
                connection = DriverManager.getConnection(connectionString);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        numberOfOpenedConnections++;
        return connection;
    }

    public static boolean connectionIsOpen(){
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static void close(){
        try {
            connection.close();
            numberOfOpenedConnections--;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}