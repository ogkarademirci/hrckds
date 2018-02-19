package com.hrckds.javastack;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.hrckds.model.BagliBobinler;
import com.hrckds.model.BagliBobinlerPK;
import com.hrckds.model.CplGecmis;
import com.hrckds.model.CplGecmisPK;
import com.hrckds.model.HatKapasite;
import com.hrckds.model.HatKapasitePK;
import com.hrckds.model.RcmGecmis;
import com.hrckds.model.RcmGecmisPK;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class SapDataSources {

	static String ABAP_AS = "ABAP_AS_WITHOUT_POOL";
	static String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL";
	// static String ABAP_MS = "ABAP_MS_WITHOUT_POOL";

	static {
		Properties connectProperties = new Properties();
		connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "X");
		connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
		connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "006");
		connectProperties.setProperty(DestinationDataProvider.JCO_USER, "okarademirci");
		connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "X");
		connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "en");
		createDestinationDataFile(ABAP_AS, connectProperties);
		connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "3");
		connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "10");
		createDestinationDataFile(ABAP_AS_POOLED, connectProperties);

	}

	public static void createDestinationDataFile(String destinationName, Properties connectProperties) {
		File destCfg = new File(destinationName + ".jcoDestination");
		try {
			FileOutputStream fos = new FileOutputStream(destCfg, false);
			connectProperties.store(fos, "for tests only !");
			fos.close();
		} catch (Exception e) {
			throw new RuntimeException("Unable to create the destination files", e);
		}
	}

	/**
	 * Vardiya doluluk rfcsini call eder.
	 * 
	 */
	public static List<HatKapasite> callVardiyaDoluluk() throws JCoException {
		List<HatKapasite> hatKapasiteL = new ArrayList<HatKapasite>();

		JCoDestination destination = JCoDestinationManager.getDestination(ABAP_AS);
		JCoFunction function = destination.getRepository().getFunction("ZMM_F_VARDIYA_DOLULUK");

		if (function == null)
			throw new RuntimeException("ZMM_F_VARDIYA_DOLULUK not found in SAP.");

		// close after tests ##
		function.getImportParameterList().setValue("DATUM", "20170101");

		try {
			function.execute(destination);
		} catch (AbapException e) {
			// System.out.println(e.toString());
			return null;
		}

		JCoTable codes = function.getTableParameterList().getTable("ET_VARDIYA_DOLULUK");
		for (int i = 0; i < codes.getNumRows(); i++) {
			HatKapasite hatKapasite = new HatKapasite();
			HatKapasitePK id = new HatKapasitePK();

			codes.setRow(i);
			// set compsite id
			id.setYil(Integer.parseInt(codes.getString("YIL")));
			id.setHafta(Integer.parseInt(codes.getString("HAFTA")));
			id.setHat(codes.getString("HAT"));
			// set hatkapsite object
			hatKapasite.setCalismaSure(Integer.parseInt(codes.getString("CALISMA")));
			hatKapasite.setId(id);

			hatKapasiteL.add(hatKapasite);
			id = null;
			hatKapasite = null;

			// System.out.println(codes.getString("YIL") + '\t' + codes.getString("HAFTA")
			// + '\t' + codes.getString("HAT") + '\t' + codes.getString("CALISMA") );

		}
		return hatKapasiteL;
	}

	public static List<BagliBobinler> getBagliBobinler() throws JCoException {
		List<BagliBobinler> bagliBobinL = new ArrayList<BagliBobinler>();

		JCoDestination destination = JCoDestinationManager.getDestination(ABAP_AS);
		JCoFunction function = destination.getRepository().getFunction("ZMM_F_HRCKDS_SIPARISE_BAGLI");

		if (function == null)
			throw new RuntimeException("ZMM_F_HRCKDS_SIPARISE_BAGLI not found in SAP.");

		try {
			function.execute(destination);
		} catch (AbapException e) {
			// System.out.println(e.toString());
			return null;
		}

		JCoTable codes = function.getTableParameterList().getTable("ET_BOBINLER");
		for (int i = 0; i < codes.getNumRows(); i++) {
			BagliBobinler bagliBobin = new BagliBobinler();
			BagliBobinlerPK id = new BagliBobinlerPK();

			codes.setRow(i);
			// set compsite id
			id.setCharg(codes.getString("CHARG"));
			id.setMatnr(codes.getString("MATNR"));
			id.setVbeln(codes.getString("VBELN"));
			id.setPosnr(codes.getString("POSNR"));
			// set bagliBobin object
			bagliBobin.setMamulMatnr(codes.getString("VBAP_MATNR"));
			bagliBobin.setKalab(codes.getBigDecimal("KALAB"));
			bagliBobin.setArbpl(codes.getString("ARBPL")); // is yeri
			bagliBobin.setArcelor(codes.getString("ARCELOR"));
			bagliBobin.setMensei(codes.getString("MENSEI"));
			bagliBobin.setKalinlik(codes.getString("KALINLIK"));
			bagliBobin.setGenislik(codes.getBigDecimal("GENISLIK"));
			bagliBobin.setHrcKalite(codes.getString("HRCKALITE"));

			bagliBobin.setUzunluk(codes.getString("UZUNLUK"));
			bagliBobin.setUrunGrubu(codes.getString("URNTP")); // URNTP
			bagliBobin.setYuzeyGrubu(codes.getString("YZKSN")); // YZKSN
			bagliBobin.setSonKalinlik(codes.getString("HEDEF_KALINLIK")); // HEDEF_KALINLIK
			bagliBobin.setRcmIsyeri(codes.getString("RCMIS")); // RCMIS
			bagliBobin.setGalvaIsyeri(codes.getString("GLVIS")); // GLVIS
			bagliBobin.setHaddeYag(codes.getString("HADDE_YAG")); // HADDE_YAG

			bagliBobin.setId(id);

			bagliBobinL.add(bagliBobin);
			id = null;
			bagliBobin = null;

			// System.out.println(codes.getString("YIL") + '\t' + codes.getString("HAFTA")
			// + '\t' + codes.getString("HAT") + '\t' + codes.getString("CALISMA") );

		}
		return bagliBobinL;
	}

	public static List<CplGecmis> getCplGecmis() throws JCoException {
		List<CplGecmis> cplGecmisL = new ArrayList<CplGecmis>();

		JCoDestination destination = JCoDestinationManager.getDestination(ABAP_AS);
		JCoFunction function = destination.getRepository().getFunction("ZMM_F_HRCKDS_CPL_GECMIS");

		if (function == null)
			throw new RuntimeException("ZMM_F_HRCKDS_CPL_GECMIS not found in SAP.");

		// 6 ay öncesini al .
		Date in = new Date();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -12);
		in = cal.getTime();
		// LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),
		// ZoneId.systemDefault());
		// Date currentDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String yyyyMMdd = sdf.format(in);
		// give the import parameters
		function.getImportParameterList().setValue("START_DATE", yyyyMMdd);

		try {
			function.execute(destination);
		} catch (AbapException e) {
			// System.out.println(e.toString());
			return null;
		}

		JCoTable codes = function.getTableParameterList().getTable("ET_CPLGECMIS");
		for (int i = 0; i < codes.getNumRows(); i++) {
			CplGecmis cplGecmis = new CplGecmis();
			CplGecmisPK id = new CplGecmisPK();

			codes.setRow(i);
			// set compsite id
			id.setKayitTarihi(codes.getDate("OUTDT"));
			id.setRowID(i);
			// set bagliBobin object
			cplGecmis.setUzunluk(codes.getString("UZUNLUK"));
			cplGecmis.setProsesNetSure(codes.getString("NETSURE"));
			cplGecmis.setHedef_Hammadde_Mensei(codes.getString("MENSEI"));
			cplGecmis.setKalinlik(codes.getString("KALINLIK"));
			cplGecmis.setGenislik(codes.getBigDecimal("GENISLIK"));
			cplGecmis.setMiktarKg(codes.getString("MIKTAR"));
			cplGecmis.setKalite(codes.getString("HRCKALITE"));

			cplGecmis.setId(id);

			cplGecmisL.add(cplGecmis);
			id = null;
			cplGecmis = null;

			// System.out.println(codes.getString("YIL") + '\t' + codes.getString("HAFTA")
			// + '\t' + codes.getString("HAT") + '\t' + codes.getString("CALISMA") );

		}
		return cplGecmisL;
	}

	public static List<RcmGecmis> getRcmGecmis() throws JCoException {
		List<RcmGecmis> rcmGecmisL = new ArrayList<RcmGecmis>();

		JCoDestination destination = JCoDestinationManager.getDestination(ABAP_AS);
		JCoFunction function = destination.getRepository().getFunction("ZMM_F_HRCKDS_RCM_GECMIS");

		if (function == null)
			throw new RuntimeException("ZMM_F_HRCKDS_RCM_GECMIS not found in SAP.");

		// 6 ay öncesini al .
		Date in = new Date();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -12);
		in = cal.getTime();
		// LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),
		// ZoneId.systemDefault());
		// Date currentDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String yyyyMMdd = sdf.format(in);

		// give the import parameters
		function.getImportParameterList().setValue("START_DATE", yyyyMMdd);

		try {
			function.execute(destination);
		} catch (AbapException e) {
			// System.out.println(e.toString());
			return null;
		}
		/**/
		JCoTable codes = function.getTableParameterList().getTable("ET_RCMGECMIS");
		for (int i = 0; i < codes.getNumRows(); i++) {
			RcmGecmis rcmGecmis = new RcmGecmis();
			RcmGecmisPK id = new RcmGecmisPK();

			codes.setRow(i);
			// set compsite id
			id.setKayitTarihi(codes.getDate("OUTDT"));
			id.setHat(codes.getString("HAT"));
			id.setRowID(i);
			// set bagliBobin object
			BigDecimal hammaddeKalinlik = codes.getBigDecimal("HM_KALINLIK");
			String hrcKalite = codes.getString("HRCKALITE");
			String kenarTipi = codes.getString("KENDR");
			String mensei = codes.getString("MENSEI");
			BigDecimal miktarKg = codes.getBigDecimal("MIKTAR");
			String rcmSonrakiHat = codes.getString("SONRAKI_HAT");
			BigDecimal reduksiyon = codes.getBigDecimal("REDUKSIYON");
			BigDecimal rwt = codes.getBigDecimal("NETSURE");
			String sertlikGrubu = codes.getString("SERTLIK_GRUBU");
			BigDecimal sonKalinlik = codes.getBigDecimal("SON_KALINLIK");
			String urunGrubu = codes.getString("URNTP");
			String yuzeyGrubu = codes.getString("YZKSN");

			rcmGecmis.setHammaddeKalinlik(hammaddeKalinlik);
			rcmGecmis.setHrcKalite(hrcKalite);
			rcmGecmis.setKenarTipi(kenarTipi);
			rcmGecmis.setMensei(mensei);
			rcmGecmis.setMiktarKg(miktarKg);
			rcmGecmis.setRcmSonrakiHat(rcmSonrakiHat);
			rcmGecmis.setReduksiyon(reduksiyon);
			rcmGecmis.setRwt(rwt);
			rcmGecmis.setSertlikGrubu(sertlikGrubu);
			rcmGecmis.setSonKalinlik(sonKalinlik);
			rcmGecmis.setUrunGrubu(urunGrubu);
			rcmGecmis.setYuzeyGrubu(yuzeyGrubu);

			rcmGecmis.setId(id);

			rcmGecmisL.add(rcmGecmis);
			id = null;
			rcmGecmis = null;

		}
		return rcmGecmisL;
	}
}
