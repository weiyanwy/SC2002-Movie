/**
 * 
 */

/**
 * @author weiya
 *
 */
public class Movie {
	private String title;
	private String Synopsis;
	private String Director;
	private String ShowStatus;
	private String MainCast;
	private int numvotes;
	private float rating;
	private String MovieRestriction;
	private String Genre;
	private String runtime;
	private int totalsales;
	private String[] reviews = new String[10];
	///
	//private Seating
	////
	private int count=0;
	
	
	public void assignTitle(String Movietitle) {
		this.title = Movietitle;
	}
	public void assignStatus(String Status) {
		this.ShowStatus = Status;
	}
	public void assignSyn(String Syns) {
		this.Synopsis = Syns;
	}
	public void assignDirect(String Director) {
		this.Director = Director;
	}
	// change to array easier to update
	public void assignCast(String Cast) {
		this.MainCast=Cast;
	}
	public void assignRate(float rating) {
		this.rating=rating;
	}
	public void assignVotes(int numvotes) {
		this.numvotes=numvotes;
	}
	public void assignSales(int sales) {
		this.totalsales= sales;
	}
	public void updateReview(String Review) {	
		reviews[this.count]= Review;
		this.count+=1;	
	}
	public void assignGenre(String Genre) {
		this.Genre=Genre;
	}
	public void assignRuntime(String Runtime) {
		this.runtime=Runtime;
	}
	public void assignRestrict(String Restrict) {
		this.MovieRestriction = Restrict;
	}
	public void viewReviews() {
		for (int x = 0; x<this.count; x++) {
			System.out.println("Review #"+ (x+1) + this.reviews[x]);
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getStatus() {
		return this.ShowStatus;
	}
	public String getSynopsis() {
		return this.Synopsis;
	}
	public String getDirector() {
		return this.Director;
	}
	public String getCast() {
		return this.MainCast;
	}
	public int getVotes() {
		return this.numvotes;
	}
	public float getRating() {
		return this.rating;
	}
	public String getMovieRest() {
		return this.MovieRestriction;
	}
	public String getGenre() {
		return this.Genre;
	}
	public String runtime() {
		return this.runtime;
	}
	
	public void rundetails() {
		System.out.println("Title: "+ this.title);
		System.out.println("Show Status: "+ this.ShowStatus);
		System.out.println("Synopsis "+ this.Synopsis);
		System.out.println("Director "+ this.Director);
		System.out.println("Main Cast "+ this.MainCast);
		System.out.println("Movie rating "+this.rating);
		System.out.println("Movie Restriction "+ this.MovieRestriction);
		System.out.println("Movie Reviews: ");
		viewReviews();
		// get reviews
		
	}
}
