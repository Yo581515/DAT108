package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrukerDAO {
	
	@PersistenceContext(name = "brukerPU")
    private EntityManager em;
	
	public List<Bruker> hentAlleBrukere() {
		return em.createQuery("SELECT b FROM Bruker b", Bruker.class).getResultList();
	}
	
	public Bruker hentBruker(String navn) {
		return em.find(Bruker.class, navn);
	}

	public void lagreNyBruker(Bruker nyBruker) {
		em.persist(nyBruker);
	}
}


