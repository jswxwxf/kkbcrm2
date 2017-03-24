/**
 * 
 */
package com.lichengbao.domain.insurance.order;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.lichengbao.domain.common.Vehicle;


/**
 * @author jwang
 *
 */
@Entity
@Table(name = "orders_entrapments")
@PrimaryKeyJoinColumn(name = "order_id")
public class OrderEntrapment extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4486302041972537265L;

	private String licenseNo;

	private String mobile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Vehicle vehicle;
	
	private String name;
	
	private OrderEntrapmentStatus status;

	@Temporal(TemporalType.DATE)
	private Calendar gotOn;
	
	@Temporal(TemporalType.DATE)
	private Calendar expiredOn;
	
	@Temporal(TemporalType.DATE)
	private Calendar activedOn;
	
	@Temporal(TemporalType.DATE)
	private Calendar validateFrom;
	
	@Temporal(TemporalType.DATE)
	private Calendar validateTo;
	
	@Temporal(TemporalType.DATE)
	private Calendar overOn;
	
	@Temporal(TemporalType.DATE)
	private Calendar issuedOn;
	
	private Long standardAmount;

	private Long extraAmount;

	private Long finalAmount;
	
	private String comments;
	
	private Long origin;
	
	private Long originSecond;
	
	private Long friendLevel;
	
	private Long friendNum;
	
	private Boolean flagFes;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

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
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

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
	 * @return the status
	 */
	public OrderEntrapmentStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderEntrapmentStatus status) {
		this.status = status;
	}

	/**
	 * @return the gotOn
	 */
	public Calendar getGotOn() {
		return gotOn;
	}

	/**
	 * @param gotOn the gotOn to set
	 */
	public void setGotOn(Calendar gotOn) {
		this.gotOn = gotOn;
	}

	/**
	 * @return the expiredOn
	 */
	public Calendar getExpiredOn() {
		return expiredOn;
	}

	/**
	 * @param expiredOn the expiredOn to set
	 */
	public void setExpiredOn(Calendar expiredOn) {
		this.expiredOn = expiredOn;
	}

	/**
	 * @return the activedOn
	 */
	public Calendar getActivedOn() {
		return activedOn;
	}

	/**
	 * @param activedOn the activedOn to set
	 */
	public void setActivedOn(Calendar activedOn) {
		this.activedOn = activedOn;
	}

	/**
	 * @return the validateFrom
	 */
	public Calendar getValidateFrom() {
		return validateFrom;
	}

	/**
	 * @param validateFrom the validateFrom to set
	 */
	public void setValidateFrom(Calendar validateFrom) {
		this.validateFrom = validateFrom;
	}

	/**
	 * @return the validateTo
	 */
	public Calendar getValidateTo() {
		return validateTo;
	}

	/**
	 * @param validateTo the validateTo to set
	 */
	public void setValidateTo(Calendar validateTo) {
		this.validateTo = validateTo;
	}

	/**
	 * @return the overOn
	 */
	public Calendar getOverOn() {
		return overOn;
	}

	/**
	 * @param overOn the overOn to set
	 */
	public void setOverOn(Calendar overOn) {
		this.overOn = overOn;
	}

	/**
	 * @return the issuedOn
	 */
	public Calendar getIssuedOn() {
		return issuedOn;
	}

	/**
	 * @param issuedOn the issuedOn to set
	 */
	public void setIssuedOn(Calendar issuedOn) {
		this.issuedOn = issuedOn;
	}

	/**
	 * @return the standardAmount
	 */
	public Long getStandardAmount() {
		return standardAmount;
	}

	/**
	 * @param standardAmount the standardAmount to set
	 */
	public void setStandardAmount(Long standardAmount) {
		this.standardAmount = standardAmount;
	}

	/**
	 * @return the extraAmount
	 */
	public Long getExtraAmount() {
		return extraAmount;
	}

	/**
	 * @param extraAmount the extraAmount to set
	 */
	public void setExtraAmount(Long extraAmount) {
		this.extraAmount = extraAmount;
	}

	/**
	 * @return the finalAmount
	 */
	public Long getFinalAmount() {
		return finalAmount;
	}

	/**
	 * @param finalAmount the finalAmount to set
	 */
	public void setFinalAmount(Long finalAmount) {
		this.finalAmount = finalAmount;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the origin
	 */
	public Long getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(Long origin) {
		this.origin = origin;
	}

	/**
	 * @return the originSecond
	 */
	public Long getOriginSecond() {
		return originSecond;
	}

	/**
	 * @param originSecond the originSecond to set
	 */
	public void setOriginSecond(Long originSecond) {
		this.originSecond = originSecond;
	}

	/**
	 * @return the friendLevel
	 */
	public Long getFriendLevel() {
		return friendLevel;
	}

	/**
	 * @param friendLevel the friendLevel to set
	 */
	public void setFriendLevel(Long friendLevel) {
		this.friendLevel = friendLevel;
	}

	/**
	 * @return the friendNum
	 */
	public Long getFriendNum() {
		return friendNum;
	}

	/**
	 * @param friendNum the friendNum to set
	 */
	public void setFriendNum(Long friendNum) {
		this.friendNum = friendNum;
	}

	/**
	 * @return the flagFes
	 */
	public Boolean getFlagFes() {
		return flagFes;
	}

	/**
	 * @param flagFes the flagFes to set
	 */
	public void setFlagFes(Boolean flagFes) {
		this.flagFes = flagFes;
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
