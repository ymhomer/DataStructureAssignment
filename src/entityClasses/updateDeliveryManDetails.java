/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class updateDeliveryManDetails {

    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
    private static String status;
    private static Scanner scanner = new Scanner(System.in);
        
    public updateDeliveryManDetails() {
        int select;
        
        do {
            //return integer number from mainMenu and store in select
            select = mainMenu();
            String yesNo;

            // to check the select either is 1, 2, 3, 4, or 5
            if (select == 1) {
                do {
                    updateDelivery();
                    System.out.print("\nDo you want to continue to update delivery man name, gender, and IC number (yes / no): ");
                    yesNo = scanner.nextLine();

                } while(yesNo.equals("yes") || yesNo.equals("y"));
            }

            else if (select == 2) {
                do {
                    updateContact();
                    System.out.print("\nDo you want to continue to update delivery man contact information (yes / no): ");
                    yesNo = scanner.nextLine();

                } while(yesNo.equals("yes") || yesNo.equals("y"));
            }

            else if (select == 3) {
                do {
                    updateSalary();
                    System.out.print("\nDo you want to continue to update delivery man salary (yes / no): ");
                    yesNo = scanner.nextLine();

                } while(yesNo.equals("yes") || yesNo.equals("y"));
            }

            else if (select == 4) {
                do {
                    updateStatus();
                    System.out.print("\nDo you want to continue to update delivery man status (yes / no): ");
                    yesNo = scanner.nextLine();
                } while(yesNo.equals("yes") || yesNo.equals("y"));
            }      


        } while(select != 5);
        
    }
        
    public int mainMenu() {       
        System.out.println("=========");
        System.out.println("Main Menu");
        System.out.println("=========");
        System.out.println("1. Update Delivery Man ID, Password, Name, Gender and IC Number");
        System.out.println("2. Update Delivery Man Contact Information (Phone Number, Home Address, Emergency Contact)");
        System.out.println("3. Update Delivery Man Salary");
        System.out.println("4. Update Delivery Man Status(Resigned, Retired, Full-Time)");
        System.out.println("5. Exit");
        System.out.print("\nPlease select the number you want to do : ");
        
        int select = scanner.nextInt();

        return select;
        
    } 
    
    // use to update the delivery man ID, password, name, gender, and IC Number
    public void updateDelivery() {
        listDeliveryMan = retrieveDeliveryMan();
        
        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            System.out.println("\n\n==============");
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
        
        System.out.print("\nPlease select that delivery man you want to update : ");
        int noDeliveryMan = scanner.nextInt();     
        
        String name = "";
        String gender = "";
        String icNo = "";
        String deliveryManID = "";
        String password = "";
        
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Delivery Man ID");
        System.out.println("2. Password");
        System.out.println("3. Name ");
        System.out.println("4. Gender ");
        System.out.println("5. IC Number");
        System.out.println("6. All (Delivery Man ID, Password, Name, Gender, IC Number) ");
        System.out.print("\nPlease select that details you want to update : ");
        int select = scanner.nextInt();

        // use to check the select either is 1, 2, 3, 4, 5, or 6
        if (select == 1) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    
                    System.out.print("Delivery Man ID    : " );
                    scanner.nextLine();
                    deliveryManID = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setNewDeliveryID(deliveryManID);
                    
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());

                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime()); 
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 2) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    
                    System.out.print("Password                : " );
                    scanner.nextLine();
                    password = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setPassword(password);
                    
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());

                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());   
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
   
        if (select == 3) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.print("Name                    : " );
                    scanner.nextLine();
                    name = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setNewDeliveryName(name);
                    
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());

                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime()); 
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 4) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {                   
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    
                    System.out.print("Gender                  : " );
                    scanner.nextLine();
                    gender = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setGender(gender);
                    
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());  
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 5) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    
                    System.out.print("IC Number               : " );
                    scanner.nextLine();
                    icNo = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setIcNo(icNo);

                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime()); 
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 6) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.print("Delivery Man ID         : " );
                    scanner.nextLine();
                    deliveryManID = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setNewDeliveryID(deliveryManID);
                    
                    System.out.print("Password                : " );
                    scanner.nextLine();
                    password = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setPassword(password);
                    
                    System.out.print("Name                    : " );
                    scanner.nextLine();
                    name = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setNewDeliveryName(name);
                    
                    System.out.print("Gender                  : " );
                    gender = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setGender(gender);
                    
                    System.out.print("IC Number               : " );
                    icNo = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setIcNo(icNo);

                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        // save in the deliveryManDetails.dat file
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
          } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
        
    }
   
    // call the update Contact to update the phone No, Home Address, and Emergency Contact
    public void updateContact() {
        listDeliveryMan = retrieveDeliveryMan();
        
        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            System.out.println("\n\n==============");
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
        
        System.out.print("\nPlease select that delivery man you want to update : ");
        int noDeliveryMan = scanner.nextInt();

        String phoneNo;
        String homeAddress;
        String emergencyContact;
        
        System.out.println("1. Phone No ");
        System.out.println("2. Home Address ");
        System.out.println("3. Emergency Contact ");
        System.out.println("4. All (Phone No, Home Address, Emergency Contact) ");
        System.out.print("\nPlease select that details you want to update : ");
        int select = scanner.nextInt();
        
        if (select == 1) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
                    
                    System.out.print("Phone No                : " );
                    scanner.nextLine();
                    phoneNo = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setPhoneNo(phoneNo);
                    
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());    
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 2) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());
                    
                    System.out.print("Home Address            : " );
                    scanner.nextLine();
                    homeAddress = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setHomeAddress(homeAddress);
                    
                    
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());  
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 3) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());
                    
                    System.out.print("Emergency Contact       : " );
                    scanner.nextLine();
                    emergencyContact = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setEmergencyContact(emergencyContact);

                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());   
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());   
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        }
        
        if (select == 4) {
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());

                    System.out.print("Phone No                : " );
                    scanner.nextLine();
                    phoneNo = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setPhoneNo(phoneNo);

                    System.out.print("Home Address            : " );
                    homeAddress = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setHomeAddress(homeAddress);

                    System.out.print("Emergency Contact       : " );
                    emergencyContact = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setEmergencyContact(emergencyContact);

                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());  
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());   
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                    
                }
            }
        }
           
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
          } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
                
    }
    
    // call to update the delivery man salary
    public void updateSalary() {
        listDeliveryMan = retrieveDeliveryMan();
        
        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            System.out.println("\n\n==============");
            System.out.println(i + " delivery man");
            System.out.println("==============");
            System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
            System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
            System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
            System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
            System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
            System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());
            System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());
            System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
            System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());                      
            System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
            System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());  
            System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
            System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
            System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
            System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
        }
        
        System.out.print("\nPlease select the number of delivery man you want to update : ");
        int noDeliveryMan = scanner.nextInt();
        
        System.out.println("\nUpdate the Status of delivery man : ");
        System.out.println("======================================");
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());      
                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());           
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    
                    System.out.printf("Salary                  : ");
                    scanner.nextLine();
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    listDeliveryMan.getEntry(i).setSalary(salary);
                    
                    System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());  
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        
        
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
          } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
    }   
    
    // call to update delivery man status
    // change the status in the full-time, retired, or resigned for each delivery man
    public void updateStatus() {
        listDeliveryMan = retrieveDeliveryMan();
        
        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            System.out.println("\n\n==============");
            System.out.println(i + " delivery man");
            System.out.println("==============");
            System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
            System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
            System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
            System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
            System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());
            System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());
            System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());
            System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
            System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary());                      
            System.out.println("Status                  : " + listDeliveryMan.getEntry(i).getStatus());
            System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime()); 
            System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
            System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
            System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
            System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
        }
        
        System.out.print("\nPlease select the number of delivery man you want to update : ");
        int noDeliveryMan = scanner.nextInt();

        
        System.out.println("\nUpdate the Status of delivery man : ");
        System.out.println("======================================");
            for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
                if (noDeliveryMan == i) {
                    System.out.println("Delivery Man ID         : " + listDeliveryMan.getEntry(i).getNewDeliveryID());
                    System.out.println("Password                : " + listDeliveryMan.getEntry(i).getPassword());
                    System.out.println("Name                    : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender                  : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number               : " + listDeliveryMan.getEntry(i).getIcNo());      
                    System.out.println("Phone No                : " + listDeliveryMan.getEntry(i).getPhoneNo());           
                    System.out.println("Home Address            : " + listDeliveryMan.getEntry(i).getHomeAddress());      
                    System.out.println("Emergency Contact       : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary                  : %.2f\n", listDeliveryMan.getEntry(i).getSalary()); 
                    
                    System.out.print("Status                  : ");
                    scanner.nextLine();
                    status = scanner.nextLine();
                    listDeliveryMan.getEntry(i).setStatus(status);
                    
                    System.out.println("Types of Full Time      : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());    
                    System.out.println("Clock-In                : " + listDeliveryMan.getEntry(i).getClockIn());
                    System.out.println("Clock-Out               : " + listDeliveryMan.getEntry(i).getClockOut());
                    System.out.println("Pending Delivery Status : " + listDeliveryMan.getEntry(i).getPendingDeliveryStatus());
                    System.out.println("Order ID                : " + listDeliveryMan.getEntry(i).getOrderID());
                }
            }
        
        
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
          } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
        
    }
    
    // use to retrive the records from the deliveryManDetails.dat file
    public ListInterface retrieveDeliveryMan() {
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
       
}
