package nupack.calculator.markup;

import nupack.calculator.Job;
import static nupack.calculator.Job.JobBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static nupack.calculator.MarkupCalculator.calculateCost;
import static org.junit.Assert.*;

/**
 * Created by awood on 2016-07-04.
 */
public class MarkupCalculatorTest {


    @Test
    public void calculateExampleOne(){
        Job job = new JobBuilder().basePrice(1299.99f).workers(3).material("FOOD").build();

        BigDecimal expected = new BigDecimal("1591.58");
        BigDecimal actual = calculateCost(job);

        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    public void calculateCostExampleTwo() {
        Job job = new JobBuilder().basePrice(5432f).material("PHARMACEUTICALS").build();
        BigDecimal actual = calculateCost(job);
        BigDecimal expected = new BigDecimal("6199.81");

        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    public void calculateCostExampleThree() {
        Job job = new JobBuilder().basePrice(12456.95f).workers(4).material("BOOKS").build();
        BigDecimal actual = calculateCost(job);
        BigDecimal expected = new BigDecimal("13707.63");

        assertEquals(0, actual.compareTo(expected));
    }


}