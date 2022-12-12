package code;
//package coordonnees;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Personnage extends Coordonnees {

/*!
 * Utilise la classe Coordonnees
 */
	private Image ImPerso;
	public Personnage(int x, int y){ super(x,y);
	
	}

	public Personnage(Coordonnees m_pos){ super(m_pos.getI(),m_pos.getJ());

	}

	public Coordonnees getPosition(){
	    res = super(this.getI(), this.getJ());
		return Coordonnees(this.getI(), this.getJ());
	}


	public void afficher_perso(MonPanel P, int perso){
	    if (perso==1) {
	    	ImPerso = new ImageIcon(this.getClass().getResource("/PNG/playerFace1.png")).getImage();
	    	P.setBounds(this.getJ()*50,this.getI()*50+25,50,50);
	    }
	    else {
	    	ImPerso = new ImageIcon(this.getClass().getResource("/PNG/playerFace0.png")).getImage();
	        P.setBounds(this.getJ()*50,this.getI()*50+25,50,50);
	    }
	}

}
