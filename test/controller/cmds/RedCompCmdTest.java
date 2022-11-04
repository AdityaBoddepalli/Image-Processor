package controller.cmds;


import java.util.Scanner;


/**
 * Tests a specific instance of abstract commands.
 */
public class RedCompCmdTest extends AbstractCmdTest {

  /**
   * Creates an instance to abstract test.
   */
  public RedCompCmdTest() {
    super(new Scanner("koala blue-koala"), "koala"
            , "Command: red-component koala blue-koala\n");
  }

  @Override
  protected ImageProcessorCmds createCmd(Scanner input) {
    return new RedCompCmd(input);
  }
}