package exercice23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

	public static void main(String[] args) {
		
		final String OUT_PATH= "C:\\ProgFiles\\employees.ftw";
		
		
		 try {
			ObjectInputStream inputEmployee = new ObjectInputStream(new FileInputStream(OUT_PATH));
		
			System.out.println("Employees List:\n");
			
			
			while(true) {
				Employees emp;
				try {
					emp = (Employees) inputEmployee.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(emp);
			}
		 
		 } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
}
