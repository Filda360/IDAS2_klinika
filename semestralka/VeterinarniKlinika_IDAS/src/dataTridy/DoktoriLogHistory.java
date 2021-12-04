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
public class DoktoriLogHistory {
    int idLog;
    int idDoktora;
    String datumPrihlaseni;

    public DoktoriLogHistory(int idLog, int idDoktora, String datumPrihlaseni) {
        this.idLog = idLog;
        this.idDoktora = idDoktora;
        this.datumPrihlaseni = datumPrihlaseni;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdDoktora() {
        return idDoktora;
    }

    public void setIdDoktora(int idDoktora) {
        this.idDoktora = idDoktora;
    }

    public String getDatumPrihlaseni() {
        return datumPrihlaseni;
    }

    public void setDatumPrihlaseni(String datumPrihlaseni) {
        this.datumPrihlaseni = datumPrihlaseni;
    }
    
}
