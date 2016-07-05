package nupack.calculator.validator;

import java.math.BigDecimal;

/**
 * Internal class; written in lieu of using third party libraries like Apache Commons's Validate.
 *
 * @author awood
 */
public class Validate {

    public Validate(){}

    static public void notNull(Object object, String reason) throws IllegalArgumentException {
        if(object == null)
            throw new IllegalArgumentException(reason + " cannot be null");
    }

    static public void greaterThanZero(Integer i, String reason) throws IllegalArgumentException {
        notNull(i, reason);
        if(i <= 0)
            throw new IllegalArgumentException(reason + " cannot be zero or less");
    }

    static public void greaterThanZero(BigDecimal bigDecimal, String reason) throws IllegalArgumentException {
        notNull(bigDecimal, reason);
        if(bigDecimal.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException(reason + " cannot be zero or less");
    }

}
