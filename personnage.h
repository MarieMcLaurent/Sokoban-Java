#include "coordonnees.h"
#include <string>
#include <QPainter>


#ifndef PERSONNAGE_H
#define PERSONNAGE_H
/*!
 * \file personnage.h
 * \brief Personnage jouable du jeu Sokoban
 * \author Larange-Laurent
 * \version 0.2
 */
class Personnage: public Coordonnees
{
public:
    Personnage(int x, int y);
    Personnage(Coordonnees m_pos);
    Coordonnees getPosition();
    void afficher_perso(QPainter *p, int perso=0);

};

#endif // PERSONNAGE_H
