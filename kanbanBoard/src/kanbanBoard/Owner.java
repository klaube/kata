package kanbanBoard;

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
	private boolean workInProgress;
	private boolean testing;

	public Owner(String name) {
		this.name = name;
	}

	public void setNewState(State newState) {
		switch (newState) {
		case ToDo: return;
		
		case WiP: 
			workInProgress = true;
			return;
			
		case Test: 
			workInProgress = false;
			testing = true;
			return;
			
		case Done:
			testing = true;
			return;
		}
	}

	public boolean has(State newState) {
		switch (newState) {
		case WiP: return workInProgress;
		case Test: return testing;
		default: return false;
		}
	}

	@Override
	public String toString() {
		return name;
	}
}
