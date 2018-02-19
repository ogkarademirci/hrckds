package com.hrckds.repository;

import java.util.List;

import com.hrckds.model.HatKapasite;

public interface HatKapasiteRepository {
	List<HatKapasite> saveAll( List<HatKapasite> hatKapasite );
	
	HatKapasite save( HatKapasite hatKapasite );
	
	List<HatKapasite> loadAll();
}
