package com.hrckds.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hrckds.model.RcmGecmis;
import com.hrckds.model.HatKapasite;

@Repository("rcmGecmisRepository")
public class RcmGecmisRepositoryImpl implements RcmGecmisRepository {

	@PersistenceContext
	private EntityManager em;

	public List<RcmGecmis> saveAll(List<RcmGecmis> rcmGecmisL) {
		/* ## butun listeyi dbye yazacak - burada gerek kalmayabilir. */
		for (RcmGecmis rcmGecmis : rcmGecmisL) {
			try {
				em.merge(rcmGecmis);
			} catch (PersistenceException e) {
				em.persist(rcmGecmis);
				em.flush();
			}
		}

		return rcmGecmisL;
	}

	public RcmGecmis save(RcmGecmis rcmGecmis) {

		try {
			em.remove(rcmGecmis);
		} catch (PersistenceException e) {
			em.persist(rcmGecmis);
			em.flush();
		}

		return rcmGecmis;

	}

	public int deleteAll(Date date) {
		Query query;
		if (date == null) {
			query = em.createQuery("DELETE FROM RcmGecmis r");
		} else {
			query = em.createQuery("DELETE FROM RcmGecmis r WHERE r.kayitTarihi <= :date");
			query.setParameter("date", date);
		}
		int deleted = query.executeUpdate();

		return deleted;
	}

	public List<RcmGecmis> loadAll() {
		// ## typequery ile al .
		TypedQuery<RcmGecmis> query = em.createNamedQuery("RcmGecmis.findAll", RcmGecmis.class);
		return query.getResultList();

	}

}
