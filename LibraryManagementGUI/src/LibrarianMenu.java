import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RadialGradientPaint;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class LibrarianMenu extends JFrame {

	
	private JPanel contentPane;

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;
	private JRadioButton rdbtnNewRadioButton_5;
	private JRadioButton rdbtnNewRadioButton_6;
	private JRadioButton rdbtnNewRadioButton_7;
	private JRadioButton rdbtnNewRadioButton_8;
	private JButton btnNext;


	/**
	 * Create the frame.
	 */
	public LibrarianMenu(Library l,String Name) {
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
		

		
		rdbtnNewRadioButton = new JRadioButton("Add Book");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 3;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Remove Book");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 4;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Calculate Fine");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 4;
		gbc_rdbtnNewRadioButton_2.gridy = 5;
		contentPane.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Add Member");
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 4;
		gbc_rdbtnNewRadioButton_3.gridy = 6;
		contentPane.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Remove member");
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 4;
		gbc_rdbtnNewRadioButton_4.gridy = 7;
		contentPane.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		rdbtnNewRadioButton_5 = new JRadioButton("Allocate room");
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 4;
		gbc_rdbtnNewRadioButton_5.gridy = 8;
		contentPane.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		
		rdbtnNewRadioButton_6 = new JRadioButton("Deallocate Room");
		GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_6.gridx = 4;
		gbc_rdbtnNewRadioButton_6.gridy = 9;
		contentPane.add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
		
		rdbtnNewRadioButton_7 = new JRadioButton("Details of Books");
		GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_7.gridx = 4;
		gbc_rdbtnNewRadioButton_7.gridy = 10;
		contentPane.add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
		
		rdbtnNewRadioButton_8 = new JRadioButton("Details of Members");
		GridBagConstraints gbc_rdbtnNewRadioButton_8 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_8.gridx = 4;
		gbc_rdbtnNewRadioButton_8.gridy = 11;
		contentPane.add(rdbtnNewRadioButton_8, gbc_rdbtnNewRadioButton_8);
		
		btnNext = new JButton("Next");
		
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 12;
		contentPane.add(btnNext, gbc_btnNext);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_4);
		group.add(rdbtnNewRadioButton_5);
		group.add(rdbtnNewRadioButton_6);
		group.add(rdbtnNewRadioButton_7);
		group.add(rdbtnNewRadioButton_8);
		
		setVisible(true);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnNewRadioButton.isSelected())
				{
					dispose();
					new AddBookMenu(l,Name);
				}
				

				else if(rdbtnNewRadioButton_1.isSelected())
				{
					dispose();
					new RemoveBookMenu(l,Name);
				}
				
				else if(rdbtnNewRadioButton_2.isSelected())
				{
					dispose();
					new CalculateFineMenu(l,Name);
				}
				
				else if(rdbtnNewRadioButton_3.isSelected())
				{
					dispose();
					new AddMemberMenu(l,Name);
				}
				else if(rdbtnNewRadioButton_4.isSelected())
				{
					dispose();
					new RemoveMemberMenu(l,Name);
				}
				else if(rdbtnNewRadioButton_5.isSelected())
				{
					dispose();
					new AllocateRoomMenu(l,Name);
				}
				else if(rdbtnNewRadioButton_6.isSelected())
				{
					dispose();
					new DeallocateRoomMenu(l,Name);
				}
				else if(rdbtnNewRadioButton_7.isSelected())
				{
					dispose();
					new PrintBookDetailsMenu(l,Name);
				}
				else if(rdbtnNewRadioButton_8.isSelected())
				{
					dispose();
					new PrintMemberDetailsMenu(l,Name);
				}
				
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select a choice"); 
				}
				
			}
		});
		
		}
}

