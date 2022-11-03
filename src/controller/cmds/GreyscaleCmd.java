package controller.cmds;

import java.util.Scanner;

import model.ImageProcessor;

public class GreyscaleCmd extends AbstractCmd {
  public GreyscaleCmd(Scanner input) {
    super(input);
  }

  /**
   * What to do with the image name and dest name.
   *
   * @param imgName  the name of the image in the processor
   * @param destName the name of the new image after the process
   * @param imgPro   the model to do the process on
   */
  @Override
  protected void specificCommand(String imgName, String destName, ImageProcessor imgPro) {
    String type = this.getNextInput();
    imgPro.visGreyscale(imgName, destName, type);
  }
}
