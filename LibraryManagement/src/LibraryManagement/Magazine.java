package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Magazine extends Book
{
	int Issue_Number;
	String Magazine_Category;
	
	public Magazine() 
	{
		super();
	}


	public Magazine(String book_Name, double price, String book_status,int issue_no, String cat)
	{
		super(book_Name, price, book_status);
		this.Issue_Number=issue_no;
		this.Magazine_Category=cat;
	}


	public int getIssue_Number() {
		return Issue_Number;
	}


	public void setIssue_Number(int issue_Number) {
		Issue_Number = issue_Number;
	}


	public String getMagazine_Category() {
		return Magazine_Category;
	}


	public void setMagazine_Category(String magazine_Category) {
		Magazine_Category = magazine_Category;
	}
	
	
	
}
