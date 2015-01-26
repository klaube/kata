
/**
 * 
 * @author Katharina Laube
 * @since 26.01.2015
 */
public class Converter {

	public static String convertToRoman(final Integer latin) {
		
		String completeRoman = "";
		
		for (int i = 0; i < RomanLimit.values().length - 2; i+=2) {
			
			final RomanLimit currentLimit = RomanLimit.values()[i]; 
			final Integer currentLatin = currentLimit.getLatin();
			
			final RomanLimit nextLimit = RomanLimit.values()[i+1];  
			final Integer nextLatin = nextLimit.getLatin();
			
			final RomanLimit afterNextLimit = RomanLimit.values()[i+2]; 
			final Integer afterNextLatin = afterNextLimit.getLatin();
			
			String prefix = "";
			String middle = "";
			String suffix = "";
			
			if (currentLatin == latin){
				return currentLimit.getRoman();
			}
			
			if ( currentLatin < latin && latin < nextLatin - 1){
				suffix = repeat(latin, currentLimit);
			}
			else if (latin == nextLatin - 1){
				prefix = currentLimit.getRoman();
				middle = nextLimit.getRoman(); 
			}
			else if (latin == nextLatin){
				middle = nextLimit.getRoman();
			} 
			else if (nextLatin < latin && latin < afterNextLatin - 1){
				middle = nextLimit.getRoman(); 
				suffix = repeat(latin-nextLatin, currentLimit);				
			}
			else if (latin == afterNextLatin - 1){ 
				prefix = currentLimit.getRoman();
				middle = afterNextLimit.getRoman();
			}
			
			completeRoman += prefix + middle + suffix;
		}
		
		return completeRoman;
	}

	private static String repeat(Integer latin, RomanLimit limit) {
		String repeated = "";
		for (int i = 0; i < latin; i++) {
			repeated += limit.getRoman();
		}
		return repeated;
	}

}
