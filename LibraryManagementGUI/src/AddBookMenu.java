import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddBookMenu extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JTextField textField;
	JTextField textField_1;
	public AddBookMenu(Library l, String librarian_Name) {
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
		
		JLabel lblNewLabel_2 = new JLabel("Enter Price");

		textField_1 = new JTextField();
		
		textField_1.setColumns(10);
		
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
		JButton btnAddNBook = new JButton("Add Book");

		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton_3);	
		contentPane.add(btnAddNBook);

		setVisible(true);
		
	
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0,flag1=0,flag3=0;
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
				try 
				{
					Price= Double.parseDouble(textField_1.getText());
					flag=1;
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild price.");   
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
				if(flag==1 &&flag1==1&& flag3==1)
				add_Book(l,Book_Name,Price,Category,librarian_Name);
				
			}
		});
		
	
}
	public void add_Book(Library l,String name,double price,String cat, String librarian_Name)
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
			
			JLabel lblNewLabel_3 = new JLabel("Select Journal Category :");
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Education");
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("General");
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnNewRadioButton);
			group.add(rdbtnNewRadioButton_1);
			
			JButton btnAddNBook = new JButton("Add Journal");
			
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);
			contentPane.add(lblNewLabel_3);
			contentPane.add(rdbtnNewRadioButton);
			contentPane.add(rdbtnNewRadioButton_1);
			contentPane.add(btnAddNBook);
			
			btnAddNBook.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					int flag1=0,flag2=0;
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
					
					if(rdbtnNewRadioButton.isSelected())
					{
						Category = "Education";
						flag2=1;
					}
					else if(rdbtnNewRadioButton_1.isSelected())
					{
						Category = "General";
						flag2=1;
					}
					
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please select one category"); 
					}
			
					if(flag1==1 && flag2==1)
					{
						if(l.journallist.add(new Journal(name, price, "Available", issue, Category)))
						{
						JOptionPane.showMessageDialog(new JFrame(), "Book added successfully!!");
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
			
			JLabel lblNewLabel_3 = new JLabel("Select Magazine Category :");
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Education");
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("General");
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnNewRadioButton);
			group.add(rdbtnNewRadioButton_1);
			
			JButton btnAddNBook = new JButton("Add Journal");
			
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);
			contentPane.add(lblNewLabel_3);
			contentPane.add(rdbtnNewRadioButton);
			contentPane.add(rdbtnNewRadioButton_1);
			contentPane.add(btnAddNBook);
			btnAddNBook.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					int flag1=0,flag2=0;
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
					
					if(rdbtnNewRadioButton.isSelected())
					{
						Category = "Education";
						flag2=1;
					}
					else if(rdbtnNewRadioButton_1.isSelected())
					{
						Category = "General";
						flag2=1;
					}
					
					else
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please select one category");   
					}
			if(flag1==1 && flag2==1)
			{
				if(l.magazinelist.add(new Magazine(name, price, "Available", issue, Category)))
				{
				JOptionPane.showMessageDialog(new JFrame(), "Book added successfully!!");   
				}
				else
				{
				JOptionPane.showMessageDialog(new JFrame(), "Error in adding book!!");   
				}
			}
				}
			});
		}
		
		else if (cat.equals("Study Books"))
		{   
			contentPane.removeAll();
			contentPane.revalidate();
			contentPane.repaint();
			contentPane.setLayout(new GridLayout(0,1));
			
			JLabel lblNewLabel_1 = new JLabel("Enter Author Name:");
			
			textField = new JTextField();

			textField.setColumns(10);
			JButton btnAddNBook = new JButton("Add Study Book");
			
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);

			contentPane.add(btnAddNBook);
			
		
			btnAddNBook.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					String author=null;
					
					author= textField.getText();
					
					if (author.isEmpty())
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild Author Name");   
					}
			
					else
					{
						if(l.studybooklist.add(new Study_Books(name, price, "Available", author,false)))
						{
							JOptionPane.showMessageDialog(new JFrame(), "Book added successfully!!");   
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Error in adding book!!");   
						}
					}
				}
			});
		}
		
		
		else if (cat.equals("Reference Books"))
		{   
			contentPane.removeAll();
			contentPane.revalidate();
			contentPane.repaint();
			contentPane.setLayout(new GridLayout(0,1));
			
			JLabel lblNewLabel_1 = new JLabel("Enter Author Name:");
			
			textField = new JTextField();

			textField.setColumns(10);
			
			
			JButton btnAddNBook = new JButton("Add Study Book");
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);

			contentPane.add(btnAddNBook);
			btnAddNBook.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					String author=null;
					author= textField.getText();
					
					if (author.isEmpty())
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild Author Name");   
					}
					else
					{
						if(l.referencebooklist.add(new Reference_Books(name, price, "Available", author)))
						{
							JOptionPane.showMessageDialog(new JFrame(), "Book added successfully!!");   
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Error in adding book!!");   
						}
					}
				}
			});
		}
	}

}


