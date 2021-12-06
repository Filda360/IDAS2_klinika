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
    int id;
    String tabulka;
    String operace;
    String cas;
    String uzivatel;
    int typUzivatele;

    public LogTable(String tabulka, String operace, String cas, String uzivatel, int id, int typUzivatele) {
        this.tabulka = tabulka;
        this.operace = operace;
        this.cas = cas;
        this.uzivatel = uzivatel;
        this.id = id;
        this.typUzivatele = typUzivatele;
    }

    public String getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(String uzivatel) {
        this.uzivatel = uzivatel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypUzivatele() {
        return typUzivatele;
    }

    public void setTypUzivatele(int typUzivatele) {
        this.typUzivatele = typUzivatele;
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
    
    @Override
    public String toString() {
        return cas+", "+tabulka;
    }
}
