package bilverkstad;

/**
 * Representation of a towedsled vehicle.
 *
 * @author Tomas Perers
 * @version 2016-12-11
 */
public class TowedSled extends Trailers
{
    private int numberOfSkids;

    /**
     * Constructur of the object, creates a towedslef object.
     *
     * @param regNumber String
     * @param brand String
     * @param owner Owner object
     * @param modelYear String
     * @param type String type of vehicle
     */
    public TowedSled(String regNumber, String brand, Owner owner, String modelYear, String type)
    {
        super(regNumber, brand, owner, modelYear, type);
        this.numberOfSkids = 2;
    }

    /**
     * Returns the ammount of skids on the towedsled.
     *
     * @return int with ammount of skids
     */
    public int getNumberOfSkids()
    {
        return numberOfSkids;
    }
}
