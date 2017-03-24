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
import com.lichengbao.domain.user.UserAccount;


class UserSpecDef extends SpecDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265392408645912765L;
	
	private Integer userHasConnectedTo;
	
	/**
	 * @return the userHasConnectedTo
	 */
	public Integer getUserHasConnectedTo() {
		return userHasConnectedTo;
	}
	
	/**
	 * @param userHasConnectedTo the userHasConnectedTo to set
	 */
	public void setUserHasConnectedTo(Integer userHasConnectedTo) {
		this.userHasConnectedTo = userHasConnectedTo;
	}
	
}

/**
 * @author jwang
 *
 */
@Component
public class UserSpecifications extends AbstractSpecifications {
	
	public Specification<User> hasConnectedTo(Integer platformCode) {
		return (root, query, cb) -> {
			Join<User, UserAccount> accounts = root.join("accounts");
			return cb.equal(accounts.<Integer>get("platform"), platformCode);
		};
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), UserSpecDef.class);
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
		UserSpecDef specDef = (UserSpecDef) def;
		if (specDef.getUserHasConnectedTo() != null) specs.add(hasConnectedTo(specDef.getUserHasConnectedTo()));
		return specs;
	}

}
