/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class PartBMenu {

    /**
     * @param args the command line arguments
     */

    public PartBMenu() {
  
        String select = deliveryManMenu();
        
        if (select.equals("1")) {
            new addNewDeliveryManDetails();
        }
        else if (select.equals("2")) {
            new updateDeliveryManDetails();
        }
        else if (select.equals("3")) {
            new viewPendingDeliveryMan();
        }
        else if (select.equals("4")) {
            new viewDailyReport();
        }
        else if (select.equals("5")) {
            
        }
        else if (!select.equals("1") || !select.equals("2") || !select.equals("3") || !select.equals("4") || !select.equals("5")){
            System.err.println("\nPlease select the number from 1,2,3,4,5 only!!!");
        }
    }
    
    public static String deliveryManMenu() {
        
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Delivery Man Information Menu");
        System.out.println("=============================");
        System.out.println("1. Add Delivery Man Details");
        System.out.println("2. Update Delivery Man Details");
        System.out.println("3. View Pending Delivery Man");
        System.out.println("4. View Daily Report");
        System.out.println("5. Exit");
        
        System.out.print("\nPlease enter your selection : ");
        return scanner.nextLine();

    }
    
}
