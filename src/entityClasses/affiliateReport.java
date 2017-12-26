package entityClasses;

import adt.LList;
import adt.ListInterface;
import static entityClasses.AffiliateLogin.loginedID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class affiliateReport {

    static AffiliateClass as = new AffiliateClass();
    static Scanner sc = new Scanner(System.in);
    static ListInterface<AffiliateClass> affiliates = new LList<>();
    static ListInterface<foodMenuClass> foodM = new LList<>();

    public affiliateReport(String[] args) {
        AffiliatesReport();
    }

    public static void AffiliatesReport() {
        ShowAffiliatesReport();
    }

    public static void ShowAffiliatesReport() {
        int qttFood = 0;
        double ttPrice = 0.0;
        foodM = entityClasses.foodMenu.retrieveFoodMenu();
        affiliates = Affiliate_retrieve.retrieveAffiliate();
        System.out.println("\n-- Fastest Deliveryman --\nAffiliates Report Details\n====================================");
        for (int j = 1; j < affiliates.getNumberOfEntries() + 1; j++) {
            if (loginedID.equals(affiliates.getEntry(j).getAffID())) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                System.out.println("Restaurant\t: " + affiliates.getEntry(j).getRestaurantName());
                System.out.println("Owner\t\t: " + affiliates.getEntry(j).name);
                System.out.println("Report Date\t: " + dtf.format(now));
                System.out.println("\nFoods in system : ");
                System.out.printf("ID   %-30s - %-10s\n", "Food Name", "Price");
                System.out.println("==== ============================== - ==========");

                for (int t = 1; t < foodM.getNumberOfEntries() + 1; t++) {
                    if (loginedID.equals(foodM.getEntry(t).getAffID())) {
                        System.out.printf("%s %-30s - RM %7.2f\n", foodM.getEntry(t).foodID, foodM.getEntry(t).foodName, foodM.getEntry(t).foodPrice);
                        qttFood++;
                        ttPrice += foodM.getEntry(t).foodPrice;
                    }
                }

                System.out.println("                                      ==========");
                System.out.printf("%38sRM %7.2f", "Total - ", ttPrice);
                System.out.println("\n                                      ==========");

                System.out.println("\nNumber of foods in list : " + qttFood);
            }
        }
    }
}
