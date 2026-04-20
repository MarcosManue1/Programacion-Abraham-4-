package dataBaseConection;

import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DBConection {

	public static void main(String[] args) {
		
			//String url = "jdbc:mysql://localhost:3306/PlayersDB?useSSL=false&serverTimezone=UTC"; //Modern way
	 
			readPlayersFromDB();
			
	}

	private static ArrayList<Player> readPlayersFromDB() {
		String url = "jdbc:mysql://10.203.28.74:3306/PlayersDB";
		String user = "root";
		String password = ""; // en XAMPP suele estar vacío
		ArrayList<Player>playersList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión exitosa");
 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Players");
 
			Player auxPlayer=null;
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int puntuacion = rs.getInt("puntuation");

				auxPlayer=new Player(name, puntuacion);
				playersList.add(auxPlayer); 
				System.out.println(id + " - " + name + " - " + puntuacion);
			}
			
			System.out.println(stmt.execute("INSERT INTO Players (name,puntuation) VALUES ('Abraham',100)"));
			System.out.println(stmt.execute("UPDATE Players SET puntuation = 2000 WHERE name = 'Anastasio'"));
			System.out.println(stmt.execute("DELETE Players WHERE name = 'Ana bowele'"));
 
			conn.close();
			System.out.println(playersList.size());
			
			Player play = maxPuntuationPlayer(playersList);
			System.out.println("Best player is: "+play.toString());
			
			double average=averagePuntuation(playersList);
			System.out.println("Average Puntuation: "+average);
			
			sortList(playersList);
			
			Collections.sort(playersList);
			for(Player player : playersList) {
				System.out.println(player);
			}
		
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playersList;

	}
	
	public static String insertValues() {
		String
	}
	
	public static double averagePuntuation(ArrayList<Player> list) {
		int total=0;
		for(Player player : list){
		total +=player.getPuntuation();	
		}
		return (double)((double)total/(double)list.size());
	}
	
	public static ArrayList<Player>sortList(ArrayList<Player> list){
		ArrayList<Player> auxList=list;
		Collections.sort(auxList);
		
		return auxList;
	}
	
	public static Player maxPuntuationPlayer(ArrayList<Player> list) {
		Player auxPlayer = null;
		int maxPunt=Integer.MIN_VALUE;
		
		int pos=0;
		for(int i = 0; i<list.size();i++) {
			auxPlayer=list.get(i);
			if(auxPlayer.getPuntuation() > maxPunt) {
				maxPunt = auxPlayer.getPuntuation();
				pos=i;		
			}
		}
		list.clear();
		return list.get(pos);
	}
}
