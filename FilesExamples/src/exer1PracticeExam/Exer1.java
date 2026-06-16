package exer1PracticeExam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exer1 {

	final static String OUTPUT_PATH="C:\\output";
	final static String TEST_PATH="C:\\ProgFiles";
	
	public static void main(String[] args) {
		
		File inputFile = new File(TEST_PATH + "\\valeRossi.txt");
		File outputFile = new File(OUTPUT_PATH + "\\ModifyValeRossi.txt");
		
		ArrayList<String> changedContent = readFileRossi(inputFile);
		printRossi(changedContent);
		
		writeFileRossi(outputFile, changedContent);
	}

	public static ArrayList<String> readFileRossi(File fich){
		ArrayList<String> valentinoRossi = new ArrayList<>();
		
		try {
			BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fich));
			String line;
			int lineNumber=1;
			while((line = bufferedFileReader.readLine()) != null) {
				if(lineNumber % 2 != 0) {
					valentinoRossi.add(line.toLowerCase());
				}else {
					valentinoRossi.add(line.toUpperCase());
				}
				lineNumber++;
			}
		} catch (IOException e) {
			
			System.out.println("Error while reading the file."+e.getMessage());
			
		}
		return valentinoRossi;
	}
	
	public static void printRossi(ArrayList<String> list) {
		if (list.isEmpty()) {
			System.out.println("The list is empty");
			return;
		}
		
		for (String line : list) {
			System.out.println(line);
		}
	}
	public static void writeFileRossi(File DestinedFich, ArrayList<String> list) {
		
		File file = new File(OUTPUT_PATH);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		try {
			BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(DestinedFich));
			for (String line : list) {
				bufferedFileWriter.write(line);
				bufferedFileWriter.newLine(); 
			}
			bufferedFileWriter.close(); 
			System.out.println("File saved Succesfully: " + DestinedFich.getAbsolutePath());
			
		} catch (IOException e) {
			System.out.println("Error while writing the file: " + e.getMessage());
		}
		/*
		 Create a package called exer2 You are given a file containing objects of the class Team(you must create it). This class has the following private
		 attributes:
		 
		 private int id;
		private String name;
		private String motoBrand;
		private int victories;
		
		Create any methods you consider neccesary.
		Once the team class is created, create another class Exer2 where yoy will complete the excercice:
		
		1. Check if the file "MotoGPTeams.ftw" located in C:\\ProgFiles exists and is a file. If it does not exist or is a directory display an error and terminte the program.
		2. If it is a file, read its content(readFile(file Fich):ArrayList<Team>), create a new team making sure there is no existing one with the same id and name and add all data (existing + new) to the file >> writeFile(File fich, ArrayList<Team>):void
		*/
		}
	}

