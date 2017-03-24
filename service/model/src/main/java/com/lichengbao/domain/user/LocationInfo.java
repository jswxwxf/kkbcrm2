/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jwang
 *
 */
@Embeddable
public class LocationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4798773343453871444L;

	private String name;
	
	private String nickname;
	
	private String lat;
	
	private String lon;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal accuracy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar epochTime;

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
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 * @return the accuracy
	 */
	public BigDecimal getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(BigDecimal accuracy) {
		this.accuracy = accuracy;
	}

	/**
	 * @return the epochTime
	 */
	public Calendar getEpochTime() {
		return epochTime;
	}

	/**
	 * @param epochTime the epochTime to set
	 */
	public void setEpochTime(Calendar epochTime) {
		this.epochTime = epochTime;
	}
	
}
