/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ScheduleOrders implements Serializable{
    int orderID,distance,quantity,travelTime;
    String restaurant, food, custName,paymentStatus,deliveryMan,jobStatus,date,time;
    double cost, totalAmount;
   

    public ScheduleOrders() {
    }

    public ScheduleOrders(int orderID, int distance, int quantity, String restaurant, String food, String custName, String paymentStatus, String deliveryMan, double cost, double totalAmount, String date, String time,String jobStatus,int travelTime) {
        this.orderID = orderID;
        this.distance = distance;
        this.quantity = quantity;
        this.restaurant = restaurant;
        this.food = food;
        this.custName = custName;
        this.paymentStatus = paymentStatus;
        this.deliveryMan = deliveryMan;
        this.cost = cost;
        this.totalAmount = totalAmount;
        this.date = date;
        this.time = time;
        this.jobStatus = jobStatus;
        this.travelTime = travelTime;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
