/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DriverProgram;

import entityClasses.*;
import java.util.Scanner;

/**
 * *
 * @author ASUS1
 */
public class homePage {

    /**
     * @param args the command line arguments
     */
    private static Scanner scanner = new Scanner(System.in);
    private static int select;
    
    public static void main(String[] args) {
        
        select = menu();
        
        if(select == 1) {
            new AffiliateLogin();
        }
        else if (select == 2) {
            new PartBMenu();
        }
        else if (select == 3) {
            new DataStructure();
        }
        else if (select == 4) {
            new PartDMenu();
        }
         
    }
    
    public static int menu() {
        System.out.println("1. Affiliates Menu");
        System.out.println("2. Delivery Man Information");
        System.out.println("3. Make the Food Order");
        System.out.println("4. Clock-In, Clock-Out");
        
        System.out.print("Please select your number : ");
        select = scanner.nextInt();
        return select;
    }
}
