package bilverkstad;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a general vehicle object with all the common things
 *
 * @author Tomas Perers
 * @version 1, 2016-12-07
 */
public class Vehicle
{
    private String regNumber, brand, serviceLevel, modelYear, type;
    private Owner owner;
    private int repairTime, milage;
    private String formattedDate;
    private static final int MAX_MILAGE = 40000;
    private static final int MIN_MILAGE = 1500;

    /**
     * Constructur for the class
     *
     * @param regNumber string with registration number
     * @param brand string with brand name
     * @param owner Owner object holding name
     * @param modelYear String with model year of vehicle
     * @param type String with type of vehicle.
     */
    public Vehicle(String regNumber, String brand, Owner owner, String modelYear, String type)
    {
        this.regNumber = regNumber.toUpperCase();
        this.brand = brand;
        this.owner = owner;
        this.modelYear = modelYear;
        this.milage = MIN_MILAGE + (int) (Math.random() * ((MAX_MILAGE - MIN_MILAGE) + 1));
        this.repairTime = milage / 1500;
        this.formattedDate = new SimpleDateFormat("EEE LLL dd").format(new Date());
        this.type = type;
    }

    /**
     * Returns the milage of the vehicle
     *
     * @return int milage
     */
    public int getMilage()
    {
        return milage;
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
     * @return String with registrationnumber
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
    public Owner getOwner()
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
