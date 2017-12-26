package entityClasses;

import adt.LList;
import adt.ListInterface;
import static entityClasses.AffiliateMenu.affMenu;
import java.util.Scanner;

public class AffiliateLogin {

    static Scanner sc = new Scanner(System.in);
    static String affID_login, pass_login, err_message = "";
    static String loginedID,loginOwner;
    static ListInterface<AffiliateClass> affiliates = new LList<>();

    public static void main(String[] args) {
        AffiliateLogin();
    }

    public static void AffiliateLogin() {
        affiliates = Affiliate_retrieve.retrieveAffiliate();

        System.out.println("\n-- Fastest Deliveryman --\nAffiliates Login\n====================================");
        System.out.print("Affiliate ID\t: ");
        affID_login = sc.nextLine();
        System.out.print("Password\t: ");
        pass_login = sc.nextLine();

        for (int j = 1; j < affiliates.getNumberOfEntries() + 1; j++) {
            if (affID_login.equals(affiliates.getEntry(j).getAffID())) {
                if (pass_login.equals(affiliates.getEntry(j).getPassword())) {
                    loginedID = affiliates.getEntry(j).getAffID();
                    loginOwner = affiliates.getEntry(j).getName();
                    System.out.println("\n\nLogin Success!\nWelcome " + loginOwner + ".");
                    affMenu();
                    break;
                }
            } else {
                err_message = "Login fail.\nPlease try the correct affiliate ID and Password.";
            }
        }
        if (err_message != null) {
            System.out.println(err_message);
        }
    }
}
