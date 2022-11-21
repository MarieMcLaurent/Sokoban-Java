#include "case.h"

#ifndef CASE_MUR_H
#define CASE_MUR_H
/*!
 * \file case_mur.h
 * \brief Case mur/obstacle du plateau de jeu Sokoban
 * \author Larange-Laurent
 * \version 0.2
 */
class Case_Mur: public Case
{
private:
    ;
public:
    Case_Mur(int type=3);
    void afficher_case(QPainter *p, int i, int j);

};

#endif // CASE_MUR_H
