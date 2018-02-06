import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BorrowBookMenu extends JFrame {

	private JPanel contentPane;

	
	public BorrowBookMenu(Library l,String memberName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEnterBookName = new JLabel("Enter Book Name:");
		GridBagConstraints gbc_lblEnterBookName = new GridBagConstraints();
		gbc_lblEnterBookName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterBookName.gridx = 2;
		gbc_lblEnterBookName.gridy = 1;
		contentPane.add(lblEnterBookName, gbc_lblEnterBookName);
		
		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("Borrow Book");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 7;
		contentPane.add(btnNext, gbc_btnNext);
		
		setVisible(true);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String Book_Name=null;
			Book_Name=textField.getText();
			if(Book_Name.isEmpty())
			{
			JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Book Name"); 
			}
			else
			{
				int found=0,borrow=0;
				List<Study_Books> sb = l.getStudybooklist();
					
					for(Study_Books x : sb)
					{	
						if (x.getBook_Name().equals(Book_Name))
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
					if(borrow==1)
					{
						dispose();
						JOptionPane.showMessageDialog(new JFrame(), "Book Borrowed sucessfully");						
						new MemberMenu(l,memberName);
					}
					else if(found==1)
					{
						dispose();
						JOptionPane.showMessageDialog(new JFrame(), "Book is in use"); 
						new MemberMenu(l,memberName);
					}
					else
					{
						dispose();
						JOptionPane.showMessageDialog(new JFrame(), "Book Not found. Only study books can be borrowed");
						new MemberMenu(l,memberName);
					}
			}
			}});
	}

}
