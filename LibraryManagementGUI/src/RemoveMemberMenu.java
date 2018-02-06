import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RemoveMemberMenu extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public RemoveMemberMenu(Library l,String librarian_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Welcome " + librarian_Name +" !!");
		
		JLabel lblNewLabel_0 = new JLabel("Enter Member Name :");
		
		JTextField textField_0 = new JTextField();
		
		textField_0.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Select Member Category :");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Adult");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		JButton btnAddNBook = new JButton("Remove member");
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag3=0,flag2=0;
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
				
				if(flag2==1&&flag3==1)
				{
					remove_Member(l,librarian_Name,Name,Category);
				}
				
			}});
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_0);
		contentPane.add(textField_0);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(btnAddNBook);

		setVisible(true);
			}
		public void remove_Member(Library l, String librarian_Name, String Name, String Category)
		{
			if (Category.equals("Adult"))
			{   
				int found=0;
				Adult rem=new Adult();
				List<Adult> a = l.getAdultlist();
				
				for(Adult x : a)
				{	
					if (x.getName().equals(Name))
					{
						rem=x;
						found=1;
					}
					
				}
				if(found==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Given adult member not found");
					dispose();
					new LibrarianMenu(l,librarian_Name);
				}
				else if(l.adultlist.remove(rem))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Given adult member removed sucessfully");
					dispose();
					new LibrarianMenu(l,librarian_Name);
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Error on removing membership");
					dispose();
					new LibrarianMenu(l,librarian_Name);
				}
			}
			
			else if (Category.equals("Student"))
			{   
				int found=0;
				Student rem=new Student();
				List<Student> s = l.getStudentlist();
				
				for(Student x : s)
				{	
					if (x.getName().equals(Name))
					{
						rem=x;
						found=1;
					}
					
				}
				if(found==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Given student member not found");
					dispose();
					new LibrarianMenu(l,librarian_Name);
				}
				else if(l.studentlist.remove(rem))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Given student member removed sucessfully");
					dispose();
					new LibrarianMenu(l,librarian_Name);
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Error on removing membership");
					dispose();
					new LibrarianMenu(l,librarian_Name);
				}
			}

		}
	}


