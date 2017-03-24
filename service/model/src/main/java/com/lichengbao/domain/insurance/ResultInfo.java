/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author jwang
 *
 */
@MappedSuperclass
@Embeddable
public class ResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777763983113411641L;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal commercial;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal compulsory;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal tax;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Calendar validFrom;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Calendar validUntil;

	/**
	 * @return the commercial
	 */
	public BigDecimal getCommercial() {
		return commercial;
	}

	/**
	 * @param commercial the commercial to set
	 */
	public void setCommercial(BigDecimal commercial) {
		this.commercial = commercial;
	}

	/**
	 * @return the compulsory
	 */
	public BigDecimal getCompulsory() {
		return compulsory;
	}

	/**
	 * @param compulsory the compulsory to set
	 */
	public void setCompulsory(BigDecimal compulsory) {
		this.compulsory = compulsory;
	}

	/**
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * @return the validFrom
	 */
	public Calendar getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Calendar validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validUntil
	 */
	public Calendar getValidUntil() {
		return validUntil;
	}

	/**
	 * @param validUntil the validUntil to set
	 */
	public void setValidUntil(Calendar validUntil) {
		this.validUntil = validUntil;
	}
	
}
