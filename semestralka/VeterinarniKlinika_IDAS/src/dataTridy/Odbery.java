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
public class Odbery {
    String datum;
    int idZvirete;
    int idOdberu;
    String poznamka;
    ComboBox<Zvirata> zvirata;

    public Odbery(String datum, int idZvirete, int idOdberu, String poznamka, ComboBox<Zvirata> zvirata) {
        this.datum = datum;
        this.idZvirete = idZvirete;
        this.idOdberu = idOdberu;
        this.poznamka = poznamka;
        this.zvirata = zvirata;
    }

    public ComboBox<Zvirata> getZvirata() {
        return zvirata;
    }

    public void setZvirata(ComboBox<Zvirata> zvirata) {
        this.zvirata = zvirata;
    }


    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getIdZvirete() {
        return idZvirete;
    }

    public void setIdZvirete(int idZvirete) {
        this.idZvirete = idZvirete;
    }

    public int getIdOdberu() {
        return idOdberu;
    }

    public void setIdOdberu(int idOdberu) {
        this.idOdberu = idOdberu;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }
    @Override
    public String toString() {
        return datum;
    }
}
