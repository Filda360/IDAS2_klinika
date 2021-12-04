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
public class Faktury {
    int idFaktury;
    String datumVystaveni;
    String datumSplatnosti;
    String stav;
    int idMajitele;
    int idTypu;

    public Faktury(int idFaktury, String datumVystaveni, String datumSplatnosti, String stav, int idMajitele, int idTypu) {
        this.idFaktury = idFaktury;
        this.datumVystaveni = datumVystaveni;
        this.datumSplatnosti = datumSplatnosti;
        this.stav = stav;
        this.idMajitele = idMajitele;
        this.idTypu = idTypu;
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
    
}
