package controller;

/**
 * Controller for the image processor. Acts as a UI between the user and the underlying model
 */
public interface ImageProcessorController {

  /**
   * Start the imgprocessor and wait for user input.
   * Execute if the input is valid
   *
   * @throws IllegalStateException if the input is invalid or impossible right now.
   */
  void startProcessing() throws IllegalStateException;
}
