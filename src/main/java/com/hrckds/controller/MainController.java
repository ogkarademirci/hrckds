package com.hrckds.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hrckds.model.CplGecmis;
import com.hrckds.model.CplGecmisPK;
import com.hrckds.service.BagliBobinlerService;
import com.hrckds.service.CplGecmisService;
import com.hrckds.service.HatKapasiteService;
import com.hrckds.service.RcmGecmisService;

@Controller
@SessionAttributes("main")
public class MainController {

	@Autowired
	private CplGecmisService cplGecmisService;

	@Autowired
	private RcmGecmisService rcmGecmisService;

	@Autowired
	private HatKapasiteService hatKapasiteService;	

	@Autowired
	private BagliBobinlerService bagliBobinlerService;	

	/**
	 * 
	 * */
	@RequestMapping(value = "cplGecmis", method = RequestMethod.GET)
	public String saveCplGecmis(Model model) {
		/*
		 * RFCler veya APIlar burada çagrilabilir. db tablosu burada doldurulabilir.
		 * yazilacak bir programla bu
		 * 
		 */
		
		cplGecmisService.saveAll();

		return "redirect:index.jsp";
	}

	@RequestMapping(value = "rcmGecmis", method = RequestMethod.GET)
	public String saveRcmGecmis(Model model) {
		/*
		 * RFCler veya APIlar burada çagrilabilir.
		 * 
		 */
		 rcmGecmisService.saveAll();
		return "redirect:index.jsp";
	}

	@RequestMapping(value = "hatKapasite", method = RequestMethod.GET)
	public String saveHatKapasite(Model model) {
		/*
		 * RFCler veya APIlar burada çagrilabilir.
		 * 
		 */
		hatKapasiteService.saveAll();

		return "redirect:index.jsp";
	}

	@RequestMapping(value = "bagliBobinler", method = RequestMethod.GET)
	public String saveSipariseBagliBobinler(Model model) {
		/*
		 * RFCler veya APIlar burada çagrilabilir.
		 * 
		 */
		bagliBobinlerService.saveAll();
		
		return "redirect:index.jsp";
	}

	@RequestMapping(value = "socunlar", method = RequestMethod.GET)
	public String saveSonuclar(Model model) {
		/*
		 * RFCler veya APIlar burada çagrilabilir.
		 * 
		 */
		//kullanici adi
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return "redirect:index.jsp";
	}	

	@RequestMapping(value = "rezervasyonsuzSiparisler", method = RequestMethod.GET)
	public String saveRezervasyonsuzSiparisler(Model model) {
		/*
		 * RFCler veya APIlar burada çagrilabilir.
		 * 
		 */
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "cplGecmis", method = RequestMethod.POST)
	public String save() {

		//cplGecmisService.saveAll();

		// List<CplGecmis> cplGecmiList = cplGecmisService.findAll();

		return "redirect:index.jsp";
	}	

}
