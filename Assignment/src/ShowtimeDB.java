import java.io.*;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ShowtimeDB {


    /// Pass Movie data to database, read and write from database
    //Store file Address
        private String FileAddress;

        public ShowtimeDB(String FileAddress) {
            this.FileAddress = FileAddress; //Input the directory where your .dat file is located
        }

        public String getFileAddress() {
            return FileAddress;
        }

        public void setFileAddress(String fileAddress) {
            this.FileAddress = fileAddress;
        }

        public void InsertShowtimetoDB(ArrayList<Showtime> showtime) throws IOException, ClassNotFoundException {

            FileOutputStream fileout = new FileOutputStream(this.FileAddress);
            ObjectOutputStream Objout = new ObjectOutputStream(fileout);
            File fpos = new File(FileAddress);
            if(fpos.exists())
                fpos.delete();
            try {
                //Write Object to datebase
                Objout.writeObject(showtime);
                Objout.close();
                fileout.close();
                System.out.println("Serialized data of Movie save in Showtime.txt file");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Showtime> GetShowtimeFromDB() throws IOException, ClassNotFoundException {
            ArrayList<Showtime> newtemp = null;
            FileInputStream fis = null;
            ObjectInputStream in = null;

            try {
                fis = new FileInputStream(FileAddress);
                in = new ObjectInputStream(fis);
                newtemp = (ArrayList<Showtime>) in.readObject();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            return newtemp;
        }
        // replace the old file w new.



    }
}
