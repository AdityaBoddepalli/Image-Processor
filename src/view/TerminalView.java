package view;

import java.io.IOException;

public class TerminalView implements PixelImageView {

  Appendable output;

  public TerminalView(Appendable output) {
    if(output == null) {
      throw new IllegalArgumentException("Invalid view");
    }
    this.output = output;
  }

  public TerminalView() {
    this.output = System.out;
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void transmitMessage(String message) throws IOException {
    this.output.append(message);
  }
}
