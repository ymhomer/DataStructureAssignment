/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author user
 */
public interface deliveryManDetailsInterface {

    public String getNewDeliveryName();
    public String getGender();
    public String getIcNo();
    public String getPhoneNo();
    public String getHomeAddress();
    public String getEmergencyContact();
    public double getSalary();
    public String getStatus();
    public String getTypesOfFullTime();
    public int getDeliveredDonePerDay();
    public int getTotalTravelPerDay();
    public void setNewDeliveryName(String newDeliveryName);
    public void setGender(String gender);
    public void setIcNo(String icNo);
    public void setPhoneNo(String phoneNo);
    public void setHomeAddress(String homeAddress);
    public void setEmergencyContact(String emergencyContact);
    public void setSalary(double salary);
    public void setStatus(String status);
    public void setTypesOfFullTime(String typesOfFullTime);
    public void setDeliveredDonePerDay(int deliveredDonePerDay);
    public void setTotalTravelPerDay(int totalTravelPerDay);    
}
