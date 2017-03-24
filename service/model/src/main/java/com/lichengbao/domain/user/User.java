/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author jwang
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6456905645534310553L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String mobile;
	
	@Column(name = "name")
	private String username;
	
	private String email;
	
	@JsonIgnore
	private String password;
	
	@Column(name = "awrads")
	private Long awards = 0l;
	
	@Column(name = "total_awrads")
	private Long totalAwards = 0l;
	
	private String avatar;
	
	private String realname;
	
	private String idCard;
	
	private DeviceType deviceType;
	
	private String openid;
	
	private String pushToken;
	
	private String rememberToken;
	
	private String refCode;
	
	private String promoCode;
	
	private UserStatus status = UserStatus.Available;
	
	private UserActivated activated;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<UserAccount> accounts = new HashSet<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the awards
	 */
	public Long getAwards() {
		return awards;
	}

	/**
	 * @param awards the awards to set
	 */
	public void setAwards(Long awards) {
		this.awards = awards;
	}

	/**
	 * @return the totalAwards
	 */
	public Long getTotalAwards() {
		return totalAwards;
	}

	/**
	 * @param totalAwards the totalAwards to set
	 */
	public void setTotalAwards(Long totalAwards) {
		this.totalAwards = totalAwards;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
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
	 * @return the deviceType
	 */
	public DeviceType getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
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
	 * @return the pushToken
	 */
	public String getPushToken() {
		return pushToken;
	}

	/**
	 * @param pushToken the pushToken to set
	 */
	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	/**
	 * @return the rememberToken
	 */
	public String getRememberToken() {
		return rememberToken;
	}

	/**
	 * @param rememberToken the rememberToken to set
	 */
	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	/**
	 * @return the refCode
	 */
	public String getRefCode() {
		return refCode;
	}

	/**
	 * @param refCode the refCode to set
	 */
	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	/**
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(UserStatus status) {
		this.status = status;
	}

	/**
	 * @return the activated
	 */
	public UserActivated getActivated() {
		return activated;
	}

	/**
	 * @param activated the activated to set
	 */
	public void setActivated(UserActivated activated) {
		this.activated = activated;
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
	
	/**
	 * @return the accounts
	 */
	public Set<UserAccount> getAccounts() {
		return accounts;
	}
	
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Set<UserAccount> accounts) {
		this.accounts = accounts;
	}
	
}
