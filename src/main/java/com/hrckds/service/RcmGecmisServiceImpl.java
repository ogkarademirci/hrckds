package com.hrckds.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrckds.javastack.SapDataSources;
import com.hrckds.model.RcmGecmis;
import com.hrckds.repository.RcmGecmisRepository;
import com.sap.conn.jco.JCoException;

@Service("rcmGecmisService")
public class RcmGecmisServiceImpl implements RcmGecmisService {
	
	@Autowired
	private RcmGecmisRepository rcmGecmisRepository;
	
	@Transactional
	public List<RcmGecmis> saveAll() {
		/* ## data validationlar burada yapilacak.*/
		
		List<RcmGecmis> rcmGecmisL = new ArrayList<RcmGecmis>();
		
		try {
			rcmGecmisL = SapDataSources.getRcmGecmis();
		} catch (JCoException e) {
			e.printStackTrace();
		}
		
		// delete older data
		deleteAll(null);		
		return rcmGecmisRepository.saveAll(rcmGecmisL);		
	}
	@Transactional
	public RcmGecmis save(RcmGecmis rcmGecmis) {	
		return rcmGecmisRepository.save(rcmGecmis);		
	}
	
	@Transactional
	public List<RcmGecmis> findAll() {
		/* ## data validationlar burada yapilacak.*/
		return rcmGecmisRepository.loadAll();
	}
	@Transactional
	public int deleteAll(Date date) {
		return rcmGecmisRepository.deleteAll(date);
	}

}
