package com.hrckds.service;

import java.util.List;

import com.hrckds.model.HatKapasite;

public interface HatKapasiteService {
    
	List<HatKapasite> saveAll();
	
	HatKapasite save( HatKapasite hatKapasite );
	
	List<HatKapasite> findAll();
	
}
