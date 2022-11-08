import java.util.HashMap;
import java.util.Scanner;

public class Cinema {

    //#------------------------
    //initiate relevant variables
    private String name;

    private CinemaType cinematype;
    private MovieDBcontrol moviedb;
    Scanner sc = new Scanner(System.in);

    //#------------------------
    //constructors of the Cinema

    public void setname(String name) {
        this.name=name;

    }
    public void setCinematype(CinemaType type){
        cinematype=type;
       }

    public String getname() {
        return this.name;
    }
    public CinemaType getCinematype(){
        return this.cinematype;
    }


}
