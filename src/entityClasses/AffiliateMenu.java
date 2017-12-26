package entityClasses;

import static entityClasses.AffiliatesRegistration.*;
import static entityClasses.affiliateReport.AffiliatesReport;
import java.util.Scanner;

public class AffiliateMenu {

    static Scanner sc = new Scanner(System.in);
    static String toAddAffiliates = "y";
    static boolean toExit = false;

    public AffiliateMenu() {
        affMenu();
    }

    public static void affMenu() {

        while (!toExit) {
            System.out.println("\n-- Fastest Deliveryman --\nAffiliates Menu\n====================================");
            System.out.print("1. Affiliate Resgistration\n"
                    + "2. Food Menu Management\n"
                    + "3. Restaurant Summary Report\n"
                    + "0. Exit\n"
                    + "====================================\n"
                    + "Select the number : ");
            String affMenuChoice = sc.nextLine();

            switch (affMenuChoice) {
                case "1":
                    while (toAddAffiliates.equalsIgnoreCase("y")) {
                        affiliates = Affiliate_retrieve.retrieveAffiliate();
                        AffiliatesReg();
                    }
                    System.out.println("Press Enter to Continue...");
                    sc.nextLine();
                    break;
                case "2":
                    entityClasses.foodMenu.FoodMainMenu();
                    System.out.println("Press Enter to Continue...");
                    sc.nextLine();
                    break;
                case "3":
                    AffiliatesReport();
                    System.out.println("Press Enter to Continue...");
                    sc.nextLine();
                    break;
                case "0":
                    toExit = true;
                    break;
                default:
                    System.out.print("\nPlease select only 0 to 3");
                    break;
            }
        }
    }
}
