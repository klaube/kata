

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
	private Integer latin;
	private boolean isCounter;

	private RomanLimit(String roman, Integer latin, boolean isCounter) {
		this.roman = roman;
		this.latin = latin;
		this.isCounter = isCounter;
	}
	
	String fromLatin(Integer latin){
		for (RomanLimit limit : RomanLimit.values()) {
			if(limit.getLatin().equals(latin)){
				return limit.getRoman();
			}
		}
		throw new IllegalArgumentException();
	}

	String getRoman() {
		return roman;
	}

	Integer getLatin() {
		return latin;
	}
	
	boolean isCounter() {
		return isCounter;
	}
}
