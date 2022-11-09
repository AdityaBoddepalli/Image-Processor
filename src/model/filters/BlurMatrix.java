package model.filters;

import model.Pixel;
import model.PixelImage;
import model.StdPixel;


/**
 * A blur kernel.
 */
public class BlurMatrix implements MyMatrix {

  private final double[][] matrixArray;

  public BlurMatrix() {
    matrixArray = new double[3][3];
    matrixArray[0][0] = 0.0625;
    matrixArray[0][2] = 0.0625;
    matrixArray[2][0] = 0.0625;
    matrixArray[2][2] = 0.0625;
    matrixArray[0][1] = 0.125;
    matrixArray[1][0] = 0.125;
    matrixArray[1][2] = 0.125;
    matrixArray[2][1] = 0.125;
    matrixArray[1][1] = 0.25;
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

    for (int mRow = 0; mRow < 3; mRow++) {
      for(int mCol = 0; mCol < 3; mCol++) {
        if(img.isValidPxl(row + mRow - 1, col + mCol - 1)) {
          newRed += this.matrixArray[mRow][mCol] *
                  img.getPixelAt(row + mRow - 1, col + mCol - 1).getRed();
          newGreen += this.matrixArray[mRow][mCol] *
                  img.getPixelAt(row + mRow - 1, col + mCol - 1).getGreen();
          newBlue += this.matrixArray[mRow][mCol] *
                  img.getPixelAt(row + mRow - 1, col + mCol - 1).getBlue();
        }
      }
    }
    return new StdPixel(currPxl.normalize((int) Math.round(newRed)),
            currPxl.normalize((int) Math.round(newGreen)),
            currPxl.normalize((int) Math.round(newBlue)),
            currPxl.getMaxVal());
  }

}
