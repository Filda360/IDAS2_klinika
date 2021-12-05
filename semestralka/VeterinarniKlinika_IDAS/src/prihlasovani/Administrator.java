
package prihlasovani;

import java.util.Date;

public class Administrator extends PrihlasenyUzivatel{
    
    public Administrator(int id, String jmeno, String prijmeni, Date datumNarozeni, String telefon, String email, String ulice, String cisloPopisne, String mesto, int psc) {
        this.id = id;
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
        
    public Administrator(){ 
    }
    
    public void setId(int id) {
        this.id = id;
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
}
