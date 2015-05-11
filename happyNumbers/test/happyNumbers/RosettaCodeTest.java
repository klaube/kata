package happyNumbers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Katharina Laube, Oliver Jahns
 * @since 11.05.2015
 */
public class RosettaCodeTest {

	@Test
	public void one_should_be_happy() {
		assertTrue(RosettaCode.happy(1));
	}
	
	@Test
	public void testUnhappy() {
		assertFalse(RosettaCode.happy(4));
	}
	
}
