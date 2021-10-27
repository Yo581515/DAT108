package no.hvl.dat108;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "f17pwd")
public class Bruker {

    @Id
    private String brukernavn;
    @Embedded
    private Passord passord;
    
	public Bruker(String brukernavn, Passord passord) {
		this.brukernavn = brukernavn;
		this.passord = passord;
	}
	
	public Bruker() {}

	@Override
	public String toString() {
		return "Bruker [brukernavn=" + brukernavn + ", passord=" + passord + "]";
	}
}
