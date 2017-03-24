/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.lichengbao.domain.common.Region;
import com.lichengbao.domain.common.VehicleInfo;

/**
 * @author jwang
 *
 */
@MappedSuperclass
@Embeddable
public class InsuranceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 459096835766066589L;

	private String name;

	private String idCard;

	private String mobile;

	@Column(name = "city")
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "city_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Region city;
	
	private VehicleInfo vehicle;

	private String licenseVehicle;
	
	private PackageInfo pkg;

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
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the city
	 */
	public Region getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(Region city) {
		this.city = city;
	}

	/**
	 * @return the vehicle
	 */
	public VehicleInfo getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(VehicleInfo vehicle) {
		this.vehicle = vehicle;
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
	 * @return the pkg
	 */
	public PackageInfo getPkg() {
		return pkg;
	}

	/**
	 * @param pkg the pkg to set
	 */
	public void setPkg(PackageInfo pkg) {
		this.pkg = pkg;
	}
	
}
