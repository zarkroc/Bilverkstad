package bilverkstad;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * Program to register vehicles for repairs in a garage shop program also lists
 * and search for vehicles
 *
 * @author Tomas Perers
 * @version 1 2016-12-11
 */
public class Gui
{

    /**
     * Creates a number of message boxes for the user to input information to
     * register vehicles etc. Also lists and search registered vehicles.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        GarageShop garage = new GarageShop();

        while (true)
        {
            registerVehicle(garage);
            int reply = JOptionPane.showConfirmDialog(null, "Register another vehicle?",
                    "Register vehicle", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION)
            {
                break;
            }
        }

        printRegisteredVehicles(garage);
        
        while (true)
        {
            String regNumber = JOptionPane.showInputDialog("Input registration number to earch for");
            Vehicle vehicle = garage.searchVehicle(regNumber.toUpperCase());
            if (vehicle != null)
            {
                printFormatting(vehicle);
            }
            else
            {
                System.out.println("Car was not found");
            }

            int reply = JOptionPane.showConfirmDialog(null, "search for another vehicle?",
                    "Search vehicle", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION)
            {
                break;
            }
        }
     }
    /**
     * Prints all vehicles registered for repairs by calling a formatting method.
     * @param garage GarageShop object where vehicles are registered.
     */
    private static void printRegisteredVehicles(GarageShop garage)
    {
        List<Vehicle> repairObjects = garage.getRepairObjects();
        System.out.println("Vehicles registered in the garage");
        for (int i = 0; i < repairObjects.size(); i++)
        {
            printFormatting(repairObjects.get(i));
        }
    }

    /**
     * Prints one vehicles registered for repair
     *
     * @param vehicle to print.
     */
    private static void printFormatting(Vehicle vehicle)
    {
        System.out.println("--------------------------");
        System.out.println(vehicle.getType() + ": " + vehicle.getBrand() + " " + vehicle.getRegNumber());
        System.out.println("Year model: " + vehicle.getModelYear());
        System.out.println("Owner: " + vehicle.getOwner());
        System.out.println("Milage: " + vehicle.getMilage() + " miles");
        System.out.println("Handed in: " + vehicle.getFormattedDate());
        System.out.println("Repair time: " + vehicle.getRepairTime() + " days");
        System.out.println(vehicle.getServiceLevel() + " is recommeded");
    }
    
    /**
     * Register a new Vehicle for repair actions.
     */
    private static void registerVehicle(GarageShop garage)
    {
        String mType = (String) JOptionPane.showInputDialog(null, "Vehicle type",
                "Choose the type of vehicle", JOptionPane.QUESTION_MESSAGE, null, new String[]
                {
                    "Car",
                    "MotorCycle",
                    "Truck",
                    "Trailer",
                    "Towedsled"
                }, "Car");
        String mRegNumber = JOptionPane.showInputDialog("Input registration number");
        String mModelYear = JOptionPane.showInputDialog("Input model year");
        // If the input is not a number ask the user for a new input.
        while (true)
        {
            if (mModelYear.matches("[0-9]+"))
            {
                break;
            }
            mModelYear = JOptionPane.showInputDialog("Input model year \nUse only numbers");
        }
        String mBrand = JOptionPane.showInputDialog("Input brand name");
        String mOwner = JOptionPane.showInputDialog("Input owner (Name Sirname)");
        Vehicle mVehicle = null;
        switch (mType)
        {
            case "Car":
                mVehicle = new Car(mRegNumber, mBrand, mOwner, mModelYear, mType);
                break;
            case "MotorCycle":
                mVehicle = new MotorCycle(mRegNumber, mBrand, mOwner, mModelYear, mType);
                break;
            case "Truck":
                mVehicle = new Truck(mRegNumber, mBrand, mOwner, mModelYear, mType);
                break;
            case "Trailer":
                mVehicle = new Trailer(mRegNumber, mBrand, mOwner, mModelYear, mType);
                break;
            case "Towedsled":
                mVehicle = new TowedSled(mRegNumber, mBrand, mOwner, mModelYear, mType);
                break;
        }
        garage.addVehicle(mVehicle);
    }
}
