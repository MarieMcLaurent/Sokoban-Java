#include <string>
using namespace std;
/// Class Coordonnees
///
#ifndef COORDONNEES_H
#define COORDONNEES_H
/*!
 * \file coordonnees.h
 * \brief Position dans l'espace des objets du jeu Sokoban
 * \author Larange-Laurent
 * \version 0.1
 */
class Coordonnees
{
private:
    int x;
    int y;
public:
    Coordonnees(int m_x, int m_y);
    Coordonnees(const Coordonnees& coord, string d);
    void setX(int m);
    void setY(int m);
    int getX() const;
    int getY() const;
    Coordonnees& operator=(const Coordonnees coord);
};

#endif // COORDONNEES_H
