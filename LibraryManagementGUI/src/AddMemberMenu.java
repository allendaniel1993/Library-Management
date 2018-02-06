import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddMemberMenu extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_0;
	JTextField textField_0;


	public AddMemberMenu(Library l,String librarian_Name) {
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
		
		JLabel lblNewLabel_3 = new JLabel("Select Member Category :");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Adult");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Years of Membership Required :");
		
		JTextField textField_2 = new JTextField();

		textField_2.setColumns(10);
		
		JButton btnAddNBook = new JButton("Add member");
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag3=0,flag2=0,flag4=0;
				int Years=0;
				String Category=null;
				String Name=null;
	
				Name=textField_0.getText();
				if(Name.isEmpty())
				{
				JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Name"); 
				}
				else
				{
					flag2=1;
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
					Years= Integer.parseInt(textField_2.getText());
					flag4=1;
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild year in number");   
				}
				
				
				if(flag2==1 && flag3==1 && flag4==1)
				add_Member(l,librarian_Name,Name,Category,Years);
				
			}
			});
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_0);
		contentPane.add(textField_0);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textField_2);
	
		contentPane.add(btnAddNBook);
		

		setVisible(true);
			}
	public void add_Member(Library l, String librarian_Name, String Name, String Category,int years)
	{
		
		if (Category.equals("Student"))
		{   
			contentPane.removeAll();
			contentPane.revalidate();
			contentPane.repaint();
			contentPane.setLayout(new GridLayout(0,1));
			
			JLabel lblNewLabel_1 = new JLabel("Enter Student ID Number:");
			
			JTextField  textField = new JTextField();

			textField.setColumns(10);
			
			JButton btnAddNBook1 = new JButton("Add Student");
			
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);
			contentPane.add(btnAddNBook1);
			
			btnAddNBook1.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					int Student_ID=0,flag=0;
					double fee=0.00;
					try 
					{
						Student_ID= Integer.parseInt(textField.getText());
						fee = years*100;
						if(l.studentlist.add(new Student(Name,Student_ID)))
						{ 
						JOptionPane.showMessageDialog(new JFrame(), "Member added Sucessfully. The membership fee is: "+fee); 
						dispose();
						new LibrarianMenu(l,librarian_Name);
						}
						else
						{
						JOptionPane.showMessageDialog(new JFrame(), "Error in adding member");
						dispose();
						new LibrarianMenu(l,librarian_Name);
						}
					} 
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild number");
					}
				}
			});
		}
		else if (Category.equals("Adult"))
		{
			
			int fee = years*250;
			if(l.adultlist.add(new Adult(Name)))
			{ 
			JOptionPane.showMessageDialog(new JFrame(), "Member added Sucessfully. The membership fee is: "+fee); 
			dispose();
			new LibrarianMenu(l,librarian_Name);
			}
			else
			{
			JOptionPane.showMessageDialog(new JFrame(), "Error in adding member");
			dispose();
			new LibrarianMenu(l,librarian_Name);
			}
		}
			
	}
	}

