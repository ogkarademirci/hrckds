package com.hrckds.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrckds.javastack.SapDataSources;
import com.hrckds.model.CplGecmis;
import com.hrckds.repository.CplGecmisRepository;
import com.sap.conn.jco.JCoException;

@Service("cplGecmisService")
public class CplGecmisServiceImpl implements CplGecmisService {

	@Autowired
	private CplGecmisRepository cplGecmisRepository;

	@Transactional
	public List<CplGecmis> saveAll() {
		/* ## data validationlar burada yapilacak. */
		List<CplGecmis> cplGecmisL = new ArrayList<CplGecmis>();
		
		try {
			cplGecmisL = SapDataSources.getCplGecmis();
		} catch (JCoException e) {
			e.printStackTrace();
		}
		
		// delete older data
		deleteAll(null);
		// insert new data
		return cplGecmisRepository.saveAll(cplGecmisL);
	}

	@Transactional
	public CplGecmis save(CplGecmis cplGecmis) {
		return cplGecmisRepository.save(cplGecmis);
	}

	@Transactional
	public List<CplGecmis> findAll() {
		/* ## data validationlar burada yapilacak. */
		return cplGecmisRepository.loadAll();
	}

	@Transactional
	public int deleteAll(Date date) {
		return cplGecmisRepository.deleteAll(date);
	}
	
	public Date getCurrentDate(){
		return null;
	}
}
