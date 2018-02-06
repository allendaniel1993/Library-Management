import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RemoveBookMenu extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JTextField textField;


	/**
	 * Create the frame.
	 */
	public RemoveBookMenu(Library l, String librarian_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		lblNewLabel = new JLabel("Welcome " + librarian_Name +" !!");
		
		lblNewLabel_1 = new JLabel("Enter Book Name :");
		
		textField = new JTextField();

		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Select book Type :");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Journal");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Magazine");
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Study Books");
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Reference Books");
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		JButton btnAddNBook = new JButton("Next");

		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton_3);	
		contentPane.add(btnAddNBook);

		setVisible(true);
		
	
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag1=0,flag3=0;
				double Price=0.0;
				String Category=null;
				String Book_Name=null;
				
				Book_Name=textField.getText();
				if(Book_Name.isEmpty())
				{
				JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Book Name"); 
				}
				else
				{
					flag1=1;
				}
				
				if(rdbtnNewRadioButton.isSelected())
				{
					Category = "Journal";
					flag3=1;
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					Category = "Magazine";
					flag3=1;
				}
				else if(rdbtnNewRadioButton_2.isSelected())
				{
					Category = "Study Books";
					flag3=1;
				}
				else if(rdbtnNewRadioButton_3.isSelected())
				{
					Category = "Reference Books";
					flag3=1;
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select one choice");   
				}
				if(flag1==1 && flag3==1)
				remove_Book(l,Book_Name,Category,librarian_Name);
				
			}
		});
	}	
	


public void remove_Book(Library l,String name,String cat,String librarian_Name)
{

	if (cat.equals("Journal"))
	{   
		contentPane.removeAll();
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.setLayout(new GridLayout(0,1));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Issue Number:");
		
		textField = new JTextField();

		textField.setColumns(10);
		
		
		JButton btnAddNBook1 = new JButton("Remove Journal");
		
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(btnAddNBook1);
		
		btnAddNBook1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag1=0,found=0;
				int issue=0;
				String Category=null;
				
				try 
				{
					issue= Integer.parseInt(textField.getText());
					flag1=1;
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild Issue number");   
				}
		
				if(flag1==1)
				{
					Journal rem=new Journal();
					List<Journal> j = l.getJournallist();
					
					for(Journal x : j)
					{	
						if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue)
						{
							rem=x;
							found=1;
						}
						
					}
					if(found==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Journal Not Found!!");
						dispose();
						new LibrarianMenu(l,librarian_Name);
					}
					
					if(found==1)
					{
					if(l.journallist.remove(rem))
					{
					JOptionPane.showMessageDialog(new JFrame(), "Book removed successfully!!");
					dispose();
					new LibrarianMenu(l,librarian_Name);
					
					}
					else
					{
					JOptionPane.showMessageDialog(new JFrame(), "Error in removing book!!");  
					dispose();
					new LibrarianMenu(l,librarian_Name);
					}
					}
					
				}
			}
		});
	}
	
	else if (cat.equals("Magazine"))
	{   
		contentPane.removeAll();
		contentPane.revalidate();
		contentPane.repaint();
		contentPane.setLayout(new GridLayout(0,1));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Issue Number:");
		
		textField = new JTextField();

		textField.setColumns(10);
		
		JButton btnAddNBook1 = new JButton("Remove Magazine");
		
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(btnAddNBook1);
		
		btnAddNBook1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag1=0,found=0;
				int issue=0;
				String Category=null;
				
				try 
				{
					issue= Integer.parseInt(textField.getText());
					flag1=1;
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild Issue number");   
				}
		
				if(flag1==1)
				{
					Magazine rem=new Magazine();
					List<Magazine> j = l.getMagazinelist();
					
					for(Magazine x : j)
					{	
						if (x.getBook_Name().equals(name) && x.getIssue_Number()==issue)
						{
							rem=x;
							found=1;
						}
						
					}
					if(found==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Magazine Not Found!!");
						dispose();
						new LibrarianMenu(l,librarian_Name);
					}
					
					if(found==1)
					{
					if(l.magazinelist.remove(rem))
					{
					JOptionPane.showMessageDialog(new JFrame(), "Book removed successfully!!");
					dispose();
					new LibrarianMenu(l,librarian_Name);
					
					}
					else
					{
					JOptionPane.showMessageDialog(new JFrame(), "Error in removing book!!");  
					dispose();
					new LibrarianMenu(l,librarian_Name);
					}
					}
					
				}
			}
		});
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
						JOptionPane.showMessageDialog(new JFrame(), "Study Book Not Found!!");
						dispose();
						new LibrarianMenu(l,librarian_Name);
					}
					
					if(found==1)
					{
					if(l.studybooklist.remove(rem))
					{
					JOptionPane.showMessageDialog(new JFrame(), "Book removed successfully!!");
					dispose();
					new LibrarianMenu(l,librarian_Name);
					
					}
					else
					{
					JOptionPane.showMessageDialog(new JFrame(), "Error in adding book!!");  
					dispose();
					new LibrarianMenu(l,librarian_Name);
					}
					}
					
				}
	
	else if (cat.equals("Reference Books"))
	{   
		int found=0;
		Reference_Books rem=new Reference_Books();
		List<Reference_Books> sb = l.getReferencebooklist();
		
		for(Reference_Books x : sb)
		{	
			if (x.getBook_Name().equals(name))
			{
				rem=x;
				found=1;
			}
			
		}
					if(found==0)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Reference Book Not Found!!");
						dispose();
						new LibrarianMenu(l,librarian_Name);
					}
					
					if(found==1)
					{
					if(l.referencebooklist.remove(rem))
					{
					JOptionPane.showMessageDialog(new JFrame(), "Book removed successfully!!");
					dispose();
					new LibrarianMenu(l,librarian_Name);
					
					}
					else
					{
					JOptionPane.showMessageDialog(new JFrame(), "Error in adding book!!");  
					dispose();
					new LibrarianMenu(l,librarian_Name);
					}
					}
					
				}
	
}
}
