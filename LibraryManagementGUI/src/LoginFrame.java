import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library l=new Library("ABC Library");
					LoginFrame frame = new LoginFrame(l);
					frame.setTitle("Library Management");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame(Library l) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{129, 153, 0};
		gbl_contentPane.rowHeights = new int[]{15, 38, 16, 25, 25, 0, 25, 25, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLibraryManagement = new JLabel("Library Management");
		lblLibraryManagement.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 13));
		GridBagConstraints gbc_lblLibraryManagement = new GridBagConstraints();
		gbc_lblLibraryManagement.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLibraryManagement.insets = new Insets(0, 0, 5, 0);
		gbc_lblLibraryManagement.gridx = 1;
		gbc_lblLibraryManagement.gridy = 0;
		contentPane.add(lblLibraryManagement, gbc_lblLibraryManagement);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		GridBagConstraints gbc_lblEnterName = new GridBagConstraints();
		gbc_lblEnterName.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnterName.gridx = 1;
		gbc_lblEnterName.gridy = 1;
		contentPane.add(lblEnterName, gbc_lblEnterName);
		
		ButtonGroup group = new ButtonGroup();
		
		JButton btnEnter = new JButton("Enter");
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select Your Role:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Librarian");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 4;
		contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Member");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 5;
		contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Visitor");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_2.gridx = 1;
		gbc_rdbtnNewRadioButton_2.gridy = 6;
		contentPane.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_2);
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.anchor = GridBagConstraints.NORTH;
		gbc_btnEnter.gridx = 1;
		gbc_btnEnter.gridy = 7;
		contentPane.add(btnEnter, gbc_btnEnter);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected())
				{
					name=textField.getText();
					if(name.isEmpty())
					{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Librarian Name"); 
					}
					else
					{	
					dispose();
					new LibrarianMenu(l,name);
					}
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					name=textField.getText();
					if(name.isEmpty())
					{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Member Name"); 
					}
					else
					{	
					dispose();
					new MemberMenu(l,name);
					}
				}
				else if(rdbtnNewRadioButton_2.isSelected())
				{
					name=textField.getText();
					if(name.isEmpty())
					{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid Name"); 
					}
					else
					{	
					dispose();
					new VisitorMenu(l,name);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please select one");   
				}
			}
		});
		
		
	}
}
