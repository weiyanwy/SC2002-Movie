import java.io.IOException;
import java.util.Scanner;

public class PriceSetting {
    PriceDBcontrol priceDB = new PriceDBcontrol();
    Scanner sc = new Scanner(System.in);
    public void RunPriceSetup() throws IOException {
        System.out.println("Set Price of tickets");
        System.out.println("General Price:");
        double Generalprice= Double.parseDouble(sc.nextLine());
        System.out.println("Senior Discount:");
        double SeniorDiscount = -1 * Double.parseDouble(sc.nextLine());
        System.out.println("Student Discount:");
        double StudentDiscount = -1* Double.parseDouble(sc.nextLine());
        System.out.println("Extra fee for Blockbuster movie:");
        double Blockbuster= Double.parseDouble(sc.nextLine());
        System.out.println("Enter GST rate %");
        double GST= Double.parseDouble(sc.nextLine()) / 100;
        System.out.println("Enter extra fee for Thursday/Closer to weekend:");
        double NearWeekend = Double.parseDouble(sc.nextLine());
        System.out.println("Enter extra fee for Fri-Sun:");
        double weekend=Double.parseDouble(sc.nextLine());
        System.out.println("Enter 3D movie price during weekday: ");
        double weekday3D = Double.parseDouble(sc.nextLine());
        System.out.println("Enter 3D movie price during weekend: ");
        double weekend3D= Double.parseDouble(sc.nextLine());
        System.out.println("Enter multiplier rate for 'Gold' type cinema: ");
        double rateGold = Double.parseDouble(sc.nextLine());
        System.out.println("Enter multiplier rate for 'Platinum' type cinema:" );
        double ratePlat = Double.parseDouble(sc.nextLine());
        System.out.println("Enter multiplier rate for Public Holiday: ");
        double PH= Double.parseDouble(sc.nextLine());
        Pricing temp = new Pricing();
        temp.setPricing(Generalprice, SeniorDiscount, StudentDiscount, Blockbuster, GST, NearWeekend, weekend, weekday3D, weekend3D, rateGold, ratePlat,PH);
        temp.printrate();
        priceDB.insertPriceToDB(temp);
    }
}
