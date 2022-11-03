package controller.cmds;
import java.util.Scanner;
import model.ImageProcessor;

public class LoadCmd extends AbstractCmd {
  public LoadCmd(Scanner input) {
    super(input);
  }
  @Override
  protected void specificCommand(String imgName, String destName, ImageProcessor imgPro) {
    imgPro.loadImage(imgName, destName);
  }
}