package nupack.calculator;

import nupack.calculator.Job.JobBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;
import static nupack.calculator.materials.Materials.ELECTRONICS;
import static nupack.calculator.materials.Materials.materialFor;
import static org.junit.Assert.*;

/**
 * Created by awood on 2016-07-04.
 */
public class JobTest {

    @Test
    public void testBuilderHappyPath(){
        Job job = new JobBuilder().basePrice(new BigDecimal(10.00f)).material("HOCKEY_PUCKS").workers(2).build();
        assertTrue(job.getBasePrice().equals(new BigDecimal(10.00f)));
        assertTrue(job.getWorkers() == 2);
        assertEquals(job.getMaterial(), materialFor("HOCKEY_PUCKS"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void basePriceIsRequired() {
        new JobBuilder().material("OTHER").workers(1).build();
    }

    @Test
    public void getDefaultWorkersIsOne() {
        Job job = new JobBuilder().basePrice(new BigDecimal(99.99f)).material("ELECTRONICS").build();
        assertTrue(job.getWorkers() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void materialsIsRequired() {
        new JobBuilder().basePrice(new BigDecimal(900.21f)).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativePath(){
        new JobBuilder().build();
    }

    @Test
    public void flatMarkupRateBigDecimal(){
        Job job = new JobBuilder().basePrice(10.00f).material("DOG_FOOD").flatMarkupRate(new BigDecimal(.44f)).build();
        assertTrue(job.getFlatMarkup().equals(new BigDecimal(.44f)));
    }

    @Test
    public void flatMarkupRateFloat(){
        Job job = new JobBuilder().basePrice(10.00f).material("FISH_FOOD").flatMarkupRate(.33f).build();
        assertTrue(job.getFlatMarkup().setScale(2, HALF_EVEN).equals(new BigDecimal(".33")));
    }

    @Test
    public void perLabourerRateFloat(){
        Job job = new JobBuilder().basePrice(10.00f).material("DOG_FOOD").perLabourerRate(.44f).build();
        assertTrue(job.getPerLabourerRate().setScale(2, HALF_EVEN).equals(new BigDecimal(".44")));
    }

    @Test
    public void rawEnumForMaterials(){
        Job job = new JobBuilder().basePrice(1800.00f).material(ELECTRONICS).build();
        assertTrue(job.getMaterial().getName().equals("ELECTRONICS"));
    }

}