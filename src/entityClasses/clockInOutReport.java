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
 * @author ASUS1
 */
public class clockInOutReport {

private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();

    public void report() {
        System.out.println("Report for clock in & clock out");
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
                System.out.println("Clock in           : " + listDeliveryMan.getEntry(i).getClockIn());  
                System.out.println("Clock out          : " + listDeliveryMan.getEntry(i).getClockOut());  
            }
        }
    }
 }
        
    

