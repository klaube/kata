package kanbanBoard;


/**
 * 
 * @author Isabel Batista, Katharina Laube
 * @since 18.02.2015
 */
public class Task {
	
	private State state;
	private Owner owner;

	public Task() {
		state = State.ToDo;
	}
 	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Owner getOwner() {
		return owner;
	}

}
