package snl.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Max Schwaab, Katharina Laube
 * @since 27.08.2014
 */
public class Game {

    private Map<Integer, JumpRule> specialPositions;

    private List<Player> players;

    private int currentPlayer;

	private int fieldSize;
	
	public Game() {
		System.out.println("\n\nLet's start a new game!");
		System.out.println("=======================");
		
	    specialPositions = new HashMap<>();
	    players = new ArrayList<>();
	    currentPlayer = 0;
	}

    void addPlayer(final Player player) {
        players.add(player);
        System.out.println("Welcome player " + player.getName() +"!");
    }

    Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

	public void moveCurrentPlayer() {
		moveCurrentPlayerForTest(getDiceValue());
	}

    void moveCurrentPlayerForTest(int diceValue) {
    	
    	checkFieldSize();
    	
        final int lastPosition = getCurrentPlayer().getPosition();
        final String playerName = getCurrentPlayer().getName();

        // roll dice
        int newPosition = lastPosition + diceValue;
        if (newPosition > getFieldSize()) {
        	System.out.println("\nSorry " + playerName + ", you have to roll a '" 
        			+ (getFieldSize()-lastPosition) + "' or lower!");
        	return;
        }
        System.out.println("\n" + playerName + ", you have rolled '" +  diceValue+ "'. "
        		+ "This moves you to " + newPosition + ".");
        
        // use snake or ladder
		JumpRule jumpRule = specialPositions.get(newPosition);
		if (jumpRule != null) {
			newPosition = jumpRule.getEndPosition();
			System.out.println("You have found a " + jumpRule.getType()
					+ ". It moves you to " + newPosition + ".");
		}
		
		getCurrentPlayer().setPosition(newPosition);
    }

    void shiftPlayer() {
        if(this.currentPlayer == players.size() -1 ) {
            this.currentPlayer = 0;
        } else {
            this.currentPlayer ++;
        }
    }

    boolean isOver() {
        return getCurrentPlayer().getPosition() == getFieldSize();
    }

    int getDiceValue() {
        return new Random().nextInt(6) + 1;
    }

	int getPlayersPosition(Player searchedPlayer) {
		for (Player player : players) {
			if (player.equals(searchedPlayer)) {
				return player.getPosition();
			}
		}
		throw new IllegalArgumentException("Player [" + searchedPlayer + "] is unknown!");
	}

	void addJumpRule(JumpRule jumpRule) {
    	
		checkFieldSize();
		checkJumpRule(jumpRule);
		specialPositions.put(jumpRule.getStartPosition(), jumpRule);
	}

	private void checkJumpRule(JumpRule jumpRule) {
		Type type = jumpRule.getType();
		switch (type) {
		case LADDER:
			if (jumpRule.getStartPosition() >= getFieldSize()) {
				throw new IllegalArgumentException(type + " must not start before field's end!");
			}
			if (jumpRule.getStartPosition() < 1) {
				throw new IllegalArgumentException(type + " must start at least on field's start!");
			}
			break;
		case SNAKE:
			if (jumpRule.getStartPosition() < 2) {
				throw new IllegalArgumentException(type + " must start after field's start!");
			}
			if (jumpRule.getStartPosition() >= getFieldSize()) {
				throw new IllegalArgumentException(type + " must start before field's end!");
			}
			if (jumpRule.getEndPosition() < 1) {
				throw new IllegalArgumentException(type + " must not end before field's start!");
			}
			break;
		}
	}

    int getFieldSize() {
    	checkFieldSize();
        return fieldSize;
    }

	private void checkFieldSize() {
		if (fieldSize <= 0) {
    		throw new IllegalArgumentException("Please initialize the field's size!");
    	}
	}

	public void setFieldSize(int fieldSize) {
        System.out.println("The field's size is " + fieldSize +".");
		this.fieldSize = fieldSize;
	}

	public Map<Integer, JumpRule> getSpecialPositions() {
		return specialPositions;
	}
}
