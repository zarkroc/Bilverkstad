package bilverkstad;

/**
 * Representation of a truck object
 *
 * @author Tomas Perers
 * @version 2016-12-09
 */
public class Truck extends Vehicle
{
    private int tires;
    private int doors;
    private String liftType;
    private double height;

    /**
     * Create a truck object
     *
     * @param regNumber String registration number
     * @param brand String brand name
     * @param modelYear String for model year
     * @param owner Owner object
     * @param type String type of vehicle.
     */
    public Truck(String regNumber, String brand, String owner, String modelYear, String type)
    {
        super(regNumber, brand, owner, modelYear, type);
        this.tires = 6;
        this.doors = 2;
        this.liftType = "Heavy lift";
        this.height = 3.5;
    }

    /**
     * get number of tires on the truck
     *
     * @return int with number of tires
     */
    public int getTires()
    {
        return tires;
    }

    /**
     * Returns the number of doors on the truck
     *
     * @return int with number of doors
     */
    public int getDoors()
    {
        return doors;
    }

    /**
     * Returns the lift type needed for the vehicle
     *
     * @return String lift type.
     */
    public String getLiftType()
    {
        return liftType;
    }

    /**
     * Returns the height of the vehicle
     *
     * @return double height
     */
    public double getHeight()
    {
        return height;
    }
}
