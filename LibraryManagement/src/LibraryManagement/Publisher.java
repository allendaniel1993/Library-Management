package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

public class Publisher 
{
	int Publisher_Id;
	String Publisher_Name;
	
	public Publisher(int publisher_Id, String publisher_Name) {
		super();
		Publisher_Id = publisher_Id;
		Publisher_Name = publisher_Name;
	}

	public int getPublisher_Id() {
		return Publisher_Id;
	}

	public void setPublisher_Id(int publisher_Id) {
		Publisher_Id = publisher_Id;
	}

	public String getPublisher_Name() {
		return Publisher_Name;
	}

	public void setPublisher_Name(String publisher_Name) {
		Publisher_Name = publisher_Name;
	}
	

}
