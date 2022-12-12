package code;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;  
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;  
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JPasswordField;
import java.awt.*;
import java.util.*;

public class FenetrePrincipale extends JFrame {

	private JFrame frame;
	private JLabel displayField;
	private ImageIcon Image;
	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrénom;
	private JTextField textAge;
	private JTextField textAdresse;
	private JLabel lblAdresse;
	private JButton btnButtonRemplir;
	private JButton btnButtonVider;
	
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

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale() {
		setTitle("Bienvenu au jeu Sokoban");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(300, 300, 850, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(7, 7, 7, 7));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNom = new JTextField();
		textNom.setBounds(330, 32, 96, 19);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textPrénom = new JTextField();
		textPrénom.setColumns(10);
		textPrénom.setBounds(330, 75, 96, 19);
		contentPane.add(textPrénom);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(330, 117, 96, 19);
		contentPane.add(textAge);
		
		textAdresse = new JTextField();
		textAdresse.setColumns(10);
		textAdresse.setBounds(21, 49, 185, 59);
		contentPane.add(textAdresse);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(266, 33, 60, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom");
		lblNewLabel_1.setBounds(260, 76, 60, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(266, 118, 60, 16);
		contentPane.add(lblNewLabel_2);
		
		
		
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(84, 32, 60, 19);
		contentPane.add(lblAdresse);
		
		JButton btnButtonRemplir = new JButton("Remplir");
		btnButtonRemplir.setBackground(UIManager.getColor("Table.selectionBackground"));
		btnButtonRemplir.setForeground(Color.BLACK);
		btnButtonRemplir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remplir(e);
			}
		});
		
		btnButtonRemplir.setBounds(21, 116, 84, 21);
		contentPane.add(btnButtonRemplir);
		
		btnButtonVider = new JButton("Vider");
		btnButtonVider.setBackground(UIManager.getColor("Table.selectionBackground"));
		btnButtonVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vider(e);
			}
		});
		

		btnButtonVider.setBounds(127, 116, 79, 21);
		contentPane.add(btnButtonVider);
	    
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 279, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Fonctionnalités");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Sokoban");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Besoin d'aides?");
		menuBar.add(mnNewMenu_2);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/PNG/jerry.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(92, 164, 163, 89);
		contentPane.add(label);
		
		JButton valider = new JButton("");
		valider.setBackground(Color.ORANGE);
		Image val = new ImageIcon(this.getClass().getResource("/PNG/valider.png")).getImage();
		valider.setBounds(278, 164, 84, 89);
		valider.setIcon(new ImageIcon(val));
		contentPane.add(valider);
		
	}

}
