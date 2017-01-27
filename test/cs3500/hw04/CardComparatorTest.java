package cs3500.hw04;

/**
 * Created by veronicashei on 6/2/16.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import cs3500.hw03.CardGameModel;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class CardComparatorTest {

  /**
   * Helper method that sorts the cards using the comparator
   *
   * @return a sorted list
   */
  private <S, T extends Comparator<S>> List<S> testComparatorHelper(List<S> list, T comparator) {
    List<S> temp = new ArrayList<S>();
    for (S item : list) {
      temp.add(item);
    }
    Collections.sort(temp, comparator);
    return temp;
  }

  /**
   * Tests to see if the sorting the cards using the comparator returned the right output
   */
  @Test
  public void testCompare() {
    CardGameModel model = new WhistTrumpModel();
    List<?> deck = testComparatorHelper(model.getDeck(), new CardComparator());
    model.startPlay(3, deck);

    assertEquals(model.getGameState(), "Number of players: 3\n" +
        "Player 1: A♠, J♠, 8♠, 5♠, 2♠, Q♥, 9♥, 6♥, 3♥, K♦, 10♦, 7♦, 4♦, A♣, J♣, 8♣, 5♣, 2♣\n" +
        "Player 2: K♠, 10♠, 7♠, 4♠, A♥, J♥, 8♥, 5♥, 2♥, Q♦, 9♦, 6♦, 3♦, K♣, 10♣, 7♣, 4♣\n" +
        "Player 3: Q♠, 9♠, 6♠, 3♠, K♥, 10♥, 7♥, 4♥, A♦, J♦, 8♦, 5♦, 2♦, Q♣, 9♣, 6♣, 3♣\n" +
        "Player 1 score: 0\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
  }
}