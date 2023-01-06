package code;

import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Caisse extends Coordonnees{
	
	//Attributs
	protected boolean EtatCaisse=false;
	protected int type=4;
	public ImageIcon ImCaisse;

	public Caisse(int x, int y,  boolean Etat,int m_type) {
		super(x,y);
		EtatCaisse = Etat;
		type = m_type;
		if (EtatCaisse == true) 
			ImCaisse = new ImageIcon("PNG/caisse-marque.png");
		else
			ImCaisse = new ImageIcon("PNG/caisse.png");
	}
	
	public boolean getEtat() {return EtatCaisse;}
	
	//public Coordonnees getPosition() {return super(this.getI(),this.getJ());}
	
	public void ChangementCouleur() {EtatCaisse = !EtatCaisse;}
	
	public void afficher_caisse(Graphics g) {
		if (EtatCaisse == true) 
			ImCaisse = new ImageIcon("PNG/caisse-marque.png");
		else
			ImCaisse = new ImageIcon("PNG/caisse.png");
		g.drawImage(this.ImCaisse.getImage(),this.getJ()*50,this.getI()*50+25, 50,50, null);
	}
}
