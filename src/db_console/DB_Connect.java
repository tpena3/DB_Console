/*
Name: Tanya Pena
Project 2
 */

package db_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DB_Connect {

    public static void main(String[] args) {
        
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Users", "username", "password");
            Statement stmt = con.createStatement();
            
            String SQL1 = "SELECT * FROM app.Faculty";
            ResultSet rs1 = stmt.executeQuery(SQL1);
            
            System.out.println("Faculty:");
            while (rs1.next()) {
                int UIN = rs1.getInt("UIN");
                String name = rs1.getString("FirstName") + " " + rs1.getString("LastName");
                System.out.printf("UIN: %d\nName: %s\n\n", UIN, name);
            }
            
            String SQL2 = "SELECT * FROM app.Students";
            ResultSet rs2 = stmt.executeQuery(SQL2);
            
            System.out.println("\nStudents:");
            while (rs2.next()) {
                String Anumber = rs2.getString("Anumber");
                String Name = rs2.getString("FirstName") + " " + rs2.getString("LastName");
                System.out.printf("A#: %s\nName: %s\n\n", Anumber, Name);
            }
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
    }
    
}
