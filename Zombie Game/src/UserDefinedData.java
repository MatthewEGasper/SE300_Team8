public class UserDefinedData {
	private int iterations;
	// private int groupNumber;
	private int groupSize;
	private double mutationRate;
	private double transmissionRange;
	private double lethality;
	private int lifespan;

	private boolean checkTransmissionRange(String transmission)
	{
		try {
			double temp = Double.parseDouble(transmission);
			if (temp >= 0.5 && temp <= 10) {
				transmissionRange = temp;
				return true;
			} else {
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	
	private boolean checkMutationRate(String mutation)
	{
		try {
			int temp = Integer.parseInt(mutation);
			if (temp == 3) {
				mutationRate = 0.0001;
				return true;
			} else if (temp == 2) {
				mutationRate = 0.00001;
				return true;
			} else if (temp == 1) {
				mutationRate = 0.000001;
				return true;
			} else if (temp == 0) {
				mutationRate = 0;
				return true;
			} else {
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	
	private boolean checkLethality(String lethal)
	{
		try {
			double temp = Double.parseDouble(lethal);
			if (temp >= 1 && temp <= 10) {
				lethality = temp;
				return true;
			} else {
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	
	private boolean checkLifespan(String life)
	{
		try {
			int temp = Integer.parseInt(life);
			if (temp >= 5 && temp <= 28) {
				lifespan = temp;
				return true;
			} else {
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	
	private boolean checkGroupSize(String group)
	{
		try {
			int temp = Integer.parseInt(group);
			if (temp > 0) {
				groupSize = temp;
				return true;
			} else {
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	
	private boolean checkIterations(String iteration)
	{
		try {
			int temp = Integer.parseInt(iteration);
			if (temp > 0) {
				iterations = temp;
				return true;
				
			} else {
				return false;
			}
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
	}
	
	
	public boolean defineData(String[] userInputs) {
		if(checkTransmissionRange(userInputs[0]) && checkMutationRate(userInputs[1]) && checkLethality(userInputs[2]) && 
		   checkLifespan(userInputs[3]) && checkGroupSize(userInputs[4]) && checkIterations(userInputs[5])) 
		{
			return true;
		} else {
			return false;
		}
		
	}

	// setters
	public void setIterations(int iterate){
		iterations = iterate;
	}
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