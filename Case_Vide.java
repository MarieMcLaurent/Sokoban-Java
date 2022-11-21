package code;
import javax.swing.ImageIcon;
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
			super(type);
		}
		
		//Redefinition Méthodes Abstraites :
		@Override
		public void afficher_case(int i, int j){this.ImCase = new ImageIcon(new ImageIcon(":/images/data/PNG/vide.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

		ImCase.paintIcon(null, null, i, j);
		}

}