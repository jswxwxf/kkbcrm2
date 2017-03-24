/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jwang
 *
 */
@Embeddable
public class Result15Info extends ResultInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777763983113411641L;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal standardCommercial;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal driveRewardMin;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal driveRewardMax;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal stopReward;
	
	@Column(precision = 6, scale = 2)
	private BigDecimal annuallyReward;
	
	/**
	 * @return the standardCommercial
	 */
	public BigDecimal getStandardCommercial() {
		return standardCommercial;
	}

	/**
	 * @param standardCommercial the standardCommercial to set
	 */
	public void setStandardCommercial(BigDecimal standardCommercial) {
		this.standardCommercial = standardCommercial;
	}

	/**
	 * @return the driveRewardMin
	 */
	public BigDecimal getDriveRewardMin() {
		return driveRewardMin;
	}

	/**
	 * @param driveRewardMin the driveRewardMin to set
	 */
	public void setDriveRewardMin(BigDecimal driveRewardMin) {
		this.driveRewardMin = driveRewardMin;
	}

	/**
	 * @return the driveRewardMax
	 */
	public BigDecimal getDriveRewardMax() {
		return driveRewardMax;
	}

	/**
	 * @param driveRewardMax the driveRewardMax to set
	 */
	public void setDriveRewardMax(BigDecimal driveRewardMax) {
		this.driveRewardMax = driveRewardMax;
	}

	/**
	 * @return the stopReward
	 */
	public BigDecimal getStopReward() {
		return stopReward;
	}

	/**
	 * @param stopReward the stopReward to set
	 */
	public void setStopReward(BigDecimal stopReward) {
		this.stopReward = stopReward;
	}

	/**
	 * @return the annuallyReward
	 */
	public BigDecimal getAnnuallyReward() {
		return annuallyReward;
	}

	/**
	 * @param annuallyReward the annuallyReward to set
	 */
	public void setAnnuallyReward(BigDecimal annuallyReward) {
		this.annuallyReward = annuallyReward;
	}
	
}
