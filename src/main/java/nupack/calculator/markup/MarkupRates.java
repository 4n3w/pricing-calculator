package nupack.calculator.markup;

import java.math.BigDecimal;

/**
 *
 * Default values; unlikely to change but are override-able in
 * {@link nupack.calculator.Job.JobBuilder#perLabourerRate(Float)} and
 * {@link nupack.calculator.Job.JobBuilder#flatMarkupRate(Float)}.
 *
 * @author awood
 */
public interface MarkupRates {

    BigDecimal PER_LABOURER_RATE = new BigDecimal(.012f);
    BigDecimal FLAT_MARKUP = new BigDecimal(1.05f);

}
