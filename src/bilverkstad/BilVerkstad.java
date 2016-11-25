package bilVerkstad;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author tomas
 * @version 2016-11-13 Program for garage shop to register cars that comes in
 *          for service.
 *          Also hides the owner name if the brand is Volvo or SAAB.
 *          2016-11-25: Removed the hiding of ownerName, introduced validation 
 *          of model year
 */
public class BilVerkstad {

    private static final int MAX_MILAGE = 40000;
    private static final int MIN_MILAGE = 1500;
    // Values for ascii tables to stay within letters A-Z
    private static final int MAX_ASCII = 122;
    private static final int MIN_ASCII = 97;
    // Variable for the file that will be used for storing data.
    private String FilePath = "BilVerkstadData.txt";
    // Read in todays date and format it according to: Tue Nov 08
    private static String formattedDate = new SimpleDateFormat("EEE LLL dd").format(new Date());

    /**
     * Main method of the program.
     * Currently handles all the input from the user.
     * Used to register cars.
     * TODO: Would like to split this into a car object later on.
     *      And split up the input and formatting better.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BilVerkstad verkstad = new BilVerkstad();
       
        // A String for the output message in the box.
        String outputMessage;
        // Define all variables used.
        String serviceLevelMessage;
        String modelYear;
        String brandName;
        String ownerName;
        int milage;
        int repairTime;
        String registerNumber;
        boolean startLoop;
        int start = JOptionPane.showConfirmDialog(null, "Registrera en bil?"
                , "Registrera bil eller se resultat", JOptionPane.YES_NO_OPTION);
        startLoop = start != JOptionPane.NO_OPTION;
        
        // Ask the user to input information.
        while (startLoop)
        {       
            registerNumber = JOptionPane.showInputDialog("Ange registreringsnummer");
            modelYear = JOptionPane.showInputDialog("Ange årsmodell");
            // If the input is not a number ask the user for a new input.
            while (true)
            {                
                if (modelYear.matches("[0-9]+"))
                    break;
                modelYear = JOptionPane.showInputDialog("Ange årsmodell \nAnvänd bara siffror");
                
            }
            brandName = JOptionPane.showInputDialog("Ange märke");
            ownerName = JOptionPane.showInputDialog("Ange ägare (för och efternamn)");
            // Calculate the milage according to a random formula.
            milage = MIN_MILAGE + (int) (Math.random() * ((MAX_MILAGE - MIN_MILAGE) + 1));
            repairTime = milage / 1500;

            // Call the function to decide what service level to use.
            serviceLevelMessage = verkstad.serviceLevel(milage);

            // Make the first char in each word a capital char.
            ownerName = verkstad.capitalizeName(ownerName);

            // Make the registerNumber to uppercase.
            registerNumber = registerNumber.toUpperCase();
            // Make first char uppercase in string.
            brandName = brandName.substring(0, 1).toUpperCase() + brandName.substring(1);

            // Concat the output message.
            outputMessage = brandName.concat(";")
                .concat(registerNumber).concat(";")
                .concat(modelYear).concat(";")
                .concat(ownerName).concat(";")
                .concat(Integer.toString(milage)).concat(";")
                .concat(formattedDate).concat(";")
                .concat(Integer.toString(repairTime)).concat(";")
                .concat(serviceLevelMessage);
            // Write the output to a file.
            verkstad.writeCarsToFile(outputMessage);
            
            // Ask the user if more input should be done.
            int reply = JOptionPane.showConfirmDialog(null, "Registrera en till bil?", "Registrera bil", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION)
            {
                break;
            }
        }
        
        // Read from a file and print out result.
        String message = verkstad.readCarsFromFile();
        verkstad.printMessage(message);

    }
    /**
     * Format the output message that will be shown to the user.
     * @param input
     * @return string with formated data.
     */
    private String formatOutput(String input) {
        String []parts = input.split(";");
        String brand = parts[0];
        String regNum = parts[1];
        String modelYear = parts[2];
        String ownerName = parts[3];
        String milage = parts[4];
        String date = parts[5];
        String repairTime = parts[6];
        String serviceLevelMessage = parts[7];     
        String output = "Bil: ".concat(brand).concat(" ").concat(regNum).concat("\n")
                .concat("Årsmodell: ").concat(modelYear).concat("\n")
                .concat("Ägare: ").concat(ownerName).concat("\n")
                .concat("Mätarställning: ").concat(milage).concat(" mil \n")
                .concat("Inlämnad: ").concat(date).concat("\n")
                .concat("Beräknad tid att laga: ").concat(repairTime).concat(" dagar \n")
                .concat(serviceLevelMessage).concat(" rekommderas").concat("\n");
        return output;
    }

    /**
     * Method to calculate what service level should be used depending on the milage on the car.
     *
     * @param milage
     * @return String with service level that should be used.
     */
    private String serviceLevel(int milage) {
        // Depending on milage we get different level of service.
        if (milage > 20000 && milage <= 40000) {
            return "En Stor service";
        } else if (milage > 8000 && milage <= 20000) {
            return "En Medium service";
        } else if (milage >= 500 && milage <= 8000) {
            return "En Liten service";
        } else {
            return "Ingen service";
        }
    }

    /**
     * Method to print a message in a box.
     *
     * @param outputMessage
     */
    private void printMessage(String outputMessage) {
        JOptionPane.showMessageDialog(null, outputMessage);
    }

    /**
     * Method to capitalize the first char in a string.
     *
     * @param name
     * @return string with the first letter in each word Capitalized.
     */
    private String capitalizeName(String name) {
        //Make the strign lowercase anc create a charArray.
        char[] nameCharArray = name.toLowerCase().toCharArray();

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
        name = new String(nameCharArray);
        return name;
    }
    /**
     * Method to read information from a file.
     * @return string with formatted information to present for the user.
     */
    private String readCarsFromFile() {
        String allCarsInFile = "";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(FilePath));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Kunde inte hitta filen! " +FilePath);
            e.printStackTrace();
        }
        // Read each line and call a function to format the output.
        while (sc.hasNextLine()) {
            allCarsInFile = allCarsInFile.concat(this.formatOutput(sc.nextLine()).concat("\n"));
        }
        sc.close();
        return allCarsInFile;
    }
    /**
     * Method to write the input string to a file.
     * @param input 
     */
    private void writeCarsToFile(String input) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FilePath, true)))) {
            out.println(input);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
