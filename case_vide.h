#include "case.h"

#ifndef CASE_VIDE_H
#define CASE_VIDE_H
/*!
 * \file case_vide.h
 * \brief Case vide du plateau de jeu Sokoban
 * \author Larange-Laurent
 * \version 0.2
 */

class Case_Vide : public Case
{
private:
public:
    Case_Vide(int type=1);
    void afficher_case(QPainter *p, int i, int j);

};

#endif // CASE_VIDE_H
