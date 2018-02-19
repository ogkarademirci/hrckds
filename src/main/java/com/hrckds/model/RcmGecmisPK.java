package com.hrckds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the RcmGecmis database table.
 * 
 */
@Embeddable
public class RcmGecmisPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RowID")
	private int rowID;

	@Column(name="Hat")
	private String hat;

	@Column(name="KayitTarihi")
	@Temporal(TemporalType.DATE)
	private Date kayitTarihi;

	public RcmGecmisPK() {
	}
	public int getRowID() {
		return this.rowID;
	}
	public void setRowID(int rowID) {
		this.rowID = rowID;
	}
	public String getHat() {
		return this.hat;
	}
	public void setHat(String hat) {
		this.hat = hat;
	}
	public Date getKayitTarihi() {
		return this.kayitTarihi;
	}
	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RcmGecmisPK)) {
			return false;
		}
		RcmGecmisPK castOther = (RcmGecmisPK)other;
		return 
			(this.rowID == castOther.rowID)
			&& this.hat.equals(castOther.hat)
			&& this.kayitTarihi.equals(castOther.kayitTarihi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rowID;
		hash = hash * prime + this.hat.hashCode();
		hash = hash * prime + this.kayitTarihi.hashCode();
		
		return hash;
	}
}