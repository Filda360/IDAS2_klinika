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
    int idVysetreni;
    String datum;
    String poznamka;
    int idDiagnozy;
    int idZvirete;

    public Vysetreni(int idVysetreni, String datum, String poznamka, int idDiagnozy, int idZvirete) {
        this.idVysetreni = idVysetreni;
        this.datum = datum;
        this.poznamka = poznamka;
        this.idDiagnozy = idDiagnozy;
        this.idZvirete = idZvirete;
    }

    public int getIdVysetreni() {
        return idVysetreni;
    }

    public void setIdVysetreni(int idVysetreni) {
        this.idVysetreni = idVysetreni;
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

    public int getIdDiagnozy() {
        return idDiagnozy;
    }

    public void setIdDiagnozy(int idDiagnozy) {
        this.idDiagnozy = idDiagnozy;
    }

    public int getIdZvirete() {
        return idZvirete;
    }

    public void setIdZvirete(int idZvirete) {
        this.idZvirete = idZvirete;
    }
    
}
