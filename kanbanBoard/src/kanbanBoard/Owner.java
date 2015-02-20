package kanbanBoard;

import java.util.HashMap;

/**
 * An owner is a person who owns a task.
 * An owner is only allowed to own one task with state Work-in-Progress
 * and one testing task in parallel.
 * 
 * @author Katharina Laube
 * @since 18.02.2015
 */
public class Owner {

	private String name;
	private HashMap<State, Boolean> ownership;

	public Owner(String name) {
		this.name = name;
		ownership = new HashMap<>();
	}

	public void removePreviousState(State previousState) {
		ownership.put(previousState, false);
	}

	public void setNewState(State newState) {
		ownership.put(newState, true);
	}

	public boolean has(State newState) {
		return ownership.getOrDefault(newState, false);
	}

	@Override
	public String toString() {
		return name;
	}
}
