import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class PrintBookDetailsMenu extends JFrame {

	private JPanel contentPane;

	public PrintBookDetailsMenu(Library l,String librarian_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Welcome " + librarian_Name +" !!");
		
		JLabel lblNewLabel_3 = new JLabel("Select book Type :");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Journal");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Magazine");
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Study Books");
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Reference Books");
		JButton btnAddNBook = new JButton("Get book Details");
		
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton_3);	
		contentPane.add(btnAddNBook);

		setVisible(true);
		
	
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnNewRadioButton.isSelected())
				{
					contentPane.removeAll();
					contentPane.revalidate();
					contentPane.repaint();
					contentPane.setLayout(new GridLayout(0,1));
					for (Journal j : l.journallist)
					{
						JLabel lblNewLabel_1 = new JLabel("The Journal Name is :"+j.getBook_Name());
						JLabel lblNewLabel_2 = new JLabel("The Journal Id is :"+j.getBook_Id());
						JLabel lblNewLabel_3 = new JLabel("The Journal Status is :"+j.getBook_status());
						JLabel lblNewLabel_4 = new JLabel("The Journal Price is :"+j.getPrice());
						JLabel lblNewLabel_5 = new JLabel("The Journal Issue Number is :"+j.getIssue_Number());
						JLabel lblNewLabel_6 = new JLabel("The Journal Category is :"+j.getJournal_Category());
					
						
						contentPane.add(lblNewLabel_1);
						contentPane.add(lblNewLabel_2);
						contentPane.add(lblNewLabel_3);
						contentPane.add(lblNewLabel_4);
						contentPane.add(lblNewLabel_5);
						contentPane.add(lblNewLabel_6);
						
					}
					JButton prev=new JButton("Previous");
					contentPane.add(prev);
					prev.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							new LibrarianMenu(l,librarian_Name);
						}
						});
				}
				else if (rdbtnNewRadioButton_1.isSelected())
				{
					contentPane.removeAll();
					contentPane.revalidate();
					contentPane.repaint();
					contentPane.setLayout(new GridLayout(0,1));
					for (Magazine m : l.magazinelist)
					{
						
						JLabel lblNewLabel_1 = new JLabel("The Magazine Name is :"+m.getBook_Name());
						JLabel lblNewLabel_2 = new JLabel("The Magazine Id is :"+m.getBook_Id());
						JLabel lblNewLabel_3 = new JLabel("The Magazine Status is :"+m.getBook_status());
						JLabel lblNewLabel_4 = new JLabel("The Magazine Price is :"+m.getPrice());
						JLabel lblNewLabel_5 = new JLabel("The Magazine Issue Number is :"+m.getIssue_Number());
						JLabel lblNewLabel_6 = new JLabel("The Magazine Category is :"+m.getMagazine_Category());
				
						contentPane.add(lblNewLabel_1);
						contentPane.add(lblNewLabel_2);
						contentPane.add(lblNewLabel_3);
						contentPane.add(lblNewLabel_4);
						contentPane.add(lblNewLabel_5);
						contentPane.add(lblNewLabel_6);
						
					}	
					JButton prev=new JButton("Previous");
					contentPane.add(prev);
					prev.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							new LibrarianMenu(l,librarian_Name);
						}
						});
				}
				else if (rdbtnNewRadioButton_2.isSelected())
				{
					contentPane.removeAll();
					contentPane.revalidate();
					contentPane.repaint();
					contentPane.setLayout(new GridLayout(0,1));
					for (Study_Books m : l.studybooklist)
					{
						
						
						JLabel lblNewLabel_1 = new JLabel("The Study Book Name is :"+m.getBook_Name());
						JLabel lblNewLabel_2 = new JLabel("The Study Book Id is :"+m.getBook_Id());
						JLabel lblNewLabel_3 = new JLabel("The Study Book Status is :"+m.getBook_status());
						JLabel lblNewLabel_4 = new JLabel("The Study Book Price is :"+m.getPrice());
						JLabel lblNewLabel_5 = new JLabel("The Study Book Author Status is :"+m.getAuthor());
						JLabel lblNewLabel_6 = new JLabel("The Study Book Borrow Status is :"+m.getBorrow_Status());
						
						contentPane.add(lblNewLabel_1);
						contentPane.add(lblNewLabel_2);
						contentPane.add(lblNewLabel_3);
						contentPane.add(lblNewLabel_4);
						contentPane.add(lblNewLabel_5);
						contentPane.add(lblNewLabel_6);
						
					}	
					JButton prev=new JButton("Previous");
					contentPane.add(prev);
					prev.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							new LibrarianMenu(l,librarian_Name);
						}
						});
				}
				else if (rdbtnNewRadioButton_3.isSelected())
				{
					contentPane.removeAll();
					contentPane.revalidate();
					contentPane.repaint();
					contentPane.setLayout(new GridLayout(0,1));
					for (Study_Books m : l.studybooklist)
					{
						
						JLabel lblNewLabel_1 = new JLabel("The Reference Book Name is :"+m.getBook_Name());
						JLabel lblNewLabel_2 = new JLabel("The Reference Book Id is :"+m.getBook_Id());
						JLabel lblNewLabel_3 = new JLabel("The Reference Book Status is :"+m.getBook_status());
						JLabel lblNewLabel_4 = new JLabel("The Reference Book Price is :"+m.getPrice());
						JLabel lblNewLabel_5 = new JLabel("The Reference Book Author is :"+m.getAuthor());			
						
						contentPane.add(lblNewLabel_1);
						contentPane.add(lblNewLabel_2);
						contentPane.add(lblNewLabel_3);
						contentPane.add(lblNewLabel_4);
						contentPane.add(lblNewLabel_5);
						
					}
					JButton prev=new JButton("Previous");
					contentPane.add(prev);
					prev.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							new LibrarianMenu(l,librarian_Name);
						}
						});
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select one catgory");   
				}
			}
	});
	}
}
