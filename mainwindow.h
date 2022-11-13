#include "partie.h"
#include <QMainWindow>
#include <QFileDialog>
#include <QKeyEvent>
#include <QMessageBox>

#ifndef MAINWINDOW_H
#define MAINWINDOW_H
/*!
 * \file mainwindow.h
 * \brief Fenêtre principale jeu Sokoban
 * \author Larange-Laurent
 * \version 0.4
 */

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{

    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();
    void paintEvent(QPaintEvent* e);
    void keyPressEvent ( QKeyEvent * event);
    void gestionPlateau(int niveau);
    void setNiveau(int niv);
    int getNiveau();
    void setDeco(int val);
    void setPerso(int val);
private:
    Ui::MainWindow *ui;
    int niveau =1;
    Plateau *pl;
    int perso;
    int deco;

private slots:
    void on_actionNouvelle_Partie_triggered();
    void on_actionRecommencer_triggered();

};
#endif // MAINWINDOW_H
