/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class addNewDeliveryManDetails implements Serializable {

    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
            
    public addNewDeliveryManDetails() {

        // return the records from the deliveryMan.dat file and store it in listDeliveryMan
        // to avoid overwrite
        listDeliveryMan = retrieveDeliveryMan();

        // type the new information for new delivery man
        // and save it in to deliveryMan.dat file
        writeDeliveryManDetails();
    }
    
    public void writeDeliveryManDetails() {
        Scanner scanner = new Scanner(System.in);
        
        // use to count how many delivery man have added now
        int count = 0;
 
        String newDeliveryID = "";
        String password = "";
        String newDeliveryName = "";
        String gender;
        String icNo;
        String phoneNo;
        String homeAddress;
        String emergencyContact;
        double salary = 0.0;
        String status = "Full-Time";
        String typesOfFullTime = "-";
        String clockIn = "-";
        String clockOut = "-";
        String pendingDeliveryStatus = "-";
        int orderID = 0;
        String yesNo;
        
        do { 
            System.out.println("\n" + (count + 1) + " Delivery Man");
            System.out.println("==============");
            
            newDeliveryID = "DM" + (listDeliveryMan.getNumberOfEntries() + 1);
            System.out.println("Enter the New Delivery Man ID: " + newDeliveryID);

            System.out.print("Enter your Password: ");
            password = scanner.nextLine();
            
            System.out.print("Enter the New Delivery Man Name: ");
            newDeliveryName = scanner.nextLine();

            System.out.print("Enter your gender: ");
            gender = scanner.nextLine();
            
            System.out.print("Enter the IC Number: ");
            icNo = scanner.nextLine();

            System.out.print("Enter the Phone Number: ");
            phoneNo = scanner.nextLine();

            System.out.print("Enter the home address: ");
            homeAddress = scanner.nextLine();

            System.out.print("Enter the emergency Contact : ");
            emergencyContact = scanner.nextLine();
            
            System.out.print("Enter the salary (RM) : ");
            salary = scanner.nextDouble();
           
            scanner.nextLine();
            
            System.out.println("Status  : " + status);
            System.out.println("Types of Full Time : " + typesOfFullTime);
            System.out.println("Clock-In  : " + clockIn);
            System.out.println("Clock-Out : " + clockOut);
            System.out.println("Pending Delivery Status : " + pendingDeliveryStatus);
            System.out.println("Order ID : " + orderID);
            
            deliveryManDetailsInterface deliveryManDetails = new deliveryManDetails(newDeliveryID, password, newDeliveryName, gender, icNo, phoneNo, homeAddress, emergencyContact, salary, status, typesOfFullTime, clockIn, clockOut,pendingDeliveryStatus, orderID);
            
            listDeliveryMan.add( (deliveryManDetails) deliveryManDetails); 
            count++;
                        
             try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
          } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
              System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
                    
            System.out.print("\nDo You want to continue to add new delivery man (yes / no): ");
            yesNo = scanner.nextLine();
 
        }while(yesNo.equals("yes") || yesNo.equals("y"));
        
        System.out.println("\nAdd " + (count) + " number of delivery man Successful!!!\n");
        
        int numberOfDeliveryMan = displayDeliveryManDetails();

        System.out.println("\nHave " + (numberOfDeliveryMan - 1) + " number of delivery man!!!\n");
     
    }
    
    public int displayDeliveryManDetails() {
        int i;
        System.out.println("--------------------------------------------------------------");
        System.out.println("This below are showing that the records your are added");
                
        for (i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            System.out.println("\n==============");
            System.out.println(i + " delivery man");
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
        }
        return i;
    }
    
    public ListInterface retrieveDeliveryMan() {
         try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManDetails.dat"));
              listDeliveryMan = (ListInterface<deliveryManDetails>) (oiStream.readObject());                
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
              
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
         return listDeliveryMan;
    }
    
}
