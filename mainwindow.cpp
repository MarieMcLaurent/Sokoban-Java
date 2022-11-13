#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    string file = "../Projet_2021_2022_Sokoban_0.3/data/LVL/Niveau"+to_string(niveau)+".txt";
    cout << file<< endl;
    pl = new Plateau(file,1);
    this->repaint();
}

MainWindow::~MainWindow()
{
    delete ui;
    delete pl;
}

void MainWindow::paintEvent(QPaintEvent* e){
    QWidget::paintEvent(e);
    QPainter painter(this);
    pl->afficher_Plateau(&painter, perso);
}


void MainWindow::keyPressEvent ( QKeyEvent * event ) {
    int reponse;
    string line;
    switch(event->key())
    {
    case Qt::Key_Up :
        pl->deplacerPerso(pl->getPersonnage()->getPosition(),"haut");
    break;
    case Qt::Key_Down :
        pl->deplacerPerso(pl->getPersonnage()->getPosition(),"bas");
    break;
    case Qt::Key_Left :
        pl->deplacerPerso(pl->getPersonnage()->getPosition(),"gauche");
    break;
    case Qt::Key_Right :
        pl->deplacerPerso(pl->getPersonnage()->getPosition(),"droite");
    break;
    }
    this->repaint();
    if (pl->Niveau_terminee()==true){
        reponse= QMessageBox::question(this, "Titre de la fenêtre", "Bravo!! \n Niveau suivant?", QMessageBox::Yes | QMessageBox::No);
        if (reponse == QMessageBox::Yes)
        {

            hide();
            niveau++;
            gestionPlateau(niveau);
            show();
        }
        else if (reponse == QMessageBox::No){
            string file = "../Projet_2021_2022_Sokoban_0.3/data/LVL/level.txt";
            cout << file<< endl;
            ifstream fichier(file.c_str(), ios::in);
            int i =1;
            fichier>>line;
            if(!fichier.fail())
            {
                while (fichier.eof() == false and i!=niveau+1){
                    fichier>>line;
                    i++;
                }
                string msg ="Merci d'avoir joué.\n Pour accéder directement au niveau "+to_string(i)+"\n utilisez le code : "+line;
                QMessageBox mgb;
                mgb.setText(QString::fromStdString(msg));
                mgb.exec();

               }
            close();
        }
    }

}


void MainWindow::on_actionNouvelle_Partie_triggered()
{
    niveau=1;
    gestionPlateau(niveau);
    //this->repaint();
}

void MainWindow::gestionPlateau(int niveau){
    string file = "../Projet_2021_2022_Sokoban_0.3/data/LVL/Niveau"+to_string(niveau)+".txt";
    cout << file<< endl;
    pl = new Plateau(file,niveau);
    this->setFixedSize(pl->getLargeur()*50, 25+pl->getLongueur()*50);
    this->repaint();
}


void MainWindow::on_actionRecommencer_triggered()
{
    gestionPlateau(niveau);
    //this->repaint();
}

void MainWindow::setNiveau(int niv){
    niveau = niv;
}
int MainWindow::getNiveau(){
    return niveau;
}

void MainWindow::setDeco(int val){deco = val;}
void MainWindow::setPerso(int val){perso = val;}
