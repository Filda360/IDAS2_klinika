/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTridy;

/**
 *
 * @author tzlat
 */
public class Operace {
    int idOperace;
    String nazev;
    String oznaceni;
    double delka;
    String riziko;

    public Operace(int idOperace, String nazev, String oznaceni, double delka, String riziko) {
        this.idOperace = idOperace;
        this.nazev = nazev;
        this.oznaceni = oznaceni;
        this.delka = delka;
        this.riziko = riziko;
    }

    public int getIdOperace() {
        return idOperace;
    }

    public void setIdOperace(int idOperace) {
        this.idOperace = idOperace;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getOznaceni() {
        return oznaceni;
    }

    public void setOznaceni(String oznaceni) {
        this.oznaceni = oznaceni;
    }

    public double getDelka() {
        return delka;
    }

    public void setDelka(double delka) {
        this.delka = delka;
    }

    public String getRiziko() {
        return riziko;
    }

    public void setRiziko(String riziko) {
        this.riziko = riziko;
    }
    @Override
    public String toString() {
        return nazev+" ("+oznaceni+")";
    }
}
