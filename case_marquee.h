#include "case.h"


#ifndef CASE_MARQUEE_H
#define CASE_MARQUEE_H
/*!
 * \file case_marquee.h
 * \brief Case cible du plateau de jeu Sokoban
 * \author Larange-Laurent
 * \version 0.2
 */
class Case_Marquee: public Case
{
private:
public:
    Case_Marquee(int m_type=2);
    void afficher_case(QPainter *p, int i, int j);

};

#endif // CASE_MARQUEE_H
