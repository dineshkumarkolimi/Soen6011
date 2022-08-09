import org.junit.Assert;

import validation.ValidationUtil;

public class ValidatorTest {

  /**
   * Test case 1. When user inputs valid number and values is not with in range of output datatype.
   */
  @org.junit.Test
  public void testValidateInputRangeInvalidInput() {
    double inputValue = 2 * Double.MAX_VALUE;
    double inputValueNegative = -2 * Double.MAX_VALUE;
    Assert.assertFalse(ValidationUtil.validateInputRange(inputValue));
    Assert.assertFalse(ValidationUtil.validateInputRange(inputValueNegative));
  }

  /**
   * Test case 2 . when user inputs valid number and values is with in range of datatype.
   * but, the out is more/less than the datatype could store.
   */
  @org.junit.Test
  public void testValidateOutputRange() {
    Assert.assertFalse(ValidationUtil.validateOutputRange(Double.NEGATIVE_INFINITY));
    Assert.assertFalse(ValidationUtil.validateOutputRange(Double.POSITIVE_INFINITY));
  }
}