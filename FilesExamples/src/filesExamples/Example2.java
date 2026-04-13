package filesExamples;


import java.io.*;
import java.util.ArrayList;

public class Example2 {

	    // Constantes
	    private static final String OUTPUT_PATH = "c:\\output\\result.txt";

	    public static void main(String[] args) {

	        File file = new File("input.txt"); // archivo de entrada
	        String wordToSearch = "example";   // palabra a buscar

	        ArrayList<String> lines = readFile(file);

	        int wordCount = countWord(lines, wordToSearch);
	        int avgLength = averageLength(lines);
	        int vowels = vowelNumber(lines);
	        int consonants = consonantNumber(lines);

	        writeResults(wordCount, avgLength, vowels, consonants);
	    }

	    // 1. Leer archivo
	    public static ArrayList<String> readFile(File fich) {
	        ArrayList<String> list = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(fich))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                list.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    // 2. Contar palabra
	    public static int countWord(ArrayList<String> list, String word) {
	        int count = 0;

	        for (String line : list) {
	            String[] words = line.split("\\W+");
	            for (String w : words) {
	                if (w.equalsIgnoreCase(word)) {
	                    count++;
	                }
	            }
	        }

	        return count;
	    }

	    // 3. Longitud media de líneas
	    public static int averageLength(ArrayList<String> list) {
	        if (list.isEmpty()) return 0;

	        int total = 0;
	        for (String line : list) {
	            total += line.length();
	        }

	        return total / list.size();
	    }

	    // 4. Número de vocales
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

	    // 5. Número de consonantes
	    public static int consonantNumber(ArrayList<String> list) {
	        int count = 0;

	        for (String line : list) {
	            for (char c : line.toLowerCase().toCharArray()) {
	                if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
	                    count++;
	                }
	            }
	        }

	        return count;
	    }

	    // 6. Escribir resultados
	    public static void writeResults(int wordCount, int avgLength, int vowels, int consonants) {

	        try {
	            File dir = new File("c:\\output");
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }

	            BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_PATH));

	            bw.write("Word count: " + wordCount);
	            bw.newLine();
	            bw.write("Average line length: " + avgLength);
	            bw.newLine();
	            bw.write("Number of vowels: " + vowels);
	            bw.newLine();
	            bw.write("Number of consonants: " + consonants);

	            bw.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
	}
}
