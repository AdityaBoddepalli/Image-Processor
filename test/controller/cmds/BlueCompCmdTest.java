package controller.cmds;

import java.util.Scanner;


/**
 * Tests a specific instance of abstract commands.
 */
public class BlueCompCmdTest extends AbstractCmdTest {

  /**
   * Creates an instance to abstract test.
   */
  public BlueCompCmdTest() {
    super(new Scanner("koala blue-koala"), "koala"
            , "Command: blue-component koala blue-koala\n");
  }

  @Override
  protected ImageProcessorCmds createCmd(Scanner input) {
    return new BlueCompCmd(input);
  }
}