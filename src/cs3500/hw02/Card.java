package cs3500.hw02;

/**
 * Created by veronicashei on 5/17/16.
 */

/**
 * Represents a card in a deck of cards
 */

public class Card implements Comparable<Card> {
  /**
   * @param suit    the suit of the card
   * @param rank    the rank of the card
   */
  private final int suit;
  private final int rank;

  public Card(int suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  /**
   * Getter method for suit
   *
   * @return the suit for the card
   */
  public int getSuit() {
    return this.suit;
  }

  /**
   * Getter method for rank
   *
   * @return the rank for the card
   */

  public int getRank() {
    return this.rank;
  }

  /**
   * Compare to method for Comparable, compares two cards based on suit and rank
   *
   * @param card the card that is being compared
   * @return an int representing the hierarchy of the cards
   */
  public int compareTo(Card card) {
//    Card card;
//    if (o instanceof Card) {
//      card = (Card) o;
//    } else {
//      throw new ClassCastException("Invalid Object");
//    }
    if (this.suit == card.suit) {
      if (this.rank == card.rank) {
        return 0;
      } else if (this.rank < card.rank) {
        return 1;
      } else {
        return -1;
      }
    } else if (this.suit < card.suit) {
      return 1;
    } else {
      return -1;
    }
  }

  public boolean equals(Card card) {
//    Card card;
//    if (o instanceof  Card) {
//      card = (Card) o;
//    }
//    else {
//      throw new ClassCastException("Invalid Object");
//    }
    return this.suit == card.suit && this.rank == card.rank;
  }

  public int hashCode() {
    int val = this.rank * 5;
    val = val + this.suit;
    return val;
  }

  public String toString() {
    return this.suit+ ", " + this.rank;
  }
}



