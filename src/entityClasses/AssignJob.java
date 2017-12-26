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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;

public class AssignJob {
    
private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
private static ListInterface<Order> orderList = new LList<>();

    public static void main(String[] args) {
        char selection;
        do{
            
        System.out.println("Pending Deliveries of each delivery msn");
        System.out.println("=======================================");
        
        try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManDetails.dat"));
              listDeliveryMan = (ListInterface<deliveryManDetails>) (oiStream.readObject());
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            if (listDeliveryMan.getEntry(i).getStatus().equals("Full-Time") || listDeliveryMan.getEntry(i).getTypesOfFullTime().equals("Available")) {
                System.out.println("\n==============");
                System.out.println(i + " delivery man");
                System.out.println("==============");
                System.out.println("Name               : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                System.out.println("Username           : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                System.out.println("Password           : " + listDeliveryMan.getEntry(i).getPassword());
                System.out.println("Gender             : " + listDeliveryMan.getEntry(i).getGender());
                System.out.println("IC Number          : " + listDeliveryMan.getEntry(i).getIcNo());
                System.out.println("Phone Number       : " + listDeliveryMan.getEntry(i).getPhoneNo());
                System.out.println("Home Address       : " + listDeliveryMan.getEntry(i).getHomeAddress());
                System.out.println("Emergence Contact  : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                System.out.printf("Salary             : %.2f\n", listDeliveryMan.getEntry(i).getSalary());
                System.out.println("Status             : " + listDeliveryMan.getEntry(i).getStatus());
                System.out.println("Working State      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime()); 
                System.out.println("Pending status     : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                System.out.println("Order ID assigned  : " + listDeliveryMan.getEntry(i).getOrderID());  
                System.out.println("Clock in           : " + listDeliveryMan.getEntry(i).getClockIn());  
                System.out.println("Clock out          : " + listDeliveryMan.getEntry(i).getClockOut());  
            }
        }
        System.out.println("\n");
        System.out.println("Order List");
        System.out.println("==========");
        
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
        
             for (int i = 1; i <= orderList.getNumberOfEntries(); i++) {
                 
                 System.out.println("\n");
                 System.out.println("Order ID       : " + orderList.getEntry(i).getOrderID());
                 System.out.println("Customer       : " + orderList.getEntry(i).getCustomerName());
                 System.out.printf("Total price     : RM %.2f\n" ,orderList.getEntry(i).getTotalAmount());
                 System.out.println("Date & Time    : " + orderList.getEntry(i).getDateTime());
                 System.out.println("Job Status     : " + orderList.getEntry(i).getJobStatus()); 
                 System.out.println("Delivery man ID: " + orderList.getEntry(i).getDeliverymenID()); 
             }
        String name;
        Scanner assName = new Scanner(System.in); 
        System.out.print("Enter available delivery man's name: ");
        name = assName.nextLine();
        for(int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            if(name.equals(listDeliveryMan.getEntry(i).getNewDeliveryName())) {
                System.out.println("\n==============");
                System.out.println(i + " delivery man");
                System.out.println("==============");
                System.out.println("Name               : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                System.out.println("Username           : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                System.out.println("Password           : " + listDeliveryMan.getEntry(i).getPassword());
                System.out.println("Gender             : " + listDeliveryMan.getEntry(i).getGender());
                System.out.println("IC Number          : " + listDeliveryMan.getEntry(i).getIcNo());
                System.out.println("Phone Number       : " + listDeliveryMan.getEntry(i).getPhoneNo());
                System.out.println("Home Address       : " + listDeliveryMan.getEntry(i).getHomeAddress());
                System.out.println("Emergence Contact  : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                System.out.printf("Salary             : %.2f\n", listDeliveryMan.getEntry(i).getSalary());
                System.out.println("Status             : " + listDeliveryMan.getEntry(i).getStatus());
                System.out.println("Working State      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime()); 
                System.out.println("Pending status     : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                System.out.println("Order ID assigned  : " + listDeliveryMan.getEntry(i).getOrderID());  
                System.out.println("Clock in           : " + listDeliveryMan.getEntry(i).getClockIn()); 
            }
        }
        
        int orderIDAssigned;
        Scanner ass = new Scanner(System.in); 
        System.out.print("Assign job with Order ID to available delivery man: ");
        orderIDAssigned = ass.nextInt();
        
        String ID;
        Scanner del = new Scanner(System.in);
        System.out.print("Assign available delivery man's username for delivery: ");
        ID = del.nextLine();
        
        for(int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            
            if(name.equals(listDeliveryMan.getEntry(i).getNewDeliveryName())) {
                if(ID.equals(listDeliveryMan.getEntry(i).getNewDeliveryID())) {

                listDeliveryMan.getEntry(i).setOrderID(orderIDAssigned);
                listDeliveryMan.getEntry(i).setPendingDeliveryStatus("Pending");
                
          try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("You have error, found no file");
        } catch (IOException ex) {
            System.err.println("You have error");
        }
                
            }
           }
            }
        
        for(int a = 1; a <= orderList.getNumberOfEntries(); a++) {
            if(orderIDAssigned == orderList.getEntry(a).getOrderID()) {
                orderList.getEntry(a).setDeliverymenID(ID);
                
                try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("orderList.dat"));
            ooStream.writeObject(orderList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("You have error, found no file");
        } catch (IOException ex) {
            System.err.println("You have error");
        }
            }
        }
       
        Scanner sel = new Scanner(System.in);
        System.out.print("Do you want assign again ? (y/n)");
        selection = sel.nextLine().charAt(0);
        }while(selection=='y');
    }
    
}
