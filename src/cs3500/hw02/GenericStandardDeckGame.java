package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by veronicashei on 5/17/16.
 */

/**
 * Represents the standard deck game
 */
public class GenericStandardDeckGame implements GenericCardGameModel {
  /**
   * Constructs an {@code GenericStandardGame} object
   *
   * @param players     the list of players in the game
   * @param deck        the total list of cards in the game
   */

  protected List<Player> players;
  protected List<Card> deck;

  public GenericStandardDeckGame() {
    this.players = new ArrayList<Player>();
    this.deck = new ArrayList<Card>();
  }

  /**
   * Edited the method to clear the deck each time so the deck does not duplicate when it is called
   * multiple times
   *
   * @return a valid deck of playing cards
   */
  @Override
  public List getDeck() {
    deck.clear();
    for (int suit = 0; suit <= 3; suit++) {
      for (int rank = 2; rank <= 14; rank++) {
        deck.add(new Card(suit, rank));
      }
    }
    return deck;
  }

  /**
   * Checks to see if the deck contains any duplicates
   *
   * @return a boolean indicating whether or not there are any duplicates in the deck
   */
  private boolean containsDuplicates() {
    boolean duplicates = false;
    for (int i = 0; i < deck.size(); i++) {
      for (int r = i + 1; r < deck.size(); r++) {
        if (i != r && deck.get(r) == deck.get(i)) {
          duplicates = true;
        }
      }
    }
    return duplicates;
  }

  @Override
  public void startPlay(int numPlayers, List deck) {
    this.deck = (ArrayList<Card>) deck;
    if (this.deck.size() != 52 || numPlayers <= 0) {
      throw new IllegalArgumentException("Invalid deck size");
    } else if (containsDuplicates()) {
      throw new IllegalArgumentException("Deck contains duplicate cards");
    } else {
      for (int p = 0; p < numPlayers; p++) {
        players.add(new Player());
      }
      int count = 0;
      for (int card = 0; card < deck.size(); card++) {
        players.get(count).addCard((Card) deck.get(card));
        count++;
        if (count == numPlayers) {
          count = 0;
        }
      }
    }
  }

  /**
   * Edited the method to output the right String when there are no cards left in the player's
   * hands
   *
   * @return String representing the state of the game
   */
  @Override
  public String getGameState() {
    String output = "Number of players: " + players.size() + "\n";
    Player player;
    Card card;
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getAllCards().size() == 0) {
        output = output + "Player " + (i + 1) + ": \n";
      } else {
        player = players.get(i);
        String playerCards = "Player " + (i + 1) + ": ";
        Collections.sort(players.get(i).getAllCards());
        for (int r = 0; r < player.getAllCards().size(); r++) {
          card = player.getAllCards().get(r);
          switch (card.getRank()) {
            case 14:
              playerCards = playerCards + "A";
              break;
            case 13:
              playerCards = playerCards + "K";
              break;
            case 12:
              playerCards = playerCards + "Q";
              break;
            case 11:
              playerCards = playerCards + "J";
              break;
            default:
              playerCards = playerCards + card.getRank();

          }
          switch (card.getSuit()) {
            case 0:
              playerCards = playerCards + "♣";
              break;
            case 1:
              playerCards = playerCards + "♦";
              break;
            case 2:
              playerCards = playerCards + "♥";
              break;
            case 3:
              playerCards = playerCards + "♠";
              break;
            default:
              throw new IllegalArgumentException("Invalid suit");
          }
          if (r == player.getAllCards().size() - 1) {
            playerCards = playerCards + "\n";
          } else {
            playerCards = playerCards + ", ";
          }
        }
        output = output + playerCards;
      }
    }
    return output;
  }
}


