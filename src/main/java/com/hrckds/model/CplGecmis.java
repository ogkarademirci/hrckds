package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CplGecmis database table.
 * 
 */
@Entity
@NamedQuery(name="CplGecmis.findAll", query="SELECT c FROM CplGecmis c")
public class CplGecmis implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CplGecmisPK id;

	@Column(name="Genislik")
	private BigDecimal genislik;

	@Column(name="Hedef_Hammadde_Mensei")
	private String hedef_Hammadde_Mensei;

	@Column(name="Kalinlik")
	private String kalinlik;

	@Column(name="Kalite")
	private String kalite;

	@Column(name="MiktarKg")
	private String miktarKg;

	@Column(name="ProsesNetSure")
	private String prosesNetSure;

	@Column(name="Uzunluk")
	private String uzunluk;

	public CplGecmis() {
	}

	public CplGecmisPK getId() {
		return this.id;
	}

	public void setId(CplGecmisPK id) {
		this.id = id;
	}

	public BigDecimal getGenislik() {
		return this.genislik;
	}

	public void setGenislik(BigDecimal genislik) {
		this.genislik = genislik;
	}

	public String getHedef_Hammadde_Mensei() {
		return this.hedef_Hammadde_Mensei;
	}

	public void setHedef_Hammadde_Mensei(String hedef_Hammadde_Mensei) {
		this.hedef_Hammadde_Mensei = hedef_Hammadde_Mensei;
	}

	public String getKalinlik() {
		return this.kalinlik;
	}

	public void setKalinlik(String kalinlik) {
		this.kalinlik = kalinlik;
	}

	public String getKalite() {
		return this.kalite;
	}

	public void setKalite(String kalite) {
		this.kalite = kalite;
	}

	public String getMiktarKg() {
		return this.miktarKg;
	}

	public void setMiktarKg(String miktarKg) {
		this.miktarKg = miktarKg;
	}

	public String getProsesNetSure() {
		return this.prosesNetSure;
	}

	public void setProsesNetSure(String prosesNetSure) {
		this.prosesNetSure = prosesNetSure;
	}

	public String getUzunluk() {
		return this.uzunluk;
	}

	public void setUzunluk(String uzunluk) {
		this.uzunluk = uzunluk;
	}

}