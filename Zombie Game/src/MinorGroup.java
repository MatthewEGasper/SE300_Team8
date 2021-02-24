// File: MinorGroup.java
// Name: MinorGroup
// Desc: This class is meant to store the characteristics of the MinorGroup of the population 
// Auth: Jorge Santos
// Date: 2/21/2021


public class MinorGroup {
	private Person person;
	private Climate climate;
	private int responseThreshold;
	private int initialPopulation;
	private int responseStrength;
	private int baselinePopulationExposure;
	
	
	
	//setters
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setClimate(Climate climate) {
		this.climate = climate;
	}
	
	public void setResponseThreshold(int responseThreshold) {
		this.responseThreshold = responseThreshold;
	}
	
	public void setInitialPopulation(int initialPopulation) {
		this.initialPopulation = initialPopulation;
	}
	
	public void setResponseStrength(int responseStrength) {
		this.responseStrength = responseStrength;
	}
	
	public void setBaselinePopulationExposure(int baselinePopulationExposure) {
		this.baselinePopulationExposure = baselinePopulationExposure;
	}
	
	//getters
	public Person getPerson() {
		return this.person;
	}

	public Climate getClimate() {
		return this.climate;
	}

	public int getResponseThreshold() {
		return this.responseThreshold;
	}

	public int getInitialPopulation() {
		return this.initialPopulation;
	}

	public int getResponseStrength() {
		return this.responseStrength;
	}

	public int getBaselinePopulationExposure() {
		return this.baselinePopulationExposure;
	}
}
