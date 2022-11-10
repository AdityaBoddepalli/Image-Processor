import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;

import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import model.BasicImageProcessor;
import model.ImageProcessor;
import view.PixelImageView;
import view.TerminalView;

/**
 * The runner class that houses main.
 */
public class ImageProcessorRunner {

  public static Readable getReadable(String[] args) {
    Readable input;
    if (args.length == 1) {
      try {
        input = new InputStreamReader(new FileInputStream(args[0]));
      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("Couldn't open script");
      }
    } else {
      input = new InputStreamReader(System.in);
    }
    return input;
  }

  /**
   * Main method to run the img processor.
   *
   * @param args enter filepath as first argument if a script needs to be executed.
   */
  public static void main(String[] args) {
    ImageProcessor model = new BasicImageProcessor(new HashMap<>());
    PixelImageView view = new TerminalView();
    ImageProcessorController controller = new ImageProcessorControllerImpl(model,
            view, getReadable(args));
    controller.startProcessing();
  }
}
