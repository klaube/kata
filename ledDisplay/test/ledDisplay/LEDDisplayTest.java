package ledDisplay;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LEDDisplayTest {
	
	LEDDisplay cut;

	@Before
	public void setUp() throws Exception {
		cut = new LEDDisplay();
	}

	@Test
	public void testConvert2ToLED() {
		final String[] expected = { " - ",
									"  |",
									" - ",
									"|  ",
									" - "};
		runTestConvertToLED(expected, 2);
	}

	@Test
	public void testConvert4ToLED() {
		final String[] expected = { "   ",
									"| |",
									" - ",
									"  | ",
									"   "};
		runTestConvertToLED(expected, 4);
	}
	
	private void runTestConvertToLED(final String[] expected, int number) {
		final String[] result = cut.convertNumberToLED(number);
		assertThat(result, equalTo(expected));
	}

}
