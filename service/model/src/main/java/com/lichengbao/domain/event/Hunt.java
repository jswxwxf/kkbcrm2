/**
 * 
 */
package com.lichengbao.domain.event;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "fes_hcz")
public class Hunt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7454220491798945351L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String mobile;
	
	private String licenseNo;
	
	private String source;
	
	private Long uid;
	
	private Long fromid;
	
	private String address;
	
	@Column(name = "is_send")
	private Boolean sent;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

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
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @param licenseNo the licenseNo to set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}

	/**
	 * @return the fromid
	 */
	public Long getFromid() {
		return fromid;
	}

	/**
	 * @param fromid the fromid to set
	 */
	public void setFromid(Long fromid) {
		this.fromid = fromid;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the sent
	 */
	public Boolean isSent() {
		return sent;
	}

	/**
	 * @param sent the sent to set
	 */
	public void setSent(Boolean sent) {
		this.sent = sent;
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
