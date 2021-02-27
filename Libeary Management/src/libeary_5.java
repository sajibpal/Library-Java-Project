import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
 
class libeary5 extends JFrame{

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	/**
	 * Launch the application.
	 */
	
	public libeary5() {
		initialize();
		conn=sqlconnection. ConnecrDb();
		Table_update();
		Table_update_1();
		
	}

	
	private void initialize() {
		
		Container	frame=this.getContentPane(); 
		frame.setBackground(new Color(119, 136, 153));
		frame.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 683, 209);
		frame.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(189, 183, 107)));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(5, 105, 695, 301);
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Book Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(91, 11, 122, 23);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(223, 13, 149, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(null);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 Table_update();
			 
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(408, 12, 84, 23);
		panel.add(btnSearch);
		
		JButton btnRefreshTable = new JButton("Refresh table");
		btnRefreshTable.setIcon(new ImageIcon("if_view-refresh_118801.png"));
		btnRefreshTable.setHorizontalAlignment(SwingConstants.LEFT);
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Table_update_1();
			}
		});
		btnRefreshTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRefreshTable.setBounds(250, 47, 122, 23);
		panel.add(btnRefreshTable);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Untitled-3.jpg"));
		lblNewLabel_1.setBounds(123, 17, 460, 77);
		frame.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary7 frm7=new libeary7();
				frm7.setVisible(true);	
				frm7.setBounds(100, 100, 710, 417);
				frm7.setTitle("sajib pal");
				close();	
			}
		});
		btnNewButton.setIcon(new ImageIcon("01_arrow_left-32.png"));
		btnNewButton.setBounds(0, 0, 41, 33);
		frame.add(btnNewButton);
	}
   
	 void close(){
			
		    WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
				}
	void Table_update(){ 
	   	
		 try{
			 
			 String name=textField.getText();
			 String sql="select  *from  Library_1 where book_name = ? ";	
			 
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, name);
			 rs=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			
 } catch(Exception e){
	 
	    JOptionPane.showMessageDialog(null, e);
     }
	
 }
	void Table_update_1(){ 
	   	
		 try{
			 
			 String sql="select book_name,book_id,edition,publish,date,author_id,shelf_info,shelf_num,availability from  Library_1 ";	
			 
			 pst=conn.prepareStatement(sql);
			 rs=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			
  } catch(Exception e){
	 
	    JOptionPane.showMessageDialog(null, e);
   }
		 
	 finally{
			  
		 try{
				 
		 rs.close();
		 pst.close();
		}catch (Exception e){
				 
		  JOptionPane.showMessageDialog(null,e);
		
		  }			
					
		} 	 
	}
}

public class libeary_5 {
	
	public static void main(String[] args) {
		

		try{
	
		  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
				
		     }
		
			catch(Exception e){
						
			 }
		libeary5 frm5=new libeary5();
		frm5.setVisible(true);	
		frm5.setBounds(200, 100, 719, 443);
		frm5.setTitle("sajib pal");
				
			}
		
	}
