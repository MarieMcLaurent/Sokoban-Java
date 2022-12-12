package code;

import javax.swing.JPanel;

public class Coordonnees {

	//Attributs
		private	int i=0;
		private	int j=0;
		public 	MonPanel P;
		/* Constructeurs par défault
		 */
		public Coordonnees(){}
		/* Constructeurs 
		 * @param x,y : entiers correspondants
		 */
		public Coordonnees(int x,int y){
			i=x;
			j=y;
		}
		/*Constructeur après déplacement*/
		public Coordonnees(Coordonnees coord,String d  ){
			if (d=="haut"){
		        this.i = coord.i - 1;
		        this.j = coord.j;
		    }
		    if (d=="bas"){
		    	this.i = coord.i + 1;
		    	this.j = coord.j;
		    }
		    if (d=="gauche"){
		    	this.i = coord.i;
		    	this.j = coord.j - 1;
		    }
		    if (d=="droite"){
		    	this.i = coord.i;
		    	this.j = coord.j + 1;
		    }
		}
		// Accesseurs
		public int getI(){return i;}
		public int getJ(){return j;}

		// Mutateurs
		public void setI(int i){this.i=i;}
		public void setJ(int j){this.j=j;}

		// Redefinition de la methode = 
		
	 	
	 	// Redefinition de la methode hashCode
		@Override
	 	public int hashCode() {
	 		return i*10+j;
	 	}
}
