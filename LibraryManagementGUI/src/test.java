import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridLayout gl_contentPane = new GridLayout(0,1);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		
		contentPane.setLayout(gl_contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel);
		
		textField = new JTextField();
	
		contentPane.add(textField, gbc_lblNewLabel);
		textField.setColumns(10);
		
		
		lblNewLabel_2 = new JLabel("New label");

		contentPane.add(lblNewLabel_2, gbc_lblNewLabel);
		
		textField_1 = new JTextField();

		contentPane.add(textField_1, gbc_lblNewLabel);
		textField_1.setColumns(10);
	}
}
