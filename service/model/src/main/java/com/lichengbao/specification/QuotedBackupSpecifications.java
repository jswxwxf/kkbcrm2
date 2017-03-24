/**
 * 
 */
package com.lichengbao.specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.lichengbao.domain.common.VehicleInfo;
import com.lichengbao.domain.insurance.Insurance15Info;
import com.lichengbao.domain.insurance.QuotedBackup;
import com.lichengbao.domain.user.User;


class QuotedBackupSpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489075209569261660L;
	
	private String licenseNo;
	
	private String name;
	
	private String owner;
	
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
	
}

/**
 * @author jwang
 *
 */
@Component
public class QuotedBackupSpecifications extends AbstractSpecifications {
	
	public Specification<QuotedBackup> isLicenseNo(String licenseNo) {
		return (root, query, cb) -> {
//			Join<User, Account> accounts = root.join("accounts");
			return cb.like(root.<Insurance15Info>get("insurance").<VehicleInfo>get("vehicle").<String>get("licenseNo"), "%" + licenseNo + "%");
		};
	}
	
	public Specification<QuotedBackup> isOwner(String name) {
		return (root, query, cb) -> {
			Join<QuotedBackup, User> owner = root.join("user");
			return cb.or(
					cb.like(owner.<String>get("mobile"), "%" + name + "%"), 
					cb.like(owner.<String>get("username"), "%" + name + "%"));
		};
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), QuotedBackupSpecDef.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecifications(com.lichengbao.specs.SpecDef)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	List<Specification> getSpecifications(SpecDef def) {
		List<Specification> specs = new ArrayList<>();
		QuotedBackupSpecDef specDef = (QuotedBackupSpecDef) def;
		if (StringUtils.isNotEmpty(specDef.getLicenseNo())) specs.add(isLicenseNo(specDef.getLicenseNo()));
		if (StringUtils.isNotEmpty(specDef.getOwner())) specs.add(isOwner(specDef.getOwner()));
		return specs;
	}

}
