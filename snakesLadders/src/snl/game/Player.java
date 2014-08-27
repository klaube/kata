package snl.game;

import java.util.Random;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class Player {
    private int position;

    public void setPosition(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void rollDice() {
        position += getDiceValue();
    }

    public int getDiceValue() {
        return new Random().nextInt(6) + 1;
    }
}
