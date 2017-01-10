package bilverkstad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a general vehicle object with all the common things
 *
 * @author Tomas Perers
 * @version 1, 2016-12-07
 * @version 2 2016-12-29
 */
public class Vehicle implements Serializable
{
    private String regNumber, brand, serviceLevel, modelYear, type, owner;
    private int repairTime, milage;
    private long cost;
    private String formattedDate;
    private static final int MAX_MILAGE = 40000;
    private static final int MIN_MILAGE = 1500;

    /**
     * Constructor for the class
     *
     * @param regNumber string with registration number
     * @param brand string with brand name
     * @param owner String holding name
     * @param modelYear String with model year of vehicle
     * @param type String with type of vehicle.
     * @param milage Integer with milage of vehicle.
     */
    public Vehicle(String regNumber, String brand, String owner, String modelYear, String type, int milage)
    {
        this.regNumber = regNumber.toUpperCase();
        this.brand = brand;
        this.owner = owner;
        this.modelYear = modelYear;
        this.milage = milage;
        this.repairTime = milage / 1500;
        this.formattedDate = new SimpleDateFormat("EEE LLL dd").format(new Date());
        this.type = type;
        this.cost = 0;
    }

    /**
     * Returns the milage of the vehicle
     *
     * @return long milage
     */
    public int getMilage()
    {
        return milage;
    }
    /**
     * Returns the cost of all the repairs.
     * @return long with sum of repair cost
     */
    public long getCost() {
        return this.cost;
    }
    /**
     * Sets the repair cost
     * @param cost long with cost of repairs.
     */
    public void addCost(long cost) {
        this.cost += cost;
        System.out.println("Cost to add: " +cost);
    }

    /**
     * Returns the type of the vehicle
     *
     * @return String with type of vehicle
     */
    public String getType()
    {
        return type;
    }

    /**
     * Returns the registration number of the vehicle
     *
     * @return String with registration number
     */
    public String getRegNumber()
    {
        return regNumber;
    }

    /**
     * Returns the brand name
     *
     * @return String with brand name
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Gets the service level for the vehicle based on rules.
     *
     * @return String with the recommended service level
     */
    public String getServiceLevel()
    {
        if (milage > 20000 && milage <= 40000)
        {
            serviceLevel = "En Stor service";
        }
        else if (milage > 8000 && milage <= 20000)
        {
            serviceLevel = "En Medium service";
        }
        else if (milage >= 500 && milage <= 8000)
        {
            serviceLevel = "En Liten service";
        }
        else
        {
            serviceLevel = "Ingen service";
        }
        return serviceLevel;
    }

    /**
     * Returns the owner of the vehicle
     *
     * @return Owner object
     */
    public String getOwner()
    {
        return owner;
    }

    /**
     * Returns the modelyear
     *
     * @return String with modelyear
     */
    public String getModelYear()
    {
        return modelYear;
    }

    /**
     * Returns the repairtime of the vehicle
     *
     * @return int repairtime
     */
    public int getRepairTime()
    {
        return repairTime;
    }

    /**
     * Returns the date of the registration
     *
     * @return String date
     */
    public String getFormattedDate()
    {
        return formattedDate;
    }
}
