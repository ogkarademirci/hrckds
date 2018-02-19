package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 * The primary key class for the CplGecmis database table.
 * 
 */
@Embeddable
public class CplGecmisPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="RowID")
	@GeneratedValue
	private int rowID;

	@Column(name="KayitTarihi")
	@Temporal(TemporalType.DATE)
	private Date kayitTarihi;

	public CplGecmisPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CplGecmisPK)) {
			return false;
		}
		CplGecmisPK castOther = (CplGecmisPK)other;
		return 
			(this.rowID == castOther.rowID)
			&& this.kayitTarihi.equals(castOther.kayitTarihi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.rowID;
		hash = hash * prime + this.kayitTarihi.hashCode();
		
		return hash;
	}
}