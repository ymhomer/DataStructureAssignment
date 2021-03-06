/*
Auther : Tan Kai Lun
Group 10
Member group 3 part A
Task ID : 152569170
User story : As a restaurant owner, I want register as an affiliates, so that I can maintain the food menu.
 */
package entityClasses;

import adt.LList;
import adt.ListInterface;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class AffiliatesRegistration {

    //static LinkedStack<String> ls = new LinkedStack<>();
    static AffiliateClass as = new AffiliateClass();
    static Scanner sc = new Scanner(System.in);
    //static String toAddAffiliates = "y";
//    static LinkedStack<AffiliateClass> affiliates = new LinkedStack<>();
    static ListInterface<AffiliateClass> affiliates = new LList<>();

//    public static void main(String[] args) {
//        while (toAddAffiliates.equalsIgnoreCase("y")) {
//            affiliates = retrieveAffiliate();
//            AffiliatesReg();
//            //saveAffiliate();
//        }
//    }
    public static void AffiliatesReg() {
        //menu start
        System.out.println("\n-- Fastest Deliveryman --\nAffiliates Registration\n====================================");
        as.affID = String.format("aff%03d", affiliates.getNumberOfEntries() + 1);
        System.out.println("Restaurant ID\t: " + as.affID);

        do {
            System.out.printf("Password\t: ");
            as.password = sc.next();
            System.out.printf("Retry password\t: ");
            as.rpassword = sc.next();

            if (!as.password.equals(as.rpassword)) {
                System.out.println("\n**Please try the correct password!**");

            }
        } while (!as.password.equals(as.rpassword));

        System.out.printf("Password Hit\t: ");
        sc.nextLine();
        //for recovery
        as.passwordHit = sc.nextLine();
        //Restaurant Information
        System.out.println("\nRestaurant Information\n====================================");
        System.out.printf("Restaurant name\t: ");
        as.restaurantName = sc.nextLine();
        System.out.printf("Owner's name\t: ");
        as.name = sc.nextLine();
        System.out.printf("IC number - e.g.(011111011111)\n * 16-digits\t: ");
        as.icno = sc.nextLine();
        System.out.printf("Tel number - e.g.(0123456789)\n * 10-11 digits\t: ");
        as.phoneNo = sc.nextLine();
        System.out.printf("Email\t\t: ");
        as.email = sc.nextLine();
        System.out.printf("Address\nline 1\t\t: ");
        as.address1 = sc.nextLine();
        System.out.printf("line 2\t\t: ");
        as.address2 = sc.nextLine();
        System.out.printf("Zip code\t: ");
        as.zipCode = sc.nextLine();
        System.out.printf("City\t\t: ");
        as.city = sc.nextLine();
        System.out.printf("State\t\t: ");
        as.state = sc.nextLine();
        System.out.printf("Are you sure (y=yes, n=no)\t : ");

        if (sc.nextLine().equalsIgnoreCase("y")) {
            affiliates.add(as);
            try {
                showStaffInfo();
            } catch (IOException ex) {
                System.out.println("IOException");
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException");
            }
        } else {
            System.out.println("Data unsaved.");
            //break;
        }

        System.out.printf("====================================\nDo You want to add more affiliates?(y=yes, n=no): ");
        entityClasses.AffiliateMenu.toAddAffiliates = sc.nextLine();
    }

    public static void showStaffInfo() throws IOException, ClassNotFoundException {
        System.out.println("\nRegistration Success\n====================================");
        System.out.println("Restaurant ID\t: " + as.affID);
        System.out.println("The restaurant " + as.restaurantName + " has been registed.\n");
        System.out.println("Owner's name\t: " + as.name);
        System.out.println("IC number\t: " + as.icno);
        System.out.println("Tel number\t: " + as.phoneNo);
        System.out.println("Email\t\t: " + as.email);
        System.out.println("Address\t\t: \n\t" + as.address1 + "\n\t" + as.address2 + "\n\t" + as.zipCode + " " + as.city + "\n\t" + as.state + "\n");
        System.out.println("====================================\n*Please remember your USER ID and PASSWORD!!*");
        Affiliate_save.saveAffiliate();
    }

    public static class affiliateStream implements Serializable {

        public String affID = null;
        public String password = null;
        //public String rpassword = null;
        public String passwordHit = null;
        public String name = null;
        public String restaurantName = null;
        public String email = null;
        public String icno = null;
        public String phoneNo = null;
        public String address1 = null;
        public String address2 = null;
        public String city = null;
        public String state = null;
        public String zipCode = null;
    }
}
