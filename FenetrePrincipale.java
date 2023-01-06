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


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
	private Plateau Pt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Remplir(ActionEvent e)
	{
		textNom.setText("Dupont");
		textPrénom.setText("Jeanne");
		textAge.setText("18");
		textAdresse.setText("29 Avenue Blaise Pascal");
	}
	
	public void Vider(ActionEvent e)
	{
		textNom.setText("");
		textPrénom.setText("");
		textAge.setText("");
		textAdresse.setText("");
	}
	private void on_actionNouvelle_Partie_triggered(java.awt.event.ActionEvent evt) {
		// On ajoute un cercle à la liste des objets graphiques
		this.gestionPlateau(1);
		
		// On appelle la méthode dessiner()
		dessiner(this.getContentPane().getGraphics());}
	
	private void gestionPlateau(int niveau) {
		// On ajoute un rectangle à la liste des objets graphiques
		Pt = new Plateau();
		}
	
	private void on_actionRecommencer_triggered(java.awt.event.ActionEvent evt) {
		// On ajoute une image à la liste des objets graphiques
		this.setNiveau(0);
		int niv = this.getNiveau();
		// On appelle la méthode dessiner()
		dessiner(this.getContentPane().getGraphics());}
	private void setNiveau(int niv) {
		niveau = niv;
	}
	private int getNiveau() {
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
		
		JMenuItem mnNewMenu_2 = new JMenuItem("Dialog?");
		mnNewMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemAProposActionPerformed(e);
			}
			});
		mnNewMenu.add(mnNewMenu_2);
		JMenu mnMenu2 = new JMenu("Dessin ");
		menuBar.add(mnMenu2);
		
		JMenuItem mnMenu_1 = new JMenuItem("Cercle");
		mnMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				on_actionRecommencer_triggered(e);
			}
			});
		mnMenu2.add(mnMenu_1);
		
		JMenuItem mnMenu_2 = new JMenuItem("Rectangle");
		mnMenu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				on_actionRecommencer_triggered(e);
			}
			});
		mnMenu2.add(mnMenu_2);
		JMenuItem mnMenu_3 = new JMenuItem("Image");
		mnMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				on_actionRecommencer_triggered(e);
			}
			});
		mnMenu2.add(mnMenu_3);
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
		if (Pt != null)
			Pt.afficher_Plateau(bufferGraphics, 1);
	
	// On afficher l'image mémoire à l'écran
		g.drawImage(offscreen,0,5,null);}
	
	/* Accès boîte de dialogue */
	private void menuItemAProposActionPerformed(java.awt.event.ActionEvent evt) {
		// Création de la boite en mémoire
		Dialog maBoite = new Dialog();
		// Affichage de la boite
		maBoite.setVisible(true);
		}
	/*
	private void formKeyPressed(java.awt.event.KeyEvent evt) {
		 if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE ) {
		 // Si la liste des objets graphiques n'est pas vide, on déplace le dernier de la liste
				 if (!listeObjets.isEmpty())
				 {
				 listeObjets.get(listeObjets.size()-1).deplacer(new Point(400,400));
				 dessiner(this.getContentPane().getGraphics());
				 }
			 }
		 if Key_Up ; Key_Down ; Key_Left ; Key_Right
		}
	if (pl->Niveau_terminee()==true){
        reponse= QMessageBox::question(this, "Titre de la fenêtre", "Bravo!! \n Niveau suivant?", QMessageBox::Yes | QMessageBox::No);
        if (reponse == QMessageBox::Yes)
        {

            hide();
            niveau++;
            gestionPlateau(niveau);
            show();
        }
        else if (reponse == QMessageBox::No){
            string file = "../Projet_2021_2022_Sokoban_0.3/data/LVL/level.txt";
            cout << file<< endl;
            ifstream fichier(file.c_str(), ios::in);
            int i =1;
            fichier>>line;
            if(!fichier.fail())
            {
                while (fichier.eof() == false and i!=niveau+1){
                    fichier>>line;
                    i++;
                }
                string msg ="Merci d'avoir joué.\n Pour accéder directement au niveau "+to_string(i)+"\n utilisez le code : "+line;
                QMessageBox mgb;
                mgb.setText(QString::fromStdString(msg));
                mgb.exec();

               }
            close();
        }
    }*/
}