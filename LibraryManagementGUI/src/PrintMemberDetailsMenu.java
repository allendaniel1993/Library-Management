import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class PrintMemberDetailsMenu extends JFrame {

	private JPanel contentPane;

	public PrintMemberDetailsMenu(Library l, String librarian_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Welcome " + librarian_Name +" !!");
		
		JLabel lblNewLabel_3 = new JLabel("Select Member Type :");
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Adult");
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Student");
		
		JButton btnAddNBook = new JButton("Get member Details");
		
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton_1);	
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
					for (Adult j : l.adultlist)
					{
						
						JLabel lblNewLabel_1 = new JLabel("The Adult Member Name is :"+j.getName());
						JLabel lblNewLabel_2 = new JLabel("The Member Id is :"+j.getMember_Id());
						JLabel lblNewLabel_3 = new JLabel("The Adult Member Fine is :"+j.getFine());
						
						
						contentPane.add(lblNewLabel_1);
						contentPane.add(lblNewLabel_2);
						contentPane.add(lblNewLabel_3);
						
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
					for (Student j : l.studentlist)
					{
						
						JLabel lblNewLabel_1 = new JLabel("The Student Member Name is :"+j.getName());
						JLabel lblNewLabel_2 = new JLabel("The Member Id is :"+j.getMember_Id());
						JLabel lblNewLabel_3 = new JLabel("The Student Member Fine is :"+j.getFine());
						JLabel lblNewLabel_4 = new JLabel("The Student Id is :"+j.getStudent_Id());
						
						
						contentPane.add(lblNewLabel_1);
						contentPane.add(lblNewLabel_2);
						contentPane.add(lblNewLabel_3);
						contentPane.add(lblNewLabel_4);
						
						
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