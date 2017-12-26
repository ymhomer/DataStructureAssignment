/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.LList;
import adt.ListInterface;
import adt.deliveryManDetails;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class viewDistanceTravelledDaily {
    
    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
    private static ListInterface<ScheduleOrders> scheduleList = new LList<>();
    
    private static int totalDeliveredDone = 0;
    private static int totalTravel = 0;
    
    public viewDistanceTravelledDaily() {
        try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManDetails.dat"));
              listDeliveryMan = (ListInterface<deliveryManDetails>) (oiStream.readObject());
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
              System.out.println(ex.getMessage());
            } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        
        scheduleList = retriveSchedule();
      
        // System.out.println(orderList.getEntry(i).getJobStatus());
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate currentDate = LocalDate.now();
        
        System.out.println(scheduleList.getEntry(1).getDistance());
        int total = 0;
         System.out.println("--------------------------\n");
        System.out.println("Report about total distance of Delivery Man per day");
        System.out.println("============================================================");
        System.out.println("No.\t Name\t\t\tDistance of Travelled Per Day");
        System.out.println("============================================================");
        for (int i = 1; i <= scheduleList.getNumberOfEntries(); i++) {  
            if (scheduleList.getEntry(i).getJobStatus().equals("Done")) {     
                total += scheduleList.getEntry(i).getDistance();
                System.out.printf("%2d \t %-15s \t\t %-12d \n" ,i, scheduleList.getEntry(i).getDeliveryMan(), scheduleList.getEntry(i).getDistance());

            }
            break;
        }

        
        System.out.println("----------------------------------------------------------");
        System.out.printf("\t Total Per Daily \t\t %-2d \n", total);
        System.out.println("----------------------------------------------------------");
        }
        

    public ListInterface<ScheduleOrders> retriveSchedule(){
        try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("schedule.dat"));
      scheduleList = (ListInterface<ScheduleOrders>) (oiStream.readObject());
      oiStream.close();
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        return scheduleList;
    }

}
