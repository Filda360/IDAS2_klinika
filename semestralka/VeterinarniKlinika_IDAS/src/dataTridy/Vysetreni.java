/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTridy;

import javafx.scene.control.ComboBox;

/**
 *
 * @author tzlat
 */
public class Vysetreni {
    int idVysetreni;
    String datum;
    String poznamka;
    int idDiagnozy;
    int idZvirete;
    ComboBox<Diagnozy> diagnozy;
    ComboBox<Zvirata> zvirata;

    public Vysetreni(int idVysetreni, String datum, String poznamka, int idDiagnozy, int idZvirete, ComboBox<Diagnozy> diagnozy, ComboBox<Zvirata> zvirata) {
        this.idVysetreni = idVysetreni;
        this.datum = datum;
        this.poznamka = poznamka;
        this.idDiagnozy = idDiagnozy;
        this.idZvirete = idZvirete;
        this.diagnozy = diagnozy;
        this.zvirata = zvirata;
    }

    public ComboBox<Diagnozy> getDiagnozy() {
        return diagnozy;
    }

    public void setDiagnozy(ComboBox<Diagnozy> diagnozy) {
        this.diagnozy = diagnozy;
    }

    public ComboBox<Zvirata> getZvirata() {
        return zvirata;
    }

    public void setZvirata(ComboBox<Zvirata> zvirata) {
        this.zvirata = zvirata;
    }


    public int getIdVysetreni() {
        return idVysetreni;
    }

    public void setIdVysetreni(int idVysetreni) {
        this.idVysetreni = idVysetreni;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public int getIdDiagnozy() {
        return idDiagnozy;
    }

    public void setIdDiagnozy(int idDiagnozy) {
        this.idDiagnozy = idDiagnozy;
    }

    public int getIdZvirete() {
        return idZvirete;
    }

    public void setIdZvirete(int idZvirete) {
        this.idZvirete = idZvirete;
    }
    @Override
    public String toString() {
        return datum;
    }
}
