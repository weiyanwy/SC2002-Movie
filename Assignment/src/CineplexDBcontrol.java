import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/// Pass Movie data to database, read and write from database
public class CineplexDBcontrol {
    //Store file Address
    String FileAddress = "Cineplex.txt";
    /*public CineplexDBcontrol(){
        this.FileAddress=address;
    }*/

    public void insertCineplexToDB(Cineplex cineplex) throws IOException {

        FileOutputStream fos;
        ObjectOutputStream out;
        File f = new File(FileAddress);
        ArrayList<Cineplex> cineplexArrayList = new ArrayList<>();
        if (f.exists())
            cineplexArrayList = this.GetCineplexFromDB();
        else if (f.createNewFile()) {
            System.out.println("File: " + FileAddress + " does not exist");
            System.out.println("Creating new DB");
        }
        if (checkifexit(cineplexArrayList, cineplex)) {
            try {
                fos = new FileOutputStream(FileAddress);
                out = new ObjectOutputStream(fos);
                out.writeObject(cineplex);
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean checkifexit(ArrayList<Cineplex> cineplexlist, Cineplex cine) {
        if (cineplexlist.size() > 0) {
            for (Cineplex cineplex : cineplexlist) {
                if (cine.getCineplexName().equalsIgnoreCase(cineplex.getCineplexName())) {
                    System.out.println("Cineplex Name exists");
                    return false;
                }
            }
        }
        return true;
    }

    public void OverwriteFile(ArrayList<Cineplex> cineplexlist) {
        FileOutputStream fos;
        ObjectOutputStream out;
        File f = new File(FileAddress);
        if (f.exists()) {
            f.delete();
            System.out.println("Replace with new file");
        }
        try {
            fos = new FileOutputStream(FileAddress);
            out = new ObjectOutputStream(fos);
            out.writeObject(cineplexlist);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Cineplex> GetCineplexFromDB() {
        ArrayList<Cineplex> newtemp = new ArrayList<>();
        File f = new File(FileAddress);
        FileInputStream fis;
        ObjectInputStream in;
        if (f.exists()) {
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


