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
public class Leciva {
    int idLeku;
    String nazev;
    String datumExpirace;
    int pocetSkladem;
    String popis;
    int idDodavatele;

    public Leciva(int idLeku, String nazev, String datumExpirace, int pocetSkladem, String popis, int idDodavatele) {
        this.idLeku = idLeku;
        this.nazev = nazev;
        this.datumExpirace = datumExpirace;
        this.pocetSkladem = pocetSkladem;
        this.popis = popis;
        this.idDodavatele = idDodavatele;
    }

    public int getIdLeku() {
        return idLeku;
    }

    public void setIdLeku(int idLeku) {
        this.idLeku = idLeku;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getDatumExpirace() {
        return datumExpirace;
    }

    public void setDatumExpirace(String datumExpirace) {
        this.datumExpirace = datumExpirace;
    }

    public int getPocetSkladem() {
        return pocetSkladem;
    }

    public void setPocetSkladem(int pocetSkladem) {
        this.pocetSkladem = pocetSkladem;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public int getIdDodavatele() {
        return idDodavatele;
    }

    public void setIdDodavatele(int idDodavatele) {
        this.idDodavatele = idDodavatele;
    }
    
}
