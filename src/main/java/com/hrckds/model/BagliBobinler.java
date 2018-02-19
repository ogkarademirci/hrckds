package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the BagliBobinler database table.
 * 
 */
@Entity
@NamedQuery(name = "BagliBobinler.findAll", query = "SELECT b FROM BagliBobinler b")
public class BagliBobinler implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BagliBobinlerPK id;

	@Column(name = "Arbpl")
	private String arbpl;

	@Column(name = "Arcelor")
	private String arcelor;

	@Column(name = "Kalab")
	private BigDecimal kalab;

	@Column(name = "MamulMatnr")
	private String mamulMatnr;

	@Column(name = "Kalinlik")
	private String kalinlik;
	
	@Column(name = "Genislik")
	private BigDecimal genislik;
	
	@Column(name = "Mensei")
	private String mensei;
	
	@Column(name = "UrunGrubu")
	private String urunGrubu;
	
	@Column(name = "YuzeyGrubu")
	private String yuzeyGrubu;
	
	@Column(name = "SonKalinlik")
	private String sonKalinlik;

	@Column(name = "HrcKalite")
	private String hrcKalite;

	@Column(name="Uzunluk")
	private String uzunluk;
	
	@Column(name = "RcmIsyeri")
	private String rcmIsyeri;

	@Column(name = "GalvaIsyeri")
	private String galvaIsyeri;
	
	@Column(name = "HaddeYag")
	private String haddeYag;
	
	
	public BagliBobinler() {
	}

	public BagliBobinlerPK getId() {
		return this.id;
	}

	public void setId(BagliBobinlerPK id) {
		this.id = id;
	}

	public String getArbpl() {
		return this.arbpl;
	}

	public void setArbpl(String arbpl) {
		this.arbpl = arbpl;
	}

	public String getArcelor() {
		return this.arcelor;
	}

	public void setArcelor(String arcelor) {
		this.arcelor = arcelor;
	}

	public BigDecimal getKalab() {
		return this.kalab;
	}

	public void setKalab(BigDecimal kalab) {
		this.kalab = kalab;
	}

	public String getMamulMatnr() {
		return this.mamulMatnr;
	}

	public void setMamulMatnr(String mamulMatnr) {
		this.mamulMatnr = mamulMatnr;
	}

	public String getKalinlik() {
		return kalinlik;
	}

	public void setKalinlik(String kalinlik) {
		this.kalinlik = kalinlik;
	}

	public BigDecimal getGenislik() {
		return genislik;
	}

	public void setGenislik(BigDecimal genislik) {
		this.genislik = genislik;
	}

	public String getMensei() {
		return mensei;
	}

	public void setMensei(String mensei) {
		this.mensei = mensei;
	}

	public String getUrunGrubu() {
		return urunGrubu;
	}

	public void setUrunGrubu(String urunGrubu) {
		this.urunGrubu = urunGrubu;
	}

	public String getYuzeyGrubu() {
		return yuzeyGrubu;
	}

	public void setYuzeyGrubu(String yuzeyGrubu) {
		this.yuzeyGrubu = yuzeyGrubu;
	}

	public String getSonKalinlik() {
		return sonKalinlik;
	}

	public void setSonKalinlik(String sonKalinlik) {
		this.sonKalinlik = sonKalinlik;
	}

	public String getHrcKalite() {
		return hrcKalite;
	}

	public void setHrcKalite(String hrcKalite) {
		this.hrcKalite = hrcKalite;
	}

	public String getUzunluk() {
		return uzunluk;
	}

	public void setUzunluk(String uzunluk) {
		this.uzunluk = uzunluk;
	}

	public String getRcmIsyeri() {
		return rcmIsyeri;
	}

	public void setRcmIsyeri(String rcmIsyeri) {
		this.rcmIsyeri = rcmIsyeri;
	}

	public String getGalvaIsyeri() {
		return galvaIsyeri;
	}

	public void setGalvaIsyeri(String galvaIsyeri) {
		this.galvaIsyeri = galvaIsyeri;
	}

	public String getHaddeYag() {
		return haddeYag;
	}

	public void setHaddeYag(String haddeYag) {
		this.haddeYag = haddeYag;
	}

}