package wordSearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LineTest {

	private Line horizontalRow;

	@Before
	public void setUp() throws Exception {
		horizontalRow = new Line("XXXXWORDXX");
	}

	@Test
	public void a_contained_word_should_be_found() {
		assertTrue(horizontalRow.contains("WORD"));
	}
	
	@Test
	public void a_missing_should_not_be_found() {
		assertFalse(horizontalRow.contains("TEST"));
	}

}
