package model;

import java.io.FileWriter;
import java.io.IOException;

public class GridPixelImage implements PixelImage {

  private final Pixel[][] imageGrid;

  private final int height;

  private final int width;


  /**
   * C
   *
   * @param imageGrid
   * @param height
   * @param width
   */
  public GridPixelImage(Pixel[][] imageGrid, int height, int width) {
    this.imageGrid = imageGrid;
    this.height = height;
    this.width = width;
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
    if ((row >= 0 && row < this.getHeight())
            && (col >= 0 && col < this.getWidth())) {
      return this.imageGrid[row][col];
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns the number of rows of pixels in this image.
   *
   * @return the height
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Returns the number of columns of pixels in this image.
   *
   * @return the width
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Returns the maximum numeric value a pixel in this PixelImage can have.
   *
   * @return an integer representing the max value.
   */
  @Override
  public int getMaxValue() {
    return this.getPixelAt(0, 0).getMaxVal();
  }

  /**
   * Visualizes the image as a color-scaled image.
   *
   * @param color the color to grayscale
   * @return a new PixelImage in blue scale.
   */
  @Override
  public PixelImage getComponent(String color) {
    Pixel[][] newGrid = new Pixel[height][width];
    int colVal = 0;
    for (int row = 0; row < this.getHeight(); row++) {
      for (int col = 0; col < this.getWidth(); col++) {
        switch (color.toLowerCase()) {
          case "red":
            colVal = this.getPixelAt(row, col).getRed();
            break;
          case "green":
            colVal = this.getPixelAt(row, col).getGreen();
            break;
          case "blue":
            colVal = this.getPixelAt(row, col).getBlue();
            break;
          default:
            throw new IllegalArgumentException("Invalid component to visualize");
        }
        Pixel p = new StdPixel(colVal, colVal, colVal, this.getMaxValue());
        newGrid[row][col] = p;
      }
    }
    return new GridPixelImage(newGrid, this.height, this.width);
  }


  /**
   * Visualizes the given image in greyscale according to the specified type.
   *
   * @param type the type of greyscale - value, intensity or luma
   * @return a new Image greyscaled accordingly.
   */
  @Override
  public PixelImage visGreyscale(String type) {
    Pixel[][] newGrid = new Pixel[height][width];
    int colVal = 0;
    for (int row = 0; row < this.getHeight(); row++) {
      for (int col = 0; col < this.getWidth(); col++) {
        Pixel currPixel = this.getPixelAt(row, col);
        newGrid[row][col] = currPixel.greyscale(type);
      }
    }
    return new GridPixelImage(newGrid, this.height, this.width);
  }

  /**
   * Visualizes this image as the mirror image in the given direction of the original.
   *
   * @param direction the direction to flip.
   * @return a new Image flipped horizontally.
   */
  @Override
  public PixelImage flipImage(String direction) {
    Pixel[][] newGrid = new Pixel[height][width];
    for (int row = 0; row < this.getHeight(); row++) {
      for (int col = 0; col < this.getWidth(); col++) {
        Pixel currPixel = this.getPixelAt(row, col);
        Pixel p = new StdPixel(currPixel.getRed(), currPixel.getGreen(),
                currPixel.getBlue(), this.getMaxValue());
        switch (direction.toLowerCase()) {
          case "vertical":
            newGrid[this.height - 1 - row][col] = p;
          case "horizontal":
            newGrid[row][this.width - 1 - col] = p;
          default:
            throw new IllegalArgumentException("Invalid direction to flip: " + direction);
        }
      }
    }
    return new GridPixelImage(newGrid, this.height, this.width);
  }

  /**
   * Visualizes the image as a brighter/darker version of
   * the original image by a certain factor.
   *
   * @param factor the factor to brighten
   * @return a new PixelImage that is brightened.
   */
  @Override
  public PixelImage adjustBrightness(int factor) {
    Pixel[][] newGrid = new Pixel[height][width];
    int colVal = 0;
    for (int row = 0; row < this.getHeight(); row++) {
      for (int col = 0; col < this.getWidth(); col++) {
        Pixel currPixel = this.getPixelAt(row, col);
        newGrid[row][col] = currPixel.brighten(factor);
      }
    }
    return new GridPixelImage(newGrid, this.height, this.width);
  }



  /**
   * Saves this image to the given path
   *
   * @param path the path to save to.
   */
  @Override
  public void saveImg(String path) {
    try {
      FileWriter save = new FileWriter(path);
      save.write("P3\n");
      save.write(String.format("%i %i\n", this.width, this.height));
      save.write(String.format("%i\n", this.getMaxValue()));
      for (int row = 0; row < this.getHeight(); row++) {
        for (int col = 0; col < this.getWidth(); col++) {
          Pixel currPixel = this.getPixelAt(row, col);
          save.write(String.format("%i\n", currPixel.getRed()));
          save.write(String.format("%i\n", currPixel.getGreen()));
          save.write(String.format("%i\n", currPixel.getBlue()));
        }
      }
      save.close();

    } catch (IOException e) {
      throw new IllegalStateException("Couldn't write to file");
    }
  }
}
