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

import com.lichengbao.domain.common.Vehicle;
import com.lichengbao.domain.common.VehicleInfo;
import com.lichengbao.domain.user.Reward;
import com.lichengbao.domain.user.User;


class RewardSpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489075209569261660L;
	
	private String licenseNo;
	
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
public class RewardSpecifications extends AbstractSpecifications {
	
	public Specification<Reward> isLicenseNo(String licenseNo) {
		return (root, query, cb) -> {
			return cb.like(root.<Vehicle>get("vehicle").<VehicleInfo>get("vehicleInfo").<String>get("licenseNo"), "%" + licenseNo + "%");
		};
	}
	
	public Specification<Reward> isOwner(String name) {
		return (root, query, cb) -> {
			Join<Reward, User> owner = root.join("user");
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
			return mapper.readValue(search.getValue(), RewardSpecDef.class);
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
		RewardSpecDef specDef = (RewardSpecDef) def;
		if (StringUtils.isNotEmpty(specDef.getLicenseNo())) specs.add(isLicenseNo(specDef.getLicenseNo()));
		if (StringUtils.isNotEmpty(specDef.getOwner())) specs.add(isOwner(specDef.getOwner()));
		return specs;
	}

}
