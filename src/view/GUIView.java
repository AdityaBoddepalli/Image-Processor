package view;

import java.awt.event.ActionListener;

/**
 * The graphical interface implemented for the Image-Processor program.
 */
public interface GUIView extends PixelImageView {

  /**
   * Redraws the view.
   */
  void refresh();

  /**
   * Sets the ActionListener of the button commands to the given ActionListener.
   *
   * @param listener the given ActionLister for the button command
   */
  void addActionListener(ActionListener listener);

}
