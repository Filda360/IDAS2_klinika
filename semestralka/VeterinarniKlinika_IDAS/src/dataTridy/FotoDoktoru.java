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
public class FotoDoktoru {
    int idFotky;
    String nazev;
    String typSouboru;
    String pripona;
    String datumNahrani;
    String obsah;
    int idDoktora;
    ComboBox<Doktori> doktori;

    public FotoDoktoru(int idFotky, String nazev, String typSouboru, String pripona, String datumNahrani, String obsah, int idDoktora, ComboBox<Doktori> doktori) {
        this.idFotky = idFotky;
        this.nazev = nazev;
        this.typSouboru = typSouboru;
        this.pripona = pripona;
        this.datumNahrani = datumNahrani;
        this.obsah = obsah;
        this.idDoktora = idDoktora;
        this.doktori = doktori;
    }

    public ComboBox<Doktori> getDoktori() {
        return doktori;
    }

    public void setDoktori(ComboBox<Doktori> doktori) {
        this.doktori = doktori;
    }

    public int getIdFotky() {
        return idFotky;
    }

    public void setIdFotky(int idFotky) {
        this.idFotky = idFotky;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getTypSouboru() {
        return typSouboru;
    }

    public void setTypSouboru(String typSouboru) {
        this.typSouboru = typSouboru;
    }

    public String getPripona() {
        return pripona;
    }

    public void setPripona(String pripona) {
        this.pripona = pripona;
    }

    public String getDatumNahrani() {
        return datumNahrani;
    }

    public void setDatumNahrani(String datumNahrani) {
        this.datumNahrani = datumNahrani;
    }

    public String getObsah() {
        return obsah;
    }

    public void setObsah(String obsah) {
        this.obsah = obsah;
    }

    public int getIdDoktora() {
        return idDoktora;
    }

    public void setIdDoktora(int idDoktora) {
        this.idDoktora = idDoktora;
    }
    
    @Override
    public String toString() {
        return nazev+pripona;
    }
}
