package cs3500.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cs3500.hw02.Card;
import cs3500.hw03.Trick;
import cs3500.hw03.WhistModel;

/**
 * Created by veronicashei on 6/2/16.
 */

/**
 * A class representing the Trump version of the Whist game
 */
public class WhistTrumpModel extends WhistModel {

  private int trumpSuit;

  public WhistTrumpModel() {
    super();
    trumpSuit = deck.get(0).getSuit();
  }

  /**
   * Takes into account the trump suit when playing
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
        List<Card> trumpPile = new ArrayList<>();
        List<Card> normalPile = new ArrayList<>();
        for (int r = 0; r < pile.size(); r++) {
          if (pile.get(r).getCard().getSuit() == trumpSuit) {
            trumpPile.add(pile.get(r).getCard());
          }
          if (trumpPile.size() == 0) {
            if (pile.get(r).getCard().getSuit() == pileSuit) {
              normalPile.add(pile.get(r).getCard());
            }
          }
        }
        if (trumpPile.size() != 0) {
          Collections.sort(trumpPile);
          for (int n = 0; n < trumpPile.size(); n++) {
            if (trumpPile.get(0) == pile.get(n).getCard()) {
              int winner = pile.get(n).getPlayerNo();
              players.get(winner).setScore();
              if (players.get(winner).getAllCards().size() == 0) {
                turn = 0;
              } else {
                turn = winner;
              }
            }
          }
        } else {
          Collections.sort(normalPile);
          for (int n = 0; n < normalPile.size(); n++) {
            if (normalPile.get(0) == pile.get(n).getCard()) {
              int winner = pile.get(n).getPlayerNo();
              players.get(winner).setScore();
              if (players.get(winner).getAllCards().size() == 0) {
                turn = 0;
              } else {
                turn = winner;
              }
            }
          }
        }
        pileSuit = -1;
        pile.clear();
      }
    }
  }

  /**
   * The new model’s getGameState method should return a String exactly as WhistModel did, with an
   * additional line at the end: "Trump suit: X" where X is replaced by the character of the trump
   * suit.
   *
   * @return a String representing the state of the WhistTrump game
   */
  @Override
  public String getGameState() {
    String output = super.getGameState();
    String trumpCard;
    switch (trumpSuit) {
      case 0:
        trumpCard = "♣";
        break;
      case 1:
        trumpCard = "♦";
        break;
      case 2:
        trumpCard = "♥";
        break;
      case 3:
        trumpCard = "♠";
        break;
      default:
        throw new IllegalArgumentException("Invalid trump suit");
    }
    output = output + "\nTrump suit: " + trumpCard;
    return output;
  }

  /**
   * Equals method for the WhistTrumpModel to compare to see if two different models are the same
   *
   * @param o the given object to be compared with, if not of the type WhistTrumpModel an exception
   *          is thrown
   * @return a boolean indicating whether or not the object is equivalent to this model
   */
  @Override
  public boolean equals(Object o) {
    boolean flag = true;
    WhistTrumpModel trumpModel;
    if (o instanceof WhistTrumpModel) {
      trumpModel = (WhistTrumpModel) o;
    } else {
      throw new ClassCastException();
    }
    for (int i = 0; i < deck.size(); i++) {
      flag = flag && this.deck.get(i).equals(trumpModel.deck.get(i));
    }
    flag = flag && players.size() == trumpModel.players.size();
    flag = flag && this.turn == trumpModel.turn;
    flag = flag && this.pileSuit == trumpModel.pileSuit;
    flag = flag && this.trumpSuit == trumpModel.trumpSuit;
    return flag;
  }

  /**
   * A hashcode method specific for this model
   *
   * @return an int indicating the hashcode for this model
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.deck, players.size());
  }

}
