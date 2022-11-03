package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StdPixelTest {
  Pixel p1;
  Pixel p2;
  Pixel p3;

  public void initData() {
    p1 = new StdPixel(120, 130, 140, 255);
    p2 = new StdPixel(20, 30, 40, 255);
    p3 = new StdPixel(10, 30, 90, 100);
  }


  @Test
  public void getRed() {
    this.initData();
    assertEquals(120, p1.getRed());
    assertEquals(20, p2.getRed());
    assertEquals(10, p3.getRed());
  }

  @Test
  public void getGreen() {
    this.initData();
    assertEquals(130, p1.getGreen());
    assertEquals(30, p2.getGreen());
    assertEquals(30, p3.getGreen());
  }

  @Test
  public void getBlue() {
    this.initData();
    assertEquals(140, p1.getBlue());
    assertEquals(40, p2.getBlue());
    assertEquals(90, p3.getBlue());
  }

  @Test
  public void getMaxVal() {
    this.initData();
    assertEquals(255, p1.getMaxVal());
    assertEquals(255, p2.getMaxVal());
    assertEquals(100, p3.getMaxVal());
  }

  @Test
  public void greyscale() {
    this.initData();
    assertEquals(new StdPixel(140, 140, 140, 255), p1.greyscale("value"));
    assertEquals(new StdPixel(30, 30, 30, 255), p2.greyscale("intensity"));
    assertEquals(new StdPixel(30, 30, 30, 100), p3.greyscale("luma"));
  }

  @Test
  public void brighten() {
    this.initData();
    assertEquals(new StdPixel(130, 140, 150, 255), p1.brighten(10));
    assertEquals(new StdPixel(236, 246, 255, 255), p2.brighten(216));
    assertEquals(new StdPixel(100, 100, 100, 100), p3.brighten(100));
  }

  @Test
  public void darken() {
    this.initData();
    assertEquals(new StdPixel(110, 120, 130, 255), p1.brighten(-10));
    assertEquals(new StdPixel(0, 5, 15, 255), p2.brighten(-25));
    assertEquals(new StdPixel(0, 0, 0, 100), p3.brighten(-100));
  }
}