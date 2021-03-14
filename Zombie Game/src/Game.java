import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		DataRecorder thingy = new DataRecorder(1);
		thingy.createDataDump();
		thingy.writeDataDumpHeader();
		thingy.appendDataDump();
		thingy.appendDataDump();
		thingy.appendDataDump();
		thingy.readDataDump();
		thingy.readDataDumpRecent();

		thingy.createSaveFile();
		thingy.writeSaveFileHeader();
		thingy.appendSaveFile(0, 0, 0, 0, 0, 0, 0);
		thingy.appendSaveFile(1, 1, 1, 1, 1, 1, 1);
		thingy.appendSaveFile(2, 2, 2, 2, 2, 2, 2);
		thingy.readSaveFile();

		// User inputs simulation info
		Scanner scan = new Scanner(System.in);
		UserDefinedData userData = new UserDefinedData();

		userData.defineData();
		// create Disease and set mutation rate
		Disease d1 = new Disease(userData);

		// create disease fighter calculator
		Contagion contagion = new Contagion();
		
		

		// create minor group and climate
		MinorGroup group1 = new MinorGroup();

		// input people into group
		for (int i = 0; i < userData.getGroupSize(); i++) {
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
		for (int i = 0; i < userData.getIterations(); i++) {
			contagion.calculateMutationChange(d1);
			System.out.println("Lethality: " + d1.getLethality());
			System.out.println("Transmission Range: " + d1.getTransmissionRange());
			System.out.println("Life Span: " + d1.getLifespan() + "\n");
			for (int j = 0; j < group1.getPeople().size(); j++) {
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
			} else {
				state = "dead";
			}
			if (group.getPeople().get(i).getLifeState() && group.getPeople().get(i).getHealth() > 0) {
				System.out.println((i + 1) + ": " + state + group.getPeople().get(i).getHealth());
			} else {
				System.out.println((i + 1) + ": " + state);
			}

		}
	}

}