import java.io.*;


public class PriceDBcontrol {
    String FileAddress="Pricing.txt";

    public void insertPriceToDB(Pricing price) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream out;
        File f = new File(FileAddress);

        if (f.exists()) {
            f.delete();
            try {
                fos = new FileOutputStream(FileAddress);
                out = new ObjectOutputStream(fos);
                out.writeObject(price);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public Pricing GetPriceFromDB() {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FileAddress));
            Pricing price = (Pricing) in.readObject();
            in.close();
            return price;
        } catch (ClassNotFoundException | IOException e) {
            //
        }
        return new Pricing();
    }
}
