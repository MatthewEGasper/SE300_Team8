
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
		double num = 0;
		for (int i = 0; i < userData.getGroupSize(); i++) {
			num = Math.random();
			if (num > 0.9) {
				group.getPeople().add(i,new Person(disease));
				group.getPeople().get(i).setDiseaseCounter(userData.getLifespan());
			} else {
				group.getPeople().add(i,new Person());
			}
		}
		iterations = userData.getIterations();
	}
	
	
	public void runSim() {
		this.printMinorGroup();
		recorder.createDataDump();
		recorder.writeDataDumpHeader();
		
		for (int i = 0; i < iterations; i++) {
			group.checkTotals();
			System.out.println(group.getNumInfected() + "   " + group.getNumSusceptible() + "  " + group.getNumRecovered() + "   " + group.getNumDead());
			
			contagion.calculateMutationChange(disease);
			System.out.print((i+1) + ".) Lethality: " + disease.getLethality());
			System.out.print(" Transmission Range: " + disease.getTransmissionRange());
			System.out.print(" Life Span: " + disease.getLifespan() + "\n");
			
			contagion.diseaseSpreadCalculator(group);

			
			for (int j = 0; j < group.getPeople().size(); j++) {
				if (group.getPeople().get(j).getInfected()) {
					contagion.diseaseFighterCalculator((group.getPeople().get(j)));

				}
			}
			

			group.checkTotals();
			recorder.setTotalInfected(group.getNumInfected());
			recorder.setTotalImmune(group.getNumRecovered());
			recorder.setTotalDead(group.getNumDead());
			
			//Currently Redundant I KNOW! (strictly for the Save File)
			recorder.setCurrentPopulation(group.getPeople().size() - group.getNumDead());
			recorder.setCurrentInfected(group.getNumInfected());
			recorder.setCurrentImmune(group.getNumRecovered());
			
			recorder.calcInfectionRate();
			recorder.calcMortalityRate();
			recorder.calcRecoveryRate();
			
			System.out.println(recorder.getInfectionRate() + "    " + recorder.getMortalityRate() + "    " + recorder.getRecoveryRate());
			System.out.println(recorder.getTotalInfected() + "    " + recorder.getTotalImmune());
			recorder.appendDataDump();
			
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
