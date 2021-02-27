

import java.sql.*;
import javax.swing.*;

public class sqlconnection {

  Connection conn=null;
  public static  Connection ConnecrDb(){
	
	  try{
		  
		Class.forName("org.sqlite.JDBC");
		Connection conn=DriverManager.getConnection("jdbc:Sqlite:F:\\sajib\\java program\\databaseproject\\Empoyeed.sqlite");
		//JOptionPane.showMessageDialog(null, "conected");
		
		return conn;
		
		
	  }
	  catch(Exception e){
		  
		  JOptionPane.showMessageDialog(null, e);
		return null;  
	  }
	  
  }
}
