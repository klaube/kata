package eventsOnly;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Katharina Laube
 */
public class IncomingTelNumberTest {

	private IncomingTelNumber classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new IncomingTelNumber("0505555555");
	}

	@Test
	public void testGetVorwahl() {
		String vorwahl = classUnderTest.getVorwahl();
		assertThat(vorwahl, equalTo("050"));
	}

}
