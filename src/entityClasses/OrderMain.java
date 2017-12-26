package entityClasses;

import adt.LList;
import adt.ListInterface;

import adt.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
//import order.Customer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.LinkedList;

/**
 *
 * @author Ong Chong Ren
 */
public class OrderMain {

    /**
     * @param args the command line arguments
     */
    

    private ListInterface<Customer> customerList = new LList<>();
    private ListInterface<AffiliateClass> restaurantList = new LList<>();
    private ListInterface<foodMenuClass> foodList = new LList<>();
    private ListInterface<Order> orderList = new LList<>();

    Scanner sc = new Scanner(System.in);
    
    //addOrder(ListInterface<Order> orderList);

    public OrderMain(Customer cust) {
       
        //orderMain.addCustRecord();
        //orderMain.retrieveCustomer();
       // orderMain.addFoodRecord();
        //orderMain.retrieveFood();
        //orderMain.addRestaurantRecord();
        //orderMain.retrieveRestaurant();
        
        mainMenu(cust);
        

        
       
        
        
    }
    //boolean exit = false;

    public void mainMenu(Customer cust) {

        int choice;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Fastest Deliverymen's ");
        System.out.println("1.Make Order ");
        System.out.println("2.Retrieve Customer Record ");
        System.out.print("Choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                restaurant(cust);
                
                break;
            case 2:
                retrieveCustomer();
                break;
            default:

                System.out.println("Please select 1 to 2 selection !!!");
                mainMenu(cust);
                break;
        }

    }

    public void restaurant(Customer customer) {

        restaurantList = retrieveRestaurant();
        foodList = retrieveFood();
        //this one
        orderList = retreiveOrder();
        //System.out.println(restaurantList.getEntry(1).getName());
        //System.out.println(foodList.getEntry(1).getFoodName());
        int selection = 1;
        int i = 0;
        int foodChoice;
        int qty = 0;
        double total = 0.00, dTotal = 0.00;
        double subtotal = 0.00;
        String yesSelection;
        String option;
        int Order = 1000;
        //this one 
        Order = orderList.getEntry(orderList.getNumberOfEntries()).getOrderID() + 1;
        System.out.println("Welcome to Fastest Deliveryman");
        System.out.println("Here is the restaurant that you can choose: ");
        //selext res
        for (i = 1; i < restaurantList.getNumberOfEntries() + 1; i++) {

            System.out.println(i + ". " + restaurantList.getEntry(i).getRestaurantName());

        }
        //System.out.println("0. Main menu");
        System.out.println("Please choose which restaurant that you want: ");
        selection = sc.nextInt();
        AffiliateClass restaurant = selectionRes(selection);
        String resN = restaurant.getRestaurantName();
        int count = 1;
        //display food
        do {
            int p = 1;
            System.out.println("\nHere is the " + resN + " food that you can choose: ");
            for (int a = 1; a < foodList.getNumberOfEntries() + 1; a++) {
                if (restaurant.getAffID().equals(foodList.getEntry(a).getAffID())) {
                    System.out.println(p + ". " + foodList.getEntry(a).getFoodName());
                    p++;
                }

            }

            System.out.print("Please choose the food you want:");
            foodChoice = sc.nextInt();
            foodMenuClass food = selectFood(foodChoice, restaurant);
            System.out.println("Please enter the quantity:");
            qty = sc.nextInt();
            subtotal = qty * food.getFoodPrice();
            total += subtotal;
            System.out.printf("Subtotal: RM %.2f \n\n", subtotal);
            Calendar cal = new GregorianCalendar();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
            String dateTime = sdf.format(date);
            //System.out.println(dateTime);
            Order order = new Order(Order, qty, restaurant.getRestaurantName(), food.getFoodName(), customer.getName(), "unpaid", total, dateTime, "Undone",subtotal, null);
            //Order order = new Order(subtotal, Order, qty, restaurant.getRestaurantName(), food.getFoodName(), customer.getName(), "unpaid",total, dateTime, "-", "Undone");
            orderList.add(order);

            System.out.print("\nDo you want to continue set more food to your order? (yes/no) ");
            sc.nextLine();
            yesSelection = sc.nextLine();

        } while (yesSelection.equalsIgnoreCase("YES"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        addOrder();
        System.out.println("==================");
        System.out.println("Order Confirmation");
        System.out.println("==================");
        System.out.println("Order Date\t: " + dtf.format(now));
        System.out.printf("%-8s %-25s %-20s %-8s %-8s\n", "Order ID", "Restaurant", "Food selected", "Quantity", "Subtotal");
        System.out.printf("%-8s %-25s %-20s %-8s %-8s\n", "========", "=========================", "====================", "========", "========");
        //System.out.println("Order ID" + "The restaurant selected" + "The food you have selected" + "The quantity you have selected" + "Subtotal");
        for (int a = 1; a < orderList.getNumberOfEntries() + 1; a++) {
            if (orderList.getEntry(a).getOrderID() == Order) {
//                System.out.println(orderList.getEntry(a).getOrderID()+"|"+orderList.getEntry(a).getRestaurant()+"|"+orderList.getEntry(a).getFood()
//                                       +"|"+orderList.getEntry(a).getQty()+"|"+orderList.getEntry(a).getSubTotal());
                System.out.printf("%-8s|%-25s|%-20s|%-8s|%.2f\n", orderList.getEntry(a).getOrderID(), orderList.getEntry(a).getRestaurant(), orderList.getEntry(a).getFood(),
                        orderList.getEntry(a).getQty(), orderList.getEntry(a).getSubTotal());

                dTotal = orderList.getEntry(a).getTotalAmount();

            }

        }
        System.out.printf("\n%57s Total: RM %.2f\n", " ", dTotal);
        System.out.println("Thank you. Please come again!\n");
        System.out.print("Press Enter to Continue...");
        sc.nextLine();
        //String orderID;
        //int counter = 0;
        // orderID = String.format("ORD%03d", ++counter);
        //System.out.println("Order ID:" + orderID);
        //System.out.println("===================");
        //System.out.println("Order Confirmation");
        //System.out.println("===================");
        /*for (int j = 1; j < restaurantList.getNumberOfEntries()+1; j++) {

                if (restaurant.affID.equals(foodList.getEntry(j).getAffID())) {

                    System.out.println("Restaurant\t: " + restaurantList.getEntry(j).getRestaurantName());
                    orderID = String.format("ORD%03d", counter++);
                    System.out.println("Order ID:" + orderID);
                    System.out.println("\nFoods in system : ");
                    System.out.printf("ID   %-26s - %-10s\n", "Food Name", "Price");
                    System.out.println("==== ========================== - ==========");

                    for (int t = 1; t < foodList.getNumberOfEntries() + 1; t++) {
                        if (restaurant.getAffID().equals(foodList.getEntry(t).getAffID())) {
                            System.out.printf("%s %-26s - RM %7.2f\n", foodList.getEntry(t).foodID, foodList.getEntry(t).foodName, foodList.getEntry(t).foodPrice);
                            qty++;
                            total += subtotal;
                            //System.out.printf("Total Amount :RM %.2f\n", total);
                        }
                    }
                    System.out.println("                                  ==========");
                    System.out.printf("%34sRM %7.2f", "Total - ", total);
                    System.out.println("\n                                  ==========");

//Systsem.out.print;
                    // System.out.printf("Total Amount :RM %.2f\n", total);
                }
            }*/
    }

    public AffiliateClass selectionRes(int selection) {
        restaurantList = retrieveRestaurant();
        AffiliateClass res = restaurantList.getEntry(selection);
        return res;
    }

    public foodMenuClass selectFood(int choice, AffiliateClass res) {

        foodList = retrieveFood();
        foodMenuClass food = new foodMenuClass();

        for (int a = 1; a < foodList.getNumberOfEntries() + 1; a++) {
            if (res.getAffID().equals(foodList.getEntry(a).getAffID()) && choice == foodList.getEntry(a).getFoodCode()) {

                food = foodList.getEntry(a);

            }

        }

        return food;

    }

    

    public ListInterface<Customer> retrieveCustomer() {

        String phoneNumber;
        String option;

        try {
            try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("customer.dat"))) {
                customerList = (ListInterface<Customer>) (oiStream.readObject());

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "File not found"+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Cannot read from file"+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Class not found"+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        do {
            Scanner sc = new Scanner(System.in);

            System.out.println(customerList.getEntry(1).getPhoneNumber());
            System.out.println(customerList.getEntry(2).getPhoneNumber());
            System.out.println(customerList.getEntry(3).getPhoneNumber());
            System.out.println(customerList.getEntry(4).getPhoneNumber());

            System.out.println("Please enter you phone number : ");

            phoneNumber = sc.nextLine();
            for (int i = 1; i < customerList.getNumberOfEntries(); i++) {

                if (customerList.getEntry(i).getPhoneNumber().equals(phoneNumber)) {

                    System.out.println("Name:" + customerList.getEntry(i).getName());
                    System.out.println("Gender: " + customerList.getEntry(i).getGender());
                    System.out.println("Home Address:" + customerList.getEntry(i).getHomeAddress());
                    System.out.println("Phone Number:" + customerList.getEntry(i).getPhoneNumber());

                }

            }
            System.out.print("\nDo You want to continue to retrieve customer detail ? (yes / no): ");
            option = sc.nextLine();

        } while (option.equals("yes") || option.equals("y"));

        return customerList;

    }

  
    public ListInterface<AffiliateClass> retrieveRestaurant() {

        try {
            try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("affiliate.dat"))) {
                restaurantList = (ListInterface<AffiliateClass>) (oiStream.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return restaurantList;

    }


    public ListInterface<foodMenuClass> retrieveFood() {

        try {
            try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("foodMenu.dat"))) {
                foodList = (ListInterface<foodMenuClass>) (oiStream.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ClassNotFoundException");
        }
        return foodList;

    }

    public void addOrder() {
        
        try {
            try (ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("orderList.dat"))) {
                ooStream.writeObject(orderList);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File not found"+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cannot save to file"+ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }

    }

    public ListInterface<Order> retreiveOrder() {
        
        try {
            try (ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("orderList.dat"))) {
                orderList = (ListInterface<Order>) (oiStream.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FileNotFoundException"+ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ClassNotFoundException");
        }
        return orderList;

    }

}
