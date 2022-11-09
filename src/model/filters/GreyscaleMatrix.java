package model.filters;

import model.Pixel;
import model.PixelImage;
import model.StdPixel;


/**
 * A greyscale transformation matrix
 */
public class GreyscaleMatrix implements MyMatrix {

  private final double[][] matrixArray;

  public GreyscaleMatrix() {
    matrixArray = new double[3][3];
    for(int ii = 0; ii < 3; ii++) {
      for(int jj = 0; jj < 3; jj++) {
        if (jj == 0) {
          matrixArray[ii][jj] = 0.2126;
        } else if(jj == 1) {
          matrixArray[ii][jj] = 0.7152;
        } else {
          matrixArray[ii][jj] = 0.0722;
        }
      }
    }
  }


  /**
   * Returns the pixel after being altered by this matrix.
   *
   * @param img the og img
   * @param row the row of the pixel
   * @param col the col of the pixel
   * @return the new pixel
   */
  @Override
  public Pixel matrixify(PixelImage img, int row, int col) {
    Pixel currPxl = img.getPixelAt(row, col);
    int newRed = (int) Math.round(matrixArray[0][0] * currPxl.getRed() +
            matrixArray[0][1] * currPxl.getGreen() +
            matrixArray[0][2] * currPxl.getBlue());
    int newGreen = (int) Math.round(matrixArray[1][0] * currPxl.getRed() +
            matrixArray[1][1] * currPxl.getGreen() +
            matrixArray[1][2] * currPxl.getBlue());
    int newBlue = (int) Math.round(matrixArray[2][0] * currPxl.getRed() +
            matrixArray[2][1] * currPxl.getGreen() +
            matrixArray[2][2] * currPxl.getBlue());

    return new StdPixel(currPxl.normalize(newRed), currPxl.normalize(newGreen),
            currPxl.normalize(newBlue), currPxl.getMaxVal());
  }
}
