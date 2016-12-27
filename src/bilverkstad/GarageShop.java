package bilverkstad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class file to represent an garageshop objects. Stores vehicle objects in a
 * list.
 *
 * @author Tomas Perers
 * @version 2016-11-13 Program for garage shop to register cars that comes in
 for service. Also hides the mOwner name if the mBrand is Volvo or SAAB.
 2016-11-25: Removed the hiding of ownerName, introduced validation of model
 year 2016-12-11: Updated all program to use objects. 
 *
 */
public class GarageShop
{
    private List<Vehicle> repairObjects;
    
    /**
     * Constructor for the garageshop class. Initialize a new list of vehicles
     */
    public GarageShop()
    {
        repairObjects = new ArrayList<>();
    }

    /**
     * Register a new Vehicle for repair actions.
     */
    public void addVehicle(Vehicle vehicle)
    {
        repairObjects.add(vehicle);        
    }

    /**
     * Returns a List of all vehicles registered for repairs.
     *
     * @return List vehicles under repair
     */
    public List getRepairObjects()
    {
        return repairObjects;
    }

    /**
     * Search for the registration number of a vehicle in the garage shop
     *
     * @param mRegNumber of the object to search for
     * @return boolean true or false
     */
    public Vehicle searchVehicle(String mRegNumber)
    {
        for (int i = 0; i < repairObjects.size(); i++)
        {
            if (repairObjects.get(i).getRegNumber().equals(mRegNumber))
            {
                System.out.println("Car was found:");
                return repairObjects.get(i);
            }
        }
        return null;
    }
}
