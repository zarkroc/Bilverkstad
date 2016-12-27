package bilverkstad;

/**
 * Representation of a towed sled vehicle.
 *
 * @author Tomas Perers
 * @version 2016-12-11
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
     */
    public TowedSled(String regNumber, String brand, String owner, String modelYear, String type)
    {
        super(regNumber, brand, owner, modelYear, type);
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
