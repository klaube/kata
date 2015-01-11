package wordSearch;

/**
 * Tests the search for a word within one line.
 *
 * @author Till Friebe, Katharina Laube
 * @since 12.12.2014
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LineTest {

	private Line cut;

	@Test
	public void a_contained_word_should_be_found() {
		cut = new Line("XXXXWORDXX", 0, Orientation.HORIZONTAL);
		assertEquals(4, cut.getStartOfWordWithinSentence("WORD"));
	}
	
	@Test
	public void a_missing_should_not_be_found() {
		cut = new Line("XXXXWORDXX", 0, Orientation.HORIZONTAL);
		assertEquals(-1, cut.getStartOfWordWithinSentence("TEST"));
	}
	
	@Test
	public void letterShouldbeAdded() throws Exception {
		cut = new Line("XXXXWORDXX", 0, Orientation.HORIZONTAL);
		cut.add("A");
		assertEquals("XXXXWORDXXA", cut.getRow());
	}

}
