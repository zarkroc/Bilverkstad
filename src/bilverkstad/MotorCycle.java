package bilverkstad;

/**
 * Representation of a motorcycle object
 *
 * @author Tomas Perers
 * @version 2016-12-09
 */
public class MotorCycle extends Vehicle
{
    private int tires;
    private String liftType;

    /**
     * Creates a motorcycle object.
     *
     * @param regNumber String registration number
     * @param brand string brand name
     * @param owner Owner object
     * @param modelYear String model year
     * @param type String type of vehicle
     */
    public MotorCycle(String regNumber, String brand, String owner, String modelYear, String type)
    {
        super(regNumber, brand, owner, modelYear, type);
        this.tires = 2;
        this.liftType = "No lift";
    }

    /**
     * Returns the amount of tires.
     *
     * @return int amount of tires
     */
    public int getTires()
    {
        return tires;
    }

    /**
     * Returns the lift needed for a motorcycle
     *
     * @return String with lift type needed
     */
    public String getLiftType()
    {
        return liftType;
    }

}
