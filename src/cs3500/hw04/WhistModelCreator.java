package cs3500.hw04;

import cs3500.hw03.CardGameModel;
import cs3500.hw03.WhistModel;

/**
 * Created by veronicashei on 6/2/16.
 */

/**
 * A class that checks to see if the given input should use the WhistModel or WhistTrumpModel
 */
public class WhistModelCreator {
  public enum ModelType {
    TRUMP(1), NOTRUMP(0);
    private int value;

    ModelType(int value) {
      this.value = value;
    }

    /**
     * Getter method for the trump suit
     *
     * @return a boolean indicating whether or not this is the trump suit
     */
    public int getTrump() {
      return this.value;
    }
  }

  private final ModelType modelType;

  private WhistModelCreator(ModelType modelType) {
    this.modelType = modelType;
  }

  public static CardGameModel create(ModelType type) {
    if (type.getTrump() == 1) {
      return new WhistTrumpModel();
    } else if (type.getTrump() == 0) {
      return new WhistModel();
    } else {
      throw new IllegalArgumentException("Invalid input");
    }
  }
}