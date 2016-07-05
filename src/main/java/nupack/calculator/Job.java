package nupack.calculator;

import nupack.calculator.markup.MarkupRates;
import nupack.calculator.materials.Material;
import nupack.calculator.materials.Materials;
import nupack.calculator.validator.Validate;

import java.math.BigDecimal;

import static nupack.calculator.materials.Materials.materialFor;

/**
 * Model representing a given "Job".
 *
 * Contains a Builder to help with creating {@link Job} instances with ease.
 *
 * @author awood
 */
public class Job {

    private final BigDecimal basePrice;
    private final Integer workers;
    private final Material material;

    private final BigDecimal perLabourerRate;
    private final BigDecimal flatMarkup;

    private Job(BigDecimal basePrice, Integer workers, Material material, BigDecimal perLabourerRate, BigDecimal flatMarkupRate){

        Validate.greaterThanZero(basePrice, "The basePrice");
        Validate.greaterThanZero(perLabourerRate, "The per labourer rate");
        Validate.greaterThanZero(flatMarkupRate, "The markup rate");
        Validate.greaterThanZero(workers, "Number of workers");
        Validate.notNull(material, "The material");

        this.basePrice = basePrice;
        this.workers = workers;
        this.material = material;
        this.perLabourerRate = perLabourerRate;
        this.flatMarkup = flatMarkupRate;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public Integer getWorkers() {
        return workers;
    }

    public Material getMaterial() {
        return material;
    }

    public BigDecimal getPerLabourerRate() {
        return perLabourerRate;
    }

    public BigDecimal getFlatMarkup() {
        return flatMarkup;
    }

    interface Builder<T>{
        T build();
    }

    /**
     * Builder/Fluent API Style builder.
     *
     * Example:
     * <pre>
     *     {@code
     *      Job job = new JobBuilder().basePrice(new BigDecimal(25.00f)).material("SILVER_BULLION").workers(20).build();
     *     }
     * </pre>
     *
     */
    public static class JobBuilder implements Builder<Job> {

        private BigDecimal basePrice;
        private Integer workers = 1;
        private Material material;

        private BigDecimal perLabourerRate = MarkupRates.PER_LABOURER_RATE;
        private BigDecimal flatMarkupRate = MarkupRates.FLAT_MARKUP;

        public JobBuilder basePrice(final BigDecimal basePrice){
            this.basePrice = basePrice;
            return this;
        }

        public JobBuilder basePrice(final Float basePrice){
            this.basePrice = BigDecimal.valueOf(basePrice);
            return this;
        }

        public JobBuilder workers(final Integer workers){
            this.workers = workers;
            return this;
        }

        public JobBuilder material(final Materials materials){ //Raw enum
            this.material = materials;
            return this;
        }

        public JobBuilder material(final String material){
            this.material = materialFor(material);
            return this;
        }

        /**
         * Method used to override the default flat markup rate.
         *
         * @param flatMarkupRate The new flat rate
         * @return JobBuilder
         */
        public JobBuilder flatMarkupRate(final Float flatMarkupRate){
            this.flatMarkupRate = BigDecimal.valueOf(flatMarkupRate);
            return this;
        }

        public JobBuilder flatMarkupRate(final BigDecimal flatMarkupRate){
            this.flatMarkupRate = flatMarkupRate;
            return this;
        }

        /**
         * Method used to over-ride the default per-worker labour rate.
         *
         * @param perLabourerRate The new percentage
         * @return JobBuilder
         */
        public JobBuilder perLabourerRate(final Float perLabourerRate){
            this.perLabourerRate = BigDecimal.valueOf(perLabourerRate);
            return this;
        }

        public Job build(){
            return new Job(this.basePrice, this.workers, this.material, this.perLabourerRate, this.flatMarkupRate);
        }
    }

}
