package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "f17")
public class Student {

    @Id
    private String id;
    private String navn;

    @ManyToOne
    @JoinColumn(name="klasse_kode")
    private Klasse klasse;

	@Override
	public String toString() {
		return "Student [id=" + id + ", navn=" + navn + ", klasse=" + klasse + "]";
	}

}
