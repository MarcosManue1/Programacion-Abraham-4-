package dataBaseConection;

import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConection {

	public static void main(String[] args) {
		
			//String url = "jdbc:mysql://localhost:3306/PlayersDB?useSSL=false&serverTimezone=UTC"; //Modern way
			String url = "jdbc:mysql://10.203.28.74:3306/PlayersDB";
			String user = "root";
			String password = ""; // en XAMPP suele estar vacío
			ArrayList<Player>playersList = new ArrayList<>();
			ObjectInputStream objsFile = null;
			players=readFileObjects(fich,objsFile);
	 
			readPlayersFromDB(url, user, password);
			
	}

	private static ArrayList<Player> readPlayersFromDB() {
		try {
			Connection conn = DriverManager.getConnection();
			System.out.println("Conexión exitosa");
 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Players");
 
			Player auxPlayer=null;
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("name");
				int puntuacion = rs.getInt("puntuation");

				auxPlayer=new Player(nombre,puntuacion);
				playersList.add(auxPlayer); 
				System.out.println(id + " - " + nombre + " - " + puntuacion);
			}
 
			conn.close();
			
			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersList;
	}
}
