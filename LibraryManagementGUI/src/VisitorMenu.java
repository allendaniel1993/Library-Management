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
import javax.swing.border.EmptyBorder;

public class VisitorMenu extends JFrame {

	private JPanel contentPane;

	public VisitorMenu(Library l,String member_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
					contentPane.setLayout(new GridLayout(0,1));
					JLabel lblNewLabel_3 = new JLabel("Select One :");
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Read Book");
					JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Search Book");
					ButtonGroup group = new ButtonGroup();
					group.add(rdbtnNewRadioButton);
					group.add(rdbtnNewRadioButton_1);
					
					JButton btnAddNBook = new JButton("Next");
					
					contentPane.add(lblNewLabel_3);
					contentPane.add(rdbtnNewRadioButton);
					contentPane.add(rdbtnNewRadioButton_1);
					
					contentPane.add(btnAddNBook);
					setVisible(true);
					btnAddNBook.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent arg0) 
						{
							
							if(rdbtnNewRadioButton.isSelected())
							{
								dispose();
								new ReadBookMenuVisitor(l, member_Name);
							}
							else if(rdbtnNewRadioButton_1.isSelected())
							{
								dispose();
								new SearchBookVisitor(l, member_Name);
							}
							
							else
							{
								JOptionPane.showMessageDialog(new JFrame(), "Please select one");   
							}
						}
					});
				}
	
}

