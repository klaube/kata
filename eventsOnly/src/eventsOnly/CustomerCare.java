package eventsOnly;

/**
 * Customer Care gets the calls for its city and answers it.
 * It is a receiver for events of type IncomingTelNumber.
 * 
 * @author Katharina Laube
 */
public class CustomerCare {

	private String anwser;

	public void anwser(IncomingTelNumber event) {
		final String city;
		
		final String vorwahl = event.getVorwahl();
		switch (vorwahl) {
		case "030": city = "Berlin"; break;
		case "040": city = "Hamburg"; break;

		default: throw new IllegalArgumentException(vorwahl + " is unknown!");
		}
		
		setAnwser(city + " anwsers the call!");
		System.out.println(getAnwser());
	}

	public String getAnwser() {
		return anwser != null ? anwser : "No number was called!";
	}
	
	public void setAnwser(String anwser) {
		this.anwser = anwser;
	}

}
