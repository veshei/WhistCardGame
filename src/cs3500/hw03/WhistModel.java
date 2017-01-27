package cs3500.hw03;

/**
 * Created by veronicashei on 5/23/16.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cs3500.hw02.GenericStandardDeckGame;
import cs3500.hw02.Player;
import cs3500.hw02.Card;

/**
 * Represents the game of Whist
 */
public class WhistModel extends GenericStandardDeckGame implements CardGameModel {

  protected List<Trick> pile;
  protected int turn;
  protected int pileSuit;

  public WhistModel() {
    super();
    pile = new ArrayList<>();
    deck = super.getDeck();
    turn = -1;
    pileSuit = -1;

  }

  /**
   * Also have to consider the case where the winner of the pile has no more cards, continue in
   * round robin fashion
   *
   * @param playerNo the player at that number
   * @param cardIdx  the card at that index
   */
  @Override
  public void play(int playerNo, int cardIdx) {
    if (this.invalidTurn(playerNo)) {
      throw new IllegalArgumentException("Player out of turn");
    } else if (this.gameNotStarted()) {
      throw new IllegalArgumentException("Game has not been started yet");
    } else if (this.invalidCardIdx(playerNo, cardIdx)) {
      throw new IllegalArgumentException("Invalid card index");
    } else if (this.invalidSuit(playerNo, cardIdx)) {
      throw new IllegalArgumentException("Invalid suit given");
    } else if (this.isGameOver()) {
      throw new IllegalArgumentException("Game is over");
    } else {
      if (pile.size() == 0) {
        Card pileCard = players.get(playerNo).getCard(cardIdx);
        pile.add(new Trick(playerNo, pileCard));
        pileSuit = pileCard.getSuit();
        players.get(playerNo).removeCard(cardIdx);
        turn = (playerNo + 1) % players.size();
      } else if (players.get(playerNo).getAllCards().size() != 0) {
        Card pileCard = players.get(playerNo).getCard(cardIdx);
        pile.add(new Trick(playerNo, pileCard));
        players.get(playerNo).removeCard(cardIdx);
        if (players.get((playerNo + 1) % players.size()).getAllCards().size() == 0) {
          turn = 0;
        } else {
          turn = (playerNo + 1) % players.size();
        }
      }
      if (pile.size() == players.size()
          || players.get((playerNo + 1) % players.size()).getAllCards().size() == 0) {
        List<Card> temp = new ArrayList<>();
        for (int r = 0; r < pile.size(); r++) {
          if (pile.get(r).getCard().getSuit() == pileSuit) {
            temp.add(pile.get(r).getCard());
          }
        }
        Collections.sort(temp);
        for (int n = 0; n < temp.size(); n++) {
          if (temp.get(0) == pile.get(n).getCard()) {
            int winner = pile.get(n).getPlayerNo();
            players.get(winner).setScore();
            if (players.get(winner).getAllCards().size() == 0) {
              turn = 0;
            } else {
              turn = winner;
            }
          }
        }
        pileSuit = -1;
        pile.clear();
      }
    }
  }

  /**
   * Helper function for play checks whether or not the correct player is called for the next turn
   *
   * @param playerNo the player given for that turn
   * @return a boolean indicating whether or not this is the correct turn for that player
   */
  protected boolean invalidTurn(int playerNo) {
    return turn != -1 && turn != playerNo;
//    if (turn == -1) {
//      return false;
//    } else {
//      return turn != playerNo;
//    }
  }

  /**
   * Helper function for play checks whether or not play has been started yet
   *
   * @return a boolean indicating whether or not the game has been started
   */
  protected boolean gameNotStarted() {
    List<Player> cardSize = new ArrayList<>();
    boolean flag = false;
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getAllCards().size() == 0) {
        cardSize.add(players.get(i));
      }
    }
    if (cardSize.size() == players.size()) {
      for (int r = 0; r < players.size(); r++) {
        if (players.get(r).getScore() == 0) {
          flag = true;
        }
      }
    }
    return flag;
  }

  /**
   * Helper function for play Checks whether or not an invalid card index was given for that
   * particular player, i.e. did the player give an index of a card he does not have or of a card
   * that does not exist?
   *
   * @param cardIdx the index of the card given
   * @return a boolean indicating whether or not the given index is valid
   */
  protected boolean invalidCardIdx(int playerNo, int cardIdx) {
    boolean flag = false;
    if (cardIdx > (players.get(playerNo).getAllCards().size() - 1)) {
      flag = true;
    }
    return flag;
  }

  /**
   * Helper function for play Checks whether or not the player has given the wrong suit even though
   * the player has a card of the correct suit
   *
   * @return a boolean indicating whether or not the suit is valid for that turn
   */
  protected boolean invalidSuit(int playerNo, int cardIdx) {
    boolean flag = false;
    if (pile.size() == 0) {
      flag = false;
    } else {
        for (int r = 0; r < players.get(playerNo).getAllCards().size(); r++) {
          if (players.get(playerNo).getAllCards().get(r).getSuit() == pileSuit) {
            if (players.get(playerNo).getAllCards().get(cardIdx).getSuit() != pileSuit) {
              flag = true;
            }
          }
        }
      }
    return flag;
  }

  /**
   * Provides the int of the current player Checks to see if the game has started yet, if it has set
   * current player to 1 (cannot use turn because turn is originally initialized to -1), then if the
   * game has started it sets the currentPlayer to one more than the turn.
   *
   * @return the current player
   */
  @Override
  public int getCurrentPlayer() {
    if (isGameOver()) {
      throw new IllegalArgumentException("Game has ended");
    } else {
      int currentPlayer;
      if (turn == -1) {
        currentPlayer = 0;
      } else {
        currentPlayer = turn;
      }
      return currentPlayer;
    }
  }

  /**
   * Helper function for isGameOver() Checks whether or not the players have any cards left
   *
   * @return a boolean indicating if the player still has cards
   */
  private boolean cardExist() {
    int x = 0;
    for (int i = 0; i < players.size(); i++) {
      x = x + players.get(i).getAllCards().size();
    }
    return (x == 0);
  }

  /**
   * Checks whether or not the game is finished
   *
   * @return a boolean indicating whether or not the game is over
   */
  @Override
  public boolean isGameOver() {
    if (turn == -1 && gameNotStarted()) {
      throw new IllegalArgumentException("Game has not started yet");
    } else {
      return players.size() < 2 || cardExist();
    }
  }

  /**
   * Override the String getGameState() that returns a String that contains the entire state of the
   * game as follows, one on each line: Number of players: N (as before) Player 1: cards in sorted
   * order (as a comma-separate list as before) Player 2: cards in sorted order (as a comma-separate
   * list as before ... Player N: cards in sorted order (as a comma-separate list as before) Player
   * 1 score: X (where X is the number of tricks won) Player 2 score: Y (where Y is the number of
   * tricks won) ... Player N score: Z (where Z is the number of tricks won) Special message
   *
   * The comma-separated lists should separate each item by a single comma and a single space,
   * exactly as specified in Assignment 2. There is no trailing newline. The special message in the
   * end should be either "Turn: Player X" if the game is ongoing and it is player X’s turn to play
   * next, or "Game over. Player X won." if the game is over and player X has won. For this message,
   * the player numbers start with 1.
   *
   * @return a String that represents the entire state of the game
   */
  @Override
  public String getGameState() {
    String output = super.getGameState();
    String playerScore = "";
    for (int i = 0; i < players.size(); i++) {
      playerScore = playerScore + "Player " + (i + 1) + " score: "
          + players.get(i).getScore() + "\n";
    }
    if (isGameOver()) {
      playerScore = playerScore + "Game over. " + this.winner() + " won.";
    } else {
      playerScore = playerScore + "Turn: Player " + (this.getCurrentPlayer() + 1);
    }
    output = output + playerScore;
    return output;
  }

  /**
   * Helper function for getGameState() Determines the index of the winner of the game
   *
   * @return the integer index of the winner of the game
   */

  private String winner() {
    ArrayList<Integer> winner = new ArrayList<>();
    String output = "";
    int max;
    int temp;
    List<Integer> scores1 = new ArrayList<>();
    for (int i = 0; i < players.size(); i++) {
      temp = players.get(i).getScore();
      scores1.add(temp);
    }

    max = Collections.max(scores1);
    for (int r = 0; r < scores1.size(); r++) {
      if (max == scores1.get(r)) {
        winner.add(r);
      }
    }
    if (winner.size() == 1) {
      output = "Player " + (winner.get(0) + 1);
    } else {
      for (int n = 0; n < winner.size(); n++) {
        if (n < winner.size() - 1) {
          output = output + "Player " + (winner.get(n) + 1) + " and ";
        } else {
          output = output + "Player " + (winner.get(n) + 1);
        }
      }
    }
    return output;
  }

  public boolean equals(Object o) {
    boolean flag = true;
    WhistModel whistModel;
    if (o instanceof WhistModel) {
      whistModel = (WhistModel) o;
    } else {
      throw new ClassCastException();
    }
    for (int i = 0; i < deck.size(); i++) {
      flag = flag && this.deck.get(i).equals(whistModel.deck.get(i));
    }
    flag = flag && players.size() == whistModel.players.size();
    flag = flag && this.turn == whistModel.turn;
    flag = flag && this.pileSuit == whistModel.pileSuit;
    return flag;
  }

  public int hashCode() {
    return Objects.hash(this.deck, players.size());
  }
}