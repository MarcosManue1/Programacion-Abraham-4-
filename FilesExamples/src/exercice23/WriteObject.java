package exercice23;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriteObject {

	public static void main(String[] args) {
		
		final String OUT_PATH= "C:\\ProgFiles\\employees.ftw";
		Scanner keyboard = new Scanner (System.in);
		
		try {
			ObjectOutputStream writeObject = new ObjectOutputStream(new FileOutputStream(OUT_PATH));
			Employees emp1 = new Employees();
			Employees emp2 = new Employees("Valentino", 1300f, 23);
			Employees emp3 = new Employees("Diana", 1400f, 24);
			
			writeObject.writeObject(emp1);
			writeObject.writeObject(emp2);
			writeObject.writeObject(emp3);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
}
