/**
 * 
 */
package com.lichengbao.domain.insurance.order;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lichengbao.domain.insurance.PackageInfo;

/**
 * @author jwang
 *
 */
@Entity
@Table(name = "orders_10")
@PrimaryKeyJoinColumn(name = "order_id")
public class Order10 extends Order {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2575746040622050524L;
	
	private Order10Status status;

	private String licenseNo;
	
	private String name;
	
	private String cert;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal beginMile;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal endMile;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal standardPrice;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal realPrice;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal discountPrice;

	@Column(precision = 10, scale = 2)
	private BigDecimal standardCommercial;

	@Column(precision = 10, scale = 2)
	private BigDecimal realCommercial;

	@Column(precision = 10, scale = 2)
	private BigDecimal discountCommercial;

	@Column(precision = 10, scale = 2)
	private BigDecimal tax;
	
	private String rewards;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar validFrom;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar validTo;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
	private PackageInfo pkg;

	/**
	 * @return the status
	 */
	public Order10Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Order10Status status) {
		this.status = status;
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
	 * @return the cert
	 */
	public String getCert() {
		return cert;
	}

	/**
	 * @param cert the cert to set
	 */
	public void setCert(String cert) {
		this.cert = cert;
	}

	/**
	 * @return the beginMile
	 */
	public BigDecimal getBeginMile() {
		return beginMile;
	}

	/**
	 * @param beginMile the beginMile to set
	 */
	public void setBeginMile(BigDecimal beginMile) {
		this.beginMile = beginMile;
	}

	/**
	 * @return the endMile
	 */
	public BigDecimal getEndMile() {
		return endMile;
	}

	/**
	 * @param endMile the endMile to set
	 */
	public void setEndMile(BigDecimal endMile) {
		this.endMile = endMile;
	}

	/**
	 * @return the standardPrice
	 */
	public BigDecimal getStandardPrice() {
		return standardPrice;
	}

	/**
	 * @param standardPrice the standardPrice to set
	 */
	public void setStandardPrice(BigDecimal standardPrice) {
		this.standardPrice = standardPrice;
	}

	/**
	 * @return the realPrice
	 */
	public BigDecimal getRealPrice() {
		return realPrice;
	}

	/**
	 * @param realPrice the realPrice to set
	 */
	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	/**
	 * @return the discountPrice
	 */
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * @param discountPrice the discountPrice to set
	 */
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

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
	 * @return the realCommercial
	 */
	public BigDecimal getRealCommercial() {
		return realCommercial;
	}

	/**
	 * @param realCommercial the realCommercial to set
	 */
	public void setRealCommercial(BigDecimal realCommercial) {
		this.realCommercial = realCommercial;
	}

	/**
	 * @return the discountCommercial
	 */
	public BigDecimal getDiscountCommercial() {
		return discountCommercial;
	}

	/**
	 * @param discountCommercial the discountCommercial to set
	 */
	public void setDiscountCommercial(BigDecimal discountCommercial) {
		this.discountCommercial = discountCommercial;
	}

	/**
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * @return the rewards
	 */
	public String getRewards() {
		return rewards;
	}

	/**
	 * @param rewards the rewards to set
	 */
	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	/**
	 * @return the validFrom
	 */
	public Calendar getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Calendar validFrom) {
		this.validFrom = validFrom;
	}
	
	/**
	 * @return the validTo
	 */
	public Calendar getValidTo() {
		return validTo;
	}
	
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Calendar validTo) {
		this.validTo = validTo;
	}

	/**
	 * @return the createTime
	 */
	public Calendar getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
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
