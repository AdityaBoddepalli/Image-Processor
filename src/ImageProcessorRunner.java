import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;

import controller.TerminalController;
import controller.TerminalControllerImpl;
import model.BasicImageProcessor;
import model.ImageProcessor;
import view.PixelImageView;
import view.TerminalView;

public class ImageProcessorRunner {
  public static void main(String[] args) {
    Readable input;
    if(args.length == 1) {
      try {
        input = new InputStreamReader(new FileInputStream(args[0]));
      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("Couldn't open script");
      }
    } else {
      input = new InputStreamReader(System.in);
    }
    ImageProcessor model = new BasicImageProcessor(new HashMap<>());
    PixelImageView view = new TerminalView();
    TerminalController controller = new TerminalControllerImpl(model, view, input);
    controller.startProcessing();
  }
}
