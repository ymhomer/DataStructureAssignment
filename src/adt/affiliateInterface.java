
package adt;

import java.io.Serializable;

public interface affiliateInterface extends Serializable {

    String getAddress1();

    String getAddress2();

    String getAffID();

    String getCity();

    String getEmail();

    String getIcno();

    String getName();

    String getPassword();

    String getPasswordHit();

    String getPhoneNo();

    String getRestaurantName();

    String getRpassword();

    String getState();

    String getZipCode();

    void setAddress1(String address1);

    void setAddress2(String address2);

    void setAffID(String affID);

    void setCity(String city);

    void setEmail(String email);

    void setIcno(String icno);

    void setName(String name);

    void setPassword(String password);

    void setPasswordHit(String passwordHit);

    void setPhoneNo(String phoneNo);

    void setRestaurantName(String restaurantName);

    void setRpassword(String rpassword);

    void setState(String state);

    void setZipCode(String zipCode);
    
}
