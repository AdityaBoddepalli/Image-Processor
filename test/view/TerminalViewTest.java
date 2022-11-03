package view;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TerminalViewTest {

  PixelImageView pIV;
  StringBuilder out;

  public void initData() {
    out = new StringBuilder();
    pIV = new TerminalView(out);
  }

  @Test
  public void transmitMessage() throws IOException {
    this.initData();
    pIV.transmitMessage("wadawada");
    assertEquals("wadawada", out.toString());
  }
}