package bilverkstad;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tomas
 * @version 2016-11-13 Program for garage shop to register cars that comes in
 * for service.
 * Also hides the ownername if the brand is Volvo or Saab.
 */
public class BilVerkstad
{

    private static final int MAX_MILAGE = 40000;
    private static final int MIN_MILAGE = 1500;
    // Values for ascii tables to stay within letters A-Z
    private static final int MAX_ASCII = 122;
    private static final int MIN_ASCII = 97;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        // Declaration of variables used for displaying the date.
        Date date;
        DateFormat df;
        String formattedDate;
        // Temporary storage for Rövarspråket function.
        String done = ""; 
        // A char array with all the consonants
        char consonants[] = "bcdfghjklmnpqrstvwxz".toCharArray();
        // A String for the output message in the box.
        String outputMessage;
        // Define all variables used.
        String serviceLevelMessage;
        int modelYear;
        String brandName;
        String ownerName;
        int milage;
        int repairTime;
        String registerNumber;
        String serviceLevel;
        char[] ownerNameArray;
        // Create an int for ascii codes for random name generation.
        int ascii;
        // Read in todays date and format it according to: Tue Nov 08
        // Format the date.
        date = new Date();
        df = new SimpleDateFormat("EEE LLL dd");
        formattedDate = df.format(date);

        // Make the user input information.
        registerNumber = JOptionPane.showInputDialog("Ange registreringsnummer");
        modelYear = Integer.parseInt(JOptionPane.showInputDialog("Ange årsmodell"));
        brandName = JOptionPane.showInputDialog("Ange märke");
        ownerName = JOptionPane.showInputDialog("Ange ägare (för och efternamn)");
        // Calculate the milage according to a random formula.
        milage = MIN_MILAGE + (int) (Math.random() * ((MAX_MILAGE - MIN_MILAGE) + 1));
        repairTime = milage / 1500;
        
        // Call the function to decide what service level to use.
        serviceLevelMessage = serviceLevel(milage);

        // Make the ownername lowercase and make it into a charArray.
        ownerNameArray = ownerName.toLowerCase().toCharArray();

        // If the brandName is Volvo do something bad with the name. Make it random.
        // But keep it within letters A-Z. i.e within the ascii values.
        // Could be solved with a charArray with all valid letters A-Ö as well.
        if (brandName.toLowerCase().equals("volvo"))
        {
            for (int i = 0; i < ownerNameArray.length; i++)
            {
                if (' ' != ownerNameArray[i])
                {
                    ascii = (int) (Math.random() * (MAX_ASCII - MIN_ASCII + 1) + MIN_ASCII);
                    ownerNameArray[i] = (char) ascii;
                }
            }
        }
        // If the brandName is saab make change it to rövarspråket.
        // add 0 + consonant after a consonant.
        else if (brandName.toLowerCase().equals("saab"))
        {
            for (int i = 0; i < ownerNameArray.length; i++)
            {
                String add = "";
                for (int j = 0; j < consonants.length; j++)
                {
                    if (consonants[j] == ownerNameArray[i])
                    {
                        add = Character.toString(ownerNameArray[i]) + "o" + Character.toString(ownerNameArray[i]);
                        break;
                    }
                    else
                    {
                        add = Character.toString(ownerNameArray[i]);
                    }
                }
                done = done + add;
            }
            ownerNameArray = done.toCharArray();
        }
        // Change the first char in the charArray to an uppercase letter if it is a letter.
        if (Character.isLetter(ownerNameArray[0]) && Character.isLowerCase(ownerNameArray[0]))
        {
            ownerNameArray[0] = Character.toUpperCase(ownerNameArray[0]);
        }
        // Change all chars that are after a space to uppercase.
        for (int i = 1; i < ownerNameArray.length; i++)
        {
            if (ownerNameArray[i] == ' ')
            {
                ownerNameArray[i + 1] = Character.toUpperCase(ownerNameArray[i + 1]);
            }
        }

        // Make the registerNumber to uppercase.
        registerNumber = registerNumber.toUpperCase();
        // Make first char uppercase in string.
        brandName = brandName.substring(0, 1).toUpperCase() + brandName.substring(1);
        ownerName = new String(ownerNameArray);
        
        // Concat the output message.
        outputMessage ="Bil: ";
        outputMessage = outputMessage.concat(brandName).concat(" ").concat(registerNumber).concat("\n")
                .concat("årsmodell: ").concat(Integer.toString(modelYear)).concat("\n")
                .concat("Ägare: ").concat(ownerName).concat("\n")
                .concat("Mätarställning: ").concat(Integer.toString(milage)).concat(" mil \n")
                .concat("Inlämnad: ").concat(formattedDate).concat("\n")
                .concat("Beräknad tid att laga: ").concat(Integer.toString(repairTime)).concat(" dagar \n")
                .concat(serviceLevelMessage).concat(" rekommderas");
        JOptionPane.showMessageDialog(null, outputMessage);
    }
    private static String serviceLevel (int milage)
    {
        // Depending on milage we get different level of service.        
        if (milage > 20000 && milage <= 40000)
        {
            return "En Stor service";
        }
        else if (milage > 8000 && milage <= 20000)
        {
            return "En Medium service";
        }
        else if (milage >= 500 && milage <= 8000)
        {
            return "En Liten service";
        }
        else
        {
            return "Ingen service";
        }
    }
}
