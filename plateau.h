#include "case.h"
#include "case_marquee.h"
#include "case_mur.h"
#include "case_vide.h"
#include "caisse.h"
#include "personnage.h"
#include <iostream>
#include <string>

#include <fstream>
#include <QPainter>
#include <QFile>
#include <vector>

#ifndef PLATEAU_H
#define PLATEAU_H
/*!
 * \file plateau.h
 * \brief Zone de déplacement du jeu Sokoban
 * \author Larange-Laurent
 * \version 0.4
 */
using namespace std;


class Plateau: public Coordonnees
{
private:
    int nbCaisse;
    int largeur;
    int longueur;
    // Il n'est pas possible de créer un tableau 2D basé sur des objets abstraits
    // du coup, je suis parti sur des vecteurs de vecteurs
    vector<vector <Case*>> GrillePlateau;
    vector<Caisse*> ListeCaisse;
    Personnage *PersoSurPlateau;
public:
    Plateau(string file, int x=1, int y=1);
    //Plateau(int x=0, int y=0);
    ~Plateau();
    void deplacerPerso(Coordonnees coordP, string d);
    bool deplacerCaisse(Coordonnees coordC, string d);
    Personnage *getPersonnage();
    int getLongueur();
    int getLargeur();
    bool existeDansListeCaisse(Coordonnees coord, string d);
    int verifierPosition(Coordonnees coord, string d);
    void updateCoordonneesP(Coordonnees coordP,string d);
    void updateCoordonneesC(Coordonnees coordP,string d);
    Caisse *getCaisse(Coordonnees coord);
    void afficher_Plateau(QPainter *p, int perso=0);
    int getNbCaisse();
    vector<Caisse*> getListeCaisse();
    bool Niveau_terminee();

};

#endif // PLATEAU_H
