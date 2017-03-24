/**
 * 
 */
package com.lichengbao.domain.insurance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

/**
 * @author jwang
 *
 */
@Embeddable
public class PackageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8560650471304103435L;

	private PackageType packageType;
	
	@Column(name = "package_detail")
	private String content;
	
	@Type(type = "com.lichengbao.domain.insurance.PackageDetailUserType")
	@Column(name = "package_detail", insertable = false, updatable = false)
	private PackageDetail packageDetail;
	
	private String company;

	/**
	 * @return the packageType
	 */
	public PackageType getPackageType() {
		return packageType;
	}

	/**
	 * @param packageType the packageType to set
	 */
	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
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
	 * @return the packageDetail
	 */
	public PackageDetail getPackageDetail() {
		return packageDetail;
	}

	/**
	 * @param packageDetail the packageDetail to set
	 */
	public void setPackageDetail(PackageDetail packageDetail) {
		this.packageDetail = packageDetail;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
}
