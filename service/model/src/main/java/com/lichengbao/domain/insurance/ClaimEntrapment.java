/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lichengbao.domain.insurance.order.Order;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "claim_entrapments")
@PrimaryKeyJoinColumn(name = "order_id")
public class ClaimEntrapment extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6703808175467004417L;
	
	private String name;
	
	private String idCard;
	
	private String engineNo;
	
	@Temporal(TemporalType.DATE)
	private Calendar stopedOn;
	
	private String stopedCert;
	
	private String forfeitCert;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the engineNo
	 */
	public String getEngineNo() {
		return engineNo;
	}

	/**
	 * @param engineNo the engineNo to set
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	/**
	 * @return the stopedOn
	 */
	public Calendar getStopedOn() {
		return stopedOn;
	}

	/**
	 * @param stopedOn the stopedOn to set
	 */
	public void setStopedOn(Calendar stopedOn) {
		this.stopedOn = stopedOn;
	}

	/**
	 * @return the stopedCert
	 */
	public String getStopedCert() {
		return stopedCert;
	}

	/**
	 * @param stopedCert the stopedCert to set
	 */
	public void setStopedCert(String stopedCert) {
		this.stopedCert = stopedCert;
	}

	/**
	 * @return the forfeitCert
	 */
	public String getForfeitCert() {
		return forfeitCert;
	}

	/**
	 * @param forfeitCert the forfeitCert to set
	 */
	public void setForfeitCert(String forfeitCert) {
		this.forfeitCert = forfeitCert;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
