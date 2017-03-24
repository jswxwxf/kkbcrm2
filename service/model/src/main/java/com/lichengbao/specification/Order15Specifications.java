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

import com.lichengbao.domain.insurance.InsuranceInfo;
import com.lichengbao.domain.insurance.order.Order;
import com.lichengbao.domain.insurance.order.Order15;
import com.lichengbao.domain.user.User;


class Order15SpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7798812025824903094L;
	
	private String owner;
	
	private String insuranceUser;

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
	 * @return the insuranceUser
	 */
	public String getInsuranceUser() {
		return insuranceUser;
	}
	
	/**
	 * @param insuranceUser the insuranceUser to set
	 */
	public void setInsuranceUser(String insuranceUser) {
		this.insuranceUser = insuranceUser;
	}
	
}

/**
 * @author jwang
 *
 */
@Component
public class Order15Specifications extends AbstractSpecifications {
	
	public Specification<Order15> isOwner(String name) {
		return (root, query, cb) -> {
			Join<Order15, User> owner = root.join("user");
			return cb.or(
					cb.like(owner.<String>get("mobile"), "%" + name + "%"), 
					cb.like(owner.<String>get("username"), "%" + name + "%"));
		};
	}
	
	public Specification<Order> isInsuranceUser(String user) {
		return (root, query, cb) -> {
			return cb.or(
				cb.like(root.<InsuranceInfo>get("insurance").<String>get("name"), "%" + user + "%"),
				cb.like(root.<InsuranceInfo>get("insurance").<String>get("mobile"), "%" + user + "%"),
				cb.like(root.<InsuranceInfo>get("insurance").<String>get("idCard"), "%" + user + "%")
			);
		};
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), Order15SpecDef.class);
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
		Order15SpecDef specDef = (Order15SpecDef) def;
		if (StringUtils.isNotEmpty(specDef.getOwner())) specs.add(isOwner(specDef.getOwner()));
		if (StringUtils.isNotEmpty(specDef.getInsuranceUser())) specs.add(isInsuranceUser(specDef.getInsuranceUser()));
		return specs;
	}

}
