package model;

public class StdPixel implements Pixel {

  int redVal;
  int greVal;
  int bluVal;
  int maxVal;

  /**
   * An observer on a pixel that returns the red component.
   *
   * @return int between 0 and MaxVal
   */
  @Override
  public int getRed() {
    return 0;
  }

  /**
   * An observer on a pixel that returns the green component.
   *
   * @return int between 0 and MaxVal
   */
  @Override
  public int getGreen() {
    return 0;
  }

  /**
   * An observer on a pixel that returns the blue component.
   *
   * @return int between 0 and MaxVal
   */
  @Override
  public int getBlue() {
    return 0;
  }

  /**
   * An observer on a pixel that returns the maximum possible value of a component.
   *
   * @return an integer
   */
  @Override
  public int getMaxVal() {
    return 0;
  }

  /**
   * Returns a pixel representing the greyscale version of the pixel.
   *
   * @return a greyscale version of the pixel
   */
  @Override
  public Pixel greyscale() {
    return null;
  }

  /**
   * Returns a pixel that is representing the pixel brightened by the given factor.
   *
   * @param factor
   * @return a brightened version of the pixel
   */
  @Override
  public Pixel brighten(int factor) {
    return null;
  }

  /**
   * Returns a pixel that is representing the pixel darkened by the given factor.
   *
   * @param factor
   * @return a darkened version of the pixel
   */
  @Override
  public Pixel darken(int factor) {
    return null;
  }
}
