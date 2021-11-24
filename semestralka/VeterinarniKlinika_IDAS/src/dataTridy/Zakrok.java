/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataTridy;

/**
 ** @author tzlat*/
public class Zakrok {
    private int idZakroku;
    private String datum;
    private String poznamka;
    private int idZvirete;
    private String jmeno;
    private String datumNarozeni;
    private double vaha;
    private String zvirePoznamka;
    private String cisloCipu;
    private int idMajitele;
    private String datumRegistrace;
    private String jmenoMajitele;
    private String prijmeniMajitele;
    private String datumNarozeniMajitele;
    private String telefonMajitele;
    private String emailMajitele;
    private int idAdresaMajitele;
    private String uliceMajitele;
    private String cisloPopisneMajitele;
    private int id_postyMajitele;
    private String mestoMajitele;
    private String pscMajitele;
    private int idPohlavi;
    private String pohlavi;
    private int idDruhu;
    private String druh;
    private int idDoktora;
    private String titul;
    private String delkaUvazku;
    private String datumNastupu;
    private double plat;
    private String jmenoLekare;
    private String prijmeniLekare;
    private String datumNarozeniLekare;
    private String telefonLekare;
    private String emailLekare;
    private int idAdresaLekare;
    private String uliceLekare;
    private String cisloPopisneLekare;
    private int idPostyLekare;
    private String mestoLekare;
    private String pscLekare;
    private int idOperace;
    private String typOperace;
    private String oznaceni;
    private double delkaOperace;
    private String riziko;

    public Zakrok(int idZakroku, String datum, String poznamka, int idZvirete, String jmeno, String datumNarozeni, double vaha, String zvirePoznamka, String cisloCipu, int idMajitele, String datumRegistrace, String jmenoMajitele, String prijmeniMajitele, String datumNarozeniMajitele, String telefonMajitele, String emailMajitele, int idAdresaMajitele, String uliceMajitele, String cisloPopisneMajitele, int id_postyMajitele, String mestoMajitele, String pscMajitele, int idPohlavi, String pohlavi, int idDruhu, String druh, int idDoktora, String titul, String delkaUvazku, String datumNastupu, double plat, String jmenoLekare, String prijmeniLekare, String datumNarozeniLekare, String telefonLekare, String emailLekare, int idAdresaLekare, String uliceLekare, String cisloPopisneLekare, int idPostyLekare, String mestoLekare, String pscLekare, int idOperace, String typOperace, String oznaceni, double delkaOperace, String riziko) {
        this.idZakroku = idZakroku;
        this.datum = datum;
        this.poznamka = poznamka;
        this.idZvirete = idZvirete;
        this.jmeno = jmeno;
        this.datumNarozeni = datumNarozeni;
        this.vaha = vaha;
        this.zvirePoznamka = zvirePoznamka;
        this.cisloCipu = cisloCipu;
        this.idMajitele = idMajitele;
        this.datumRegistrace = datumRegistrace;
        this.jmenoMajitele = jmenoMajitele;
        this.prijmeniMajitele = prijmeniMajitele;
        this.datumNarozeniMajitele = datumNarozeniMajitele;
        this.telefonMajitele = telefonMajitele;
        this.emailMajitele = emailMajitele;
        this.idAdresaMajitele = idAdresaMajitele;
        this.uliceMajitele = uliceMajitele;
        this.cisloPopisneMajitele = cisloPopisneMajitele;
        this.id_postyMajitele = id_postyMajitele;
        this.mestoMajitele = mestoMajitele;
        this.pscMajitele = pscMajitele;
        this.idPohlavi = idPohlavi;
        this.pohlavi = pohlavi;
        this.idDruhu = idDruhu;
        this.druh = druh;
        this.idDoktora = idDoktora;
        this.titul = titul;
        this.delkaUvazku = delkaUvazku;
        this.datumNastupu = datumNastupu;
        this.plat = plat;
        this.jmenoLekare = jmenoLekare;
        this.prijmeniLekare = prijmeniLekare;
        this.datumNarozeniLekare = datumNarozeniLekare;
        this.telefonLekare = telefonLekare;
        this.emailLekare = emailLekare;
        this.idAdresaLekare = idAdresaLekare;
        this.uliceLekare = uliceLekare;
        this.cisloPopisneLekare = cisloPopisneLekare;
        this.idPostyLekare = idPostyLekare;
        this.mestoLekare = mestoLekare;
        this.pscLekare = pscLekare;
        this.idOperace = idOperace;
        this.typOperace = typOperace;
        this.oznaceni = oznaceni;
        this.delkaOperace = delkaOperace;
        this.riziko = riziko;
    }

    public int getIdZakroku() {
        return idZakroku;
    }

    public String getDatum() {
        return datum;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public int getIdZvirete() {
        return idZvirete;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public double getVaha() {
        return vaha;
    }

    public String getZvirePoznamka() {
        return zvirePoznamka;
    }

    public String getCisloCipu() {
        return cisloCipu;
    }

    public int getIdMajitele() {
        return idMajitele;
    }

    public String getDatumRegistrace() {
        return datumRegistrace;
    }

    public String getJmenoMajitele() {
        return jmenoMajitele;
    }

    public String getPrijmeniMajitele() {
        return prijmeniMajitele;
    }

    public String getDatumNarozeniMajitele() {
        return datumNarozeniMajitele;
    }

    public String getTelefonMajitele() {
        return telefonMajitele;
    }

    public String getEmailMajitele() {
        return emailMajitele;
    }

    public int getIdAdresaMajitele() {
        return idAdresaMajitele;
    }

    public String getUliceMajitele() {
        return uliceMajitele;
    }

    public String getCisloPopisneMajitele() {
        return cisloPopisneMajitele;
    }

    public int getId_postyMajitele() {
        return id_postyMajitele;
    }

    public String getMestoMajitele() {
        return mestoMajitele;
    }

    public String getPscMajitele() {
        return pscMajitele;
    }

    public int getIdPohlavi() {
        return idPohlavi;
    }

    public String getPohlavi() {
        return pohlavi;
    }

    public int getIdDruhu() {
        return idDruhu;
    }

    public String getDruh() {
        return druh;
    }

    public int getIdDoktora() {
        return idDoktora;
    }

    public String getTitul() {
        return titul;
    }

    public String getDelkaUvazku() {
        return delkaUvazku;
    }

    public String getDatumNastupu() {
        return datumNastupu;
    }

    public double getPlat() {
        return plat;
    }

    public String getJmenoLekare() {
        return jmenoLekare;
    }

    public String getPrijmeniLekare() {
        return prijmeniLekare;
    }

    public String getDatumNarozeniLekare() {
        return datumNarozeniLekare;
    }

    public String getTelefonLekare() {
        return telefonLekare;
    }

    public String getEmailLekare() {
        return emailLekare;
    }

    public int getIdAdresaLekare() {
        return idAdresaLekare;
    }

    public String getUliceLekare() {
        return uliceLekare;
    }

    public String getCisloPopisneLekare() {
        return cisloPopisneLekare;
    }

    public int getIdPostyLekare() {
        return idPostyLekare;
    }

    public String getMestoLekare() {
        return mestoLekare;
    }

    public String getPscLekare() {
        return pscLekare;
    }

    public int getIdOperace() {
        return idOperace;
    }

    public String getTypOperace() {
        return typOperace;
    }

    public String getOznaceni() {
        return oznaceni;
    }

    public double getDelkaOperace() {
        return delkaOperace;
    }

    public String getRiziko() {
        return riziko;
    }

    public void setIdZakroku(int idZakroku) {
        this.idZakroku = idZakroku;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public void setIdZvirete(int idZvirete) {
        this.idZvirete = idZvirete;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public void setVaha(double vaha) {
        this.vaha = vaha;
    }

    public void setZvirePoznamka(String zvirePoznamka) {
        this.zvirePoznamka = zvirePoznamka;
    }

    public void setCisloCipu(String cisloCipu) {
        this.cisloCipu = cisloCipu;
    }

    public void setIdMajitele(int idMajitele) {
        this.idMajitele = idMajitele;
    }

    public void setDatumRegistrace(String datumRegistrace) {
        this.datumRegistrace = datumRegistrace;
    }

    public void setJmenoMajitele(String jmenoMajitele) {
        this.jmenoMajitele = jmenoMajitele;
    }

    public void setPrijmeniMajitele(String prijmeniMajitele) {
        this.prijmeniMajitele = prijmeniMajitele;
    }

    public void setDatumNarozeniMajitele(String datumNarozeniMajitele) {
        this.datumNarozeniMajitele = datumNarozeniMajitele;
    }

    public void setTelefonMajitele(String telefonMajitele) {
        this.telefonMajitele = telefonMajitele;
    }

    public void setEmailMajitele(String emailMajitele) {
        this.emailMajitele = emailMajitele;
    }

    public void setIdAdresaMajitele(int idAdresaMajitele) {
        this.idAdresaMajitele = idAdresaMajitele;
    }

    public void setUliceMajitele(String uliceMajitele) {
        this.uliceMajitele = uliceMajitele;
    }

    public void setCisloPopisneMajitele(String cisloPopisneMajitele) {
        this.cisloPopisneMajitele = cisloPopisneMajitele;
    }

    public void setId_postyMajitele(int id_postyMajitele) {
        this.id_postyMajitele = id_postyMajitele;
    }

    public void setMestoMajitele(String mestoMajitele) {
        this.mestoMajitele = mestoMajitele;
    }

    public void setPscMajitele(String pscMajitele) {
        this.pscMajitele = pscMajitele;
    }

    public void setIdPohlavi(int idPohlavi) {
        this.idPohlavi = idPohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }

    public void setIdDruhu(int idDruhu) {
        this.idDruhu = idDruhu;
    }

    public void setDruh(String druh) {
        this.druh = druh;
    }

    public void setIdDoktora(int idDoktora) {
        this.idDoktora = idDoktora;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public void setDelkaUvazku(String delkaUvazku) {
        this.delkaUvazku = delkaUvazku;
    }

    public void setDatumNastupu(String datumNastupu) {
        this.datumNastupu = datumNastupu;
    }

    public void setPlat(double plat) {
        this.plat = plat;
    }

    public void setJmenoLekare(String jmenoLekare) {
        this.jmenoLekare = jmenoLekare;
    }

    public void setPrijmeniLekare(String prijmeniLekare) {
        this.prijmeniLekare = prijmeniLekare;
    }

    public void setDatumNarozeniLekare(String datumNarozeniLekare) {
        this.datumNarozeniLekare = datumNarozeniLekare;
    }

    public void setTelefonLekare(String telefonLekare) {
        this.telefonLekare = telefonLekare;
    }

    public void setEmailLekare(String emailLekare) {
        this.emailLekare = emailLekare;
    }

    public void setIdAdresaLekare(int idAdresaLekare) {
        this.idAdresaLekare = idAdresaLekare;
    }

    public void setUliceLekare(String uliceLekare) {
        this.uliceLekare = uliceLekare;
    }

    public void setCisloPopisneLekare(String cisloPopisneLekare) {
        this.cisloPopisneLekare = cisloPopisneLekare;
    }

    public void setIdPostyLekare(int idPostyLekare) {
        this.idPostyLekare = idPostyLekare;
    }

    public void setMestoLekare(String mestoLekare) {
        this.mestoLekare = mestoLekare;
    }

    public void setPscLekare(String pscLekare) {
        this.pscLekare = pscLekare;
    }

    public void setIdOperace(int idOperace) {
        this.idOperace = idOperace;
    }

    public void setTypOperace(String typOperace) {
        this.typOperace = typOperace;
    }

    public void setOznaceni(String oznaceni) {
        this.oznaceni = oznaceni;
    }

    public void setDelkaOperace(double delkaOperace) {
        this.delkaOperace = delkaOperace;
    }

    public void setRiziko(String riziko) {
        this.riziko = riziko;
    }
    
}
