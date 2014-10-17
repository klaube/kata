package eventsOnly;

import java.util.HashMap;

/**
 * The Counter counts the calls for each city.
 * It is a receiver for events of type IncomingTelNumber.
 *
 * @author Katharina Laube
 */
public class Counter {
	
	private HashMap<String, Integer> CITY_COUNT = new HashMap<>();

	public void count(IncomingTelNumber event) {
		final String vorwahl = event.getVorwahl();
		Integer count = CITY_COUNT.get(vorwahl);
		if(count == null) {
			count = 1;
		} else {
			count++;
		}
		CITY_COUNT.put(vorwahl, count);
	}

	public int getCount(String vorwahl) {
		Integer count = CITY_COUNT.get(vorwahl);
		return count != null ? count : 0;
	}

}
