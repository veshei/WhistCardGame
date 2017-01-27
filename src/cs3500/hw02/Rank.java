package cs3500.hw02;

/**
 * Created by veronicashei on 5/18/16.
 */

/**
 * Represents the rank of a card
 */
public enum Rank {
  /**
   * @param value   represents the rank of the card as an int
   */

  Ace(14), King(13), Queen(12), Jack(11), Ten(10),
  Nine(9), Eight(8), Seven(7), Six(6), Five(5),
  Four(4), Three(3), Two(2);
  private int value;

  Rank(int value) {
    this.value = value;
  }

  /**
   * Getter method for rank
   *
   * @return the rank of the card
   */
  public int getRank() {
    return this.value;
  }
}
