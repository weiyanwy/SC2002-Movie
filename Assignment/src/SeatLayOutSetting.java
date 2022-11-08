import java.util.ArrayList;
import java.util.Scanner;
public class SeatLayOutSetting {


    private Seat[][] layout;
    private int row, column;
    SeatLayout Showtimelayout;
    Scanner sc = new Scanner(System.in);

    public SeatLayout SetSeatLayout(){
        SetRowAndColumn();
        initializeSeats(this.row,this.column);
        Showtimelayout=new SeatLayout(this.row, this.column, layout);
        return Showtimelayout;
    }
    public void SetRowAndColumn()
    {
        int sel;
        boolean check = true;
        do {
            try {
                System.out.println("Select Layout");
                System.out.println("1: 8x8");
                System.out.println("2: 6x6");
                System.out.println("3: 4x4");
                sel = Integer.parseInt(sc.nextLine());
                switch (sel) {
                    case 1:
                        this.row = 8;
                        this.column = 8;
                        check = false;
                        break;
                    case 2:
                        this.row = 6;
                        this.column = 8;

                        check = false;
                        break;
                    case 3:
                        this.row = 4;
                        this.column = 4;
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        } while (check);
    }

//	public void Layout1(){
//		//8x8
//		System.out.println("-----------------SCREEN----------------");
//		System.out.println("| [01][02][03][04]   [05][06][07][08] |");
//		System.out.println("| [11][12][13][14]   [15][16][17][18] |");
//		System.out.println("| [21][22][23][24]   [25][26][27][28] |");
//		System.out.println("| [31][32][33][34]   [35][36][37][38] |");
//		System.out.println("| [41][42][43][44]   [45][46][47][48] |");
//		System.out.println("| [51][52][53][54]   [55][56][57][58] |");
//		System.out.println("| [61][62][63][64]   [65][66][67][68] |");
//		System.out.println("| [71][72][73][74]   [75][76][77][78] |");
//		System.out.println("------------------DOOR-----------------");
//
//	}
//	public void layout2(){
//		//4x4
//		System.out.println("---------SCREEN--------");
//		System.out.println("| [01][02]   [03][04] |");
//		System.out.println("| [11][12]   [13][14] |");
//		System.out.println("| [21][22]   [23][24] |");
//		System.out.println("| [31][32]   [33][34] |");
//		System.out.println("----------DOOR---------");
//	}
//	public void layout3(){
//		//6x6
//		System.out.println("------------SCREEN------------");
//		System.out.println("| [01][02][03]  [04][05][06] |");
//		System.out.println("| [11][12][13]  [14][15][16] |");
//		System.out.println("| [21][22][23]  [24][25][26] |");
//		System.out.println("| [31][32][33]  [34][35][36] |");
//		System.out.println("| [41][42][43]  [44][45][46] |");
//		System.out.println("| [51][52][53]  [54][55][56] |");
//		System.out.println("-------------DOOR-------------");
//
//	}

    public void initializeSeats(int row, int column) {
        this.row=row;
        this.column=column;
        //this.totalseats
        this.layout = new Seat[row][column];

        for(int x=0; x< this.row;x++) {
            for(int y=0;y<this.column;y++) {
                this.layout[x][y]=new Seat();
                this.layout[x][y].setID((x*10)+y);
            }

        }

    }
    public void printSeatStatus(SeatLayout layout) {
        int row=layout.getRow();
        int col = layout.getCol();
        Seat[][] seatstatus=layout.getSeats();
        String title="[SCREEN]";
        String Status="[SEAT's STATUS]";
        for(int x=0; x< row;x++) {
            String S ="";
            for(int y=0;y<col;y++) {
                Status = "--" + Status + "--";
                title = "----" + title + "----";
                if(y==0)
                    S+="| ";
                if( x==0 && (y==(col/2)))
                    System.out.println(Status);
                if(y== (col/2))
                    S+="   ";
                S += "[ "+seatstatus[x][y].GetSeatStatus()+" ]";

            }
            S+=" |";
            System.out.println(S);
        }
        System.out.println("Legends A: Avaliable, O: Occupied");
    }
    public void printSeatIndex(int row, int column) {
        String title="[SCREEN]";
        for(int x=0; x< row;x++) {
            String S ="";
            for(int y=0;y<column;y++) {
                title = "----" + title + "----";
                if(y==0)
                    S+="| ";
                if( x==0 && (y==(column/2)))
                    System.out.println(title);
                if(y== (column/2))
                    S+="   ";
                S += "[ "+layout[x][y].getID()+" ]";

            }
            S+=" |";
            System.out.println(S);
        }
    }
    public void printlayout() {
        printSeatIndex();
        printSeatStatus();
    }
    // change to return seat
    public void selectseat(Seat seatlayout) {

        int no_tickets=0;
        ArrayList<Integer> StoreSeatIndex = new ArrayList<>();
        boolean check=true;
        do {

            try {
                printlayout(seatlayout.getrow, seatlayout.getcolumn);
                System.out.println("1: Select Index of Seat");
                System.out.println("2: UnSelect Index of Seat");
                System.out.println("3: Proceed to Payment");
                System.out.println("4: Exit;");
                int choice = Integer.parseInt(sc.nextLine());
                switch(choice) {
                    case(1):
                        System.out.println("Enter Seat Index: ");
                        index=Integer.parseInt(sc.nextLine());
                        //Convert index of seat to occupied
                        this.layout[index / 10][index% 10].SelectSeat();
                        printlayout();
                        //Store seat index in array
                        storeselect[no_tickets] = index;
                        //increment total seats selected
                        no_tickets++;
                        printseatselected(storeselect, no_tickets);
                        break;
                    case(2):
                        System.out.println("Enter Seat Index: ");
                        index=Integer.parseInt(sc.nextLine());
                        if(CheckisinArray(storeselect, index)){
                            storeselect=updateArray(storeselect, index, no_tickets);
                            no_tickets--;
                            this.layout[index / 10][index% 10].UnSelectSeat();
                            printseatselected(storeselect, no_tickets);
                        }
                        else
                            System.out.println("Invalid Input");
                        break;
                    case(3):
                        printseatselected(storeselect, no_tickets);

                        break;
                    case(4):
                        check=false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid Input");
            }
        }while(check);
    }
    public void printseatselected(int[] seatindex, int size){
        String store="";

        for(int x = 0;x <size;x ++){
            store = store + seatindex[x]+" ";
        }
        System.out.println("Seats Selected: "+store);
    }
    public boolean CheckisinArray(int[]array, int input){
        for(int x : array){
            if(x==input){
                return true;
            }
        }
        return false;
    }
    public int[] updateArray(int[] array, int input, int size){
        int[] temp=new int[this.row * this.column];
        int y=0;
        for(int x=0;x<size;x++){
            if(array[x]==input)
                y++;
            temp[x]=array[y];
            y++;
        }
        return temp;
    }
}


}


}
