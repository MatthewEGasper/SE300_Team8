/* File: Disease.java
 * Name: Disease
 * Desc: This class is meant to store the characteristics of the team's zombie game disease
 * Auth: Elijah Jenkins
 * Date: 2/19/2021
 */

public class Disease {
	private double mutationRate = 0, lethality = 0;
	private int tempLimitLow = 0, tempLimitHigh = 0, humidityLimitLow = 0, humidityLimitHigh = 0;
	private double transmissionRange = 0;
	private int lifespan = 0;
	private int mutationChances = 3;

	public Disease() {

	}

	public Disease(double m, double l, double t, int ls) {
		mutationRate = m; // between 0.01% and 0.0001%
		lethality = l;
		transmissionRange = t;
		lifespan = ls;
	}

	public double getMutationRate() {
		return mutationRate;
	}

	public void setMutationRate(double mutationRate) {
		this.mutationRate = mutationRate;
	}

	public double getLethality() {
		return lethality;
	}

	public void setLethality(double lethality) {
		this.lethality = lethality;
	}

	public int getHumidityLimitLow() {
		return humidityLimitLow;
	}

	public void setHumidityLimitLow(int humidityLimitLow) {
		this.humidityLimitLow = humidityLimitLow;
	}

	public int getTempLimitHigh() {
		return tempLimitHigh;
	}

	public void setTempLimitHigh(int tempLimitHigh) {
		this.tempLimitHigh = tempLimitHigh;
	}

	public double getTransmissionRange() {
		return transmissionRange;
	}

	public void setTransmissionRange(double transmissionRange) {
		this.transmissionRange = transmissionRange;
	}

	public int getTempLimitLow() {
		return tempLimitLow;
	}

	public void setTempLimitLow(int tempLimitLow) {
		this.tempLimitLow = tempLimitLow;
	}

	public int getHumidityLimitHigh() {
		return humidityLimitHigh;
	}

	public void setHumidityLimitHigh(int humidityLimitHigh) {
		this.humidityLimitHigh = humidityLimitHigh;
	}

	public int getLifespan() {
		return lifespan;
	}

	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}

	public int getMutationChances() {
		return mutationChances;
	}

	public void setMutationChances(int mutationChances) {
		this.mutationChances = mutationChances;
	}
}