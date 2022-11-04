package controller;

import org.junit.Test;

import java.io.StringReader;
import java.util.HashMap;

import model.BasicImageProcessor;
import model.ImageProcessor;
import model.PixelImage;
import view.PixelImageView;
import view.TerminalView;

import static org.junit.Assert.assertEquals;


/**
 * Tests the features of a controller.
 */
public class ImageProcessorControllerImplTest {

  ImageProcessor imgPro1;
  PixelImageView view1;
  ImageProcessorController controller1;

  private void initData() {
    imgPro1 = new BasicImageProcessor(new HashMap<String, PixelImage>());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNullView() {
    controller1 = new ImageProcessorControllerImpl(imgPro1, null, new StringReader("deez"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNullModel() {
    controller1 = new ImageProcessorControllerImpl(null, view1, new StringReader("deez"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorNullReader() {
    controller1 = new ImageProcessorControllerImpl(imgPro1, view1, null);
  }


  @Test(expected = IllegalStateException.class)
  public void testControllerCantTransmit() {
    this.initData();
    Appendable out = new MockAppendable();
    Readable in = new StringReader("load res/chess3.ppm ch");
    view1 = new TerminalView(out);
    controller1 = new ImageProcessorControllerImpl(imgPro1, view1, in);
    controller1.startProcessing();
  }

  @Test(expected = IllegalStateException.class)
  public void invalidCommand() {
    this.initData();
    Appendable out = new MockAppendable();
    Readable in = new StringReader("load res/chess3.ppm ch");
    view1 = new TerminalView(out);
    controller1 = new ImageProcessorControllerImpl(new InvalidCommandModel(), view1, in);
    controller1.startProcessing();
  }

  @Test
  public void startProcessing() {
    this.initData();
    StringBuilder out = new StringBuilder();
    view1 = new TerminalView(out);
    StringReader in = new StringReader("load res/Koala.ppm koala " +
            "red-component koala koala " +
            "green-component koala koala " +
            "blue-component koala koala " +
            "greyscale koala koala value " +
            "greyscale koala koala intensity " +
            "greyscale koala koala luma " +
            "flip-vertical koala koala " +
            "flip-horizontal koala koala " +
            "brighten koala koala 20 " +
            "darken koala koala 10 " +
            "save res/processed-koala.ppm koala ");
    controller1 = new ImageProcessorControllerImpl(imgPro1, view1, in);
    controller1.startProcessing();
    assertEquals("Welcome to Image Processor\n" +
            "load: Success.\n" +
            "red-component: Success.\n" +
            "green-component: Success.\n" +
            "blue-component: Success.\n" +
            "greyscale: Success.\n" +
            "greyscale: Success.\n" +
            "greyscale: Success.\n" +
            "flip-vertical: Success.\n" +
            "flip-horizontal: Success.\n" +
            "brighten: Success.\n" +
            "darken: Success.\n" +
            "save: Success.\n" +
            "End of input\n" +
            "Quit successfully\n" +
            "Thank You for using our Image Processor\n", out.toString());
  }

  @Test
  public void testQuit() {
    this.initData();
    StringBuilder out = new StringBuilder();
    view1 = new TerminalView(out);
    StringReader in = new StringReader("load res/Koala.ppm koala " +
            "red-component koala koala " +
            "Quit");
    controller1 = new ImageProcessorControllerImpl(imgPro1, view1, in);
    controller1.startProcessing();
    assertEquals("Welcome to Image Processor\n" +
            "load: Success.\n" +
            "red-component: Success.\n" +
            "Quit successfully\n" +
            "Thank You for using our Image Processor\n", out.toString());
  }


  @Test
  public void confirmInput() {
    this.initData();
    StringBuilder doNotCareOutput = new StringBuilder();
    StringBuilder log = new StringBuilder();
    view1 = new TerminalView(doNotCareOutput);
    StringReader in = new StringReader("load res/Koala.ppm koala " +
            "red-component koala koala " +
            "green-component koala koala " +
            "blue-component koala koala " +
            "greyscale koala koala value " +
            "greyscale koala koala intensity " +
            "greyscale koala koala luma " +
            "flip-vertical koala koala " +
            "flip-horizontal koala koala " +
            "brighten koala koala 20 " +
            "darken koala koala 10 " +
            "save res/processed-koala.ppm koala ");
    controller1 = new ImageProcessorControllerImpl(new ConfirmInputsModel(log), view1, in);
    controller1.startProcessing();
    assertEquals("Command: load res/Koala.ppm koala\n" +
            "Command: red-component koala koala\n" +
            "Command: green-component koala koala\n" +
            "Command: blue-component koala koala\n" +
            "Command: greyscale koala koala value\n" +
            "Command: greyscale koala koala intensity\n" +
            "Command: greyscale koala koala luma\n" +
            "Command: flip-vertical koala koala\n" +
            "Command: flip-horizontal koala koala\n" +
            "Command: brighten koala koala 20\n" +
            "Command: darken koala koala 10\n" +
            "Command: save res/processed-koala.ppm koala\n", log.toString());

  }
}