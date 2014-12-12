package wordSearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MatrixTest {

	private Matrix cut;
	
	@Test
	public void missing_word_will_not_be_found() throws Exception {
		String matrix = "XXXXXXXXXX\n" +
						"XXXXXXXXXX\n" +
						"XXXXXXXXXX";
		cut = new Matrix(matrix);
		
		assertEquals(3, cut.getRowCount());
		try {
			cut.getPosition("WORD");
			fail("IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Wrong exception!", "Word is unknown!", e.getMessage());
		}
	}
	
	@Test
	public void given_matrix_contains_horizontal_word() throws Exception {
		String matrix = "XXXXXXXXXX\n" +
						"XXXXWORDXX\n" +
						"XXXXXXXXXX";
		cut = new Matrix(matrix);
		
		Position position = cut.getPosition("WORD");
		assertEquals(14, position.getStart());
		assertEquals(17, position.getEnd());
	}
	
	@Test
	public void given_matrix_contains_vertical_word() throws Exception {
		String matrix = "AXXXXXXXXX\n" +
						"BXXXXXXXXX\n" +
						"CXXXXXXXXX";
		cut = new Matrix(matrix);

		assertEquals(10, cut.getColumnCount());
		
		Position position = cut.getPosition("ABC");
		assertEquals(0, position.getStart());
		assertEquals(20, position.getEnd());
	}
	
	@Test
	public void given_matrix_contains_vertical_word_2() throws Exception {
		String matrix = "XAXXXXXXXX\n" +
						"XBXXXXXXXX\n" +
						"XCXXXXXXXX";
		cut = new Matrix(matrix);

		assertEquals(10, cut.getColumnCount());
		
		Position position = cut.getPosition("ABC");
		assertEquals(1, position.getStart());
		assertEquals(21, position.getEnd());
	}
}
