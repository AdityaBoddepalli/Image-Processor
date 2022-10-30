package model;

public interface PixelImage extends PixelImageState {

  /**
   * Visualizes the image as a red-scaled image.
   */
  void redComponent();

  /**
   * Visualizes the image as a green-scaled image.
   */
  void greComponent();

  /**
   * Visualizes the image as a blue-scaled image.
   */
  void bluComponent();

  /**
   * Visualizes the image as a grey-scaled image by taking the average of
   * the three rgb values and set the value to all three.
   */
  void visGreyscale();

  /**
   * Visualizes the image as the mirror image in the horizontal direction of the original,
   * flipping based off which direction is inputted.
   */
  void flipImageHoriz(String direction);

  /**
   * Visualizes the image as the mirror image in the vertical direction of the original,
   * flipping based off which direction is inputted.
   */
  void flipImageVert(String direction);

  /**
   * Visualizes the image as a brighter version of the original image by a certain factor.
   */
  void imageBrighten(int factor);

  /**
   * Visualizes the image as a darker version of the original image by a certain factor.
   */
  void imageDarken(int factor);
}
