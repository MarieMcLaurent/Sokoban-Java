package code;

import javax.swing.ImageIcon;

abstract class Case {
	//Attributs
		protected int type=0;
		public ImageIcon ImCase;
		//Constructeurs
		public Case(int m_type) {
			// TODO Auto-generated constructor stub
			type = m_type;
		}
		/* Constructeurs 
		 * @param i,j : entiers correspondants
		 */
		public Case(){
		}
		
		// Accesseurs
		public int getType(){return type;}
		// Affichage de la case
		public abstract void afficher_case(int i, int j);
		
}
