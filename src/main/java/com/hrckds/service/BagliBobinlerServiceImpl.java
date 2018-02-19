package com.hrckds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrckds.javastack.SapDataSources;
import com.hrckds.model.BagliBobinler;
import com.hrckds.repository.BagliBobinlerRepository;
import com.sap.conn.jco.JCoException;

@Service("bagliBobinlerService")
public class BagliBobinlerServiceImpl implements BagliBobinlerService {

	@Autowired
	private BagliBobinlerRepository bagliBobinlerRepository;

	@Transactional
	public List<BagliBobinler> saveAll() {
		/* ## data validationlar burada yapilacak. */
		
		List<BagliBobinler> bagliBobinlerL = new ArrayList<BagliBobinler>();
		
		try {
			bagliBobinlerL = SapDataSources.getBagliBobinler();
		} catch (JCoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bagliBobinlerRepository.saveAll(bagliBobinlerL);
	}

	@Transactional
	public BagliBobinler save(BagliBobinler bagliBobinler) {
		return bagliBobinlerRepository.save(bagliBobinler);
	}


//	@Transactional
//	public List<HatKapasite> findAll() {
//		/* ## data validationlar burada yapilacak. */
//		return bagliBobinlerRepository.loadAll();
//	}

}
