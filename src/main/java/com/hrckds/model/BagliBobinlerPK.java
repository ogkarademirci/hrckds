package com.hrckds.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BagliBobinler database table.
 * 
 */
@Embeddable
public class BagliBobinlerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="Charg")
	private String charg;

	@Column(name="Matnr")
	private String matnr;

	@Column(name="Vbeln")
	private String vbeln;

	@Column(name="Posnr")
	private String posnr;

	public BagliBobinlerPK() {
	}
	public String getCharg() {
		return this.charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	public String getMatnr() {
		return this.matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getVbeln() {
		return this.vbeln;
	}
	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	public String getPosnr() {
		return this.posnr;
	}
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BagliBobinlerPK)) {
			return false;
		}
		BagliBobinlerPK castOther = (BagliBobinlerPK)other;
		return 
			this.charg.equals(castOther.charg)
			&& this.matnr.equals(castOther.matnr)
			&& this.vbeln.equals(castOther.vbeln)
			&& this.posnr.equals(castOther.posnr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.charg.hashCode();
		hash = hash * prime + this.matnr.hashCode();
		hash = hash * prime + this.vbeln.hashCode();
		hash = hash * prime + this.posnr.hashCode();
		
		return hash;
	}
}