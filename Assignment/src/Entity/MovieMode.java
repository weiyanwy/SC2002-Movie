package Entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import Controller.*;

public class MovieMode {

    MovieDBcontrol moviedb = new MovieDBcontrol();//= new MovieDBcontrol(address.getMovieDBAddress());
    MovieSettings movieSettings = new MovieSettings();
    Scanner sc = new Scanner(System.in);

    public void viewMovie() {
        ArrayList<Movie> movielist = moviedb.GetMovieFromDB();
        int sel;
        boolean exit = true;
        if (movielist.size() > 0) {
            while (exit) {
                movieSettings.printmovietitle(movielist);
                try {
                    System.out.println("Enter Movie Index to view details:");
                    System.out.println("Enter 0 to exit");
                    sel = Integer.parseInt(sc.nextLine());
                    if (sel == 0) {
                        System.out.println("Exiting View Movie....");
                        break;
                    }
                    if (CheckinMovielist(sel))
                        movielist.get(sel - 1).rundetails();
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }
        } else
            System.out.println("Movie List is Empty");
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
        if(movielist.size()>0){
        boolean exit = true;
            while(exit){
                movieSettings.printmovietitle(movielist);
                try {
                    System.out.println("Enter Movie Index to add review:");
                    System.out.println("Enter 0 to exit");
                    sel = Integer.parseInt(sc.nextLine());
                    if(sel==0){
                        System.out.println("Exiting Movie Reviews....");
                        exit=false;
                        break;
                    }
                    if(CheckinMovielist(sel)) {
                        System.out.println("Enter review:");
                        String newReview=sc.nextLine();
                        movielist.get(sel - 1).updateReview(newReview);
                        movielist.get(sel-1).viewReviews();

                    }
                }
                catch(Exception e){
                    System.out.println("Invalid input");
                }
            }
            moviedb.overwriteMovieList(movielist);
        }
        else{
            System.out.println("Movie List is Empty");
        }
    }
    public void listByReviews() {
        ArrayList<Movie> movielist = moviedb.GetMovieFromDB();
        movielist.sort(new SortbyRating());
        int top5 = 0;
        if (movielist.size() < 5) {
            top5 = movielist.size();
        }
        else {
            top5= 5;
        }
        for (int i = 0; i < top5; i++) {
            System.out.println("#"+(i+1)+ " Movie: "+movielist.get(i).getTitle() + " rating: "+ movielist.get(i).getRating());
        }
    }
    public class SortbyRating implements Comparator<Movie> {
        public int compare(Movie x, Movie y) {
            double x_rating=x.getRating();
            double y_rating=y.getRating();
            double dif = x_rating - y_rating;
            if (dif > 0) {
                return -1;
            }
            if (dif < 0) {
                return 1;
            }
            return 0;
        }
    }
}
