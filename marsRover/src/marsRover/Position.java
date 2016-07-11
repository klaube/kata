package marsRover;

import java.util.Objects;

public class Position {

	private int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position(Position position) {
		this.x = position.x;
		this.y = position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}

	void advanceX(int diff) {
		x = x + diff;
	}

	void advanceY(int diff) {
		y = y + diff;
	}

	@Override
	public String toString() {
		return String.format("(%1$2s, %2$2s)", x, y);
	}
}
