/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dataTridy.Adresy;
import dataTridy.Biochemie;
import javafx.scene.control.ComboBox;
import prihlasovani.Doktor;

/**
 *
 * @author tzlat
 */
public class ComboBoxy {
    ComboBox<Adresy> adresa;
    ComboBox<Doktor> doktor;

    public ComboBoxy(ComboBox<Adresy> adresa, ComboBox<Doktor> doktor) {
        this.adresa = adresa;
        this.doktor = doktor;
    }

    public ComboBox<Adresy> getAdresa() {
        return adresa;
    }

    public void setAdresa(ComboBox<Adresy> adresa) {
        this.adresa = adresa;
    }

    public ComboBox<Doktor> getDoktor() {
        return doktor;
    }

    public void setDoktor(ComboBox<Doktor> doktor) {
        this.doktor = doktor;
    }
    
}
