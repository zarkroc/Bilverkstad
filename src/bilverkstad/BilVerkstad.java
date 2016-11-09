package bilverkstad;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tomas
 * @version 2016-11-09 Program for garage shop to register cars that comes in
 * for service.
 */
public class BilVerkstad
{

    private static final int MAX_MILAGE = 40000;
    private static final int MIN_MILAGE = 1500;
    private static final int MAX_ASCII = 122;
    private static final int MIN_ASCII = 97;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        // Declaration of variables used.
        Date date;
        DateFormat df;
        String formattedDate;
        String done = ""; // Temporary storage for Rövarspråket function.
        // A char array with all the consonants
        char consonants[] = "bcdfghjklmnpqrstvwxz".toCharArray();
        String outputMessage;

        // Read in todays date and format it according to: Tue Nov 08
        date = new Date();
        int modelYear;
        String brandName;
        String ownerName;
        int milage;
        int repairTime;
        String registerNumber;
        String serviceLevel;
        char[] ownerNameArray;
        int ascii;

        df = new SimpleDateFormat("EEE LLL dd");
        formattedDate = df.format(date);

        registerNumber = JOptionPane.showInputDialog("Ange registreringsnummer");
        modelYear = Integer.parseInt(JOptionPane.showInputDialog("Ange årsmodell"));
        brandName = JOptionPane.showInputDialog("Ange märke");
        ownerName = JOptionPane.showInputDialog("Ange ägare (för och efternamn)");
        milage = MIN_MILAGE + (int) (Math.random() * ((MAX_MILAGE - MIN_MILAGE) + 1));
        repairTime = milage / 1500;

        if (milage > 20000)
        {
            serviceLevel = "En Stor service";
        }
        else if (milage > 8000)
        {
            serviceLevel = "En Medium service";
        }
        else
        {
            serviceLevel = "En Liten service";
        }

        ownerNameArray = ownerName.toLowerCase().toCharArray();

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

        outputMessage = "Bil: " + brandName + " " + registerNumber + "\n"
                + "Årsmodell: " + modelYear + "\n"
                + "Ägare: " + ownerName + "\n"
                + "Mätarställning: " + milage + " mil \n"
                + "Inlämnad: " + formattedDate + "\n"
                + "Beräknad tid att laga: " + repairTime + " dagar \n"
                + serviceLevel + " rekommenderas";

        JOptionPane.showMessageDialog(null, outputMessage);
    }
}
