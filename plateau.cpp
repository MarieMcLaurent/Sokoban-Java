#include "plateau.h"

Plateau:: Plateau(string file, int x, int y): Coordonnees(x,y)
{
    string line;
    char temp;
    //int CaisseX=0, CaisseY=0;
    //int PersoX, PersoY;
    string useless;
    ifstream fichier(file.c_str(), ios::in);
    if(!fichier.fail())
    {
        while (fichier.eof() == false)
        {
            fichier>>longueur>>largeur>>nbCaisse;
            for (int i=0; i<longueur;i++){
                vector<Case*> tempC;
                for (int j=0; j<largeur;j++){
                    fichier>>temp;
                    switch(temp){
                        case '#' : tempC.push_back(new Case_Mur); break;
                        case '_' : tempC.push_back(new Case_Vide); break;
                        case '.' : tempC.push_back(new Case_Marquee);break;
                        case '@' : PersoSurPlateau = new Personnage(i, j);
                        tempC.push_back(new Case_Vide); break;
                        case '+' : PersoSurPlateau = new Personnage(i, j);
                        tempC.push_back(new Case_Marquee);break;
                        case '$' : ListeCaisse.push_back(new Caisse(i, j, false));
                        tempC.push_back(new Case_Vide); break;
                        case '*' : ListeCaisse.push_back(new Caisse(i, j, false));
                        tempC.push_back(new Case_Marquee);break;
                    }
                }
                GrillePlateau.push_back(tempC);
            }
            /*for (int i=0; i<nbCaisse;i++){
                fichier>>CaisseX>>CaisseY;
                if (GrillePlateau[CaisseX][CaisseY]->getType()==2){
                   ListeCaisse.push_back(new Caisse(CaisseX, CaisseY, true));
                }
                else{
                    ListeCaisse.push_back(new Caisse(CaisseX, CaisseY, false));

                }
            }
            fichier>>PersoX>>PersoY;
            PersoSurPlateau = new Personnage(PersoX, PersoY);*/
        }
    }
    else {
        cout << "Unable to open file";
    }
    fichier.close();

}
/*
Plateau:: Plateau(int x, int y): Coordonnees(x,y)
{

    longueur = 3;
    largeur = 5;
    nbCaisse = 1;

    for(int i=0; i<3;i++){
        vector<Case*> tempC;
        for(int j=0;j<5;j++){
            if ((i==0) || (i==2)){
                tempC.push_back(new Case_Mur);
            }
            else{
                if ((j==0) || (j==4)){
                    tempC.push_back(new Case_Mur);
                }
                else{
                    if (j==3)
                        tempC.push_back(new Case_Marquee);
                    else
                        tempC.push_back(new Case_Vide);
                }
            }
        }
        GrillePlateau.push_back(tempC);

    }
    for(int i=0; i<nbCaisse;i++){
        ListeCaisse.push_back(new Caisse(1, 2, true));
    }

    PersoSurPlateau = new Personnage(1, 1);

}
*/
Plateau::~Plateau(){
    //delete PersoSurPlateau;

}

int Plateau:: getNbCaisse(){
    return nbCaisse;
}

vector<Caisse*> Plateau::getListeCaisse(){
    return ListeCaisse;
}
void Plateau:: afficher_Plateau(QPainter *p,int perso){

    for(int i=0; i<longueur;i++){
        for(int j=0; j<largeur;j++){
            GrillePlateau[i][j]->afficher_case(p,i,j);
        }
    }
    for(int i=0; i<nbCaisse;i++){
        ListeCaisse[i]->afficher_caisse(p);
    }
    PersoSurPlateau->afficher_perso(p, perso);

}


Personnage * Plateau::getPersonnage(){
    return PersoSurPlateau;
}


int Plateau:: getLongueur(){
    return longueur;
}
int Plateau:: getLargeur(){
    return largeur;
}


Caisse *Plateau::getCaisse(Coordonnees Coord){
    for (int i=0; i<nbCaisse;i++){
        if ((ListeCaisse[i]->getX() == Coord.getX()) && (ListeCaisse[i]->getY() == Coord.getY())){
            return ListeCaisse[i];
        }
    }
    return nullptr;
    /*
    cout << "Erreur: Pas de caisse avec ses coordonnées trouvés";
    return *ListeCaisse[nbCaisse-1]; // Rajouter des exceptions
    */
}


// String d --> touche du clavier flèche
void Plateau::updateCoordonneesC(Coordonnees CoordC, string d){
    if ((d=="haut") && (CoordC.getX()>0))
        getCaisse(CoordC)->setX(CoordC.getX() - 1);
    if ((d=="bas")&&(CoordC.getX()< longueur-1))
        getCaisse(CoordC)->setX(CoordC.getX() + 1);
    if ((d=="gauche")&&(CoordC.getY()>0))
        getCaisse(CoordC)->setY(CoordC.getY() - 1);
    if ((d=="droite")&&(CoordC.getY()<largeur-1))
        getCaisse(CoordC)->setY(CoordC.getY() + 1);
}


void Plateau::updateCoordonneesP(Coordonnees CoordP, string d){
    if ((d=="haut") && (CoordP.getX()>0))
        PersoSurPlateau->setX(CoordP.getX() - 1);
    if ((d=="bas") && (CoordP.getX()< longueur-1))
        PersoSurPlateau->setX(CoordP.getX() + 1);
    if ((d=="gauche") &&(CoordP.getY()>0))
        PersoSurPlateau->setY(CoordP.getY()-1);
    if ((d=="droite") &&(CoordP.getY()<largeur - 1))
        PersoSurPlateau->setY(CoordP.getY() + 1);
}


void Plateau::deplacerPerso(Coordonnees coordP, string d){
    int type = this->verifierPosition(coordP,d);
    if(type == 2 || type == 1){
        this->updateCoordonneesP(coordP,d);
    }
    if (type == 4){ // il y a une caisse
        Coordonnees coordC(coordP,d);
        if (this->deplacerCaisse(coordC,d)==true){
            this->updateCoordonneesP(coordP,d);
        }
    }
}


int Plateau:: verifierPosition(Coordonnees coord, string d){
    Coordonnees *temp;
    if (d=="haut"){
        temp = new Coordonnees(coord.getX()-1, coord.getY());
        if (getCaisse(*temp)!=nullptr) // il y a une caisse
            return 4;
        else
        {
            return GrillePlateau[temp->getX()][temp->getY()]->getType();
        }
    }
    if (d=="bas"){
        temp = new Coordonnees(coord.getX()+1, coord.getY());
        if (getCaisse(*temp)!=nullptr) // il y a une caisse
            return 4;
        else
        {
            return GrillePlateau[temp->getX()][temp->getY()]->getType();
        }
    }
    if (d=="gauche"){
        temp = new Coordonnees(coord.getX(), coord.getY()-1);
        if (getCaisse(*temp)!=nullptr) // il y a une caisse
            return 4;
        else
        {
            return GrillePlateau[temp->getX()][temp->getY()]->getType();
        }
    }
    if (d=="droite"){
        temp = new Coordonnees(coord.getX(), coord.getY()+1);
        if (getCaisse(*temp)!=nullptr) // il y a une caisse
            return 4;
        else
        {
            return GrillePlateau[temp->getX()][temp->getY()]->getType();
        }
    }
}

bool Plateau::deplacerCaisse(Coordonnees coordC, string d){
    int type = this->verifierPosition(coordC,d);
    Caisse *c = this->getCaisse(coordC);
    if(type == 1){
        this->updateCoordonneesC(coordC,d);
        if(c->getEtat()==true){
            c->ChangementCouleur();
        }
        return true;

    }
    else
    {
        if (type == 2){
            this->updateCoordonneesC(coordC,d);
            if(c->getEtat()==false){
                c->ChangementCouleur();
            }
            return true;
        }
        else {
            return false;
        }
    }
}


bool Plateau:: Niveau_terminee(){
    int nbCaisse_marquee = 0;

    for(int i=0;i<nbCaisse;i++){
        if (ListeCaisse[i]->getEtat()==true){
            nbCaisse_marquee++;
        }
    }
    if (nbCaisse_marquee==nbCaisse){
        return true;
    }
    return false;
}

