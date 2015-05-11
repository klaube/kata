package happyNumbers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Katharina Laube, Oliver Jahns
 * @since 11.05.2015
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {
	
	private Calculator cut;

	@Before
	public void setUp() throws Exception {
		cut = new Calculator();
	}

	@Test
    @Parameters({
        "1",
        "7",
        "10",
        "13", 
        "19", 
        "23", 
        "28"
    })
	public void test_happy_numbers(int number) {
		assertTrue(cut.isHappy(number));
	}

	@Test
    @Parameters({
        "2",
        "3",
        "4",
        "5", 
        "6", 
        "8", 
        "9"
    })
	public void testUnhappy(int number) {
		assertFalse(cut.isHappy(number));
	}
	
	@Test
	public void calc_19_should_return_82_Str() {
		assertEquals(82, cut.calcString(19));
	}

	@Test
	public void calc_19_should_return_82() {
		assertEquals(82, cut.calc(19));
	}
	
}
