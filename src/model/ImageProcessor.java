package model;

/**
 * Representing the operations and observations that preserve the original PixelImage.
 */
public interface ImageProcessor {


  /**
   * Loads the image at the given path and refers it by the given image name.
   *
   * @param imgPath the file path
   * @param imgName the name of the image.
   */
  void loadImage(String imgPath, String imgName);


  /**
   * Visualizes the given image as a red-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  void redComponent(String imgName, String destName);

  /**
   * Visualizes the image as a green-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  void greComponent(String imgName, String destName);

  /**
   * Visualizes the image as a blue-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  void bluComponent(String imgName, String destName);


  /**
   * Visualizes the given image in greyscale according to the specified type.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   * @param type     the type of greyscale - value, intensity or luma
   */
  void visGreyscale(String imgName, String destName, String type);


  /**
   * Visualizes the image as the mirror image in the given direction of the original.
   *
   * @param imgName   the image to flip.
   * @param destName  the new image to save
   * @param direction the direction to flip
   */
  void flipImage(String imgName, String destName, String direction);


  /**
   * Creates a new image as a brighter or darker version of the original image by a certain factor.
   *
   * @param imgName  the image to brighten
   * @param factor   the factor to brighten
   * @param destName the new image to save
   */
  void adjustBrightness(String imgName, int factor, String destName);


  /**
   * Represents a PixelImage as text and saves it to a PPM file.
   *
   * @param fileName the file to save up
   * @param imgName  the image to save
   */
  void saveToPPM(String fileName, String imgName);


  /**
   * Return a map of the images loaded so for with their names.
   *
   * @param imgName the img name
   * @return an img with the given name
   */
  PixelImage getLoadedImg(String imgName);

  /**
   * Creates a new image based on the filter applied to the given image.
   *
   * @param imgName  the img to filter
   * @param destName the filtered img
   * @param type     the type of filter - blur and sharpen
   */
  void filterImage(String imgName, String destName, String type);

  /**
   * Creates a new image based on the transformation applied to the given image.
   *
   * @param imgName  the img to transform
   * @param destName the transformed img
   * @param type     the type of transformation - greyscale and sepia
   */
  void colorTrans(String imgName, String destName, String type);


}
