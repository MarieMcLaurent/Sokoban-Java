package code;
import java.sql.*;
import com.mysql.jdbc.Driver.*;

public class Requete {

	public Requete() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/informations","root","javaavance");
		//here sonoo is database name, root is username and password.
		Statement stmt=con.createStatement();
		/*stmt.executeUpdate(sql);*/
		stmt.close();	
		}
		 catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }		
		 catch (SQLException e) {
	            e.printStackTrace();
	        }

	}
}
