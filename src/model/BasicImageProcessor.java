package model;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;


/**
 * An implementation of the image processor with a hashmap to store previous images.
 */
public class BasicImageProcessor implements ImageProcessor {

  private final Map<String, PixelImage> images;

  /**
   * Constructs a basic image processor.
   *
   * @param images hashmap of images
   */
  public BasicImageProcessor(Map<String, PixelImage> images) {
    if (images == null) {
      throw new IllegalArgumentException("cant have a null map");
    }
    this.images = images;
  }

  /**
   * Loads the image at the given path and refers it by the given image name.
   *
   * @param imgPath the file path
   * @param imgName the name of the image.
   */
  @Override
  public void loadImage(String imgPath, String imgName) throws IOException {
    PixelImage image;

    if (!imgPath.substring(imgPath.length() - 4, imgPath.length()).equals(".ppm")) {
      image = ImageUtil.bufferedToPixel(ImageIO.read(new FileInputStream(imgPath)));
    } else {
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

      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          int r = imgScanner.nextInt();
          int g = imgScanner.nextInt();
          int b = imgScanner.nextInt();

          Pixel p = new StdPixel(r, g, b, maxVal);
          grid[row][col] = p;
        }
      }
      image = new GridPixelImage(grid, height, width);
    }

    this.images.put(imgName, image);

  }

  /**
   * Ensures that the given key is a valid image name.
   *
   * @param key the key
   */
  private void ensureKey(String key) {
    if (!(images.containsKey(key))) {
      throw new IllegalArgumentException("No image called " + key + " is currently loaded");
    }
  }

  /**
   * Extracts the given component from the image.
   *
   * @param imgName  the image name
   * @param destName name of the new image
   * @param color    color to extract.
   */
  private void extractComponent(String imgName, String destName, String color) {
    this.ensureKey(imgName);
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
    this.ensureKey(imgName);
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
    this.ensureKey(imgName);
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
    this.ensureKey(imgName);
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
  public void saveImage(String fileName, String imgName) throws IOException {
    this.ensureKey(imgName);
    PixelImage img = this.images.get(imgName);
    String imgFormat = this.getImageFormat(fileName);
    if (!fileName.substring(fileName.length() - 4, fileName.length()).equals(".ppm")) {
      File output = new File(fileName);
      ImageIO.write(ImageUtil.pixelToBuffered(img), imgFormat, output);

    } else {
      img.saveImg(fileName);
    }

  }

  private String getImageFormat(String fileName) {
    for (int i = fileName.length() - 1; i >= 0; i--) {
      if(fileName.charAt(i) == '.') {
        return fileName.substring(i + 1);
      }
    }
    throw new IllegalArgumentException("Filename doesnt have an extension");
  }

  /**
   * Return a map of the images loaded so for with their names.
   *
   * @param imgName the img name
   * @return a img with the given name
   */
  @Override
  public PixelImage getLoadedImg(String imgName) {
    this.ensureKey(imgName);
    return this.images.get(imgName);
  }

  /**
   * Creates a new image based on the filter applied to the given image.
   *
   * @param imgName  the img to filter
   * @param destName the filtered img
   * @param type     the type of filter - blur and sharpen
   */
  @Override
  public void filterImage(String imgName, String destName, String type) {
    this.ensureKey(imgName);
    PixelImage editedImage = this.images.get(imgName).filter(type);
    this.images.put(destName, editedImage);
  }

}
