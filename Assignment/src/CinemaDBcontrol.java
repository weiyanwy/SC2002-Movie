import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/// Pass Movie data to database, read and write from database
public class CinemaDBcontrol {
    //Store file Address
    private String FileAddress;

    public CinemaDBcontrol(String FileAddress) {
        this.FileAddress = FileAddress; //Input the directory where your .dat file is located
    }

    public String getFileAddress() {
        return FileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.FileAddress = fileAddress;
    }

    public void InsertCinematoDB(String title, String Synopsis, String Director, String MainCast, String Genre,
                                int runtime, MovieStatus status, MovieRestriction movierestrict) throws IOException, ClassNotFoundException {

        FileOutputStream fileout = new FileOutputStream(this.FileAddress);
        ObjectOutputStream Objout = new ObjectOutputStream(fileout);
        Movie NewMovie = new Movie(title, Synopsis, Director, MainCast, Genre, runtime, status, movierestrict);

        try {
            //Write Object to datebase
            Objout.writeObject(NewMovie);
            Objout.close();
            fileout.close();
            System.out.println("Serialized data of Movie save in Movie.txt file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Movie[] GetCinemaFromDB() {
        Movie[] newtemp = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(FileAddress);
            in = new ObjectInputStream(fis);
            newtemp = (Movie[]) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return newtemp;
    }
    // replace the old file w new.
    public void UpdateCinematoDB(Movie[] movielist) throws IOException, ClassNotFoundException{
        FileOutputStream fileout = new FileOutputStream(this.FileAddress);
        ObjectOutputStream Objout = new ObjectOutputStream(fileout);
        try {
            //Write Object to datebase
            Objout.writeObject(movielist);
            Objout.close();
            fileout.close();
            System.out.println("Serialized data of Movie save in Movie.txt file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}