import java.sql.Connection;
import java.sql.DriverManager;
public class DBInfo
{
 static Connection con;
 public static Connection getCon()
 {
	 try
	 {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery", "root", "abc");
	 }
	 catch(Exception e)
	 {
	  e.printStackTrace();	 
	 }
	 return con;
 }
 public static void close()
 {
	 try
	 {
	  con.close();
	 }
	 catch(Exception e)
	 {
		 
	 }
 }
} 
