import java.util.ArrayList;

// File: MinorGroup.java
// Name: MinorGroup
// Desc: This class is meant to store the characteristics of the MinorGroup of the population 
// Auth: Jorge Santos
// Date: 2/21/2021

public class MinorGroup {
	private ArrayList<Person> people = new ArrayList<Person>();
	private Climate climate;
	private DataRecorder recorder;
	private int responseThreshold;
	private int initialPopulation;
	private float responseStrength;
	private float baselinePopulationExposure;

	public MinorGroup() {

	}

	public MinorGroup(int responseThreshold, int initialPopulation, float responseStrength,
			float baselinePopulationExposure) {
		this.recorder = new DataRecorder(initialPopulation);
		this.responseThreshold = responseThreshold;
		this.initialPopulation = initialPopulation;
		this.responseStrength = responseStrength;
		this.baselinePopulationExposure = baselinePopulationExposure;
	}
	
	// setters
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

	public void setResponseStrength(float responseStrength) {
		this.responseStrength = responseStrength;
	}

	public void setBaselinePopulationExposure(float baselinePopulationExposure) {
		this.baselinePopulationExposure = baselinePopulationExposure;
	}

	// getters
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

	public float getResponseStrength() {
		return this.responseStrength;
	}

	public float getBaselinePopulationExposure() {
		return this.baselinePopulationExposure;
	}
}