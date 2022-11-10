import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/// Pass Movie data to database, read and write from database
class CineplexDBcontrol {
    //Store file Address
    String FileAddress= "Cineplex.txt";
    /*public CineplexDBcontrol(){
        this.FileAddress=address;
    }*/

    public void insertCineplexToDB(ArrayList<Cineplex> cineplex) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        File f = new File(FileAddress);
        if(f.exists())
            f.delete();
            System.out.println("File Cineplexlist.txt exists.");
            System.out.println("Deleting old file.....");
        if(f.createNewFile()) {
            System.out.println("File: " + FileAddress + " does not exist");
            System.out.println("Creating new DB");
        }

        try {
            fos = new FileOutputStream(FileAddress);
            out = new ObjectOutputStream(fos);
            out.writeObject(cineplex);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Cineplex> GetCineplexFromDB() {
        ArrayList<Cineplex> newtemp = new ArrayList<>();
        File f = new File(FileAddress);
        FileInputStream fis = null;
        ObjectInputStream in = null;
        if(f.exists()) {
            try {
                fis = new FileInputStream(FileAddress);
                in = new ObjectInputStream(fis);
                newtemp = (ArrayList<Cineplex>) in.readObject();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return newtemp;
    }


}