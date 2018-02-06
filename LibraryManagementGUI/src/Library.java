	import java.util.*;	
/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Library
{

	private String libraryName;
	List<Book> booklist = new ArrayList<Book>();
	List<Room> roomlist = new ArrayList<Room>();
	List<Student> studentlist = new ArrayList<Student>();
	List<Adult> adultlist = new ArrayList<Adult>();
	List<Journal> journallist = new ArrayList<Journal>();
	List<Magazine> magazinelist = new ArrayList<Magazine>();
	List<Study_Books> studybooklist = new ArrayList<Study_Books>();
	List<Reference_Books> referencebooklist =new ArrayList<Reference_Books>();
	
	public Library(String libraryName)
	{
		this.libraryName=libraryName;
		
		roomlist.add(new Room(501,false));
		roomlist.add(new Room(502,true));
		roomlist.add(new Room(503,false));
		roomlist.add(new Room(504,false));
		roomlist.add(new Room(505,true));
		
		adultlist.add(new Adult("Allen"));
		adultlist.add(new Adult("Rajeev"));
		adultlist.add(new Adult("Alex"));
		adultlist.add(new Adult("Angel"));
		adultlist.add(new Adult("John"));
		
		studentlist.add(new Student("James",12786));
		studentlist.add(new Student("Linda",12685));
		studentlist.add(new Student("Dapo",12568));
		studentlist.add(new Student("Peter",12599));
		studentlist.add(new Student("July",12789));	
		
		journallist.add(new Journal("Days of Computers",12.00,"Available",4,"Education"));
		journallist.add(new Journal("Daily Living",10.00,"Available",4,"General"));
		journallist.add(new Journal("Days of Computers",12.00,"In_Use",3,"Education"));
		journallist.add(new Journal("Daily Living",10.00,"Available",3,"General"));
		journallist.add(new Journal("Environment",5.00,"In_Use",25,"General"));
		
		magazinelist.add(new Magazine("Computer World",20.00,"Available",4,"Education"));
		magazinelist.add(new Magazine("People",30.00,"Available",4,"General"));
		magazinelist.add(new Magazine("Computer World",20.00,"In_Use",3,"Education"));
		magazinelist.add(new Magazine("People",30.00,"Available",3,"General"));
		magazinelist.add(new Magazine("Fashion Today",5.00,"In_Use",25,"General"));
		
		studybooklist.add(new Study_Books("OOPS Concepts",200.00,"Available","Robert",false));
		studybooklist.add(new Study_Books("Operating Systems",150.00,"Available","Sam Peter",true));
		studybooklist.add(new Study_Books("Algorithms",25.00,"Available","Gilly Berg",false));
		studybooklist.add(new Study_Books("Networking",125.00,"Available","Jason Waner",true));
		studybooklist.add(new Study_Books("Independence",75.50,"In_Use","Fedrik",true));
		
		referencebooklist.add(new Reference_Books("Master in Arts",400.00,"Available","Jones Tamy"));
		referencebooklist.add(new Reference_Books("Source Code",150.00,"Available","Barry Laden"));
		referencebooklist.add(new Reference_Books("The Calibrartor",25.00,"Available","Samuel"));
		referencebooklist.add(new Reference_Books("Understanding Principles",125.00,"Available","Mespo"));
		referencebooklist.add(new Reference_Books("The Idea",75.50,"In_Use","Joseph"));
		
	}
	
	public List<Room> getRoomlist() {
		return roomlist;
	}

	public void setRoomlist(List<Room> roomlist) {
		this.roomlist = roomlist;
	}

	public void getLibraryName()
	{
		System.out.println(libraryName);
	}

	public List<Student> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<Student> studentlist) {
		this.studentlist = studentlist;
	}

	public List<Adult> getAdultlist() {
		return adultlist;
	}

	public void setAdultlist(List<Adult> adultlist) {
		this.adultlist = adultlist;
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public List<Journal> getJournallist() {
		return journallist;
	}

	public void setJournallist(List<Journal> journallist) {
		this.journallist = journallist;
	}

	public List<Magazine> getMagazinelist() {
		return magazinelist;
	}

	public void setMagazinelist(List<Magazine> magazinelist) {
		this.magazinelist = magazinelist;
	}

	public List<Study_Books> getStudybooklist() {
		return studybooklist;
	}

	public void setStudybooklist(List<Study_Books> studybooklist) {
		this.studybooklist = studybooklist;
	}

	public List<Reference_Books> getReferencebooklist() {
		return referencebooklist;
	}

	public void setReferencebooklist(List<Reference_Books> referencebooklist) {
		this.referencebooklist = referencebooklist;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	
	
	

}