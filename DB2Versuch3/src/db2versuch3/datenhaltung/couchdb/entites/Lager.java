package db2versuch3.datenhaltung.couchdb.entites;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Entitaetsklasse Lager
 *
 * @version 1.0
 */
public class Lager {

    private String id;
    private String revision;
    private int lnr;
    private String lort;
    private String lplz;

    public Lager() {
    }

    public Lager(String id, String revision, int lnr, String lort, String lplz) {
        this.id = id;
        this.revision = revision;
        this.lnr = lnr;
        this.lort = lort;
        this.lplz = lplz;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_rev")
    public String getRevision() {
        return revision;
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

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("_rev")
    public void setRevision(String revision) {
        this.revision = revision;
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

}
