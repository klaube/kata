package marsRover;

public enum Direction {
	North,
	East,
	South,
	West;

	Direction getNextDirection(boolean clockwise) {
		switch (this) {
		case North: return clockwise ? East : West;
		case East: return clockwise ? South : North;
		case South: return clockwise ? West : East;
		case West: return clockwise ? North : South;
		}
		throw new UnsupportedOperationException();
	}

	void print() {
		switch (this) {
		case North: System.out.print("^"); break;
		case East: System.out.print(">"); break;
		case South: System.out.print("v"); break;
		case West: System.out.print("<"); break;
		}
	}}
