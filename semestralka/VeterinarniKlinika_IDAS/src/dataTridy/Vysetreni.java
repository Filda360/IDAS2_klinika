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
public class Vysetreni {
    private int id;
    private String poznamka;
    private String datum;
    private String diagnoza;
    private int stupenZavaznosti;
    private String jmeno;
    private String druh;
    private String pohlavi;
    private String datumNarozeni;
    private int vaha;
    private String zvirePoznamka;
    private String jmenoLekare;
    private String prijmeniLekare;

    public Vysetreni(int id, String poznamka, String datum, String diagnoza, int stupenZavaznosti, String jmeno, String druh, String pohlavi, String datumNarozeni, int vaha, String zvirePoznamka, String jmenoLekare, String prijmeniLekare) {
        this.id = id;
        this.poznamka = poznamka;
        this.datum = datum;
        this.diagnoza = diagnoza;
        this.stupenZavaznosti = stupenZavaznosti;
        this.jmeno = jmeno;
        this.druh = druh;
        this.pohlavi = pohlavi;
        this.datumNarozeni = datumNarozeni;
        this.vaha = vaha;
        this.zvirePoznamka = zvirePoznamka;
        this.jmenoLekare = jmenoLekare;
        this.prijmeniLekare = prijmeniLekare;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setDiagnoza(String diagnoza) {
        this.diagnoza = diagnoza;
    }

    public void setStupenZavaznosti(int stupenZavaznosti) {
        this.stupenZavaznosti = stupenZavaznosti;
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

    public void setJmenoLekare(String jmenoLekare) {
        this.jmenoLekare = jmenoLekare;
    }

    public void setPrijmeniLekare(String prijmeniLekare) {
        this.prijmeniLekare = prijmeniLekare;
    }
    
    public int getId() {
        return id;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public String getDatum() {
        return datum;
    }

    public String getDiagnoza() {
        return diagnoza;
    }

    public int getStupenZavaznosti() {
        return stupenZavaznosti;
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

    public String getJmenoLekare() {
        return jmenoLekare;
    }

    public String getPrijmeniLekare() {
        return prijmeniLekare;
    }
    
}
