package com.hrckds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrckds.javastack.SapDataSources;
import com.hrckds.model.HatKapasite;
import com.hrckds.repository.HatKapasiteRepository;
import com.sap.conn.jco.JCoException;

@Service("hatKapasiteService")
public class HatKapasiteServiceImpl implements HatKapasiteService {

	@Autowired
	private HatKapasiteRepository hatKapasiteRepository;

	@Transactional
	public List<HatKapasite> saveAll() {
		/* ## data validationlar burada yapilacak. */
		
		List<HatKapasite> hatKapasite = new ArrayList<HatKapasite>();
		
		try {
			hatKapasite = SapDataSources.callVardiyaDoluluk();
		} catch (JCoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hatKapasiteRepository.saveAll(hatKapasite);
	}

	@Transactional
	public HatKapasite save(HatKapasite hatKapasite) {
		return hatKapasiteRepository.save(hatKapasite);
	}

	@Transactional
	public List<HatKapasite> findAll() {
		/* ## data validationlar burada yapilacak. */
		return hatKapasiteRepository.loadAll();
	}

}
