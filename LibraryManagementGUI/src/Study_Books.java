

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;
*/
public class Study_Books extends Book
{
	String Author;
	Boolean Borrow_Status;
	
	public Study_Books() 
	{
		super();
	}



	public Study_Books(String book_Name, double price, String book_status, String author, boolean status) 
	{
		super(book_Name, price, book_status);
		this.Author=author;
		this.Borrow_Status=status;
	}



	public String getAuthor() {
		return Author;
	}



	public void setAuthor(String author) {
		Author = author;
	}



	public Boolean getBorrow_Status() {
		return Borrow_Status;
	}



	public void setBorrow_Status(Boolean borrow_Status) {
		Borrow_Status = borrow_Status;
	}
	

}
