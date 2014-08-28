package snl.game;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class JumpRule {

    private int startPosition;
    private int endPosition;
    private Type type;

    JumpRule(final int startPosition, final int endPosition, final Type type) throws Exception {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.type = type;
        
        switch (type) {
		case SNAKE:
			if(startPosition <= endPosition) {
				throw new IllegalArgumentException("Startposition must be greater than endposition!");
			}
			break;
			
		case LADDER:
			if(startPosition >= endPosition) {
				throw new IllegalArgumentException("Startposition must be lower than endposition!");
			}
			break;
		}
    }
    
    int getStartPosition() {
		return startPosition;
	}

    int getEndPosition() {
        return endPosition;
    }

	Type getType() {
		return type;
	}
}
