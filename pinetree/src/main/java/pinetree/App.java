package pinetree;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int hoehe;
	private static boolean stern;

	public static void main( String[] args )
    {
        System.out.println("    *");
        System.out.println("    X");
        System.out.println("   XXX");
        System.out.println("  XXXXX");
        System.out.println(" XXXXXXX");
        System.out.println("XXXXXXXXX");
        System.out.println("    H" );

        System.out.println("    *\n    X\n   XXX\n  XXXXX\n XXXXXXX\nXXXXXXXXX\n    H" );
    }

	public static int getHoehe() {
		return hoehe;
	}

	public static void tannenbaum(int hoehe) {
		tannenbaum(hoehe, false);
	}

	public static void tannenbaum(int hoehe, boolean stern) {
		App.hoehe = hoehe;
		App.stern = stern;
		
	}

	public static boolean hasStern() {
		return stern;
	}
	
	public static String getPrintOut() {
		return generatePrintOut();
	}
	
	private static String generatePrintOut() {
		StringBuilder sb = new StringBuilder();
		
		addStar(sb);
		
		addLeaves(sb);
		
		generateCentralSymbol(sb, "H");
		
		return sb.toString();
	}

	private static void addStar(StringBuilder sb) {
		if (stern){
			generateCentralSymbol(sb, "*\n");
		}
	}

	private static void addLeaves(StringBuilder sb) {
		for(int i = 0; i < hoehe; i ++) {
			calculateSpaces(sb, i);
			calculateLeaves(sb, i);
			sb.append("\n");
		}
	}

	private static void calculateLeaves(StringBuilder sb, int i) {
		for(int x = 0; x < i * 2 + 1; x++){
			sb.append("X");
		}
	}

	private static void calculateSpaces(StringBuilder sb, int i) {
		for(int leerzeichen = 0; leerzeichen < hoehe - (i + 1); leerzeichen ++) {
			sb.append(" ");
		}
	}

	private static void generateCentralSymbol(StringBuilder sb, String symbol) {
		for(int leerzeichen = 0; leerzeichen < hoehe -  1; leerzeichen ++) {
			sb.append(" ");
		}
		sb.append(symbol);
	}

	public static void printOut() {
		System.out.println(generatePrintOut());
	}
}
