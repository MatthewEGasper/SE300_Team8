public class Game {

	public static void main(String[] args) {
		System.out.println("Hello World");
		DataRecorder thingy = new DataRecorder(1);
		thingy.createDataDump();
		thingy.writeDataDumpHeader();
		thingy.appendDataDump();
		thingy.appendDataDump();
		thingy.appendDataDump();
		thingy.readDataDump();
		
		thingy.createSaveFile();
		thingy.writeSaveFileHeader();
		thingy.appendSaveFile(0, 0, 0, 0, 0, 0, 0);
		thingy.appendSaveFile(1, 1, 1, 1, 1, 1, 1);
		thingy.appendSaveFile(2, 2, 2, 2, 2, 2, 2);
		thingy.readSaveFile();
	}

}
