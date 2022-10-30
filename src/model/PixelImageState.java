package model;

/**
 * Representing the operations and observations that preserve the original PixelImage.
 */
public interface PixelImageState {
  /**
   * Returns the value of the pixel at the given row and column.
   *
   * @param row the row value of the pixel
   * @param col the column value of the pixel
   * @return the Pixel at the given row and column values
   */
  Pixel getPixelAt(int row, int col);

  /**
   * Represents a PixelImage as text and saves it to a PPM file.
   *
   * @param fileName the file to save up
   */
  void saveToPPM(String fileName);


}
