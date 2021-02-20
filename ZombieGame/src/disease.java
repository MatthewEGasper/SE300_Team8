/* File: Disease.java
 * Name: Disease
 * Desc: This class is meant to store the characteristics of the team's zombie game disease
 * Auth: Elijah Jenkins
 * Date: 2/19/2021
 */
public class disease {
	private float mutationRate = 0, lethality = 0;
	private int tempLimitLow = 0, tempLimitHigh = 0, humidityLimitLow = 0, humidityLimitHigh = 0;
	private float transmissionRange = 0;
	private int lifespan = 0;
	

	public float getMutationRate() {
		return mutationRate;
	}

	public void setMutationRate(float mutationRate) {
		this.mutationRate = mutationRate;
	}

	public float getLethality() {
		return lethality;
	}

	public void setLethality(float lethality) {
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

	public float getTransmissionRange() {
		return transmissionRange;
	}

	public void setTransmissionRange(float transmissionRange) {
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
}
