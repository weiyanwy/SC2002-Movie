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
    private String FILENAME="Movielist.txt";



    public String getFileAddress() {
        return FILENAME;
    }

    public void setFileAddress(String filename) {
        this.FILENAME = filename;
    }

    public void addMovie(Movie addmovie)  {
        File data = new File(FILENAME);
        ArrayList<Movie> movies = new ArrayList<>();
        if(data.exists()){
            movies = GetMovieFromDB();
            if(movies.size()!=0){
                for (Movie movie : movies) {
                    if (movie.getTitle().equals(addmovie.getTitle())) {
                        System.out.println("Movie Exist");
                    }
                }
            }

        }

        Movie movieToBeAdded = addmovie;

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
            movies.add(movieToBeAdded);
            outputStream.writeObject(movies);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("caught on add movie");
        }
    }

    public ArrayList<Movie> GetMovieFromDB() {
        ArrayList<Movie> MovieList;
        File f = new File(FILENAME);
        FileInputStream fis = null;
        ObjectInputStream in = null;
        System.out.println("i tried");
        try {
            fis = new FileInputStream(f);
            in = new ObjectInputStream(fis);
            MovieList = (ArrayList<Movie>) in.readObject();
            in.close();
            return MovieList;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }

    }
    // replace the old file w new.
    public void overwriteMovieList(ArrayList<Movie> data){
        File temp = new File(FILENAME);
        if(temp.exists()){
            temp.delete();
            System.out.println("file deleted");
        }
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
            outputStream.writeObject(data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e){
            System.out.println("caught in moviecontroller");
        }
    }

    }
