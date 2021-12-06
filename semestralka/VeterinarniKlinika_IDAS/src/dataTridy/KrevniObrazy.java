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
public class KrevniObrazy {
    int idOdberu;
    double erytrocyty;
    double leukocyty;
    double trombocyty;
    double hemoglobin;

    public KrevniObrazy(int idOdberu, double erytrocyty, double leukocyty, double trombocyty, double hemoglobin) {
        this.idOdberu = idOdberu;
        this.erytrocyty = erytrocyty;
        this.leukocyty = leukocyty;
        this.trombocyty = trombocyty;
        this.hemoglobin = hemoglobin;
    }

    public int getIdOdberu() {
        return idOdberu;
    }

    public void setIdOdberu(int idOdberu) {
        this.idOdberu = idOdberu;
    }

    public double getErytrocyty() {
        return erytrocyty;
    }

    public void setErytrocyty(double erytrocyty) {
        this.erytrocyty = erytrocyty;
    }

    public double getLeukocyty() {
        return leukocyty;
    }

    public void setLeukocyty(double leukocyty) {
        this.leukocyty = leukocyty;
    }

    public double getTrombocyty() {
        return trombocyty;
    }

    public void setTrombocyty(double trombocyty) {
        this.trombocyty = trombocyty;
    }

    public double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }
    @Override
    public String toString() {
        return erytrocyty+", "+leukocyty+", "+trombocyty+", "+hemoglobin;
    }
    
}
