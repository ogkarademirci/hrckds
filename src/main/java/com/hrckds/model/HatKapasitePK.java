package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the HatKapasite database table.
 * 
 */
@Embeddable
public class HatKapasitePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Hat")
	private String hat;

	@Column(name="Yil")
	private long yil;

	@Column(name="Hafta")
	private long hafta;

	public HatKapasitePK() {
	}
	public String getHat() {
		return this.hat;
	}
	public void setHat(String hat) {
		this.hat = hat;
	}
	public long getYil() {
		return this.yil;
	}
	public void setYil(long yil) {
		this.yil = yil;
	}
	public long getHafta() {
		return this.hafta;
	}
	public void setHafta(long hafta) {
		this.hafta = hafta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HatKapasitePK)) {
			return false;
		}
		HatKapasitePK castOther = (HatKapasitePK)other;
		return 
			this.hat.equals(castOther.hat)
			&& (this.yil == castOther.yil)
			&& (this.hafta == castOther.hafta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hat.hashCode();
		hash = hash * prime + ((int) (this.yil ^ (this.yil >>> 32)));
		hash = hash * prime + ((int) (this.hafta ^ (this.hafta >>> 32)));
		
		return hash;
	}
}