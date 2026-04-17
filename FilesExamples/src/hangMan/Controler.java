package hangMan;

import java.util.ArrayList;

import dataBaseConection.DBConection;

public class Controler {

	public static void main(String[] args) {
		ArrayList<Player> playersList;
		ArrayList<Player> auxList;
		playersList=DBConection.readPlayersFromDB();
		auxList=MarcosReadAndWritingPlayers.sortPlayers(playersList);
	}

	
}
