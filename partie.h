#include "plateau.h"

#ifndef PARTIE_H
#define PARTIE_H


class Partie
{
private:
    int niveau;
    Plateau *PlateauP;
public:
    Partie(string file, int niveau);
    bool Niveau_terminee();
    int getNiveau();
    Plateau *getPlateauPartie();
    void recommencerNiveau();
    /*
    void setNiveau(int niv);

    //void configurer();
    //void AfficherAide();
    */
};

#endif // PARTIE_H
