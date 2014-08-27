package snl.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class Game {

    private Map<Integer, JumpRule> specialPositions = new HashMap<>();

    private List<Player> players = new ArrayList<>();

    private int currentPlayer = 0;

    public void initGame() {

    }

    public void moveCurrentPlayer() {
        final Player currentPlayer = getCurrentPlayer();

        currentPlayer.rollDice();

        final int endPosition = specialPositions.get(currentPlayer.getPosition()).getEndPosition();

        currentPlayer.setPosition(endPosition);
    }

    public void shiftPlayer() {
        if(this.currentPlayer == players.size() -1 ) {
            this.currentPlayer = 0;
        } else {
            this.currentPlayer ++;
        }
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public int getSize() {
        return 100;
    }

    public void addPlayer(final Player player) {
        players.add(player);
    }

    public boolean isOver() {
        return true;
    }
}
