import java.util.ArrayList;

// File: MinorGroup.java
// Name: MinorGroup
// Desc: This class is meant to store the characteristics of the MinorGroup of the population 
// Auth: Jorge Santos
// Date: 2/21/2021


public class MinorGroup {
	private ArrayList<Person> people = new ArrayList<Person>();
	private Climate climate;
	private DataRecorder recorder = new DataRecorder();
	private int responseThreshold;
	private int initialPopulation;
	private int responseStrength;
	private int baselinePopulationExposure;
	
	public MinorGroup() {
		
	}
	
	public MinorGroup(int responseThreshold, int initialPopulation, int responseStrength, int baselinePopulationExposure) {
		this.responseThreshold = responseThreshold;
		this.initialPopulation = initialPopulation;
		this.responseStrength = responseStrength;
		this.baselinePopulationExposure = baselinePopulationExposure;
	}
	
	//setters
	public void setPeople(ArrayList<Person> people) {
		this.people = people;
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
	public ArrayList<Person> getPeople() {
		return this.people;
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
