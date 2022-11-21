package code;
import javax.swing.ImageIcon;

public class Caisse extends Coordonnees{
	
	//Attributs
	protected boolean EtatCaisse=false;
	protected int type=4;
	public ImageIcon ImCaisse;

	public Caisse(int x, int y,  boolean Etat,int m_type) {
		super(x,y);
		EtatCaisse = Etat;
		type = m_type;
	}
	
	public boolean getEtat() {return EtatCaisse;}
	
	//public Coordonnees getPosition() {return super(this.getI(),this.getJ());}
	
	public void ChangementCouleur() {EtatCaisse = !EtatCaisse;}
	
	public void afficher_caisse() {
		if (EtatCaisse == true) 
			ImCaisse = new ImageIcon(":/images/data/PNG/caisse-marque.png");
		else
			ImCaisse = new ImageIcon(":/images/data/PNG/caisse.png");
	}
}
