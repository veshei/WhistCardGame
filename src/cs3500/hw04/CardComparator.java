package cs3500.hw04;

import java.util.Comparator;

import cs3500.hw02.Card;

/**
 * Created by veronicashei on 6/2/16.
 */

/**
 * A class that compares two cards and implements the Comparator interface
 */
public class CardComparator implements Comparator<Card> {


  /**
   * A method to compare two cards to see if they are less than, greater than, or equal to each
   * other
   *
   * @param c1 the first card
   * @param c2 the second card
   * @return an int indicating whether or not the card is less than, greater than, or equal to each
   * other
   */
  @Override
  public int compare(Card c1, Card c2) {
    if (c1.getSuit() == c2.getSuit()) {
      if (c1.getRank() == c2.getRank()) {
        return 0;
      } else if (c1.getRank() < c2.getRank()) {
        return 1;
      } else {
        return -1;
      }
    } else if (c1.getSuit() < c2.getSuit()) {
      return 1;
    } else {
      return -1;
    }
  }
}
