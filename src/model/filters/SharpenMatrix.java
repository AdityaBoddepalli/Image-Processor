package model.filters;

import model.Pixel;
import model.PixelImage;
import model.StdPixel;

/**
 * A sharpen kernel.
 */
public class SharpenMatrix implements MyMatrix {

  private final double[][] matrixArray;

  public SharpenMatrix() {
    matrixArray = new double[5][5];

    for (int ii = 0; ii < 5; ii++) {
      for (int jj = 0; jj < 5; jj++) {
        if (ii == 1 || ii == 3 || jj == 1 || jj == 3) {
          matrixArray[ii][jj] = 0.25;
        }
        if (ii == 0 || ii == 4 || jj == 0 || jj == 4) {
          matrixArray[ii][jj] = -0.125;
        }
        if (ii == 2 && jj == 2) {
          matrixArray[ii][jj] = 1;
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
    double newRed = 0;
    double newGreen = 0;
    double newBlue = 0;

    for (int mRow = 0; mRow < 5; mRow++) {
      for (int mCol = 0; mCol < 5; mCol++) {
        if (img.isValidPxl(row + mRow - 2, col + mCol - 2)) {
          newRed += this.matrixArray[mRow][mCol] *
                  img.getPixelAt(row + mRow - 2, col + mCol - 2).getRed();
          newGreen += this.matrixArray[mRow][mCol] *
                  img.getPixelAt(row + mRow - 2, col + mCol - 2).getGreen();
          newBlue += this.matrixArray[mRow][mCol] *
                  img.getPixelAt(row + mRow - 2, col + mCol - 2).getBlue();
        }
      }
    }
    return new StdPixel(currPxl.normalize((int) Math.round(newRed)),
            currPxl.normalize((int) Math.round(newGreen)),
            currPxl.normalize((int) Math.round(newBlue)),
            currPxl.getMaxVal());
  }
}
