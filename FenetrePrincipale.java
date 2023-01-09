package code;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.util.*;

public class FenetrePrincipale extends JFrame {

	private JFrame frame;
	private JLabel displayField;
	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrénom;
	private JTextField textAge;
	private JTextField textAdresse;
	private JLabel lblAdresse;
	private JButton btnButtonRemplir;
	private JButton btnButtonVider;
	private int niveau;
	protected Plateau Pt = new Plateau();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
					frame.addKeyListener(new KeyAdapter() { @Override public void keyPressed(java.awt.event.KeyEvent evt) {
						 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_UP ) {
							 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
									 
							 frame.Pt.deplacerPerso(frame.Pt.getPersonnage().getPosition(), "haut");
									 
							 }
							 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_DOWN ) {
								 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
										 
								 frame.Pt.deplacerPerso(frame.Pt.getPersonnage().getPosition(), "bas");
									}	
							 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_LEFT ) {
								 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
										 
								 frame.Pt.deplacerPerso(frame.Pt.getPersonnage().getPosition(), "gauche");
									}
							 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_RIGHT ) {
								 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
										 
										 frame.Pt.deplacerPerso(frame.Pt.getPersonnage().getPosition(), "droite");
									}
							 frame.dessiner(frame.getContentPane().getGraphics());
									 
							 
							
							 if (frame.Pt.Niveau_terminee()==true){
								 int reponse= JOptionPane.showConfirmDialog(null, "Bravo!!", "Niveau suivant?", JOptionPane.YES_NO_OPTION);
								 if (reponse == JOptionPane.YES_OPTION) {
						            //hide();
									int niv =frame.getNiveau()+1;
									frame.setNiveau(niv);
						        
						            // add score of level
						            frame.gestionPlateau(niv);
						            //show();
						        }
						        else {
						        	frame.dispose();
						        }
							 }}});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void on_actionNouvelle_Partie_triggered(java.awt.event.ActionEvent evt) {
		// On ajoute un cercle à la liste des objets graphiques
		this.gestionPlateau(2);
		//Image offscreen;
		// On crée une image en mémoire de la taille du ContentPane
		//offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight()-10);
		// On appelle la méthode dessiner()
		//Pt.afficher_Plateau(this.getContentPane().getGraphics(),contentPane,offscreen,1);
		dessiner(this.getContentPane().getGraphics());
		}
	
	private void gestionPlateau(int niveau) {
		// On ajoute un rectangle à la liste des objets graphiques
		String file = "Lvl/Niveau"+Integer.toString(niveau)+".txt";
		System.out.println(file);
		Pt = new Plateau(file,0,0);
		
		}
	
	private void on_actionRecommencer_triggered(java.awt.event.ActionEvent evt) {
		// On ajoute une image à la liste des objets graphiques
		this.setNiveau(0);
		int niv = this.getNiveau();
		// On appelle la méthode dessiner()
		Image offscreen;
		// On crée une image en mémoire de la taille du ContentPane
		offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight()-10);
		Pt.afficher_Plateau(this.getContentPane().getGraphics(),contentPane,offscreen,1);
		}
	
	private void menuItemAProposActionPerformed(java.awt.event.ActionEvent evt) {
		// On ajoute une image à la liste des objets graphiques
		System.out.println(Pt.getPersonnage().getI());
		Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "haut");
		System.out.println(Pt.getPersonnage().getI());
		dessiner(this.getContentPane().getGraphics());}
	public void setNiveau(int niv) {
		niveau = niv;
	}
	public int getNiveau() {
		return niveau;
	}
	
	/* 
	 * void MainWindow::setDeco(int val){deco = val;}
	 * void MainWindow::setPerso(int val){perso = val;}
	 */
	/**
	 * Create the frame.
	 */
	
	public FenetrePrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 800);
		contentPane = new MonPanel(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setContentPane(contentPane);
		this.getContentPane().setBackground(Color.WHITE);
		contentPane.setFocusable(false);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 279, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Fonctionnalités");
		menuBar.setFocusable(false);
		menuBar.add(mnNewMenu);
		
		JMenuItem mnNewMenu_1 = new JMenuItem("Plateau");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				on_actionNouvelle_Partie_triggered(e);
			}
			});
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mnNewMenu_2 = new JMenuItem("Recommencer");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemAProposActionPerformed(e);
			}
			});
		mnNewMenu.add(mnNewMenu_2);
		this.addKeyListener(new KeyAdapter() { @Override public void keyPressed(java.awt.event.KeyEvent evt) {
			 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_UP ) {
				 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
						 
						 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "haut");
						 
				 }
				 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_DOWN ) {
					 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
							 
							 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "bas");
						}	
				 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_LEFT ) {
					 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
							 
							 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "gauche");
						}
				 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_RIGHT ) {
					 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
							 
							 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "droite");
						}
				 dessiner(frame.getContentPane().getGraphics());
						 
				 
				
				 if (Pt.Niveau_terminee()==true){
					 int reponse= JOptionPane.showConfirmDialog(null, "Bravo!!", "Niveau suivant?", JOptionPane.YES_NO_OPTION);
					 if (reponse == JOptionPane.YES_OPTION) {
			            //hide();
			            niveau += 1;
			            // add score of level
			            gestionPlateau(niveau);
			            //show();
			        }
			        else {
			        	dispose();
			        }
				 }}});

	}
	public void dessiner(Graphics g)
	{
		Graphics bufferGraphics;
		Image offscreen;
		// On crée une image en mémoire de la taille du ContentPane
		offscreen = createImage(this.getContentPane().getWidth(),this.getContentPane().getHeight()-10);
		// On récupère l'objet de type Graphics permettant de dessiner dans cette image
		bufferGraphics = offscreen.getGraphics();
		// On colore le fond de l'image en blanc
		bufferGraphics.setColor(Color.WHITE);
		// bufferGraphics.fillRect(0,0,this.getContentPane().getWidth(),
		// this.getContentPane().getHeight()-10);
		// On dessine les objets graphiques de la liste dans l'image en mémoire pour éviter les
		// problèmes de scintillements
		int la = Pt.getLargeur();
		int lo = Pt.getLongueur();
		
		for(int i=0; i<lo;i++){
	        for(int j=0; j<la;j++){
	        	Coordonnees coor = new Coordonnees(i,j);
	        	Case c = Pt.getCase(i*10+j);
	        	if (c != null) {
	        		c.afficher_case(bufferGraphics,i,j);
	        	}else {
	        		c = new Case_Mur(0);
	        		c.afficher_case(bufferGraphics,i,j);
	        	}
	        }
	    }
		Pt.getPersonnage().afficher_perso(bufferGraphics, 1);
	// On afficher l'image mémoire à l'écran
		g.drawImage(offscreen,0,5,null);}
	
	/* Accès boîte de dialogue 
	private void menuItemAProposActionPerformed(java.awt.event.ActionEvent evt) {
		// Création de la boite en mémoire
		Dialog maBoite = new Dialog();
		// Affichage de la boite
		maBoite.setVisible(true);
		}*/
	
	public void formKeyPressed(java.awt.event.KeyEvent evt) {
		 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_UP ) {
		 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
				 
				 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "haut");
				 
		 }
		 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_DOWN ) {
			 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
					 
					 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "bas");
				}	
		 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_LEFT ) {
			 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
					 
					 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "gauche");
				}
		 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_KP_RIGHT ) {
			 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
					 
					 Pt.deplacerPerso(Pt.getPersonnage().getPosition(), "droite");
				}
		 dessiner(this.getContentPane().getGraphics());
				 
		 
		
		 if (Pt.Niveau_terminee()==true){
			 int reponse= JOptionPane.showConfirmDialog(null, "Bravo!!", "Niveau suivant?", JOptionPane.YES_NO_OPTION);
			 if (reponse == JOptionPane.YES_OPTION) {
	            //hide();
	            niveau += 1;
	            // add score of level
	            gestionPlateau(niveau);
	            //show();
	        }
	        else {
	        	dispose();
	        }
		 }
    }
	
}