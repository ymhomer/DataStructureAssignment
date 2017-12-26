/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.LList;
import adt.ListInterface;
import adt.deliveryManDetails;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AssignScheduleJob {
    
    private ListInterface<ScheduleOrders> scheduleList = new LList<>();
    private Scanner scanner = new Scanner (System.in);
    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>();
    
    public AssignScheduleJob(){
        
        int choose = 0;
        scheduleList = retriveSchedule();
        listDeliveryMan = retrieveDeliveryMan();
        System.out.println("This is the schedule order that havent done: ");
        /*
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            
            //System.out.println(scheduleList.getEntry(i).getDate()+ scheduleList.getEntry(i).getTime());
            System.out.println(scheduleList.getEntry(i).getDeliveryMan());
            
        }
        */
        /*
        for(int i=1 ; i < listDeliveryMan.getNumberOfEntries()+1;i ++)
        {
            
            //System.out.println(scheduleList.getEntry(i).getDate()+ scheduleList.getEntry(i).getTime());
            System.out.println(listDeliveryMan.getEntry(i).getTypesOfFullTime());
            
        }*/
        
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            if(scheduleList.getEntry(i).getDeliveryMan() == null)
            {
            System.out.println(scheduleList.getEntry(i).getOrderID());
            }
        }
        System.out.print("Please enter which Order you want to track: ");
        choose = scanner.nextInt();
        assignJob(choose);
    }
    
    public void assignJob(int orderID){
        String date = null ,time = null,foodName= null, assName = null;
        int tTime = 0, orderId=0;
        
        scheduleList = retriveSchedule();
        listDeliveryMan= retrieveDeliveryMan();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        
        //HH converts hour in 24 hours format (0-23), day calculation
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("This is the detail information for the order that havent assign delivery man");
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            if(scheduleList.getEntry(i).getDeliveryMan() == null && scheduleList.getEntry(i).getOrderID() == orderID)
            {
                date = scheduleList.getEntry(i).getDate();
                time = scheduleList.getEntry(i).getTime();
                tTime = scheduleList.getEntry(i).getTravelTime();
                orderId=scheduleList.getEntry(i).getOrderID();
                foodName = scheduleList.getEntry(i).getFood();
                
               System.out.println("\nOrderId: " + orderId);
               System.out.println("Food Name: " + foodName);
               System.out.println("Date: " + date);
               System.out.println("Time: " + time);
            }
        }
        
        
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
                
                if(diffDays == 0 && diffHours == 0 & diffMinutes == 0)
                {
                    System.out.println("This is the Avaiable Delivery Man: ");
                    for(int i=1 ; i < listDeliveryMan.getNumberOfEntries()+1;i ++)
                    {
                        if(listDeliveryMan.getEntry(i).getTypesOfFullTime().equals("AVAILABLE"))
                        {
                           System.out.println(listDeliveryMan.getEntry(i).getNewDeliveryName());
                           
                        }
                    }
                    System.out.print("Enter the name of delivery man you want to assign");
                    scanner.nextLine();
                    assName = scanner.nextLine();
                    for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
                    {
                        for(int a=1 ; a < listDeliveryMan.getNumberOfEntries()+1;a ++)
                        {
                            if(scheduleList.getEntry(i).getOrderID() == orderID && listDeliveryMan.getEntry(a).getNewDeliveryName().equals(assName))
                            {
                               scheduleList.getEntry(i).setDeliveryMan(assName);
                               listDeliveryMan.getEntry(a).setTypesOfFullTime("delivery");
                            }
                        }
                    }
                    storeSchedule();
                    storeDeliveryMan();
                    System.out.println("\nThe schedule order have done");
                }
                else
                {
                    System.out.println("\nRemaining Time havent Finish, Cannot Done the Order");
                    System.out.print("\n");
                    System.out.print("The remaining time that the assign the free delivery man to schedule order is "+diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes");
                }
                
		

	} catch (Exception e) {
		e.printStackTrace();
	}

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
    public void storeDeliveryMan(){
        
        try {
           
            
        ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
        ooStream.writeObject(listDeliveryMan);
        ooStream.close();
       
        } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
        System.out.print(ex.getMessage());
        }
    }
    
    
    
    public ListInterface<deliveryManDetails> retrieveDeliveryMan(){
        try {
              ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManDetails.dat"));
              listDeliveryMan = (ListInterface<deliveryManDetails>) (oiStream.readObject());
              oiStream.close();
            } catch (FileNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "File not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, "Cannot read from file", "ERROR", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Class not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        return listDeliveryMan;
    }
}
