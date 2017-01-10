package bilverkstad;

/**
 * Enum for price information of work that can be done on a Vehicle
 * @author Tomas Perers
 * @version 2016-12-29
 */
public enum WorkDonePriceEnum {
    PREMIUM("Premium Service", 1500),
    MEDIUM("Medium Service", 1000),
    BUDGET("Budget Service", 800),
    PAINT("Paint Car", 8000),
    TIRES("Change Tires", 500);

    private final String description;
    private final long price;

    WorkDonePriceEnum(String description, long price) {
        this.description = description;
        this.price = price;
    }
    
    /**
     * Returns the description
     * @return String description
     */
    public String description() {
        return description;
    }
    
    /**
     * Returns the price
     * @return long price
     */
    public long price() {
        return price;
    }

    /**
     * Overrides the toString method
     * @return String description
     */
    @Override
    public String toString() {
        return description;
    }
}
