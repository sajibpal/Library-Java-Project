import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

 class libeary6  extends JFrame{

	private JFrame frmSajibPal;
	private JTextField btextField;
	private JTextField btextField1;
	private JTextField bntextField;
	private JTextField bntextField1;
	private JTextField etextField;
	private JTextField etextField1;
	private JTextField ptextField;
	private JTextField ptextField1;
	private JTextField atextField;
	private JTextField atextField1;
	private JTextField stextField;
	private JTextField stextField1;
	private JTextField ntextField;
	private JTextField ntextField1;
	private JTextField setextField;
	private JTextField setextField1;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	JDateChooser dateChooser,dateChooser_1;
	private JTextField dateChooser_2;
	private JTextField dateChooser_3;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public libeary6() {
		initialize();
		conn=sqlconnection. ConnecrDb();
		Table_update();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Container	frmSajibPal=this.getContentPane();
		frmSajibPal.setBackground(new Color(119, 136, 153));
		frmSajibPal.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 235, 205)));
		tabbedPane.setBounds(5, 116, 671, 332);
		frmSajibPal.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Book Borrow", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 40, 83, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 96, 75, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edition");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 147, 83, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Publish");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 198, 83, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Author ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 242, 83, 22);
		panel.add(lblNewLabel_4);
		
		btextField = new JTextField();
		btextField.setBounds(81, 43, 109, 20);
		panel.add(btextField);
		btextField.setColumns(10);
		
		bntextField = new JTextField();
		bntextField.setBounds(87, 98, 103, 20);
		panel.add(bntextField);
		bntextField.setColumns(10);
		
		etextField = new JTextField();
		etextField.setBounds(88, 150, 102, 20);
		panel.add(etextField);
		etextField.setColumns(10);
		
		ptextField = new JTextField();
		ptextField.setBounds(86, 201, 104, 20);
		panel.add(ptextField);
		ptextField.setColumns(10);
		
		atextField = new JTextField();
		atextField.setBounds(88, 244, 102, 20);
		panel.add(atextField);
		atextField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						String sql="select *from  Library_1 where book_id = ?";
						
						pst=conn.prepareStatement(sql);
						 pst.setString(1,btextField.getText());
						 rs=pst.executeQuery();
						 
						 if(rs.next()){
							 
						    String book_id =rs.getString("book_id");
						    String book_name =rs.getString("book_name");
							String author=rs.getString("author_id");
							String publish=rs.getString("publish");
							String edition=rs.getString("edition");
							
							
							rs.close();
						    pst.close();
								
							bntextField.setText(book_name);
							btextField.setText(book_id);
							atextField.setText(author);
							ptextField.setText(publish);
							etextField.setText(edition);			
								
						  }
					}
					catch(Exception e5){
						
						 
					JOptionPane.showMessageDialog(null, e5);
						
					}				
			}
		});
		btnNewButton.setIcon(new ImageIcon("purple-search-icon-256-x-256.jpg"));
		btnNewButton.setBounds(200, 36, 40, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Student ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(301, 17, 96, 37);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Student Name ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(301, 80, 96, 19);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date of issue");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(301, 183, 83, 20);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Date of Return");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(294, 228, 103, 20);
		panel.add(lblNewLabel_8);
		
		stextField = new JTextField();
		stextField.setBounds(407, 25, 109, 23);
		panel.add(stextField);
		stextField.setColumns(10);
		
		ntextField = new JTextField();
		ntextField.setBounds(405, 80, 111, 22);
		panel.add(ntextField);
		ntextField.setColumns(10);
		
		 dateChooser = new JDateChooser();
		 dateChooser.setDateFormatString(" d,MMM, yyyy");
		dateChooser.setBounds(407, 183, 120, 20);
		panel.add(dateChooser);
		
	    dateChooser_1 = new JDateChooser();
	    dateChooser_1.setDateFormatString(" d, MMM,yyyy");
		dateChooser_1.setBounds(407, 228, 120, 20);
		panel.add(dateChooser_1);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemester.setBounds(301, 133, 88, 20);
		panel.add(lblSemester);
		
		setextField = new JTextField();
		setextField.setBounds(407, 134, 103, 22);
		panel.add(setextField);
		setextField.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						String sql="select *from  Library where id = ?";
						
						pst=conn.prepareStatement(sql);
						 pst.setString(1,stextField.getText());
						 rs=pst.executeQuery();
						 
						 if(rs.next()){
							 
							String name =rs.getString("name");
							String id =rs.getString("id");
							String semester=rs.getString("semester");   
							
							rs.close();
						    pst.close();
								
							ntextField.setText(name);
							setextField.setText(semester);
							stextField.setText(id);
											
						  }
					}
					catch(Exception e5){
						
						 
					JOptionPane.showMessageDialog(null, e5);
						
					}				
			}
		});
		button.setIcon(new ImageIcon("purple-search-icon-256-x-256.jpg"));
		button.setBounds(533, 17, 40, 40);
		panel.add(button);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						
						String sql="insert into Library_2 (book_name,book_id,edition,publish,author_id,student_id,student_name,semester ,issue,return) values (?,?,?,?,?,?,?,?,?,?)";
						
						pst=conn.prepareStatement(sql);
						
						pst.setString(1, bntextField.getText());
						pst.setString(2, btextField.getText());
						pst.setString(3, etextField.getText());
						pst.setString(4, ptextField.getText());
						pst.setString(5, atextField.getText());
						pst.setString(6, stextField.getText());
						pst.setString(7, ntextField.getText());
						pst.setString(8, setextField.getText());
						pst.setString(9,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						pst.setString(10,((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText());
						
						pst.execute();
						
						
						JOptionPane.showMessageDialog(null, "Sucessfully save");
						
					}catch(Exception e2){
						
						 
					JOptionPane.showMessageDialog(null, e2);
						
					}						
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(443, 270, 75, 23);
		panel.add(btnAdd);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(321, 270, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Return Book", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Book ID");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel1.setBounds(10, 40, 83, 22);
		panel_1.add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("Book Name");
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel2.setBounds(10, 96, 75, 22);
		panel_1.add(lblNewLabel2);
		
		JLabel lblNewLabel8 = new JLabel("Edition");
		lblNewLabel8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel8.setBounds(10, 147, 83, 22);
		panel_1.add(lblNewLabel8);
		
		JLabel lblNewLabel_9 = new JLabel("Publish");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 198, 83, 22);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Author ID");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 242, 83, 22);
		panel_1.add(lblNewLabel_10);
		
		btextField1 = new JTextField();
		btextField1.setBounds(90, 43, 109, 20);
		panel_1.add(btextField1);
		btextField1.setColumns(10);
		
		bntextField1 = new JTextField();
		bntextField1.setBounds(87, 98, 103, 20);
		panel_1.add(bntextField1);
		bntextField1.setColumns(10);
		
		etextField1 = new JTextField();
		etextField1.setBounds(88, 150, 102, 20);
		panel_1.add(etextField1);
		etextField1.setColumns(10);
		
		ptextField1 = new JTextField();
		ptextField1.setBounds(86, 201, 104, 20);
		panel_1.add(ptextField1);
		ptextField1.setColumns(10);
		
		atextField1 = new JTextField();
		atextField1.setBounds(88, 244, 102, 20);
		panel_1.add(atextField1);
		atextField1.setColumns(10);
		
		JButton btnNewButton1 = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						String sql="select *from  Library_1 where book_id = ?";
						
						pst=conn.prepareStatement(sql);
						 pst.setString(1,btextField.getText());
						 rs=pst.executeQuery();
						 
						 if(rs.next()){
							 
						    String book_id =rs.getString("book_id");
						    String book_name =rs.getString("book_name");
							String author=rs.getString("author_id");
							String publish=rs.getString("publish");
							String edition=rs.getString("edition");
							
							rs.close();
						    pst.close();
								
							bntextField.setText(book_name);
							btextField.setText(book_id);
							atextField.setText(author);
							ptextField.setText(publish);
							etextField.setText(edition);			
								
						  }
					}
					catch(Exception e5){
						
						 
					JOptionPane.showMessageDialog(null, e5);
						
					}				
			}
		});
		btnNewButton.setIcon(new ImageIcon("purple-search-icon-256-x-256.jpg"));
		btnNewButton.setBounds(200, 36, 40, 40);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel("Student ID");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(301, 17, 96, 37);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Student Name ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(301, 80, 96, 19);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Date of issue");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(294, 183, 103, 20);
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Date of Return");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(294, 228, 103, 20);
		panel_1.add(lblNewLabel_15);
		
		stextField1 = new JTextField();
		stextField1.setBounds(407, 25, 109, 23);
		panel_1.add(stextField1);
		stextField1.setColumns(10);
		
		ntextField1 = new JTextField();
		ntextField1.setBounds(405, 80, 111, 22);
		panel_1.add(ntextField1);
		ntextField1.setColumns(10);
		
		JLabel lblSemester16 = new JLabel("Semester");
		lblSemester16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemester16.setBounds(301, 133, 88, 20);
		panel_1.add(lblSemester16);
		
		setextField1 = new JTextField();
		setextField1.setBounds(407, 134, 109, 22);
		panel_1.add(setextField1);
		setextField1.setColumns(10);
		
		JButton btnAdd1 = new JButton("Return");
		btnAdd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
					 try{
							
							String sql="delete from Library_2 where book_id = ? ";
							pst=conn.prepareStatement(sql);
							pst.setString(1,btextField1.getText());
										
							pst.execute();
										
								}
							catch(Exception e3){
										
										 
							JOptionPane.showMessageDialog(null, e3);
										
								}		
						
						
					JOptionPane.showMessageDialog(null, "Sucessfully Return");
						
					}catch(Exception e2){
						
						 
					JOptionPane.showMessageDialog(null, e2);
						
					}						
			}
		});
		btnAdd1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd1.setBounds(214, 270, 75, 23);
		panel_1.add(btnAdd1);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						String sql="select *from  Library_2 where book_id = ?";
						
						pst=conn.prepareStatement(sql);
						 pst.setString(1,btextField1.getText());
						 rs=pst.executeQuery();
						 
						 if(rs.next()){
							 
						    String book_id =rs.getString("book_id");
						    String book_name =rs.getString("book_name");
							String author=rs.getString("author_id");
							String publish=rs.getString("publish");
							String edition=rs.getString("edition");
							String issue=rs.getString("issue");
							String return1=rs.getString("return");
							String name =rs.getString("student_name");
							String id =rs.getString("student_id");
							String semester=rs.getString("semester"); 

							rs.close();
						    pst.close();
								
							bntextField1.setText(book_name);
							btextField1.setText(book_id);
							atextField1.setText(author);
							ptextField1.setText(publish);
							etextField1.setText(edition);
							ntextField1.setText(name);
							setextField1.setText(semester);
							stextField1.setText(id);
							dateChooser_2.setText(issue);
							dateChooser_3.setText(return1);
								
						  }
					}
					catch(Exception e5){
						
						 
					JOptionPane.showMessageDialog(null, e5);
						
					}						
			}
		});
		button_1.setIcon(new ImageIcon("purple-search-icon-256-x-256.jpg"));
		button_1.setBounds(209, 40, 40, 40);
		panel_1.add(button_1);
		
		dateChooser_2 = new JTextField();
		dateChooser_2.setBounds(411, 183, 105, 22);
		panel_1.add(dateChooser_2);
		dateChooser_2.setColumns(10);
		
		dateChooser_3 = new JTextField();
		dateChooser_3.setBounds(413, 230, 109, 20);
		panel_1.add(dateChooser_3);
		dateChooser_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Book Borrow List", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 646, 189);
		panel_2.add(scrollPane);
		
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
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID :");
		lblEnterStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterStudentId.setBounds(53, 29, 123, 25);
		panel_2.add(lblEnterStudentId);
		
		textField = new JTextField();
		textField.setBounds(186, 31, 133, 25);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Table_update_1();	
			}
		});
		button_2.setIcon(new ImageIcon("purple-search-icon-256-x-256.jpg"));
		button_2.setBounds(329, 16, 43, 47);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Table_update();	
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_3.setIcon(new ImageIcon("iges.jpg"));
		button_3.setBounds(381, 16, 52, 52);
		panel_2.add(button_3);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("Untitle55d-1.jpg"));
		lblNewLabel_11.setBounds(118, 0, 485, 112);
		frmSajibPal.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary7 frm7=new libeary7();
				frm7.setVisible(true);	
				frm7.setBounds(100, 100, 710, 417);
				frm7.setTitle("sajib pal");
				close();	
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("01_arrow_left-32.png"));
		btnNewButton_2.setBounds(0, 0, 41, 33);
		frmSajibPal.add(btnNewButton_2);
		
	}
	void close(){
		
	    WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
			
	   }	
	
	void Table_update_1(){ 
	   	
		 try{
			 
			 String name=textField.getText();
					 
			 String sql="select  *from  Library_2 where student_id = ? ";	
			 
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, name);
			 rs=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			
} catch(Exception e){
	 
	    JOptionPane.showMessageDialog(null, e);
    }
		 
}
	void Table_update(){ 
	   	
		 try{
			 
			 String sql="select  * from  Library_2 ";	
			 
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
 
 public class libeary_6 {
		
		public static void main(String[] args) {
			

			try{
		
			  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
					
			     }
			
				catch(Exception e){
							
				 }
			libeary6 frm6=new libeary6();
			frm6.setVisible(true);	
			frm6.setBounds(200, 100, 692, 487);
			frm6.setTitle("sajib pal");
					
			}
			
	}
