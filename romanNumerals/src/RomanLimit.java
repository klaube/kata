

/**
 * 
 * @author Katharina Laube
 * @since 26.01.2015
 */
public enum RomanLimit {

	I("I", 1, true),
	V("V", 5, false),
	X("X", 10, true),
	L("L", 50, false),
	C("C", 100, true),
	D("D", 500, false),
	M("M", 1000, true);
	
	private String roman;
	private Integer arabic;
	private boolean isCounter;

	private RomanLimit(String roman, Integer arabic, boolean isCounter) {
		this.roman = roman;
		this.arabic = arabic;
		this.isCounter = isCounter;
	}
	
	String fromArabic(Integer arabic){
		for (RomanLimit limit : RomanLimit.values()) {
			if(limit.getArabic().equals(arabic)){
				return limit.getRoman();
			}
		}
		throw new IllegalArgumentException();
	}

	String getRoman() {
		return roman;
	}

	Integer getArabic() {
		return arabic;
	}
	
	boolean isCounter() {
		return isCounter;
	}
}
