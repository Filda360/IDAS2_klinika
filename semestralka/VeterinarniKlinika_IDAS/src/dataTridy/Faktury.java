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
public class Faktury {
    int idFaktury;
    String datumVystaveni;
    String datumSplatnosti;
    String stav;
    int idMajitele;
    int idTypu;
    ComboBox<Majitele> majitele;
    ComboBox<TypyPlatby> typy;

    public Faktury(int idFaktury, String datumVystaveni, String datumSplatnosti, String stav, int idMajitele, int idTypu, ComboBox<Majitele> majitele, ComboBox<TypyPlatby> typy) {
        this.idFaktury = idFaktury;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.stav = stav;
        this.idMajitele = idMajitele;
        this.idTypu = idTypu;
        this.majitele = majitele;
        this.typy = typy;
    }

    public ComboBox<Majitele> getMajitele() {
        return majitele;
    }

    public void setMajitele(ComboBox<Majitele> majitele) {
        this.majitele = majitele;
    }

    public ComboBox<TypyPlatby> getTypy() {
        return typy;
    }

    public void setTypy(ComboBox<TypyPlatby> typy) {
        this.typy = typy;
    }

    

    public int getIdFaktury() {
        return idFaktury;
    }

    public void setIdFaktury(int idFaktury) {
        this.idFaktury = idFaktury;
    }

    public String getDatumVystaveni() {
        return datumVystaveni;
    }

    public void setDatumVystaveni(String datumVystaveni) {
        this.datumVystaveni = datumVystaveni;
    }

    public String getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(String datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    public String getStav() {
        return stav;
    }

    public void setStav(String stav) {
        this.stav = stav;
    }

    public int getIdMajitele() {
        return idMajitele;
    }

    public void setIdMajitele(int idMajitele) {
        this.idMajitele = idMajitele;
    }

    public int getIdTypu() {
        return idTypu;
    }

    public void setIdTypu(int idTypu) {
        this.idTypu = idTypu;
    }
    
    @Override
    public String toString() {
        return datumVystaveni+" - "+ datumSplatnosti+" ("+stav+")";
    }
}
