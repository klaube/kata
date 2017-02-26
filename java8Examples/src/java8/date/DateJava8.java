package java8.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Java 8 contains a brand new date and time API under the package java.time. 
 * The new Date API is comparable with the Joda-Time library, however it's not the same. 
 * The following examples cover the most important parts of this new API.
 */
public class DateJava8 {

	public static void main(String[] args) {

		clock();
		
		timezones();
		
		localTime();
		
		localDate();
		
		localDateTime();

	}

	/**
	 * Clock provides access to the current date and time. 
	 * Clocks are aware of a timezone and may be used instead of System.currentTimeMillis() 
	 * to retrieve the current milliseconds. Such an instantaneous point on the time-line 
	 * is also represented by the class Instant. 
	 * Instants can be used to create legacy java.util.Date objects.
	 */
	private static void clock() {
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();

		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
	}
	
	/**
	 * Timezones are represented by a ZoneId. 
	 * They can easily be accessed via static factory methods. 
	 * Timezones define the offsets which are important to convert between instants and local dates and times.
	 */
	private static void timezones() {

		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		// ZoneRules[currentStandardOffset=+01:00]
		// ZoneRules[currentStandardOffset=-03:00]
		
	}
	
	/**
	 * LocalTime represents a time without a timezone, e.g. 10pm or 17:30:15. 
	 * The following example creates two local times for the timezones defined above. 
	 * Then we compare both times and calculate the difference in hours and minutes between both times.
	 */
	private static void localTime() {

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);

		System.out.println(now1.isBefore(now2));  // false

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

		System.out.println(hoursBetween);       // -3
		System.out.println(minutesBetween);     // -239


		/*
		 * LocalTime comes with various factory method to simplify the creation of new instances, 
		 * including parsing of time strings.
		 */

		LocalTime late = LocalTime.of(23, 59, 59);
		System.out.println(late);       // 23:59:59

		DateTimeFormatter germanFormatter =
		    DateTimeFormatter
		        .ofLocalizedTime(FormatStyle.SHORT)
		        .withLocale(Locale.GERMAN);

		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);   // 13:37
	}
	
	/**
	 * LocalDate represents a distinct date, e.g. 2014-03-11. 
	 * It's immutable and works exactly analog to LocalTime. 
	 * The sample demonstrates how to calculate new dates by adding or substracting days, months or years. 
	 * Keep in mind that each manipulation returns a new instance.
	 */
	private static void localDate() {

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);

		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);    // FRIDAY


		//Parsing a LocalDate from a string is just as simple as parsing a LocalTime:
		DateTimeFormatter germanFormatter =
		    DateTimeFormatter
		        .ofLocalizedDate(FormatStyle.MEDIUM)
		        .withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(xmas);   // 2014-12-24
	}
	
	/**
	 * LocalDateTime represents a date-time. It combines date and time as seen 
	 * in the above sections into one instance. 
	 * LocalDateTime is immutable and works similar to LocalTime and LocalDate. 
	 * We can utilize methods for retrieving certain fields from a date-time:
	 */
	private static void localDateTime() {

			LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

			DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
			System.out.println(dayOfWeek);      // WEDNESDAY

			Month month = sylvester.getMonth();
			System.out.println(month);          // DECEMBER

			long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
			System.out.println(minuteOfDay);    // 1439


			/*
			 * With the additional information of a timezone it can be converted to an instant. 
			 * Instants can easily be converted to legacy dates of type java.util.Date.
			 */

			Instant instant = sylvester
			        .atZone(ZoneId.systemDefault())
			        .toInstant();

			Date legacyDate = Date.from(instant);
			System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014


			/*
			 * Formatting date-times works just like formatting dates or times. 
			 * Instead of using pre-defined formats we can create formatters from custom patterns.
			 * 
			 * Unlike java.text.NumberFormat the new DateTimeFormatter is immutable and thread-safe.
			 */

			DateTimeFormatter formatter =
			    DateTimeFormatter
			        .ofPattern("MMM dd, yyyy - HH:mm");

			LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
			String string = formatter.format(parsed);
			System.out.println(string);     // Nov 03, 2014 - 07:13

	}

}
