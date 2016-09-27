package gossipingBusDrivers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {

	private static final String route11 = "3 1 2 3";
	private static final String route12 = "3 2 3 1";
	private static final String route13 = "4 2 3 4 5";

	private World world;

	@Before
	public void setUp() {
		world = new World();
	}

	@SuppressWarnings("boxing")
	@Test
	public void world_should_know_when_all_gossip_was_shared() {

		world.addRoute(route11);

		assertEquals(true, world.isAllGossipShared());
	}

	@Test
	public void two_drivers_should_exchange_gossip_at_first_station() {

		world.addRoute(route11);
		world.addRoute(route12);

		world.simulate();

		assertEquals(2, world.getDriver(0).getGossipCount());
		assertEquals(2, world.getDriver(1).getGossipCount());

		assertEquals("1", world.getCurrentStation());
	}

	@Test
	public void three_drivers_should_exchange_gossip_at_fifth_station() {

		world.addRoute(route11);
		world.addRoute(route12);
		world.addRoute(route13);

		world.simulate();

		assertEquals(3, world.getDriver(0).getGossipCount());
		assertEquals(3, world.getDriver(1).getGossipCount());
		assertEquals(3, world.getDriver(2).getGossipCount());

		assertEquals("5", world.getCurrentStation());
	}

	@Test
	public void two_drivers_should_never_exchange_gossip() {

		world.addRoute("2 1 2");
		world.addRoute("5 2 8");

		world.simulate();

		assertEquals("never", world.getCurrentStation());
	}

	@Test
	public void test_challenge_input_1() {

		world.addRoute("7 11 2 2 4 8 2 22");
		world.addRoute("3 0 11 8");
		world.addRoute("5 11 8 10 3 11");
		world.addRoute("5 9 2 5 0 3");
		world.addRoute("7 4 8 2 8 1 0 5");
		world.addRoute("3 6 8 9");
		world.addRoute("4 2 11 3 3");

		world.simulate();

		assertEquals("9", world.getCurrentStation());
	}

	@Test
	public void test_challenge_input_2() {

		world.addRoute("12 23 15 2 8 20 21 3 23 3 27 20 0");
		world.addRoute("21 14 8 20 10 0 23 3 24 23 0 19 14 12 10 9 12 12 11 6 27 5");
		world.addRoute("8 18 27 10 11 22 29 23 14");
		world.addRoute("13 7 14 1 9 14 16 12 0 10 13 19 16 17");
		world.addRoute("24 25 21 4 6 19 1 3 26 11 22 28 14 14 27 7 20 8 7 4 1 8 10 18 21");
		world.addRoute("13 20 26 22 6 5 6 23 26 2 21 16 26 24");
		world.addRoute("6 7 17 2 22 23 21");
		world.addRoute("23 14 22 28 10 23 7 21 3 20 24 23 8 8 21 13 15 6 9 17 27 17 13 14");
		world.addRoute("23 13 1 15 5 16 7 26 22 29 17 3 14 16 16 18 6 10 3 14 10 17 27 25");
		world.addRoute("25 28 5 21 8 10 27 21 23 28 7 20 6 6 9 29 27 26 24 3 12 10 21 10 12 17");
		world.addRoute("26 22 26 13 10 19 3 15 2 3 25 29 25 19 19 24 1 26 22 10 17 19 28 11 22 2 13");
		world.addRoute("8 4 25 15 20 9 11 3 19");
		world.addRoute("24 29 4 17 2 0 8 19 11 28 13 4 16 5 15 25 16 5 6 1 0 19 7 4 6");
		world.addRoute("16 25 15 17 20 27 1 11 1 18 14 23 27 25 26 17 1");

		world.simulate();

		assertEquals("16", world.getCurrentStation());
	}

}
