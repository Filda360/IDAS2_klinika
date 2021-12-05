/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dataTridy.Adresy;
import dataTridy.Biochemie;
import dataTridy.Posty;
import javafx.scene.control.ComboBox;
import prihlasovani.Doktor;

/**
 *
 * @author tzlat
 */
public class ComboBoxy {
    ComboBox<Adresy> adresa;
    ComboBox<Doktor> doktor;
    ComboBox<Posty> posta;

    public ComboBoxy(ComboBox<Adresy> adresa, ComboBox<Doktor> doktor, ComboBox<Posty> posta) {
        this.adresa = adresa;
        this.doktor = doktor;
        this.posta = posta;
    }

    public ComboBox<Posty> getPosta() {
        return posta;
    }

    public void setPosta(ComboBox<Posty> posta) {
        this.posta = posta;
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
