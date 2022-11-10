import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/// Pass Movie data to database, read and write from database
public class MovieDBcontrol {
    //Store file Address
    private String filename="Movielist.txt";



    public String getFileAddress() {
        return filename;
    }

    public void setFileAddress(String filename) {
        this.filename = filename;
    }

    public void insertMovieToDB(ArrayList<Movie> Movielist) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

            File f = new File(filename);
            if (f.exists()) {
                f.delete();
                System.out.println("File Movielist.txt exists.");
                System.out.println("Deleting old file.....");
            }
            if (f.createNewFile()) {
                System.out.println("File created: " + filename);
            }

        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(Movielist);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Movie> GetMovieFromDB() {
        ArrayList<Movie> newtemp = new ArrayList<>();
        File f = new File(filename);
        FileInputStream fis = null;
        ObjectInputStream in = null;
        if(f.exists()) {
            try {
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
                newtemp = (ArrayList<Movie>) in.readObject();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return newtemp;
    }
    // replace the old file w new.
    public void updateExistingFile(ArrayList<Movie> newData) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        File f = new File("Movielist.txt");
        if(f.exists())
            f.delete();
        else
            System.out.println("File: " + "Movielist.txt" + " does not exist");
        try {
            fos = new FileOutputStream("Movielist.txt");
            out = new ObjectOutputStream(fos);
            out.writeObject(newData);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

}