import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

 class libeary7 extends JFrame {

	private JFrame frmSajibPal;

	/**
	 * Launch the application.
	 */
	
	public libeary7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Container	frmSajibPal=this.getContentPane();
		frmSajibPal.setBackground(new Color(119, 136, 153));
		frmSajibPal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(169, 169, 169)));
		panel.setBounds(10, 141, 674, 186);
		frmSajibPal.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary3 frm3=new libeary3();
				frm3.setVisible(true);	
				frm3.setBounds(100, 100, 700, 459);
				frm3.setTitle("sajib pal");
				close();
			}
		});
		btnNewButton.setIcon(new ImageIcon("if_Student-3_379413.png"));
		btnNewButton.setBounds(10, 11, 115, 137);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary4 frm4=new libeary4();
				frm4.setVisible(true);	
				frm4.setBounds(100, 100, 708, 480);
				frm4.setTitle("sajib pal");
				close();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("Flatt3d-Books-128.png"));
		btnNewButton_1.setBounds(135, 11, 123, 137);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary5 frm5=new libeary5();
				frm5.setVisible(true);	
				frm5.setBounds(100, 100, 719, 443);
				frm5.setTitle("sajib pal");
				close();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("18-128.png"));
		btnNewButton_2.setBounds(271, 11, 122, 137);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary6 frm6=new libeary6();
				frm6.setVisible(true);	
				frm6.setBounds(100, 100, 692, 487);
				frm6.setTitle("sajib pal");
				close();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("books_2-128.png"));
		btnNewButton_3.setBounds(403, 11, 123, 137);
		panel.add(btnNewButton_3);
		
		JLabel lblStudentInfo = new JLabel("Student Info");
		lblStudentInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentInfo.setBounds(20, 148, 98, 27);
		panel.add(lblStudentInfo);
		
		JLabel lblBookInfo = new JLabel("Books Info");
		lblBookInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookInfo.setBounds(145, 148, 104, 27);
		panel.add(lblBookInfo);
		
		JLabel lblBookSearch = new JLabel("Books Search");
		lblBookSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBookSearch.setBounds(281, 148, 98, 27);
		panel.add(lblBookSearch);
		
		JLabel lblBorrowBooks = new JLabel("Borrow Books");
		lblBorrowBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBorrowBooks.setBounds(413, 148, 98, 27);
		panel.add(lblBorrowBooks);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 close();	
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("close_off-128.png"));
		btnNewButton_4.setBounds(531, 11, 129, 137);
		panel.add(btnNewButton_4);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogout.setBounds(564, 152, 84, 19);
		panel.add(lblLogout);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setForeground(new Color(240, 255, 255));
		lblLibraryManagementSystem.setFont(new Font("Tw Cen MT", Font.PLAIN, 26));
		lblLibraryManagementSystem.setBounds(175, 338, 315, 30);
		frmSajibPal.add(lblLibraryManagementSystem);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("1-128.png"));
		lblNewLabel.setBounds(239, 0, 172, 93);
		frmSajibPal.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Library Admin Panel");
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(210, 104, 240, 26);
		frmSajibPal.add(lblNewLabel_1);
	}
	
  void close(){
		
	    WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
			
	   }		
}
 public class libeary_7 {
		
		public static void main(String[] args) {
			

			try{
		
			  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
					
			     }
			
				catch(Exception e){
							
				 }
			libeary7 frm7=new libeary7();
			frm7.setVisible(true);	
			frm7.setBounds(200, 100, 710, 417);
			frm7.setTitle("sajib pal");
					
			}
			
	}
