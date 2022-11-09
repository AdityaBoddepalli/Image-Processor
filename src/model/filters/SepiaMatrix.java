package model.filters;

import model.Pixel;
import model.PixelImage;
import model.StdPixel;


/**
 * A greyscale transformation matrix
 */
public class SepiaMatrix implements MyMatrix {

  private final double[][] matrixArray;

  public SepiaMatrix() {
    matrixArray = new double[3][3];
    matrixArray[0][0] = 0.393;
    matrixArray[0][1] = 0.769;
    matrixArray[0][2] = 0.189;
    matrixArray[1][0] = 0.349;
    matrixArray[1][1] = 0.686;
    matrixArray[1][2] = 0.168;
    matrixArray[2][0] = 0.272;
    matrixArray[2][1] = 0.534;
    matrixArray[2][2] = 0.131;
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
