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
@DiscriminatorValue("1")
public class UserEncashAlipay extends UserEncash {

	/**
	 * 
	 */
	private static final long serialVersionUID = -282303822670134038L;
	
	private String name;
	
	@Column(name = "alipay_account")
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
