#include "menu.h"
#include "ui_menu.h"
#include <QPainter>
#include <QMessageBox>
#include <QInputDialog>
Menu::Menu(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Menu)
{
    ui->setupUi(this);
}

Menu::~Menu()
{
    delete ui;
}


void Menu::paintEvent(QPaintEvent* e){
    QWidget::paintEvent(e);
    QPainter painter(this);
    painter.drawPixmap(0,0,400,225, QPixmap(":/images/data/PNG/logo.jpeg"));
}


void Menu::on_Jouer_clicked()
{
    int reponse, reponse2, reponse3,reponse4;
    string line;
    mainwindow.setPerso(option.getPerso());
    mainwindow.setDeco(option.getDeco());
    reponse= QMessageBox::question(this, "Titre de la fenêtre", "Avez vous déjà au sokoban?", QMessageBox::Yes | QMessageBox::No);
    if (reponse == QMessageBox::Yes)
    {
        reponse2  = QMessageBox::question(this, "Titre de la fenêtre", "Première partie?", QMessageBox::Yes | QMessageBox::No);
        if (reponse2 == QMessageBox::Yes)
        {
            hide();
            mainwindow.gestionPlateau(1);
            mainwindow.show();
        }
        else if (reponse2 == QMessageBox::No){
            bool ok;
            QString text = QInputDialog::getText(this, tr("Recherche du niveau"),tr("Code niveau:"), QLineEdit::Normal,"Stays", &ok);
            if (ok && !text.isEmpty()){
                ok = false;
                reponse3 = 0;
                string file = "../Projet_2021_2022_Sokoban_0.3/data/LVL/level.txt";
                cout << file<< endl;
                cout <<  text.toStdString() << endl;
                ifstream fichier(file.c_str(), ios::in);
                if(!fichier.fail())
                {
                    while (fichier.eof() == false and !ok){
                        fichier>>line;
                        ok = (text.toStdString() == line);
                        reponse3++;
                    }
                    if (ok){
                        hide();
                        mainwindow.setNiveau(reponse3);
                        mainwindow.gestionPlateau(reponse3);
                        mainwindow.show();
                    }
                    else {
                        reponse4 = QMessageBox::warning(this, "Code erroné", "Renvoi premier niveau");
                        hide();
                        mainwindow.gestionPlateau(1);
                        mainwindow.show();
                    }
                }
            }
        }
    }
    else if (reponse == QMessageBox::No)
    {
       aide.show();
    }
    //hide();
    //gn.show();
}

void Menu::on_Quitter_clicked()
{
    close();
}

void Menu::on_pushButton_clicked()
{

    option.show();
}
