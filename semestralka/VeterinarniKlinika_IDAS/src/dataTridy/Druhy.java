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
public class Druhy {
    int idDruhu;
    String druh;

    public Druhy(int idDruhu, String druh) {
        this.idDruhu = idDruhu;
        this.druh = druh;
    }

    public int getIdDruhu() {
        return idDruhu;
    }

    public void setIdDruhu(int idDruhu) {
        this.idDruhu = idDruhu;
    }

    public String getDruh() {
        return druh;
    }

    public void setDruh(String druh) {
        this.druh = druh;
    }
    
    @Override
    public String toString() {
        return druh;
    }
}
