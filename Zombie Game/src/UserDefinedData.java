
import java.util.Scanner;

public class UserDefinedData {
	private Scanner scan = new Scanner(System.in);
	private int iterations;
	// private int groupNumber;
	private int groupSize;
	private double mutationRate;
	private double transmissionRange;
	private double lethality;
	private int lifespan;

	private void defineMutationRate() {
		System.out.println("Enter level number of mutation rate of disease (1: high, 2: medium, 3: low, 0: no mutation)");
		try {
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
			
		} catch (Exception x) {
			scan = new Scanner(System.in);
			this.defineMutationRate();
		}
	}

	public void defineData() {
		iterations = -1;
		groupSize = 0;
		transmissionRange = 0;
		lethality = 0;
		lifespan = 0;
		while (iterations < 0) {
			System.out.println("Enter iterations (enter 0 to stop program)");
			try {
				iterations = scan.nextInt();
			} catch (Exception x) {
				System.out.println("Must be integer greater than or equal to 0");
				iterations = -1;
				scan = new Scanner(System.in);
			}
		}
		if (iterations > 0) {
			while (groupSize < 1) {
				System.out.println("Enter group size");
				try {
					groupSize = scan.nextInt();
				} catch (Exception x) {
					System.out.println("Must be integer greater than 0");
					groupSize = 0;
					scan = new Scanner(System.in);
				}
			}
			defineMutationRate();
			while (transmissionRange < 0.5 || transmissionRange > 10) {
				System.out.println("Enter transmission range of disease (0.5-10)");
				try {
					transmissionRange = scan.nextDouble();
				} catch (Exception x) {
					System.out.println("Must be number between 0.5 and 10");
					transmissionRange = -1;
					scan = new Scanner(System.in);
				}
			}
			while (lethality < 1 || lethality > 10) {
				System.out.println("Enter lethality of disease (1-10)");
				try {
					lethality = scan.nextDouble();
				} catch (Exception x) {
					System.out.println("Must be number between 1 and 10");
					lethality = -1;
					scan = new Scanner(System.in);
				}
			}
			while (lifespan < 5 || lifespan > 28) {
				System.out.println("Enter lifespan of disease (integer from 5-28)");
				try {
					lifespan = scan.nextInt();
				} catch (Exception x) {
					System.out.println("Must be integer bewtween 5 and 28");
					lifespan = 0;
					scan = new Scanner(System.in);
				}
			}
			
		}

	}

	// setters

	// getters
	public int getIterations() {
		return iterations;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public double getMutationRate() {
		return mutationRate;
	}

	public double getTransmissionRange() {
		return transmissionRange;
	}

	public double getLethality() {
		return lethality;
	}

	public int getLifespan() {
		return lifespan;
	}

}