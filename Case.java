package code;

import javax.swing.ImageIcon;
import java.awt.Graphics;

abstract class Case {
	//Attributs
		protected int type=0;
		public ImageIcon ImCase;
		//Constructeurs
		public Case(int m_type,String nom) {
			// TODO Auto-generated constructor stub
			type = m_type;
			ImCase = new ImageIcon(nom);
		}
		/* Constructeurs 
		 * @param i,j : entiers correspondants
		 */
		public Case(){
		}
		
		// Accesseurs
		public int getType(){return type;}
		// Affichage de la case
		public abstract void afficher_case(Graphics g,int i, int j);
		
}
