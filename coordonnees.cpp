#include "coordonnees.h"

Coordonnees::Coordonnees(int m_x, int m_y){
    x= m_x;
    y=m_y;
}
void Coordonnees::setX(int m){
    x= m;
}
void Coordonnees::setY(int m){
    y=m;
}
int Coordonnees::getX() const{
    return x;
}
int Coordonnees::getY() const{
    return y;
}

Coordonnees& Coordonnees:: operator=(const Coordonnees coord){
    this->x= coord.getX();
    this->y= coord.getY();
    return *this;
}


Coordonnees:: Coordonnees(const Coordonnees& coord,  string d){
    if (d=="haut"){
        this->x = coord.x - 1;
        this->y = coord.y;
    }
    if (d=="bas"){
        this->x = coord.x + 1;
        this->y = coord.y;
    }
    if (d=="gauche"){
        this->x = coord.x;
        this->y = coord.y - 1;
    }
    if (d=="droite"){
        this->x = coord.x;
        this->y = coord.y + 1;
    }
}
