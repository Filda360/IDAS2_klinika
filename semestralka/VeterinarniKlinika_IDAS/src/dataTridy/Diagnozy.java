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
public class Diagnozy {
    int idDiagnozy;
    String nazev;
    String oznaceni;
    int stupenZavaznosti;

    public Diagnozy(int idDiagnozy, String nazev, String oznaceni, int stupenZavaznosti) {
        this.idDiagnozy = idDiagnozy;
        this.nazev = nazev;
        this.oznaceni = oznaceni;
        this.stupenZavaznosti = stupenZavaznosti;
    }

    public void setIdDiagnozy(int idDiagnozy) {
        this.idDiagnozy = idDiagnozy;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setOznaceni(String oznaceni) {
        this.oznaceni = oznaceni;
    }

    public void setStupenZavaznosti(int stupenZavaznosti) {
        this.stupenZavaznosti = stupenZavaznosti;
    }

    public int getIdDiagnozy() {
        return idDiagnozy;
    }

    public String getNazev() {
        return nazev;
    }

    public String getOznaceni() {
        return oznaceni;
    }

    public int getStupenZavaznosti() {
        return stupenZavaznosti;
    }
    
    @Override
    public String toString() {
        return nazev+", "+oznaceni;
    }
}
