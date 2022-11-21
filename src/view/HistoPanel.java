package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import javax.swing.*;

public class HistoPanel extends JPanel {

  private int redDistr[];
  private int greenDistr[];
  private int blueDistr[];

  private int maxVal;

  private int intensityDistr[];

  public HistoPanel() {
    super();
    this.maxVal = 255;
    this.redDistr = new int[this.maxVal + 1];
    this.greenDistr = new int[this.maxVal + 1];
    this.blueDistr = new int[this.maxVal + 1];
    this.intensityDistr = new int[this.maxVal + 1];
    this.setVisible(false);
  }

  public void setRedDistr(int[] redDistr) {
    this.redDistr = redDistr;
  }

  public void setGreenDistr(int[] greenDistr) {
    this.greenDistr = greenDistr;
  }

  public void setBlueDistr(int[] blueDistr) {
    this.blueDistr = blueDistr;
  }

  public void setIntensityDistr(int[] intensityDistr) {
    this.intensityDistr = intensityDistr;
  }

  public void setMaxVal(int maxVal) {
    this.maxVal = maxVal;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);


    AffineTransform ogTransform = g2d.getTransform();

    g2d.translate(0, this.getHeight());
    g2d.scale(1, -1);
    Stroke prevStroke = g2d.getStroke();
    g2d.setStroke(new BasicStroke(5));
    g2d.drawLine(15, 25, this.getWidth() - 15, 25);
    g2d.drawLine(15, 25, 15, this.getHeight() - 15);
    g2d.setStroke(prevStroke);
    g2d.drawString("0", 15, 20);
    double rectWidth = ((double) this.getWidth() - 30) / (double) this.maxVal;
    double maxFreq = Integer.max(Integer.max(Arrays.stream(this.redDistr).max().getAsInt(),
                    Arrays.stream(this.blueDistr).max().getAsInt()),
            Integer.max(Arrays.stream(this.greenDistr).max().getAsInt(),
                    Arrays.stream(this.intensityDistr).max().getAsInt()));
    double heightFactor = ((double) this.getHeight() - 40) / maxFreq;
    for (int ii = 0; ii < this.maxVal + 1; ii++) {
      g2d.setColor(Color.RED);
      g2d.drawRect((int) (15 + (ii * rectWidth)), 25, (int) rectWidth,
              (int) (this.redDistr[ii] * heightFactor));
      g2d.setColor(Color.GREEN);
      g2d.drawRect((int) (15 + (ii * rectWidth)), 25, (int) rectWidth,
              (int) (this.greenDistr[ii] * heightFactor));
      g2d.setColor(Color.BLUE);
      g2d.drawRect((int) (15 + (ii * rectWidth)), 25, (int) rectWidth,
              (int) (this.blueDistr[ii] * heightFactor));
      g2d.setColor(Color.WHITE);
      g2d.drawRect((int) (15 + (ii * rectWidth)), 25, (int) rectWidth,
              (int) (this.intensityDistr[ii] * heightFactor));
      g2d.setColor(Color.BLACK);
    }

    g2d.setTransform(ogTransform);
    g2d.drawString(Integer.toString(this.maxVal), this.getWidth() - 24,
            this.getHeight() - 12);
  }
}
