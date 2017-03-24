/**
 * 
 */
package com.lichengbao.domain.common;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author jwang
 *
 */
@Embeddable
public class VehicleInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7189084331080765644L;

	private String carBrand;
	
	@OneToOne
	@JoinColumn(name = "brand_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private VehicleModel brand;
	
	private String carSeries;
	
	@OneToOne
	@JoinColumn(name = "series_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private VehicleModel serie;
	
	private String carModel;
	
	@OneToOne
	@JoinColumn(name = "model_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private VehicleModel model;

	private String carVin;
	
	private String engineNo;

	private String licenseNo;

	/**
	 * @return the carBrand
	 */
	public String getCarBrand() {
		return carBrand;
	}

	/**
	 * @param carBrand the carBrand to set
	 */
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	/**
	 * @return the brand
	 */
	public VehicleModel getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(VehicleModel brand) {
		this.brand = brand;
	}

	/**
	 * @return the carSeries
	 */
	public String getCarSeries() {
		return carSeries;
	}

	/**
	 * @param carSeries the carSeries to set
	 */
	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}

	/**
	 * @return the serie
	 */
	public VehicleModel getSerie() {
		return serie;
	}

	/**
	 * @param serie the serie to set
	 */
	public void setSerie(VehicleModel serie) {
		this.serie = serie;
	}

	/**
	 * @return the carModel
	 */
	public String getCarModel() {
		return carModel;
	}

	/**
	 * @param carModel the carModel to set
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
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
	 * @return the carVin
	 */
	public String getCarVin() {
		return carVin;
	}

	/**
	 * @param carVin the carVin to set
	 */
	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}

	/**
	 * @return the engineNo
	 */
	public String getEngineNo() {
		return engineNo;
	}

	/**
	 * @param engineNo the engineNo to set
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	/**
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}

	/**
	 * @param licenseNo the licenseNo to set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
}
