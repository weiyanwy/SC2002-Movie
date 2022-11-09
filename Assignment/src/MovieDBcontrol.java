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
    private String FileAddress;

    public MovieDBcontrol(String FileAddress) {
        this.FileAddress = FileAddress; //Input the directory where your .dat file is located
    }

    public String getFileAddress() {
        return FileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.FileAddress = fileAddress;
    }

    public void InsertMovietoDB(ArrayList<Movie> movie) throws IOException, ClassNotFoundException {

        FileOutputStream fileout = new FileOutputStream(this.FileAddress);
        ObjectOutputStream Objout = new ObjectOutputStream(fileout);


        try {
            //Write Object to datebase
            Objout.writeObject(movie);
            Objout.close();
            fileout.close();
            System.out.println("Serialized data of Movie save in Movie.txt file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movie> GetMovieFromDB() {
        ArrayList<Movie> newtemp = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(FileAddress);
            in = new ObjectInputStream(fis);
            newtemp = (ArrayList<Movie>) in.readObject();
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