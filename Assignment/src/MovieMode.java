import java.util.ArrayList;
import java.util.Scanner;

public class MovieMode {
    DBaddress address;
    MovieDBcontrol moviedb;//= new MovieDBcontrol(address.getMovieDBAddress());

    Scanner sc = new Scanner(System.in);

    public void viewMovie(){
        ArrayList<Movie>movielist=moviedb.GetMovieFromDB();
        int sel;
        boolean exit = true;
        if(movielist.size()>0){
            for(int x=0; x<movielist.size(); x++){
                System.out.println("#"+(x+1)+ " "+ movielist.get(x).getTitle());
        }
            while(exit){
                try {
                    System.out.println("Enter Movie Index to view details:");
                    System.out.println("Enter 0 to exit");
                    sel = Integer.parseInt(sc.nextLine());
                    if(sel==0){
                        System.out.println("Exiting View Movie....");
                        exit=false;
                        break;
                    }
                    if(CheckinMovielist(sel))
                        movielist.get(sel-1).rundetails();
                }
                catch(Exception e){
                    System.out.println("Invalid input");
                }
            }
        }
        else{
            System.out.println("Movie List is Empty");
        }
    }
    public boolean CheckinMovielist(int sel){
        ArrayList<Movie>movielist=moviedb.GetMovieFromDB();
        if(sel>0 && sel<=movielist.size())
            return true;
        else
            return false;
    }

    public void SearchMovie(String MovieName){
        ArrayList<Movie>movielist=moviedb.GetMovieFromDB();
        if(movielist.size()>0){
            for(int x=0; x<movielist.size(); x++){
                if(movielist.get(x).getTitle().equalsIgnoreCase(MovieName)){
                    System.out.println("Movie Found");
                    movielist.get(x).rundetails();
                    break;
                }
            }
            System.out.println("Movie Not Found");
        }
        else
            System.out.println("Movie List is Empty");
    }

    public void updateMovieReview(){
        ArrayList<Movie>movielist=moviedb.GetMovieFromDB();
        int sel;
        boolean exit = true;
        if(movielist.size()>0){
            for(int x=0; x<movielist.size(); x++){
                System.out.println("#"+(x+1)+ " "+ movielist.get(x).getTitle());
            }
            while(exit){
                try {
                    System.out.println("Enter Movie Index to add review:");
                    System.out.println("Enter 0 to exit");
                    sel = Integer.parseInt(sc.nextLine());
                    if(sel==0){
                        System.out.println("Exiting Movie Reviews....");
                        break;
                    }
                    if(CheckinMovielist(sel)) {
                        System.out.println("Enter review:");
                        String newReview=sc.nextLine();
                        movielist.get(sel - 1).updateReview(newReview);
                        moviedb.overwriteMovieList(movielist);
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid input");
                }
            }
        }
        else{
            System.out.println("Movie List is Empty");
        }
    }
}
