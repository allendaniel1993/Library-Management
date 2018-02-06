package LibraryManagement;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

public class Journal extends Book
{
	private int Issue_Number;
	private String Journal_Category;
	
	public Journal() 
	{
		super();
	}

	public Journal(String book_Name, double price, String book_status,int issue_no, String cat) 
	{
		super(book_Name, price, book_status);
		this.Issue_Number=issue_no;
		this.Journal_Category=cat;
	}

	public int getIssue_Number() {
		return Issue_Number;
	}

	public void setIssue_Number(int issue_Number) {
		Issue_Number = issue_Number;
	}

	public String getJournal_Category() {
		return Journal_Category;
	}

	public void setJournal_Category(String journal_Category) {
		Journal_Category = journal_Category;
	}
	
	

}
