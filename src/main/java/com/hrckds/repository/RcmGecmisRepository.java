package com.hrckds.repository;

import java.util.Date;
import java.util.List;

import com.hrckds.model.RcmGecmis;

public interface RcmGecmisRepository {
	
	List<RcmGecmis> saveAll( List<RcmGecmis> rcmGecmis );
	int deleteAll(Date date) ;
	RcmGecmis save( RcmGecmis rcmGecmis );
	
	List<RcmGecmis> loadAll();
}
