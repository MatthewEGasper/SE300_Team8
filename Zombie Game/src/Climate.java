
public class Climate {
	private int avgTemp;
	private int humidity;
	
	public Climate(int avgTemp, int humidity) {
		this.avgTemp = avgTemp;
		this.humidity = humidity;
	}
	
	//setters
	public void setAvgTemp(int avgTemp) {
		this.avgTemp = avgTemp;
	}
	
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	//getters
	public int getAvgTemp() {
		return this.avgTemp;
	}
	
	public int getHumidity() {
		return this.humidity;
	}
}
