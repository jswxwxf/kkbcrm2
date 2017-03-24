/**
 * 
 */
package com.lichengbao.domain.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author jwang
 *
 */
@Entity
@DiscriminatorValue("2")
public class UserEncashBank extends UserEncash {

	/**
	 * 
	 */
	private static final long serialVersionUID = 512100500384505821L;
	
	private String name;
	
	private String bank;
	
	@Column(name = "bank_account")
	private String account;

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
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

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

}
