package view;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JLabel {

  private Image currImage;

  /**
   * Constructs an ImagePanel
   */
  public ImagePanel() {
    try {
      currImage = ImageIO.read(new FileInputStream("res/funny.jpg"));
    } catch (IOException e) {
      throw new IllegalArgumentException("Invalid file provided.");
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(currImage, 1, 1, this);
  }

}
