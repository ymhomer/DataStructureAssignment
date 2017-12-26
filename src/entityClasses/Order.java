package entityClasses;

import java.io.Serializable;
import java.util.*;

public class Order implements Serializable {
    
    double totalAmount= 0,subTotal;
    int orderID,qty;
    String restaurant, food ,customerName,paymentStatus,dateTime,jobStatus,deliverymenID;

    public Order(int orderID) {
        this.orderID = orderID;
    }

    public Order(int orderID, int qty, String restaurant, String food, String customerName, String paymentStatus, Double totalAmount, String dateTime, String jobStatus, double subTotal,String deliverymenID) {
        this.orderID = orderID;
        this.qty = qty;
        this.restaurant = restaurant;
        this.food = food;
        this.customerName = customerName;
        this.paymentStatus = paymentStatus;
        this.totalAmount = totalAmount;
        this.dateTime = dateTime;
        this.jobStatus = jobStatus;
        this.subTotal = subTotal;
        this.deliverymenID = deliverymenID;
    }

 

    public int getOrderID() {
        return orderID;
    }

    public int getQty() {
        return qty;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getFood() {
        return food;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDateTime() {
        return dateTime;
    }


    public String getJobStatus() {
        return jobStatus;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getDeliverymenID() {
        return deliverymenID;
    }

    public void setDeliverymenID(String deliverymenID) {
        this.deliverymenID = deliverymenID;
    }
    
}
