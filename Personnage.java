package code;


import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Personnage extends Coordonnees {

/*!
 * Utilise la classe Coordonnees
 */
	public ImageIcon ImPerso;
	public Personnage(int x, int y){ super(x,y);
		ImPerso = new ImageIcon("PNG/playerFace1.png");
	}

	public Personnage(Coordonnees m_pos){ super(m_pos.getI(),m_pos.getJ());

	}

	public Coordonnees getPosition(){
		return new Coordonnees(this.getI(), this.getJ());
	}


	public void afficher_perso(Graphics g, int perso){
	    if (perso==1) {
	    	g.drawImage(this.ImPerso.getImage(),this.getJ()*50,this.getI()*50+25, 50,50, null);
	    }
	    else {
	    	ImPerso = new ImageIcon("PNG/playerFace0.png");
	    	g.drawImage(this.ImPerso.getImage(),this.getJ()*50,this.getI()*50+25, 50,50, null);
	    }
	}

}
