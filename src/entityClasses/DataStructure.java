/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;
import adt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class DataStructure {
    
    private Customer c1 = new Customer("Ong Chong Ren","cr","asd123","Customer",85000,"Male", "12,Jalan Prima,Taman Prima ", "012-3456789");
    private Customer c2 = new Customer("Ong Chun Wei","cw","qwe123","Customer",53000,"Male","PV20,Taman Danau Kota", "017-1234567");
    private Customer c3 = new Customer("Tan Wei Jie","wj","zxc123","Customer",81000,"Male","Jalan Prima Setapak,Taman Prima", "012-4567890");
    private Customer c4 = new Customer("Ng De Bao", "db","tyu123" ,"Customer",82000,"Male","PV16,Taman Danau Kota", "012-7894561");
    private Customer c5 = new Customer("Tan Kai Lun", "kl","uio123" ,"Customer",83000,"Male", "PV15,Taman Danau Kota", "017-7853329");
    
    private ListInterface<Customer> customerList = new LList<>();
    private ListInterface<AffiliateClass> resList = new LList<>();
    private ListInterface<foodMenuClass> foodList = new LList<>();
    private ListInterface<ScheduleOrders> scheduleList = new LList<>();
   private Scanner scanner = new Scanner (System.in);
    public DataStructure() {
       
        
        //d.storeCustomer();
        loginSystem(); 
       //d.report();
        //d.test();
       //d.assignJob();
       /*
       ListInterface<Customer> customerList = new LList<>();
               customerList =  d.retriveCustomer();
               for(int i=1 ; i < customerList.getNumberOfEntries()+1;i ++)
        {
            System.out.println(customerList.getEntry(i).getName());
        }*/
    }
    
    public void test(){
        scheduleList = retriveSchedule(); 
        
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            System.out.println(scheduleList.getEntry(i).getTime());
        }
        /*
         foodList = retriveFood(); 
        
        for(int i=1 ; i < foodList.getNumberOfEntries()+1;i ++)
        {
            System.out.println(foodList.getEntry(i).getFoodName());
        }*/
        /*
        resList = retriveRes(); 
        
        for(int i=1 ; i < resList.getNumberOfEntries()+1;i ++)
        {
            System.out.println(resList.getEntry(i).getUserID());
        }*/
        /*
        customerList = retriveCustomer(); 
        
        for(int i=1 ; i < customerList.getNumberOfEntries()+1;i ++)
        {
            System.out.println(customerList.getEntry(i).getName());
        }
         
        try {
        customerList.add(c5);
        ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("customer.dat"));
        ooStream.writeObject(customerList);
        ooStream.close();
       
        } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
        System.out.print(ex.getMessage());
        }*/
    }
    
    public void loginSystem(){
        System.out.println("\nChoose your roles to login; ");
        System.out.println("1. Customer login ");
        System.out.println("2. Human Resource Manager Login ");
        System.out.println("3. Delivery ");
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();
        
        if(choice == 1)
        {
            custLoginSystem();
        }
        else if (choice == 2)
        {
            
        }
        else if(choice == 3)
        {
            
        }
    }
    
    public void custLoginSystem(){
        String userN = null;
        String pass = null;
        
        System.out.println("\nCustomer Login Validation");
         System.out.print("User Name: ");
         scanner.nextLine();
        userN = scanner.nextLine();
        System.out.print("Password: ");
        pass = scanner.nextLine();
        boolean valid = custValidation(userN,pass);
        
        if(valid == true)  
        {
            Customer customer = custInfo(userN,pass);
            menu(customer);
        }
        else
        {
            System.out.print("The Password or User name are wrong!! Please enter again!!");
            custLoginSystem();
        }
        
    }
    
    public void menu(Customer cust){
        System.out.println("\nHello " + cust.getName());
        System.out.println("\nPlease Select what thing you want to do");
        System.out.println("1. Make Real Time Order");
        System.out.println("2. Make Schedule Order");
        System.out.println("3. View Schedule Order Report");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        if(choice == 1)
        {
            new OrderMain(cust);
        }
        else if (choice == 2)
        {
            scheduleOrders(cust);
        }
        else if (choice == 3)
        {
            report();
        }
    }
    
    public void scheduleOrders(Customer cust){
        resList = retriveRes();
        foodList = retriveFood();
        scheduleList = retriveSchedule();
        
        int i=0, choice,foodChoice,quantity,sOrder=1000,distance,tTime;
        double total,cost;
        String date = null,time,yesNo;
        
        sOrder = scheduleList.getEntry(scheduleList.getNumberOfEntries()).getOrderID() + 1;
        System.out.println("\nMake Schedule Orders");
        System.out.println("Here is the restaurant that you can choose: ");
        for(i=1;i<resList.getNumberOfEntries()+1;i++)
        {
            System.out.println(i+". "+ resList.getEntry(i).getRestaurantName());
        }
        System.out.print("Please choose which restaurant that you want: ");
        choice = scanner.nextInt();
        AffiliateClass res = selectRes(choice);
        do{
           int z = 1;
        System.out.println("\nHere is the "+ res.getRestaurantName()+ " food that you can choose: ");
        for(int a =1; a < foodList.getNumberOfEntries()+1;a++)
        {
            if(res.getAffID().equals(foodList.getEntry(a).getAffID()))
            {
                System.out.println(z+". "+ foodList.getEntry(a).getFoodName());
                z++;
            }
        }
        System.out.print("Please choose which food that you want: ");
        foodChoice = scanner.nextInt();  
        foodMenuClass food = selectFood(foodChoice,res);
        System.out.print("Please enter the quantity: ");
        quantity = scanner.nextInt();
        total = quantity * food.getFoodPrice();
        System.out.printf("Total Amount: %.2f",total);
        ScheduleOrders s1 = new ScheduleOrders(sOrder,0,quantity,res.getRestaurantName(),food.getFoodName(),cust.getName(),"Unpaid",null,0,total,null,null,"Undone",0);
        scheduleList.add(s1);
        System.out.print("\nDo you want to continue set more food to your schedule order? (yes/no) ");
        scanner.nextLine();
        yesNo = scanner.nextLine();
        }while(yesNo.equals("yes"));
        
        
        date = selectDate();
        System.out.print("\nThis is the date that you already choose: "+date);
        System.out.print("\nPlease enter what time you want to deliver: (e.g 04:10) ");
        scanner.nextLine();
        time = scanner.nextLine();
        distance = distance(res,cust);
        System.out.print("\nThis is your total distance that needed to travel "+ distance+" km");
        cost = cost(distance);
        System.out.printf("\nThis is the petrol cost that you used in one deliver %.2f",cost);
        tTime = time(distance);
        if(tTime > 60)
        {
            tTime = tTime/60;
            System.out.print("\nThis is the travel you needed for this time deliver "+tTime +" hours");
        }
        else
        {
            System.out.print("\nThis is the travel you needed for this time deliver "+tTime +" minutes");
        }
        for(int y =1; y < scheduleList.getNumberOfEntries()+1;y++)
        {
            if(scheduleList.getEntry(y).getOrderID() == sOrder)
            {
                scheduleList.getEntry(y).setDate(date);
                scheduleList.getEntry(y).setTime(time);
                scheduleList.getEntry(y).setDistance(distance);
                scheduleList.getEntry(y).setCost(cost);
                scheduleList.getEntry(y).setTravelTime(tTime);
            }
        }
        calculateRemainingTime(date,time);
        storeSchedule();
        
    }
    public int distance(AffiliateClass res, Customer cust){
        int distance = 0;
        if(cust.getAreaCode() == 85000 && res.getZipCode().equals("53100") )
        {
            distance = 4;
        }
        else if(cust.getAreaCode() == 85000 && res.getZipCode().equals("53300"))
        {
            distance = 3;
        }
        else if(cust.getAreaCode() == 53000 && res.getZipCode().equals("53100"))
        {
            distance = 15;
        }
        else if(cust.getAreaCode() == 53000 && res.getZipCode().equals("53300"))
        {
            distance = 16;
        }
        
        return distance;
    }
    
    public void calculateRemainingTime(String date, String time){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        
	String dateStop = date +" "+ time;
	//HH converts hour in 24 hours format (0-23), day calculation
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	Date d1 = null;
	Date d2 = null;

	try {
		d1 = c.getTime();
		d2 = format.parse(dateStop);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
                
                System.out.print("\n");
                System.out.print("The remaining time that the food will deliver to your house is "+diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes");
		

	} catch (Exception e) {
		e.printStackTrace();
	}

    }
    
    public void assignJob(){
        String date = null ,time = null,foodName= null;
        int tTime = 0, orderId=0;
        foodList = retriveFood();
        scheduleList = retriveSchedule();
        
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        
        //HH converts hour in 24 hours format (0-23), day calculation
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            if(scheduleList.getEntry(i).getDeliveryMan() == null)
            {
                date = scheduleList.getEntry(scheduleList.getNumberOfEntries()).getDate();
                time = scheduleList.getEntry(scheduleList.getNumberOfEntries()).getTime();
                tTime = scheduleList.getEntry(scheduleList.getNumberOfEntries()).getTravelTime();
                orderId=scheduleList.getEntry(scheduleList.getNumberOfEntries()).getOrderID();
               
            }
        }
        System.out.println("This is current schedule order that does not have delivery man");
        System.out.println("OrderId: " + orderId);
        
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        if(tTime<10)
        {
        System.out.println("Time needed delivery to customer: " + tTime + " hour");
        }
        else
        {
            System.out.println("Time needed delivery to customer: " + tTime + " minutes");
        }
        String dateStop = date +" "+ time;
        
        Date date1 = null;
        try{
         date1 = format.parse(dateStop);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
            if(tTime < 10)
            {
                c1.add(Calendar.HOUR, -tTime);
            }
            else
            {
                c1.add(Calendar.MINUTE, -tTime);
            }
            dateStop=format.format(c1.getTime());
        }catch(Exception ex)
        {
            
        }

	Date d1 = null;
	Date d2 = null;

	try {
		d1 = c.getTime();
		d2 = format.parse(dateStop);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
                
                
                System.out.print("The remaining time that the assign the free delivery man to schedule order is "+diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes");
		

	} catch (Exception e) {
		e.printStackTrace();
	}

    }
    
    
    public void report(){
        double total= 0;
        scheduleList = retriveSchedule();
        System.out.println("Total Schedule Orders Sale Report");
        for(int i=1; i<scheduleList.getNumberOfEntries()+1;i++)
        {
            total += scheduleList.getEntry(i).getTotalAmount();
        }
        System.out.printf("This is the total income from schedule order: RM%.2f\n",total);
    }
    
    public double cost(int distance){
        double cost = distance * 0.24;
        return cost;
    }
    
    public int time(int distance){
        int time =distance * 10;
        return time;
    }
    
    public boolean custValidation(String userN, String pass){
        boolean valid = false;
        customerList = retriveCustomer();
        for(int i =1; i<customerList.getNumberOfEntries() +1 ; i++)
        {
            if(userN.equals(customerList.getEntry(i).getUserName()) && pass.equals(customerList.getEntry(i).getPass()) && customerList.getEntry(i).getPosition().equals("Customer"))
            {
               
                valid = true;
            }
            
        }
        return valid;
    }
    
    public Customer custInfo(String userN, String pass){
        Customer customer = new Customer();
        
        customerList = retriveCustomer();
        for(int i =1; i<customerList.getNumberOfEntries() +1 ; i++)
        {
            if(userN.equals(customerList.getEntry(i).getUserName()) && pass.equals(customerList.getEntry(i).getPass()) && customerList.getEntry(i).getPosition().equals("Customer"))
            {
               
                customer = customerList.getEntry(i);
            }
            
        }
        return customer;
    }
    
    public AffiliateClass selectRes(int choice){
       resList = retriveRes();
       AffiliateClass res = resList.getEntry(choice);
       return res;
    }
    
    public foodMenuClass selectFood(int choice,AffiliateClass res){
       foodList = retriveFood();
       foodMenuClass food = new foodMenuClass();
       for(int a =1; a < foodList.getNumberOfEntries()+1;a++)
        {
            if(res.getAffID().equals(foodList.getEntry(a).getAffID()) &&  choice == foodList.getEntry(a).getFoodCode())
            {
               food = foodList.getEntry(a);
            }
        }
       return food;
    }
    
    public String selectDate(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormat = null;
        System.out.println("\n Please choose when you want to delivery the food");
        System.out.println("1. Tommorow");
        System.out.println("2. Day after tommorow");
        System.out.println("3. 3 day from now");
        System.out.println("4. 4 day from now");
        System.out.println("5. 5 day from now");
        System.out.println("6. 6 day from now");
        System.out.println("7. 7 day from now");
        System.out.print("Please select: ");
        int dayChoice = scanner.nextInt();
        
        if(dayChoice == 1)
        {
            c.add(Calendar.DATE, 1);
            dateFormat = format1.format(c.getTime());
        }
        else if(dayChoice == 2)
        {
            c.add(Calendar.DATE, 2);
            dateFormat = format1.format(c.getTime());
           
        }
        else if(dayChoice == 3)
        {
            c.add(Calendar.DATE, 3);
            dateFormat = format1.format(c.getTime());
      
        }
        else if(dayChoice == 4)
        {
            c.add(Calendar.DATE, 4);
            dateFormat = format1.format(c.getTime());
           
        }
        else if(dayChoice == 5)
        {
            c.add(Calendar.DATE, 5);
            dateFormat = format1.format(c.getTime());
           
        }
        else if(dayChoice == 6)
        {
            c.add(Calendar.DATE, 6);
            dateFormat = format1.format(c.getTime());
            
        }
        else if(dayChoice == 7)
        {
            c.add(Calendar.DATE, 7);
            dateFormat = format1.format(c.getTime());
           
        }
        return dateFormat;
    }
    
    public void storeCustomer(){
        
        try {
            customerList.add(c1);
            customerList.add(c2);
            customerList.add(c3);
            customerList.add(c4);
            customerList.add(c5);
        ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("customer.dat"));
        ooStream.writeObject(customerList);
        ooStream.close();
       
        } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
        System.out.print(ex.getMessage());
        }
    }
    
    public ListInterface<Customer> retriveCustomer(){
        try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("customer.dat"));
      customerList = (ListInterface<Customer>) (oiStream.readObject());
      oiStream.close();
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        return customerList;
    }
    
    
    public ListInterface<AffiliateClass> retriveRes(){
        try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("affiliate.dat"));
      resList = (ListInterface<AffiliateClass>) (oiStream.readObject());
      oiStream.close();
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        return resList;
    }
   
    
    public ListInterface<foodMenuClass> retriveFood(){
        try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("foodMenu.dat"));
      foodList = (ListInterface<foodMenuClass>) (oiStream.readObject());
      oiStream.close();
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        return foodList;
    }
    
    public void storeSchedule(){
        
        try {
           
            
        ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("schedule.dat"));
        ooStream.writeObject(scheduleList);
        ooStream.close();
       
        } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
        System.out.print(ex.getMessage());
        }
    }
    
    public ListInterface<ScheduleOrders> retriveSchedule(){
        try {
      ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("schedule.dat"));
      scheduleList = (ListInterface<ScheduleOrders>) (oiStream.readObject());
      oiStream.close();
    } catch (FileNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ClassNotFoundException ex) {
      JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
        return scheduleList;
    }
}
