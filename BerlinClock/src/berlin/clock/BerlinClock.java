package berlin.clock;

public class BerlinClock {

	private String input;

	public void setInput(String input) {
		this.input = input;
	}

	private int getHour() {
		String hourStr = input.substring(0,2);
		return Integer.parseInt(hourStr);
	}
	
	private int getMinutes() {
		String minutesStr = input.substring(3,5);
		return Integer.parseInt(minutesStr);
	}
	
	private int getSeconds() {
		String secondsStr = input.substring(6,8);
		return Integer.parseInt(secondsStr);
	}

	public String getSecondsRow() {
		int seconds = getSeconds();
		return getOutput(seconds%2, "Y", 1);
	}

	public String getHourRow1() {
		int hour = getHour();
		return getOutput(hour/5, "R", 4);
	}

	public String getHourRow2() {
		int hour = getHour();
		return getOutput(hour%5, "R", 4);
	}

	public String getMinutesRow1() {
		int minutes = getMinutes();
		String output = "";
		int marker = 0;
		for (int i = 0; i < minutes/5; i++, marker++) {
			if (marker % 3 == 2) {
				output += "R";
			} else {
				output += "Y";
			}
		}
		for (int k = output.length(); k < 11; k++) {
			output += "O";
		}
		return output;
	}

	public String getMinutesRow2() {
		int minutes = getMinutes();
		return getOutput(minutes%5, "Y", 4);
	}

	private String getOutput(final int lightsOn, String letterOn, int lightsAll) {
		String output = "";
		for (int i = 0; i < lightsOn; i++) {
			output += letterOn;
		}
		for (int k = output.length(); k < lightsAll; k++) {
			output += "O";
		}
		return output;
	}

}
