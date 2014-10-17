package eventsOnly;

/**
 * This event contains the whole telephone number.
 *
 * @author Katharina Laube
 */
public class IncomingTelNumber {

	private String telefonNumber;

	public IncomingTelNumber(String telefonNumber) {
		this.telefonNumber = telefonNumber;
		
	}

	public String getTelefonNumber() {
		return telefonNumber;
	}

	public String getVorwahl() {
		return getTelefonNumber().substring(0, 3);
	}

}
