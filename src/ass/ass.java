/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class ass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DBStudent;user=sa;password=123456;trustServerCertificate=true;";

        try (Connection con = DriverManager.getConnection(connectionUrl); 
            Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM Students";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("MaSv") + " " + rs.getString("HoTen"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
