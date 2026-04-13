package storageOfObjects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.io.FileOutputStream;

public class ObjectWriting {

	public static void main(String[] args) {
		final String OUT_PATH= "C:\\ProgFiles\\objects.ftw";
		try {
		ObjectOutputStream objectFile = new ObjectOutputStream(new FileOutputStream(OUT_PATH));
		
		Book book1 = new Book();
		Book book2 = new Book("Title","Anacleto",55,90,LocalDate.now());
		Book book3 = new Book("Cucarachas crudas","Valentina",55,3,LocalDate.of(1997, 4, 14));
		
		objectFile.writeObject(book1);
		objectFile.writeObject(book2);
		objectFile.writeObject(book3);
		
		objectFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
