package exercice23;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

public class WriteObject {

	public static void main(String[] args) {
		
		final String OUT_PATH= "C:\\ProgFiles\\employees.ftw";
		Scanner keyboard = new Scanner (System.in);
		ArrayList<Employe>employees = new ArrayList<>();
		
		writeEmployee(OUT_PATH, keyboard);
		
		readEmployee(OUT_PATH);
		
		
		keyboard.close();
	}

	private static void readEmployee(final String OUT_PATH,Arraylist<Employe> employees) {
		
		try {
			ObjectInputStream inputEmploye = new ObjectInputStream(new FileInputStream(OUT_PATH));
			System.out.println("Employees List:\n");
		
			while(true) {
				
					Employees emp = (Employees) inputEmploye.readObject();
					System.out.println(emp);
					
			}
			
		} catch (EOFException e) {
			System.out.println("\nEnd of file reached.");
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}

	private static void writeEmployee(final String OUT_PATH, Scanner keyboard) {
		try {
			ObjectOutputStream employeFile = new ObjectOutputStream(new FileOutputStream(OUT_PATH));
			System.out.println("How many employees?: ");
			int numEmp = keyboard.nextInt();
			keyboard.nextLine();
			
			for(int i = 0; i<numEmp; i++) {
				
				System.out.println("Employee "+(i+1));
				
				System.out.println("Name: ");
				String name = keyboard.nextLine();
				
				System.out.println("Salary: ");
				float salary = keyboard.nextFloat();
				
				System.out.println("Age: ");
				int age = keyboard.nextInt();
				keyboard.nextLine();
				
				Employees emp = new Employees(name, salary, age);
				employeFile.writeObject(emp);
				
			}
			
			employeFile.close();
			System.out.println("Employee saved correctly");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
