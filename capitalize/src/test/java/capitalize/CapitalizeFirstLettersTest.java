package capitalize;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import capitalize.CapitalizeFirstLetters;

public class CapitalizeFirstLettersTest {
	

	@Test
	public void testCapitalizeFirstLetters() {
		String result = CapitalizeFirstLetters.capitalizeFirstLetters("test");
		assertNotNull(result);
		assertEquals("Test", result);
	}
	
	@Test
	public void testCapitalizeExludingNumbers() {
		String result = CapitalizeFirstLetters.capitalizeFirstLetters("1test");
		assertEquals("1test", result);
	}
	
	@Test
	public void testCapitalizeExcludingStartSpaces() {
		String result = CapitalizeFirstLetters.capitalizeFirstLetters(" test ");
		assertEquals(" Test ", result);
	}
	
	@Test
	public void testCapitalizeExcludingSpaces() {
		String result = CapitalizeFirstLetters.capitalizeFirstLetters("test  test ");
		assertEquals("Test  Test ", result);
	}
	
	@Test
	public void testCapitalizeOnlySpaces() {
		String result = CapitalizeFirstLetters.capitalizeFirstLetters("   ");
		assertEquals("   ", result);
	}

}
