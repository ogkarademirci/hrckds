package com.hrckds.service;

import java.util.List;

import com.hrckds.model.BagliBobinler;

public interface BagliBobinlerService {
    
	List<BagliBobinler> saveAll();
	
	BagliBobinler save( BagliBobinler bagliBobinler );
	
	//List<HatKapasite> findAll();
	
}
