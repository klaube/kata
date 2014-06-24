package capitalize;


public class CapitalizeFirstLetters {

	public static String capitalizeFirstLetters(final String input) {
		
		char[] allLetters = input.toCharArray();
		
		boolean isPreviousLetterSpace = false;
		
		for(int i=0; i<allLetters.length; i++) { 
			changeLetter(allLetters, isPreviousLetterSpace, i); 
			isPreviousLetterSpace = checkLetter(allLetters, i);
		}	
		
		return String.valueOf(allLetters);
	}


	private static void changeLetter(char[] allLetters, boolean isPreviousLetterSpace, int i) {
		final boolean isNoSpace = allLetters[i] != ' ';
		final boolean isFirstLetterAndNoSpace = (i == 0) && isNoSpace;
		
		if (isFirstLetterAndNoSpace || isPreviousLetterSpace) {
			toUpperCase(allLetters, i);
		}
	}

	
	private static boolean checkLetter(char[] allLetters, int i) {
		
		if (allLetters[i] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	
	private static void toUpperCase(char[] allLetters, int letterPosition) {
		String upperCaseLetter = String.valueOf(allLetters[letterPosition]).toUpperCase();
		allLetters[letterPosition] = upperCaseLetter.charAt(0);
	}

}
