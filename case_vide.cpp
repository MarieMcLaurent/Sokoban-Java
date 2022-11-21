#include "case_vide.h"

Case_Vide::Case_Vide(int m_type) : Case(m_type)
{
}


void Case_Vide::afficher_case(QPainter *p, int i, int j)
{

    p->drawPixmap(j*50,i*50+25,50,50, QPixmap(":/images/data/PNG/ground.png"));

}
