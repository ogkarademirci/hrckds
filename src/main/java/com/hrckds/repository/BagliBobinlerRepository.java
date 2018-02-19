package com.hrckds.repository;

import java.util.List;

import com.hrckds.model.BagliBobinler;

public interface BagliBobinlerRepository {
	List<BagliBobinler> saveAll( List<BagliBobinler> bagliBobinlerL );
	
	BagliBobinler save( BagliBobinler bagliBobinler );
	
	//List<HatKapa	site> loadAll();
}
