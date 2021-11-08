package no.hvl.dat108;

import java.util.List;

public class DeltagerDAODerBrukerErRegistrert implements DeltagerDAO {

	@Override
	public Deltager findByMobil(String mobil) {
		return null;
	}

	@Override
	public List<Deltager> findAllOrderedByName() {
		return null;
	}

	@Override
	public boolean isPaameldt(String mobil) {
		return true;
	}

	@Override
	public void save(Deltager deltager) {

	}

}
