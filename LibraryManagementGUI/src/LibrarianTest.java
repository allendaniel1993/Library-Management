import static org.junit.Assert.*;

import org.junit.Test;

public class LibrarianTest {
	
	Library l=new Library("Test library");
	Librarian lb=new Librarian("Test");


	@Test
	public void testAdd_Book() {
		assertEquals(true,lb.add_Book(l,"New Book", 100.00,"Study Books"));
	}
	
	@Test
	public void testAdd_Book_Fail() {
		assertEquals(false,lb.add_Book(l,"Test Book", 100.00,"Wring Category"));
	}

	@Test
	public void testRemove_Book() {
		assertEquals(true,lb.remove_Book(l, "OOPS Concepts", "Study Books"));
	}
	
	@Test
	public void testRemove_Book_Fail() {
		assertEquals(false,lb.remove_Book(l, "Wrong Book", "Study Books"));
	}
	

	@Test
	public void testCalculate_Fine() {
	
		assertEquals(4.00,lb.calculate_Fine(l,"Allen","Independence",12,"n","Adult"),0.00);
	}

	
	@Test
	public void testCalculate_Fine_Fail() {
	
		assertEquals(0.00,lb.calculate_Fine(l,"Allen","Book",12,"n","Adult"),0.00);
	}
	
	@Test
	public void testAdd_Member() {
		assertEquals(true,lb.add_Member(l,"Daniel","Adult"));
	}
	
	@Test
	public void testAdd_Member_Fail() {
		assertEquals(false,lb.add_Member(l,"Daniel","Wrong_category"));
	}

	@Test
	public void testRemove_Member() {
		assertEquals(false,lb.remove_Member(l,"Daniel","Adult"));
	}
	
	@Test
	public void testRemove_Member_Fail() {
		assertEquals(false,lb.remove_Member(l,"Seshu","Adult"));
	}

	@Test
	public void testAllocate_Room() {
		assertEquals(true,lb.allocate_Room(l,501));
	}
	
	@Test
	public void testAllocate_Room_Fail() {
		assertEquals(false,lb.allocate_Room(l,502));
	}

	@Test
	public void testDeallocate_Room() {
		assertEquals(true,lb.deallocate_Room(l, 505));
	}
	
	@Test
	public void testDeallocate_Room_Fail() {
		assertEquals(false,lb.deallocate_Room(l, 504));
	}

}
