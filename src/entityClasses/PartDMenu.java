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
public class PartDMenu {
    
    public PartDMenu() {
  
        String select = deliveryManMenu();
        
        if (select.equals("1")) {
            new AssignJob();
        }
        else if (select.equals("2")) {
            new CountTime();
        }
        else if (select.equals("3")) {
            new AssignScheduleJob();
        }
        else if (select.equals("4")) {
            new trackScheduleTime();
        }
        else if (select.equals("5")) {
            SetStatus ss = new SetStatus();
            ss.login();
        }
        else if(select.equals("6")){
            CountTime cT = new CountTime();
            cT.input();
        }
        else if(select.equals("0")){
            System.exit(0);
        }
        else if(select.equals("7")) {
            clockInOutReport r = new clockInOutReport();
            r.report();
        }
        else if (!select.equals("1") || !select.equals("2") || !select.equals("3") || !select.equals("4") || !select.equals("5") || !select.equals("6") || !select.equals("0") || !select.equals("7")){
            System.err.println("\nPlease select the number from 1,2,3,4,5 only!!!");
        }
    }
    
    public static String deliveryManMenu() {
        
        Scanner scanner = new Scanner(System.in);
  
        System.out.println("Delivery Man Job Menu");
        System.out.println("=============================");
        System.out.println("1. Assign Job to Delivery Man");
        System.out.println("2. Track the Order Remainig Time");
        System.out.println("3. Assign Job to Delivey Man (Schedule)");
        System.out.println("4. Track the Schedule Order Remaining Time");  
        System.out.println("5. Set status for delivery man");
        System.out.println("6. Track real time");
        System.out.println("7. Report for time of delivery man clock in & clock out");
        System.out.println("0. Exit");
        System.out.print("\nPlease enter your selection : ");
        return scanner.nextLine();

    }
}
