package controller.runnables;

import java.io.IOException;

import model.ImageProcessor;
import view.GUIView;

public abstract class AbstractButtonAction implements Runnable{

  protected final ImageProcessor model;

  protected final GUIView view;

  public AbstractButtonAction(ImageProcessor model, GUIView view) {
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
    String displayImgName = null;
    try {
      displayImgName = this.specificAction();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
    if(displayImgName != null) {
      this.view.setDisplayImage(this.model.getLoadedImg(displayImgName));
      this.view.setCurrImageName(displayImgName);
      this.view.refresh();
    }
  }

  /**
   * The signature features of every button that are different.
   * @return the image to be displayed after the process.
   */
  protected abstract String specificAction() throws IOException;
}
