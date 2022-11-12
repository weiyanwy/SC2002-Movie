package Entity;
import java.io.Serializable;
import java.util.ArrayList;


public class Cinema implements Serializable {

    //#------------------------
    //initiate relevant variables
    private String name;
    private String Code;
    private CinemaType cinematype;
    private ArrayList<Showtime> Showtimelist;


    //#------------------------
    //constructors of the Cinema

    public void setNameCode(String name,String Code) {
        this.name=name;
        this.Code=Code;
    }
    public void assignShowtime(ArrayList<Showtime> Showtimelist){
        this.Showtimelist=Showtimelist;
    }
    public ArrayList<Showtime> getShowtimelist(){
        return this.Showtimelist;
    }
    public void setCinematype(CinemaType type){
        cinematype=type;
    }
    public String getCode(){
        return this.Code;
    }
    public String getname() {
        return this.name;
    }
    public CinemaType getCinematype(){
        return this.cinematype;
    }


}
