package filesExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Repaso {
	
	public static void main(String[] args) {
		final String PATH="C:\\ProgFiles";
		File file = new File(PATH,"Spliter.txt");
		char readedChar;
		int auxInt;
		String auxStr;
		ArrayList<String>reverseFile=new ArrayList<String>();
		
		if(!file.isFile()) {
		System.out.println("The file is not a file ");
		}else {
			
			try {
				FileReader fileReader = new FileReader(file,StandardCharsets.UTF_8);
				BufferedReader bufferedReader = new BufferedReader(fileReader);		
				
				do {
					auxStr=bufferedReader.readLine();
					if(auxStr != null)
						reverseFile.add(auxStr);
					//System.out.println(auxStr);
				}while(auxStr!=null);
				
				for (int i = reverseFile.size() - 1; i >= 0; i--) {
				    System.out.println(reverseFile.get(i));
				}
				/*do {
				
					auxInt=fileReader.read();
					readedChar=(char)auxInt;
					System.out.println(readedChar);
				}while(auxInt != -1);
				*/
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}	
}
