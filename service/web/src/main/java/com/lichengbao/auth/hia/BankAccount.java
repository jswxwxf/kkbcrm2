/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author jwang
 *
 */
@Entity
public class BankAccount extends BillingDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6943742184887428992L;

	@Column(nullable = false)
	private String account;
	
	@Column(nullable = false)
	private String bankname;
	
	@Column(nullable = false)
	private String swift;

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/**
	 * @return the bankname
	 */
	public String getBankname() {
		return bankname;
	}
	
	/**
	 * @param bankname the bankname to set
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	/**
	 * @return the swift
	 */
	public String getSwift() {
		return swift;
	}
	
	/**
	 * @param swift the swift to set
	 */
	public void setSwift(String swift) {
		this.swift = swift;
	}
	
}
