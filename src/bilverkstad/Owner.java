package bilverkstad;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of the owner of a vehicle
 * @author Tomas Perers
 * @version 2016-12-10
 */
public class Owner {
    private String name;
    private List<Vehicle> vehicles = new ArrayList<>();
    
    /**
     * Constructor for the owner
     * @param name String name of the owner
     */
    public Owner (String name) {
        //Make the strign lowercase anc create a charArray.
        this.name = name.trim();
        char[] nameCharArray = this.name.toLowerCase().toCharArray();

        // Change the first char in the charArray to an uppercase letter if it is a letter.
        if (Character.isLetter(nameCharArray[0]) && Character.isLowerCase(nameCharArray[0])) {
            nameCharArray[0] = Character.toUpperCase(nameCharArray[0]);
        }
        // Change all chars that are after a space to uppercase.
        for (int i = 1; i < nameCharArray.length; i++) {
            if (nameCharArray[i] == ' ') {
                nameCharArray[i + 1] = Character.toUpperCase(nameCharArray[i + 1]);
            }
        }
        this.name = new String(nameCharArray);       
    }
    
    /**
     * Returns the name of the owner
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * List the vehicles owned by
     * @return List of vehicles
     */
    public List<Vehicle> getVehicle() {
        return vehicles;
    }
    /**
     * Add a new vehicle to the list of owned vehicles.
     * @param vehicle 
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
}
