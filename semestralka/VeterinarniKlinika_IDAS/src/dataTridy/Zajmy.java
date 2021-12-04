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
public class Zajmy {
    int id;
    String zajem;

    public Zajmy(int id, String zajem) {
        this.id = id;
        this.zajem = zajem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZajem() {
        return zajem;
    }

    public void setZajem(String zajem) {
        this.zajem = zajem;
    }
    
}
