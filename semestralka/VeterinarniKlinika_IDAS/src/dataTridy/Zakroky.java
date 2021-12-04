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
public class Zakroky {
    int idZakroku;
    String datum;
    String poznamka;
    int idZvirete;
    int idOperace;

    public Zakroky(int idZakroku, String datum, String poznamka, int idZvirete, int idOperace) {
        this.idZakroku = idZakroku;
        this.datum = datum;
        this.poznamka = poznamka;
        this.idZvirete = idZvirete;
        this.idOperace = idOperace;
    }

    public int getIdZakroku() {
        return idZakroku;
    }

    public void setIdZakroku(int idZakroku) {
        this.idZakroku = idZakroku;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public int getIdZvirete() {
        return idZvirete;
    }

    public void setIdZvirete(int idZvirete) {
        this.idZvirete = idZvirete;
    }

    public int getIdOperace() {
        return idOperace;
    }

    public void setIdOperace(int idOperace) {
        this.idOperace = idOperace;
    }
    
}
