package bilverkstad;

/**
 * A representation of a car object
 *
 * @author Tomas Perers
 * @version 2017-01-10
 */
public class Car extends Vehicle
{

    private int tires;
    private int doors;
    private String liftType;
    private double height;

    /**
     * Creates a car object.
     *
     * @param regNumber String with registration number of Car
     * @param brand String with brand name of Car
     * @param owner String with name of owner
     * @param modelYear String with year of the model
     * @param type String with type of car
     * @param milage Integer with milage of vehicle
     */
    public Car(String regNumber, String brand, String owner, String modelYear, String type, int milage)
    {
        super(regNumber, brand, owner, modelYear, type, milage);
        this.tires = 4;
        this.doors = 4;
        this.liftType = "Light lift";
        this.height = 1.5;
    }

    /**
     * Returns the number of tires on the car.
     *
     * @return int amount of tires
     */
    public int getTires()
    {
        return tires;
    }

    /**
     * Returns the number of doors on the car
     *
     * @return int containing the amount of doors on the vehicle
     */
    public int getDoors()
    {
        return doors;
    }

    /**
     * Returns the lift type needed for a car
     *
     * @return String liftType used for lifting the vehicle
     */
    public String getLiftType()
    {
        return liftType;
    }

    /**
     * Returns the height of the car
     *
     * @return int height of the car
     */
    public double getHeight()
    {
        return height;
    }
}
