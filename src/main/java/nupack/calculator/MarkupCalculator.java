package nupack.calculator;

import nupack.calculator.materials.Material;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 *
 *
 * @author awood
 */
public class MarkupCalculator {

    public static BigDecimal calculateCost(Job job){
        return new MarkupCalculator().calculateCost(
                job.getBasePrice(),
                job.getWorkers(),
                job.getMaterial(),
                job.getPerLabourerRate(),
                job.getFlatMarkup()
        );
    }

    private
    BigDecimal calculateCost(BigDecimal baseprice,
                             Integer workers,
                             Material material,
                             BigDecimal perLabourerRate,
                             BigDecimal flatMarkup){

        BigDecimal flat_price = baseprice.multiply(flatMarkup);
        BigDecimal labour = flat_price.multiply( perLabourerRate.multiply(BigDecimal.valueOf(workers)));
        BigDecimal materialsCost = flat_price.multiply(BigDecimal.valueOf(material.getPercentage()));

        return flat_price.add(labour.add(materialsCost))
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
