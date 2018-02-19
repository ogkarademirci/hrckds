package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Sonuclar2 database table.
 * 
 */
@Entity
@NamedQuery(name="Sonuclar2.findAll", query="SELECT s FROM Sonuclar2 s")
public class Sonuclar2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Sonuclar2PK id;

	@Column(name="MalzemeTuru")
	private String malzemeTuru;

	@Column(name="MaxKalinlik")
	private String maxKalinlik;

	@Column(name="Mensei")
	private String mensei;

	@Column(name="MinKalinlik")
	private String minKalinlik;

	public Sonuclar2() {
	}

	public Sonuclar2PK getId() {
		return this.id;
	}

	public void setId(Sonuclar2PK id) {
		this.id = id;
	}

	public String getMalzemeTuru() {
		return this.malzemeTuru;
	}

	public void setMalzemeTuru(String malzemeTuru) {
		this.malzemeTuru = malzemeTuru;
	}

	public String getMaxKalinlik() {
		return this.maxKalinlik;
	}

	public void setMaxKalinlik(String maxKalinlik) {
		this.maxKalinlik = maxKalinlik;
	}

	public String getMensei() {
		return this.mensei;
	}

	public void setMensei(String mensei) {
		this.mensei = mensei;
	}

	public String getMinKalinlik() {
		return this.minKalinlik;
	}

	public void setMinKalinlik(String minKalinlik) {
		this.minKalinlik = minKalinlik;
	}

}