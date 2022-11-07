public class CinemaMode {
    private Cinema[] Cinemalist;
    private int CinemalistSize;

    public void runCinemaMode(Cinema[] Cinemalist, int listSize){
        this.Cinemalist=Cinemalist;
        this.CinemalistSize=listSize;

    }
    public void printCinema(){
        for(int x=1; x<=CinemalistSize; x++){
            System.out.println("Cinema #"+x+ " "+ Cinemalist[x-1].getname());
        }
    }
    public void select Cinema()
}
