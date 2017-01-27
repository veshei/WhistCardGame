package cs3500.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veronicashei on 5/18/16.
 */

/**
 * Represents a player in the game
 */
public class Player {
  /**
   * @param playerCards   the list of cards in the player's hands
   */
  private List<Card> playerCards;
  private int playerScores;


  public Player() {
    this.playerCards = new ArrayList<Card>();
    this.playerScores = 0;
  }

  /**
   * Getter method for the list of cards in the player's hands
   *
   * @return the list of cards in the player's hands
   */
  public List<Card> getAllCards() {
    return this.playerCards;
  }

  /**
   * Adds a card to the player's list of cards
   *
   * @param card the card to be added to the list
   */
  public void addCard(Card card) {
    playerCards.add(card);
  }

  /**
   * Integer to void Removes the specified card from the list
   *
   * @param cardIdx the index of the card to be removed
   */

  public void removeCard(int cardIdx) {
    playerCards.remove(cardIdx);
  }

  /**
   * Gives the card specified at that index
   *
   * @param cardIdx the index of the card
   * @return the card at that index
   */
  public Card getCard(int cardIdx) {
    return playerCards.get(cardIdx);
  }

  public int getScore() {
    return playerScores;
  }

  public void setScore() {
    playerScores++;
  }

}