
/**
 * 
 * @author Katharina Laube
 * @since 26.01.2015
 */
public class Converter {

	public static String convertToRoman(final Integer arabic) {
		
		String completeRoman = "";
		
		for (int i = 0; i < RomanLimit.values().length - 2; i+=2) {
			
			final RomanLimit currentLimit = RomanLimit.values()[i]; 
			final Integer currentArabic = currentLimit.getArabic();
			
			final RomanLimit nextLimit = RomanLimit.values()[i+1];  
			final Integer nextArabic = nextLimit.getArabic();
			
			final RomanLimit afterNextLimit = RomanLimit.values()[i+2]; 
			final Integer afterNextArabic = afterNextLimit.getArabic();
			
			String prefix = "";
			String middle = "";
			String suffix = "";
			
			if (currentArabic == arabic){
				return currentLimit.getRoman();
			}
			
			if ( currentArabic < arabic && arabic < nextArabic - 1){
				suffix = repeat(arabic, currentLimit);
			}
			else if (arabic == nextArabic - 1){
				prefix = currentLimit.getRoman();
				middle = nextLimit.getRoman(); 
			}
			else if (arabic == nextArabic){
				middle = nextLimit.getRoman();
			} 
			else if (nextArabic < arabic && arabic < afterNextArabic - 1){
				middle = nextLimit.getRoman(); 
				suffix = repeat(arabic - nextArabic, currentLimit);
			}
			else if (arabic == afterNextArabic - 1){
				prefix = currentLimit.getRoman();
				middle = afterNextLimit.getRoman();
			}
			
			completeRoman += prefix + middle + suffix;
		}
		
		return completeRoman;
	}

	private static String repeat(Integer arabic, RomanLimit limit) {
		String repeated = "";
		for (int i = 0; i < arabic; i++) {
			repeated += limit.getRoman();
		}
		return repeated;
	}

}
