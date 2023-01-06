package code;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class Case_Vide  extends Case{

	//Constructeurs
		public Case_Vide () {
			// TODO Auto-generated constructor stub
		}
		/* Constructeurs 
		 * @param i,j : entiers correspondants
		 */
		public Case_Vide(int type){ 
			super(type,"/PNG/ground.png");
		}
		
		//Redefinition Méthodes Abstraites :
		@Override
		public void afficher_case(Graphics g,int i, int j){
			g.drawImage(ImCase.getImage(),j*50,i*50+25, 50,50, null);
		}

}
