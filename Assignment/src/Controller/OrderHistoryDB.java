package Controller;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Entity.*;

/// Pass Movie data to database, read and write from database
public class OrderHistoryDB {
    //Store file Address
    private String FILENAME="OrderHistory.txt";



    public String getFileAddress() {
        return FILENAME;
    }

    public void setFileAddress(String filename) {
        this.FILENAME = filename;
    }

    public void InsertBookingtoDB(OrderHist neworder) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream out;
        File data = new File(FILENAME);
        ArrayList<OrderHist> OrderHistList = new ArrayList<>();
        if(data.exists()) {
            //System.out.println("File exist");
            OrderHistList =this.GetOrderHistFromDB();
        }
        else if(data.createNewFile()){
            //System.out.println("creating new DB");
        }
        try {
                OrderHistList.add(neworder);
                fos = new FileOutputStream(FILENAME);
                out = new ObjectOutputStream(fos);
                out.writeObject(OrderHistList);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public ArrayList<OrderHist> GetOrderHistFromDB() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME));
            ArrayList<OrderHist> OrderHistList = (ArrayList<OrderHist>) in.readObject();
            in.close();
            return OrderHistList;
        } catch (ClassNotFoundException | IOException e) {
            //
        }
        return new ArrayList<OrderHist>();
    }
}