

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Reference_Books extends Book
{
	private String Author;

	public Reference_Books() 
	{
		super();
	}

	public Reference_Books(String book_Name, double price, String book_status,String author) 
	{
		super(book_Name, price, book_status);
		this.Author=author;
	}
	
	public String getAuthor() 
	{
		return Author;
	}

}
