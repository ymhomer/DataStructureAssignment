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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class viewTotalDeliveredDoneDaily {
    
    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
    private static ListInterface<deliveryManDetails> listDeliveryManReport = new LList<>();
    private static ListInterface<Order> orderList = new LList<>();
    
    private static int totalDeliveredDone = 0;
    private static int totalTravel = 0;
    
    public viewTotalDeliveredDoneDaily() {
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
        
        orderList = retrieveOrderList();
        int quantity1 = 0;
        int quantity2 = 0;
        int quantity3 = 0;
        int quantity4 = 0;
        int quantity5 = 0;
        
        //LocalDate currentDate = LocalDate.now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        //SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
        //formatter.format(currentDate);
        
        //Date date1 = null;
        //String date = "";
 
        System.out.println("Daily Report ");     
        
        for (int i = 1; i < orderList.getNumberOfEntries() + 1; i++) {
//            try {
//                date = orderList.getEntry(i).getDateTime();
//                date1 = dtf.parse(date);
//                date = dtf.format(date1);
//                System.out.println(date);
//            } catch(Exception ex) {
//                System.out.println(ex.getMessage());
//            }
            
            
                if(orderList.getEntry(i).getDeliverymenID().equals("DM1") && orderList.getEntry(i).getJobStatus().equals("Done")) {
                    quantity1 += 1;      
                }
                if(orderList.getEntry(i).getDeliverymenID().equals("DM2") && orderList.getEntry(i).getJobStatus().equals("Done")) {
                    quantity2 += 1;      
                }
                if(orderList.getEntry(i).getDeliverymenID().equals("DM3") && orderList.getEntry(i).getJobStatus().equals("Done")) {
                    quantity3 += 1;      
                }
                if(orderList.getEntry(i).getDeliverymenID().equals("DM4") && orderList.getEntry(i).getJobStatus().equals("Done")) {
                    quantity4 += 1;      
                }
                if(orderList.getEntry(i).getDeliverymenID().equals("DM5") && orderList.getEntry(i).getJobStatus().equals("Done")) {
                    quantity5 += 1;      
                }       
       } 
        //System.out.println(date.equals(formatter.format(currentDate)));
        
       // for (int i = 1 ; i <= listDeliveryMan.getNumberOfEntries() ; i++) {
          //  int qunatity = 0;
            //for (int j = 1 ; j <= orderList.getNumberOfEntries() ; j++) {
           //     if(listDeliveryMan.getEntry(i).getNewDeliveryID().equals(orderList.getEntry(j).getDeliverymenID())) {
                  //  System.out.println(orderList.getEntry(i).getDeliverymenID() + " " +orderList.getEntry(i).getJobStatus());
                  //  qunatity++;
               // }
           // }
            //System.out.print(qunatity);
       // }
        
        
        System.out.println("--------------------------\n");
        System.out.println("Report about delivered have done per day");
        System.out.println("============================================================");
        System.out.println("No.\t Name\t\t\tTotal Delivered Done Per Day");
        System.out.println("============================================================");
        for (int i = 1; i <= orderList.getNumberOfEntries(); i++) {  
            if (orderList.getEntry(i).getJobStatus().equals("Done")) {     
                System.out.printf("%2d \t %-15s \t\t %-12d \n" ,1, listDeliveryMan.getEntry(1).getNewDeliveryName(), quantity1);
                System.out.printf("%2d \t %-15s \t\t %-12d \n" ,2, listDeliveryMan.getEntry(2).getNewDeliveryName(), quantity2);
                System.out.printf("%2d \t %-15s \t\t %-12d \n" ,3, listDeliveryMan.getEntry(3).getNewDeliveryName(), quantity3);
                System.out.printf("%2d \t %-15s \t\t %-12d \n" ,4, listDeliveryMan.getEntry(4).getNewDeliveryName(), quantity4);
                System.out.printf("%2d \t %-15s \t\t %-12d \n" ,5, listDeliveryMan.getEntry(5).getNewDeliveryName(), quantity5);     
             
            }
            break;
        }
        int totalQuantity = quantity1 + quantity2 + quantity3 + quantity4 + quantity5;
        
        System.out.println("----------------------------------------------------------");
        System.out.printf("\t Total Per Daily \t\t %-2d \n", totalQuantity);
        System.out.println("----------------------------------------------------------");
        }

    public ListInterface<Order> retrieveOrderList() {
        try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("orderList.dat"));
              orderList = (ListInterface<Order>) (oiStream.readObject());
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);      
            } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
         return orderList;
    }
}
