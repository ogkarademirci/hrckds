package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RcmGecmis database table.
 * 
 */
@Entity
@NamedQuery(name="RcmGecmis.findAll", query="SELECT r FROM RcmGecmis r")
public class RcmGecmis implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RcmGecmisPK id;

	@Column(name="HammaddeKalinlik")
	private BigDecimal hammaddeKalinlik;

	@Column(name="HrcKalite")
	private String hrcKalite;

	@Column(name="KenarTipi")
	private String kenarTipi;

	@Column(name="Mensei")
	private String mensei;

	@Column(name="MiktarKg")
	private BigDecimal miktarKg;

	@Column(name="RcmSonrakiHat")
	private String rcmSonrakiHat;

	@Column(name="Reduksiyon")
	private BigDecimal reduksiyon;

	@Column(name="Rwt")
	private BigDecimal rwt;

	@Column(name="SertlikGrubu")
	private String sertlikGrubu;

	@Column(name="SonKalinlik")
	private BigDecimal sonKalinlik;

	@Column(name="UrunGrubu")
	private String urunGrubu;

	@Column(name="YuzeyGrubu")
	private String yuzeyGrubu;

	public RcmGecmis() {
	}

	public RcmGecmisPK getId() {
		return this.id;
	}

	public void setId(RcmGecmisPK id) {
		this.id = id;
	}

	public BigDecimal getHammaddeKalinlik() {
		return this.hammaddeKalinlik;
	}

	public void setHammaddeKalinlik(BigDecimal hammaddeKalinlik) {
		this.hammaddeKalinlik = hammaddeKalinlik;
	}

	public String getHrcKalite() {
		return this.hrcKalite;
	}

	public void setHrcKalite(String hrcKalite) {
		this.hrcKalite = hrcKalite;
	}

	public String getKenarTipi() {
		return this.kenarTipi;
	}

	public void setKenarTipi(String kenarTipi) {
		this.kenarTipi = kenarTipi;
	}

	public String getMensei() {
		return this.mensei;
	}

	public void setMensei(String mensei) {
		this.mensei = mensei;
	}

	public BigDecimal getMiktarKg() {
		return this.miktarKg;
	}

	public void setMiktarKg(BigDecimal miktarKg) {
		this.miktarKg = miktarKg;
	}

	public String getRcmSonrakiHat() {
		return this.rcmSonrakiHat;
	}

	public void setRcmSonrakiHat(String rcmSonrakiHat) {
		this.rcmSonrakiHat = rcmSonrakiHat;
	}

	public BigDecimal getReduksiyon() {
		return this.reduksiyon;
	}

	public void setReduksiyon(BigDecimal reduksiyon) {
		this.reduksiyon = reduksiyon;
	}

	public BigDecimal getRwt() {
		return this.rwt;
	}

	public void setRwt(BigDecimal rwt) {
		this.rwt = rwt;
	}

	public String getSertlikGrubu() {
		return this.sertlikGrubu;
	}

	public void setSertlikGrubu(String sertlikGrubu) {
		this.sertlikGrubu = sertlikGrubu;
	}

	public BigDecimal getSonKalinlik() {
		return this.sonKalinlik;
	}

	public void setSonKalinlik(BigDecimal sonKalinlik) {
		this.sonKalinlik = sonKalinlik;
	}

	public String getUrunGrubu() {
		return this.urunGrubu;
	}

	public void setUrunGrubu(String urunGrubu) {
		this.urunGrubu = urunGrubu;
	}

	public String getYuzeyGrubu() {
		return this.yuzeyGrubu;
	}

	public void setYuzeyGrubu(String yuzeyGrubu) {
		this.yuzeyGrubu = yuzeyGrubu;
	}

}