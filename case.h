#include <QPainter>

#ifndef CASE_H
#define CASE_H
/*!
 * \file case.h
 * \brief Case globale du plateau de jeu Sokoban
 * \author Larange-Laurent
 * \version 0.2
 */

class Case
{
    int type;
public:
    Case(int m_type);
    virtual ~Case() {};

    int getType();
    virtual void afficher_case(QPainter *p, int i, int j) =0;


};

#endif // CASE_H
