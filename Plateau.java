package code;

import java.util.HashMap;
import java.util.*;
import java.io.*;
import java.lang.Class;
public class Plateau extends Coordonnees {


	//Attributs
	private int nbCaisse = 0;
	private	int largeur = 7;
	private	int longueur = 6;
	private Class cls;
	private Personnage PersoSurPlateau;
	private	HashMap<Coordonnees, Case> cases= new HashMap<Coordonnees, Case>();
	private ArrayList<Caisse> ListeCaisse = new ArrayList<>();
	/* Constructeurs par défault
	 */
	public Plateau(){
		super(1,1);
		for(int i=0; i<hauteur;i++){
			for (int j=0;j<largeur ;j++ ) {
				cases.put(new Coordonnees(i,j),new Case_Vide());
			}
		}
	}
	/* Constructeurs 
	 * @param l,h : entiers correspondants à la largeur et à la hauteur de la grille choisie
	 */
	public Plateau(String fich, int x, int y){
		super(x,y);
		InputStream inputStream = null;
		String line;
		Char temp = "";
		try {
			Class cls = Class.forName("ClassLoaderDemo");

		      // returns the ClassLoader object associated with this Class
		      ClassLoader cLoader = cls.getClassLoader();
		    
		      System.out.println(cLoader.getClass());
		    
		    File file = new File(cLoader.getResource(fich).getFile());
		    inputStream = new FileInputStream(file);
		    if (file.exists()) {
	            // get the contents into arr[]
	            // now arr[i] represent either a File or
	            // Directory
		    	// Créer l'objet File Reader
		        FileReader fr = new FileReader(file);  
		        // Créer l'objet BufferedReader        
		        BufferedReader br = new BufferedReader(fr); 
		        if ((line = br.readLine()) != null) {
		        	nbCaisse = Integer.parseInt(line);
		        	longueur = Integer.parseInt(br.readLine());
		        	largeur = Integer.parseInt(br.readLine());
		            for (int i=0; i<longueur;i++){
		            	line = br.readLine();
		                for (int j=0; j<largeur;j++){
		                	temp=line[j];
		                    switch(temp){
		                        case '#' : cases.put(new Coordonnees(i,j),new Case_Mur(1)); break;
		                        case '_' : cases.put(new Coordonnees(i,j),new Case_Vide(0)); break;
		                        case '.' : cases.put(new Coordonnees(i,j),new Case_Marquee(2));break;
		                        case '@' : PersoSurPlateau = new Personnage(i, j);
		                        cases.put(new Coordonnees(i,j),new Case_Vide(0)); break;
		                        case '+' : PersoSurPlateau = new Personnage(i, j);
		                        cases.put(new Coordonnees(i,j),new Case_Marquee(2));break;
		                        case '$' : ListeCaisse.add(new Caisse(i,j, false,4));
		                        cases.put(new Coordonnees(i,j),new Case_Vide(0)); break;
		                        case '*' : ListeCaisse.add(new Caisse(i, j, false,4));
		                        cases.put(new Coordonnees(i,j),new Case_Marquee(2));break;
		                    }
		                }
	            }
	           } 
		    }    
		finally {
		    if (inputStream != null) {
		        try {
		            inputStream.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		largeur=l;
		hauteur=h;
		
	}	
	// Accesseurs
	public int getLargeur(){return largeur;}
	public int getHauteur(){return hauteur;}

	int getNbCaisse(){
	    return nbCaisse;
	}

	ArrayList<Caisse> getListeCaisse(){
	    return ListeCaisse;
	}
	void Plateau:: afficher_Plateau(QPainter *p,int perso){

	    for(int i=0; i<longueur;i++){
	        for(int j=0; j<largeur;j++){
	            GrillePlateau[i][j]->afficher_case(p,i,j);
	        }
	    }
	    for(int i=0; i<nbCaisse;i++){
	        ListeCaisse[i]->afficher_caisse(p);
	    }
	    PersoSurPlateau->afficher_perso(p, perso);

	}


	Personnage * Plateau::getPersonnage(){
	    return PersoSurPlateau;
	}


	int Plateau:: getLongueur(){
	    return longueur;
	}
	int Plateau:: getLargeur(){
	    return largeur;
	}
	// Mutateurs
	

	//Autres Méthodes
	public String afficher(){ // Refaire pour avoir sortie string 
		String res = "-";
		for(int j=0; j<largeur ;j++ ){
			res= res+ "-0"+j;
		}
		res=res+"--\n";
		for(int i=0; i<hauteur;i++){
			res = res +i+"|";
			for (int j=0;j<largeur ;j++ ) {
				Coordonnees c =new Coordonnees(i,j);
				(cases.get(c)).afficher_case(i,j);
			}
			res=res+"|\n";
		}
		return res;
	}


}
