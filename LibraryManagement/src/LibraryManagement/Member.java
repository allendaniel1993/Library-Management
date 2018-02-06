package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Member {
	
	String name;
	static int member_count=0;
	int member_Id;
	double fine;
	
	public Member()
	{
		
	}
	
	public int getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(int member_Id) {
		this.member_Id = member_Id;
	}

	public Member(String name)
	{
		this.name=name;
		member_count++;
		this.member_Id=100+member_count;
		this.fine=0.00;
	}
	public void menu(Library l,String name)
	{
		int choice;
		boolean redo=true;
		Scanner s2 = new Scanner(System.in);
		while(redo)
		{
		System.out.println("Please select one : \n 1.Read Books \n 2.Search Book \n 3.Borrow Book \n 4.Return Book  \n 5.Exit");
		System.out.println("Enter your Choice:");
		try
		{
		choice = s2.nextInt();
		s2.nextLine();
			if(choice==1||choice==2||choice==3||choice==4||choice==5)
			{
				switch(choice)
				{
				case 1:
						System.out.println("Enter Book Name");
						String b_name=s2.nextLine();
						System.out.println("Enter Book Category(Journal/Magazine/Study Books/Reference Books) :");
						String b_category=s2.nextLine();
						if(read_Book(l,b_name,b_category))
							System.out.println("Book is available for reading");
						else
							System.out.println("Book is not available for reading");
						break;
				case 2:
						System.out.println("Enter Book Name");
						String bk_name=s2.nextLine();
						System.out.println("Enter Book Category(Journal/Magazine/Study Books/Reference Books) :");
						String bk_category=s2.nextLine();
						if(search_Book(l,bk_name,bk_category))
							System.out.println("Book is available");
						else
							System.out.println("Book is not available");
						break;
					
				case 3:
						System.out.println("Enter Book Name");
						String bb_name=s2.nextLine();
						if(borrow_Book(l,bb_name))
							System.out.println("Book is borrowed sucessfully");
						else
							System.out.println("Unable to borrow book. Book not available");
						break;
				
				case 4: 
						System.out.println("Enter Book Name");
						String rb_name=s2.nextLine();
						if(borrow_Book(l,rb_name))
							System.out.println("Book is returned sucessfully");
						else
							System.out.println("Error in returning book");
						break;
								
				case 5:
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
			String str = s2.next();
			System.out.println("Bad input.. Try Again");
			}
		}s2.close();
	
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	//@Requires({"name!=null", "cat!=null"})
	//@Ensures({"result==true|| result==false"})
	public boolean search_Book(Library l,String name,String cat)
	{
		int found=0,available=0;
		if (cat.equals("Journal"))
		{   
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Issue Number");
			int issue_number=s.nextInt();
			s.nextLine();
			List<Journal> j = l.getJournallist();
			
			for(Journal x : j)
			{	
				if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue_number)
				{
					found=1;
					if(x.getBook_status().equals("Available"))
						available=1;
				}
				
			}
		}
		
		else if (cat.equals("Magazine"))
		{   
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Issue Number");
			int issue_number=s.nextInt();
			s.nextLine();
			List<Magazine> m = l.getMagazinelist();
			
			for(Magazine x : m)
			{	
				if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue_number)
				{	
					found=1;
					if(x.getBook_status().equals("Available"))
						available=1;
				}
				
			}
		}
		
		else if (cat.equals("Study Books"))
		{   
			List<Study_Books> sb = l.getStudybooklist();
			
			for(Study_Books x : sb)
			{	
				if (x.getBook_Name().equals(name))
				{	
					found=1;
					if(x.getBook_status().equals("Available"))
						available=1;
				}
				
			}
		}
		
		else if (cat.equals("Reference Books"))
		{   
			
			List<Reference_Books> rb = l.getReferencebooklist();
			
			for(Reference_Books x : rb)
			{	
				if (x.getBook_Name().equals(name))
				{
					found=1;
					if(x.getBook_status().equals("Available"))
						available=1;
				}
				
			}

		}
		
		else
		{
			System.out.println("Invalid Category");
		}
		
		if(found==0)
		{
			System.out.println("Book is not found");
		}
		
		if(available==1)
			return true;
		else
			return false;
	}
	
	//@Requires({"name!=null", "cat!=null"})
	//@Ensures({"result==true|| result==false"})
	public boolean read_Book(Library l,String name,String cat)
	{
		int found=0,read=0;
		boolean success=false;
		if (cat.equals("Journal"))
		{   		
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Issue Number");
			int issue_number=s.nextInt();
			s.nextLine();
			List<Journal> j = l.getJournallist();
			
			for(Journal x : j)
			{	
				if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue_number)
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						x.setBook_status("In_Use");
						read=1;
					}
				}
				
			}
		}
		
		else if (cat.equals("Magazine"))
		{   
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Issue Number");
			int issue_number=s.nextInt();
			s.nextLine();
			List<Magazine> m = l.getMagazinelist();
			
			for(Magazine x : m)
			{	
				if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue_number)
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						x.setBook_status("In_Use");
						read=1;
					}
				}
				
			}
		}
		
		else if (cat.equals("Study Books"))
		{   
			List<Study_Books> sb = l.getStudybooklist();
			
			for(Study_Books x : sb)
			{	
				if (x.getBook_Name().equals(name))
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						x.setBook_status("In_Use");
						read=1;
					}
				}
				
			}
		}
		
		else if (cat.equals("Reference Books"))
		{   
			List<Reference_Books> rb = l.getReferencebooklist();
			
			for(Reference_Books x : rb)
			{	
				if (x.getBook_Name().equals(name))
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						x.setBook_status("In_Use");
						read=1;
					}
				}
				
			}
		}
		
		else
		{
			System.out.println("Invalid Category");
		}
		
		if(found==0)
		{
			System.out.println("Book is not found");
		}
		
		if(read==1)
			return true;
		else
			return false;
	}
	
	//@Requires({"name!=null"})
	//@Ensures({"result==true|| result==false"})	
	public boolean borrow_Book(Library l,String name)
	{
		int found=0,borrow=0;
		boolean success=false;
		List<Study_Books> sb = l.getStudybooklist();
			
			for(Study_Books x : sb)
			{	
				if (x.getBook_Name().equals(name))
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						x.setBook_status("In_Use");
						x.Borrow_Status=true;
						borrow=1;
					}
				}
				
			}
			if(found==0)
			{
				System.out.println("Book not found. Only Study books can be borrowed");
			}
			if(borrow==1)
				return true;
			else
				return false;
		}
	
	//@Requires({"name!=null"})
	//@Ensures({"result==true|| result==false"})
	public boolean return_Book(Library l,String name)
	{
		int found=0,return_b=0;
		boolean success=false;
		List<Study_Books> sb = l.getStudybooklist();
			
			for(Study_Books x : sb)
			{	
				if (x.getBook_Name().equals(name))
				{
					found=1;
					if(x.getBook_status().equals("In_Use"))
					{	
						x.setBook_status("Available");
						x.Borrow_Status=false;
						return_b=1;
					}
				}
				
			}
			if(found==0)
			{
				System.out.println("You have given wrong book name");
			}
			if(return_b==1)
				return true;
			else
				return false;
		}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

