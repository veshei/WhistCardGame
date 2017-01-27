package cs3500.hw04;

import org.junit.Test;

import java.io.StringReader;

import cs3500.hw03.CardGameModel;
import cs3500.hw03.IWhistController;
import cs3500.hw03.WhistController;
import cs3500.hw03.WhistModel;

import static org.junit.Assert.assertEquals;

/**
 * Created by veronicashei on 6/5/16.
 */
public class WhistTrumpModelControllerTest {
  @Test
  public void testTrumpController() {
    CardGameModel gameModel = new WhistTrumpModel();
    StringBuffer out = new StringBuffer();
    IWhistController controller = new WhistController(new StringReader("0 0 0 0 0 0 0 0 0 0 0 0" +
        " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 " +
        "0 0 0 0 0 0 0 0 0 0 0 0 q "), out);
    controller.playGame(gameModel, 4);

    assertEquals(gameModel.getGameState(), "Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1 score: 0\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 12\n" +
        "Game over. Player 4 won.\n" +
        "Trump suit: ♣");
  }

  /**
   * Tests to see if the controller works with an odd number of players like three
   */
  @Test
  public void testThreeTrumpPlayerGame() {
    CardGameModel gameModel = new WhistTrumpModel();
    StringBuffer out = new StringBuffer();
    IWhistController controller = new WhistController(new StringReader("0 0 0 0 0 0 0 0 0 0 0 0" +
        " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
        " 0 0 0 0 0 0 0 0 0 0 0 0 0 q "), out);
    controller.playGame(gameModel, 3);

    assertEquals(gameModel.getGameState(), "Number of players: 3\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 1 score: 18\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Game over. Player 1 won.\n" +
        "Trump suit: ♣");
  }

  /**
   * Tests to see if the controller works for a game with five players
   */
  @Test
  public void testTrumpFivePlayerGame() {
    CardGameModel gameModel = new WhistTrumpModel();
    StringBuffer out = new StringBuffer();
    IWhistController controller = new WhistController(new StringReader("0 0 0 0 0 0 0 0 0 0 0 0" +
        " 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0" +
        " 0 0 0 0 0 0 0 0 0 0 0 0 0 q "), out);
    controller.playGame(gameModel, 5);

    assertEquals(gameModel.getGameState(), "Number of players: 5\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 5: \n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 10\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Game over. Player 2 won.\n" +
        "Trump suit: ♣");
  }
}