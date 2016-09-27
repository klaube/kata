package gossipingBusDrivers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Driver {

	private Set<Gossip> gossip;

	List<Station> route;

	public Driver() {
		gossip = new HashSet<>();
		gossip.add(new Gossip());
	}

	void addRoute(List<Station> route) {
		this.route = route;
	}

	public Set<Gossip> getGossip() {
		return gossip;
	}

	public int getGossipCount() {
		return getGossip().size();
	}

	public void stopAtStation(int time) {
		Station station = route.get(time % route.size());
		station.addDriver(this);
	}

	public void addAllGossip(Set<Gossip> newGossip) {
		gossip.addAll(newGossip);
	}

}
