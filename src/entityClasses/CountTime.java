/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.SimpleDateFormat;
import java.util.*;
import adt.LList;
import adt.ListInterface;
import adt.deliveryManDetails;
import entityClasses.Customer;
import entityClasses.Order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class CountTime {

private static ListInterface<Order> orderList = new LList<>();
private static ListInterface<Customer> custList = new LList<>();
private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();

    public static void main(String[] args) {
          
        CountTime cT = new CountTime();
        cT.input();
    }
    
    
    public void input() {
        Scanner custID = new Scanner(System.in);
        String custUser;
        System.out.print("Enter your username: ");
        custUser = custID.nextLine();
        
        Scanner orderID = new Scanner(System.in);
        int orderNo;
        System.out.print("Enter your order ID: ");
        orderNo = orderID.nextInt();
        
         try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("customer.dat"));
              custList = (ListInterface<Customer>) (oiStream.readObject());
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
         
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
         
         
        for(int i = 1; i <= custList.getNumberOfEntries(); i++) {
            for(int n = 1; n <= orderList.getNumberOfEntries(); n++) {
               for(int a = 1; a <= listDeliveryMan.getNumberOfEntries(); a++) {
        if(custUser.equals(custList.getEntry(i).getUserName())) {
            if(orderNo == orderList.getEntry(n).getOrderID() && orderList.getEntry(n).getJobStatus().equals("Undone")) {
                  //System.out.println(custUser.equals(custList.getEntry(i).getUserName()));
              if(custList.getEntry(i).getHomeAddress().equals("12,Jalan Prima,Taman Prima ")) {
                  if(orderList.getEntry(n).getDeliverymenID().equals(listDeliveryMan.getEntry(a).getNewDeliveryID())) {
              
              System.out.println("Item             : " + orderList.getEntry(n).getFood());
              System.out.println("Restaurant       : " + orderList.getEntry(n).getRestaurant());
              System.out.println("Address          : "  + custList.getEntry(i).getHomeAddress());
              System.out.println("Date & Time      : " + orderList.getEntry(n).getDateTime());
              
              try {
                Calendar c = new GregorianCalendar();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
                Date date = sdf.parse(orderList.getEntry(n).getDateTime());
                c.setTime(date);
                Date date2 = null;
                date2 = sdf.parse(orderList.getEntry(n).getDateTime());
                c.setTime(date2);
                c.add(Calendar.MINUTE, 30);
                date2 = c.getTime();
                Calendar cal = new GregorianCalendar();
                Date sysDate = new Date();
                //cal.setTime(sysDate);
                
                //c.add(c.get(Calendar.MINUTE), 30);
                long diff = date2.getTime() - sysDate.getTime();
                
                long diffMinutes = diff / (60 * 1000) % 60;
                
                if(diffMinutes > 0) {
                  System.out.println("Your item will be reached within "+ diffMinutes + " minutes.");  
                }
                else if(diffMinutes <= 0) {
                    System.out.println("It reached your home\n"); 
                    orderList.getEntry(n).setJobStatus("Done");
                    listDeliveryMan.getEntry(a).setPendingDeliveryStatus("No Pending");
                try {
                 ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("orderList.dat"));
                 ooStream.writeObject(orderList);
                 ooStream.close();
             } catch (FileNotFoundException ex) {
                 System.err.println("You have error, found no file");
             } catch (IOException ex) {
                 System.err.println("You have error");
             }
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
              }catch (Exception e) {
                System.out.println(e.getMessage());
            }
                   }
                }
              else if(custList.getEntry(i).getHomeAddress().equals("PV16,Taman Danau Kota")) {
                  if(orderList.getEntry(n).getDeliverymenID().equals(listDeliveryMan.getEntry(a).getNewDeliveryID())) {
              
              System.out.println("Item             : " + orderList.getEntry(n).getFood());
              System.out.println("Restaurant       : " + orderList.getEntry(n).getRestaurant());
              System.out.println("Address          : "  + custList.getEntry(i).getHomeAddress());
              System.out.println("Date & Time      : " + orderList.getEntry(n).getDateTime());
              
              try {
                Calendar c = new GregorianCalendar();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
                Date date = sdf.parse(orderList.getEntry(n).getDateTime());
                c.setTime(date);
                Date date2 = null;
                date2 = sdf.parse(orderList.getEntry(n).getDateTime());
                c.setTime(date2);
                c.add(Calendar.MINUTE, 30);
                date2 = c.getTime();
                Calendar cal = new GregorianCalendar();
                Date sysDate = new Date();

                long diff = date2.getTime() - sysDate.getTime();
                
                long diffMinutes = diff / (60 * 1000) % 60;
                
                if(diffMinutes > 0) {
                  System.out.println("Your item will be reached within "+ diffMinutes + " minutes.");  
                }
                else if(diffMinutes <= 0) {
                    System.out.println("It reached your home\n"); 
                    orderList.getEntry(n).setJobStatus("Done");
                    listDeliveryMan.getEntry(a).setPendingDeliveryStatus("No Pending");
                try {
                 ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("orderList.dat"));
                 ooStream.writeObject(orderList);
                 ooStream.close();
             } catch (FileNotFoundException ex) {
                 System.err.println("You have error, found no file");
             } catch (IOException ex) {
                 System.err.println("You have error");
             }
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
              }catch (Exception e) {
                System.out.println(e.getMessage());
            }
                   }
                }
         }
       }
            }
      }
    }
   }
    
}
