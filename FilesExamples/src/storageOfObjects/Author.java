package storageOfObjects;

import java.io.Serializable;

public class Author implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2793461304098782735L;
	
	String name;
	int age;
	
	public Author(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Author() {
		super();
		
		name="Crescen";
		age=666;
	}
	
	@Override
	public String toString() {
		return "Author [name=" + name + ", age=" + age + "]";
	}
	
	
}
