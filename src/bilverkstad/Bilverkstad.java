/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilverkstad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author tomas
 * @version 2016-11-07
 * Program for garage shop to register cars that comes in for service.
 */
public class Bilverkstad {
    private static final int MAX_MILAGE = 40000;
    private static final int MIN_MILAGE = 1500;
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Read in todays date and format it according to: Tue Nov 08
        Date date;
        date = new Date();
        DateFormat df = new SimpleDateFormat("EEE LLL dd");
        String formattedDate = df.format(date);
       
        String registerNumber = JOptionPane.showInputDialog("Ange registreringsnummer");
        int modelYear = Integer.parseInt(JOptionPane.showInputDialog("Ange årsmodell"));
        String brandName = JOptionPane.showInputDialog("Ange märke");
        String ownerName = JOptionPane.showInputDialog("Ange ägare (för och efternamn)");
        int milage = MIN_MILAGE + (int)(Math.random() * ((MAX_MILAGE - MIN_MILAGE) + 1));
        int repairTime = milage / 1500;
        
        JOptionPane.showMessageDialog(null, "Bil: " +brandName +" " +registerNumber +"\n" +"Årsmodell: " 
                +modelYear +"\n" + "Ägare: " +ownerName + "\n" +"Mätarställning: " +milage +" mil" +"\n" 
                +"Inlämnad: " +formattedDate +"\n" +"Beräknad tid att laga: " +repairTime +" dagar");
    }
    
}
