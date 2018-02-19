package com.hrckds.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the HatKapasite database table.
 * 
 */
@Entity
@NamedQuery(name="HatKapasite.findAll", query="SELECT h FROM HatKapasite h")
public class HatKapasite implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HatKapasitePK id;

	@Column(name="CalismaSure")
	private int calismaSure;

	public HatKapasite() {
	}

	public HatKapasitePK getId() {
		return this.id;
	}

	public void setId(HatKapasitePK id) {
		this.id = id;
	}

	public int getCalismaSure() {
		return this.calismaSure;
	}

	public void setCalismaSure(int calismaSure) {
		this.calismaSure = calismaSure;
	}

}