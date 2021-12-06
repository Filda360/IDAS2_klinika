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
public class Pohlavi {
    int idPohlavi;
    String pohlavi;

    public Pohlavi(int idPohlavi, String pohlavi) {
        this.idPohlavi = idPohlavi;
        this.pohlavi = pohlavi;
    }

    public int getIdPohlavi() {
        return idPohlavi;
    }

    public void setIdPohlavi(int idPohlavi) {
        this.idPohlavi = idPohlavi;
    }

    public String getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }
    @Override
    public String toString() {
        return pohlavi;
    }
}
