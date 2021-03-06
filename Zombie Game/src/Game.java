import java.util.Scanner;

public class Game {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		// User inputs simulation info
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter size of group:");
		int groupSize = scan.nextInt();
		System.out.println("Random disease is created.");
		// create Disease and set mutation rate
		Disease d1 = new Disease(Math.random()*0.1, Math.random()*0.5, Math.random()*6, (int)(Math.random()*15));
		
		//create disease fighter calculator
		Contagion contagion = new Contagion();
		
		// create minor group and climate
		MinorGroup group1 = new MinorGroup();
		
		System.out.println("How many iterations of disease mutation?");

		int iterations = scan.nextInt();
		
		// input people into group
		for(int i = 0; i < groupSize; i++) {
			if (Math.random() > 0.5) {
				group1.getPeople().add(new Person(d1));
			} else {
				group1.getPeople().add(new Person());
			}
		}
		
		// show people in group
		printPeople(group1);
		
		// dispay 5 iterations of mutation of disease
		System.out.println("Rate of mutation is: " + d1.getMutationRate());
		for (int i = 0; i < iterations; i++) {
			d1.calculateMutationChange();
			System.out.println("Lethality: " + d1.getLethality());
			System.out.println("Transmission Range: " + d1.getTransmissionRange());
			System.out.println("Life Span: " + d1.getLifespan() + "\n");
			for (int j=0; j<group1.getPeople().size(); j++) {
				if (group1.getPeople().get(j).getHasDisease()) {
					contagion.diseaseFighterCalculator((group1.getPeople().get(j)));
					
				}	
			}
		}
		

		// show people in group
		printPeople(group1);
	}
	
	public static void printPeople(MinorGroup group) {
		String state = "";
		for (int i = 0; i < group.getPeople().size(); i++) {
			if (group.getPeople().get(i).getLifeState() && group.getPeople().get(i).getHealth() > 0) {
				state = "alive, ";
			}
			else {
				state = "dead";
			}
			if (group.getPeople().get(i).getLifeState() && group.getPeople().get(i).getHealth() > 0) {
				System.out.println((i+1) + ": " + state + group.getPeople().get(i).getHealth());
			} else {
				System.out.println((i+1) + ": " + state);
			}
			
		}
	}

}
