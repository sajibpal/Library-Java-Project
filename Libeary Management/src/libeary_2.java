import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

 class libeary2 extends JFrame implements Runnable{

	private JFrame frmSajibPal;
	JProgressBar progressBar;
	Thread th;

	
	
	public libeary2() {
		initialize();
		th=new Thread((Runnable)this);
		uploding();
	}

	 void uploding(){
		  
		 
		 th.start();  
		   
	   }
		
	 public void run(){
		   
		  try{ 
			  
			for(int i=0;i<=110;i++){
			   
				
				int m=progressBar.getMaximum();
				int v=progressBar.getValue(); 
				
			   if(v<m){
				   
				 progressBar.setValue(progressBar.getValue()+1);  
				   
			   }else{
				   
				 i=111;
				libeary7 frm7=new libeary7();
				frm7.setVisible(true);	
				frm7.setBounds(100, 100, 710, 417);
				frm7.setTitle("sajib pal");
				close();
				
			   }
			Thread.sleep(50); 
		   }
			
		  }catch(Exception e){
			  
		JOptionPane.showMessageDialog(null, e);	  
			  
		  }  
	   }
	
	
	private void initialize() {
		
		Container	frmSajibPal=this.getContentPane(); 
		frmSajibPal.setBackground(new Color(255, 250, 205));
		frmSajibPal.setLayout(null);
		
		 progressBar = new JProgressBar();
		 progressBar.setForeground(new Color(65, 105, 225));
		progressBar.setBackground(new Color(248, 248, 255));
		progressBar.setStringPainted(true);
		progressBar.setBounds(184, 94, 221, 21);
		frmSajibPal.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("graphics-books-453003.gif"));
		lblNewLabel.setBounds(225, 186, 144, 93);
		frmSajibPal.add(lblNewLabel);
		
		JLabel lblLoading = new JLabel("Loading.....");
		lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoading.setBounds(233, 136, 136, 21);
		frmSajibPal.add(lblLoading);
	}
	
	 void close(){
			
		WindowEvent windowclose= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclose);
		}

 }
 public class libeary_2 {
		
		public static void main(String[] args) {
			

			try{
		
				UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");		
					
			     }
			
				catch(Exception e){
							
				 }
			libeary2 frm2=new libeary2();
			frm2.setVisible(true);	
			frm2.setBounds(200, 100, 606, 400);
			frm2.setTitle("sajib pal");
					
				}
			
		}