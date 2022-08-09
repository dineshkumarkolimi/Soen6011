package display;

public class DisplayMessages {

  public static final String ENTER_INPUT = "Please enter any number as input to calculate the sinhx\n";
  public static final String INPUT_IS_INVALID = "Given input is in valid, Input should be number only";
  public static final String OUTPUT_MESSAGE = "Output of calculation of sinh for the given input ";
  static final String CONTINUE_MESSAGE = "Please enter 1 to continue\nPlease enter 0 to "
      + "exit from calculator program";
  public static final String RANGE_ERROR_MESSAGE =
      "Value should be more than " + Double.MIN_VALUE + " and less than " + Double.MAX_VALUE;
  public static final String ERROR_MESSAGE_RANGE_OUTPUT_MAX =
      "Output value is more than supported value " + Double.MAX_VALUE + "";
  public static final String ERROR_MESSAGE_RANGE_OUTPUT_MIN =
      "Output value is less than supported value " + Double.MIN_VALUE + "";
  static final String INVALID_CHOICE_ERROR =
      "invalid choice, please follow the instruction";
  public static final String PROGRAM_STOPPED_ERROR_MESSAGE =
      "\n Calculator Program stopped unexpectedly,Please re run program\n";
}
