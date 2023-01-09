package code;

import java.util.*;
import java.awt.Color;

//import gui.CObjetGraphique;

//import gui.File;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.*;
import java.io.*;
import java.awt.BorderLayout;

//import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class Plateau extends Coordonnees {


	//Attributs
	private int nbCaisse = 0;
	private	int largeur = 7;
	private	int longueur = 6;
	//private Class cls;
	private Personnage PersoSurPlateau = new Personnage(0,0);
	private	HashMap<Integer, Case> cases= new HashMap<Integer, Case>();
	private ArrayList<Caisse> ListeCaisse = new ArrayList<>();
	/* Constructeurs par défault
	 */
	public Plateau(){
		super(1,1);
		for(int i=0; i<longueur;i++){
			for (int j=0;j<largeur ;j++ ) {
				cases.put(i*10+j,new Case_Vide(0));
			}
		}
	}
	/* Constructeurs 
	 * @param l,h : entiers correspondants à la largeur et à la hauteur de la grille choisie
	 */
	public Plateau(String fich, int x, int y){
		super(x,y);
		//InputStream inputStream = null;
		Scanner scanner = null;
		String line;
		char temp = '0';
		try {
		    //File file = new File(cLoader.getResource(fich).getFile());
		    scanner = new Scanner(new File(fich));
		    //inputStream = new FileInputStream(file);
		    if (scanner.hasNextLine()) {
		        line = scanner.nextLine();
		        longueur = Integer.parseInt(line);
		        line = scanner.nextLine();
		        largeur = Integer.parseInt(line);
		        line = scanner.nextLine();
		        nbCaisse = Integer.parseInt(line);
		        System.out.println(largeur);
		        for (int i=0; i<longueur;i++){
		        	line = scanner.nextLine();
		        	
		            for (int j=0; j<largeur;j++){
		                temp= line.toCharArray()[j];
		                switch(temp){
		                	case '#' : cases.put(i*10+j,new Case_Mur(3)); break;
		                    case '_' : cases.put(i*10+j,new Case_Vide(1)); break;
		                    case '.' : cases.put(i*10+j,new Case_Marquee(2));break;
		                    case '@' : PersoSurPlateau = new Personnage(i, j);
		                    cases.put(i*10+j,new Case_Vide(1)); break;
		                    case '+' : PersoSurPlateau = new Personnage(i, j);
		                    cases.put(i*10+j,new Case_Marquee(2));break;
		                    case '$' : ListeCaisse.add(new Caisse(i,j, false,4));
		                    cases.put(i*10+j,new Case_Vide(1)); break;
		                    case '*' : ListeCaisse.add(new Caisse(i, j, false,4));
		                    cases.put(i*10+j,new Case_Marquee(2));break;
		                  }
		               }
	            }
	           } 
		    	scanner.close();
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		
	}	
	// Accesseurs

	public int getNbCaisse(){
	    return nbCaisse;
	}

	public ArrayList<Caisse> getListeCaisse(){
	    return ListeCaisse;
	}
	
	public Personnage getPersonnage(){
	    return PersoSurPlateau;
	}

	public Case getCase(int i) {
		return(cases.get(i));
	}
	public int getLongueur(){
	    return longueur;
	}
	public int getLargeur(){
	    return largeur;
	}
	// Fonction d'affichage des élements du plateau
	public void afficher_Plateau(Graphics g,JPanel p,Image offscreen,int perso){
		Graphics bufferGraphics;
		// On crée une image en mémoire de la taille du ContentPane
		//offscreen = createImage(p.getWidth(),p.getHeight()-10);
		// On récupère l'objet de type Graphics permettant de dessiner dans cette image
		bufferGraphics = offscreen.getGraphics();
		// On colore le fond de l'image en blanc
		bufferGraphics.setColor(Color.WHITE);
		// bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),
		// this.getContentPane().getHeight()-10);
		// On dessine les objets graphiques de la liste dans l'image en mémoire pour éviter les
		// problèmes de scintillements
	
	// On afficher l'image mémoire à l'écran
		
	    for(int i=0; i<longueur;i++){
	        for(int j=0; j<largeur;j++){
	        	Coordonnees coor = new Coordonnees(i,j);
	        	Case c = cases.get(i*10+j);
	        	
	        	if (c != null) {
	        		System.out.println(1);
	        		c.afficher_case(bufferGraphics,i,j);
	        	}else {
	        		System.out.println(1);
	        		c = new Case_Vide(0);
	        		c.afficher_case(bufferGraphics,i,j);
	        	}
	        }
	    }
	    if (ListeCaisse != null) {
			for (Caisse c : ListeCaisse)
				c.afficher_caisse(bufferGraphics);
	    }
	    PersoSurPlateau.afficher_perso(bufferGraphics, perso);
	    g.drawImage(offscreen,0,5,null);
	}


	public Caisse getCaisse(Coordonnees Coord){
		for (Caisse c : ListeCaisse){
	        if ((c.getI() == Coord.getI()) && (c.getJ() == Coord.getJ())){
	            return c;
	        }
	    }
	    return null;
	    /*
	    cout << "Erreur: Pas de caisse avec ses coordonnées trouvés";
	    return *ListeCaisse[nbCaisse-1]; // Rajouter des exceptions
	    */
	}
	

	public void updateCoordonneesP(Coordonnees CoordP, String d){
	    if ((d=="haut") && (CoordP.getI()>0))
	        PersoSurPlateau.setI(CoordP.getI() - 1);
	    if ((d=="bas") && (CoordP.getI()< longueur-1))
	        PersoSurPlateau.setI(CoordP.getI() + 1);
	    if ((d=="gauche") &&(CoordP.getJ()>0))
	        PersoSurPlateau.setJ(CoordP.getJ()-1);
	    if ((d=="droite") &&(CoordP.getJ()<largeur - 1))
	        PersoSurPlateau.setJ(CoordP.getJ() + 1);
	}
	// String d --> touche du clavier flèche
	public void updateCoordonneesC(Coordonnees CoordC, String d){
	    if ((d=="haut") && (CoordC.getI()>0)) {
	        getCaisse(CoordC).setI(CoordC.getI() - 1);}
	    if ((d=="bas")&&(CoordC.getI()< longueur-1)) {
	        getCaisse(CoordC).setI(CoordC.getI() + 1);}
	    if ((d=="gauche")&&(CoordC.getJ()>0)) {
	        getCaisse(CoordC).setJ(CoordC.getJ() - 1);}
	    if ((d=="droite")&&(CoordC.getJ()<largeur-1)) {
	        getCaisse(CoordC).setJ(CoordC.getJ() + 1);}
	}

	public void deplacerPerso(Coordonnees coordP, String d){
	    int type = this.verifierPosition(coordP,d);
	    System.out.println(type);
	    if(type == 2 || type == 1){
	        this.updateCoordonneesP(coordP,d);
	    }
	    if (type == 4){ // il y a une caisse
	        Coordonnees coordC= new Coordonnees(coordP,d);
	        if (this.deplacerCaisse(coordC,d)==true){
	            this.updateCoordonneesP(coordP,d);
	        }
	    }
	}


	public int verifierPosition(Coordonnees coord, String d){
	    Coordonnees temp;
	    if (d=="haut"){
	        temp = new Coordonnees(coord.getI()-1, coord.getJ());
	        if (getCaisse(temp)!=null) // il y a une caisse
	            return 4;
	        else
	        {
	            return cases.get(temp.getI()*10 +temp.getJ()).getType();
	        }
	    }
	    if (d=="bas"){
	        temp = new Coordonnees(coord.getI()+1, coord.getJ());
	        if (getCaisse(temp)!=null) // il y a une caisse
	            return 4;
	        else
	        {
	            return cases.get(temp.getI()*10 +temp.getJ()).getType();
	        }
	    }
	    if (d=="gauche"){
	        temp = new Coordonnees(coord.getI(), coord.getJ()-1);
	        if (getCaisse(temp)!=null) // il y a une caisse
	            return 4;
	        else
	        {
	            return cases.get(temp.getI()*10 +temp.getJ()).getType();
	        }
	    }
	    if (d=="droite"){
	        temp = new Coordonnees(coord.getI(), coord.getJ()+1);
	        if (getCaisse(temp)!=null) // il y a une caisse
	            return 4;
	        else
	        {
	            return cases.get(temp.getI()*10 +temp.getJ()).getType();
	        }
	    }
	    else
	    {
	    	return -1;
	    }
	}

	private boolean deplacerCaisse(Coordonnees coordC, String d){
	    int type = this.verifierPosition(coordC,d);
	    Caisse c = this.getCaisse(coordC);
	    if(type == 1){
	        this.updateCoordonneesC(coordC,d);
	        if(c.getEtat()==true){
	            c.ChangementCouleur();
	        }
	        return true;
	
	    }
	    else
	    {
	        if (type == 2){
	            this.updateCoordonneesC(coordC,d);
	            if(c.getEtat()==false){
	                c.ChangementCouleur();
	            }
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	}


	public boolean Niveau_terminee(){
	    int nbCaisse_marquee = 0;
	
	    for (Caisse c : ListeCaisse){
	        if (c.getEtat()==true){
	            nbCaisse_marquee++;
	        }
	    }
	    if (nbCaisse_marquee==nbCaisse){
	        return true;
	    }
	    return false;
	}
}