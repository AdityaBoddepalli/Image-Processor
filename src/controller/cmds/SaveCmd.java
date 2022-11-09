package controller.cmds;

import java.io.IOException;
import java.util.Scanner;

import model.ImageProcessor;

/**
 * The command that saves an image.
 */
public class SaveCmd extends AbstractCmd {
  /**
   * Constructs a savecmd.
   * @param input the input into the command.
   */
  public SaveCmd(Scanner input) {
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
    try {
      imgPro.saveImage(imgName, destName);
    } catch (IOException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }
}
