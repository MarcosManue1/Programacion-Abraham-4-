package storageOfObjects;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReading {

	public static void main(String[] args) {
		final String OUT_PATH= "C:\\ProgFiles\\objects.ftw";
		
		
		try {
			ObjectInputStream objectFile = new ObjectInputStream(new FileInputStream(OUT_PATH));
			Book rdBook;
			while(true) {
				rdBook=(Book)objectFile.readObject();
				System.out.println(rdBook.toString());
			}
		
		} catch(EOFException e) {
			
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
