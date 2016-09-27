package gossipingBusDrivers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	private static final List<Station> route = Arrays.asList(new Station("1"), new Station("2"));
	private Driver driver;

	@Before
	public void setUp() {
		driver = new Driver();
	}

	@Test
	public void driver_should_start_with_one_gossip() {
		assertEquals(1, driver.getGossipCount());
	}

	@Test
	public void driver_should_have_a_route() {
		driver.addRoute(route);
		List<Station> result = driver.route;

		assertEquals(2, result.size());
	}

}
