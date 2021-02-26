public class Game {

	public static void main(String[] args) {
		System.out.println("Hello World");
		DataRecorder thingy = new DataRecorder();
		thingy.createDataDump();
		thingy.writeDataDumpHeader();
		thingy.writeDataDump();
	}

}
