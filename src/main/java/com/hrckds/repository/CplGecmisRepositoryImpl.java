package com.hrckds.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hrckds.model.CplGecmis;
import com.hrckds.model.HatKapasite;

@Repository("cplGecmisRepository")
public class CplGecmisRepositoryImpl implements CplGecmisRepository {

	@PersistenceContext
	private EntityManager em;

	public List<CplGecmis> saveAll(List<CplGecmis> cplGecmisL) {
		/* ## butun listeyi dbye yazacak - burada gerek kalmayabilir. */
		for (CplGecmis cplGecmis : cplGecmisL) {
			try {
				em.merge(cplGecmis);
			} catch (PersistenceException e) {
				em.persist(cplGecmis);
				em.flush();
			}
		}
		return cplGecmisL;
	}

	public CplGecmis save(CplGecmis cplGecmis) {

		try {
			em.remove(cplGecmis);
		} catch (PersistenceException e) {
			em.persist(cplGecmis);
			em.flush();
		}

		return cplGecmis;

	}

	public int deleteAll(Date date) {
		Query query;
		if (date == null) {
			query = em.createQuery("DELETE FROM CplGecmis r");
		} else {
			query = em.createQuery("DELETE FROM CplGecmis r WHERE r.kayitTarihi <= :date");
			query.setParameter("date", date);
		}
		int deleted = query.executeUpdate();

		return deleted;
	}

	public List<CplGecmis> loadAll() {
		// ## typequery ile al .
		TypedQuery<CplGecmis> query = em.createNamedQuery("CplGecmis.findAll", CplGecmis.class);
		return query.getResultList();

	}

}
