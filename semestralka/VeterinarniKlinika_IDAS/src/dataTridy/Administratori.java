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
public class Administratori {
    int idAdministratora;
    String jmeno;
    String prijmeni;
    String datumNarozeni;
    String telefon;
    String email;
    int idAdresy;
    String prihlasovaciJmeno;
    String heslo;
    ComboBox<Adresy> adresy;

    public Administratori(int idAdministratora, String jmeno, String prijmeni, String datumNarozeni, String telefon, String email, int idAdresy, String prihlasovaciJmeno, String heslo, ComboBox<Adresy> adresy) {
        this.idAdministratora = idAdministratora;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.telefon = telefon;
        this.email = email;
        this.idAdresy = idAdresy;
        this.prihlasovaciJmeno = prihlasovaciJmeno;
        this.heslo = heslo;
        this.adresy = adresy;
    }

    public int getIdAdministratora() {
        return idAdministratora;
    }

    public void setIdAdministratora(int idAdministratora) {
        this.idAdministratora = idAdministratora;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdAdresy() {
        return idAdresy;
    }

    public void setIdAdresy(int idAdresy) {
        this.idAdresy = idAdresy;
    }

    public String getPrihlasovaciJmeno() {
        return prihlasovaciJmeno;
    }

    public void setPrihlasovaciJmeno(String prihlasovaciJmeno) {
        this.prihlasovaciJmeno = prihlasovaciJmeno;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public ComboBox<Adresy> getAdresy() {
        return adresy;
    }

    public void setAdresy(ComboBox<Adresy> adresy) {
        this.adresy = adresy;
    }
    
    
}
