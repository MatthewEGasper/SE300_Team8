/* File: Contagion.java
 * Name: Contagion
 * Desc: This class has consumed the scope of DiseaseFighterCalculator and includes DiseaseSSpreadCalculator and ResponseThresholdCalculator.
 * It is best to consider this class a decentralized calculator for various interactions in the simulation.
 * Auth: Elijah Jenkins/Bryan Polk
 * Date: 4/23/2021
 * 
 * TODO: Fix the function descriptions because I was lazy and didn't rewrite them yet -Bryan 4/23/21
 */

import java.util.ArrayList;
import java.util.Random;

public class Contagion {
	// Declare global variables
	private Random rng;
	private Disease disease;
	public Contagion(Disease disease) {
		rng = new Random(System.nanoTime());
		this.disease = disease;
	}

	/*
	 * Last edited 4/23/21 Bryan Polk The disease fighter calculator takes a person
	 * and checks for disease. This calculator is currently able to randomize damage
	 * to the infected person based on the disease's lethality and the person's
	 * immune system resistance, and updates the disease's lifespan variable after
	 * iterating to reflect the time passing.
	 */
	private void diseaseFighterCalculator(Person person) {
		//If the person has remaining disease lifespan on their infection
		if (person.getDiseaseCounter() > 0)
		{
			// Sets the damage to a randomized value and updates person health and disease
			// lifespan for the iteration
			float damage = (int) ((disease.getLethality() - person.getImmuneSystemResistance())
					* rng.nextInt(10));
			person.setHealth(person.getHealth() - damage);
			person.setDiseaseCounter(person.getDiseaseCounter() - 1);
			// Checks if a condition has been met to either say the person has died or the
			// disease has been fought off
			if (person.getHealth() <= 0) {
				person.setLifeState(false);
			}
			if (person.getDiseaseCounter() == 0) {
				person.setRecovered();
			}
		}
	}

	/*
	 * Last edited 4/23/21 Bryan Polk The disease spread calculator considers the
	 * spread between two members of a MinorGroup. It checks to see if members of a
	 * group have any diseases to spread, then simulates the possibility of an
	 * infected individual contacting an at risk individual. Furthermore, it
	 * simulates the possible spread of the virus to the at risk individual, and
	 * will update their disease parameter as needed.
	 */
	public void diseaseCalculator(MinorGroup group) {
		float infectedPercent = calculatePercentInfected(group);
		// check each group member for vulnerability
		for (int i = 0; i < group.getPeople().size(); i++) {
			if (group.getPeople().get(i).getSusceptible()) {
				// upon finding an at risk group member, check their exposure against the group's level of infection
				if(group.getPeople().get(i).getExposureLevel() * infectedPercent > rng.nextFloat()*10)
				{
					group.getPeople().get(i).setExposed();
					group.getPeople().get(i).setExposureTimer(disease.getLifespan()*2);
				}
				
			}
			if (group.getPeople().get(i).getExposed())
			{
				//If they've been exposed, determine if they are infected
				if(group.getPeople().get(i).getImmuneSystemResistance()/disease.getTransmissionRange() >
					rng.nextFloat()*10	)
				{
					group.getPeople().get(i).setInfected();
					group.getPeople().get(i).setDiseaseCounter(disease.getLifespan());
				}
				else
				{
					group.getPeople().get(i).decrementExposureTimer();
					if(group.getPeople().get(i).getExposureTimer() == 0)
					{
						group.getPeople().get(i).setSusceptible(true);
					}
				}
			}
			if(group.getPeople().get(i).getInfected())
			{
				diseaseFighterCalculator(group.getPeople().get(i));
			}
		}
	}

	/*
	 * Last edited 3/11/21 Bryan Polk The response threshold calculator considers
	 * the given group's exposure level and response threshold, and if the threshold
	 * is met will reduce the baseline exposure of all group members based on the
	 * innate response strength value of the group. It will then update the value of
	 * the baseline exposure to reflect the changes.
	 
	public void responseThresholdCalculator(MinorGroup group) {
		// if the group's exposure is above the set threshold
		if (group.getBaselinePopulationExposure() > group.getResponseThreshold()) {
			// reduce all group members' exposure levels in accordance with the response
			// strength of the group
			for (int i = 0; i < group.getPeople().size(); i++) {
				group.getPeople().get(i)
						.setExposureLevel(group.getPeople().get(i).getExposureLevel() - group.getResponseStrength());
			}
			group.setBaselinePopulationExposure(calculateBaselineExposure(group));
		}
	}

					********METHOD CURRENTLY NOT IN USE.*********
	*/
	
	
	
	/*
	 * Last edited 4/23/21 Bryan Polk This function calculates a group's percentile of infected individuals.
	 */
	private float calculatePercentInfected(MinorGroup group) {
		float avg = 0;
		for (int i = 0; i < group.getPeople().size(); i++) {
			if(group.getPeople().get(i).getExposed())
			{
				avg++;
			}
		}
		avg = avg / group.getPeople().size();

		return avg;
	}

	// I edited the code for syntax errors. -Bryan (Elijah coded this section)
	public void calculateMutationChange(Disease d) {
		int mutationChances = d.getMutationChances();
		boolean lethalityTF = true, transmissionTF = true, lifespanTF = true;

		if (d.getLethality() >= 10 && lethalityTF) {
			mutationChances = mutationChances - 1;
			lethalityTF = false;
		}

		if (d.getTransmissionRange() >= 10 && transmissionTF) {
			mutationChances = mutationChances - 1;
			transmissionTF = false;
		}

		if (d.getLifespan() >= 28 && lifespanTF) {
			mutationChances = mutationChances - 1;
			lifespanTF = false;
		}

		d.setMutationChances(mutationChances);

		if (mutationChances > 0) {

			if (d.getLethality() < 10) {
				double changeLethalityProbability = Math.random();
				if (changeLethalityProbability < d.getMutationRate() / mutationChances) {
					double newLethality = (d.getLethality() * ((Math.random() * 0.2) + 0.05) + d.getLethality());

					if (newLethality > 10) {
						newLethality = 10;
					}
					d.setLethality(newLethality);
				}
			}

			if (d.getTransmissionRange() < 10) {
				double changeTransmissionProbability = Math.random();
				if (changeTransmissionProbability < d.getMutationRate() / mutationChances) {
					double newTransmission = (d.getTransmissionRange() + 0.5);

					if (newTransmission > 10) {
						newTransmission = 10;
					}
					d.setTransmissionRange(newTransmission);
				}
			}

			if (d.getLifespan() < 28) {
				double changeLifespanProbability = Math.random();
				if (changeLifespanProbability < d.getMutationRate() / mutationChances) {
					int newLifespan = (d.getLifespan() + 2);

					if (newLifespan > 28) {
						newLifespan = 28;
					}
					d.setLifespan(newLifespan);
				}
			}
		}
	}
}