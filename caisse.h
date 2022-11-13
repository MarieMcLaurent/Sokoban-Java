#include "coordonnees.h"
#include <QPainter>

#ifndef CAISSE_H
#define CAISSE_H
/*!
 * \file caisse.h
 * \brief Caisse du jeu Sokoban
 * \author Larange-Laurent
 * \version 0.2
 */

class Caisse: public Coordonnees
{
private:
    bool EtatCaisse;
    int type;
public:
    Caisse(int x=0, int y=0,  bool Etat=false,int m_type=4);
    bool getEtat();
    Coordonnees getPosition();
    void ChangementCouleur();
    void afficher_caisse(QPainter *p);

};

#endif // CAISSE_H
