package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class SwingImageProcessor extends JFrame implements GUIView {


  private final ImagePanel currImage;

  private final ButtonPanel options;

  private final HistoPanel histogram;

  private JButton BlueComp;
  private JButton Blur;
  private JButton Brighten;
  private JButton Darken;
  private JButton GreenComp;
  private JButton Greyscale;
  private JButton HorizFlip;
  private JButton Intensity;
  private JButton Load;
  private JButton Luma;
  private JButton Open;
  private JButton RedComp;
  private JButton Save;
  private JButton Sepia;
  private JButton Sharpen;
  private JButton Value;
  private JButton VertFlip;

  private String currImgName;


  /**
   * Constructs our Swing view of the image processor.
   *
   * @throws HeadlessException if GraphicsEnvironment.isHeadless()
   *                           returns true.
   * @see GraphicsEnvironment#isHeadless
   * @see Component#setSize
   * @see Component#setVisible
   * @see JComponent#getDefaultLocale
   */
  public SwingImageProcessor() throws HeadlessException {
    super();

    setPreferredSize(new Dimension(1600, 900));

    //this.getContentPane().setPreferredSize(new Dimension(500, 500));
    //setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    currImage = new ImagePanel(); //TODO: Make a constructor for the ImagePanel
    this.add(this.currImage, BorderLayout.WEST);
    this.options = new ButtonPanel();
    this.add(this.options, BorderLayout.NORTH);
    this.histogram = new HistoPanel();
    this.add(this.histogram, BorderLayout.EAST);

    JScrollPane scroll = new JScrollPane(this.currImage);
    this.add(scroll);


    pack();
    setVisible(true);
    refresh();
  }

  /**
   * Redraws the view.
   */
  @Override
  public void refresh() {
  }

  /**
   * Sets the ActionListener of the button commands to the given ActionListener.
   *
   * @param listener the given ActionLister for the button command
   */
  @Override
  public void addActionListener(ActionListener listener) {

  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void transmitMessage(String message) throws IOException {

  }
}
