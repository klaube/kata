package wordSearch;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class MatrixTest {

	private Matrix cut;
	
	@Test
	public void given_matrix_contains_horizontal_word() throws Exception {
		String matrix = "XXXXXXXXXX\n" +
						"XXXXWORDXX\n" +
						"XXXXXXXXXX";
		cut = new Matrix(matrix);
		
		assertEquals(true , cut.contains("WORD"));
	}
	
	@Test
	public void missing_word_will_not_be_found() throws Exception {
		String matrix = "XXXXXXXXXX\n" +
						"XXXXXXXXXX\n" +
						"XXXXXXXXXX";
		cut = new Matrix(matrix);
		
		assertEquals(3, cut.getRowCount());
		assertEquals(false , cut.contains("WORD"));
	}
	
	@Test
	public void given_matrix_contains_vertical_word() throws Exception {
		String matrix = "AXXXXXXXXX\n" +
						"BXXXXXXXXX\n" +
						"CXXXXXXXXX";
		cut = new Matrix(matrix);
		
		assertEquals(true, cut.contains("ABC"));
	}
	
	@Test
	@Ignore
	public void given_matrix_doesnt_contain_vertical_word() throws Exception {
		String matrix = "AXXXXXXXXX\n" +
						"BXXXXXXXXX\n" +
						"CXXXXXXXXX";
		cut = new Matrix(matrix);
		
		assertEquals(true, cut.contains("ABC"));
	}
}
