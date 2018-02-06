import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CalculateFineMenu extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JTextField textField;
	JLabel lblNewLabel_0;
	JTextField textField_0;


	public CalculateFineMenu(Library l,String librarian_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Welcome " + librarian_Name +" !!");
		
		lblNewLabel_0 = new JLabel("Enter Member Name :");
		
		textField_0 = new JTextField();
		
		textField_0.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Enter Book Name :");
		
		textField = new JTextField();

		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Select Member Category :");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Adult");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Number of Days :");
		
		JTextField textField_2 = new JTextField();

		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Is book Lost ?? :");
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yes");
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("No");
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtnNewRadioButton_2);
		group1.add(rdbtnNewRadioButton_3);

		JButton btnAddNBook = new JButton("Calculate Fine");
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag1=0,flag3=0,flag2=0,flag4=0,flag5=0;
				int Days=0;
				String Category=null;
				String Name=null,Book_Name=null;
				boolean lost=false;
				Name=textField_0.getText();
				if(Name.isEmpty())
				{
				JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Name"); 
				}
				else
				{
					flag2=1;
				}
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
					Category = "Student";
					flag3=1;
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					Category = "Adult";
					flag3=1;
				}
	
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select one catgory");   
				}
				
				try 
				{
					Days= Integer.parseInt(textField_2.getText());
					flag4=1;
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild number");   
				}
				
				if(rdbtnNewRadioButton_2.isSelected())
				{
					lost=true;
					flag5=1;
				}
				else if(rdbtnNewRadioButton_3.isSelected())
				{
					lost=false;
					flag5=1;
				}
	
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select one lost/not lost");   
				}
				
				if(flag1==1 && flag2==1 && flag3==1 && flag4==1 && flag5==1)
				calculate_Fine(l,librarian_Name,Name,Book_Name,Days,Category,lost);
			
			}
		});

		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_0);
		contentPane.add(textField_0);
		contentPane.add(lblNewLabel_1);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_2);
		contentPane.add(lblNewLabel_4);
		contentPane.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton_3);
	
		contentPane.add(btnAddNBook);
		

		setVisible(true);
	}
	
	public void calculate_Fine(Library l,String l_Name,String Name,String Book_Name,int Days, String Category,Boolean lost)
	{
		List<Study_Books> b = l.getStudybooklist();
		List<Adult> m_a = l.getAdultlist();
		List<Student>  m_s = l.getStudentlist();
		double price=0.00,fine=0.00;
		int flag=0,flag1=0,flag2=0;
		for(Book x : b)
		{	
			if (x.getBook_Name().equals(Book_Name))
			{
				price=x.getPrice();
				flag=1;
			}
			  
		}
		if(flag==0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Book not found");   
			flag2=1;
			dispose();
			new LibrarianMenu(l,l_Name);
		}
	
		if(lost)
		{
			fine=price*50/100;
		}
		else
		{
			if(Days<10)
				fine= 2.00;
			else
				fine= 2.00+(Days-10)*1.00;
		}
		
		if(Category.equals("Adult"))
		{
			for(Adult y : m_a)
			{	
				if (y.getName().equals(Name))
				{
					y.setFine(fine);
					flag1=1;
				}
			
			}
		}
		
		else if (Category.equals("Student"))
		for(Student y : m_s)
		{	
			if (y.getName().equals(Name))
			{
				y.setFine(fine);
				flag1=1;
			}
			
		}
		
		if(flag1==0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Member not found.");   
			flag2=1;
			dispose();
			new LibrarianMenu(l,l_Name);
		}
		if(flag2==0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "The fine amount is: "+ fine); 
			dispose();
			new LibrarianMenu(l,l_Name);
		}
	}
	
}

