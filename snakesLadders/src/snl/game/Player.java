package snl.game;


/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class Player {
    private int position;
	private String name;
    
    public Player(String name) {
    	this.name = name;
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

	public String getName() {
		return name;
	}
}
