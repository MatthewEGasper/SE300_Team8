import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		GUI gui = new GUI();
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
		thingy.appendSaveFile(3, 3, 3, 3, 3, 3, 3);
		thingy.appendSaveFile(1, 1, 1, 1, 1, 1, 1);
		thingy.appendSaveFile(2, 2, 2, 2, 2, 2, 2);
		thingy.readSaveFile();
		try {
			thingy.writeDataCell(1,3,99);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("The Cell value is: "+thingy.readDataCell(1,3));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
		
		System.out.println("Good Bye!");
		
	}


}