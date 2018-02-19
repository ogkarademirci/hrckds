package com.hrckds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the Sonuclar2 database table.
 * 
 */
@Embeddable
public class Sonuclar2PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RowID")
	private int rowID;

	@Column(name="KayitTarihi")
	@Temporal(TemporalType.DATE)
	private Date kayitTarihi;

	@Column(name="KullaniciID")
	private String kullaniciID ;

	@Column(name="SenaryoID")
	private int senaryoID;

	public Sonuclar2PK() {
	}
	public int getRowID() {
		return this.rowID;
	}
	public void setRowID(int rowID) {
		this.rowID = rowID;
	}
	public Date getKayitTarihi() {
		return this.kayitTarihi;
	}
	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}
	public String getKullaniciID() {
		return this.kullaniciID;
	}
	public void setKullaniciID(String kullaniciID) {
		this.kullaniciID = kullaniciID;
	}
	public int getSenaryoID() {
		return this.senaryoID;
	}
	public void setSenaryoID(int senaryoID) {
		this.senaryoID = senaryoID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Sonuclar2PK)) {
			return false;
		}
		Sonuclar2PK castOther = (Sonuclar2PK)other;
		return 
			(this.rowID == castOther.rowID)
			&& this.kayitTarihi.equals(castOther.kayitTarihi)
			&& this.kullaniciID.equals(castOther.kullaniciID)
			&& (this.senaryoID == castOther.senaryoID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rowID;
		hash = hash * prime + this.kayitTarihi.hashCode();
		hash = hash * prime + this.kullaniciID.hashCode();
		hash = hash * prime + this.senaryoID;
		
		return hash;
	}
}