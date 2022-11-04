package controller.cmds;

import java.util.Scanner;

/**
 * Tests a specific instance of abstract commands.
 */
public class GreenCompCmdTest extends AbstractCmdTest {


  /**
   * Creates an instance to abstract test.
   */
  public GreenCompCmdTest() {
    super(new Scanner("koala blue-koala"), "koala"
            , "Command: green-component koala blue-koala\n");
  }

  @Override
  protected ImageProcessorCmds createCmd(Scanner input) {
    return new GreenCompCmd(input);
  }
}