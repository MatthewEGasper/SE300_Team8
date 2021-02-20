/* File: Person.java
 * Name: Person
 * Desc: This class is meant to represent an individual member of a group in the Zombie Simulation.
 * Auth: Bryan Polk
 * Date: 2/20/2021
 */

public class Person {
	private float immuneSystemResistance = 0, exposureLevel = 0, health = 0;
	private boolean lifeState = true;
	private boolean[] immunityList = new boolean[0];		//Change to string and add a name variable to diseases? or make this a disease array?
	//private Disease disease; commenting until Disease is implemented.
	
	public void setImmuneSystemResistance(float num) 	{immuneSystemResistance=num;}
	public void setExposureLevel(float num)				{exposureLevel=num;}
	public void setHealth(float num)					{health=num;}
	public void setLifeState(boolean life)				{lifeState=life;}
	public void setImmunityList(boolean[] immunities)	{immunityList=immunities;}
	//public void setDisease(Disease ailment)			{disease=ailment;}	commenting until Disease is implemented.

//-----------------------------------------------------------------------------

	public float getImmuneSystemResistance()	{return immuneSystemResistance;}
	public float getExposureLevel()				{return exposureLevel;}
	public float getHealth()					{return health;}
	public boolean getLifeState()				{return lifeState;}
	public boolean[] getImmunityList()			{return immunityList;}
	//public float getDisease()					{return disease;}	commenting until Disease is implemented.
}
