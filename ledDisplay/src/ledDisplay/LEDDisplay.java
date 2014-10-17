package ledDisplay;

public class LEDDisplay {

	private static final String[] LED2 = {   
		" - ",
		"  |",
		" - ",
		"|  ",
		" - "};
	
	private static final String[] LED4 = { 
		"   ",
		"| |",
		" - ",
		"  | ",
		"   "};
	
	public String[] convertNumberToLED(int number) {
		switch (number) {
		case 2: return LED2;
		case 4: return LED4;

		default: throw new IllegalArgumentException("Number [" + number + "] is not supported!");
		}
	}

}
