/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/



public class Book {
	
	String Book_Name;
	double Price;
	String Book_Status;
	private static int Book_Count;
	int Book_Id;
	
	public Book() 
	{

	}

	public int getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(int book_Id) {
		Book_Id = book_Id;
	}

	public Book(String book_Name, double price, String book_status) {
		super();
		this.Book_Name = book_Name;
		Book_Count++;
		this.Book_Id = 1000 + Book_Count;
		this.Price = price;
		this.Book_Status = book_status;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}

	public String getBook_Name() {
		return Book_Name;
	}

	public void setBook_Name(String book_Name) {
		this.Book_Name = book_Name;
	}

	public String getBook_status() {
		return Book_Status;
	}

	public void setBook_status(String book_status) {
		this.Book_Status = book_status;
	}
	
}
