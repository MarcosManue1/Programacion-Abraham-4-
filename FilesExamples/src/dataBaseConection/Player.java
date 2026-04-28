package dataBaseConection;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player>{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	String name;
	int puntuation;
	
	public Player(String name) {
		super();
		this.name = name;
		this.puntuation = puntuation ;
	}

	public Player() {
		super();
		
		name="Dominic";
		puntuation=112;
		
	}

	@Override
	public String toString() {
		return "Players [name="+name+",puntuation="+puntuation+"]";
	}

	public int getPuntuation() {
		
		return puntuation;
	}

	@Override
	public int compareTo(Player o) {
		return this.puntuation-o.puntuation;
	}
}
