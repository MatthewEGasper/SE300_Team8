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
	private boolean susceptible = false, exposed = false, infected = false, recovered = false;
	private int diseaseCounter, exposureTimer;

	public Person() {
		health = (float) (Math.random() * 11);
		immuneSystemResistance = (float) (Math.random() * 11);
		exposureLevel = (float) (Math.random() * 11);
		susceptible = true;
		infected = false;
		recovered = false;
	}
	
	public void decrementExposureTimer() {
		this.exposureTimer--;
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
		if(!life)
		{
			susceptible = false;
			exposed = false;
			infected = false;
			recovered = false;
		}
	}

	public void setSusceptible(boolean s) {
		susceptible = s;
		if(s)
		{
			exposed = false;
			infected = false;
			recovered = false;
		}
	}
	
	public void setExposed()
	{
		exposed = true;
		susceptible = false;
	}
	
	public void setInfected() {
		infected = true;
		susceptible = false;
		exposed = false;
	}
	
	public void setRecovered() {
		recovered = true;
		infected = false;
		exposed = false;
		susceptible = false;
	}

	public void setDiseaseCounter(int diseaseCounter) {
		this.diseaseCounter = diseaseCounter;
	}
	
	public void setExposureTimer(int exposureTimer) {
		this.exposureTimer = exposureTimer;
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
	
	public boolean getSusceptible() {
		return susceptible;
	}
	
	public boolean getExposed() {
		return exposed;
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

	public int getExposureTimer() {
		return exposureTimer;
	}
}