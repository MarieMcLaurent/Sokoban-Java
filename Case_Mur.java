package code;


import java.awt.Graphics;
import java.awt.Image;

public class Case_Mur extends Case{

	//Constructeurs
		public Case_Mur() {
			// TODO Auto-generated constructor stub
		}
		/* Constructeurs 
		 * @param i,j : entiers correspondants
		 */
		public Case_Mur(int type){ 
			super(type,"PNG/wall.png");
		}
		
		//Redefinition Méthodes Abstraites :
		@Override
		public void afficher_case(Graphics g,int i, int j){
			g.drawImage(this.ImCase.getImage(),j*50,i*50+25, 50,50, null);
		}

}