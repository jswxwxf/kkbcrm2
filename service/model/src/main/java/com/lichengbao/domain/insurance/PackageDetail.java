/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jwang
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 395095774636307217L;
	
	/**
	 * 车辆损失险
	 */
	private Boolean destroy;
	
	/**
	 * 第三者责任险
	 */
	private Long liability;
	
	/**
	 * 全车盗抢险
	 */
	private Boolean stolen;
	
	/**
	 * 乘客座位险
	 */
	private Long passengerSeat;
	
	/**
	 * 司机座位险
	 */
	private Long driverSeat;
	
	/**
	 * 划痕险
	 */
	private Long scratch;
	
	/**
	 * 玻璃破损险
	 */
	private String glasses;
	
	/**
	 * 涉水险
	 */
	private Boolean water;
	
	/**
	 * 自燃险
	 */
	private Boolean burn;
	
	/**
	 * 后视镜和车灯险
	 */
	private String lights;
	
	/**
	 * 不计免赔
	 */
	private Boolean excluding;

	/**
	 * @return the destroy
	 */
	public Boolean getDestroy() {
		return destroy;
	}

	/**
	 * @param destroy the destroy to set
	 */
	public void setDestroy(Boolean destroy) {
		this.destroy = destroy;
	}

	/**
	 * @return the liability
	 */
	public Long getLiability() {
		return liability;
	}

	/**
	 * @param liability the liability to set
	 */
	public void setLiability(Long liability) {
		this.liability = liability;
	}

	/**
	 * @return the stolen
	 */
	public Boolean getStolen() {
		return stolen;
	}

	/**
	 * @param stolen the stolen to set
	 */
	public void setStolen(Boolean stolen) {
		this.stolen = stolen;
	}

	/**
	 * @return the passengerSeat
	 */
	public Long getPassengerSeat() {
		return passengerSeat;
	}

	/**
	 * @param passengerSeat the passengerSeat to set
	 */
	public void setPassengerSeat(Long passengerSeat) {
		this.passengerSeat = passengerSeat;
	}

	/**
	 * @return the driverSeat
	 */
	public Long getDriverSeat() {
		return driverSeat;
	}

	/**
	 * @param driverSeat the driverSeat to set
	 */
	public void setDriverSeat(Long driverSeat) {
		this.driverSeat = driverSeat;
	}

	/**
	 * @return the scratch
	 */
	public Long getScratch() {
		return scratch;
	}

	/**
	 * @param scratch the scratch to set
	 */
	public void setScratch(Long scratch) {
		this.scratch = scratch;
	}

	/**
	 * @return the glasses
	 */
	public String getGlasses() {
		return glasses;
	}

	/**
	 * @param glasses the glasses to set
	 */
	public void setGlasses(String glasses) {
		this.glasses = glasses;
	}

	/**
	 * @return the water
	 */
	public Boolean getWater() {
		return water;
	}

	/**
	 * @param water the water to set
	 */
	public void setWater(Boolean water) {
		this.water = water;
	}

	/**
	 * @return the burn
	 */
	public Boolean getBurn() {
		return burn;
	}

	/**
	 * @param burn the burn to set
	 */
	public void setBurn(Boolean burn) {
		this.burn = burn;
	}

	/**
	 * @return the lights
	 */
	public String getLights() {
		return lights;
	}

	/**
	 * @param lights the lights to set
	 */
	public void setLights(String lights) {
		this.lights = lights;
	}

	/**
	 * @return the excluding
	 */
	public Boolean getExcluding() {
		return excluding;
	}

	/**
	 * @param excluding the excluding to set
	 */
	public void setExcluding(Boolean excluding) {
		this.excluding = excluding;
	}

}
