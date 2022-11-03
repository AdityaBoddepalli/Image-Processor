package controller.cmds;

import java.util.Scanner;

import model.ImageProcessor;

public abstract class AbstractCmd implements ImageProcessorCmds {

  private final Scanner input;

  public AbstractCmd(Scanner input) {
    if(input == null) {
      throw new IllegalArgumentException("Cant execute with a null scanner");
    }
    this.input = input;
  }


  /**
   * Execute this command.
   *
   * @param imgPro the processor on which to execute.
   */
  @Override
  public void execute(ImageProcessor imgPro) {
    String imgName = this.getNextInput();
    String destName = this.getNextInput();
    this.specificCommand(imgName, destName, imgPro);
  }

  /**
   * What to do with the image name and dest name.
   * @param imgName the name of the image in the processor
   * @param destName the name of the new image after the process
   * @param imgPro the model to do the process on
   */
  protected abstract void specificCommand(String imgName, String destName, ImageProcessor imgPro);

  protected String getNextInput() {
    if (input.hasNext()) {
      return input.next();
    } else {
      throw new IllegalArgumentException("Input ran out: not enough input to execute command");
    }
  }
}
