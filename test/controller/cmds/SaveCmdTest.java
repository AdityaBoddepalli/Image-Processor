package controller.cmds;

import java.util.Scanner;

/**
 * Tests a specific instance of abstract commands.
 */
public class SaveCmdTest extends AbstractCmdTest {

  /**
   * Creates an instance to abstract test.
   */
  public SaveCmdTest() {
    super(new Scanner("koala blue-koala"), "koala"
            , "Command: save koala blue-koala\n");
  }

  @Override
  protected ImageProcessorCmds createCmd(Scanner input) {
    return new SaveCmd(input);
  }
}