package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

import static org.junit.Assert.*;

import org.junit.Test;

public class VisitorTest {

	Library l=new Library("Test library");
	Librarian lb=new Librarian("Test");
	Visitor a=new Visitor("Test Visitor");


	@Test
	public void testSearch_Book() {
		assertEquals(true,a.search_Book(l,"OOPS Concepts","Study Books"));
	}
	
	@Test
	public void testSearch_Book_Fail() {
		assertEquals(false,a.search_Book(l,"Invalid Book","Study Books"));
	}

	@Test
	public void testRead_Book() {
		assertEquals(true,a.read_Book(l,"OOPS Concepts","Study Books"));
	}

	@Test
	public void testRead_Book_Fail() {
		assertEquals(false,a.read_Book(l,"Invalid Book","Study Books"));
	}
	
}
