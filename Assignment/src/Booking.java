import java.util.ArrayList;
import java.util.Scanner;
public class Booking {
    DBaddress address;
    CineplexDBcontrol cineplexDB= new CineplexDBcontrol(address.getCineplexDBAddress());
    ArrayList<Cineplex> CineplexList=cineplexDB.GetCineplexFromDB();
}
