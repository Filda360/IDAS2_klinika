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
public class Dodavatele {
    int idDodavatele;
    String nazev;
    String telefon;
    String email;
    int idAdresy;
    ComboBox<Adresy> adresy;

    public Dodavatele(int idDodavatele, String nazev, String telefon, String email, int idAdresy,ComboBox<Adresy> adresy) {
        this.idDodavatele = idDodavatele;
        this.nazev = nazev;
        this.telefon = telefon;
        this.email = email;
        this.idAdresy = idAdresy;
        this.adresy=adresy;
    }

    public ComboBox<Adresy> getAdresy() {
        return adresy;
    }

    public void setAdresy(ComboBox<Adresy> adresy) {
        this.adresy = adresy;
    }

    public void setIdDodavatele(int idDodavatele) {
        this.idDodavatele = idDodavatele;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdAdresy(int idAdresy) {
        this.idAdresy = idAdresy;
    }

    public int getIdDodavatele() {
        return idDodavatele;
    }

    public String getNazev() {
        return nazev;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public int getIdAdresy() {
        return idAdresy;
    }
    
}
