package controller.cmds;

import java.util.Scanner;

import model.ImageProcessor;

public class RedCompCmd extends AbstractCmd {

  public RedCompCmd(Scanner input) {
    super(input);
  }
  @Override
  protected void specificCommand(String imgName, String destName, ImageProcessor imgPro) {
    imgPro.redComponent(imgName, destName);
  }
}
