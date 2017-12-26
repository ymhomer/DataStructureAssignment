/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class viewDailyReport {
    
    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
    private static ListInterface<deliveryManDetails> listDeliveryManReport = new LList<>();
    private static int totalDeliveredDone = 0;
    private static int totalTravel = 0;
    
    public viewDailyReport() {
        try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManReport.dat"));
              listDeliveryManReport = (ListInterface<deliveryManDetails>) (oiStream.readObject());
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();
        
        System.out.println("Daily Report on " + dtf.format(currentDate));
        System.out.println("--------------------------\n");
        System.out.println("    Report about delivered have done and total distance of Delivery Man per day");
        System.out.println("========================================================================================");
        System.out.println("No.\t Name\t\t\tDelivered Done Per Day\t\tTotal Travel Per Day(KM)");
        System.out.println("========================================================================================");
        for (int i = 1; i < listDeliveryManReport.getNumberOfEntries() + 1; i++) {           
            System.out.printf("%2d \t %-15s \t\t %-12d  %20d\n" ,(i + 1), listDeliveryManReport.getEntry(i).getNewDeliveryName(), listDeliveryManReport.getEntry(i).getDeliveredDonePerDay(), listDeliveryManReport.getEntry(i).getTotalTravelPerDay());
            
            totalDeliveredDone += listDeliveryManReport.getEntry(i).getDeliveredDonePerDay();
            totalTravel += listDeliveryManReport.getEntry(i).getTotalTravelPerDay();
            
        }
        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("\t Total Per Daily \t\t %-2d \t\t\t %10d\n", totalDeliveredDone, totalTravel);
        System.out.println("------------------------------------------------------------------------------------");
    }
        
        
    
}
