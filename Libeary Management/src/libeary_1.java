import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

 class libeary1 extends JFrame {

	private JFrame frmSajibPal;
	private JTextField textField;
	private JPasswordField ptextField;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public libeary1() {
		initialize();
		conn=sqlconnection. ConnecrDb();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		 Container	frmSajibPal=this.getContentPane();
		 frmSajibPal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, new Color(240, 255, 255), new Color(245, 245, 245)));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(0, 0, 588, 375);
		frmSajibPal.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Untitled-1.jpg"));
		lblNewLabel.setBounds(166, 21, 192, 114);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(121, 165, 335, 199);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name ");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(10, 28, 75, 14);
		panel_1.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 89, 88, 23);
		panel_1.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(108, 26, 160, 23);
		panel_1.add(textField);
		textField.setColumns(10);
		
		ptextField = new JPasswordField();
		ptextField.setBounds(108, 91, 160, 23);
		panel_1.add(ptextField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
              try{
					
					String sql="select *from  Library where password= ? or  name= ?";
							
					pst=conn.prepareStatement(sql);
			 	    pst.setString(1,ptextField.getText()); 
			 	   pst.setString(2,textField.getText()); 
					rs=pst.executeQuery();
					
					String tpass =ptextField.getText();
					String tname = textField.getText();
					 
					 if(rs.next()){
							 
						 
					String databasepass =rs.getString("password");
					String	databasename =rs.getString("name");	
						rs.close();
						pst.close();
							
					    if(tpass.equals(databasepass) && tname.equals(databasename)){
								 
						   JOptionPane.showMessageDialog(null, "Login sucessfully");
						   
						    close();
						    
						    libeary2 frm2=new libeary2();
							frm2.setVisible(true);	
							frm2.setBounds(100, 100, 606, 400);
							frm2.setTitle("sajib pal");
						   	    
						     }	
					    else{
							 
							JOptionPane.showMessageDialog(null, "User name or password wrong"); 
							
						      }		
						 }	
						 	 
				 } catch(Exception e3){
					 
	                JOptionPane.showMessageDialog(null, e3);
	
	               }
			}
		});		
			
		
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(80, 165, 95, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary3 frm3=new libeary3();
				frm3.setVisible(true);	
				frm3.setBounds(100, 100, 700, 459);
				frm3.setTitle("sajib pal");
			}
		});	
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(204, 165, 107, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Library Management System Login ");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(167, 128, 238, 26);
		panel.add(lblNewLabel_1);
	}
	
	 void close(){
			
			WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
		}	
}

public class libeary_1 {
	
	public static void main(String[] args) {
		

		try{
	
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
				
		     }
		
			catch(Exception e){
						
			 }
		libeary1 frm=new libeary1();
		frm.setVisible(true);	
		frm.setBounds(200, 100, 604, 413);
		frm.setTitle("sajib pal");
				
			}
		
	}
