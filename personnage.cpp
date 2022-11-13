#include "personnage.h"


Personnage::Personnage(int x, int y): Coordonnees(x,y)
{
}

Personnage::Personnage(Coordonnees m_pos): Coordonnees(m_pos.getX(),m_pos.getY())
{

}

Coordonnees Personnage:: getPosition(){
    return Coordonnees(this->getX(), this->getY());
}


void Personnage:: afficher_perso(QPainter *p, int perso){
    if (perso==1)
        p->drawPixmap(getY()*50,getX()*50+25,50,50, QPixmap(":/images/data/PNG/playerFace1.png"));
    else
        p->drawPixmap(getY()*50,getX()*50+25,50,50, QPixmap(":/images/data/PNG/playerFace0.png"));

}
