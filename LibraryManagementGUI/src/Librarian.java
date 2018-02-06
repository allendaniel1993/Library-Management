 import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

public class Librarian
{	
	private String Name;
	private int Id;
	private static int Librarian_Count;
	
	public Librarian(String name)
	{
		this.Name=name;
		Librarian_Count++;
		this.Id=Librarian_Count;
	}
	
	public void menu(Library l,String name)
	{
		int choice;
		boolean redo=true;
		Scanner s = new Scanner(System.in);
		while(redo)
		{
			System.out.println("Please select one : \n 1.Add Book \n 2.Remove Book \n 3.Calculate fine \n 4.Add Member \n 5.Remove Member \n 6.Allocate Room \n 7.Deallocate Room \n 8.Details of Books \n 9.Details of Members \n 10.Exit");
			System.out.println("Enter your Choice :");
			try
			{
				choice = s.nextInt();
				s.nextLine();
				if(choice==1||choice==2||choice==3||choice==4||choice==5||choice==6||choice==7||choice==8||choice==9||choice==10)
					{
						switch(choice)
						{
							case 1:
									System.out.println("Enter Book Name :");
									String b_name=s.nextLine();
									System.out.println("Enter Book Price :");
									double price=s.nextDouble();
									s.nextLine();
									System.out.println("Enter Book Category(Journal/Magazine/Study Books/Reference Books) :");
									String b_category=s.nextLine();
									if(add_Book(l,b_name,price,b_category))
										System.out.println("Book added sucessfully");
									else
										System.out.println("Error in adding book");
									break;
									
							case 2:
									System.out.println("Enter Book Name :");
									String bk_name=s.nextLine();
									System.out.println("Enter Book Category(Journal/Magazine/Study Books/Reference Books) :");
									String bk_category=s.nextLine();
									if(remove_Book(l,bk_name,bk_category))
										System.out.println("Book removed sucessfully");
									else
										System.out.println("Error in removing book");
									break;
					
							case 3:
									System.out.println("Enter the Member name :");
									String member_name=s.nextLine();
									System.out.println("Enter the Book name :");
									String book_name=s.nextLine();
									System.out.println("Enter member category(Student/Adult) :");
									String m_cat=s.nextLine();
									System.out.println("Enter the number of delayed days :");
									int days=s.nextInt();
									s.nextLine();
									System.out.println("Is book lost(y/n) :");
									String lost=s.nextLine();
									double d=calculate_Fine(l,member_name,book_name,days,lost,m_cat);
									System.out.println("The fine is :" +d);
									break;
						
							case 4:
									System.out.println("Enter the Visitor name :");
									String name_v=s.nextLine();
									System.out.println("Enter visitor category(Student/Adult) :");
									String v_cat=s.nextLine();
									if(add_Member(l,name_v,v_cat))
									System.out.println("Congrats the member is added");
									else
									System.out.println("Error in adding Member");
									break;
					
							case 5:
									System.out.println("Enter the Member Name to be removed");
									String m_name=s.nextLine();
									System.out.println("Enter Member Category(Student/Adult) :");
									String m_category=s.nextLine();
									if(remove_Member(l,m_name,m_category))
										System.out.println("Member removed sucessfully");
									else
										System.out.println("Error in removing Member");
									break;
						
							case 6 :
									System.out.println("Enter Room Number: ");
									int room_number=s.nextInt();
									s.nextLine();
									if(allocate_Room(l,room_number))
										System.out.println("Room allocated sucessfully");
									else
										System.out.println("Error in allocating room");
									break;
					
							case 7:
									System.out.println("Enter Room Number: ");
									int r_number=s.nextInt();
									s.nextLine();
									if(deallocate_Room(l,r_number))
										System.out.println("Room deallocated sucessfully");
									else
										System.out.println("Error in deallocating room");
									break;

							case 8:
									System.out.println("Enter the category of books you want to list(Journal/Magazine/Study Books/Reference Books) : ");
									String ls_category=s.nextLine();
									print_book_details(ls_category,l);								
									break;
									
							case 9:
									System.out.println("Enter the category of memebers you want to list(Adults/Students) : ");
									String ml_category=s.nextLine();
									print_member_details(ml_category,l);								
									break;
					
							case 10:	
									System.out.println("Thank You");
									redo=false;
									System.exit(0);
									
							default:
									System.out.println("Thank You");
		
						}
				
					}
				else
				{
					System.out.println("Bad input.. Try Again");
				}
		
			}
			catch (InputMismatchException e) 
			{
				String str = s.next();
				System.out.println("Bad input.. Try Again");
			}
		}
		s.close();
	}
	public boolean inserted(String s,Library l)
	{
		int found=0;
		for(Journal x : l.journallist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		for(Magazine x : l.magazinelist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		for(Study_Books x : l.studybooklist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		for(Reference_Books x : l.referencebooklist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		if(found==1)
			return true;
		return false;
			
	}
	
	@Requires({"name!=null", "price>=0.00","cat!=null"})
	@Ensures({"inserted(name,l)"})
	public boolean add_Book(Library l,String name,double price,String cat)
	{
		int flag=0;
		Scanner s = new Scanner(System.in);
		if (cat.equals("Journal"))
		{   
			System.out.println("Enter Issue Number: ");
			int issue_no=s.nextInt();
			s.nextLine();
			System.out.println("Enter Journal Category: ");
			String j_cat=s.nextLine();
			if(l.journallist.add(new Journal(name, price, "Available", issue_no, j_cat)))
			{
				flag=1;
			}
		}
		
		else if (cat.equals("Magazine"))
		{   
			System.out.println("Enter Issue Number: ");
			int issue_no=s.nextInt();
			s.nextLine();
			System.out.println("Enter Magazine Category: ");
			String j_cat=s.nextLine();
			if(l.magazinelist.add(new Magazine(name, price, "Available", issue_no, j_cat)))
			{
				flag=1;
			}
		}
		
		else if (cat.equals("Study Books"))
		{   
			System.out.println("Enter Author Name: ");
			String author=s.nextLine();

			if(l.studybooklist.add(new Study_Books(name, price, "Available", author, false)))
			{
				flag=1;
			}
		}
		
		else if (cat.equals("Reference Books"))
		{   
			System.out.println("Enter Author Name: ");
			String author=s.nextLine();

			if(l.referencebooklist.add(new Reference_Books(name, price, "Available", author)))
			{
				flag=1;
			}
		}
		
		else
		{
			System.out.println("Invalid Category");
		}
		
		if(flag==1)
			return true;
		else
			return false;
	}
	public boolean removed(String s,Library l)
	{
		int found=0;
		for(Journal x : l.journallist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		for(Magazine x : l.magazinelist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		for(Study_Books x : l.studybooklist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		for(Reference_Books x : l.referencebooklist)
		{	
			if (x.getBook_Name().equals(s))
				found=1;
		}
		if(found==0)
			return true;
		return false;
			
	}
	@Requires({"name!=null","cat!=null"})
	@Ensures({"removed(name,l)"})
	public boolean remove_Book(Library l,String name,String cat)
	{
		boolean success=false;
		if (cat.equals("Journal"))
		{   
			int found=0;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Issue Number");
			int issue_number=s.nextInt();
			s.nextLine();
			Journal rem=new Journal();
			List<Journal> j = l.getJournallist();
			
			for(Journal x : j)
			{	
				if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue_number)
				{
					rem=x;
					found=1;
				}
				
			}
			if(found==0)
			{
				System.out.println("Journal Not Found");
			}
			if(l.journallist.remove(rem))
				success=true;
		}
		
		else if (cat.equals("Magazine"))
		{   
			int found=0;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Issue Number");
			int issue_number=s.nextInt();
			s.nextLine();
			Magazine rem=new Magazine();
			List<Magazine> m = l.getMagazinelist();
			
			for(Magazine x : m)
			{	
				if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue_number)
				{
					rem=x;
					found=1;
				}
				
			}
			if(found==0)
			{
				System.out.println("Magazine Not Found");
			}
			if(l.magazinelist.remove(rem))
				success=true;
		}
		
		else if (cat.equals("Study Books"))
		{   
			int found=0;
			Study_Books rem=new Study_Books();
			List<Study_Books> sb = l.getStudybooklist();
			
			for(Study_Books x : sb)
			{	
				if (x.getBook_Name().equals(name))
				{
					rem=x;
					found=1;
				}
				
			}
			if(found==0)
			{
				System.out.println("Study Book Not Found");
			}
			if(l.studybooklist.remove(rem))
				success=true;
		}
		
		else if (cat.equals("Reference Books"))
		{   
			int found=0;
			Reference_Books rem=new Reference_Books();
			List<Reference_Books> rb = l.getReferencebooklist();
			
			for(Reference_Books x : rb)
			{	
				if (x.getBook_Name().equals(name))
				{
					rem=x;
					found=1;
				}
				
			}
			if(found==0)
			{
				System.out.println("Reference Book Not Found");
			}
			if(l.referencebooklist.remove(rem))
				success=true;
		}
		
		else
		{
			System.out.println("Invalid Category");
		}
		
		if(success)
			return true;
		else
			return false;
	}
		
	@Requires({"m_name!=null","cat!=null","b_name!=null","s!=null","d>=0"})
	@Ensures({"result>=0.00"})
	public double calculate_Fine(Library l,String m_name,String b_name,int d,String s,String cat)
	{
		List<Study_Books> b = l.getStudybooklist();
		List<Adult> m_a = l.getAdultlist();
		List<Student>  m_s = l.getStudentlist();
		double price=0.00,fine=0.00;
		int flag=0,flag1=0,flag2=0;
		for(Book x : b)
		{	
			if (x.getBook_Name().equals(b_name))
			{
				price=x.getPrice();
				flag=1;
			}
			
		}
		if(flag==0)
		{
			System.out.println("Book not found");
			flag2=1;
		}
	
		if(s=="y")
		{
			fine=price*50/100;
		}
		else
		{
			if(d<10)
				fine= 2.00;
			else
				fine= 2.00+(d-10)*1.00;
		}
		
		if(cat.equals("Adult"))
		{
			for(Adult y : m_a)
			{	
				if (y.getName().equals(m_name))
				{
					y.setFine(fine);
					flag1=1;
				}
			
			}
		}
		
		else if (cat.equals("Student"))
		for(Student y : m_s)
		{	
			if (y.getName().equals(m_name))
			{
				y.setFine(fine);
				flag1=1;
			}
			
		}
		
		if(flag1==0)
		{
			System.out.println("Member not found");
			flag2=1;
		}
		if(flag2==0)
			return fine;
		else
			return 0.00;
	}
	public boolean memberadded(String s,Library l)
	{
		int found=0;
		for(Student x : l.studentlist)
		{	
			if (x.getName().equals(s))
				found=1;
		}
		for(Adult x : l.adultlist)
		{	
			if (x.getName().equals(s))
				found=1;
		}
		
		if(found==1)
			return true;
		return false;
			
	}
	@Requires ({"name!=null","cat!=null"})
	@Ensures({"memberadded(name,l)"})
	public boolean add_Member(Library l,String name, String cat)
	{
		int flag=0;
		if (cat.equals("Adult"))
		{   
			Scanner s = new Scanner(System.in);
			System.out.println("Enter years of membership required: ");
			int years=s.nextInt();
			s.nextLine();
			System.out.println("The mebership fee is: " + years*250);
			if(l.adultlist.add(new Adult(name)))
			{
				flag=1;
			}
		}
		else if(cat.equals("Student"))
		{   
			Scanner s = new Scanner(System.in);
			System.out.println("Enter student id: ");
			int s_id=s.nextInt();
			s.nextLine();
			System.out.println("Enter years of membership required: ");
			int years=s.nextInt();
			s.nextLine();
			System.out.println("The mebership fee is: " + years*100);
			if(l.studentlist.add(new Student(name,s_id)))
			{
				flag=1;
			}
		}
		else
		{
			System.out.println("Invalid Category");
		}
		if(flag==1)
				return true;
		else
				return false;
	}
	public boolean memberremoved(String s,Library l)
	{
		int found=0;
		for(Student x : l.studentlist)
		{	
			if (x.getName().equals(s))
				found=1;
		}
		for(Adult x : l.adultlist)
		{	
			if (x.getName().equals(s))
				found=1;
		}
		
		if(found==0)
			return true;
		return false;
			
	}
	@Requires ({"m_name!=null","m_category!=null"})
	@Ensures({"memberremoved(m_name,l)"})
	public boolean remove_Member(Library l,String m_name, String m_category)
	{
		boolean success=false;
		if (m_category.equals("Adult"))
		{   
			int found=0;
			Adult rem=new Adult();
			List<Adult> a = l.getAdultlist();
			
			for(Adult x : a)
			{	
				if (x.getName().equals(m_name))
				{
					rem=x;
					found=1;
				}
				
			}
			if(found==0)
			{
				System.out.println("Given Adult Member Not Found");
			}
			if(l.adultlist.remove(rem))
				success=true;
		}
		
		else if (m_category.equals("Student"))
		{   
			int found=0;
			Student rem=new Student();
			List<Student> s = l.getStudentlist();
			
			for(Student x : s)
			{	
				if (x.getName().equals(m_name))
				{
					rem=x;
					found=1;
				}
				
			}
			if(found==0)
			{
				System.out.println("Given Student Member Not Found");
			}
			if(l.studentlist.remove(rem))
				success=true;
		}
		else
		{
			System.out.println("Invalid Category");
		}
		
		if(success)
			return true;
		else
			return false;
		
	}
	
	@Requires({"rno>=501 && rno<=505"})
	@Ensures({"result==true || result==false"})
	public boolean allocate_Room(Library l,int rno)
	{
		List<Room> r= l.getRoomlist();
		int flag1=0,flag2=0;
		for(Room x : r)
		{	
			if (x.getRoom_Number()==rno)
			{
				flag2=1;
				if(x.get_Allocated()==false)
				{
					x.set_Allocated(true);
					flag1=1;
				}
				
			}
			
		}
		if(flag2==0)
		{
			System.out.println("Room " +rno+ " not found");
		}
		if(flag1==1)
			return true;
		else
			return false;
	}
	@Requires({"rno>=501 && rno<=505"})
	@Ensures({"result==true || result==false"})
	public boolean deallocate_Room(Library l,int rno)
	{
		List<Room> r= l.getRoomlist();
		int flag1=0,flag2=0;
		for(Room x : r)
		{	
			if (x.getRoom_Number()==rno)
			{
				flag2=1;
				if(x.get_Allocated()==true)
				{
					x.set_Allocated(false);
					flag1=1;
				}
				
			}
			
		}
		if(flag2==0)
		{
			System.out.println("Room " +rno+ " not found");
		}
		if(flag1==1)
			return true;
		else
			return false;
	}
	@Requires({"ls_category!=null"})
	public void print_book_details(String ls_category,Library l)
	{
	
		if (ls_category.equals("Journal"))
		{   
			for (Journal j : l.journallist)
			{
				System.out.println("The Journal Name is :"+j.getBook_Name());
				System.out.println("The Journal Id is :"+j.getBook_Id());
				System.out.println("The Journal Status is :"+j.getBook_status());
				System.out.println("The Journal Price is :"+j.getPrice());
				System.out.println("The Journal Issue Number is :"+j.getIssue_Number());
				System.out.println("The Journal Category is :"+j.getJournal_Category());
			}
			
		}
		
		else if (ls_category.equals("Magazine"))
		{   

			for (Magazine m : l.magazinelist)
			{
				System.out.println("The Magazine Name is :"+m.getBook_Name());
				System.out.println("The Magazine Id is :"+m.getBook_Id());
				System.out.println("The Magazine Status is :"+m.getBook_status());
				System.out.println("The Magazine Price is :"+m.getPrice());
				System.out.println("The Magazine Issue Number is :"+m.getIssue_Number());
				System.out.println("The Magazine Category is :"+m.getMagazine_Category());
			}
		}
		
		else if (ls_category.equals("Study Books"))
		{   

			for (Study_Books m : l.studybooklist)
			{
				System.out.println("The Study Book Name is :"+m.getBook_Name());
				System.out.println("The Study Book Id is :"+m.getBook_Id());
				System.out.println("The Study Book Status is :"+m.getBook_status());
				System.out.println("The Study Book Price is :"+m.getPrice());
				System.out.println("The Study Book Author Status is :"+m.getAuthor());
				System.out.println("The Study Book Borrow Status is :"+m.getBorrow_Status());
				
			}
		}
		
		else if (ls_category.equals("Reference Books"))
		{   

			for (Reference_Books m : l.referencebooklist)
			{
				System.out.println("The Reference Book Name is :"+m.getBook_Name());
				System.out.println("The Reference Book Id is :"+m.getBook_Id());
				System.out.println("The Reference Book Status is :"+m.getBook_status());
				System.out.println("The Reference Book Price is :"+m.getPrice());
				System.out.println("The Reference Book Author is :"+m.getAuthor());
			}
		}
		
		else
		{
			System.out.println("Invalid Category");
		}
		
	}
	
	@Requires({"ml_category!=null"})
	void print_member_details(String ml_category,Library l)
	{
		
		if (ml_category.equals("Students"))
		{   
			for (Student j : l.studentlist)
			{
				System.out.println("The Student Member Name is :"+j.getName());
				System.out.println("The Member Id is :"+j.getMember_Id());
				System.out.println("The Student Member Fine is :"+j.getFine());
				System.out.println("The Student Id is :"+j.getStudent_Id());
			}
			
		}
		else if (ml_category.equals("Students"))
		{   
			for (Student j : l.studentlist)
			{
				System.out.println("The Adult Member Name is :"+j.getName());
				System.out.println("The Member Id is :"+j.getMember_Id());
				System.out.println("The Adult Member Fine is :"+j.getFine());
			}
			
		}
	}
	
}
