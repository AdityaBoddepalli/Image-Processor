package controller;

import java.io.IOException;

import model.ImageProcessor;
import model.PixelImage;


/**
 * Mock model to confirm whether the controller communicates properly with the model.
 */
public class ConfirmInputsModel implements ImageProcessor {

  Appendable log;


  /**
   * Constructs a confirm inputs model.
   *
   * @param log log
   */
  public ConfirmInputsModel(Appendable log) {
    this.log = log;
  }

  /**
   * Loads the image at the given path and refers it by the given image name.
   *
   * @param imgPath the file path
   * @param imgName the name of the image.
   */
  @Override
  public void loadImage(String imgPath, String imgName) {
    try {
      log.append(String.format("Command: load %s %s\n", imgPath, imgName));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Visualizes the given image as a red-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void redComponent(String imgName, String destName) {
    try {
      log.append(String.format("Command: red-component %s %s\n", imgName, destName));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Visualizes the image as a green-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void greComponent(String imgName, String destName) {
    try {
      log.append(String.format("Command: green-component %s %s\n", imgName, destName));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Visualizes the image as a blue-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void bluComponent(String imgName, String destName) {
    try {
      log.append(String.format("Command: blue-component %s %s\n", imgName, destName));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Visualizes the given image in greyscale according to the specified type.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   * @param type     the type of greyscale - value, intensity or luma
   */
  @Override
  public void visGreyscale(String imgName, String destName, String type) {
    try {
      log.append(String.format("Command: greyscale %s %s %s\n", imgName, destName, type));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Visualizes the image as the mirror image in the given direction of the original.
   *
   * @param imgName   the image to flip.
   * @param destName  the new image to save
   * @param direction the direction to flip
   */
  @Override
  public void flipImage(String imgName, String destName, String direction) {
    try {
      if (direction.equals("vertical")) {
        log.append(String.format("Command: flip-vertical %s %s\n", imgName, destName));
      } else {
        log.append(String.format("Command: flip-horizontal %s %s\n", imgName, destName));
      }
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Creates a new image as a brighter or darker version of the original image by a certain factor.
   *
   * @param imgName  the image to brighten
   * @param factor   the factor to brighten
   * @param destName the new image to save
   */
  @Override
  public void adjustBrightness(String imgName, int factor, String destName) {
    try {
      if (factor < 0) {
        log.append(String.format("Command: darken %s %s %d\n", imgName, destName, -factor));
      } else {
        log.append(String.format("Command: brighten %s %s %d\n", imgName, destName, factor));
      }
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Represents a PixelImage as text and saves it to a PPM file.
   *
   * @param fileName the file to save up
   * @param imgName  the image to save
   */
  @Override
  public void saveImage(String fileName, String imgName) {
    try {
      log.append(String.format("Command: save %s %s\n", fileName, imgName));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Return a map of the images loaded so for with their names.
   *
   * @param imgName the img name
   * @return a img with the given name
   */
  @Override
  public PixelImage getLoadedImg(String imgName) {
    return null;
  }

  /**
   * Creates a new image based on the filter applied to the given image.
   *
   * @param imgName  the img to filter
   * @param destName the filtered img
   * @param type     the type of filter - blur and sharpen
   */
  @Override
  public void filterImage(String imgName, String destName, String type) {
    try {
      log.append(String.format("Command: filter %s %s %s\n", imgName, destName, type));
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
