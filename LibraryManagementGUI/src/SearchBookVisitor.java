import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

public class SearchBookVisitor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	int found=0,read=0;


	public SearchBookVisitor(Library l,String memberName) {
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblSelectTheBook = new JLabel("Select the book Category:");
		GridBagConstraints gbc_lblSelectTheBook = new GridBagConstraints();
		gbc_lblSelectTheBook.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectTheBook.gridx = 4;
		gbc_lblSelectTheBook.gridy = 2;
		contentPane.add(lblSelectTheBook, gbc_lblSelectTheBook);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Journal");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 3;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Magazine");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 4;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Study Books");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_2.gridx = 4;
		gbc_rdbtnNewRadioButton_2.gridy = 5;
		contentPane.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Reference Books");
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_3.gridx = 4;
		gbc_rdbtnNewRadioButton_3.gridy = 6;
		contentPane.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		
		JButton btnNext = new JButton("Next");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 7;
		contentPane.add(btnNext, gbc_btnNext);
		
		setVisible(true);
		btnNext.addActionListener(new ActionListener() {
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
			if(flag1==1&& flag3==1)
			search_Book(l,Book_Name,Category,memberName);
			
		}
	});
	
	}
	public void search_Book(Library l,String Book_Name,String Category,String memberName)
	{
		
		if (Category.equals("Journal"))
		{   		
			
			contentPane.removeAll();
			contentPane.revalidate();
			contentPane.repaint();
			contentPane.setLayout(new GridLayout(0,1));
			
			JLabel lblNewLabel_1 = new JLabel("Enter Issue Number:");
			
			textField = new JTextField();
			textField.setColumns(10);
			JButton btnAddNBook = new JButton("Read Journal");
			
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);
			contentPane.add(btnAddNBook);
			
			btnAddNBook.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					int issue=0;
					
					try 
					{
						issue= Integer.parseInt(textField.getText());
					} 
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild Issue number");   
					}
					
					List<Journal> j = l.getJournallist();
			
					for(Journal x : j)
					{	
						if (x.getBook_Name().equals(Book_Name) && x.getIssue_Number()==issue)
						{
							found=1;
							if(x.getBook_status().equals("Available"))
							{	
								read=1;
							}
						}
				
					}
				}
				});
		}
		
		
		else if (Category.equals("Magazine"))
		{   		
			
			contentPane.removeAll();
			contentPane.revalidate();
			contentPane.repaint();
			contentPane.setLayout(new GridLayout(0,1));
			
			JLabel lblNewLabel_1 = new JLabel("Enter Issue Number:");
			
			textField = new JTextField();

			textField.setColumns(10);
			
		
			
			JButton btnAddNBook = new JButton("Read Magazine");
			
			contentPane.add(lblNewLabel_1);
			contentPane.add(textField);
			contentPane.add(btnAddNBook);
			
			btnAddNBook.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					int issue=0;
					
					try 
					{
						issue= Integer.parseInt(textField.getText());
					} 
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild Issue number");   
					}
					
					List<Magazine> j = l.getMagazinelist();
			
					for(Magazine x : j)
					{	
						if (x.getBook_Name().equals(Book_Name) && x.getIssue_Number()==issue)
						{
							found=1;
							if(x.getBook_status().equals("Available"))
							{	
								read=1;
							}
						}
				
					}
				}
				});
		}
		
		else if (Category.equals("Study Books"))
		{   
			List<Study_Books> sb = l.getStudybooklist();
			
			for(Study_Books x : sb)
			{	
				if (x.getBook_Name().equals(Book_Name))
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						read=1;
					}
				}
				
			}
		}
		
		else if (Category.equals("Reference Books"))
		{   
			List<Reference_Books> rb = l.getReferencebooklist();
			
			for(Reference_Books x : rb)
			{	
				if (x.getBook_Name().equals(Book_Name))
				{
					found=1;
					if(x.getBook_status().equals("Available"))
					{	
						read=1;
					}
				}
				
			}
		}
		
		if(read==1)
		{
			dispose();
			JOptionPane.showMessageDialog(new JFrame(), "Book is found"); 
			new VisitorMenu(l,memberName);
		}
		
		else if(found==1)
		{
			dispose();
			JOptionPane.showMessageDialog(new JFrame(), "Book is in use");
			new VisitorMenu(l,memberName);
		}
		else
		{
			dispose();
			JOptionPane.showMessageDialog(new JFrame(), "Book not found");
			new VisitorMenu(l,memberName);
		}
		
		
	}
	

}
