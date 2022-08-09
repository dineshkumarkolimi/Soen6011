import java.text.DecimalFormat;
import java.util.Scanner;

import display.DisplayMessages;
import validation.ValidationUtil;

/**
 * This class  implements sinhx function
 *
 * @author : dineshkumar kolimi
 */
public class SinhFunction {

  private static final double div = 2d;
  static int maximumTurns = 20;

  /**
   * Function to calculate e power x.
   *
   * @param x input provided by user
   * @return calculated value of e power x
   */
  double epowerx(double x) {
    double res = 1;

    for (int i = SinhFunction.maximumTurns; i > 0; --i) {
      res = 1 + x * res / i;
    }

    return res;
  }

  /**
   * To calculate sinh(x) using sinh(x) = (e^x - e^-x)/2.
   *
   * @returns result
   */
  double calculateSinh(double ePowerX, double ePowerMinusX) {
    return (ePowerX - ePowerMinusX) / div;
  }

  /**
   * Function to validate e power x and then calculate sinhx
   */
  private void validCalculateSinhx(double x, double ePowerX, double ePowerMinusX) {
    if (ValidationUtil.validateOutput(ePowerX) && ValidationUtil
        .validateOutput(ePowerMinusX)) {
      double res = calculateSinh(ePowerX, ePowerMinusX);
      System.out.print(DisplayMessages.OUTPUT_MESSAGE + x + " is ");
      System.out.printf("%.15f", res);
    }
  }

  /**
   * Function to calculate sinhx with input x
   * It calculates e power x
   * It calculates sinhx
   * validates if the values are within the range or not
   */
  void init() {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextDouble()) {
      double val = scanner.nextDouble();
      if (ValidationUtil.validateInput(x)) {
        //As per assumption consider only first 15 decimal points from input
        DecimalFormat df = new DecimalFormat(".####################");
        val = Double.parseDouble(df.format(val));
        double epowerX = epowerx(val);
        double epowerMinusX = epowerx(-val);
        validCalculateSinhx(val, epowerX, epowerMinusX);
      } else {
        System.out.println(DisplayMessages.RANGE_ERROR_MESSAGE);
      }

    } else {
      System.out.println(DisplayMessages.INPUT_IS_INVALID);
    }

  }

}
