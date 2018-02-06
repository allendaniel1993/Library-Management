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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class MemberMenu extends JFrame {

	private JPanel contentPane;

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	
	private JButton btnNext;
	private JLabel lblSelectYourCategory;

	public MemberMenu(Library l,String member_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblSelectYourCategory = new JLabel("Select your Category:");
		GridBagConstraints gbc_lblSelectYourCategory = new GridBagConstraints();
		gbc_lblSelectYourCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectYourCategory.gridx = 4;
		gbc_lblSelectYourCategory.gridy = 1;
		contentPane.add(lblSelectYourCategory, gbc_lblSelectYourCategory);
		

		
		rdbtnNewRadioButton = new JRadioButton("Student");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 3;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Adult");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 4;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		
		btnNext = new JButton("Next");
		
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 12;
		contentPane.add(btnNext, gbc_btnNext);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		setVisible(true);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int found=0;
				
				if(rdbtnNewRadioButton.isSelected())
				{
					Student rem=new Student();
					List<Student> st = l.getStudentlist();
				
					for(Student x : st)
						{	
							if (x.getName().equals(member_Name))
								{
									found=1;
								}
						}
				}
				

				else if(rdbtnNewRadioButton_1.isSelected())
				{
					Adult rem=new Adult();
					List<Adult> a = l.getAdultlist();
				
					for(Adult x : a)
						{	
							if (x.getName().equals(member_Name))
								{
									found=1;
								}
						}
				}
					
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select a choice"); 
				}
				
				if(found==1)
				{
					contentPane.removeAll();
					contentPane.revalidate();
					contentPane.repaint();
					contentPane.setLayout(new GridLayout(0,1));
					JLabel lblNewLabel_3 = new JLabel("Select One :");
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Read Book");
					JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Search Book");
					JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Borrow Book");
					JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Return Book");
					ButtonGroup group = new ButtonGroup();
					group.add(rdbtnNewRadioButton);
					group.add(rdbtnNewRadioButton_1);
					group.add(rdbtnNewRadioButton_2);
					group.add(rdbtnNewRadioButton_3);
					
					JButton btnAddNBook = new JButton("Next");
					
					contentPane.add(lblNewLabel_3);
					contentPane.add(rdbtnNewRadioButton);
					contentPane.add(rdbtnNewRadioButton_1);
					contentPane.add(rdbtnNewRadioButton_2);
					contentPane.add(rdbtnNewRadioButton_3);
					
					contentPane.add(btnAddNBook);
					btnAddNBook.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent arg0) 
						{
							
							if(rdbtnNewRadioButton.isSelected())
							{
								dispose();
								new ReadBookMenu(l, member_Name);
							}
							else if(rdbtnNewRadioButton_1.isSelected())
							{
								dispose();
								new SearchBookMenu(l, member_Name);
							}
							else if(rdbtnNewRadioButton_2.isSelected())
							{
								dispose();
								new BorrowBookMenu(l, member_Name);
							}
							else if(rdbtnNewRadioButton_3.isSelected())
							{
								dispose();
								new ReturnBookMenu(l, member_Name);
							}
							
							else
							{
								JOptionPane.showMessageDialog(new JFrame(), "Please select one");   
							}
						}
					});
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Not a member"); 
					dispose();
					new MemberMenu(l, member_Name);
				}
			}
		});
		
		}
	
}

