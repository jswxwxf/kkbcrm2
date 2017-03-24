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
@Table(name = "vehicles")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5435032365657960625L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	@NotFound(action = NotFoundAction.IGNORE)
	private User user = new User();
	
	private String city;
	
	private VehicleInfo vehicleInfo;
	
	private String licenseVehicle;
	
	private String licenseModel;
	
	private String oilType;
	
	private String type;
	
	private String owner;
	
	private String purpose;
	
	private String address;
	
	private Boolean meetPolicy;
	
	@Temporal(TemporalType.DATE)
	private Calendar issuedOn;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar registeredOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Calendar gpsUpdatedAt;

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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the vehicleInfo
	 */
	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	/**
	 * @param vehicleInfo the vehicleInfo to set
	 */
	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	/**
	 * @return the licenseVehicle
	 */
	public String getLicenseVehicle() {
		return licenseVehicle;
	}

	/**
	 * @param licenseVehicle the licenseVehicle to set
	 */
	public void setLicenseVehicle(String licenseVehicle) {
		this.licenseVehicle = licenseVehicle;
	}

	/**
	 * @return the licenseModel
	 */
	public String getLicenseModel() {
		return licenseModel;
	}

	/**
	 * @param licenseModel the licenseModel to set
	 */
	public void setLicenseModel(String licenseModel) {
		this.licenseModel = licenseModel;
	}

	/**
	 * @return the oilType
	 */
	public String getOilType() {
		return oilType;
	}

	/**
	 * @param oilType the oilType to set
	 */
	public void setOilType(String oilType) {
		this.oilType = oilType;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the meetPolicy
	 */
	public Boolean getMeetPolicy() {
		return meetPolicy;
	}

	/**
	 * @param meetPolicy the meetPolicy to set
	 */
	public void setMeetPolicy(Boolean meetPolicy) {
		this.meetPolicy = meetPolicy;
	}

	/**
	 * @return the issuedOn
	 */
	public Calendar getIssuedOn() {
		return issuedOn;
	}

	/**
	 * @param issuedOn the issuedOn to set
	 */
	public void setIssuedOn(Calendar issuedOn) {
		this.issuedOn = issuedOn;
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
	 * @return the gpsUpdatedAt
	 */
	public Calendar getGpsUpdatedAt() {
		return gpsUpdatedAt;
	}

	/**
	 * @param gpsUpdatedAt the gpsUpdatedAt to set
	 */
	public void setGpsUpdatedAt(Calendar gpsUpdatedAt) {
		this.gpsUpdatedAt = gpsUpdatedAt;
	}

}
