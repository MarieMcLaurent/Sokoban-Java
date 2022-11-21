#ifndef OPTION_H
#define OPTION_H

#include <string>
#include <QDialog>
/*!
 * \file option.h
 * \brief Fenêtre de choix d'options visuels du jeu Sokoban
 * \author Larange-Laurent
 * \version 0.3
 */
using namespace std;
namespace Ui {
class Option;
}

class Option : public QDialog
{
    Q_OBJECT

public:
    explicit Option(QWidget *parent = nullptr);
    ~Option();
    int getPerso();
    int getDeco();

private slots:
    void on_buttonBox_accepted();

private:
    Ui::Option *ui;
    int perso=0;
    int deco=0;
};

#endif // OPTION_H
