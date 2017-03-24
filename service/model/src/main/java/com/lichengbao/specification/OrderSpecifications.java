/**
 * 
 */
package com.lichengbao.specification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.lichengbao.domain.insurance.InsuranceInfo;
import com.lichengbao.domain.insurance.order.Order;
import com.lichengbao.domain.insurance.order.Order15;
import com.lichengbao.domain.user.User;


class OrderSpecDef extends SpecDef {

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
public class OrderSpecifications extends AbstractSpecifications {
	
	public Specification<Order> isOwner(String name) {
		return (root, query, cb) -> {
			Join<Order, User> owner = root.join("user");
			return cb.or(
					cb.like(owner.<String>get("mobile"), "%" + name + "%"), 
					cb.like(owner.<String>get("username"), "%" + name + "%"));
		};
	}
	
	public Specification<Order> isInsuranceUser(String user) {
		return (root, query, cb) -> {
//		    Root<T> fromType = query.from(type);
		    Root<Order15> order15 = query.from(Order15.class);
//		    Path<Order15> order15 = (Path<Order15>) root.join("order15").as(Order15.class);

//		    Path<Object> pathCode = order15.get("code");
//		    Path<Object> pathIdTagType = fromType.get("idTag");
//		    Path<Object> pathIdTagRfId = order15.get("id");

//		    CriteriaQuery<T> select = query.select(root);
//		    root.where(
//		            cb.equal(pathCode, catName),
//		            cb.equal(pathIdTagType, pathIdTagRfId));

//		    TypedQuery<T> q = em.createQuery(select);
//		    return q.getSingleResult();

			return cb.or(
				cb.like(order15.<InsuranceInfo>get("insurance").<String>get("name"), "%" + user + "%"),
				cb.like(order15.<InsuranceInfo>get("insurance").<String>get("mobile"), "%" + user + "%"),
				cb.like(order15.<InsuranceInfo>get("insurance").<String>get("idCard"), "%" + user + "%")
			);
		};
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), OrderSpecDef.class);
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
		OrderSpecDef specDef = (OrderSpecDef) def;
		if (StringUtils.isNotEmpty(specDef.getOwner())) specs.add(isOwner(specDef.getOwner()));
		if (StringUtils.isNotEmpty(specDef.getInsuranceUser())) specs.add(isInsuranceUser(specDef.getInsuranceUser()));
		return specs;
	}

}
