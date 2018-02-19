package com.hrckds.repository;

import java.util.Date;
import java.util.List;

import com.hrckds.model.CplGecmis;

public interface CplGecmisRepository {
	
	List<CplGecmis> saveAll( List<CplGecmis> cplGecmis );
	
	int deleteAll(Date date) ;
	
	CplGecmis save( CplGecmis cplGecmis );
	
	List<CplGecmis> loadAll();
}
