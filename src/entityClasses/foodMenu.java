package entityClasses;

import adt.*;
import static entityClasses.AffiliateLogin.loginedID;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Tan Kai Lun Group 10 Member group 3 part A Task ID : 152569170 User
 * story : As a restaurant manager, I want to add food details into food menu,
 * so that customer can select the food for order.
 */
public class foodMenu {

    static foodMenuClass fmc = new foodMenuClass();
    static Scanner sc = new Scanner(System.in);
    static String toAddFood = "y", toEditFood = "y", mainChoice, leaveMenu = "y";
    static ListInterface<foodMenuClass> foodM = new LList<>();

    public static void FoodMainMenu() {
        toAddFood = "y";
        System.out.printf("\n-- Fastest Deliveryman --\nrestaurant food menu\n====================================\n"
                + "1) Add food menu\n"
                + "2) Edit food menu\n");
        do {
            System.out.printf("Enter number : ");
            mainChoice = sc.nextLine();
            fmc.affID = loginedID;
            if (!mainChoice.equals("1") && !mainChoice.equals("2")) {
                System.out.printf("Invalid choice, ");
            }
        } while (!mainChoice.equals("1") && !mainChoice.equals("2"));

        switch (mainChoice) {
            case "1":
                fmc.foodCode = 0;
                while (toAddFood.equalsIgnoreCase("y")) {
                    AddFood();
                }
                break;
            case "2":
                EditFood();
                break;
        }
    }

    public static void AddFood() {
        foodM = retrieveFoodMenu();
        System.out.println("\nFoods\n====================================");
        fmc.foodCode++;
        System.out.println(fmc.foodCode);
        fmc.foodID = String.format("f%03d", foodM.getNumberOfEntries() + 1);
        //foodID = "f001";
        System.out.println("Food ID\t\t: " + fmc.foodID);
        System.out.printf("Name\t\t: ");
        fmc.foodName = sc.nextLine();
        System.out.printf("Description\t: ");
        fmc.foodDesc = sc.nextLine();
        System.out.printf("Price(RM)\t\t: ");
        fmc.foodPrice = sc.nextDouble();
        System.out.printf("Promotion price(RM)\t: ");
        fmc.promotionPrice = sc.nextDouble();
        System.out.printf("Add foods?(y=yes,n=no)\t: ");
        sc.nextLine();
        toAddFood = sc.nextLine();

        foodM.add(fmc);

        saveFoodMenu();
    }

    public static void EditFood() {
        foodM = retrieveFoodMenu();
        System.out.printf("Enter food ID\t: ");
        fmc.foodID = sc.nextLine();
        for (int j = 1; j < foodM.getNumberOfEntries() + 1; j++) {
            if (fmc.foodID.equals(foodM.getEntry(j).getFoodID())) {
                System.out.println("Item found, food name : " + foodM.getEntry(j).getFoodName() + " " + foodM.getEntry(j).getFoodPrice() + "\nPlease Enter new details");
                System.out.printf("Name\t\t: ");
                fmc.setFoodName(sc.nextLine());
                System.out.printf("Description\t: ");
                fmc.setFoodDesc(sc.nextLine());
                System.out.printf("Price(RM)\t\t: ");
                fmc.setFoodPrice(sc.nextDouble());
                System.out.printf("Promotion price(RM)\t: ");
                fmc.setPromotionPrice(sc.nextDouble());
                sc.nextLine();
                foodM.replace(j, fmc);
                saveFoodMenu();
            } else {
            }
        }
    }

    public static class foodMenuStream implements Serializable {

        public String affID = null;
        public String foodName = null;
        public String foodDesc = null;
        public String foodPrice = null;
        public String promotionPrice = null;
    }

    public static void saveFoodMenu() {

        try {
            try (ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("foodMenu.dat"))) {
                ooStream.writeObject(foodM);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("IOException");
        }
    }

    public static ListInterface<foodMenuClass> retrieveFoodMenu() {
        try {
            try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("foodMenu.dat"))) {
                foodM = (ListInterface<foodMenuClass>) (oiStream.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ClassNotFoundException");
        }
        return foodM;
    }
}
