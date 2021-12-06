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
public class Zvirata {
    int idZvirete;
    String jmeno;
    String datumNarozeni;
    double vaha;
    String poznamka;
    String cisloCipu;
    int idMajitele;
    int idPohlavi;
    int idDruhu;
    int idDoktora;
    ComboBox<Majitele> majitele;
    ComboBox<Pohlavi> pohlavi;
    ComboBox<Druhy> druhy;
    ComboBox<Doktori> doktori;

    public Zvirata(int idZvirete, String jmeno, String datumNarozeni, double vaha, 
            String poznamka, String cisloCipu, int idMajitele, int idPohlavi, 
            int idDruhu, int idDoktora, ComboBox<Majitele> majitele, ComboBox<Pohlavi> pohlavi,
            ComboBox<Druhy> druhy, ComboBox<Doktori> doktori) {
        this.idZvirete = idZvirete;
        this.jmeno = jmeno;
        this.datumNarozeni = datumNarozeni;
        this.vaha = vaha;
        this.poznamka = poznamka;
        this.cisloCipu = cisloCipu;
        this.idMajitele = idMajitele;
        this.idPohlavi = idPohlavi;
        this.idDruhu = idDruhu;
        this.idDoktora = idDoktora;
        this.majitele = majitele;
        this.pohlavi = pohlavi;
        this.druhy = druhy;
        this.doktori = doktori;
    }

    public ComboBox<Majitele> getMajitele() {
        return majitele;
    }

    public void setMajitele(ComboBox<Majitele> majitele) {
        this.majitele = majitele;
    }

    public ComboBox<Pohlavi> getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(ComboBox<Pohlavi> pohlavi) {
        this.pohlavi = pohlavi;
    }

    public ComboBox<Druhy> getDruhy() {
        return druhy;
    }

    public void setDruhy(ComboBox<Druhy> druhy) {
        this.druhy = druhy;
    }

    public ComboBox<Doktori> getDoktori() {
        return doktori;
    }

    public void setDoktori(ComboBox<Doktori> doktori) {
        this.doktori = doktori;
    }

    

    public int getIdZvirete() {
        return idZvirete;
    }

    public void setIdZvirete(int idZvirete) {
        this.idZvirete = idZvirete;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public double getVaha() {
        return vaha;
    }

    public void setVaha(double vaha) {
        this.vaha = vaha;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public String getCisloCipu() {
        return cisloCipu;
    }

    public void setCisloCipu(String cisloCipu) {
        this.cisloCipu = cisloCipu;
    }

    public int getIdMajitele() {
        return idMajitele;
    }

    public void setIdMajitele(int idMajitele) {
        this.idMajitele = idMajitele;
    }

    public int getIdPohlavi() {
        return idPohlavi;
    }

    public void setIdPohlavi(int idPohlavi) {
        this.idPohlavi = idPohlavi;
    }

    public int getIdDruhu() {
        return idDruhu;
    }

    public void setIdDruhu(int idDruhu) {
        this.idDruhu = idDruhu;
    }

    public int getIdDoktora() {
        return idDoktora;
    }

    public void setIdDoktora(int idDoktora) {
        this.idDoktora = idDoktora;
    }

    @Override
    public String toString() {
        return jmeno + ", " + datumNarozeni;
    }
    
    
}
