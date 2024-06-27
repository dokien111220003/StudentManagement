/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DBStudent;user=sa;password=123456;trustServerCertificate=true;";
    public static Connection getDBConnect() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlsever.jdbc.SQLSeverDriver");
        } catch (Exception e) {
            System.out.println("Chưa có driver !" + e.toString());
        }
        try {
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e) {
            System.out.println("Loi connection" + e.toString());
        }
        return null;
    }
}
