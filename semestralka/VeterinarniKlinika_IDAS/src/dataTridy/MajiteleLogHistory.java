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
public class MajiteleLogHistory {
    int idLog;
    int idMajitele;
    String datumPrihlaseni;

    public MajiteleLogHistory(int idLog, int idMajitele, String datumPrihlaseni) {
        this.idLog = idLog;
        this.idMajitele = idMajitele;
        this.datumPrihlaseni = datumPrihlaseni;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdMajitele() {
        return idMajitele;
    }

    public void setIdMajitele(int idMajitele) {
        this.idMajitele = idMajitele;
    }

    public String getDatumPrihlaseni() {
        return datumPrihlaseni;
    }

    public void setDatumPrihlaseni(String datumPrihlaseni) {
        this.datumPrihlaseni = datumPrihlaseni;
    }
    
}
