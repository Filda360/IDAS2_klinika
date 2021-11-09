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
public class Zakrok {
    private int id;
    private String datum;
    private String poznamka;
    private String jmeno;
    private String druh;
    private String pohlavi;
    private String datumNarozeni;
    private int vaha;
    private String zvirePoznamka;
    private String typOperace;
    private int delkaOperace;
    private String jmenoLekare;
    private String prijmeniLekare;

    public Zakrok(int id, String datum, String poznamka, String jmeno, String druh, String pohlavi, String datumNarozeni, int vaha, String zvirePoznamka, String typOperace, int delkaOperace, String jmenoLekare, String prijmeniLekare) {
        this.id = id;
        this.datum = datum;
        this.poznamka = poznamka;
        this.jmeno = jmeno;
        this.druh = druh;
        this.pohlavi = pohlavi;
        this.datumNarozeni = datumNarozeni;
        this.vaha = vaha;
        this.zvirePoznamka = zvirePoznamka;
        this.typOperace = typOperace;
        this.delkaOperace = delkaOperace;
        this.jmenoLekare = jmenoLekare;
        this.prijmeniLekare = prijmeniLekare;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setDruh(String druh) {
        this.druh = druh;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public void setVaha(int vaha) {
        this.vaha = vaha;
    }

    public void setZvirePoznamka(String zvirePoznamka) {
        this.zvirePoznamka = zvirePoznamka;
    }

    public void setTypOperace(String typOperace) {
        this.typOperace = typOperace;
    }

    public void setDelkaOperace(int delkaOperace) {
        this.delkaOperace = delkaOperace;
    }

    public void setJmenoLekare(String jmenoLekare) {
        this.jmenoLekare = jmenoLekare;
    }

    public void setPrijmeniLekare(String prijmeniLekare) {
        this.prijmeniLekare = prijmeniLekare;
    }

    public int getId() {
        return id;
    }

    public String getDatum() {
        return datum;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getDruh() {
        return druh;
    }

    public String getPohlavi() {
        return pohlavi;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public int getVaha() {
        return vaha;
    }

    public String getZvirePoznamka() {
        return zvirePoznamka;
    }

    public String getTypOperace() {
        return typOperace;
    }

    public int getDelkaOperace() {
        return delkaOperace;
    }

    public String getJmenoLekare() {
        return jmenoLekare;
    }

    public String getPrijmeniLekare() {
        return prijmeniLekare;
    }
    
}
