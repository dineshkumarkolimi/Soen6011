package validation;

import display.DisplayMessages;

public class ValidationUtil {

  public static boolean validateInput(double userInput) {
    boolean res = true;
    if (userInput > Double.MAX_VALUE) {
      res = false;
    } else if (userInput < -Double.MAX_VALUE) {
      res = false;
    }
    return res;
  }

  public static boolean validateOutput(double output) {
    boolean res = true;
    if (output == Double.POSITIVE_INFINITY) {
      System.out.println(DisplayMessages.ERROR_MESSAGE_RANGE_OUTPUT_MAX);
      res = false;
    } else if (output == Double.NEGATIVE_INFINITY) {
      System.out.println(DisplayMessages.ERROR_MESSAGE_RANGE_OUTPUT_MIN);
      res = false;
    }
    return res;
  }
}
