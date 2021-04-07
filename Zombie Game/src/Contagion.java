/* File: Contagion.java
 * Name: Contagion
 * Desc: This class has consumed the scope of DiseaseFighterCalculator and includes DiseaseSSpreadCalculator and ResponseThresholdCalculator.
 * It is best to consider this class a decentralized calculator for various interactions in the simulation.
 * Auth: Elijah Jenkins/Bryan Polk
 * Date: 3/06/2021
 */

import java.util.ArrayList;
import java.util.Random;

public class Contagion {
	// Declare global variables
	private ArrayList<Disease> diseaseArray;
	private Random rng;

	// Default constructor to initialize empty arraylist of diseases.
	public Contagion() {
		diseaseArray = new ArrayList<Disease>();
		rng = new Random(); // Temporary rng for testing purposes; don't believe it's seeded with system
												// time at the moment.
	}

	/*
	 * Last edited 4/6/21 Bryan Polk The disease fighter calculator takes a person
	 * and checks for disease. This calculator is currently able to randomize damage
	 * to the infected person based on the disease's lethality and the person's
	 * immune system resistance, and updates the disease's lifespan variable after
	 * iterating to reflect the time passing.
	 */
	public void diseaseFighterCalculator(Person person) {
		if (person.getDisease() != null && person.getLifeState() && person.getDisease().getLifespan() > 0)// if the person is infected and alive, calculate the fight process.
		{
			//Sets the damage to a randomized value and updates person health and disease lifespan for the iteration
			float damage = (int) ((person.getDisease().getLethality() - person.getImmuneSystemResistance()) * rng.nextInt(10));
			person.setHealth(person.getHealth() - damage);
			person.getDisease().setLifespan(person.getDisease().getLifespan() - 1);
			//Checks if a condition has been met to either say the person has died or the disease has been fought off
			if(person.getHealth()<= 0)
			{
				person.setLifeState(false);
			}
			if(person.getDisease().getLifespan() == 0)
			{
				ArrayList<Disease> immuneTemp = new ArrayList<Disease>();
				immuneTemp = person.getImmunityList();
				immuneTemp.add(person.getDisease());
				person.setImmunityList(immuneTemp);
				person.setDisease(null);
				
			}
		}
	}

	/*
	 * Last edited 3/11/21 Bryan Polk The disease spread calculator considers the
	 * spread between two members of a MinorGroup. It checks to see if members of a
	 * group have any diseases to spread, then simulates the possibility of an
	 * infected individual contacting an at risk individual. Furthermore, it
	 * simulates the possible spread of the virus to the at risk individual, and
	 * will update their disease parameter as needed.
	 */
	public void diseaseSpreadCalculator(MinorGroup group) {
		// check each group member for infection
		for (int i = 0; i < group.getPeople().size(); i++) {
			if (group.getPeople().get(i).getHasDisease()) {
				// upon finding an infected group member, check interaction with all at risk
				// group members
				for (int j = 0; j < group.getPeople().size(); j++) {
					if (!group.getPeople().get(j).getHasDisease()) {
						// If another member of the group isn't already infected, test for interaction
						if (rng.nextFloat() < group.getPeople().get(i).getExposureLevel()
								* group.getPeople().get(j).getExposureLevel()) {
							// If the random number is smaller than the product of the peoples' exposure
							// levels, they interact.
							if (rng.nextFloat() < group.getPeople().get(i).getDisease().getTransmissionRange()
									* group.getPeople().get(j).getImmuneSystemResistance()) {
								// If the random number is smaller than the product of the transmission value of
								// the disease and the at risk person's immune system
								// The at risk person is infected.
								group.getPeople().get(j).setDisease(group.getPeople().get(i).getDisease());
							}
						}
					}
				}
			}
		}
	}

	/*
	 * Last edited 3/11/21 Bryan Polk The response threshold calculator considers
	 * the given group's exposure level and response threshold, and if the threshold
	 * is met will reduce the baseline exposure of all group members based on the
	 * innate response strength value of the group. It will then update the value of
	 * the baseline exposure to reflect the changes.
	 */
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

	/*
	 * Last edited 3/06/21 Bryan Polk This function calculates a group's average
	 * exposure level across all Person objects it contains.
	 */
	public float calculateBaselineExposure(MinorGroup group) {
		float avg = 0;
		for (int i = 0; i < group.getPeople().size(); i++) {
			avg += group.getPeople().get(i).getExposureLevel();
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