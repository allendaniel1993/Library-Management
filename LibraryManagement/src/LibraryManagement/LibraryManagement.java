package LibraryManagement;

import java.util.*;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

public class LibraryManagement {

	public static void main(String[] args) 
	{
		int choice;
		Library l=new Library("ABC Library");
		l.getLibraryName();
		Scanner s = new Scanner(System.in);
		boolean redo=true;
		while(redo)
		{
		System.out.println("Please select one : \n 1.Visitor \n 2.Member \n 3.Librarian \n 4.Exit");
		System.out.println("Enter your Choice:");
		try
		{
		choice = s.nextInt();
		s.nextLine();
			if(choice==1||choice==2||choice==3||choice==4)
			{
				switch(choice)
				{
				case 1:
						System.out.println("Enter your name :");
						String v_name = s.nextLine();
						Visitor v=new Visitor(v_name);
						System.out.println("Welcome " + v_name);
						v.menu(l,v_name);
						break;
				case 2:
						System.out.println("Enter your name :");
						String m_name = s.nextLine();
						System.out.println("Enter member category(Student/Adult) :");
						String m_cat=s.nextLine();
						int found=0;
						if (m_cat.equals("Adult"))
						{  
							Adult rem=new Adult();
							List<Adult> a = l.getAdultlist();
						
							for(Adult x : a)
								{	
									if (x.getName().equals(m_name))
										{
											found=1;
											x.menu(l,m_name);
										}
								}
						}
						else if (m_cat.equals("Student"))
						{  
							Student rem=new Student();
							List<Student> st = l.getStudentlist();
						
							for(Student x : st)
								{	
									if (x.getName().equals(m_name))
										{
											found=1;
											x.menu(l,m_name);
										}
								}
						}
						else
						{
							System.out.println("Invalid Category");
						}
						
						if(found==0)
						{
							System.out.println("You are not a member");
						}
						break;
						
				case 3:
						System.out.println("Enter your name");
						String l_name = s.nextLine();
						Librarian li = new Librarian(l_name); 
						System.out.println("Welcome " + l_name);
						li.menu(l,l_name);
						break;
						
				case 4:
						System.out.println("Thank You");
						redo=false;
						System.exit(0);
	
				default:
						break;
			
				}
				
			}
			else
			{
				System.out.println("Bad input.. Try Again");
			}
		
		}
		catch (InputMismatchException e) {
			String str = s.next();
			System.out.println("Bad input.. Try Again");
		}
		}
		s.close();
		
	}
	
}
