
public class SimulationManager {
	Contagion contagion = new Contagion();
	MinorGroup group = new MinorGroup();
	Disease disease;
	int iterations;
	int clock = 0;
	DataRecorder recorder = new DataRecorder();
	
	public SimulationManager() {

	}
	
	public SimulationManager(UserDefinedData userData) {
		disease = new Disease(userData);
		for (int i = 0; i < userData.getGroupSize(); i++) {
			if (Math.random() > 0.5) {
				group.getPeople().add(new Person(disease));
			} else {
				group.getPeople().add(new Person());
			}
		}
		iterations = userData.getIterations();
	}
	
	
	public void runSim() {
		this.printMinorGroup();
		for (int i = 0; i < iterations; i++) {
			contagion.calculateMutationChange(disease);
			System.out.print((i+1) + ".) Lethality: " + disease.getLethality());
			System.out.print(" Transmission Range: " + disease.getTransmissionRange());
			System.out.print(" Life Span: " + disease.getLifespan() + "\n");
			
			for (int j = 0; j < group.getPeople().size(); j++) {
				if (group.getPeople().get(j).getHasDisease()) {
					contagion.diseaseFighterCalculator((group.getPeople().get(j)));

				}
				group.checkTotals();
			}
			clock++;
		}
		
		this.printMinorGroup();
	}
	
	public void printMinorGroup() {
		String state = "";
		for (int i = 0; i < group.getPeople().size(); i++) {
			if (group.getPeople().get(i).getLifeState() && group.getPeople().get(i).getHealth() > 0) {
				state = "alive, ";
			} else {
				state = "dead";
			}
			if (group.getPeople().get(i).getLifeState() && group.getPeople().get(i).getHealth() > 0) {
				System.out.println((i + 1) + ": " + state + (int)(group.getPeople().get(i).getHealth()*100)/100.0);
			} else {
				System.out.println((i + 1) + ": " + state);
			}

		}
		System.out.println(group.getNumSusceptible());
	}
	
	
	// setters
	
	
	// getters
	public Contagion getContagion() { return contagion; }
	public MinorGroup getMinorGroup() { return group; }
	public Disease getDisease() { return disease; }
	
	public void setUserInputs(UserDefinedData userData) {
		iterations = userData.getIterations();
	}
	
}
