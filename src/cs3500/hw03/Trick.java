package cs3500.hw03;

/**
 * Created by veronicashei on 5/28/16.
 */

/**
 * Represents one trick played during the game
 */

import cs3500.hw02.Card;

public class Trick {

  private int playerNo;
  private Card card;

  public Trick(int playerNo, Card card) {
    this.playerNo = playerNo;
    this.card = card;
  }

  /**
   * Getter method for playerNo
   *
   * @return the int of the playerNo for that Trick
   */
  public int getPlayerNo() {
    return this.playerNo;
  }

  /**
   * Getter method for Card
   *
   * @return the Card for the Trick
   */
  public Card getCard() {
    return this.card;
  }
}
