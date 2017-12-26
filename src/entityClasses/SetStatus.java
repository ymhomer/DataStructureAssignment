/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

public class SetStatus {

    private static ListInterface<deliveryManDetails> listDeliveryMan = new LList<>(); 
    
    private Formatter fM;
    private Scanner x;

    public void input(int i, String user) {

        Scanner input = new Scanner(System.in);
        char num;

        System.out.println("**********Delivery status************\n");
        System.out.println("1. available   2. delivery   3. break for clock out");
        System.out.print("Please enter your delivery status:");
        num = input.nextLine().charAt(0);
        System.out.println("\n");

        if (Character.isDigit(num) && !Character.isSpaceChar(num)) {
            do {
                if (num == '1') {
                    addRecord(i, num);
                    input(i, user);
                } else if (num == '2') {
                    addRecord(i, num);
                    input(i, user);
                } else if (num == '3') {
                    addRecord(i, num);
                    System.exit(0);
                } else {
                    System.out.println("\nPlease enter following the numbers above\n");
                    input(i, user);
                }
            } while (num == '1' || num == '2');

        } else {
            System.err.println("\nYou can enter number only !\n");
            input(i, user);
        }

    }

    public void login() {

        Scanner userName = new Scanner(System.in);
        Scanner password = new Scanner(System.in);
        String user;
        String pass;

        System.out.print("Enter username: ");
        user = userName.next();
        System.out.print("Enter password: ");
        pass = password.next();

        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("deliveryManDetails.dat"));
            listDeliveryMan = (ListInterface<deliveryManDetails>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("You have error, found no file");
        } catch (IOException ex) {
            System.err.println("You have error");
        } catch (ClassNotFoundException ex) {
            System.err.println("You have error, found no class");
        }
        for (int i = 1; i <= listDeliveryMan.getNumberOfEntries(); i++) {
            if (user.equals(listDeliveryMan.getEntry(i).getNewDeliveryID()) && pass.equals(listDeliveryMan.getEntry(i).getPassword())) {
                if (listDeliveryMan.getEntry(i).getStatus().equals("Full-Time") || listDeliveryMan.getEntry(i).getTypesOfFullTime().equals("Available")) {
                    Calendar cal = new GregorianCalendar();
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat(" EE dd-MM-yyyy hh:mm aa");
                    String dateString = sdf.format(date);
                    listDeliveryMan.getEntry(i).setClockIn(dateString);
                    listDeliveryMan.getEntry(i).setClockOut("-");
                    try {
                        ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
                        ooStream.writeObject(listDeliveryMan);
                        ooStream.close();
                    } catch (FileNotFoundException ex) {
                        System.err.println("You have error, found no file");
                    } catch (IOException ex) {
                        System.err.println("You have error");
                    }
                    System.out.print("\nWelcome " + listDeliveryMan.getEntry(i).getNewDeliveryName() + "\n");
                    System.out.println("Date & Time you clock IN:" + dateString + "\n");
                    System.out.println("\n==============");
                    System.out.println(i + " delivery man");
                    System.out.println("==============");
                    System.out.println("Name               : " + listDeliveryMan.getEntry(i).getNewDeliveryName());
                    System.out.println("Gender             : " + listDeliveryMan.getEntry(i).getGender());
                    System.out.println("IC Number          : " + listDeliveryMan.getEntry(i).getIcNo());
                    System.out.println("Phone Number       : " + listDeliveryMan.getEntry(i).getPhoneNo());
                    System.out.println("Home Address       : " + listDeliveryMan.getEntry(i).getHomeAddress());
                    System.out.println("Emergence Contact  : " + listDeliveryMan.getEntry(i).getEmergencyContact());
                    System.out.printf("Salary             : %.2f\n", listDeliveryMan.getEntry(i).getSalary());
                    System.out.println("Status             : " + listDeliveryMan.getEntry(i).getStatus());
                    System.out.println("Types of Full Time : " + listDeliveryMan.getEntry(i).getTypesOfFullTime());
                    System.out.println("\n");
                    input(i, user);
                } else {
                    System.out.println("You are retired, hope you stay healthy!!!");
                }
            }
        }

    }

    public void openFile() {

        try {
            fM = new Formatter("Record.txt");
        } catch (Exception e) {
            System.err.println("You have error");
        }
    }

    public void addRecord(int i, char num) {
        String status;

        if (num == '1') {
            status = "AVAILABLE";
            listDeliveryMan.getEntry(i).setTypesOfFullTime(status);
            System.out.println("AVAILABLE");

        } else if (num == '2') {
            status = "DELIVERY";
            listDeliveryMan.getEntry(i).setTypesOfFullTime(status);
            System.out.println("DELIVERY");

        } else if (num == '3') {
            status = "BREAK";
            listDeliveryMan.getEntry(i).setTypesOfFullTime(status);
            System.out.println("BREAK");

            Calendar cal2 = new GregorianCalendar();
            Date date2 = cal2.getTime();
            SimpleDateFormat sdf2 = new SimpleDateFormat(" EE dd-MM-yyyy hh:mm aa");
            String dateString2 = sdf2.format(date2);
            listDeliveryMan.getEntry(i).setClockOut(dateString2);
            System.out.print("Date & Time you clock OUT:" + dateString2 + "\n");

        }
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("deliveryManDetails.dat"));
            ooStream.writeObject(listDeliveryMan);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.err.println("You have error, found no file");
        } catch (IOException ex) {
            System.err.println("You have error");
        }

    }

    public void closeFile() {
        fM.close();
    }

    public void openReadFile() {

        try {
            x = new Scanner(new File("Record.txt"));
        } catch (Exception e) {
            System.err.println("You have error");
        }
    }

    public void readFile() {
        while (x.hasNext()) {
            String a = x.next();
            System.out.printf("%s ", a);
        }
        System.out.println("\n");
    }

    public void closeReadFile() {
        x.close();
    }

}
