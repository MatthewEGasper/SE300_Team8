/* File: DataRecorder.java
 * Name: DataRecorder
 * Desc: This class is meant to act as a storage container for the Zombie Simulator,
 * 		 recording different values and statistics of the on going simulation.
 * Auth: Matthew Gasper
 * Date: 2/19/2021
 */

public class DataRecorder {
	private int population=0, infectedPopulation=0, immunePopulation=0;
	private int dPopulation=0, dInfectedPopulation=0, dImmunePopulation=0;
	private float infectionRate=0, mortalityRate=0, recoveryRate=0;
	private float dInfectionRate=0, dMortalityRate=0, dRecoveryRate=0;
	
	public void setPopulation(int num) 				{population=num;}
	public void setInfectedPopulation(int num)		{infectedPopulation=num;}
	public void setImmunePopulation(int num)		{immunePopulation=num;}
	public void setDpopulation(int num)				{dPopulation=num;}
	public void setDinfectedPopulation(int num)		{dInfectedPopulation=num;}
	public void setDimmunePopulation(int num)		{dImmunePopulation=num;}
	public void setInfectionRate(float num)			{infectionRate=num;}
	public void setMortalityRate(float num)			{mortalityRate=num;}
	public void setRecoveryRate(float num)			{recoveryRate=num;}
	public void setDinfectionRate(float num)		{dInfectionRate=num;}
	public void setDmortalityRate(float num)		{dMortalityRate=num;}
	public void setDrecoveryRate(float num)			{dRecoveryRate=num;}
//-----------------------------------------------------------------------------
	public int   getPopulation()			{return population;}
	public int	 getInfectedPopulation()	{return infectedPopulation;}
	public int 	 getImmunePopulation()		{return immunePopulation;}
	public int 	 getDpopulation()			{return dPopulation;}
	public int	 getDinfectedPopulation()	{return dInfectedPopulation;}
	public int	 getDImmunePopulation()		{return dImmunePopulation;}
	public float getInfectionRate()			{return infectionRate;}
	public float getMortalityRate()			{return mortalityRate;}
	public float getRecoveryRate()			{return recoveryRate;}
	public float getDinfectionRate()		{return dInfectionRate;}
	public float getDmortalityRate()		{return dMortalityRate;}
	public float getDrecoveryRate()			{return dRecoveryRate;}
}
