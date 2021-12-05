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
public class Posty {
    int idPosty;
    String mesto;
    String PSC;

    public Posty(int idPosty, String mesto, String PSC) {
        this.idPosty = idPosty;
        this.mesto = mesto;
        this.PSC = PSC;
    }

    public int getIdPosty() {
        return idPosty;
    }

    public void setIdPosty(int idPosty) {
        this.idPosty = idPosty;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPSC() {
        return PSC;
    }

    public void setPSC(String PSC) {
        this.PSC = PSC;
    }
    @Override
    public String toString() {
        return mesto + ", " + PSC;
    }  
}
