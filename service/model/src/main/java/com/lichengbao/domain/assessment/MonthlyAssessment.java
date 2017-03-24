/**
 * 
 */
package com.lichengbao.domain.assessment;

import java.io.Serializable;
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
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lichengbao.domain.common.Vehicle;
import com.lichengbao.domain.user.User;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "monthly_assessments")
public class MonthlyAssessment implements Serializable {
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Vehicle vehicle;
	
	private String content;
	
	@Type(type = "com.lichengbao.domain.assessment.MonthlyAssessmentResultUserType")
	@Column(name = "content", insertable = false, updatable = false)
	private MonthlyAssessmentResult result;

	private Integer stage;

	private String grade;

	private Integer level;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar startOn;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar endOn;

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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return the result
	 */
	public MonthlyAssessmentResult getResult() {
		return result;
	}
	
	/**
	 * @param result the result to set
	 */
	public void setResult(MonthlyAssessmentResult result) {
		this.result = result;
	}

	/**
	 * @return the stage
	 */
	public Integer getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Integer stage) {
		this.stage = stage;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the startOn
	 */
	public Calendar getStartOn() {
		return startOn;
	}

	/**
	 * @param startOn the startOn to set
	 */
	public void setStartOn(Calendar startOn) {
		this.startOn = startOn;
	}

	/**
	 * @return the endOn
	 */
	public Calendar getEndOn() {
		return endOn;
	}

	/**
	 * @param endOn the endOn to set
	 */
	public void setEndOn(Calendar endOn) {
		this.endOn = endOn;
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
