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
 * for service. Also hides the owner name if the brand is Volvo or SAAB.
 * 2016-11-25: Removed the hiding of ownerName, introduced validation of model
 * year 2016-12-11: Updated all prgram to use objects. Rearragned the whole code
 *
 */
public class GarageShop
{
    private static final String DATA_STORAGE = "BilVerkstadData.txt";
    private List<Vehicle> repairObjects;
    private List<Owner> ownerList;

    /**
     * Constructor for the garageshop class. Initializ a new list of vehicles
     */
    public GarageShop()
    {
        repairObjects = new ArrayList<>();
        ownerList = new ArrayList<>();
    }

    /**
     * Register a new Vehicle for repair actions.
     */
    public void registerVehicle()
    {
        String type = (String) JOptionPane.showInputDialog(null, "Vehicle type",
                "Choose the type of vehicle", JOptionPane.QUESTION_MESSAGE, null, new String[]
                {
                    "Car",
                    "MotorCycle",
                    "Truck",
                    "Trailer",
                    "Towedsled"
                }, "Car");
        String regNumber = JOptionPane.showInputDialog("Input registration number");
        String modelYear = JOptionPane.showInputDialog("Input model year");
        // If the input is not a number ask the user for a new input.
        while (true)
        {
            if (modelYear.matches("[0-9]+"))
            {
                break;
            }
            modelYear = JOptionPane.showInputDialog("Input model year \nUse only numbers");
        }
        String brand = JOptionPane.showInputDialog("Input brand name");
        String ownerName = JOptionPane.showInputDialog("Input owner (Name Sirname)");
        Owner owner = new Owner(ownerName);
        Vehicle vehicle = null;
        switch (type)
        {
            case "Car":
                vehicle = new Car(regNumber, brand, owner, modelYear, type);
                break;
            case "MotorCycle":
                vehicle = new MotorCycle(regNumber, brand, owner, modelYear, type);
                break;
            case "Truck":
                vehicle = new Truck(regNumber, brand, owner, modelYear, type);
                break;
            case "Trailer":
                vehicle = new Trailer(regNumber, brand, owner, modelYear, type);
                break;
            case "Towedsled":
                vehicle = new TowedSled(regNumber, brand, owner, modelYear, type);
                break;
        }
        repairObjects.add(vehicle);
        owner.addVehicle(vehicle);
        ownerList.add(owner);
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
     * Returns the list of all owners registerd.
     *
     * @return
     */
    public List getOwnerList()
    {
        return ownerList;
    }

    /**
     * Search for the registration number of a vehicle in the garage shop
     *
     * @param regNumber of the object to search for
     * @return boolean true or false
     */
    public Vehicle searchVehicle(String regNumber)
    {
        for (int i = 0; i < repairObjects.size(); i++)
        {
            if (repairObjects.get(i).getRegNumber().equals(regNumber))
            {
                System.out.println("Car was found:");
                return repairObjects.get(i);
            }
        }
        return null;
    }
}
