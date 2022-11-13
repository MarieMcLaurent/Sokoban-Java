#include "partie.h"

Partie:: Partie(string file, int niveau){
    PlateauP = new Plateau(file, 0, 0);
    niveau = 0;
}

bool Partie:: Niveau_terminee(){
    int nbCaisse_marquee = 0;
    int nbCaisse = PlateauP->getNbCaisse();
    for(int i=0;i<nbCaisse;i++){
        if (PlateauP->getListeCaisse()[i]->getEtat()==true){
            nbCaisse_marquee++;
        }
    }
    if (nbCaisse_marquee==nbCaisse){
        return true;
    }
    return false;
}


Plateau * Partie::getPlateauPartie(){
    return PlateauP;
}

void Partie::recommencerNiveau(){

}
