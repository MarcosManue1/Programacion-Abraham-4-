package filesExamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class fileExample1 {
	
	public static void main(String[] args) {
		
		final String PATH="C:\\ProgFiles";
		File file = new File(PATH,"File.txt");
		boolean haveLines=true;
		ArrayList<String> poema=new ArrayList();
		try {
			
			Scanner input = new Scanner(file);
			String line;
			
			while(haveLines) {
				
				line = input.nextLine();
				poema.add(line);
				System.out.println(line);
			}
			
		} catch(NoSuchElementException e){
			haveLines=false;
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void checkFile(File file) {
		
		System.out.println("Exists \t\t"+file.exists());
		System.out.println("is a Directory \t"+file.isDirectory());
		System.out.println("is a File \t"+file.isFile());
		System.out.println("Can write "+file.canWrite());
		System.out.println("Can read "+file.canRead());
		System.out.println(file.lastModified());
		
		}
	
	
}
