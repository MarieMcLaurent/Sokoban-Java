#include "caisse.h"

Caisse:: Caisse(int x, int y, bool Etat, int m_type): Coordonnees(x,y)
{
    EtatCaisse = Etat;
    type = m_type;
}


bool Caisse::getEtat(){
    return EtatCaisse;
}


void Caisse::ChangementCouleur(){
    // changer la photo de la caisse
    EtatCaisse = !EtatCaisse;
}


void Caisse:: afficher_caisse(QPainter *p){
    if (EtatCaisse==true)
        p->drawPixmap(getY()*50,getX()*50+25,50,50, QPixmap(":/images/data/PNG/caisse - marque.png"));
    else
        p->drawPixmap(getY()*50,getX()*50+25,50,50, QPixmap(":/images/data/PNG/caisse.png"));

}
