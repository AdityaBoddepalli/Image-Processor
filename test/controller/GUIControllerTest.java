package controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests whether the controller configures the view properly.
 */
public class GUIControllerTest {

  @Test
  public void startProcessing() {
    Appendable log = new StringBuilder();
    ImageProcessorController controller = new GUIController(new ConfirmInputsModel(log),
            new ConfirmInputsGUIView(log));
    controller.startProcessing();
    assertEquals("added listeners\n", log.toString());
  }
}