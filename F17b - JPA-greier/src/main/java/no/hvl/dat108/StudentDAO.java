package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentDAO {
	
	@PersistenceContext(name="studentDB")
	private EntityManager em;

	public List<Student> hentAlleStudenter() {
//		TypedQuery<Student> query = em.createQuery("", Student.class);
//		return query.getResultList();
		return em.createQuery("select s from Student s", Student.class).getResultList();
	}
}
