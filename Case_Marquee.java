package code;
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
			super(type);
		}
		
		//Redefinition Méthodes Abstraites :
		@Override
		public void afficher_case(int i, int j){this.ImCase = new ImageIcon(new ImageIcon(":/images/data/PNG/marque_point.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImCase.paintIcon(null, null, i, j);
		}

}
