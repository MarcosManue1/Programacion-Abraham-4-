package filesExerciceMarcos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class FilesExerMarcos {
	
	final static String OUTPUT_PATH="C:\\output";
	final static String TEST_PATH="C:\\ProgFiles";
	
	public static void main(String[] args) {
		
		 File file = new File("C:\\ProgFiles\\nariz.txt");
	     String wordToSearch = "nariz";   

	     ArrayList<String> lines = readFile(file);
	     
	     int wordCount = countWord(lines, wordToSearch);
	     float avgLength = averageLength(lines);
	     int vowels = vowelNumber(lines);
	   
		writeResults(wordCount, avgLength, vowels);
	     
	     System.out.println("Word count: " + wordCount);
	     System.out.println("Average length: " + avgLength);
	    }

	    // 1. Read from a text file
	    public static ArrayList<String> readFile(File fich) {
	        ArrayList<String> list = new ArrayList<>();

	        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fich))) {
	            String line;
	            while ((line = bufferedFileReader.readLine()) != null) {
	                list.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
		
		//2. Count how many times a given word appears
	    
	    public static int countWord (ArrayList<String>list, String word) {
	    	int count = 0;
	    	
	    	for(String line : list) {
	    		String[]words = line.split("[a-zA-ZáéíóúÁÉÍÓÚ]");
	    			for(String w : words) {
	    				if(w.equalsIgnoreCase(word)) {
	    					count++;
	    				}
	    			}
	    	}
	    	return count;
	    }
	    
		//3. Average length of the lines
	    
	    public static float averageLength(ArrayList<String>list) {
	    	if (list.isEmpty()) return 0;

	        float total = 0;
	        for (String line : list) {
	            total += line.length();
	        }

	        return total / list.size();
	    }
		//4. Number of vowels 
	    
	    public static int vowelNumber(ArrayList<String> list) {
	        int count = 0;

	        for (String line : list) {
	            for (char c : line.toLowerCase().toCharArray()) {
	                if ("aeiou".indexOf(c) != -1) {
	                    count++;
	                }
	            }
	        }

	        return count;
	    }
	    
	    //5. Number of consonants
	    	
	    
	    
	    //6. Show the results
	    public static void writeResults (int wordCount, float avgLength, int vowels) {
	    	
	    	try {
	            File direction = new File("C:\\output");
	            if (!direction.exists()) {
	                direction.mkdirs();
	            }

	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH + "\\result.txt"));
	            
	            bufferedWriter.write("Word count: " + wordCount);
	            bufferedWriter.newLine();
	            bufferedWriter.write("Average length: " + avgLength);
	            bufferedWriter.newLine();
	            bufferedWriter.write("Number Of Vowels: "+ vowels);
	            bufferedWriter.newLine();
	            bufferedWriter.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

