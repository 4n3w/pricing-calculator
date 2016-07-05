package nupack.calculator.materials;

import nupack.calculator.validator.Validate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * Enum representing known Materials and their markup percentages.
 *
 * Note the use of Factory methods {@link #materialFor(String)} and {@link #materialFor(String, Float)}; these methods
 * can be used to a) find the known {@link Material} enumerations; and b) add new {@link Material} instances at runtime.
 *
 * Unknown / "Other" material types are generally assumed to have a percentage rate of 0; but using these factory
 * methods allows for the enum to have new {@link Material} implementations that differ from that assumption.
 *
 * @author awood
 */
public enum Materials implements Material {

    PHARMACEUTICALS(.075f),
    FOOD(.13f),
    ELECTRONICS(.02f);

    private Float percentage;

    Materials(Float percentage) {
        this.percentage = percentage;
    }

    public Float getPercentage() {
        return percentage;
    }

    private static final ConcurrentMap<String, Material> materials = new ConcurrentHashMap<String, Material>();

    /**
     *
     * Use this method to get the {@link Material} from the list of known materials; or transparently add new
     * {@link Material}s with a default markup percentage of 0%.
     *
     * @param name The name for the enumeration to be found/added; newly created names will have a default
     *             percentage of 0
     * @return {@link Material} The material in question.
     */
    public static Material materialFor(final String name) {
        Validate.notNull(name, "name");
        initializeMaterialsMap();
        materials.putIfAbsent(name.toUpperCase(), new Material() {
            public String getName() {
                return name.toUpperCase();
            }

            public Float getPercentage() {
                return 0f; /* Default percentage is zero */
            }
        });
        return materials.get(name.toUpperCase());
    }

    /**
     * Use this method to find existing {@link Material}s and to add new {@link Material} instances with any percentage
     * rate desired.
     *
     * @param name The name for the enumeration to be found/added; newly created names will have a default
     *             percentage of 0
     * @param percentage The markup percentage to use for the provided name
     * @return {@link Material} The material in question.
     */
    public static Material materialFor(final String name, final Float percentage) {
        Validate.notNull(percentage, "percentage");
        Validate.notNull(name, "name");
        initializeMaterialsMap();
        materials.put(name.toUpperCase(), new Material() {
            public String getName() {
                return name.toUpperCase();
            }

            public Float getPercentage() {
                return percentage;
            }
        });
        return materials.get(name.toUpperCase());
    }

    private static void initializeMaterialsMap() {
        if (materials.isEmpty()) {
            for (Material material : values())
                materials.putIfAbsent(material.getName(), material);
        }
    }

    public String getName() {
        return name();
    }
}
