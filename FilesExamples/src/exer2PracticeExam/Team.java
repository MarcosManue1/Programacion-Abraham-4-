package exer2PracticeExam;

import java.io.Serializable;

public class Team implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String motoBrand;
	private int victories;
	
	public Team(int id, String name, String motoBrand, int victories) {
		super();
		this.id = id;
		this.name = name;
		this.motoBrand = motoBrand;
		this.victories = victories;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the motoBrand
	 */
	public String getMotoBrand() {
		return motoBrand;
	}

	/**
	 * @param motoBrand the motoBrand to set
	 */
	public void setMotoBrand(String motoBrand) {
		this.motoBrand = motoBrand;
	}

	/**
	 * @return the victories
	 */
	public int getVictories() {
		return victories;
	}

	/**
	 * @param victories the victories to set
	 */
	public void setVictories(int victories) {
		this.victories = victories;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", motoBrand=" + motoBrand + ", victories=" + victories + "]";
	}
	
	
}
