import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

 class libeary3 extends JFrame {

	private JFrame frmSajibPal;
	private JTextField utextField;
	private JTextField stextField;
	private JPasswordField ptextField;
	private JTextField sttextField,idtextField,stutextField,usetextField;
	private JTable table;
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	JDateChooser dateChooser;
	TextArea textArea_2;
	private JTextField setextField;
	private JTextField patextField;

	
	public libeary3() {
		initialize();
		conn=sqlconnection. ConnecrDb();
		Table_update();
	
	}

	
	private void initialize() {
		
		Container	frmSajibPal=this.getContentPane(); 
		frmSajibPal.setBackground(new Color(119, 136, 153));
		frmSajibPal.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBounds(10, 103, 668, 307);
		frmSajibPal.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Student information", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("User name ");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName.setBounds(26, 58, 71, 16);
		panel.add(lblUserName);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(26, 103, 60, 16);
		panel.add(lblStudentId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(26, 147, 55, 16);
		panel.add(lblPassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight"}));
		comboBox.setEditable(true);
		comboBox.setBounds(126, 194, 127, 22);
		panel.add(comboBox);
		
		JLabel lblSemister = new JLabel("Semester");
		lblSemister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemister.setBounds(26, 197, 71, 16);
		panel.add(lblSemister);
		
		utextField = new JTextField();
		utextField.setBounds(126, 57, 127, 20);
		panel.add(utextField);
		utextField.setColumns(10);
		
		stextField = new JTextField();
		stextField.setBounds(126, 102, 127, 20);
		panel.add(stextField);
		stextField.setColumns(10);
		
		ptextField = new JPasswordField();
		ptextField.setBounds(126, 146, 127, 20);
		panel.add(ptextField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(287, 58, 46, 16);
		panel.add(lblAddress);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(367, 31, 204, 106);
		panel.add(textArea);
		
		JButton add = new JButton("Add information");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try{
						
						
						String sql="insert into Library (id,password,address,name,date,semester) values (?,?,?,?,?,?)";
						
						pst=conn.prepareStatement(sql);
						
						pst.setString(1, stextField.getText());
						pst.setString(2, ptextField.getText());
						pst.setString(3, textArea.getText());
						pst.setString(4, utextField.getText());
						pst.setString(5,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						pst.setString(6, (String)comboBox.getSelectedItem());
						
			
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Sucessfully save");
						
					}catch(Exception e2){
						
						 
					JOptionPane.showMessageDialog(null, e2);
						
					}		
			}
		});
		add.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add.setBounds(367, 226, 127, 25);
		panel.add(add);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				libeary1 frm=new libeary1();
				frm.setVisible(true);	
				frm.setBounds(250, 100, 604, 413);
				frm.setTitle("sajib pal");
				close();
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 13));
		back.setBounds(520, 226, 70, 25);
		panel.add(back);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("View Details", null, panel_1, null);
		panel_1.setLayout(null);
		
		sttextField = new JTextField();
		sttextField.setBounds(184, 16, 173, 20);
		panel_1.add(sttextField);
		sttextField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Table_update_1();
			  }
			});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(292, 47, 81, 23);
		panel_1.add(btnSearch);
		
		JButton btnRefracTabel = new JButton("Refresh tabel");
		btnRefracTabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Table_update();
			}
		});
		btnRefracTabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRefracTabel.setBounds(172, 47, 110, 23);
		panel_1.add(btnRefracTabel);
		
		JLabel lblNewLabel = new JLabel("Enter Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 16, 118, 17);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 639, 183);
		panel_1.add(scrollPane);
		
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
				"name", "student id", "semester", "Address"
			}
		));
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update Details", null, panel_2, null);
		panel_2.setLayout(null);
		
		idtextField = new JTextField();
		idtextField.setBounds(198, 13, 173, 25);
		panel_2.add(idtextField);
		idtextField.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
						
						String sql="select *from  Library where id = ?";
						
						pst=conn.prepareStatement(sql);
						 pst.setString(1,idtextField.getText());
						 rs=pst.executeQuery();
						 
						 if(rs.next()){
							 
						    String address =rs.getString("address");
						    String password =rs.getString("password");
							String name=rs.getString("name");
							String semester=rs.getString("semester");
							String id=rs.getString("id");
							
							rs.close();
						    pst.close();
								
							usetextField.setText(name);
							textArea_2.setText(address);
							patextField.setText(password);
							setextField.setText(semester);
							stutextField.setText(id);
									
								
						  }
					}
					catch(Exception e5){
						
						 
					JOptionPane.showMessageDialog(null, e5);
						
					}		
			}
		});
		btnSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch_1.setBounds(381, 12, 73, 25);
		panel_2.add(btnSearch_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(70, 11, 118, 25);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblUserName_2 = new JLabel("User name ");
		lblUserName_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName_2.setBounds(26, 58, 71, 16);
		panel_2.add(lblUserName_2);
		
		JLabel lblStudentId_2 = new JLabel("Student ID");
		lblStudentId_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId_2.setBounds(26, 103, 60, 16);
		panel_2.add(lblStudentId_2);
		
		JLabel lblPassword_2 = new JLabel("Password");
		lblPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword_2.setBounds(26, 147, 55, 16);
		panel_2.add(lblPassword_2);
		
		JLabel lblSemister_2 = new JLabel("Semester");
		lblSemister_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemister_2.setBounds(26, 197, 71, 16);
		panel_2.add(lblSemister_2);
		
		usetextField = new JTextField();
		usetextField.setBounds(126, 57, 127, 20);
		panel_2.add(usetextField);
		usetextField.setColumns(10);
		
		stutextField = new JTextField();
		stutextField.setBounds(126, 102, 127, 20);
		panel_2.add(stutextField);
		stutextField.setColumns(10);
		
		JLabel lblAddress_3 = new JLabel("Address");
		lblAddress_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress_3.setBounds(287, 58, 46, 16);
		panel_2.add(lblAddress_3);
		
		TextArea textArea_1 = new TextArea();
		textArea.setBounds(367, 31, 204, 106);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(287, 172, 46, 22);
		panel.add(lblDate);
		
	    dateChooser = new JDateChooser();
		dateChooser.setDateFormatString(" d, MMM,yyyy");
		dateChooser.setBounds(368, 170, 127, 22);
		panel.add(dateChooser);
		
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{		
					
				  String name=usetextField.getText();
				  String address=textArea_2.getText();
				  String password=patextField.getText();
				  String semester=setextField.getText();
				  String id=stutextField.getText();
						
					String sql="update Library set name='"+name+"',address='"+address+"',password='"+password+"',semester='"+semester+"' where id='"+id+"' ";
					pst=conn.prepareStatement(sql);
					 pst.execute();
						
					JOptionPane.showMessageDialog(null,"update");
						
				    }catch(Exception e4){
						
						 
					JOptionPane.showMessageDialog(null, e4);
						
					 }	
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(368, 193, 84, 25);
		panel_2.add(btnNewButton_1);
		
		 textArea_2 = new TextArea();
		textArea_2.setBounds(344, 57, 235, 107);
		panel_2.add(textArea_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
			int p=JOptionPane.showConfirmDialog(null,"Do you want Delete","Delete",JOptionPane.YES_NO_OPTION);
			  if(p==0){
				try{
								
					String sql="delete from Library where id = ? ";
					pst=conn.prepareStatement(sql);
					pst.setString(1,stutextField.getText());
								
					pst.execute();
								
					  JOptionPane.showMessageDialog(null,"Delete");	
						}
					catch(Exception e3){
								
								 
					JOptionPane.showMessageDialog(null, e3);
								
						}
				
					}
			   }
		  });
				
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBounds(485, 194, 89, 23);
		panel_2.add(btnDelete);
		
		setextField = new JTextField();
		setextField.setBounds(126, 191, 127, 25);
		panel_2.add(setextField);
		setextField.setColumns(10);
		
		patextField = new JTextField();
		patextField.setBounds(127, 146, 126, 25);
		panel_2.add(patextField);
		patextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Untit-1.jpg"));
		lblNewLabel_2.setBounds(93, 11, 538, 87);
		frmSajibPal.add(lblNewLabel_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
				
			   libeary7 frm7=new libeary7();
				frm7.setVisible(true);	
				frm7.setBounds(100, 100, 710, 417);
				frm7.setTitle("sajib pal");
				close();
			}
		});
		button.setIcon(new ImageIcon("01_arrow_left-32.png"));
		button.setBounds(0, 0, 41, 33);
		frmSajibPal.add(button);
		
	}
	
	 void close(){
			
		WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
		}
	 
	void Table_update_1(){ 
	   	
		 try{
			 
			 String id=sttextField.getText();
			 String sql="select  *from  Library where id = ? ";	
			 
			 pst=conn.prepareStatement(sql);
			 pst.setString(1, id);
			 rs=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
			
  } catch(Exception e){
	 
	    JOptionPane.showMessageDialog(null, e);
      }
	
  }		 
	void Table_update(){ 
	   	
		 try{
			 
			 String sql="select  name,id,address,date,semester from  Library ";	
			 
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
 
 public class libeary_3 {
		
		public static void main(String[] args) {
			

			try{
		
			  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
					
			     }
			
				catch(Exception e){
							
				 }
			libeary3 frm3=new libeary3();
			frm3.setVisible(true);	
			frm3.setBounds(200, 100, 700, 459);
			frm3.setTitle("sajib pal");
					
				}
			
		}
