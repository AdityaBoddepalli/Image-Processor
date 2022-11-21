package controller.runnables;

import model.ImageProcessor;
import view.GUIView;

public class RefreshButtonAction implements Runnable {

  private final ImageProcessor model;
  private final GUIView view;
  public RefreshButtonAction(ImageProcessor model, GUIView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used
   * to create a thread, starting the thread causes the object's
   * <code>run</code> method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method <code>run</code> is that it may
   * take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    this.view.refresh();
  }
}
