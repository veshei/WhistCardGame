package cs3500.hw03;

/**
 * Created by veronicashei on 5/23/16.
 */
public interface IWhistController {

  /**
   * A method <K> void playGame(CardGameModel<K> game, int numPlayers). This method should start the
   * provided game model. It should throw an IllegalArgumentException only if the model is null or
   * number of players passed to it is invalid.
   *
   * @param game       specifies the correct game model
   * @param numPlayers provides the number of players in the game
   * @param <K>        a game of type K, where K is the type of game
   */
  <K> void playGame(CardGameModel<K> game, int numPlayers);
}

