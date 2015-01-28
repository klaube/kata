/**
 * Converts arabic numerals to roman numerals.
 * 
 * @author Katharina Laube, Egga
 * @since 26.01.2015
 */
public class Converter {

	public static String convertToRoman(final Integer arabic) {
		
		if (arabic <= 0 || arabic > 3899){
			throw new IllegalArgumentException("Roman numerals can only be mapped from 1 to 3899!");
		}
		
		String completeRoman = "";
		
		// interate the digit of the arabic numeral beginning with the last digit
		char[] arabicString = arabic.toString().toCharArray();
		for (int i = arabicString.length - 1, j=0; i >= 0 ; i--, j++) {
			
			char c = arabicString[i];
			Integer arabicDigit = Character.getNumericValue(c);
			completeRoman = getRomanLetter(arabicDigit, j) + completeRoman;
		}
		
		return completeRoman;
	}

	public static String getSimpleRepeat(final Integer arabic, String completeRoman) {
		int remainder = arabic;
		for (RomanLimit counter : RomanLimit.getCounters()) {
			
			int div = (int) Math.nextUp((double) (remainder / counter.getArabic()));
			completeRoman += repeat(div, counter);
			
			remainder = remainder % counter.getArabic();
			
		}
		return completeRoman;
	}

	private static String getRomanLetter(final Integer arabicDigit, int i) {
		final RomanLimit currentCounterLimit = RomanLimit.getCounters().get(i); 
		
		final RomanLimit nextHalf = RomanLimit.getHalfs().get(i);  
		final Integer nextHalfArabic = nextHalf.getArabic();
		
		final RomanLimit nextCounterLimit = RomanLimit.getCounters().get(i+1); 
		
		String prefix = "";
		String middle = "";
		String suffix = "";
		
		if (1 == arabicDigit){
			return currentCounterLimit.getRoman();
		}
		
		if ( 1 < arabicDigit && arabicDigit <= 3){
			suffix = repeat(arabicDigit, currentCounterLimit);
		}
		else if (arabicDigit == 4){
			prefix = currentCounterLimit.getRoman();
			middle = nextHalf.getRoman(); 
		}
		else if (arabicDigit == 5){
			middle = nextHalf.getRoman();
		} 
		else if (5 < arabicDigit && arabicDigit < 9){
			middle = nextHalf.getRoman(); 
			suffix = repeat(arabicDigit-nextHalfArabic, currentCounterLimit);				
		}
		else if (arabicDigit == 9){ 
			prefix = currentCounterLimit.getRoman();
			middle = nextCounterLimit.getRoman();
		}
		
		return prefix + middle + suffix;
	}

	private static String repeat(int repeatCount, RomanLimit limit) {
		String repeated = "";
		for (int i = 0; i < repeatCount; i++) {
			repeated += limit.getRoman();
		}
		return repeated;
	}

}
