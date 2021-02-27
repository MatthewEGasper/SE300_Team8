/* File: diseaseFighterCalculator.java
 * Name: Disease Fighter Calculator
 * Desc: This class is meant to simulate the disease's battle with the body's immune system
 * Auth: Elijah Jenkins/Bryan Polk
 * Date: 2/27/2021
 */

public class diseaseFighterCalculator {
	//Declare global variables
	Person person;
	Disease disease;
	float resistance, lethality;
	int health, lifespan;
	boolean lifeState;
	
	
	//Constructor to initialize values for a singular person
	public diseaseFighterCalculator(Person person)
	{
		this.person = person;
		resistance = this.person.getImmuneSystemResistance();
	    health = this.person.getHealth();
	    lifeState = this.person.getLifeState();
	    disease = this.person.getDisease();
	    lethality = disease.getLethality();
	    lifespan = disease.getLifespan();
	    
	}
	//Empty Constructor, default. I assume this is the ideal use for this class
	//Allows one initialization, then pass each person into the calculation function through
	//this object.
    public diseaseFighterCalculator()
    {
    	this.person = null;
		resistance = 0;
	    health = 0;
	    lifeState = false;
	    disease = null;
	    lethality = 0;
	    lifespan = 0;
    }
    

	//disease fighter functionality -> Use combination of lethality and resistance (and random numbers) to 
	//either increase or decrease person's health. resistance could be lowered once person's health drops 
	//below certain threshold, say 15%.
	
	//Currently implemented: Lethality/Resistance interact in calculations
	//Disease lifespan is lowered by one "tick" accordingly
	//Finally, person's health is updated to reflect either recovery or damage taken due to virus.
	//Currently, the changes are not sent to the person's setters to avoid potential issues
	//The only changes would be visible in the variables stored in this class.
	public void calculateFight(Person person)
	{
		//Update global variables for the new person
		this.person = person;
		resistance = this.person.getImmuneSystemResistance();
	    health = this.person.getHealth();
	    lifeState = this.person.getLifeState();
	    disease = this.person.getDisease();
	    lethality = disease.getLethality();
	    lifespan = disease.getLifespan();
	    
	    
		if(disease != null)//if the person is infected, calculate the fight process.
		{
			float damage = (int)(lethality-resistance);	//TBD: Multiply by random value to determine severity of outcome
			//TBD: Potentially add gradual increases to resistance or lethality depending on a treatment boolean?
			health -= damage;
			lifespan--;
		}
	}
	
	
	//Added a function to update all values pertinent to the person after fight result is calculated
	public void updatePerson(Person person)
	{
		person.setImmuneSystemResistance(resistance);
		person.setHealth(health);
		person.setLifeState(lifeState);
		person.setDisease(disease);
		person.getDisease().setLethality(lethality);
		person.getDisease().setLifespan(lifespan);
	}

}