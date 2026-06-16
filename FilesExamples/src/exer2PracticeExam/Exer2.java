package exer2PracticeExam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Exer2 {

	final static String TEST_PATH="C:\\ProgFiles";
	
	public static void main(String[] args) {
		
		File file = new File(TEST_PATH + "\\MotoGPTeams1.ftw");
		
		if(!file.exists() || !file.isFile()) {
			System.out.println("Error, The file doesn't exists");
			System.out.println("Goodbye");
			return;
		}
		
		System.out.println("Reading data, loading...");
		ArrayList<Team>teamList = readFile(file);
		for (Team t : teamList) {
			System.out.println(t);
			
			
		}
	}

	public static ArrayList<Team> readFile(File fich) {
		
		ArrayList<Team> teamsList = new ArrayList<>();
		
		if (fich.length() == 0) {
			return teamsList;
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich))) {
			
			teamsList = (ArrayList<Team>) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error while reading: " + e.getMessage());
		}
		
		return teamsList;
	}
}
