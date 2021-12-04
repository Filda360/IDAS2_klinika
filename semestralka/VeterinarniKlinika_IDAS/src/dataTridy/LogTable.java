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
public class LogTable {
    String tabulka;
    String operace;
    String cas;
    String uzivatel;

    public LogTable(String tabulka, String operace, String cas, String uzivatel) {
        this.tabulka = tabulka;
        this.operace = operace;
        this.cas = cas;
        this.uzivatel = uzivatel;
    }

    public String getTabulka() {
        return tabulka;
    }

    public void setTabulka(String tabulka) {
        this.tabulka = tabulka;
    }

    public String getOperace() {
        return operace;
    }

    public void setOperace(String operace) {
        this.operace = operace;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(String uzivatel) {
        this.uzivatel = uzivatel;
    }
    
}
