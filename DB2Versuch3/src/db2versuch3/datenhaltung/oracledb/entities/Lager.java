package db2versuch3.datenhaltung.oracledb.entities;

/**
 * Entitaetsklasse Lager - stellt ein Datensatz der Tabelle LagerAt dar,
 * die Spalte Artikelliste wird lediglich durch die Anzahl der zugehoerigen
 * Artikel ersetzt
 * 
 * @version 1.0
 */
public class Lager {

    private int lnr;
    private String lort;
    private String lplz;
    
    /**
    * Anzahl der zugehoerigen Artikel
    */
    private int anzart;  

    public Lager() {
    }

    public Lager(int lnr, String lort, String lplz, int anzart) {
        this.lnr = lnr;
        this.lort = lort;
        this.lplz = lplz;
        this.anzart = anzart;
    }

    public int getLnr() {
        return lnr;
    }

    public String getLort() {
        return lort;
    }

    public String getLplz() {
        return lplz;
    }

    public int getAnzart() {
        return anzart;
    }

    public void setLnr(int lnr) {
        this.lnr = lnr;
    }

    public void setLort(String lort) {
        this.lort = lort;
    }

    public void setLplz(String lplz) {
        this.lplz = lplz;
    }

    public void setAnzart(int anzart) {
        this.anzart = anzart;
    }

}
