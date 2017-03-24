/**
 * 
 */
package com.lichengbao.domain.insurance;

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
public class Insurance15Info extends InsuranceInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1021574476313486565L;
	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "product_id", insertable = false, updatable = false)
	private ProductType product;

	@Temporal(TemporalType.DATE)
	private Calendar registerDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar transferDate;
	
	private Long carSeat;

	private String licenseVehicleBack;
	
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}
	
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the product
	 */
	public ProductType getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductType product) {
		this.product = product;
	}

	/**
	 * @return the registerDate
	 */
	public Calendar getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the transferDate
	 */
	public Calendar getTransferDate() {
		return transferDate;
	}

	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(Calendar transferDate) {
		this.transferDate = transferDate;
	}

	/**
	 * @return the carSeat
	 */
	public Long getCarSeat() {
		return carSeat;
	}

	/**
	 * @param carSeat the carSeat to set
	 */
	public void setCarSeat(Long carSeat) {
		this.carSeat = carSeat;
	}

	/**
	 * @return the licenseVehicleBack
	 */
	public String getLicenseVehicleBack() {
		return licenseVehicleBack;
	}

	/**
	 * @param licenseVehicleBack the licenseVehicleBack to set
	 */
	public void setLicenseVehicleBack(String licenseVehicleBack) {
		this.licenseVehicleBack = licenseVehicleBack;
	}

}
