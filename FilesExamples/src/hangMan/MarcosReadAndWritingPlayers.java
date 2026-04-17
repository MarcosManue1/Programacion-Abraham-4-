package hangMan;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MarcosReadAndWritingPlayers {

	public static void main(String[] args) {
		
		final String OUT_PATH="C:\\ProgFiles\\players.omg";
		final String IN_PATH="C:\\output\\result.omg";
		ArrayList<Player>playerList = new ArrayList<Player>();
		
		try {
		readFile(OUT_PATH);
		System.out.println("Total Players: "+playerList.size());
		System.out.println("AveragePuntuation: "+averagePuntuation(playerList));
		Player best = maxPuntuation(playerList);
		System.out.println("Best Player: "+best);
		} catch (EOFException e) {
		
			System.out.println("End of the file");
			
		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	private static ArrayList<Player> readFile(final String OUT_PATH) throws EOFException, FileNotFoundException,IOException,ClassNotFoundException{
		ArrayList<Player>list=new ArrayList<Player>();
		try {
			ObjectInputStream readPlayer = new ObjectInputStream (new FileInputStream(OUT_PATH));
			System.out.println("Players List:\n");
			
			while(true) {
				
				try {
					Player player = (Player) readPlayer.readObject();
					list.add(player);
					System.out.println(player);
					
			}catch(EOFException e) {
				System.out.println("End of file");
				break; //Rompe el bucle infinito the end of the file
			}
			
			}
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
	
		}catch (IOException e) {
			
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	private static float averagePuntuation(ArrayList<Player>playerList){
		int sum=0;
		float average=0;
		for(Player player : playerList) {
			sum+=player.getPuntuation();
			
		}
		average=sum/playerList.size();
		return average;
	}
	
	private static Player maxPuntuation(ArrayList<Player>playerList) {
		
		if (playerList.isEmpty()) return (Player) null;
        Player max = playerList.get(0);
        for (Player p : playerList) {
            if (p.getPuntuation() > max.getPuntuation()) max = p;
        }
        return max;
	}
	}

