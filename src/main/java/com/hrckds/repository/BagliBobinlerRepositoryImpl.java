package com.hrckds.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import com.hrckds.model.BagliBobinler;

@Repository("bagliBobinlerRepository")
public class BagliBobinlerRepositoryImpl implements BagliBobinlerRepository {

	@PersistenceContext
	private EntityManager em;

	public List<BagliBobinler> saveAll(List<BagliBobinler> bagliBobinlerL) {
		/* ## butun listeyi dbye yazacak - burada gerek kalmayabilir. */
		for (BagliBobinler bagliBobinler : bagliBobinlerL) {
			try {
				em.merge(bagliBobinler);
			} catch (PersistenceException e) {
				em.persist(bagliBobinler);
				em.flush();
			}
		}

		return bagliBobinlerL;
	}

	public BagliBobinler save(BagliBobinler bagliBobinler) {

		try {
			em.merge(bagliBobinler);
		} catch (PersistenceException e) {
			em.persist(bagliBobinler);
			em.flush();
		}

		return bagliBobinler;

	}

	// public List<BagliBobinler> loadAll() {
	// //## typequery ile al .
	// TypedQuery<HatKapasite> query =
	// em.createNamedQuery("HatKapasite.findAll", HatKapasite.class);
	// return query.getResultList();
	//
	// }

}
