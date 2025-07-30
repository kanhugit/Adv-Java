package dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "Kanha@123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

