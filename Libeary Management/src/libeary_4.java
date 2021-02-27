import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

 class libeary4 extends JFrame {

	private JFrame frmSajibPal;
	private JTable table;
	private JTextField btextField;
	private JTextField bitextField;
	private JTextField etextField;
	private JTextField ptextField;
	private JTextField atextField;
	private JTextField sitextField;
	private JTextField avtextField;
	private JTextField sntextField;
	private JTable table_1;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	JDateChooser dateChooser ;

	
	public libeary4() {
		initialize();
		conn=sqlconnection. ConnecrDb();
		Table_update();
		Table_update_1();
	}

	
	private void initialize() {
		
		Container	frmSajibPal=this.getContentPane(); 
		frmSajibPal.setBackground(new Color(119, 136, 153));
		frmSajibPal.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(211, 211, 211)));
		tabbedPane.setBounds(10, 119, 672, 312);
		frmSajibPal.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Books", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 653, 241);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Book name", "book_id", "edition", "publish", "shelf_num"
			}
		));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add new book", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 37, 76, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(27, 88, 64, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edition");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(27, 141, 64, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Publish");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(27, 186, 64, 20);
		panel_1.add(lblNewLabel_3);
		
		btextField = new JTextField();
		btextField.setBounds(137, 37, 131, 22);
		panel_1.add(btextField);
		btextField.setColumns(10);
		
		bitextField = new JTextField();
		bitextField.setBounds(137, 89, 119, 22);
		panel_1.add(bitextField);
		bitextField.setColumns(10);
		
		etextField = new JTextField();
		etextField.setBounds(137, 142, 119, 22);
		panel_1.add(etextField);
		etextField.setColumns(10);
		
		ptextField = new JTextField();
		ptextField.setBounds(137, 187, 119, 22);
		panel_1.add(ptextField);
		ptextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Author ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(27, 238, 76, 19);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Shelf info");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(335, 89, 64, 20);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Availability");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(335, 199, 76, 22);
		panel_1.add(lblNewLabel_6);
		
		atextField = new JTextField();
		atextField.setBounds(137, 235, 131, 22);
		panel_1.add(atextField);
		atextField.setColumns(10);
		
		sitextField = new JTextField();
		sitextField.setBounds(421, 91, 131, 25);
		panel_1.add(sitextField);
		sitextField.setColumns(10);
		
		avtextField = new JTextField();
		avtextField.setBounds(421, 200, 138, 25);
		panel_1.add(avtextField);
		avtextField.setColumns(10);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						
						String sql="insert into Library_1 (book_name,book_id,edition,publish,date,author_id,shelf_info,shelf_num,availability) values (?,?,?,?,?,?,?,?,?)";
						
						pst=conn.prepareStatement(sql);
						
						pst.setString(1, btextField.getText());
						pst.setString(2, bitextField.getText());
						pst.setString(3, etextField.getText());
						pst.setString(4, ptextField.getText());
						pst.setString(5,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						pst.setString(6, atextField.getText());
						pst.setString(7, sitextField.getText());
						pst.setString(8, sntextField.getText());
						pst.setString(9, avtextField.getText());
						
						pst.execute();
						Table_update();
						Table_update_1();
						
						JOptionPane.showMessageDialog(null, "Sucessfully save");
						
					}catch(Exception e2){
						
						 
					JOptionPane.showMessageDialog(null, e2);
						
					}				
				
			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddBook.setBounds(310, 246, 89, 23);
		panel_1.add(btnAddBook);
		
		JLabel lblShelfNo = new JLabel("Shelf no");
		lblShelfNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShelfNo.setBounds(338, 145, 73, 20);
		panel_1.add(lblShelfNo);
		
		sntextField = new JTextField();
		sntextField.setBounds(421, 145, 131, 25);
		panel_1.add(sntextField);
		sntextField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(335, 40, 46, 17);
		panel_1.add(lblDate);
		
		 dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d, MMM,yyyy");
		dateChooser.setBounds(419, 37, 133, 25);
		panel_1.add(dateChooser);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Books shelf info", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 643, 199);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"book name","Shelf no", "Shelf info"
			}
		));
		
		JLabel lblNewLabel_7 = new JLabel("\r\n");
		lblNewLabel_7.setIcon(new ImageIcon("Untitled-2.jpg"));
		lblNewLabel_7.setBounds(126, 0, 507, 120);
		frmSajibPal.add(lblNewLabel_7);
		
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon("01_arrow_left-32.png"));
		btnNewButton.setBounds(0, 0, 41, 33);
		frmSajibPal.add(btnNewButton);
			
	 }
	
	 void close(){
			
	    WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
			}
	 
	void Table_update_1(){ 
	   	
		 try{
			 
			 String sql="select  book_name,book_id,shelf_info,shelf_num from  Library_1 ";	
			 
			 pst=conn.prepareStatement(sql);
			 rs=pst.executeQuery();
			 table_1.setModel(DbUtils.resultSetToTableModel(rs));
			 
			
 } catch(Exception e){
	 
	    JOptionPane.showMessageDialog(null, e);
     }
		 
 }
	void Table_update(){ 
	   	
		 try{
			 
			 String sql="select  book_name,book_id,edition,publish,date,shelf_num,shelf_info,availability from  Library_1 ";	
			 
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

 public class libeary_4 {
		
		public static void main(String[] args) {
			

			try{
		
			  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
					
			     }
			
				catch(Exception e){
							
				 }
			libeary4 frm4=new libeary4();
			frm4.setVisible(true);	
			frm4.setBounds(200, 100, 708, 480);
			frm4.setTitle("sajib pal");
					
				}
			
		}
