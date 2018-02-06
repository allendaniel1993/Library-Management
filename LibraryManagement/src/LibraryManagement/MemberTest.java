package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberTest {

	Library l=new Library("Test library");
	Librarian lb=new Librarian("Test");
	Adult a=new Adult("Test Adult");

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
	
	@Test
	public void testBorrow_Book() {
		assertEquals(true,a.borrow_Book(l,"Networking"));
	}
	
	@Test
	public void testBorrow_Book_Fail() {
		assertEquals(false,a.borrow_Book(l,"Invalid Book"));
	}

	@Test
	public void testReturn_Book() {
		assertEquals(true,a.return_Book(l,"Independence"));
	}
	
	@Test
	public void testReturn_Book_Fail() {
		assertEquals(false,a.return_Book(l,"Invalid Boook"));
	}


}
