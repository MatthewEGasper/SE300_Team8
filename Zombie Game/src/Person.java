import java.util.ArrayList;

/* File: Person.java
 * Name: Person
 * Desc: This class is meant to represent an individual member of a group in the Zombie Simulation.
 * Auth: Bryan Polk
 * Date: 2/20/2021
 */

public class Person {
	private float immuneSystemResistance = 0, exposureLevel = 0, health = 0;
	private boolean lifeState = true;
	private ArrayList<Disease> immunityList = new ArrayList<Disease>(); // Change to string and add a name variable to
																																			// diseases? or make this a disease array?
	private Disease disease;
	private boolean hasDisease = false;
	
	private boolean susceptible = false, infected = false, recovered = false;
	private int diseaseCounter;

	public Person() {
		health = (float) (Math.random() * 11);
		immuneSystemResistance = (float) (Math.random() * 11);
		exposureLevel = (float) (Math.random() * 11);
		susceptible = true;
	}

	public Person(Disease disease) {
		this.disease = disease;
		health = (float) (Math.random() * 11);
		immuneSystemResistance = (float) (Math.random() * 11);
		hasDisease = true;
		exposureLevel = (float) (Math.random() * 11);
		infected = true;
	}

	public void setImmuneSystemResistance(float num) {
		immuneSystemResistance = num;
	}

	public void setExposureLevel(float num) {
		exposureLevel = num;
	}

	public void setHealth(float num) {
		health = num;
		if (health <= 0) {
			this.setLifeState(false);
		}
	}

	public void setLifeState(boolean life) {
		lifeState = life;
	}

	public void setImmunityList(ArrayList<Disease> immunities) {
		immunityList = immunities;
	}

	public void setDisease(Disease ailment) {
		disease = ailment;
	}
	
	public void setSusceptible(boolean s) {
		susceptible = s;
	}
	
	public void setInfected() {
		infected = true;
		susceptible = false;
	}
	
	public void setRecovered() {
		recovered = true;
		infected = false;
	}

	// -----------------------------------------------------------------------------

	public float getImmuneSystemResistance() {
		return immuneSystemResistance;
	}

	public float getExposureLevel() {
		return exposureLevel;
	}

	public float getHealth() {
		return health;
	}

	public boolean getLifeState() {
		return lifeState;
	}

	public ArrayList<Disease> getImmunityList() {
		return immunityList;
	}

	public Disease getDisease() {
		return disease;
	}

	public boolean getHasDisease() {
		return hasDisease;
	}
	
	public boolean getSusceptible() {
		return susceptible;
	}
	
	public boolean getInfected() {
		return infected;
	}
	
	public boolean getRecovered() {
		return recovered;
	}

	public int getDiseaseCounter() {
		return diseaseCounter;
	}

	public void setDiseaseCounter(int diseaseCounter) {
		this.diseaseCounter = diseaseCounter;
	}
}