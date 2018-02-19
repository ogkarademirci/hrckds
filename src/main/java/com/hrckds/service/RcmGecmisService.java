package com.hrckds.service;

import java.util.Date;
import java.util.List;

import com.hrckds.model.RcmGecmis;

//import com.hrckds.model.RcmlGecmis;

public interface RcmGecmisService {
    
	List<RcmGecmis> saveAll();
	
	int deleteAll(Date date);
	
//	CplGecmis save( CplGecmis cplGecmis );
	
//	List<CplGecmis> findAll();
	
	
}
