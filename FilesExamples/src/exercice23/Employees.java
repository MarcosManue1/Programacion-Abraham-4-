package exercice23;

import java.io.Serializable;

public class Employees implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String name;
	float salary;
	int age;
	
	public Employees(String name, float salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public Employees() {
		super();
		name="Anacleto";
		salary=1300f;
		age=19;
	}
	@Override
	public String toString() {
		return "Employees [name="+name+", salary="+salary+", age="+age+"]";
	} 
	
	
}
