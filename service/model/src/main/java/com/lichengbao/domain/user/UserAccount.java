/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "user_accounts")
public class UserAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5907864164334964038L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String openid;
	
	private AccountPlatform platform;
	
	private Long source;
	
	private Long luckymoney;
	
	private String nickname;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the platform
	 */
	public AccountPlatform getPlatform() {
		return platform;
	}

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(AccountPlatform platform) {
		this.platform = platform;
	}

	/**
	 * @return the source
	 */
	public Long getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(Long source) {
		this.source = source;
	}

	/**
	 * @return the luckymoney
	 */
	public Long getLuckymoney() {
		return luckymoney;
	}

	/**
	 * @param luckymoney the luckymoney to set
	 */
	public void setLuckymoney(Long luckymoney) {
		this.luckymoney = luckymoney;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
