/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lichengbao.domain.common.Vehicle;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "user_assessments")
public class UserVehicleAssessment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6353533861614424545L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	private Long identity;
	
	private Long drivingExperience;
	
	private Long drivingRoutine;
	
	private Long drivingHabit;
	
	private Long drivingMileage;
	
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
	 * @return the identity
	 */
	public Long getIdentity() {
		return identity;
	}

	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	/**
	 * @return the drivingExperience
	 */
	public Long getDrivingExperience() {
		return drivingExperience;
	}

	/**
	 * @param drivingExperience the drivingExperience to set
	 */
	public void setDrivingExperience(Long drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	/**
	 * @return the drivingRoutine
	 */
	public Long getDrivingRoutine() {
		return drivingRoutine;
	}

	/**
	 * @param drivingRoutine the drivingRoutine to set
	 */
	public void setDrivingRoutine(Long drivingRoutine) {
		this.drivingRoutine = drivingRoutine;
	}

	/**
	 * @return the drivingHabit
	 */
	public Long getDrivingHabit() {
		return drivingHabit;
	}

	/**
	 * @param drivingHabit the drivingHabit to set
	 */
	public void setDrivingHabit(Long drivingHabit) {
		this.drivingHabit = drivingHabit;
	}

	/**
	 * @return the drivingMileage
	 */
	public Long getDrivingMileage() {
		return drivingMileage;
	}

	/**
	 * @param drivingMileage the drivingMileage to set
	 */
	public void setDrivingMileage(Long drivingMileage) {
		this.drivingMileage = drivingMileage;
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
