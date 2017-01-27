package cs3500.hw02;

/**
 * Created by veronicashei on 5/18/16.
 */

/**
 * Represents the suit values for a card
 */
public enum Suit {
  /**
   * @param value   returns the suit of the card represented as an int
   */
  Club(0), Diamond(1), Heart(2), Spade(3);
  private int value;

  Suit(int value) {
    this.value = value;
  }

  /**
   * Getter method for suit
   *
   * @return the value of the suit
   */
  public int getSuit() {
    return this.value;
  }
}
