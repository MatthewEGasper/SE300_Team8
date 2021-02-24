/* File: DataRecorder.java
 * Name: DataRecorder
 * Desc: This class is meant to act as a calculator for the statistics involved
 * 		 within the simulator.
 * Auth: Matthew Gasper
 * Date: 2/21/2021
 */
public class DataCalculator {
	private int old_population=0, old_infectedPopulation=0, old_immunePopulation=0;
	private float old_infectionRate=0, old_mortalityRate=0, old_recoveryRate=0;
	
	public int calcDPopulation(int current_population) {
		int dPopulation=0;
		dPopulation = current_population-old_population;
		return dPopulation;
	}
	public int calcDInfectedPopulation(int current_infectedPopulation) {
		int dInfectedPopulation=0;
		dInfectedPopulation = current_infectedPopulation-old_infectedPopulation;
		return dInfectedPopulation;
	}
	public int calcDImmunePopulation(int current_immunePopulation) {
		int dImmunePopulation=0;
		dImmunePopulation = current_immunePopulation-old_immunePopulation;
		return dImmunePopulation;
	}
	public float calcInfectionRate(int total_infectedPopulation) {
		float infectionRate=0;
		infectionRate = total_infectedPopulation/old_population;
		return infectionRate;
	}
	public float calcMortalityRate(float total_infectedPopulation, float total_killed) {
		float mortalityRate=0;
		mortalityRate = total_killed/total_infectedPopulation;
		return mortalityRate;
	}
	public float calcRecoveryRate(float total_infectedPopulation, float immunePopulation) {
		float recoveryRate=0;
		recoveryRate = total_infectedPopulation/immunePopulation;
		return recoveryRate;
	}
	public float calcDInfectionRate(float current_infectionRate) {
		float dInfectionRate=0;
		dInfectionRate = current_infectionRate-old_infectionRate;
		return dInfectionRate;
	}
	public float calcDMortalityRate(float current_mortalityRate) {
		float dMortalityRate=0;
		dMortalityRate = current_mortalityRate - old_mortalityRate;
		return dMortalityRate;
	}
	public float calcDRecoveryRate(float current_recoveryRate) {
		float dRecoveryRate=0;
		dRecoveryRate = current_recoveryRate - old_recoveryRate;
		return dRecoveryRate;
	}
}
