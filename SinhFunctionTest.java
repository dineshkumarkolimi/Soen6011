import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import display.DisplayMessages;

public class SinhFunctionTest {

  private final ByteArrayOutputStream outputData = new ByteArrayOutputStream();
  private final PrintStream originalOutput = System.out;

  @Before
  public void initialSetup() {
    System.setOut(new PrintStream(outputData));
    SinhFunction.maxSteps = 20;
  }

  @After
  public void finalClosure() {
    System.setOut(originalOutput);
  }

  /**
   * Test case 1: Test case to verify if the function is returning valid output for a valid input.
   */
  @Test
  public void testValidInputInitCalculation() {
    SinhFunction sinhFunction = new SinhFunction();
    ByteArrayInputStream input = new ByteArrayInputStream("1".getBytes());
    System.setIn(input);
    sinhFunction.initCalculation();
    String expectedResult = String.valueOf(1.1752011936438);
    Assert.assertTrue(outputData.toString().trim().contains(expectedResult));
    System.setIn(System.in);
  }

  /**
   * Test case 2: Test case to verify if the initCalculation method is returning proper error message if invalid input is given.
   */
  @Test
  public void testInvalidInputInitCalculation() {
    SinhFunction sinhFunc = new SinhFunction();
    ByteArrayInputStream input = new ByteArrayInputStream("This is an invalid input".getBytes());
    System.setIn(input);
    sinhFunc.initCalculation();
    Assert.assertTrue(DisplayMessages.INPUT_IS_INVALID.equalsIgnoreCase(outputData.toString().trim()));
    System.setIn(System.in);
  }

  /**
   * Test case 3: Test case to verify the error message in case of valid numeric but exceeds the upper bound of the datatype.
   */
  @Test
  public void testInvalidUpperBoundInputInitCalculation() {
    SinhFunction sinhFunction = new SinhFunction();
    ByteArrayInputStream input = new ByteArrayInputStream(
        String.valueOf(2 * Double.MAX_VALUE).getBytes());
    System.setIn(input);
    sinhFunction.initCalculation();
    Assert.assertTrue(DisplayMessages.RANGE_ERROR_MESSAGE.equalsIgnoreCase(
        outputData.toString().trim()));
    System.setIn(System.in);
  }

  /**
   * Test case 4: Test case to verify the error message in case of valid numeric but is lower than the lower bound of the datatype.
   */
  @Test
  public void testInvalidLowerBoundInputInitCalculation() {
    SinhFunction sinhFunction = new SinhFunction();
    ByteArrayInputStream input = new ByteArrayInputStream(
        String.valueOf(Double.NEGATIVE_INFINITY).getBytes());
    System.setIn(input);
    sinhFunction.initCalculation();
    Assert.assertTrue(DisplayMessages.RANGE_ERROR_MESSAGE.equalsIgnoreCase(outputData.toString().trim()));
    System.setIn(System.in);
  }

  /**
   * Test case 5: Test case to verify if the function is taking the first 15 significant decimal points if 
   * the user enters valid but more than 15 decimal points.
   */
  @Test
  public void testSignificantDecimalPoints() {
    SinhFunction sinhFunction = new SinhFunction();
    ByteArrayInputStream input = new ByteArrayInputStream(
        "1.111111112222222222222".getBytes());
    System.setIn(input);
    sinhFunction.initCalculation();
    Assert.assertTrue(outputData.toString().trim().contains("1.11111111"));
    Assert.assertFalse(outputData.toString().trim().contains("22222222"));
    System.setIn(System.in);
  }


  /**
   * Test case 6: Test case to verify the calculated value of e is finite or not.
   */
  @Test
  public void testEPowerXFinite() {
    SinhFunction sinhFunction = new SinhFunction();
    double result = sinhFunction.epowerx(2.0);
    Assert.assertEquals(result, 7.389056098930605, 0.0);
    Assert.assertFalse(Double.isNaN(result) && Double.isInfinite(result));
  }

  /**
   * Test case 7: Test case to verify the validity of calculateSinh function.
   */
  @Test
  public void testCalculateSinh() {
    SinhFunction sinhFunction = new SinhFunction();
    double epowerX = sinhFunction.epowerx(3.0);
    double epowerMinusX = sinhFunction.epowerx(-3.0);
    double expectedResult = 10.017874927201463;
    Assert.assertEquals(expectedResult, sinhFunction.calculateSinh(epowerX, epowerMinusX), 0.0);
  }

}
