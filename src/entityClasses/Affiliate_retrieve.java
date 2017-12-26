/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityClasses;

import adt.ListInterface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author alan0
 */
public class Affiliate_retrieve {

    //    public static void readAffiliate() throws IOException, ClassNotFoundException {
    //        try {
    //            ObjectInputStream affiliateInputStream
    //                    = new ObjectInputStream(new FileInputStream("affiliate.dat"));
    //
    //            affiliateStream affS = (affiliateStream) affiliateInputStream.readObject();
    //            affiliateInputStream.close();
    //            System.out.println("\nRegistration Success\n====================================");
    //            System.out.println("Restaurant ID\t: " + affS.affID);
    //            System.out.println("Restaurant\t: " + affS.restaurantName + "\n");
    //            System.out.println("Owner's name\t: " + affS.name);
    //            System.out.println("IC number\t: " + affS.icno);
    //            System.out.println("Tel number\t: " + affS.phoneNo);
    //            System.out.println("Email\t\t: " + affS.email);
    //            System.out.println("Address\t\t: \n\t" + affS.address1 + "\n\t" + affS.address2 + "\n\t" + affS.zipCode + " " + affS.city + "\n\t" + affS.state + "\n");
    //        } catch (FileNotFoundException ex) {
    //            System.out.println("\n-- Fastest Deliveryman --\nAffiliate Details\n====================================");
    //            System.out.println("No record");
    //        }
    //    }
    public static ListInterface<AffiliateClass> retrieveAffiliate() {
        try {
            try (final ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream("affiliate.dat"))) {
                AffiliatesRegistration.affiliates = (ListInterface<AffiliateClass>) (oiStream.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("The file can not be found.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ClassNotFoundException");
        }
        return AffiliatesRegistration.affiliates;
    }
    
}
