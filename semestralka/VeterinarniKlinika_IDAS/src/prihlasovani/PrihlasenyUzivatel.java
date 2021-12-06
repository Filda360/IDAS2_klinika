
package prihlasovani;

import java.util.Date;

public abstract class PrihlasenyUzivatel {
    protected int id;
    protected String jmeno;
    protected String prijmeni;
    protected Date datumNarozeni;
    protected String telefon;
    protected String email;
    protected String ulice;
    protected String cisloPopisne;
    protected String mesto;
    protected int psc;
    protected int IdAdresy;
    
    public PrihlasenyUzivatel(){ 
        
    }

    public int getId() {
        return id;
    }

    public int getIdAdresy() {
        return IdAdresy;
    }
    
    
    
}
