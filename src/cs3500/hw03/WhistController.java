package cs3500.hw03;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;


/**
 * Created by veronicashei on 5/23/16.
 */

/**
 * Represents the controller output for the Whist game
 */
public class WhistController implements IWhistController {

  private Scanner input;
  private Appendable out;

  public WhistController(Readable rd, Appendable ap) {
    this.input = new Scanner(rd);
    this.out = ap;
  }

  @Override
  public void playGame(CardGameModel game, int numPlayers) {
    if (numPlayers < 2) {
      throw new IllegalArgumentException("Not enough players");
    }
    if (game == null) {
      throw new IllegalArgumentException("Game has not started");
    }
    String result;
    int cardIdx;
    game.startPlay(numPlayers, game.getDeck());
    while (!game.isGameOver() && input.hasNext()) {
      result = input.next();
      try {
        out.append(game.getGameState() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (result.equals("q")) {
        try {
          out.append("Game quit prematurely");
        } catch (IOException e) {
          e.printStackTrace();
        }
        return;
      } else {
        try {
          cardIdx = Integer.parseInt(result);
          game.play(game.getCurrentPlayer(), cardIdx);
        } catch (NumberFormatException e) {
          try {
            out.append("Try again. Invalid input.");
          } catch (IOException f) {
            f.printStackTrace();
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    CardGameModel gameModel = new WhistModel();
    IWhistController controller = new WhistController(new StringReader("0 0 q "), System.out);
    controller.playGame(gameModel, 6);
  }
}