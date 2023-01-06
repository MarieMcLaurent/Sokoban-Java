package code;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Case_Marquee extends Case{

	//Constructeurs
		public Case_Marquee() {
			// TODO Auto-generated constructor stub
		}
		/* Constructeurs 
		 * @param i,j : entiers correspondants
		 */
		public Case_Marquee(int type){ 
			super(type,"PNG/marque_point");
		}
		
		//Redefinition Méthodes Abstraites :
		@Override
		public void afficher_case(Graphics g,int i, int j){
			g.drawImage(this.ImCase.getImage(),j*50,i*50+25, 50,50, null);
		}


}
