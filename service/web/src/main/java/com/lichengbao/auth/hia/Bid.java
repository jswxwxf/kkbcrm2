/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jwang
 *
 */
@Entity
public class Bid implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 347848282645164525L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name = "item_id", updatable = false, insertable = false)
	private Item item;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

}
