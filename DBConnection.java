package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
 private static final String URL = "jdbc:mysql://localhost:3306/mentor_allotment";
 private static final String USER = "root";
 private static final String PASSWORD = "*sho0211"; // your real password
 public static Connection getConnection() {
 Connection conn = null;
 try {
 // Load MySQL JDBC Driver
 Class.forName("com.mysql.cj.jdbc.Driver");
 
 // Establish the connection
 conn = DriverManager.getConnection(URL, USER, PASSWORD);
 System.out.println(" Database Connected Successfully!");
 } catch (ClassNotFoundException e) {
 System.out.println(" JDBC Driver not found!");
 e.printStackTrace();
 } catch (SQLException e) {
 System.out.println(" Connection Failed!");
 e.printStackTrace();
 }
 return conn;
 }
 public static void main(String[] args) {
 getConnection();
 }
}
