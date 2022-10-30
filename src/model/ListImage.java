package model;

import java.util.List;

public class ListImage implements PixelImage {

  List<List<Pixel>> imageGrid;

  /**
   * Visualizes the image as a red-scaled image.
   */
  @Override
  public void redComponent() {

  }

  /**
   * Visualizes the image as a green-scaled image.
   */
  @Override
  public void greComponent() {

  }

  /**
   * Visualizes the image as a blue-scaled image.
   */
  @Override
  public void bluComponent() {

  }

  /**
   * Visualizes the image as a grey-scaled image by taking the average of
   * the three rgb values and set the value to all three.
   */
  @Override
  public void visGreyscale() {

  }

  /**
   * Visualizes the image as the mirror image in the horizontal direction of the original,
   * flipping based off which direction is inputted.
   *
   * @param direction
   */
  @Override
  public void flipImageHoriz(String direction) {

  }

  /**
   * Visualizes the image as the mirror image in the vertical direction of the original,
   * flipping based off which direction is inputted.
   *
   * @param direction
   */
  @Override
  public void flipImageVert(String direction) {

  }

  /**
   * Visualizes the image as a brighter version of the original image by a certain factor.
   *
   * @param factor
   */
  @Override
  public void imageBrighten(int factor) {

  }

  /**
   * Visualizes the image as a darker version of the original image by a certain factor.
   *
   * @param factor
   */
  @Override
  public void imageDarken(int factor) {

  }

  /**
   * Returns the value of the pixel at the given row and column.
   *
   * @param row the row value of the pixel
   * @param col the column value of the pixel
   * @return the Pixel at the given row and column values
   */
  @Override
  public Pixel getPixelAt(int row, int col) {
    return null;
  }

  /**
   * Represents a PixelImage as text and saves it to a PPM file.
   *
   * @param fileName the file to save up
   */
  @Override
  public void saveToPPM(String fileName) {

  }
}
