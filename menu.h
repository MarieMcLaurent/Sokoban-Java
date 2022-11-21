#ifndef MENU_H
#define MENU_H

#include <mainwindow.h>
#include <QMainWindow>
#include <QFileDialog>
#include <QKeyEvent>
#include "mainwindow.h"
#include "aide.h"
#include "option.h"
/*!
 * \file menu.h
 * \brief Fenêtre d'affichage d'un menu d'accès au jeu Sokoban
 * \author Larange-Laurent
 * \version 0.4
 */
namespace Ui {
class Menu;
}

class Menu : public QMainWindow
{
    Q_OBJECT

public:
    explicit Menu(QWidget *parent = nullptr);
    ~Menu();
    void paintEvent(QPaintEvent* e);

private slots:
    void on_Jouer_clicked();

    void on_Quitter_clicked();

    void on_pushButton_clicked();

private:
    Ui::Menu *ui;
    MainWindow mainwindow;
    Aide aide;
    Option option;
};

#endif // MENU_H
