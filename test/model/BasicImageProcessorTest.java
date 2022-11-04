package model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


/**
 * Tests the functionality of the img processor model.
 */
public class BasicImageProcessorTest {

  ImageProcessor imgpro1;


  /**
   * Inits the data.
   */
  @Before
  public void initData() {
    imgpro1 = new BasicImageProcessor(new HashMap<String, PixelImage>());
    imgpro1.loadImage("res/masterTester.ppm", "master");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException() {
    imgpro1 = new BasicImageProcessor(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnsureKey() {
    this.initData();
    imgpro1.getLoadedImg("deez");
  }


  @Test
  public void loadImage() {
    this.initData();
    imgpro1.loadImage("res/chess3.ppm", "simple koala");
    PixelImage chess3 = imgpro1.getLoadedImg("simple koala");

    assertEquals(new StdPixel(0, 0, 0, 255),
            chess3.getPixelAt(0, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            chess3.getPixelAt(0, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            chess3.getPixelAt(0, 2));
    assertEquals(new StdPixel(255, 255, 255, 255),
            chess3.getPixelAt(1, 0));
    assertEquals(new StdPixel(0, 0, 0, 255),
            chess3.getPixelAt(1, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            chess3.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            chess3.getPixelAt(2, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            chess3.getPixelAt(2, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            chess3.getPixelAt(2, 2));
  }

  @Test
  public void redComponent() {
    this.initData();
    imgpro1.redComponent("master", "master red");
    PixelImage masterRed = imgpro1.getLoadedImg("master red");

    assertEquals(new StdPixel(255, 255, 255, 255),
            masterRed.getPixelAt(0, 0));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterRed.getPixelAt(0, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterRed.getPixelAt(0, 2));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterRed.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterRed.getPixelAt(1, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterRed.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterRed.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterRed.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterRed.getPixelAt(2, 2));

  }

  @Test
  public void greComponent() {
    this.initData();
    imgpro1.greComponent("master", "master green");
    PixelImage masterGreen = imgpro1.getLoadedImg("master green");

    assertEquals(new StdPixel(0, 0, 0, 255),
            masterGreen.getPixelAt(0, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterGreen.getPixelAt(0, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterGreen.getPixelAt(0, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterGreen.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterGreen.getPixelAt(1, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterGreen.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterGreen.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterGreen.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterGreen.getPixelAt(2, 2));
  }

  @Test
  public void bluComponent() {
    this.initData();
    imgpro1.bluComponent("master", "master blue");
    PixelImage masterBlue = imgpro1.getLoadedImg("master blue");

    assertEquals(new StdPixel(0, 0, 0, 255),
            masterBlue.getPixelAt(0, 0));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterBlue.getPixelAt(0, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterBlue.getPixelAt(0, 2));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterBlue.getPixelAt(1, 0));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterBlue.getPixelAt(1, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterBlue.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterBlue.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterBlue.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterBlue.getPixelAt(2, 2));
  }

  @Test
  public void visValue() {
    this.initData();
    imgpro1.visGreyscale("master", "master value", "value");
    PixelImage masterValue = imgpro1.getLoadedImg("master value");

    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(0, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(0, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(0, 2));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(1, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterValue.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterValue.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterValue.getPixelAt(2, 2));
  }

  @Test
  public void visIntensity() {
    this.initData();
    imgpro1.visGreyscale("master", "master intensity", "intensity");
    PixelImage masterIntensity = imgpro1.getLoadedImg("master intensity");

    assertEquals(new StdPixel(85, 85, 85, 255),
            masterIntensity.getPixelAt(0, 0));
    assertEquals(new StdPixel(85, 85, 85, 255),
            masterIntensity.getPixelAt(0, 1));
    assertEquals(new StdPixel(85, 85, 85, 255),
            masterIntensity.getPixelAt(0, 2));
    assertEquals(new StdPixel(170, 170, 170, 255),
            masterIntensity.getPixelAt(1, 0));
    assertEquals(new StdPixel(170, 170, 170, 255),
            masterIntensity.getPixelAt(1, 1));
    assertEquals(new StdPixel(170, 170, 170, 255),
            masterIntensity.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterIntensity.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterIntensity.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterIntensity.getPixelAt(2, 2));
  }

  @Test
  public void visLuma() {
    this.initData();
    imgpro1.visGreyscale("master", "master luma", "luma");
    PixelImage masterLuma = imgpro1.getLoadedImg("master luma");


    assertEquals(new StdPixel(54, 54, 54, 255),
            masterLuma.getPixelAt(0, 0));
    assertEquals(new StdPixel(182, 182, 182, 255),
            masterLuma.getPixelAt(0, 1));
    assertEquals(new StdPixel(18, 18, 18, 255),
            masterLuma.getPixelAt(0, 2));
    assertEquals(new StdPixel(73, 73, 73, 255),
            masterLuma.getPixelAt(1, 0));
    assertEquals(new StdPixel(237, 237, 237, 255),
            masterLuma.getPixelAt(1, 1));
    assertEquals(new StdPixel(201, 201, 201, 255),
            masterLuma.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterLuma.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterLuma.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterLuma.getPixelAt(2, 2));
  }

  @Test
  public void flipImageHoriz() {
    this.initData();
    imgpro1.flipImage("master", "master horiz", "horizontal");
    PixelImage masterHoriz = imgpro1.getLoadedImg("master horiz");


    assertEquals(new StdPixel(0, 0, 255, 255),
            masterHoriz.getPixelAt(0, 0));
    assertEquals(new StdPixel(0, 255, 0, 255),
            masterHoriz.getPixelAt(0, 1));
    assertEquals(new StdPixel(255, 0, 0, 255),
            masterHoriz.getPixelAt(0, 2));
    assertEquals(new StdPixel(0, 255, 255, 255),
            masterHoriz.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 0, 255),
            masterHoriz.getPixelAt(1, 1));
    assertEquals(new StdPixel(255, 0, 255, 255),
            masterHoriz.getPixelAt(1, 2));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterHoriz.getPixelAt(2, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterHoriz.getPixelAt(2, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterHoriz.getPixelAt(2, 2));
  }

  @Test
  public void flipImageVert() {
    this.initData();
    imgpro1.flipImage("master", "master vert", "vertical");
    PixelImage masterVert = imgpro1.getLoadedImg("master vert");


    assertEquals(new StdPixel(0, 0, 0, 255),
            masterVert.getPixelAt(0, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterVert.getPixelAt(0, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterVert.getPixelAt(0, 2));
    assertEquals(new StdPixel(255, 0, 255, 255),
            masterVert.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 0, 255),
            masterVert.getPixelAt(1, 1));
    assertEquals(new StdPixel(0, 255, 255, 255),
            masterVert.getPixelAt(1, 2));
    assertEquals(new StdPixel(255, 0, 0, 255),
            masterVert.getPixelAt(2, 0));
    assertEquals(new StdPixel(0, 255, 0, 255),
            masterVert.getPixelAt(2, 1));
    assertEquals(new StdPixel(0, 0, 255, 255),
            masterVert.getPixelAt(2, 2));
  }

  @Test
  public void flipTwice() {
    this.initData();
    imgpro1.flipImage("master", "master vert", "vertical");
    imgpro1.flipImage("master vert", "master flip2", "horizontal");
    PixelImage masterVert = imgpro1.getLoadedImg("master flip2");


    assertEquals(new StdPixel(255, 255, 255, 255),
            masterVert.getPixelAt(0, 0));
    assertEquals(new StdPixel(125, 125, 125, 255),
            masterVert.getPixelAt(0, 1));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterVert.getPixelAt(0, 2));
    assertEquals(new StdPixel(0, 255, 255, 255),
            masterVert.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 0, 255),
            masterVert.getPixelAt(1, 1));
    assertEquals(new StdPixel(255, 0, 255, 255),
            masterVert.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 255, 255),
            masterVert.getPixelAt(2, 0));
    assertEquals(new StdPixel(0, 255, 0, 255),
            masterVert.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 0, 0, 255),
            masterVert.getPixelAt(2, 2));
  }

  @Test
  public void imageBrighten() {
    this.initData();
    imgpro1.adjustBrightness("master", 10, "master bright");
    PixelImage masterBright = imgpro1.getLoadedImg("master bright");

    assertEquals(new StdPixel(255, 10, 10, 255),
            masterBright.getPixelAt(0, 0));
    assertEquals(new StdPixel(10, 255, 10, 255),
            masterBright.getPixelAt(0, 1));
    assertEquals(new StdPixel(10, 10, 255, 255),
            masterBright.getPixelAt(0, 2));
    assertEquals(new StdPixel(255, 10, 255, 255),
            masterBright.getPixelAt(1, 0));
    assertEquals(new StdPixel(255, 255, 10, 255),
            masterBright.getPixelAt(1, 1));
    assertEquals(new StdPixel(10, 255, 255, 255),
            masterBright.getPixelAt(1, 2));
    assertEquals(new StdPixel(10, 10, 10, 255),
            masterBright.getPixelAt(2, 0));
    assertEquals(new StdPixel(135, 135, 135, 255),
            masterBright.getPixelAt(2, 1));
    assertEquals(new StdPixel(255, 255, 255, 255),
            masterBright.getPixelAt(2, 2));
  }

  @Test
  public void imageDarken() {
    this.initData();
    imgpro1.adjustBrightness("master", -10, "master dark");
    PixelImage masterDark = imgpro1.getLoadedImg("master dark");

    assertEquals(new StdPixel(245, 0, 0, 255),
            masterDark.getPixelAt(0, 0));
    assertEquals(new StdPixel(0, 245, 0, 255),
            masterDark.getPixelAt(0, 1));
    assertEquals(new StdPixel(0, 0, 245, 255),
            masterDark.getPixelAt(0, 2));
    assertEquals(new StdPixel(245, 0, 245, 255),
            masterDark.getPixelAt(1, 0));
    assertEquals(new StdPixel(245, 245, 0, 255),
            masterDark.getPixelAt(1, 1));
    assertEquals(new StdPixel(0, 245, 245, 255),
            masterDark.getPixelAt(1, 2));
    assertEquals(new StdPixel(0, 0, 0, 255),
            masterDark.getPixelAt(2, 0));
    assertEquals(new StdPixel(115, 115, 115, 255),
            masterDark.getPixelAt(2, 1));
    assertEquals(new StdPixel(245, 245, 245, 255),
            masterDark.getPixelAt(2, 2));
  }

  @Test
  public void saveToPPM() {
    this.initData();
    imgpro1.adjustBrightness("master", -10, "master dark");
    imgpro1.saveToPPM("res/master-dark.ppm", "master dark");
    imgpro1.loadImage("res/master-dark.ppm", "master dark 2");

    assertEquals(imgpro1.getLoadedImg("master dark"),
            imgpro1.getLoadedImg("master dark 2"));

  }

}