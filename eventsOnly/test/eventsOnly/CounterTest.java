package eventsOnly;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube
 */
public class CounterTest {

	private Counter classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new Counter(); 
	}

	@Test
	public void the_initial_count_is_zero() {
		int count = classUnderTest.getCount("050");
		assertThat(count, equalTo(0));
	}

}
