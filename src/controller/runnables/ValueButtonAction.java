package controller.runnables;

import java.io.IOException;

import model.ImageProcessor;
import view.GUIView;

/**
 * The button for putting an image in greyscale in accordance to the value.
 */
public class ValueButtonAction extends AbstractButtonAction {

  /**
   * The constructor for the button.
   * @param model the model
   * @param view the view
   */
  public ValueButtonAction(ImageProcessor model, GUIView view) {
    super(model, view);
  }


  /**
   * The signature features of every button that are different.
   *
   * @return the image to be displayed after the process.
   */
  @Override
  protected String specificAction() throws IOException {
    if (!this.view.checkIfLoaded()) {
      this.view.transmitMessage("Load an image to process before selecting the command");
      return null;
    }
    String destName = view.getUserStringInput("Name the modified version of the image:");
    if (destName == null) {
      return null;
    }
    this.model.visGreyscale(this.view.currImageName(), destName, "value");
    return destName;
  }
}
