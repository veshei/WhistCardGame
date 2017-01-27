package cs3500.hw04;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw03.CardGameModel;

import static org.junit.Assert.assertEquals;

/**
 * Created by veronicashei on 6/3/16.
 */
public class WhistTrumpModelTest {

  /**
   * Tests the method play in WhistTrumpModel, plays the whole game to see if the correct output is
   * shown
   */
  @Test
  public void testTrumpPlay() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(4, trumpDeck);
    trumpGame.play(0, 0);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: 10♠, 6♠, 2♠, J♥, 7♥, 3♥, Q♦, 8♦, 4♦, K♣, 9♣, 5♣\n" +
        "Player 2: 9♠, 5♠, A♥, 10♥, 6♥, 2♥, J♦, 7♦, 3♦, Q♣, 8♣, 4♣\n" +
        "Player 3: 8♠, 4♠, K♥, 9♥, 5♥, A♦, 10♦, 6♦, 2♦, J♣, 7♣, 3♣\n" +
        "Player 4: 7♠, 3♠, Q♥, 8♥, 4♥, K♦, 9♦, 5♦, A♣, 10♣, 6♣, 2♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 0);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: 6♠, 2♠, J♥, 7♥, 3♥, Q♦, 8♦, 4♦, K♣, 9♣, 5♣\n" +
        "Player 2: 5♠, A♥, 10♥, 6♥, 2♥, J♦, 7♦, 3♦, Q♣, 8♣, 4♣\n" +
        "Player 3: 4♠, K♥, 9♥, 5♥, A♦, 10♦, 6♦, 2♦, J♣, 7♣, 3♣\n" +
        "Player 4: 3♠, Q♥, 8♥, 4♥, K♦, 9♦, 5♦, A♣, 10♣, 6♣, 2♣\n" +
        "Player 1 score: 2\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 0);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: 2♠, J♥, 7♥, 3♥, Q♦, 8♦, 4♦, K♣, 9♣, 5♣\n" +
        "Player 2: A♥, 10♥, 6♥, 2♥, J♦, 7♦, 3♦, Q♣, 8♣, 4♣\n" +
        "Player 3: K♥, 9♥, 5♥, A♦, 10♦, 6♦, 2♦, J♣, 7♣, 3♣\n" +
        "Player 4: Q♥, 8♥, 4♥, K♦, 9♦, 5♦, A♣, 10♣, 6♣, 2♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 0);
    trumpGame.play(1, 9);
    trumpGame.play(2, 9);
    trumpGame.play(3, 9);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, 7♥, 3♥, Q♦, 8♦, 4♦, K♣, 9♣, 5♣\n" +
        "Player 2: A♥, 10♥, 6♥, 2♥, J♦, 7♦, 3♦, Q♣, 8♣\n" +
        "Player 3: K♥, 9♥, 5♥, A♦, 10♦, 6♦, 2♦, J♣, 7♣\n" +
        "Player 4: Q♥, 8♥, 4♥, K♦, 9♦, 5♦, A♣, 10♣, 6♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 1\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣");
    trumpGame.play(1, 0);
    trumpGame.play(2, 2);
    trumpGame.play(3, 2);
    trumpGame.play(0, 2);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, 7♥, Q♦, 8♦, 4♦, K♣, 9♣, 5♣\n" +
        "Player 2: 10♥, 6♥, 2♥, J♦, 7♦, 3♦, Q♣, 8♣\n" +
        "Player 3: K♥, 9♥, A♦, 10♦, 6♦, 2♦, J♣, 7♣\n" +
        "Player 4: Q♥, 8♥, K♦, 9♦, 5♦, A♣, 10♣, 6♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣");
    trumpGame.play(1, 1);
    trumpGame.play(2, 0);
    trumpGame.play(3, 1);
    trumpGame.play(0, 1);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, Q♦, 8♦, 4♦, K♣, 9♣, 5♣\n" +
        "Player 2: 10♥, 2♥, J♦, 7♦, 3♦, Q♣, 8♣\n" +
        "Player 3: 9♥, A♦, 10♦, 6♦, 2♦, J♣, 7♣\n" +
        "Player 4: Q♥, K♦, 9♦, 5♦, A♣, 10♣, 6♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 1\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 3\n" +
        "Trump suit: ♣");
    trumpGame.play(2, 1);
    trumpGame.play(3, 3);
    trumpGame.play(0, 3);
    trumpGame.play(1, 4);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, Q♦, 8♦, K♣, 9♣, 5♣\n" +
        "Player 2: 10♥, 2♥, J♦, 7♦, Q♣, 8♣\n" +
        "Player 3: 9♥, 10♦, 6♦, 2♦, J♣, 7♣\n" +
        "Player 4: Q♥, K♦, 9♦, A♣, 10♣, 6♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 0\n" +
        "Turn: Player 3\n" +
        "Trump suit: ♣");
    trumpGame.play(2, 3);
    trumpGame.play(3, 1);
    trumpGame.play(0, 2);
    trumpGame.play(1, 3);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, Q♦, K♣, 9♣, 5♣\n" +
        "Player 2: 10♥, 2♥, J♦, Q♣, 8♣\n" +
        "Player 3: 9♥, 10♦, 6♦, J♣, 7♣\n" +
        "Player 4: Q♥, 9♦, A♣, 10♣, 6♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 1\n" +
        "Turn: Player 4\n" +
        "Trump suit: ♣");
    trumpGame.play(3, 2);
    trumpGame.play(0, 4);
    trumpGame.play(1, 4);
    trumpGame.play(2, 4);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, Q♦, K♣, 9♣\n" +
        "Player 2: 10♥, 2♥, J♦, Q♣\n" +
        "Player 3: 9♥, 10♦, 6♦, J♣\n" +
        "Player 4: Q♥, 9♦, 10♣, 6♣\n" +
        "Player 1 score: 3\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 2\n" +
        "Turn: Player 4\n" +
        "Trump suit: ♣");
    trumpGame.play(3, 1);
    trumpGame.play(0, 1);
    trumpGame.play(1, 2);
    trumpGame.play(2, 2);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, K♣, 9♣\n" +
        "Player 2: 10♥, 2♥, Q♣\n" +
        "Player 3: 9♥, 10♦, J♣\n" +
        "Player 4: Q♥, 10♣, 6♣\n" +
        "Player 1 score: 4\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 2\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 1);
    trumpGame.play(1, 2);
    trumpGame.play(2, 2);
    trumpGame.play(3, 2);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: J♥, 9♣\n" +
        "Player 2: 10♥, 2♥\n" +
        "Player 3: 9♥, 10♦\n" +
        "Player 4: Q♥, 10♣\n" +
        "Player 1 score: 5\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 2\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 0);
    trumpGame.play(1, 1);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: 9♣\n" +
        "Player 2: 10♥\n" +
        "Player 3: 10♦\n" +
        "Player 4: 10♣\n" +
        "Player 1 score: 5\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 3\n" +
        "Turn: Player 4\n" +
        "Trump suit: ♣");
    trumpGame.play(3, 0);
    trumpGame.play(0, 0);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 4\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 1 score: 5\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 4\n" +
        "Game over. Player 1 won.\n" +
        "Trump suit: ♣");
  }

  /**
   * Checks to see if the play method works with odd number of cards distributed among the players
   */
  @Test
  public void testOddNumberOfPlayers() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(6, trumpDeck);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: A♠, 8♠, 2♠, 9♥, 3♥, 10♦, 4♦, J♣, 5♣\n" +
        "Player 2: K♠, 7♠, A♥, 8♥, 2♥, 9♦, 3♦, 10♣, 4♣\n" +
        "Player 3: Q♠, 6♠, K♥, 7♥, A♦, 8♦, 2♦, 9♣, 3♣\n" +
        "Player 4: J♠, 5♠, Q♥, 6♥, K♦, 7♦, A♣, 8♣, 2♣\n" +
        "Player 5: 10♠, 4♠, J♥, 5♥, Q♦, 6♦, K♣, 7♣\n" +
        "Player 6: 9♠, 3♠, 10♥, 4♥, J♦, 5♦, Q♣, 6♣\n" +
        "Player 1 score: 0\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 0);
    trumpGame.play(1, 1);
    trumpGame.play(2, 1);
    trumpGame.play(3, 1);
    trumpGame.play(4, 1);
    trumpGame.play(5, 1);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, 2♠, 9♥, 3♥, 10♦, 4♦, J♣, 5♣\n" +
        "Player 2: K♠, A♥, 8♥, 2♥, 9♦, 3♦, 10♣, 4♣\n" +
        "Player 3: Q♠, K♥, 7♥, A♦, 8♦, 2♦, 9♣, 3♣\n" +
        "Player 4: J♠, Q♥, 6♥, K♦, 7♦, A♣, 8♣, 2♣\n" +
        "Player 5: 10♠, J♥, 5♥, Q♦, 6♦, K♣, 7♣\n" +
        "Player 6: 9♠, 10♥, 4♥, J♦, 5♦, Q♣, 6♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 1);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    trumpGame.play(4, 0);
    trumpGame.play(5, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, 9♥, 3♥, 10♦, 4♦, J♣, 5♣\n" +
        "Player 2: A♥, 8♥, 2♥, 9♦, 3♦, 10♣, 4♣\n" +
        "Player 3: K♥, 7♥, A♦, 8♦, 2♦, 9♣, 3♣\n" +
        "Player 4: Q♥, 6♥, K♦, 7♦, A♣, 8♣, 2♣\n" +
        "Player 5: J♥, 5♥, Q♦, 6♦, K♣, 7♣\n" +
        "Player 6: 10♥, 4♥, J♦, 5♦, Q♣, 6♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 1\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣");
    trumpGame.play(1, 0);
    trumpGame.play(2, 1);
    trumpGame.play(3, 1);
    trumpGame.play(4, 1);
    trumpGame.play(5, 1);
    trumpGame.play(0, 2);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, 9♥, 10♦, 4♦, J♣, 5♣\n" +
        "Player 2: 8♥, 2♥, 9♦, 3♦, 10♣, 4♣\n" +
        "Player 3: K♥, A♦, 8♦, 2♦, 9♣, 3♣\n" +
        "Player 4: Q♥, K♦, 7♦, A♣, 8♣, 2♣\n" +
        "Player 5: J♥, Q♦, 6♦, K♣, 7♣\n" +
        "Player 6: 10♥, J♦, 5♦, Q♣, 6♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 2\n" +
        "Trump suit: ♣");
    trumpGame.play(1, 1);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    trumpGame.play(4, 0);
    trumpGame.play(5, 0);
    trumpGame.play(0, 1);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, 10♦, 4♦, J♣, 5♣\n" +
        "Player 2: 8♥, 9♦, 3♦, 10♣, 4♣\n" +
        "Player 3: A♦, 8♦, 2♦, 9♣, 3♣\n" +
        "Player 4: K♦, 7♦, A♣, 8♣, 2♣\n" +
        "Player 5: Q♦, 6♦, K♣, 7♣\n" +
        "Player 6: J♦, 5♦, Q♣, 6♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 1\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 3\n" +
        "Trump suit: ♣");
    trumpGame.play(2, 0);
    trumpGame.play(3, 1);
    trumpGame.play(4, 1);
    trumpGame.play(5, 1);
    trumpGame.play(0, 2);
    trumpGame.play(1, 2);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, 10♦, J♣, 5♣\n" +
        "Player 2: 8♥, 9♦, 10♣, 4♣\n" +
        "Player 3: 8♦, 2♦, 9♣, 3♣\n" +
        "Player 4: K♦, A♣, 8♣, 2♣\n" +
        "Player 5: Q♦, K♣, 7♣\n" +
        "Player 6: J♦, Q♣, 6♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 3\n" +
        "Trump suit: ♣");
    trumpGame.play(2, 1);
    trumpGame.play(3, 0);
    trumpGame.play(4, 0);
    trumpGame.play(5, 0);
    trumpGame.play(0, 1);
    trumpGame.play(1, 1);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, J♣, 5♣\n" +
        "Player 2: 8♥, 10♣, 4♣\n" +
        "Player 3: 8♦, 9♣, 3♣\n" +
        "Player 4: A♣, 8♣, 2♣\n" +
        "Player 5: K♣, 7♣\n" +
        "Player 6: Q♣, 6♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 1\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 4\n" +
        "Trump suit: ♣");
    trumpGame.play(3, 0);
    trumpGame.play(4, 1);
    trumpGame.play(5, 1);
    trumpGame.play(0, 2);
    trumpGame.play(1, 2);
    trumpGame.play(2, 2);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠, J♣\n" +
        "Player 2: 8♥, 10♣\n" +
        "Player 3: 8♦, 9♣\n" +
        "Player 4: 8♣, 2♣\n" +
        "Player 5: K♣\n" +
        "Player 6: Q♣\n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 2\n" +
        "Player 5 score: 0\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 4\n" +
        "Trump suit: ♣");
    trumpGame.play(3, 1);
    trumpGame.play(4, 0);
    trumpGame.play(5, 0);
    trumpGame.play(0, 1);
    trumpGame.play(1, 1);
    trumpGame.play(2, 1);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: 8♠\n" +
        "Player 2: 8♥\n" +
        "Player 3: 8♦\n" +
        "Player 4: 8♣\n" +
        "Player 5: \n" +
        "Player 6: \n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 2\n" +
        "Player 5 score: 1\n" +
        "Player 6 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");
    trumpGame.play(0, 0);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    assertEquals(trumpGame.getGameState(), "Number of players: 6\n" +
        "Player 1: \n" +
        "Player 2: \n" +
        "Player 3: \n" +
        "Player 4: \n" +
        "Player 5: \n" +
        "Player 6: \n" +
        "Player 1 score: 1\n" +
        "Player 2 score: 2\n" +
        "Player 3 score: 2\n" +
        "Player 4 score: 2\n" +
        "Player 5 score: 1\n" +
        "Player 6 score: 0\n" +
        "Game over. Player 2 and Player 3 and Player 4 won.\n" +
        "Trump suit: ♣");
  }

  /**
   * Tests to see if an exception is thrown when a player plays out of turn
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTrumpTurn() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(9, trumpDeck);
    trumpGame.play(0, 0);
    trumpGame.play(3, 0);
    assertEquals(trumpGame.getGameState(), "Player out of turn");
  }

  /**
   * Tests to see if an exception is thrown when play is called before the game has started
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testTrumpGameNotStarted() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);
    trumpGame.play(0, 0);

    assertEquals(trumpGame.getGameState(), "Game has not been started yet");
  }

  /**
   * Tests to see if an exception is thrown when an invalid card index is given, i.e. a card index
   * larger than the indices in the player's hands
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTrumpInvalidCardIndex() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(7, trumpDeck);
    trumpGame.play(0, 19);

    assertEquals(trumpGame.getGameState(), "Invalid card index");
  }

  /**
   * Tests to see if an exception is thrown when a card of the wrong suit is given when the player
   * has the right suit in their hand
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTrumpInvalidSuit() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(8, trumpDeck);
    trumpGame.play(0, 0);
    trumpGame.play(1, 5);
    assertEquals(trumpGame.getGameState(), "Invalid suit given");
  }

  /**
   * Tests to see if an exception is thrown when play is called after the game has ended
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayWhenGameEnded() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(4, trumpDeck);
    trumpGame.play(0, 0);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    trumpGame.play(0, 2);
    trumpGame.play(1, 0);
    trumpGame.play(2, 1);
    trumpGame.play(3, 1);
    trumpGame.play(1, 1);
    trumpGame.play(2, 3);
    trumpGame.play(3, 3);
    trumpGame.play(0, 4);
    trumpGame.play(1, 3);
    trumpGame.play(2, 1);
    trumpGame.play(3, 2);
    trumpGame.play(0, 3);
    trumpGame.play(2, 2);
    trumpGame.play(3, 4);
    trumpGame.play(0, 5);
    trumpGame.play(1, 5);
    trumpGame.play(2, 7);
    trumpGame.play(3, 4);
    trumpGame.play(0, 7);
    trumpGame.play(1, 7);
    trumpGame.play(3, 6);
    trumpGame.play(0, 5);
    trumpGame.play(1, 6);
    trumpGame.play(2, 6);
    trumpGame.play(0, 1);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    trumpGame.play(2, 3);
    trumpGame.play(3, 2);
    trumpGame.play(0, 3);
    trumpGame.play(1, 3);
    trumpGame.play(3, 0);
    trumpGame.play(0, 1);
    trumpGame.play(1, 1);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    trumpGame.play(0, 1);
    trumpGame.play(1, 1);
    trumpGame.play(2, 1);
    trumpGame.play(3, 0);
    trumpGame.play(0, 1);
    trumpGame.play(1, 1);
    trumpGame.play(2, 1);
    trumpGame.play(1, 0);
    trumpGame.play(2, 0);
    trumpGame.play(3, 0);
    trumpGame.play(0, 0);
    trumpGame.play(1, 1);
    assertEquals(trumpGame.getGameState(), "Game is over");
  }

  /**
   * Tests to see if the getGameState() method in WhistTrumpModel outputs the right String
   */
  @Test
  public void testTrumpGameState() {
    CardGameModel trumpGame = new WhistTrumpModel();
    List<Card> trumpDeck = trumpGame.getDeck();
    Collections.sort(trumpDeck);

    trumpGame.startPlay(5, trumpDeck);
    assertEquals(trumpGame.getGameState(), "Number of players: 5\n" +
        "Player 1: A♠, 9♠, 4♠, Q♥, 7♥, 2♥, 10♦, 5♦, K♣, 8♣, 3♣\n" +
        "Player 2: K♠, 8♠, 3♠, J♥, 6♥, A♦, 9♦, 4♦, Q♣, 7♣, 2♣\n" +
        "Player 3: Q♠, 7♠, 2♠, 10♥, 5♥, K♦, 8♦, 3♦, J♣, 6♣\n" +
        "Player 4: J♠, 6♠, A♥, 9♥, 4♥, Q♦, 7♦, 2♦, 10♣, 5♣\n" +
        "Player 5: 10♠, 5♠, K♥, 8♥, 3♥, J♦, 6♦, A♣, 9♣, 4♣\n" +
        "Player 1 score: 0\n" +
        "Player 2 score: 0\n" +
        "Player 3 score: 0\n" +
        "Player 4 score: 0\n" +
        "Player 5 score: 0\n" +
        "Turn: Player 1\n" +
        "Trump suit: ♣");

  }
}