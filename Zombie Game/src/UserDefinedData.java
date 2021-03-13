import java.util.Scanner;

public class UserDefinedData {
	private Scanner scan = new Scanner(System.in);
	private int iterations;
	private int groupNumber;
	private int groupSize;
	private double mutationRate;
	private double transmissionRange;
	private double lethality;
	private int lifespan;
	private int skip;
	
	private void defineMutationRate() {
		System.out.println("Enter level number of mutation rate of disease (1: high, 2: medium, 3: low, 0: no mutation)");
		int temp = scan.nextInt();
		if (temp == 3) {
			mutationRate = 0.0001;
		} else if (temp == 2) {
			mutationRate = 0.00001;
		} else if (temp == 1) {
			mutationRate = 0.000001;
		} else if (temp == 0) {
			mutationRate = 0;
		} else {
			this.defineMutationRate();
		}
	}
	
	public void defineData() {
		System.out.println("Enter iterationns");
		iterations = scan.nextInt();
		System.out.println("Enter group number");
		groupNumber = scan.nextInt();
		System.out.println("Enter group size");
		groupSize = scan.nextInt();
		defineMutationRate();
		transmissionRange = 0; 
		while (transmissionRange < 0.5 || transmissionRange > 10) {
			System.out.println("Enter transmission range of disease (0.5-10)");
			transmissionRange = scan.nextDouble();
		}
		lethality = 0; 
		while (lethality < 1 || lethality > 10) {
			System.out.println("Enter lethality of disease (1-10)");
			lethality = scan.nextDouble();
		}
		lifespan = 0; 
		while (lifespan < 5 || lifespan > 28) {
			System.out.println("Enter lifespan of disease (integer from 5-28)");
			lifespan = scan.nextInt();
		}
		System.out.println("Skip to? (enter 0 for no)");
		skip = scan.nextInt();
		
	}
	
	// setters
	
	// getters 
	public int getIterations() {return iterations;}
	public int getGroupNumber() {return groupNumber;}
	public int getGroupSize() {return groupSize;}
	public double getMutationRate() {return mutationRate;}
	public double getTransmissionRange() {return transmissionRange;}
	public double getLethality() {return lethality;}
	public int getLifespan() {return lifespan;}
	public int skip() {return skip;}
}
