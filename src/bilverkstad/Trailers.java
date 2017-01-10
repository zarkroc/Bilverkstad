package bilverkstad;

/**
 * Representation of all trailers
 *
 * @author Tomas Perers
 * @version 2016-12-29
 */
public class Trailers extends Vehicle
{
    private String liftType;

    /**
     * Creates a Trailer object.
     *
     * @param regNumber String registration number
     * @param brand string brand name
     * @param owner Owner object
     * @param modelYear String model year
     * @param type String type of vehicle
     * @param milage Integer with milage of vehicle
     * @param milage Integer with milage of vehicle
     */
    public Trailers(String regNumber, String brand, String owner, String modelYear, String type,int milage)
    {
        super(regNumber, brand, owner, modelYear, type, milage);
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
