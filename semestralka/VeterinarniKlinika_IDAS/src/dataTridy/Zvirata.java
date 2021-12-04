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

    public Zvirata(int idZvirete, String jmeno, String datumNarozeni, double vaha, String poznamka, String cisloCipu, int idMajitele, int idPohlavi, int idDruhu, int idDoktora) {
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
    
    
}
