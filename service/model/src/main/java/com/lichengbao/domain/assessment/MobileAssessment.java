/**
 * 
 */
package com.lichengbao.domain.assessment;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lichengbao.domain.user.User;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "mobile_assessments")
public class MobileAssessment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 488644981771412369L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	
	private Long distance;
	
	private Long duration;
	
	private Long maxSpeed;
	
	private Long avgSpeed;
	
	private Long suddenAcc;
	
	private Long suddenBrake;
	
	private Long suddenTurn;
	
	private Long speeding;

	@Column(precision = 10, scale = 2)
	private BigDecimal score;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
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
	 * @return the distance
	 */
	public Long getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Long distance) {
		this.distance = distance;
	}

	/**
	 * @return the duration
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	/**
	 * @return the maxSpeed
	 */
	public Long getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(Long maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @return the avgSpeed
	 */
	public Long getAvgSpeed() {
		return avgSpeed;
	}

	/**
	 * @param avgSpeed the avgSpeed to set
	 */
	public void setAvgSpeed(Long avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	/**
	 * @return the suddenAcc
	 */
	public Long getSuddenAcc() {
		return suddenAcc;
	}

	/**
	 * @param suddenAcc the suddenAcc to set
	 */
	public void setSuddenAcc(Long suddenAcc) {
		this.suddenAcc = suddenAcc;
	}

	/**
	 * @return the suddenBrake
	 */
	public Long getSuddenBrake() {
		return suddenBrake;
	}

	/**
	 * @param suddenBrake the suddenBrake to set
	 */
	public void setSuddenBrake(Long suddenBrake) {
		this.suddenBrake = suddenBrake;
	}

	/**
	 * @return the suddenTurn
	 */
	public Long getSuddenTurn() {
		return suddenTurn;
	}

	/**
	 * @param suddenTurn the suddenTurn to set
	 */
	public void setSuddenTurn(Long suddenTurn) {
		this.suddenTurn = suddenTurn;
	}

	/**
	 * @return the speeding
	 */
	public Long getSpeeding() {
		return speeding;
	}

	/**
	 * @param speeding the speeding to set
	 */
	public void setSpeeding(Long speeding) {
		this.speeding = speeding;
	}

	/**
	 * @return the score
	 */
	public BigDecimal getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(BigDecimal score) {
		this.score = score;
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
