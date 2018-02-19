package com.hrckds.service;

import java.util.Date;
import java.util.List;

import com.hrckds.model.CplGecmis;

public interface CplGecmisService {
    
	List<CplGecmis> saveAll();
	
	int deleteAll(Date date);
	
	CplGecmis save( CplGecmis cplGecmis );
	
	List<CplGecmis> findAll();
	
}
