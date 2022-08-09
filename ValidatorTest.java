import org.junit.Assert;

import validation.ValidationUtil;

public class ValidatorTest {

  /**
   * Test case 1. When user inputs valid number and values is not with in range of output datatype.
   */
  @org.junit.Test
  public void testValidateInput() {
    double inVal = 2 * Double.MAX_VALUE;
    double inValNeg = -2 * Double.MAX_VALUE;
    Assert.assertFalse(ValidationUtil.validateInput(inValNeg));
    Assert.assertFalse(ValidationUtil.validateInput(inVal));
  }

  /**
   * Test case 2 . when user inputs valid number and values is with in range of datatype.
   * but, the out is more/less than the datatype could store.
   */
  @org.junit.Test
  public void testValidateOutput() {
    Assert.assertFalse(ValidationUtil.validateOutput(Double.POSITIVE_INFINITY));
    Assert.assertFalse(ValidationUtil.validateOutput(Double.NEGATIVE_INFINITY));
  }
}
