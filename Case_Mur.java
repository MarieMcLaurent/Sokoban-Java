package code;
import javax.swing.ImageIcon;
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
			super(type);
		}
		
		//Redefinition Méthodes Abstraites :
		@Override
		public void afficher_case(int i, int j){this.ImCase = new ImageIcon(new ImageIcon("/PNG/mur.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImCase.paintIcon(null, null, i, j);
		}

}