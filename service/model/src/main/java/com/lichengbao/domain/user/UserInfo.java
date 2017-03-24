/**
 * 
 */
package com.lichengbao.domain.user;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author jwang
 *
 */
@Entity
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1770808006179389747L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private MarriageStatus marriageStatus;
	
	private String children;
	
	private String drivingLicense;
	
	private String drivingLicenseData;
	
	private String credit;
	
	private String creditData;
	
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;
	
	private String companyName;
	
	private String jobTitle;
	
	@Enumerated(EnumType.STRING)
	private EducationDegree degree;
	
	private String school;
	
	private String majorIn;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="info_id", unique = true)
	private UserInfo info;
	
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
	 * @return the marriageStatus
	 */
	public MarriageStatus getMarriageStatus() {
		return marriageStatus;
	}

	/**
	 * @param marriageStatus the marriageStatus to set
	 */
	public void setMarriageStatus(MarriageStatus marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	/**
	 * @return the children
	 */
	public String getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(String children) {
		this.children = children;
	}

	/**
	 * @return the drivingLicense
	 */
	public String getDrivingLicense() {
		return drivingLicense;
	}

	/**
	 * @param drivingLicense the drivingLicense to set
	 */
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	/**
	 * @return the drivingLicenseData
	 */
	public String getDrivingLicenseData() {
		return drivingLicenseData;
	}

	/**
	 * @param drivingLicenseData the drivingLicenseData to set
	 */
	public void setDrivingLicenseData(String drivingLicenseData) {
		this.drivingLicenseData = drivingLicenseData;
	}

	/**
	 * @return the credit
	 */
	public String getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}

	/**
	 * @return the creditData
	 */
	public String getCreditData() {
		return creditData;
	}

	/**
	 * @param creditData the creditData to set
	 */
	public void setCreditData(String creditData) {
		this.creditData = creditData;
	}

	/**
	 * @return the companyType
	 */
	public CompanyType getCompanyType() {
		return companyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the degree
	 */
	public EducationDegree getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(EducationDegree degree) {
		this.degree = degree;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the majorIn
	 */
	public String getMajorIn() {
		return majorIn;
	}

	/**
	 * @param majorIn the majorIn to set
	 */
	public void setMajorIn(String majorIn) {
		this.majorIn = majorIn;
	}

	/**
	 * @return the info
	 */
	public UserInfo getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(UserInfo info) {
		this.info = info;
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
