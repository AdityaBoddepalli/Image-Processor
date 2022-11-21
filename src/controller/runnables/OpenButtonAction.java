package controller.runnables;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ImageProcessor;
import view.GUIView;

public class OpenButtonAction extends AbstractButtonAction{
  public OpenButtonAction(ImageProcessor model, GUIView view) {
    super(model, view);
  }



  /**
   * The signature features of every button that are different.
   *
   * @return the image to be displayed after the process.
   */
  @Override
  protected String specificAction() throws IOException {
    String imgName = view.getUserStringInput("Enter the name of the image: ");
    if(imgName == null) {
      return null;
    }
    try {
      this.model.ensureKey(imgName);
    } catch (IllegalArgumentException e) {
      this.view.transmitMessage(e.getMessage());
      return null;
    }
    return imgName;
  }
}
