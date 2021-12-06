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
public class Objednavky {
    int idObjednavky;
    String pricina;
    String termin;
    int idMajitele;
    ComboBox<Majitele> majitele;

    public Objednavky(int idObjednavky, String pricina, String termin, int idMajitele, ComboBox<Majitele> majitele) {
        this.idObjednavky = idObjednavky;
        this.pricina = pricina;
        this.termin = termin;
        this.idMajitele = idMajitele;
        this.majitele = majitele;
    }

    public ComboBox<Majitele> getMajitele() {
        return majitele;
    }

    public void setMajitele(ComboBox<Majitele> majitele) {
        this.majitele = majitele;
    }

    public int getIdObjednavky() {
        return idObjednavky;
    }

    public void setIdObjednavky(int idObjednavky) {
        this.idObjednavky = idObjednavky;
    }

    public String getPricina() {
        return pricina;
    }

    public void setPricina(String pricina) {
        this.pricina = pricina;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public int getIdMajitele() {
        return idMajitele;
    }

    public void setIdMajitele(int idMajitele) {
        this.idMajitele = idMajitele;
    }
    
    @Override
    public String toString() {
        return pricina+", "+termin;
    }
}
