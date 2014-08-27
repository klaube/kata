package snl.game;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class JumpRule {

    private int startPosition;
    private int endPosition;
    private String type;

    public JumpRule(final int startPosition, final int endPosition, final String type) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.type = type;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
