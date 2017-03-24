/**
 * 
 */
package com.lichengbao.specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.lichengbao.domain.common.VehicleInfo;
import com.lichengbao.domain.user.User;


class VehicleSpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1400952977787995346L;
	
	private String licenseNo;
	
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

/**
 * @author jwang
 *
 */
@Component
public class VehicleSpecifications extends AbstractSpecifications {
	
	public Specification<User> isLicenseNo(String licenseNo) {
		return (root, query, cb) -> {
//			Join<User, Account> accounts = root.join("accounts");
			return cb.like(root.<VehicleInfo>get("vehicleInfo").<String>get("licenseNo"), "%" + licenseNo + "%");
		};
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), VehicleSpecDef.class);
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
		VehicleSpecDef specDef = (VehicleSpecDef) def;
		if (StringUtils.isNotEmpty(specDef.getLicenseNo())) specs.add(isLicenseNo(specDef.getLicenseNo()));
		return specs;
	}

}
