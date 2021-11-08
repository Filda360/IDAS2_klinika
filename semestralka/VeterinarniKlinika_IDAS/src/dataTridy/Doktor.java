
package dataTridy;

import java.util.Date;

public class Doktor extends PrihlasenyUzivatel{
    
    private String titul;
    private String delkaUvazku;
    private Date datumNastupu;
    private int plat;
    private int id;
    private String jmeno;
    private String prijmeni;
    private Date datumNarozeni;
    private String telefon;
    private String email;
    private String ulice;
    private String cisloPopisne;
    private String mesto;
    private int psc;

    public Doktor(int id, String titul, String delkaUvazku, Date datumNastupu, int plat, String jmeno, String prijmeni, Date datumNarozeni, String telefon, String email, String ulice, String cisloPopisne, String mesto, int psc) {
        this.id = id;
        this.titul = titul;
        this.delkaUvazku = delkaUvazku;
        this.datumNastupu = datumNastupu;
        this.plat = plat;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.telefon = telefon;
        this.email = email;
        this.ulice = ulice;
        this.cisloPopisne = cisloPopisne;
        this.mesto = mesto;
        this.psc = psc;
    }
    
    public Doktor() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public void setDelkaUvazku(String delkaUvazku) {
        this.delkaUvazku = delkaUvazku;
    }

    public void setDatumNastupu(Date datumNastupu) {
        this.datumNastupu = datumNastupu;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setDatumNarozeni(Date datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public void setCisloPopisne(String cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public int getId() {
        return id;
    }

    public String getTitul() {
        return titul;
    }

    public String getDelkaUvazku() {
        return delkaUvazku;
    }

    public Date getDatumNastupu() {
        return datumNastupu;
    }

    public int getPlat() {
        return plat;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public Date getDatumNarozeni() {
        return datumNarozeni;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getUlice() {
        return ulice;
    }

    public String getCisloPopisne() {
        return cisloPopisne;
    }

    public String getMesto() {
        return mesto;
    }

    public int getPsc() {
        return psc;
    }  

    @Override
    public String toString() {
        String s;
        s =     "jméno: " + jmeno +
                "\npřijmení: " + prijmeni + 
                "\ntitul: " + titul + 
                "\ndatum narozeni: " + datumNarozeni +
                "\ntelefon: " + telefon +
                "\nemail: " + email + 
                "\ndélka úvazku: " + delkaUvazku +
                "\nplat: " + plat +
                "\ndatum nástupu: " + datumNastupu + 
                "\nulice: " + ulice +
                "\nčíslo popisné: " + cisloPopisne +
                "\nměsto: " + mesto +
                "\nPSČ: " + psc;
        return s;
    }
    
    
}
