package nupack.calculator;

import nupack.calculator.validator.Validate;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by awood on 2016-07-04.
 */
public class ValidateTest {

    @Test
    public void testConstructorPrivate() throws Exception {
        Validate v = new Validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void notNullWithNullThrowsIllegalArgumentException() {
        Validate.notNull(null, "Test");
    }

    @Test
    public void notNull() {
        Validate.notNull("Dummy", "Test");
    }

    @Test
    public void greaterThanZeroBigDecimal() {
        Validate.greaterThanZero(new BigDecimal("21.12"), "Test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanZeroBigDecimalWithZeroThrowsIllegalArgumentException() {
        Validate.greaterThanZero(new BigDecimal("0"), "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanZeroBigDecimalWithLessThanZeroThrowsIllegalArgumentException() {
        Validate.greaterThanZero(new BigDecimal("-231.12"), "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanZeroWithNullBigDecimal(){
        BigDecimal bigDecimal = null;
        Validate.greaterThanZero(bigDecimal, "test");
    }

    @Test
    public void greaterThanZeroInteger() {
        Validate.greaterThanZero(1, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanZeroIntegerWithNegativeIntegerThrowsIllegalArgumentException() {
        Validate.greaterThanZero(-1, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanZeroIntegerWithZeroThrowsIllegalArgumentException() {
        Validate.greaterThanZero(0, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanZeroWithNullInteger(){
        Integer i = null;
        Validate.greaterThanZero(i, "test");
    }

}