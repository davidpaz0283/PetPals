package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/petpals";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static DatabaseConnection instance;
    
    private Connection connection;
    
    
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Se conecto");
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "No se conecto");
            e.printStackTrace();
        }
    }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
}
