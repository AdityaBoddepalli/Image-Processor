import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;

import controller.GUIController;
import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import model.BasicImageProcessor;
import model.ImageProcessor;
import view.GUIView;
import view.PixelImageView;
import view.SwingImageProcessorView;
import view.TerminalView;

/**
 * The runner class that houses main.
 */
public class ImageProcessorRunner {


  /**
   * Checks if there is a script in the first cmd line argument and parses it into a readable.
   * defaults to System.in.
   *
   * @param args the command line args.
   * @return A readable with the input.
   */
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
    if (args.length == 2) {
      ImageProcessor model = new BasicImageProcessor(new HashMap<>());
      GUIView view = new SwingImageProcessorView("gimpLite");
      GUIController controller = new GUIController(model, view);
    } else {
      ImageProcessor model = new BasicImageProcessor(new HashMap<>());
      PixelImageView view = new TerminalView();
      ImageProcessorController controller = new ImageProcessorControllerImpl(model,
              view, getReadable(args));
      controller.startProcessing();
    }
  }
}
