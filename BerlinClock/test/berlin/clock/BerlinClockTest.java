package berlin.clock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import berlin.clock.BerlinClock;

public class BerlinClockTest {

	private BerlinClock cut;

	@Before
	public void setUp() throws Exception {
		cut = new BerlinClock();
	}

	@Test
	public final void testHourRow1_00() {
		runTestGetHourRow1("00:00:00", "OOOO");
	}
	
	@Test
	public final void testHourRow1_13() {
		runTestGetHourRow1("13:17:01", "RROO");
	}
	
	@Test
	public final void testHourRow1_23() {
		runTestGetHourRow1("23:59:59", "RRRR");
	}
	
	@Test
	public final void testHourRow1_24() {
		runTestGetHourRow1("24:00:00", "RRRR");
	}

	private void runTestGetHourRow1(String input, String expected) {
		cut.setInput(input);
		assertEquals(expected, cut.getHourRow1());
	}
	
	@Test
	public final void testHourRow2_00() {
		runTestGetHourRow2("00:00:00", "OOOO");
	}
	
	@Test
	public final void testHourRow2_13() {
		runTestGetHourRow2("13:17:01", "RRRO");
	}
	
	@Test
	public final void testHourRow2_23() {
		runTestGetHourRow2("23:59:59", "RRRO");
	}
	
	@Test
	public final void testHourRow2_24() {
		runTestGetHourRow2("24:00:00", "RRRR");
	}
	
	private void runTestGetHourRow2(String input, String expected) {
		cut.setInput(input);
		assertEquals(expected, cut.getHourRow2());
	}

	@Test
	public final void testMinutesRow1_00() {
		runTestGetMinutesRow1("00:00:00", "OOOOOOOOOOO");
	}
	
	@Test
	public final void testMinutesRow1_17() {
		runTestGetMinutesRow1("13:17:01", "YYROOOOOOOO");
	}
	
	@Test
	public final void testMinutesRow1_59() {
		runTestGetMinutesRow1("23:59:59", "YYRYYRYYRYY");
	}

	private void runTestGetMinutesRow1(String input, String expected) {
		cut.setInput(input);
		assertEquals(expected, cut.getMinutesRow1());
	}
	
	@Test
	public final void testMinutesRow2_00() {
		runTestGetMinutesRow2("00:00:00", "OOOO");
	}
	
	@Test
	public final void testMinutesRow2_17() {
		runTestGetMinutesRow2("13:17:01", "YYOO");
	}
	
	@Test
	public final void testMinutesRow2_59() {
		runTestGetMinutesRow2("23:59:59", "YYYY");
	}
	
	private void runTestGetMinutesRow2(String input, String expected) {
		cut.setInput(input);
		assertEquals(expected, cut.getMinutesRow2());
	}
	
	@Test
	public final void testSeconds_00() {
		runTestGetSeconds("00:00:00", "O");
	}
	
	@Test
	public final void testSeconds_01() {
		runTestGetSeconds("13:17:01", "Y");
	}
	
	private void runTestGetSeconds(String input, String expected) {
		cut.setInput(input);
		assertEquals(expected, cut.getSecondsRow());
	}

}
