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

    public void addMovie(Movie newmovie) throws IOException {
        FileOutputStream fos;
        ObjectOutputStream out;
        File data = new File(FILENAME);
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        if(data.exists()) {
            movieArrayList =this.GetMovieFromDB();
        }
        else if(data.createNewFile()){
            System.out.println("creating new DB");
        }
        if(checkifexist(movieArrayList, newmovie)) {
            movieArrayList.add(newmovie);
            try {
                fos = new FileOutputStream(FILENAME);
                out = new ObjectOutputStream(fos);
                out.writeObject(movieArrayList);
                out.close();
                System.out.println("Movie: "+newmovie.getTitle()+" inserted to DataBase");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean checkifexist(ArrayList<Movie> movielist, Movie newmovie) {

        if (movielist.size() > 0) {
            for (Movie movies : movielist) {
                if (newmovie.getTitle().equalsIgnoreCase(movies.getTitle())) {
                    System.out.println("Movie Name exists");
                    return false;
                }
            }
            return true;
        }
        return true;
    }
    public ArrayList<Movie> GetMovieFromDB() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME));
            ArrayList<Movie> MovieList = (ArrayList<Movie>) in.readObject();
            in.close();
            return MovieList;
        } catch (ClassNotFoundException | IOException e) {
            //
        }
        return new ArrayList<Movie>();
    }


    // replace the old file w new.
    public void overwriteMovieList(ArrayList<Movie> data){
        File temp = new File(FILENAME);
        if(temp.exists()){
            temp.delete();
            //System.out.println("file deleted");
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
