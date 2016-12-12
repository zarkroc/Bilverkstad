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
     * @param regNumber
     * @param brand
     * @param owner
     * @param modelYear
     * @param type
     */
    public MotorCycle(String regNumber, String brand, Owner owner, String modelYear, String type)
    {
        super(regNumber, brand, owner, modelYear, type);
        this.tires = 2;
        this.liftType = "No lift";
    }

    /**
     * Returns the ammount of tires.
     *
     * @return int ammount of tires
     */
    public int getTires()
    {
        return tires;
    }

    /**
     * Returns the lift needed for a motorcyle
     *
     * @return String
     */
    public String getLiftType()
    {
        return liftType;
    }

}
