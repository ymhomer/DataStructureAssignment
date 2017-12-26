/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.deliveryManDetails;
import adt.LList;
import adt.ListInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class viewPendingDeliveryMan {
    
    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
    private static ListInterface<Order> orderList = new LList<>();
    // display delivery man which have pending to delivery
    public viewPendingDeliveryMan() {
        int count = 0;
        int orderItem = 0;
        int j = 0;
        System.out.println("\nPending Deliveries of each delivery msn");
        System.out.println("=======================================");
        
        listDeliveryMan = retrieveDeliveryManDetails();
        orderList = retrieveOrderList();

        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            if (listDeliveryMan.getEntry(i).getPendingDeliveryStatus().equals("Pending")) {         
                count += 1;
                System.out.println("\n==============");
                System.out.println((i + 1) + " delivery man");
                System.out.println("==============");
                System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
                System.out.println("Phone Number            : " + listDeliveryMan.getEntry(i).getPhoneNo());
                System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());
                System.out.println("Emergence Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());
                System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());
                System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                
                System.out.println("\n============================================");
                System.out.println("\tOrder Item              " );
                System.out.println("===================================================");
                System.out.println("Food Name                       Date Time");
                System.out.println("===================================================");
                for (j = 1; j <= orderList.getNumberOfEntries(); j++) {                    
                    if (orderList.getEntry(j).getOrderID() == listDeliveryMan.getEntry(i).getOrderID()) {                    
                        System.out.printf("%-20s\t\t%-10s\n", orderList.getEntry(j).getFood(), orderList.getEntry(j).getDateTime());
                    }
                }
          }
        }
        
        // use to check when the record get from the dat file
        // when no one delivery man pending delivery status is for pending delivery
        if (count == 0) {
           System.out.println("That are no pending deliveries records for each delivery man now!!!\n");
        }
        
    }
    
    public ListInterface<deliveryManDetails> retrieveDeliveryManDetails() {
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
        return listDeliveryMan;
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
