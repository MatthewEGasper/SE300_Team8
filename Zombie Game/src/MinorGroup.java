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
	private int numSusceptible, numInfected, numRecovered, numDead;

	public MinorGroup() {

	}

	public MinorGroup(int responseThreshold, int initialPopulation, float responseStrength,
			float baselinePopulationExposure) {
		this.recorder = new DataRecorder();
		this.responseThreshold = responseThreshold;
		this.initialPopulation = initialPopulation;
		this.responseStrength = responseStrength;
		this.baselinePopulationExposure = baselinePopulationExposure;
	}
	
	public int getTotalInfected() {
		int totalInfected = 0;
		for(int i=0; i<people.size(); i++) {
			if(people.get(i).getHasDisease()) {
				totalInfected++;
			}
		}
		return totalInfected;
	}
	
	public int getTotalDead() {
		int totalDead = 0;
		for(int i=0; i<people.size(); i++) {
			if(!people.get(i).getLifeState()) {
				totalDead++;
			}
		}
		return totalDead;
	}
	
	public int getTotalImmune() {
		int totalImmune = 0;
		for(int i=0; i<people.size(); i++) {
			if(people.get(i).getImmunityList()!=null) {
				totalImmune++;
			}
		}
		return totalImmune;
	}
	
	public void checkTotals() {
		numSusceptible = 0;
		numInfected = 0;
		numRecovered = 0;
		numDead = 0;
		
		for (int i = 0; i < people.size(); i++) {
			//go through every person in people list
			if ( !people.get(i).getLifeState() ) {
				numDead++;
			}
			else if ( people.get(i).getInfected() ) {
				numInfected++;
			}
			else if ( people.get(i).getRecovered() ) {
				numRecovered++;
			}
			else {
				numSusceptible++;
			}
		}
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

	public void setNumSusceptible(int numSusceptible) {
		this.numSusceptible = numSusceptible;
	}
	
	public void setNumInfected(int numInfected) {
		this.numInfected = numInfected;
	}

	public void setNumRecovered(int numRecovered) {
		this.numRecovered = numRecovered;
	}
	
	public void setNumDead(int numDead) {
		this.numDead = numDead;
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

	public int getNumSusceptible() {
		return numSusceptible;
	}

	public int getNumInfected() {
		return numInfected;
	}

	public int getNumRecovered() {
		return numRecovered;
	}

	public int getNumDead() {
		return numDead;
	}


}