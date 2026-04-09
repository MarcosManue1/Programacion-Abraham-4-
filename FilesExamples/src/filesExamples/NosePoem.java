package filesExamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NosePoem {

		public static void main(String[] args) {
			
			final String PATH="C:\\ProgFiles";
			
			
			File noseFile = new File(PATH,"PoemaNariz.txt");
			File copyNoseFile = new File(PATH,"CopiaPoemaNariz.txt");
			String auxStr;
			
			try {
				FileReader fileReader = new FileReader (noseFile);
				BufferedReader buffReader = new BufferedReader(fileReader);
	
				FileWriter fileWriter = new FileWriter (copyNoseFile);
				BufferedWriter buffWrite = new BufferedWriter(fileWriter);
				
				//Leemos y guardamos en el arraylist
				
				ArrayList<String> list = new ArrayList<>();
				while((auxStr=buffReader.readLine())!=null) {
					list.add(auxStr);
				}
				
				for(String line : list) {
					if(line.length()==0) {
						buffWrite.newLine();
					}else {
						
					buffWrite.write(">> "+line.toUpperCase()+"\n");
					
					}
				}
				
				//Cerramos los flujos
				
				buffReader.close();
				buffWrite.close();
				
				System.out.println("Archivo copiado correctamente. ");
				
			}catch(FileNotFoundException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
}
