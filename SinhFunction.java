import java.text.DecimalFormat;
import java.util.Scanner;

import display.DisplayMessages;
import validation.ValidationUtil;

/**
 * This class  implements sinhx function
 *
 * @author : dineshkumar
 */
public class SinhFunction {

  static int maxSteps = 20;
  private static final double divisor = 2d;

  /**
   * Function to calculate e power x based on Taylor series.
   *
   * @param x input provided by user
   * @return calculated value of e power x
   */
  double epowerx(double x) {
    double result = 1;

    for (int i = SinhFunction.maxSteps; i > 0; --i) {
      result = 1 + x * result / i;
    }

    return result;
  }

  /**
   * This function calculates sinh(x) based on formula , sinh(x) = (e^x - e^-x)/2.
   *
   * @return result of sinh based on input
   */
  double calculateSinh(double epowerX, double epowerMinusX) {
    return (epowerX - epowerMinusX) / divisor;
  }

  /**
   * Function to validate e power x and then calculate sinhx
   */
  private void validateAndCalculateSinhx(double x, double epowerX, double epowerminusX) {
    if (ValidationUtil.validateOutputRange(epowerX) && ValidationUtil
        .validateOutputRange(epowerminusX)) {
      double result = calculateSinh(epowerX, epowerminusX);
      System.out.print(DisplayMessages.OUTPUT_MESSAGE + x + " is ");
      System.out.printf("%.15f", result);
    }
  }

  /**
   * Function to calculate sinhx with input x
   * It calculates e power x
   * It calculates sinhx
   * validates if the values are within the range or not
   */
  void initCalculation() {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextDouble()) {
      double x = scanner.nextDouble();
      if (ValidationUtil.validateInputRange(x)) {
        //As per assumption consider only first 15 decimal points from input
        DecimalFormat df = new DecimalFormat(".####################");
        x = Double.parseDouble(df.format(x));
        double epowerX = epowerx(x);
        double epowerMinusX = epowerx(-x);
        validateAndCalculateSinhx(x, epowerX, epowerMinusX);
      } else {
        System.out.println(DisplayMessages.RANGE_ERROR_MESSAGE);
      }

    } else {
      System.out.println(DisplayMessages.INPUT_IS_INVALID);
    }

  }

}
