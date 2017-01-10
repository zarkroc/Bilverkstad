package bilverkstad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static bilverkstad.WorkDonePriceEnum.*;

/**
 * Class file to represent an garage shop objects. Stores vehicle objects in a
 * list.
 *
 * @author Tomas Perers
 * @version 2016-11-13 Program for garage shop to register cars that comes in
 * for service. Also hides the mOwner name if the mBrand is Volvo or SAAB.
 * 2016-11-25: Removed the hiding of ownerName, introduced validation of model
 * year 2016-12-11: Updated all program to use objects.
 *
 */
public class GarageShop
{

    private List<Vehicle> repairObjects;
    private List<Vehicle> readyObjects;
    private List<Vehicle> tempTodoyList;
    private List<Vehicle> tempReadyList;
    private String readyFile = "readyVehicles.ser";
    private String todoFile = "todoVehicles.ser";
    private FileStore fileStoreReady;
    private FileStore fileStoreTodo;

    /**
     * Constructor for the garage shop class. Initialize a new list of vehicles
     * Calls methods to read List stored in files.
     */
    public GarageShop()
    {
        repairObjects = new ArrayList<>();
        readyObjects = new ArrayList<>();

        try
        {
            fileStoreReady = new FileStore(readyFile);
        }
        catch (IOException ex)
        {
            Logger.getLogger(GarageShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            fileStoreTodo = new FileStore(todoFile);
        }
        catch (IOException ex)
        {
            Logger.getLogger(GarageShop.class.getName()).log(Level.SEVERE, null, ex);
        }

        tempReadyList = fileStoreReady.readVehiclesFromFile();
        Iterator<Vehicle> tempReadyIterator = tempReadyList.iterator();
        while (tempReadyIterator.hasNext())
        {
            Vehicle m1Vehicle = tempReadyIterator.next();
            readyObjects.add(m1Vehicle);
            System.out.println(m1Vehicle.getRegNumber());
        }
        tempTodoyList = fileStoreTodo.readVehiclesFromFile();
        Iterator<Vehicle> tempTodoIterator = tempTodoyList.iterator();
        while (tempTodoIterator.hasNext())
        {
            Vehicle m2Vehicle = tempTodoIterator.next();
            repairObjects.add(m2Vehicle);
            System.out.println(m2Vehicle.getRegNumber());
        }
    }

    /**
     * Register a new Vehicle for repair actions.
     *
     * @param vehicle to add to List.
     * @throws java.io.IOException
     */
    public void addVehicle(Vehicle vehicle) throws IOException
    {
        repairObjects.add(vehicle);
        fileStoreTodo.writeVehicleToFile(repairObjects);
    }

    /**
     * Removes a vehicle from repairObjects and adds the vehicle to readyObjects
     *
     * @param vehicle Object containing a vehicle that has been repaired.
     */
    public void repair(Vehicle vehicle)
    {
        repairObjects.remove(vehicle);
        readyObjects.add(vehicle);
        fileStoreTodo.writeVehicleToFile(repairObjects);
        fileStoreReady.writeVehicleToFile(readyObjects);
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
     * Returns a list of all vehicles that has been repaired.
     *
     * @return List vehicles that has been repaired.
     */
    public List getReadyObjects()
    {
        return readyObjects;
    }

    /**
     * Checks out and removes a vehicle that has been repaired.
     *
     * @param vehicle to checkout.
     */
    public void checkOut(Vehicle vehicle)
    {
        readyObjects.remove(vehicle);
        fileStoreReady.writeVehicleToFile(readyObjects);
    }

    /**
     * Search for the registration number of a vehicle in the garage shop By
     * calling two other methods
     *
     * @param mRegNumber of the object to search for
     * @return vehicle object or null
     */
    public Vehicle searchVehicle(String mRegNumber)
    {
        Vehicle mVehicle = searchRepair(mRegNumber);
        if (mVehicle != null)
        {
            return mVehicle;
        }
        mVehicle = searchReady(mRegNumber);
        if (mVehicle != null)
        {
            return mVehicle;
        }
        return null;
    }

    /**
     * Search for vehicles on the repair list.
     *
     * @param mRegNumber of the object to search for
     * @return vehicle object or null
     */
    public Vehicle searchRepair(String mRegNumber)
    {
        Iterator<Vehicle> repairIterator = repairObjects.iterator();
        while (repairIterator.hasNext())
        {
            Vehicle mVehicle = repairIterator.next();
            if (mVehicle.getRegNumber().equals(mRegNumber))
            {
                return mVehicle;
            }
        }
        return null;
    }

    /**
     * Search for vehicles on the ready list.
     *
     * @param mRegNumber of the object to search for
     * @return vehicle object or null
     */
    public Vehicle searchReady(String mRegNumber)
    {
        Iterator<Vehicle> readyIterator = readyObjects.iterator();
        while (readyIterator.hasNext())
        {
            Vehicle mVehicle = readyIterator.next();
            if (mVehicle.getRegNumber().equals(mRegNumber))
            {
                return mVehicle;
            }
        }
        return null;
    }

    /**
     * Adds the cost to repair the vehicle.
     *
     * @param mVehicle Vehicle object to perform repairs on.
     * @param mType String with information what repair to perform.
     */
    public void addCost(Vehicle mVehicle, String mType)
    {
        switch (mType)
        {
            case "Premium Service":
                mVehicle.addCost(PREMIUM.price());
                break;
            case "Medium Service":
                mVehicle.addCost(MEDIUM.price());
                break;
            case "Budget Service":
                mVehicle.addCost(BUDGET.price());
                break;
            case "Change Tires":
                mVehicle.addCost(TIRES.price());
                break;
            case "Paint Car":
                mVehicle.addCost(PAINT.price());
                break;
        }
        fileStoreReady.writeVehicleToFile(readyObjects);
        fileStoreTodo.writeVehicleToFile(repairObjects);
    }
}
