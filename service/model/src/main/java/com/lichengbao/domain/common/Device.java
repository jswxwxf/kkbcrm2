/**
 * 
 */
package com.lichengbao.domain.common;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "devices")
public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7579340475458987192L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String imei;
	
	private String code;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "style_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private VehicleModel model;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Vehicle vehicle;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Calendar activatedAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Calendar lastConnAt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the model
	 */
	public VehicleModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(VehicleModel model) {
		this.model = model;
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
	 * @return the activatedAt
	 */
	public Calendar getActivatedAt() {
		return activatedAt;
	}
	
	/**
	 * @param activatedAt the activatedAt to set
	 */
	public void setActivatedAt(Calendar activatedAt) {
		this.activatedAt = activatedAt;
	}
	
	/**
	 * @return the lastConnAt
	 */
	public Calendar getLastConnAt() {
		return lastConnAt;
	}
	
	/**
	 * @param lastConnAt the lastConnAt to set
	 */
	public void setLastConnAt(Calendar lastConnAt) {
		this.lastConnAt = lastConnAt;
	}

}
