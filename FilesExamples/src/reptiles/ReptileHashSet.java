package reptiles;

import java.util.HashSet;
import java.util.Iterator;

public class ReptileHashSet {

	public static void main(String[] args) throws InvalidNumberException{
		
		String url = "jdbc:mysql://10.203.28.74:3306/reptileDB";
		String user = "alumno";
		String password = "primero";
		
		HashSet set=new HashSet();
		
		set.add(new Reptile(24,24,24,"MarcosSet"));
		set.add(new Reptile(24,24,24,"MarcosSet"));
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
