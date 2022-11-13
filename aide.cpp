#include "aide.h"
#include "ui_aide.h"
#include <QPainter>
Aide::Aide(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Aide)
{
    ui->setupUi(this);
}

Aide::~Aide()
{
    delete ui;
}

void Aide::paintEvent(QPaintEvent* e){
    QWidget::paintEvent(e);
    QPainter painter(this);
    painter.drawPixmap(0,0,1280,720, QPixmap(":/images/data/PNG/aide_Sokoban.png"));
}
