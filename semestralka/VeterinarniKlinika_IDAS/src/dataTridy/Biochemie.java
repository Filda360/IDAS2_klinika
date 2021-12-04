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
public class Biochemie {
    int idOdberu;
    double urea;
    double kreatinin;
    double bilirubin;
    double ast;
    double alt;

    public Biochemie(int idOdberu, double urea, double kreatinin, double bilirubin, double ast, double alt) {
        this.idOdberu = idOdberu;
        this.urea = urea;
        this.kreatinin = kreatinin;
        this.bilirubin = bilirubin;
        this.ast = ast;
        this.alt = alt;
    }

    public void setIdOdberu(int idOdberu) {
        this.idOdberu = idOdberu;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    public void setKreatinin(double kreatinin) {
        this.kreatinin = kreatinin;
    }

    public void setBilirubin(double bilirubin) {
        this.bilirubin = bilirubin;
    }

    public void setAst(double ast) {
        this.ast = ast;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    public int getIdOdberu() {
        return idOdberu;
    }

    public double getUrea() {
        return urea;
    }

    public double getKreatinin() {
        return kreatinin;
    }

    public double getBilirubin() {
        return bilirubin;
    }

    public double getAst() {
        return ast;
    }

    public double getAlt() {
        return alt;
    }
    
    
    
}
