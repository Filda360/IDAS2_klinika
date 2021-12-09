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
public class Zpravy {
    int idZpravy;
    int idPrijemce;
    String prijemce;
    int idOdesilatele;
    String odesilatel;
    String text;
    int typPrijemce;
    int typOdesilatele;

    public Zpravy(int idZpravy, int idPrijemce, String prijemce, int idOdesilatele, String odesilatel, String text, int typPrijemce,int typOdesilatele) {
        this.idZpravy = idZpravy;
        this.idPrijemce = idPrijemce;
        this.typPrijemce = typPrijemce;
        this.prijemce = prijemce;
        this.idOdesilatele = idOdesilatele;
        this.typOdesilatele = typOdesilatele;
        this.odesilatel = odesilatel;
        this.text = text;
    }

    public int getTypPrijemce() {
        return typPrijemce;
    }

    public void setTypPrijemce(int typPrijemce) {
        this.typPrijemce = typPrijemce;
    }

    public int getTypOdesilatele() {
        return typOdesilatele;
    }

    public void setTypOdesilatele(int typOdesilatele) {
        this.typOdesilatele = typOdesilatele;
    }

    

    public int getIdZpravy() {
        return idZpravy;
    }

    public void setIdZpravy(int idZpravy) {
        this.idZpravy = idZpravy;
    }

    public int getIdPrijemce() {
        return idPrijemce;
    }

    public void setIdPrijemce(int idPrijemce) {
        this.idPrijemce = idPrijemce;
    }

    public String getPrijemce() {
        return prijemce;
    }

    public void setPrijemce(String prijemce) {
        this.prijemce = prijemce;
    }

    public int getIdOdesilatele() {
        return idOdesilatele;
    }

    public void setIdOdesilatele(int idOdesilatele) {
        this.idOdesilatele = idOdesilatele;
    }

    public String getOdesilatel() {
        return odesilatel;
    }

    public void setOdesilatel(String odesilatel) {
        this.odesilatel = odesilatel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
