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
public class Adresy {
    int idAdresy;
    String ulice;
    String cisloPopisne;
    int idPosty;
    ComboBox<Posty> posty;

    public Adresy(int idAdresy, String ulice, String cisloPopisne, int idPosty, ComboBox<Posty> posty) {
        this.idAdresy = idAdresy;
        this.ulice = ulice;
        this.cisloPopisne = cisloPopisne;
        this.idPosty = idPosty;
        this.posty = posty;
    }

    public ComboBox<Posty> getPosty() {
        return posty;
    }

    public void setPosty(ComboBox<Posty> posty) {
        this.posty = posty;
    }

    public void setIdAdresy(int idAdresy) {
        this.idAdresy = idAdresy;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public void setCisloPopisne(String cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }

    public void setIdPosty(int idPosty) {
        this.idPosty = idPosty;
    }

    public int getIdAdresy() {
        return idAdresy;
    }

    public String getUlice() {
        return ulice;
    }

    public String getCisloPopisne() {
        return cisloPopisne;
    }

    public int getIdPosty() {
        return idPosty;
    }

    @Override
    public String toString() {
        return ulice + ", " + cisloPopisne;
    }  
}
