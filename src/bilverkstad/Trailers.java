package bilverkstad;

/**
 * Representation of all trailers
 *
 * @author Tomas Perers
 * @version 2016-12-09
 */
public class Trailers extends Vehicle
{
    private String liftType;

    /**
     * Creates a Trailer object.
     *
     * @param regNumber
     * @param brand
     * @param owner
     * @param modelYear
     * @param type
     */
    public Trailers(String regNumber, String brand, String owner, String modelYear, String type)
    {
        super(regNumber, brand, owner, modelYear, type);
        this.liftType = "No lift";
    }

    /**
     * Returns the lift type needed for this type of vehicle
     *
     * @return String with the type of lift needed.
     */
    public String getLiftType()
    {
        return liftType;
    }

}
