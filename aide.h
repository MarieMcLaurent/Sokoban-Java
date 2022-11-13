#ifndef AIDE_H
#define AIDE_H

#include <QMainWindow>
/*!
 * \file aide.h
 * \brief Fenêtre d'aide du jeu Sokoban
 * \author Larange-Laurent
 * \version 0.3
 */
namespace Ui {
class Aide;
}

class Aide : public QMainWindow
{
    Q_OBJECT

public:
    explicit Aide(QWidget *parent = nullptr);
    void paintEvent(QPaintEvent* e);
    ~Aide();

private:
    Ui::Aide *ui;
};

#endif // AIDE_H
