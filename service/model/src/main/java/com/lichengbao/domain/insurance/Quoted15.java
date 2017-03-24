/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.lichengbao.domain.user.User;


/**
 * @author jwang
 *
 */
@Entity
@Table(name = "quoted_15")
public class Quoted15 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6043579050914959362L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;

	private Quoted15Status status;
	
	private Insurance15Info insurance;
	
	private Long accidentCount;
	
	private Long transfer;
	
	private String source;
	
	private Result15Info result;
	
	@Column(precision = 4, scale = 2)
	private BigDecimal discountRate;

	private String quoteDetail;
	
	@Temporal(TemporalType.DATE)
	private Calendar previousExpireDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar registeredOn;
	
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

	/**
	 * @return the status
	 */
	public Quoted15Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Quoted15Status status) {
		this.status = status;
	}

	/**
	 * @return the insurance
	 */
	public Insurance15Info getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(Insurance15Info insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the accidentCount
	 */
	public Long getAccidentCount() {
		return accidentCount;
	}

	/**
	 * @param accidentCount the accidentCount to set
	 */
	public void setAccidentCount(Long accidentCount) {
		this.accidentCount = accidentCount;
	}

	/**
	 * @return the transfer
	 */
	public Long getTransfer() {
		return transfer;
	}

	/**
	 * @param transfer the transfer to set
	 */
	public void setTransfer(Long transfer) {
		this.transfer = transfer;
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
	 * @return the result
	 */
	public Result15Info getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Result15Info result) {
		this.result = result;
	}

	/**
	 * @return the discountRate
	 */
	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return the quoteDetail
	 */
	public String getQuoteDetail() {
		return quoteDetail;
	}

	/**
	 * @param quoteDetail the quoteDetail to set
	 */
	public void setQuoteDetail(String quoteDetail) {
		this.quoteDetail = quoteDetail;
	}

	/**
	 * @return the previousExpireDate
	 */
	public Calendar getPreviousExpireDate() {
		return previousExpireDate;
	}

	/**
	 * @param previousExpireDate the previousExpireDate to set
	 */
	public void setPreviousExpireDate(Calendar previousExpireDate) {
		this.previousExpireDate = previousExpireDate;
	}

	/**
	 * @return the registeredOn
	 */
	public Calendar getRegisteredOn() {
		return registeredOn;
	}

	/**
	 * @param registeredOn the registeredOn to set
	 */
	public void setRegisteredOn(Calendar registeredOn) {
		this.registeredOn = registeredOn;
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
