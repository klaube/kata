
public class Cell {

	boolean alive = true;
	private int count;
	
	public boolean isAlive() {
		return alive;
	}

	public void tick() {
		if (count == 0) {
			alive = false;
			return;
		} 
		if(count > 3) {
			alive = false;
			return;
		}
		alive = true;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void addNeighbour(Cell n1) {
		count++;
	}

}
