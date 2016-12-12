package bilverkstad;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * Program to register vehicles for repairs in a garageshop program also lists
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
            garage.registerVehicle();
            int reply = JOptionPane.showConfirmDialog(null, "Register another vehicle?",
                    "Register vehicle", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION)
            {
                break;
            }
        }
        List<Vehicle> repairObjects = garage.getRepairObjects();
        System.out.println("Vehicles registered in the garage");
        for (int i = 0; i < repairObjects.size(); i++)
        {
            printRepairObjects(repairObjects.get(i));
        }

        while (true)
        {
            String regNumber = JOptionPane.showInputDialog("Input registration number to earch for");
            Vehicle vehicle = garage.searchVehicle(regNumber.toUpperCase());
            if (vehicle != null)
            {
                printRepairObjects(vehicle);
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

        List<Owner> ownerList = garage.getOwnerList();
        System.out.println("\nOwners registered in the garage");
        for (int i = 0; i < ownerList.size(); i++)
        {
            System.out.println(ownerList.get(i).getName());
            System.out.println("Owns the current cars:");
            for (int j = 0; j < ownerList.get(i).getVehicle().size(); j++)
            {
                System.out.println(ownerList.get(i).getVehicle().get(j).getRegNumber());
            }
        }
    }

    /**
     * Prints one vehicles registered for repair
     *
     * @param vehicle to print.
     */
    private static void printRepairObjects(Vehicle vehicle)
    {
        System.out.println("--------------------------");
        System.out.println(vehicle.getType() + ": " + vehicle.getBrand() + " " + vehicle.getRegNumber());
        System.out.println("Year model: " + vehicle.getModelYear());
        System.out.println("Owner: " + vehicle.getOwner().getName());
        System.out.println("Milage: " + vehicle.getMilage() + " miles");
        System.out.println("Handed in: " + vehicle.getFormattedDate());
        System.out.println("Repair time: " + vehicle.getRepairTime() + " days");
        System.out.println(vehicle.getServiceLevel() + " is recommeded");
    }
}
