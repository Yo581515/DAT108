package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "deltager", schema = "obl4")
public class Deltager implements Comparable<Deltager> {
    
    private static final String MANN = "&#9794;"; 	// Unicode, symbol for mann
    private static final String KVINNE = "&#9792;"; // Unicode, symbol for kvinne
    
    @Id
    private String mobil;
    private String passordhash;
	private String fornavn;
    private String etternavn;
    private String kjonn;
    
    public Deltager() {}
    
    public Deltager(String mobil, String passordhash, 
    		String fornavn, String etternavn, String kjonn) {
        setMobil(mobil);
        setPassordhash(passordhash);
        setFornavn(fornavn);
        setEtternavn(etternavn);
        setKjonn(kjonn);
    }
    
	public String getMobil() {
        return mobil;
    }
    public void setMobil(String mobil) {
    	this.mobil = mobil;
    }
    public String getPassordHash() {
		return passordhash;
	}
    private void setPassordhash(String passordhash) {
    	this.passordhash = passordhash;
	}
    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    public String getEtternavn() {
        return etternavn;
    }
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
    public String getKjonn() {
        return kjonn;
    }
    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
    
    public String getMobilFormatert() {
        return getMobil().substring(0,3) + " " + getMobil().substring(3,5)
                + " " + getMobil().substring(5,8);
    }

    public String getFulltNavn() {
        return getFornavn() + " " + getEtternavn();
    }
    
    public String getKjonnsymbol() {
        return (getKjonn().equals("mann") ? MANN : KVINNE);
    }
    
    @Override
    public boolean equals(Object obj) {
        Deltager other = (Deltager) obj;
        return this.getMobil().equals(other.getMobil());
    }

    /*
     * Litt grisete å la compareTo virke annerledes en equals, og å
     * unnlate å implementere hashCode, men pytt ...
     */
    @Override
    public int compareTo(Deltager that) {
        return this.getFulltNavn().compareTo(that.getFulltNavn());
    }
    
    @Override
    public String toString() {
    	return new Gson().toJson(this);
    }
}
