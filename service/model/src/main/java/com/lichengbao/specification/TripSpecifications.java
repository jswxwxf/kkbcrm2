/**
 * 
 */
package com.lichengbao.specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.lichengbao.domain.user.User;
import com.lichengbao.domain.user.Trip;
import com.lichengbao.domain.common.Vehicle;
import com.lichengbao.domain.common.VehicleInfo;

class TripSpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265392408645912765L;

	private String owner;
	
	private String vehicle;
	
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
	
	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}
	
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
}

/**
 * @author jwang
 *
 */
@Component
public class TripSpecifications extends AbstractSpecifications {
	
	public Specification<Trip> isOwner(String name) {
		return (root, query, cb) -> {
			Join<Trip, User> owner = root.join("user");
			return cb.or(
					cb.like(owner.<String>get("mobile"), "%" + name + "%"), 
					cb.like(owner.<String>get("username"), "%" + name + "%"));
		};
	}
	
	public Specification<Trip> isVehicle(String vehicle) {
		return (root, query, cb) -> {
			Join<Trip, Vehicle> owner = root.join("vehicle");
			return cb.or(
					cb.like(owner.<VehicleInfo>get("vehicleInfo").<String>get("licenseNo"), "%" + vehicle + "%"), 
					cb.like(owner.<User>get("user").<String>get("username"), "%" + vehicle + "%"));
		};
	}
	
	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), TripSpecDef.class);
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
		TripSpecDef specDef = (TripSpecDef) def;
		if (specDef.getOwner() != null) specs.add(isOwner(specDef.getOwner()));
		if (specDef.getVehicle() != null) specs.add(isVehicle(specDef.getVehicle()));
		return specs;
	}

}
