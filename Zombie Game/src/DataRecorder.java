
/* File: DataRecorder.java
 * Name: DataRecorder
 * Desc: This class is meant to act as a storage container and calculator 
 * 		 for the Zombie Simulator, recording different values and statistics 
 * 		 of the on going simulation.
 * Auth: Matthew Gasper
 * Date: 2/19/2021
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.io.BufferedReader;

public class DataRecorder {
	private int intial_population = 0, total_infected = 0, total_immune = 0, total_dead = 0;
	private int current_population = 0, current_infected = 0, current_immune = 0;
	private int old_infected = 0;
	private float infection_rate = 0, mortality_rate = 0, recovery_rate = 0;

	public DataRecorder() {
		
	}
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public void writeDataCell(int lineNumber, int columnNumber, float value) throws IOException{
	    String text = "";
	    String[] columns = null;
	    File data = new File("data_dump.txt");
	    try (Stream<String> all_lines = Files.lines(Paths.get("data_dump.txt"))) {
	    	text = all_lines.skip(lineNumber).findFirst().get();
	    	columns = text.split(",");
	    	columns[columnNumber]= ""+value;
	    	text = String.join(", ", columns);
	    	List<String> lines = Files.readAllLines(data.toPath());
	    	lines.set(lineNumber, text);
	    	Files.write(data.toPath(), lines);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    System.out.println(" The specific Line is: " + String.join(", ", columns));
	}
	
	public float readDataCell (int lineNumber, int columnNumber) throws IOException{
		String text = "";
	    String[] columns = null;
	    float cellValue = 0;
	    try (Stream<String> all_lines = Files.lines(Paths.get("data_dump.txt"))) {
	    	text = all_lines.skip(lineNumber).findFirst().get();
	    	columns = text.split(",");
	    	cellValue = Float.valueOf(columns[columnNumber]);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return cellValue;
	}
	
	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public void createDataDump() {
		try {
			File data = new File("data_dump.txt");
			if (data.createNewFile()) {
				System.out.println("The file: " + data.getName() + " was created!");
			} else {
				System.out.println("The file: " + data.getName() + " already exists!");
			}
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while creating file!");
			e.printStackTrace();
		}

	}

	public void writeDataDumpHeader() {
		try {
			FileWriter dataWriter = new FileWriter("data_dump.txt");
			System.out.println("data_dump.txt has been opened!");

			dataWriter.write("intial_population,total_infected,total_immune,total_dead,");
			dataWriter.write("current_population,current_infected,current_immune,current_dead,");
			dataWriter.write("infection_rate,mortality_rate,recover_rate");
			dataWriter.write("\n");

			dataWriter.close();
			System.out.println("data_dump.txt has been closed!");
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while writing to a file!");
			e.printStackTrace();
		}
	}

	public void appendDataDump() {
		try {
			FileWriter  dataWriter = new FileWriter("data_dump.txt",true);
			System.out.println("data_dump.txt has been opened!");

			dataWriter.write(intial_population + "," + total_infected + "," + total_immune + "," + total_dead + ",");
			dataWriter.write(current_population + "," + current_infected + "," + current_immune + "," + ",");
			dataWriter.write(infection_rate + "," + mortality_rate + "," + recovery_rate);
			dataWriter.write("\n");
			dataWriter.close();
			System.out.println("data_dump.txt has been closed!");
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while writing to a file!");
			e.printStackTrace();
		}
		System.out.println("I APPENDED: " + current_infected);
	}

	public void readDataDump() {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("data_dump.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				System.out.println(String.join(", ", columns));
			}
		} catch (IOException ex) {
			System.out.println("You have angered the file system gods, while reading data_dump.txt");
			ex.printStackTrace();
		}
	}

	public void readDataDumpRecent() {
		File file = new File("data_dump.txt");
		RandomAccessFile fileHandler = null;
		try {
			fileHandler = new RandomAccessFile(file, "r");
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder();

			for (long filePointer = fileLength; filePointer != -1; filePointer--) {
				fileHandler.seek(filePointer);
				int readByte = fileHandler.readByte();

				if (readByte == 0xA) {
					if (filePointer == fileLength) {
						continue;
					}
					break;

				} else if (readByte == 0xD) {
					if (filePointer == fileLength - 1) {
						continue;
					}
					break;
				}

				sb.append((char) readByte);
			}

			String lastLine = sb.reverse().toString();
			System.out.println("Last Line is: " + lastLine);
			;
			fileHandler.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// -------------------------------------------------------------------------------------------------------------
	public void createSaveFile() {
		try {
			File data = new File("save_file.txt");
			if (data.createNewFile()) {
				System.out.println("The file: " + data.getName() + " was created!");
			} else {
				System.out.println("The file: " + data.getName() + " already exists!");
			}
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while creating file!");
			e.printStackTrace();
		}

	}

	public void writeSaveFileHeader() {
		try {
			FileWriter dataWriter = new FileWriter("save_file.txt");
			System.out.println("save_file.txt has been opened!");
			dataWriter.write("MutationRate,TransmissionRange,Leathality,Lifespan,GroupSize,GroupNumber,Iterations,");
			dataWriter.write("\n");
			dataWriter.close();
			System.out.println("save_file.txt has been closed!");
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while writing to a file!");
			e.printStackTrace();
		}
	}

	public void appendSaveFile(float mr, float tr, float leathality, int lifespan, int gs, int gn, int iterations) {
		try {
			FileWriter dataWriter = new FileWriter("save_file.txt", true);
			System.out.println("save_file.txt has been opened!");
			dataWriter.write(mr + "," + tr + "," + leathality + "," + lifespan + "," + gs + "," + gn + "," + iterations + ",");
			dataWriter.write("\n");
			dataWriter.close();
			System.out.println("save_file.txt has been closed!");
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while writing to a file!");
			e.printStackTrace();
		}
	}

	public void readSaveFile() {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get("save_file.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] columns = line.split(",");
				System.out.println(String.join(", ", columns));
			}
		} catch (IOException ex) {
			System.out.println("You have angered the file system gods, while reading save_file.txt");
			ex.printStackTrace();
		}
	}

	// -------------------------------------------------------------------------------------------------------------
	//Order in Save File: Leathality, Transmission Range, Lifespan, Population Density, Response Threshhold,, Reponse Strength
	public void savePreset(String name, float leathality, float transmissionRange, float lifespan, float mutationRate, float iterations, float groupSize) {
		try {
			File data = new File(name);
			FileWriter dataWriter = new FileWriter(name, true);
			if (data.createNewFile()) {
				System.out.println("The file: " + data.getName() + " was created!");
			} else {
				System.out.println("The file: " + data.getName() + " already exists!");
			}
			dataWriter.write(leathality + "," + transmissionRange + "," + lifespan + "," + mutationRate + "," + iterations + "," + groupSize);
			dataWriter.write("\n");
			dataWriter.close();
			
		} catch (IOException e) {
			System.out.println("You have angered the file system gods, while creating file!");
			e.printStackTrace();
		}

	}
	public float[] readPreset(String name) {
		String text = "";
	    String[] columns = null;
	    float[] preset = new float[6];
	    
	    try (Stream<String> all_lines = Files.lines(Paths.get(name))) {
	    	text = all_lines.skip(0).findFirst().get();
	    	columns = text.split(",");
	    	for(int i=0; i<6; i++) {
	    		preset[i] = Float.valueOf(columns[i]);
	    	}
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		return preset;
	}
	// -------------------------------------------------------------------------------------------------------------
	public void calcInfectionRate() {
		infection_rate = (float) (current_infected - old_infected) / current_population;
	}

	public void calcMortalityRate() {
		mortality_rate = (float) total_dead / total_infected;
	}

	public void calcRecoveryRate() {
		recovery_rate = (float) total_immune / total_infected;
	}

	// -----------------------------------------------------------------------------
	public void setTotalPopulation(int num) {
		intial_population = num;
	}

	public void setTotalInfected(int num) {
		total_infected = num;
	}

	public void setTotalImmune(int num) {
		total_immune = num;
	}

	public void setTotalDead(int num) {
		total_dead = num;
	}

	public void setCurrentPopulation(int num) {
		current_population = num;
	}

	public void setCurrentInfected(int num) {
		current_infected = num;
	}

	public void setCurrentImmune(int num) {
		current_immune = num;
	}

	// -----------------------------------------------------------------------------
	public int getTotalPopulation() {
		return intial_population;
	}

	public int getTotalInfected() {
		return total_infected;
	}

	public int getTotalImmune() {
		return total_immune;
	}

	public int getTotalDead() {
		return total_dead;
	}

	public int getCurrentPopulation() {
		return current_population;
	}

	public int getCurrentInfected() {
		return current_infected;
	}

	public int getCurrentImmune() {
		return current_immune;
	}

	public float getInfectionRate() {
		return infection_rate;
	}

	public float getMortalityRate() {
		return mortality_rate;
	}

	public float getRecoveryRate() {
		return recovery_rate;
	}
}
