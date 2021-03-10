/* File: Contagion.java
 * Name: Contagion
 * Desc: This class has consumed the scope of DiseaseFighterCalculator and includes DiseaseSSpreadCalculator and ResponseThresholdCalculator.
 * It is best to consider this class a decentralized calculator for various interactions in the simulation.
 * Auth: Elijah Jenkins/Bryan Polk
 * Date: 3/06/2021
 */

import java.util.ArrayList;

public class Contagion {
	//Declare global variables
	private ArrayList<Disease> diseaseArray;
	

	//Default constructor to initialize empty arraylist of diseases.
    public Contagion()
    {
    	diseaseArray = new ArrayList<Disease>();
    }
    

	//disease fighter functionality -> Use combination of lethality and resistance (and random numbers) to 
	//either increase or decrease person's health. resistance could be lowered once person's health drops 
	//below certain threshold, say 15%.
	
	//Currently implemented: Lethality/Resistance interact in calculations
	//Disease lifespan is lowered by one "tick" accordingly
	//Finally, person's health is updated to reflect either recovery or damage taken due to virus.
	//Currently, the changes are not sent to the person's setters to avoid potential issues
	//The only changes would be visible in the variables stored in this class.
	public void diseaseFighterCalculator(Person person)
	{   
		if(person.getDisease() != null)//if the person is infected, calculate the fight process.
		{
			int damage = (int)(person.getDisease().getLethality()-person.getImmuneSystemResistance());	//TBD: Multiply by random value to determine severity of outcome
			//TBD: Potentially add gradual increases to resistance or lethality depending on a treatment boolean?
			person.setHealth(person.getHealth() - damage);
			person.getDisease().setLifespan(person.getDisease().getLifespan()-1);;
		}
	}
	
	
	//To be implemented, determine if disease spreads between group members
	public void diseaseSpreadCalculator(MinorGroup group)
	{
		
	}

	//To be implemented, determine if a group should implement response measures that reduce baseline exposure.
	public void responseThresholdCalculator(MinorGroup group, int responseThreshold)
	{
		
	}
	
	public float calculateBaselineExposure(MinorGroup group)
	{
		float avg = 0;
		for(int i = 0; i < group.getPeople().size(); i++)
		{
			avg += group.getPeople().get(i).getExposureLevel();
		}
		avg = avg/group.getPeople().size();
		
		
		return avg;
	}
	
	public void calculateMutationChange(Disease d) {
		mutationChances = d.getMutationChances();
		boolean lethalityTF = 1, transmissionTF = 1, lifespanTF = 1;
		 

		if (d.getLethality >= 10 && lethalityTF) {
			mutationChances = mutationChances - 1;
			lethalityTF = 0;
		}

		if (d.getTransmissionRange >= 10 && transmissionTF) {
			mutationChances = mutationChances - 1;
			transmissionTF = 0;
		}

		if (d.getLifespan >= 28 && lifespanTF) {
			mutationChances = mutationChances - 1;
			lifespanTF = 0;
		}

		d.setMutationChances(mutationChances);
		
		if (mutationChances > 0) {
		
			if (d.getLethality() < 10) 
			{
				double changeLethalityProbability = Math.random();
				if (changeLethalityProbability < d.getMutationRate()/3) {
					double newLethality = (d.getLethality() * ((Math.random() * 0.2) + 0.05) + d.getLethality());
				
					if (newLethality > 10)
					{
						newLethality = 10;
					}
					d.setLethality(newLethality);
				}
			}

			if (d.getTransmissionRange() < 10) 
			{
				double changeTransmissionProbability = Math.random();
				if (changeTransmissionProbability < d.getMutationRate()/3) {
					double newTransmission = (d.getTransmissionRange() + 0.5);
				
					if (newTransmission > 10)
					{
						newTransmission = 10;
					}
					d.setTransmissionRange(newTransmission);
				}
			}

			if (d.getLifespan() < 28) 
			{	
				double changeLifespanProbability = Math.random();
				if (changeLifespanProbability < d.getMutationRate()/3) {
					int newLifespan = (d.getLifespan() + 2);
				
					if (newLifespan > 28) 
					{
						newLifespan = 28;
					}
					d.setLifespan(newLifespan);
				}
			}
		}
	}
}