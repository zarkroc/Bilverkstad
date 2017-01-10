package bilverkstad;

/**
 * Representation of a towed sled vehicle.
 *
 * @author Tomas Perers
 * @version 2016-12-29
 */
public class TowedSled extends Trailers
{

    private int numberOfSkids;

    /**
     * constructor of the object, creates a towed sled object.
     *
     * @param regNumber String
     * @param brand String
     * @param owner Owner object
     * @param modelYear String
     * @param type String type of vehicle
     * @param milage Integer with milage of vehicle
     */
    public TowedSled(String regNumber, String brand, String owner, String modelYear, String type, int milage)
    {
        super(regNumber, brand, owner, modelYear, type, milage);
        this.numberOfSkids = 2;
    }

    /**
     * Returns the amount of skids on the towed sled.
     *
     * @return int with amount of skids
     */
    public int getNumberOfSkids()
    {
        return numberOfSkids;
    }
}
