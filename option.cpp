#include "option.h"
#include "ui_option.h"

Option::Option(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::Option)
{
    ui->setupUi(this);
    ui->comboBox->addItem("Luigi");
    ui->comboBox->addItem("Mario");
    ui->comboBox->addItem("Wario");
    ui->comboBox->addItem("Bowser");
}

Option::~Option()
{
    delete ui;
}

void Option::on_buttonBox_accepted()
{
    QString choix = ui->comboBox->currentText();
    if (choix=="Luigi") perso = 0;
    else
        if (choix=="Mario") perso=1;
        else
            if (choix=="Wario") perso = 2;
}

int Option:: getPerso(){
    return perso;
}
int Option:: getDeco(){
    return deco;
}
