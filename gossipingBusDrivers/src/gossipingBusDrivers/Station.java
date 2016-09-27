package gossipingBusDrivers;

import java.util.HashSet;

public class Station {

	private HashSet<Driver> drivers;
	private HashSet<Gossip> gossip;
	private String id;

	public Station(String id) {
		this.id = id;
		drivers = new HashSet<>();
		gossip = new HashSet<>();
	}

	public void addDriver(Driver driver) {
		drivers.add(driver);
		gossip.addAll(driver.getGossip());
	}

	public void reset() {
		drivers.clear();
		gossip.clear();
	}

	public void exchangeGossip() {

		for (Driver driver : drivers) {
			driver.addAllGossip(gossip);
		}
	}

	@Override
	public String toString() {
		return "Station [" + id + "]";
	}

}
