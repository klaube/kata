package snl.game;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Splitter;
import com.google.common.io.Files;

/**
 * @author Katharina Laube
 * @since 01.09.2014
 */
public class GameRunner {
	
	private static final String DIRECTORY = "D:\\Development\\GitHub\\kataKL\\snakesLadders\\res\\";
	private static final String FILE_NAME = "gameSetUp.txt";
	private static final String PATH = DIRECTORY + FILE_NAME;

    private Game game;
    
    public GameRunner() {
    	game = new Game();
	}

    public void createGameFromFile() throws Exception {
        loadGameSetUpFromFile();
        
        final Player firstPlayer = new Player("Max");
        game.addPlayer(firstPlayer);
        
        final Player secondPlayer = new Player("Kati");
        game.addPlayer(secondPlayer);
        
        final Player thirdPlayer = new Player("Java");
        game.addPlayer(thirdPlayer);
        
        runFullGame();
    }

	private void loadGameSetUpFromFile() throws Exception {
        
        final File file = new File(PATH);
		final Charset charset = Charset.defaultCharset();
		
		final List<String> gameSetUp = Files.readLines(file, charset);
		
		for (String line : gameSetUp) {
			parseLine(line);
		}
	}

	void parseLine(String line) throws Exception {
		final Iterable<String> rule = Splitter.on(':').split(line);
		
		final Iterator<String> iterator = rule.iterator();
		final String typeStr = iterator.next();
		
		switch (typeStr) {
		case "L":
			addJumpRule(iterator, Type.LADDER);
			break;
		case "S":
			addJumpRule(iterator, Type.SNAKE);
			break;
		case "F":
			Iterable<String> size = Splitter.on('*').split(iterator.next());
			Iterator<String> sizeIterator = size.iterator();
			int length = Integer.parseInt(sizeIterator.next());
			int width = Integer.parseInt(sizeIterator.next());
			game.setFieldSize(length*width);
			break;
		default:
			throw new IllegalArgumentException("Unknown Linestart [" + typeStr + "]");
		}
	}

	private void addJumpRule(Iterator<String> iterator, Type type)
			throws Exception {
		final Integer start = Integer.valueOf(iterator.next());
		final Integer end = Integer.valueOf(iterator.next());
		game.addJumpRule(new JumpRule(start, end, type));
	}
	
	private void runFullGame() throws Exception {
		while (!game.isOver()) {
			game.moveCurrentPlayer();
			
			if (game.isOver()) {
				System.out.println("The winner is " + game.getCurrentPlayer().getName() + "!");
			} else {
				game.shiftPlayer();
			}
		}
	}

	int getFieldSize() {
		return game.getFieldSize();
	}

	JumpRule getJumpRule(int start) {
		return game.getSpecialPositions().get(start);
	}
}
