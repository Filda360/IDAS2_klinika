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
public class Doktori {
    int idDoktora;
    String titul;
    String delkaUvazku;
    String datumNastupu;
    double plat;
    String jmeno;
    String prijmeni;
    String datumNarozeni;
    String telefon;
    String email;
    int idAdresy;
    String heslo;
    String prihlasovaciJmeno;
    ComboBox<Adresy> adresy;

    public Doktori(int idDoktora, String titul, String delkaUvazku, String datumNastupu, double plat, String jmeno, String prijmeni, String datumNarozeni, String telefon, String email, int idAdresy, String heslo, String prihlasovaciJmeno, ComboBox<Adresy> adresy) {
        this.idDoktora = idDoktora;
        this.titul = titul;
        this.delkaUvazku = delkaUvazku;
        this.datumNastupu = datumNastupu;
        this.plat = plat;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.telefon = telefon;
        this.email = email;
        this.idAdresy = idAdresy;
        this.heslo = heslo;
        this.prihlasovaciJmeno = prihlasovaciJmeno;
        this.adresy = adresy;
    }

    public ComboBox<Adresy> getAdresy() {
        return adresy;
    }

    public void setAdresy(ComboBox<Adresy> adresy) {
        this.adresy = adresy;
    }

    

    public int getIdDoktora() {
        return idDoktora;
    }

    public void setIdDoktora(int idDoktora) {
        this.idDoktora = idDoktora;
    }

    public String getTitul() {
        return titul;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public String getDelkaUvazku() {
        return delkaUvazku;
    }

    public void setDelkaUvazku(String delkaUvazku) {
        this.delkaUvazku = delkaUvazku;
    }

    public String getDatumNastupu() {
        return datumNastupu;
    }

    public void setDatumNastupu(String datumNastupu) {
        this.datumNastupu = datumNastupu;
    }

    public double getPlat() {
        return plat;
    }

    public void setPlat(double plat) {
        this.plat = plat;
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

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }

    public String getPrihlasovaciJmeno() {
        return prihlasovaciJmeno;
    }

    public void setPrihlasovaciJmeno(String prihlasovaciJmeno) {
        this.prihlasovaciJmeno = prihlasovaciJmeno;
    }

    @Override
    public String toString() {
        return titul + " " + jmeno + " " + prijmeni;
    }
    
}
