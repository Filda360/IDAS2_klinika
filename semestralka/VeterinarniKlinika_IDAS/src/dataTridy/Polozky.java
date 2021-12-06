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
public class Polozky {
    int idPolozky;
    String nazev;
    int pocet;
    int cena;
    int idFaktury;
    ComboBox<Faktury> faktury;

    public Polozky(int idPolozky, String nazev, int pocet, int cena, int idFaktury, ComboBox<Faktury> faktury) {
        this.idPolozky = idPolozky;
        this.nazev = nazev;
        this.pocet = pocet;
        this.cena = cena;
        this.idFaktury = idFaktury;
        this.faktury = faktury;
    }

    public ComboBox<Faktury> getFaktury() {
        return faktury;
    }

    public void setFaktury(ComboBox<Faktury> faktury) {
        this.faktury = faktury;
    }

    public int getIdPolozky() {
        return idPolozky;
    }

    public void setIdPolozky(int idPolozky) {
        this.idPolozky = idPolozky;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getIdFaktury() {
        return idFaktury;
    }

    public void setIdFaktury(int idFaktury) {
        this.idFaktury = idFaktury;
    }
    @Override
    public String toString() {
        return nazev+" ("+pocet+")";
    }
}
