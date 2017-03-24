/**
 * 
 */
package com.lichengbao.specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.Join;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.lichengbao.domain.common.Device;
import com.lichengbao.domain.common.Vehicle;
import com.lichengbao.domain.common.VehicleInfo;
import com.lichengbao.domain.user.User;


class DeviceSpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5489075209569261660L;
	
	private String licenseNo;
	
	private String vehicleInfo;
	
	private Boolean activated;
	
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
	 * @return the vehicleInfo
	 */
	public String getVehicleInfo() {
		return vehicleInfo;
	}
	
	/**
	 * @param vehicleInfo the vehicleInfo to set
	 */
	public void setVehicleInfo(String vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}
	
	/**
	 * @return the activated
	 */
	public Boolean getActivated() {
		return activated;
	}
	
	/**
	 * @param activated the activated to set
	 */
	public void setActivated(Boolean activated) {
		this.activated = activated;
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
public class DeviceSpecifications extends AbstractSpecifications {
	
	public Specification<Device> isLicenseNo(String licenseNo) {
		return (root, query, cb) -> {
			return cb.like(root.<Vehicle>get("vehicle").<VehicleInfo>get("vehicleInfo").<String>get("licenseNo"), "%" + licenseNo + "%");
		};
	}
	
	public Specification<Device> isVehicleInfo(String info) {
		return (root, query, cb) -> {
			return cb.or(
				cb.like(root.<Vehicle>get("vehicle").<VehicleInfo>get("vehicleInfo").<String>get("carBrand"), "%" + info + "%"),
				cb.like(root.<Vehicle>get("vehicle").<VehicleInfo>get("vehicleInfo").<String>get("carSeries"), "%" + info + "%"),
				cb.like(root.<Vehicle>get("vehicle").<VehicleInfo>get("vehicleInfo").<String>get("carModel"), "%" + info + "%")
			);
		};
	}
	
	public Specification<Device> isActivated(Boolean activated) {
		return (root, query, cb) -> {
			if (activated) return cb.isNotNull(root.<Calendar>get("activatedAt"));
			return cb.isNull(root.<Calendar>get("activatedAt"));
		};
	}
	
	public Specification<Device> isOwner(String name) {
		return (root, query, cb) -> {
			Join<Device, User> owner = root.join("user");
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
			return mapper.readValue(search.getValue(), DeviceSpecDef.class);
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
		DeviceSpecDef specDef = (DeviceSpecDef) def;
		if (StringUtils.isNotEmpty(specDef.getLicenseNo())) specs.add(isLicenseNo(specDef.getLicenseNo()));
		if (StringUtils.isNotEmpty(specDef.getVehicleInfo())) specs.add(isVehicleInfo(specDef.getVehicleInfo()));
		if (specDef.getActivated() != null) specs.add(isActivated(specDef.getActivated()));
		if (StringUtils.isNotEmpty(specDef.getOwner())) specs.add(isOwner(specDef.getOwner()));
		return specs;
	}

}
