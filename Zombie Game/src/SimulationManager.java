
public class SimulationManager {
	Contagion contagion;
	MinorGroup group = new MinorGroup();
	Disease disease;
	int iterations;
	DataRecorder recorder = new DataRecorder();
	
	public SimulationManager() {

	}
	
	public SimulationManager(UserDefinedData userData) {
		disease = new Disease(userData);
		double num = 0;
		group.getPeople().add(0,new Person());
		group.getPeople().get(0).setDiseaseCounter(userData.getLifespan());
		group.getPeople().get(0).setInfected();
		for (int i = 1; i < userData.getGroupSize(); i++) {
			num = Math.random();
			if (num > 0.99) {
				group.getPeople().add(i,new Person());
				group.getPeople().get(i).setDiseaseCounter(userData.getLifespan());
				group.getPeople().get(i).setInfected();
			} else if (num > 0.98){
				group.getPeople().add(i,new Person());
				group.getPeople().get(i).setExposed();
			} else {
				group.getPeople().add(i,new Person());
			}
		}
		iterations = userData.getIterations();
		contagion = new Contagion(disease);
	}
	
	
	public void runSim(boolean continued) {
		if(!continued){
			recorder.createDataDump();
			recorder.writeDataDumpHeader();
		}
		else
		{
			contagion.setDisease(disease);
		}
		for (int i = 0; i < iterations; i++) {
			group.checkTotals();
			
			contagion.calculateMutationChange(disease);
			
			contagion.diseaseCalculator(group);

			group.checkTotals();
			recorder.setTotalInfected(group.getNumInfected()+group.getNumDead()+group.getNumRecovered());
			recorder.setTotalImmune(group.getNumRecovered());
			recorder.setTotalDead(group.getNumDead());
			
			//Currently Redundant I KNOW! (strictly for the Save File)
			recorder.setCurrentPopulation(group.getPeople().size() - group.getNumDead());
			recorder.setCurrentInfected(group.getNumInfected());
			
			recorder.calcInfectionRate();
			recorder.calcMortalityRate();
			recorder.calcRecoveryRate();
			
			recorder.appendDataDump(i);
			
		}
		
	}
	
	/*public void printMinorGroup() {
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
	}*/
	
	
	// setters
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	
	public void setDisease(Disease newDisease)
	{
		disease = newDisease;
	}
	
	// getters
	public Contagion getContagion() { return contagion; }
	public MinorGroup getMinorGroup() { return group; }
	public Disease getDisease() { return disease; }
	public DataRecorder getRecorder() { return recorder; }
	
}
