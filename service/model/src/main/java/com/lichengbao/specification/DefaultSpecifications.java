/**
 * 
 */
package com.lichengbao.specification;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


/**
 * @author jwang
 *
 */
@Component
@SuppressWarnings("rawtypes")
public class DefaultSpecifications extends AbstractSpecifications {
	
	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecDef(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	SpecDef getSpecDef(SearchParameter search) {
		try {
			return mapper.readValue(search.getValue(), SpecDef.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.lichengbao.specs.AbstractSpecifications#getSpecifications(com.lichengbao.specs.SpecDef)
	 */
	@Override
	List<Specification> getSpecifications(SpecDef def) {
		return null;
	}


}
