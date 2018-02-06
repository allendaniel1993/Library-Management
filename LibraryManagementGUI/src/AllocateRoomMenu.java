import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
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

public class AllocateRoomMenu extends JFrame {

	private JPanel contentPane;

	
	public AllocateRoomMenu(Library l,String librarian_Name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Welcome " + librarian_Name +" !!");
		
		JLabel lblNewLabel_0 = new JLabel("Enter Room Number :");
		
		JTextField textField_0 = new JTextField();
		
		textField_0.setColumns(10);
		JButton btnAddNBook = new JButton("Alloacte Room");
		btnAddNBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int RoomNo=0;
				try 
				{
					RoomNo= Integer.parseInt(textField_0.getText());
					allocate_Room(l,librarian_Name,RoomNo);
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter a vaild room in number");   
				}
				
			}});
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_0);
		contentPane.add(textField_0);
		contentPane.add(btnAddNBook);

		setVisible(true);
			}
	public void allocate_Room(Library l,String librarian_Name,int RoomNo)
	{
		List<Room> r= l.getRoomlist();
		int flag1=0,flag2=0;
		for(Room x : r)
		{	
			if (x.getRoom_Number()==RoomNo)
			{
				flag2=1;
				if(x.get_Allocated()==false)
				{
					x.set_Allocated(true);
					flag1=1;
				}
				
			}
			
		}
		if(flag1==1)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Room allocated sucessfully");
			dispose();
			new LibrarianMenu(l,librarian_Name);
		}
		else if (flag2==1)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Room is not free");
			dispose();
			new LibrarianMenu(l,librarian_Name);
		}
		else if(flag2==0)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Room not found");
			dispose();
			new LibrarianMenu(l,librarian_Name);
		}
	}

}
