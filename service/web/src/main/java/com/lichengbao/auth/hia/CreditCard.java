/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

/**
 * @author jwang
 *
 */
@Entity
public class CreditCard extends BillingDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411390545648601950L;

	@NotNull
	@Column(nullable = false)
	private String number;
	
	@NotNull
	@Column(nullable = false)
	private String expMonth;
	
	@NotNull
	@Column(nullable = false)
	private String expYear;
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * @return the expMonth
	 */
	public String getExpMonth() {
		return expMonth;
	}
	
	/**
	 * @param expMonth the expMonth to set
	 */
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	
	/**
	 * @return the expYear
	 */
	public String getExpYear() {
		return expYear;
	}
	
	/**
	 * @param expYear the expYear to set
	 */
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	
}
