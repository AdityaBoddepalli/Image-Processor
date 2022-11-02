package model;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class BasicImageProcessor implements ImageProcessor {

  private final Map<String, PixelImage> images;

  public BasicImageProcessor(Map<String, PixelImage> images) {
    this.images = images;
  }

  /**
   * Loads the image at the given path and refers it by the given image name.
   *
   * @param imgPath the file path
   * @param imgName the name of the image.
   */
  @Override
  public void loadImage(String imgPath, String imgName) {
    Scanner imgScanner = ImageUtil.readPPM(imgPath);
    String token;
    token = imgScanner.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }

    int width = imgScanner.nextInt();
    int height = imgScanner.nextInt();
    int maxVal = imgScanner.nextInt();

    Pixel[][] grid = new Pixel[height][width];

    for(int row = 0; row < height; row++) {
      for(int col = 0; col < width; col++) {
        int r = imgScanner.nextInt();
        int g = imgScanner.nextInt();
        int b = imgScanner.nextInt();

        Pixel p = new StdPixel(r,g,b,maxVal);
        grid[row][col] = p;
      }
    }
    PixelImage image = new GridPixelImage(grid, height, width);

    this.images.put(imgName, image);

  }
  private void extractComponent(String imgName, String destName, String color) {
    PixelImage editedImage = this.images.get(imgName).getComponent(color);
    this.images.put(destName, editedImage);
  }

  /**
   * Visualizes the given image as a red-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void redComponent(String imgName, String destName) {
    this.extractComponent(imgName, destName, "red");
  }


  /**
   * Visualizes the image as a green-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void greComponent(String imgName, String destName) {
    this.extractComponent(imgName, destName, "green");
  }

  /**
   * Visualizes the image as a blue-scaled image.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   */
  @Override
  public void bluComponent(String imgName, String destName) {
    this.extractComponent(imgName, destName, "blue");
  }

  /**
   * Visualizes the given image in greyscale according to the specified type.
   *
   * @param imgName  the image to visualize
   * @param destName the new image to save
   * @param type     the type of greyscale - value, intensity or luma
   */
  @Override
  public void visGreyscale(String imgName, String destName, String type) {
    PixelImage editedImage = this.images.get(imgName).visGreyscale(type);
    this.images.put(destName, editedImage);
  }

  /**
   * Visualizes the image as the mirror image in the given direction of the original.
   *
   * @param imgName   the image to flip.
   * @param destName  the new image to save
   * @param direction the direction to flip
   */
  @Override
  public void flipImage(String imgName, String destName, String direction) {
    PixelImage editedImage = this.images.get(imgName).flipImage(direction);
    this.images.put(destName, editedImage);
  }

  /**
   * Creates a new image as a brighter or darker version of the original image by a certain factor.
   *
   * @param imgName  the image to brighten
   * @param factor   the factor to brighten
   * @param destName the new image to save
   */
  @Override
  public void adjustBrightness(String imgName, int factor, String destName) {
    PixelImage editedImage = this.images.get(imgName).adjustBrightness(factor);
    this.images.put(destName, editedImage);
  }


  /**
   * Represents a PixelImage as text and saves it to a PPM file.
   *
   * @param fileName the file to save up
   * @param imgName  the image to save
   */
  @Override
  public void saveToPPM(String fileName, String imgName) {
    this.images.get(imgName).saveImg(fileName);
  }

  /**
   * Return a map of the images loaded so for with their names.
   *
   * @return a map of img names to the Pixel Image
   */
  @Override
  public Map<String, PixelImage> getLoadedImgs() {
    Map<String, PixelImage> loadedImages = new HashMap<>();
    for(Map.Entry<String, PixelImage> entry : this.images.entrySet()) {
      loadedImages.put(entry.getKey(), entry.getValue());
    }
    return loadedImages;
  }
}
