/*
Auther : Tan Kai Lun
Group 10
Member group 3 part A
Task ID : 152569170
User story : As a restaurant owner, I want register as an affiliates, so that I can maintain the food menu.
 */
package datastructureassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AffiliatesRegistration {

    static Scanner sc = new Scanner(System.in);
    static String userID, password, rpassword, passwordHit, name, restaurantName, email,icno, phoneNo, address1, address2, city, state, zipCode;
    static String toAddAffiliates = "y";
    
    static List<String> userIDL = new ArrayList<>();
    static List<String> restaurantNameL = new ArrayList<>();
    static List<String> nameL = new ArrayList<>();
    static List<String> emailL = new ArrayList<>();
    static List<String> passwordL = new ArrayList<>();
    static List<String> passwordHitL = new ArrayList<>();
    static List<String> icnoL = new ArrayList<>();
    static List<String> phoneNoL = new ArrayList<>();
    static List<String> address1L = new ArrayList<>();
    static List<String> address2L = new ArrayList<>();
    static List<String> cityL = new ArrayList<>();
    static List<String> stateL = new ArrayList<>();
    static List<String> zipCodeL = new ArrayList<>();

    public static void main(String[] args) {
        //AffiliatesRegistration ar = new AffiliatesRegistration();
        while (toAddAffiliates.equals("y")) {
            AffiliatesReg();
        }
    }

    public static void AffiliatesReg() {
        //menu start
        System.out.println("\n-- Fastest Deliveryman --\nAffiliates Registration\n====================================");
        userID = String.format("aff%03d", userIDL.size() + 1);
        System.out.println("Restaurant ID\t: " + userID);
        //userID = sc.next();
        do{
            System.out.printf("Password\t: ");
            password = sc.next();
            System.out.printf("Retry password\t: ");
            rpassword = sc.next();
            
            if (!password.equals(rpassword)){
                System.out.println("\n**Please try the correct password!**");
            }
        }while(!password.equals(rpassword));
        
        System.out.printf("Password Hit\t: ");
        sc.nextLine();
        //for recovery
        passwordHit = sc.nextLine();
        //Restaurant Information
        System.out.println("\nRestaurant Information\n====================================");
        System.out.printf("Restaurant name\t: ");
        restaurantName = sc.nextLine();
        System.out.printf("Owner's name\t: ");
        name = sc.nextLine();
        System.out.printf("IC number - e.g.(011111011111)\n * 16-digits\t: ");
        icno = sc.nextLine();
        System.out.printf("Tel number - e.g.(0123456789)\n * 10-11 digits\t: ");
        phoneNo = sc.nextLine();
        System.out.printf("Email\t\t: ");
        email = sc.nextLine();
        System.out.printf("Address\nline 1\t\t: ");
        address1 = sc.nextLine();
        System.out.printf("line 2\t\t: ");
        address2 = sc.nextLine();
        System.out.printf("Zip code\t: ");
        zipCode = sc.nextLine();
        System.out.printf("City\t\t: ");
        city = sc.nextLine();
        System.out.printf("State\t\t: ");
        state = sc.nextLine();
        System.out.printf("Are you sure (y=yes, n=no)\t : ");

        if (sc.nextLine().equals("y")) {
            showStaffInfo();
        } else {
            System.out.println("Data unsaved.");
            //break;
        }

        userIDL.add(userID);
        restaurantNameL.add(restaurantName);
        nameL.add(name);
        passwordL.add(password);
        passwordHitL.add(passwordHit);
        icnoL.add(icno);
        phoneNoL.add(phoneNo);
        emailL.add(email);
        address1L.add(address1);
        address2L.add(address2);
        cityL.add(city);
        stateL.add(state);
        zipCodeL.add(zipCode);

        //System.out.println("User ID\t: " + userIDL);
        System.out.printf("====================================\nDo You want to add more affiliates?(y=yes, n=no): ");
        toAddAffiliates = sc.nextLine();
    }

    public static void showStaffInfo() {
        System.out.println("\nRegistration Success\n====================================");
        System.out.println("Restaurant ID\t: " + userID);
        System.out.println("The restaurant " + restaurantName + " has been registed.\n");
        System.out.println("Owner's name\t: " + name);
        System.out.println("IC number\t: " + icno);
        System.out.println("Tel number\t: " + phoneNo);
        System.out.println("Email\t\t: " + email);
        System.out.println("Address\t\t: \n\t" + address1 + "\n\t" + address2 + "\n\t" + zipCode + " " + city + "\n\t" + state + "\n");
        System.out.println("====================================\n*Please remember your USER ID and PASSWORD!!*");
    }
}
