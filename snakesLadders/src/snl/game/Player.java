package snl.game;


/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class Player {
    private int position;
    
    public Player() {
    	setPosition(1);
	}

    public void setPosition(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void rollDice(int diceValue) {
        position += diceValue;
    }
}
