package gossipingBusDrivers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

	private Map<String, Station> stations;

	private List<List<Station>> routes;

	private List<Driver> drivers;

	private String completeTime = "never";

	public World() {
		stations = new HashMap<>();
		routes = new ArrayList<>();
		drivers = new ArrayList<>();
	}

	public void addRoute(String routeAsString) {

		List<Station> route = new ArrayList<>();

		String[] split = routeAsString.split(" ");
		for (String stationNumber : split) {
			Station existing = stations.get(stationNumber);
			if (existing != null) {
				route.add(existing);
				continue;
			}

			Station newStation = new Station(stationNumber);
			stations.put(stationNumber, newStation);
			route.add(newStation);
		}

		routes.add(route);

		addDriver(route);
	}

	private void addDriver(List<Station> route) {

		Driver driver = new Driver();
		driver.addRoute(route);

		drivers.add(driver);
	}

	public String getCurrentStation() {
		return completeTime;
	}

	public void simulate() {
		for (int time = 0; time < 480; time++) {

			resetStations();

			updateStations(time);

			exchangeGossip();

			if (isAllGossipShared()) {
				completeTime = String.valueOf(time + 1);
				return;
			}
		}
	}

	private void resetStations() {
		for (Station station : stations.values()) {
			station.reset();
		}
	}

	private void updateStations(int time) {
		for (Driver driver : drivers) {
			driver.stopAtStation(time);
		}
	}

	private void exchangeGossip() {
		for (Station station : stations.values()) {
			station.exchangeGossip();
		}
	}

	boolean isAllGossipShared() {
		int allGossip = drivers.size();
		for (Driver driver : drivers) {
			if (allGossip != driver.getGossipCount()) {
				return false;
			}
		}
		return true;
	}

	public Driver getDriver(int i) {
		return drivers.get(i);
	}
}
