package validation;

import display.DisplayMessages;

public class ValidationUtil {

  public static boolean validateInputRange(double userInput) {
    boolean result = true;
    if (userInput > Double.MAX_VALUE) {
      result = false;
    } else if (userInput < -Double.MAX_VALUE) {
      result = false;
    }
    return result;
  }

  public static boolean validateOutputRange(double output) {
    boolean result = true;
    if (output == Double.POSITIVE_INFINITY) {
      System.out.println(DisplayMessages.ERROR_MESSAGE_RANGE_OUTPUT_MAX);
      result = false;
    } else if (output == Double.NEGATIVE_INFINITY) {
      System.out.println(DisplayMessages.ERROR_MESSAGE_RANGE_OUTPUT_MIN);
      result = false;
    }
    return result;
  }
}
