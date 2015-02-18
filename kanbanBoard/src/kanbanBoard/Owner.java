package kanbanBoard;

/**
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
		case WiP: return hasWorkInProgress();
		case Test: return isTesting();
		default: return true;
		}
	}

	boolean isTesting() {
		return testing;
	}
	
	boolean hasWorkInProgress() {
		return workInProgress;
	}

	@Override
	public String toString() {
		return name;
	}

}
