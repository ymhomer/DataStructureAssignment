
package entityClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Affiliate_save {

    public static void saveAffiliate() {
        try {
            try (final ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream("affiliate.dat"))) {
                ooStream.writeObject(AffiliatesRegistration.affiliates);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("IOException");
        }
    }
    
}
