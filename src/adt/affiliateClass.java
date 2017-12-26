
package adt;

import java.io.Serializable;

public class affiliateClass implements affiliateInterface  {

    public String password;
    public String state;
    public String name;
    public String phoneNo;
    public String email;
    public String address2;
    public String icno;
    public String city;
    public String zipCode;
    public String restaurantName;
    public String rpassword;
    public String address1;
    public String affID;
    public String passwordHit;
    
    public affiliateClass(String affID, String password, String rpassword, String passwordHit, String name, String restaurantName, String email, String icno, String phoneNo, String address1, String address2, String city, String state, String zipCode) {
        this.affID = affID;
        this.password = password;
        this.rpassword = rpassword;
        this.passwordHit = passwordHit;
        this.name = name;
        this.restaurantName = restaurantName;
        this.email = email;
        this.icno = icno;
        this.phoneNo = phoneNo;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public affiliateClass() {
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRpassword() {
        return rpassword;
    }

    @Override
    public void setAffID(String affID) {
        this.affID = affID;
    }

    @Override
    public String getAffID() {
        return affID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String getAddress2() {
        return address2;
    }

    @Override
    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    @Override
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getIcno() {
        return icno;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public void setPasswordHit(String passwordHit) {
        this.passwordHit = passwordHit;
    }

    @Override
    public void setIcno(String icno) {
        this.icno = icno;
    }

    @Override
    public String getAddress1() {
        return address1;
    }

    @Override
    public String getPasswordHit() {
        return passwordHit;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    
}
