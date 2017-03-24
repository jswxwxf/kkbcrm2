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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.lichengbao.domain.common.Device;
import com.lichengbao.domain.insurance.Insurance15Info;
import com.lichengbao.domain.insurance.Quoted15;
import com.lichengbao.domain.insurance.Result15Info;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "orders_15")
@PrimaryKeyJoinColumn(name = "order_id")
public class Order15 extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6134943125665652640L;
	
	private Long eventId;

	private String tradeNo;

	private Order15Status status;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quote_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Quoted15 quote;

	private Insurance15Info insurance;

	private Result15Info result;

	@Column(precision = 10, scale = 2)
	private BigDecimal standardPrice;

	@Column(precision = 10, scale = 2)
	private BigDecimal payPrice;

	private String source;

	private PayType payType;

	private Long hasCoupon;

	@Column(precision = 10, scale = 2)
	private BigDecimal couponPrice;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Device device;

	private Long accidents;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the tradeNo
	 */
	public String getTradeNo() {
		return tradeNo;
	}

	/**
	 * @param tradeNo
	 *            the tradeNo to set
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	/**
	 * @return the status
	 */
	public Order15Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Order15Status status) {
		this.status = status;
	}

	/**
	 * @return the quote
	 */
	public Quoted15 getQuote() {
		return quote;
	}

	/**
	 * @param quote
	 *            the quote to set
	 */
	public void setQuote(Quoted15 quote) {
		this.quote = quote;
	}

	/**
	 * @return the insurance
	 */
	public Insurance15Info getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance
	 *            the insurance to set
	 */
	public void setInsurance(Insurance15Info insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the result
	 */
	public Result15Info getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Result15Info result) {
		this.result = result;
	}

	/**
	 * @return the standardPrice
	 */
	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	/**
	 * @param standardPrice
	 *            the standardPrice to set
	 */
	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	/**
	 * @return the payPrice
	 */
	public BigDecimal getPayPrice() {
		return payPrice;
	}

	/**
	 * @param payPrice
	 *            the payPrice to set
	 */
	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the payType
	 */
	public PayType getPayType() {
		return payType;
	}

	/**
	 * @param payType
	 *            the payType to set
	 */
	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	/**
	 * @return the hasCoupon
	 */
	public Long getHasCoupon() {
		return hasCoupon;
	}

	/**
	 * @param hasCoupon
	 *            the hasCoupon to set
	 */
	public void setHasCoupon(Long hasCoupon) {
		this.hasCoupon = hasCoupon;
	}

	/**
	 * @return the couponPrice
	 */
	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	/**
	 * @param couponPrice
	 *            the couponPrice to set
	 */
	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	/**
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * @param device
	 *            the device to set
	 */
	public void setDevice(Device device) {
		this.device = device;
	}

	/**
	 * @return the accidents
	 */
	public Long getAccidents() {
		return accidents;
	}

	/**
	 * @param accidents
	 *            the accidents to set
	 */
	public void setAccidents(Long accidents) {
		this.accidents = accidents;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
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
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

}
