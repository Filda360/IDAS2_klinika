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
public class Adresy {
    int idAdresy;
    String ulice;
    String cisloPopisne;
    int idPosty;

    public Adresy(int idAdresy, String ulice, String cisloPopisne, int idPosty) {
        this.idAdresy = idAdresy;
        this.ulice = ulice;
        this.cisloPopisne = cisloPopisne;
        this.idPosty = idPosty;
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
    
    
    
}
