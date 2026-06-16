package reptiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MarcosDurand_FileExer {

	private static final String URL = "jdbc:mysql://10.203.28.74:3306/reptileDB";
	private static final String USER = "alumno";
	private static final String PASSWORD = "primero";

    public static void main(String[] args) {
    	
    	 
        
        // 1. Get the list from the method
        ArrayList<Reptile> listToInsert = getReptileData();

        // 2. Send that list to the database 
        if(!listToInsert.isEmpty()) {
        sendDataToDB(listToInsert);
        }else {
        	System.out.println("No data to insert.");
        }
    }

    
    public static ArrayList<Reptile> getReptileData() {
        ArrayList<Reptile> list = new ArrayList<>();
        
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Reptile> reptileList = new ArrayList<>();
        char continueInput;

        do {
            System.out.println("--- Enter Reptile Data ---");
            System.out.print("ID: ");
            int id = keyboard.nextInt();
            
            System.out.print("Age: ");
            int age = keyboard.nextInt();
            
            System.out.print("Length: ");
            int length = keyboard.nextInt();
            
            keyboard.nextLine(); // Clear buffer
            System.out.print("Zoo Name: ");
            String zoo = keyboard.nextLine();

            // Adding the new object to the list
            reptileList.add(new Reptile(id, age, length, zoo));

            System.out.print("Do you want to add another reptile? (Y/N): ");
            continueInput = keyboard.next().charAt(0);
            
        } while (continueInput == 'Y' || continueInput == 'y');

        return reptileList;
    }

    
    public static void sendDataToDB(ArrayList<Reptile> reptileList) {
        String insertSQL = "INSERT INTO reptile (id, age, length, zoo) VALUES (?, ?, ?, ?)";
        String querySQL = "SELECT * FROM reptile";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection successful");

            // Data insertion loop 
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                for (Reptile rep : reptileList) {
                    pstmt.setInt(1, rep.getId());
                    pstmt.setInt(2, rep.getAge());
                    pstmt.setInt(3, rep.getLength());
                    pstmt.setString(4, rep.getZoo());
                    pstmt.executeUpdate(); 
                }
            }

            // Verify data insertion
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(querySQL)) {
                
                System.out.println("\n--- Data in reptileDB ---");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " + rs.getInt("age") + " - " + 
                                       rs.getInt("length") + " - " + rs.getString("zoo"));
                }
            }

        } catch (SQLException e) {
        	
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
