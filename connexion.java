package project_test;
import java.sql.*;

public class connexion {

	public static void main(String[] args) {
		try {
			  /* 1. Charger le driver mysql*/
			  
			Class.forName("com.mysql.jdbc.Driver");
			  
			  /* 2. Créer la connexion */
			  
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_test?autoReconnect=true&useSSL=false","root","");
			  
			  /* 3. Créer un état de connexion*/
			  
			  Statement st = con.createStatement();
			  
			  /* 4.  Créer une requete de sélection */
			  
			  ResultSet res = st.executeQuery("select * from informations");
			  
			  /* 5. Parcour des données  de la table */
			  while (res.next()) {
				System.out.println("ID:"+ res.getString(1) + "  " + "Nom:" + res.getString(2) + "  " + "Prénom:"+ res.getString(3)+ "  "+"Age:"+res.getString(4)+"  "+"Adresse:"+res.getString(5)+"  "+"Score:"+res.getString(6));
				System.out.println("----------------------------------------------------------------------------");
				  
			  }
			   
			  //String query = "INSERT INTO informations ('Prenom','Score') values ('Jean',60)";
			  //st.executeUpdate(query);
			  
			  
			  /* 6. Fermer la connection*/
			  con.close();
			  
			  
		} catch (Exception e) {
			     System.out.println(
			    		 "ERROR : " + e.getMessage());}
		}
}




