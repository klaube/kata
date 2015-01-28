import java.util.Arrays;
import java.util.List;

/**
 * Enumeration of limits in roman numerals.
 * 
 * @author Katharina Laube
 * @since 26.01.2015
 */
public enum RomanLimit {

	I("I", 1),
	V("V", 5),
	X("X", 10),
	L("L", 50),
	C("C", 100),
	D("D", 500),
	M("M", 1000), 
	UNKNOWN("UNKNOWN",-1);
	
	private String roman;
	private Integer arabic;

	private RomanLimit(String roman, Integer arabic) {
		this.roman = roman;
		this.arabic = arabic;
	}
	
	static String fromArabic(Integer arabic){
		for (RomanLimit limit : RomanLimit.values()) {
			if(limit.getArabic().equals(arabic)){
				return limit.getRoman();
			}
		}
		throw new IllegalArgumentException();
	}
	
	static List<RomanLimit> getCounters(){
		return Arrays.asList(I, X, C, M, UNKNOWN);
	}
	
	static List<RomanLimit> getHalfs(){
		return Arrays.asList(V, L, D, UNKNOWN);
	}

	String getRoman() {
		return roman;
	}

	Integer getArabic() {
		return arabic;
	}
}
