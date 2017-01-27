package cs3500.hw04;

import org.junit.Test;

import cs3500.hw03.WhistModel;

import static org.junit.Assert.assertTrue;

/**
 * Created by veronicashei on 6/3/16.
 */
public class WhistModelCreatorTest {

  /**
   * Tests to see if the model returns the WhistTrumpModel when a TRUMP input is given
   */
  @Test
  public void testCreateTrump() {
    assertTrue(WhistModelCreator.create(WhistModelCreator.ModelType.TRUMP).
        equals(new WhistTrumpModel()));
  }

  /**
   * Tests to see if the model returns the WhistModel when a NOTRUMP input is given
   */
  @Test
  public void testCreateWhistModel() {
    assertTrue(WhistModelCreator.create(WhistModelCreator.ModelType.NOTRUMP).
        equals(new WhistModel()));
  }

}