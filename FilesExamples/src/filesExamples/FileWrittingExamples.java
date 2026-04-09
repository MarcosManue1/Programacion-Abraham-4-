package filesExamples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrittingExamples {

	public static void main(String[] args) {
		
		final String PATH="C:\\ProgFiles";
		
		File file = new File(PATH,"writing.txt");
		
		try {
			//OverWritting
			//FileWriter fileWriter = new FileWriter(file);
			
			FileWriter fileWriter=new FileWriter(file,true); //Write but keeping the previous information, so it doesnt overwrite
			
			BufferedWriter buffWrite = new BufferedWriter(fileWriter);
			fileWriter.write("\n\n---------------------------------------");
			fileWriter.write("\n Hola");
			
			fileWriter.close();
			buffWrite.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
