package com.hrckds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrckds.service.BagliBobinlerService;
import com.hrckds.service.CplGecmisService;
import com.hrckds.service.HatKapasiteService;
import com.hrckds.service.RcmGecmisService;

@Component("cronSchedule")
public class CronSchedule {
	
	@Autowired
	private CplGecmisService cplGecmisService;

	@Autowired
	private RcmGecmisService rcmGecmisService;

	@Autowired
	private HatKapasiteService hatKapasiteService;	

	@Autowired
	private BagliBobinlerService bagliBobinlerService;	
	
	public void doSomething() {
//		"0 0 * * * *"          // the top of every hour of every day.
//		"*/10 * * * * *"       // every ten seconds.
//		"0 0 8-10 * * *"       // 8, 9 and 10 o'clock of every day.
//		"0 0/30 8-10 * * *"    // 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
//		"0 0 9-17 * * MON-FRI" // on the hour nine-to-seventeen, and monday to friday	 
//		"0 0 0 25 12 ?"        // every Christmas Day at midnight
	
		System.out.println("Do something" + Thread.currentThread().getId() );

	}
	/**
	 *  her ayin ilk gunu sabah 1.00(AM) de calisacak
	 * */
	public void updateData() {
		
		cplGecmisService.saveAll();
		
		rcmGecmisService.saveAll();
		
		hatKapasiteService.saveAll();
		
		bagliBobinlerService.saveAll();
		
	}

}
