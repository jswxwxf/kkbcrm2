/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class QuotedBackup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3827065655390568523L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	
	private InsuranceInfo insurance;
	
	private ResultInfo result;

	private String quoteDetail;
	
	private Quoted15Status status;

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
	 * @return the insurance
	 */
	public InsuranceInfo getInsurance() {
		return insurance;
	}

	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}

	/**
	 * @return the result
	 */
	public ResultInfo getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultInfo result) {
		this.result = result;
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
