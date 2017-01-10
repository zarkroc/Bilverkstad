package bilverkstad;

/**
 * Representation of the Trailer type
 *
 * @author Tomas Perers
 * @version 2016-12-29
 */
public class Trailer extends Trailers
{
    private int tires;

    /**
     * constructor for the trailer object
     *
     * @param regNumber String registration number
     * @param brand string brand name
     * @param owner Owner object
     * @param modelYear String model year
     * @param type String type of vehicle
     * @param milage Integer with milage of vehicle
     */
    public Trailer(String regNumber, String brand, String owner, String modelYear, String type, int milage)
    {
        super(regNumber, brand, owner, modelYear, type, milage);
        this.tires = 2;
    }

    /**
     * Returns the number of tires on the trailer
     *
     * @return int amount of tires.
     */
    public int getTires()
    {
        return tires;
    }

}
