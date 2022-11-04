package controller;

import model.ImageProcessor;
import model.PixelImage;


/**
 * A mock model that always throws an IllegalArgException.
 */
public class InvalidCommandModel implements ImageProcessor {
  /**
   * Loads the image at the given path and refers it by the given image name.
   *
   * @param imgPath the file path
   * @param imgName the name of the image.
   */
  @Override
  public void loadImage(String imgPath, String imgName) {
    throw new IllegalArgumentException("get flounced");
  }

  /**
   * Visualizes the given image as a red-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void redComponent(String imgName, String destName) {
    throw new IllegalArgumentException("get flounced");

  }

  /**
   * Visualizes the image as a green-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void greComponent(String imgName, String destName) {
    throw new IllegalArgumentException("get flounced");

  }

  /**
   * Visualizes the image as a blue-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void bluComponent(String imgName, String destName) {
    throw new IllegalArgumentException("get flounced");

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
    throw new IllegalArgumentException("get flounced");

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
    throw new IllegalArgumentException("get flounced");

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
    throw new IllegalArgumentException("get flounced");

  }

  /**
   * Represents a PixelImage as text and saves it to a PPM file.
   *
   * @param fileName the file to save up
   * @param imgName  the image to save
   */
  @Override
  public void saveToPPM(String fileName, String imgName) {
    throw new IllegalArgumentException("get flounced");

  }

  /**
   * Return a map of the images loaded so for with their names.
   *
   * @param imgName the img name
   * @return a img with the given name
   */
  @Override
  public PixelImage getLoadedImg(String imgName) {
    throw new IllegalArgumentException("get flounced");

  }
}
