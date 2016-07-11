package stringCalculator;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StringJava8CalculatorTest {

	private StringJava8Calculator undertest;

	@Before
	public void setUp() throws Exception {
		undertest = new StringJava8Calculator();
	}

	@Test
	public void an_empty_string_should_return_zero() {
		assertEquals(0, undertest.add(""));
	}
	
	@Test
	public void string_withOne_returns_one() {
		assertEquals(1, undertest.add("1"));
	}
	
	@Test
	public void one_and_two_returns_three() {
		assertEquals(3, undertest.add("1,2"));
	}

	@Test
	public void new_line_is_allowed_as_separator() {
		assertEquals(6, undertest.add("1\n2,3"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void new_line_at_the_end_is_not_allowed() {
		undertest.add("1,\n");
	}
	
	@Test
	public void delimiter_is_in_front_of_the_numbers() {
		assertEquals(3, undertest.add("//;\n1;2"));
	}

	@Test
	public void negative_numbers_are_not_allowed() {
		try {
			undertest.add("1,-2");
			fail("NegativeNumberException should be thrown!");
		} catch (NegativeNumberException e) {
			List<Integer> negativeNumbers = e.getNegativeNumbers();
			assertThat(negativeNumbers, hasSize(1));
			assertThat(negativeNumbers, contains(new Integer(-2)));
		}
	}
	
	@Test
	public void negative_numbers_are_not_allowed_complex() {
		try {
			undertest.add("//;\n1;-2");
			fail("NegativeNumberException should be thrown!");
		} catch (NegativeNumberException e) {
			List<Integer> negativeNumbers = e.getNegativeNumbers();
			assertThat(negativeNumbers, hasSize(1));
			assertThat(negativeNumbers, contains(new Integer(-2)));
		}
	}

}
