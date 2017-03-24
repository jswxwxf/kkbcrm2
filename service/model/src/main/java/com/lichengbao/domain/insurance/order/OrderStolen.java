/**
 * 
 */
package com.lichengbao.domain.insurance.order;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
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
@Table(name = "orders_stolen")
@PrimaryKeyJoinColumn(name = "order_id")
public class OrderStolen extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9065861779746978343L;

	private String mobile;

	private String licenseNo;

	private String transkey;

	private String source;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Vehicle vehicle;
	
	private OrderStolenStatus status;
	
	private String name;
	
	private String idCard;
	
	private String openid;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal standardLimit;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal extraLimit;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal finalPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar forwardTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar getDay;

	@Temporal(TemporalType.DATE)
	private Calendar startDay;

	@Temporal(TemporalType.DATE)
	private Calendar endDay;
	
	private String comments;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

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
	 * @return the transkey
	 */
	public String getTranskey() {
		return transkey;
	}

	/**
	 * @param transkey the transkey to set
	 */
	public void setTranskey(String transkey) {
		this.transkey = transkey;
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
	 * @return the status
	 */
	public OrderStolenStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStolenStatus status) {
		this.status = status;
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
	 * @return the standardLimit
	 */
	public BigDecimal getStandardLimit() {
		return standardLimit;
	}

	/**
	 * @param standardLimit the standardLimit to set
	 */
	public void setStandardLimit(BigDecimal standardLimit) {
		this.standardLimit = standardLimit;
	}

	/**
	 * @return the extraLimit
	 */
	public BigDecimal getExtraLimit() {
		return extraLimit;
	}

	/**
	 * @param extraLimit the extraLimit to set
	 */
	public void setExtraLimit(BigDecimal extraLimit) {
		this.extraLimit = extraLimit;
	}

	/**
	 * @return the finalPrice
	 */
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	/**
	 * @param finalPrice the finalPrice to set
	 */
	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	/**
	 * @return the forwardTime
	 */
	public Calendar getForwardTime() {
		return forwardTime;
	}

	/**
	 * @param forwardTime the forwardTime to set
	 */
	public void setForwardTime(Calendar forwardTime) {
		this.forwardTime = forwardTime;
	}

	/**
	 * @return the getDay
	 */
	public Calendar getGetDay() {
		return getDay;
	}

	/**
	 * @param getDay the getDay to set
	 */
	public void setGetDay(Calendar getDay) {
		this.getDay = getDay;
	}

	/**
	 * @return the startDay
	 */
	public Calendar getStartDay() {
		return startDay;
	}

	/**
	 * @param startDay the startDay to set
	 */
	public void setStartDay(Calendar startDay) {
		this.startDay = startDay;
	}

	/**
	 * @return the endDay
	 */
	public Calendar getEndDay() {
		return endDay;
	}

	/**
	 * @param endDay the endDay to set
	 */
	public void setEndDay(Calendar endDay) {
		this.endDay = endDay;
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
