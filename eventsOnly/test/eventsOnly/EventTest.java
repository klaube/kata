package eventsOnly;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import net.micwin.ticino.Ticino;

import org.junit.Before;
import org.junit.Test;

/**
 * Test sending one event and receiving it by different listener.
 *
 * @author Katharina Laube
 */
public class EventTest {

	private Counter receiver1;
	private CustomerCare receiver2;

	@Before
	public void setUp() throws Exception {
		receiver1 = new Counter();
		Ticino.register(IncomingTelNumber.class, receiver1);
		
		receiver2 = new CustomerCare();
		Ticino.register(IncomingTelNumber.class, receiver2);
	}

	@Test
	public void when_no_events_was_send_then_count_is_zero() {
		assertThat(receiver1.getCount("040"), equalTo(0));
	}

	@Test
	public void when_no_events_was_send_then_no_one_anwsers() {
		assertThat(receiver2.getAnwser(), equalTo("No number was called!"));
	}
	
	@Test
	public void when_one_event_was_send_then_count_for_hamburg_is_one() {
		Ticino.dispatch(new IncomingTelNumber("040444444"));
		assertThat(receiver1.getCount("040"), equalTo(1));
	}
	
	@Test
	public void when_one_event_for_hamburg_was_send_then_count_for_Berlin_is_zero() {
		Ticino.dispatch(new IncomingTelNumber("030333333"));
		assertThat(receiver1.getCount("040"), equalTo(0));
	}
	
	@Test
	public void when_one_event_for_hamburg_was_send_then_hamburg_anwsers() {
		Ticino.dispatch(new IncomingTelNumber("040444444"));
		assertThat(receiver2.getAnwser(), equalTo("Hamburg anwsers the call!"));
	}

}
