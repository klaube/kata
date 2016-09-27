package gossipingBusDrivers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StationTest {


	@Test
	public void a_lonely_driver_doesnt_exchange_gossip() {

		Driver driver = new Driver();

		Station station = new Station("1");

		station.addDriver(driver);

		station.exchangeGossip();

		assertEquals(1, driver.getGossipCount());
	}

	@Test
	public void two_drivers_should_exchange_gossip() {

		Driver driver = new Driver();
		Driver driver2 = new Driver();

		Station station = new Station("1");

		station.addDriver(driver);
		station.addDriver(driver2);

		station.exchangeGossip();

		assertEquals(2, driver.getGossipCount());
		assertEquals(2, driver2.getGossipCount());
	}
}
