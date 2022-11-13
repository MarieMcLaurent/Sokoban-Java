#include "case_marquee.h"

Case_Marquee::Case_Marquee(int m_type): Case(m_type)
{
}


void Case_Marquee::afficher_case(QPainter *p, int i, int j)
{
    //p->drawPixmap(100+j*50,100+i*50,50,50, QPixmap(":/images/data/PNG/ground.png"));
    p->drawPixmap(j*50,i*50+25,50,50, QPixmap(":/images/data/PNG/marque_point.png"));

}
