package cs3500.hw03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veronicashei on 5/23/16.
 */

/**
 * Represents the pile of cards that have been played in one round of Whist
 */
public class Pile {
  List<Trick> pile = new ArrayList<Trick>();

  public Pile(List<Trick> pile) {
    this.pile = pile;
  }

}