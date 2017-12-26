/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.LList;
import adt.ListInterface;
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
public class trackScheduleTime {
    
    private ListInterface<ScheduleOrders> scheduleList = new LList<>();
    private Scanner scanner = new Scanner (System.in);
    public trackScheduleTime(){
        int choose = 0;
        scheduleList = retriveSchedule();
        System.out.println("This is the schedule order that havent done: ");
        /*
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            
            //System.out.println(scheduleList.getEntry(i).getDate()+ scheduleList.getEntry(i).getTime());
            System.out.println(scheduleList.getEntry(i).getJobStatus());
            
        }*/
        
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            if(scheduleList.getEntry(i).getJobStatus().equals("Undone"))
            {
            System.out.println(scheduleList.getEntry(i).getOrderID());
            }
        }
        System.out.print("Please enter which Order you want to track: ");
        choose = scanner.nextInt();
        calculateRemainingTime(choose);
    }
    
    public void calculateRemainingTime(int orderID){
        String date = null , time = null;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        scheduleList = retriveSchedule();
        for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
        {
            if(scheduleList.getEntry(i).getOrderID() == orderID)
            {
               date = scheduleList.getEntry(i).getDate();
               time = scheduleList.getEntry(i).getTime();
            }
        }
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
                
                
		
                if(diffDays == 0 && diffHours == 0 & diffMinutes == 0)
                {
                    for(int i=1 ; i < scheduleList.getNumberOfEntries()+1;i ++)
                    {
                        if(scheduleList.getEntry(i).getOrderID() == orderID)
                        {
                           scheduleList.getEntry(i).setJobStatus("Done");
                           
                        }
                    }
                    storeSchedule();
                    System.out.println("\nThe schedule order have done");
                }
                else
                {
                    System.out.println("\nRemaining Time havent Finish, Cannot Done the Order");
                    System.out.print("\n");
                    System.out.print("The remaining time that the food will deliver to your house is "+diffDays + " days, "+diffHours + " hours, "+diffMinutes + " minutes");
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
}
