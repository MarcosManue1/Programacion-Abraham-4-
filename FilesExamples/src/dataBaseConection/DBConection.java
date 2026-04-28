package dataBaseConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import hangMan.Player;

public class DBConection {
	public static void main(String[] args) {
		// String url="jdbc:mysql://localhost:3306/PlayersDB?useSSL=false&serverTimezone=UTC"; // Modern way
		
		readPlayersFromDB();
	}

	public static ArrayList<Player> readPlayersFromDB() {
		String url="jdbc:mysql://10.203.28.74:3306/PlayersDB";
		String user="root";
		String password="";//en XAMPP suele estar vacío

		ArrayList<Player> playerList=new ArrayList<Player>();
		try {
			Connection conn=DriverManager.getConnection(url, user, password);
			System.out.println("Conexión exitosa");
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM Players");

			while (rs.next()) {
				int id=rs.getInt("id");
				String nombre=rs.getString("name");
				int puntuacion=rs.getInt("puntuation");
				
				playerList.add(new Player(puntuacion, nombre));
				
//				System.out.println(id+" - "+nombre+" - "+puntuacion);
			}
			conn.close();
			System.out.println(playerList.size());
			
			Player play=maxPuntuationPlayer(playerList);
			System.out.println("Best Player is "+play);
			
			double average=averagePuntuation(playerList);
			System.out.println("Average Puntuation: "+average);
			
//			Collections.sort(playerList);			
//			for (Player player : playerList) {
//				System.out.println(player);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playerList;
	}
	public static double averagePuntuation(ArrayList<Player> list) {
		int total=0;
		for (Player player : list) {
			total+=player.getPuntuation();
		}
		return (double)((double)total/(double)list.size());
	}
	
	
	public static Player maxPuntuationPlayer(ArrayList<Player> list) {
		Player auxPlayer=null;
		int maxPunt=Integer.MIN_VALUE;
		for (Player player : list) {
			if(player.getPuntuation()> maxPunt) {
				maxPunt=player.getPuntuation();
				auxPlayer=player;
			}
		}
		return auxPlayer;
	}
}
