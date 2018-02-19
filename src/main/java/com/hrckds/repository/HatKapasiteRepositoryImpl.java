package com.hrckds.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hrckds.model.HatKapasite;

@Repository("hatKapasiteRepository")
public class HatKapasiteRepositoryImpl implements HatKapasiteRepository{
    
	@PersistenceContext
	private EntityManager em;
	
	public List<HatKapasite> saveAll(List<HatKapasite> hatKapasiteL) {
		/* ## butun listeyi dbye yazacak - burada gerek kalmayabilir.*/
		for (HatKapasite hatKapasite : hatKapasiteL) {
			//##
			try {
			em.merge(hatKapasite);
			} catch (PersistenceException e) {
				em.persist(hatKapasite);	
				em.flush();
			}

		}		
		
		return hatKapasiteL;
	}

	public HatKapasite save(HatKapasite hatKapasite) {
		
		try {
		em.merge(hatKapasite);
		} catch (PersistenceException e) {
			em.persist(hatKapasite);	
			em.flush();
		}
		
		return hatKapasite;
		
	}

	public List<HatKapasite> loadAll() {
		//## typequery ile al .
	TypedQuery<HatKapasite> query =
			      em.createNamedQuery("HatKapasite.findAll", HatKapasite.class);
	return query.getResultList();
	
	}

}
