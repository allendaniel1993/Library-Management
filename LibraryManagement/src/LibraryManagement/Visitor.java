package LibraryManagement;

/*import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;*/
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//@Invariant("name!=null")
public class Visitor 
	
{
	String name;
	public Visitor(String name)
	{
		this.name=name;
	}
	public void menu(Library l,String name)
	{
		int choice=0;
		Scanner s1 = new Scanner(System.in);
		boolean redo=true;
		System.out.println("Welcome "+this.name);
		while(redo)
		{
		System.out.println("Please select one : \n 1.Read Books \n 2.Search Book \n 4.Exit");
		System.out.println("Enter your Choice:");
		try
		{
		choice = s1.nextInt();
		s1.nextLine();
			if(choice==1||choice==2||choice==3)
			{
				switch(choice)
				{
					case 1:
							System.out.println("Enter Book Name: ");
							String b_name=s1.nextLine();
							System.out.println("Enter Book Category(Journal/Magazine/Study Books/Reference Books) :");
							String b_category=s1.nextLine();
							if(read_Book(l,b_name,b_category))
								System.out.println("Book is available for reading");
							else
								System.out.println("Book is not available for reading");
							break;
					case 2:
							System.out.println("Enter Book Name");
							String bk_name=s1.nextLine();
							System.out.println("Enter Book Category(Journal/Magazine/Study Books/Reference Books) :");
							String bk_category=s1.nextLine();
							if(search_Book(l,bk_name,bk_category))
								System.out.println("Book is available");
							else
								System.out.println("Book is not available");
							break;
					
					case 3:
							System.out.println("Thank You");
							redo=false;
							System.exit(0);
							break;
					
					default:
							System.out.println("Thank You");
							break;
				}
				
			}
			else
			{
				System.out.println("Bad input.. Try Again");
			}
		
		}
		catch (InputMismatchException e) 
		{
			String str = s1.next();
			System.out.println("Bad input.. Try Again");
		}
	}s1.close();
	
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
	
		
}

