/**
 * 
 */
package com.lichengbao.domain.event;

import java.io.Serializable;
import java.util.Calendar;

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
@Table(name = "fes_comac")
public class Comac implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5305465076410644515L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String openid;
	
	private String drawResult;

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
	 * @return the drawResult
	 */
	public String getDrawResult() {
		return drawResult;
	}

	/**
	 * @param drawResult the drawResult to set
	 */
	public void setDrawResult(String drawResult) {
		this.drawResult = drawResult;
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
