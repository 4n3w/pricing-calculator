/**
 *
 * NuPack Pricing Calculator.
 *
 * Calculating a job at NuPack requires two things:
 *  1) a properly configured {@link nupack.calculator.Job}
 *  2) a call to {@link nupack.calculator.MarkupCalculator#calculateCost(nupack.calculator.Job)}
 *
 *  You can configure your job with the builder for Jobs:
 *
 *  <pre>
 *      {@code
 *      Job job = new JobBuilder().basePrice(new BigDecimal(25.00f))
 *                      .material("SILVER_BULLION")
 *                      .workers(20).build();
 *      }
 *  </pre>
 *
 *  And call the calculator with
 *
 *  <pre>
 *      {@code
 *      BigDecimal totalcost = MarkupCalculator.calculateCost(job);
 *      }
 *  </pre>
 *
 * @author awood.
 */
package nupack.calculator;