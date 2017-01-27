package cs3500.hw03;

/**
 * Created by veronicashei on 5/23/16.
 */

import cs3500.hw02.GenericCardGameModel;

public interface CardGameModel<K> extends GenericCardGameModel {

  /**
   * A method void play(int playerNo, int cardIdx) that plays the card at index cardIdx in the set
   * of cards for player number playerNo. It is assumed that both player numbers and card indices
   * begin with 0. It is further assumed that players’ hands are sorted in the same way they are for
   * getGameState().
   *
   * @param playerNo the player at that number
   * @param cardIdx  the card at that index
   */
  void play(int playerNo, int cardIdx);

  /**
   * A method int getCurrentPlayer() that returns the player whose turn it is to play (again, player
   * numbers begin with 0). It should throw an IllegalArgumentException if the game has ended.
   *
   * @return the int of the current player
   */
  int getCurrentPlayer();

  /**
   * A method boolean isGameOver() that returns true if the game is over, false otherwise.
   *
   * @return a boolean indicating whether or not the game is over
   */
  boolean isGameOver();
}
