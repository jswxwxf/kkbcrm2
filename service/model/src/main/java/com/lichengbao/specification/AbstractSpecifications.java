/**
 * 
 */
package com.lichengbao.specification;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jwang
 *
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractSpecifications implements Specifications {
	
	@Autowired
	protected ObjectMapper mapper;
	
	/* (non-Javadoc)
	 * @see com.lichengbao.specs.Specifications#parseSearch(org.springframework.data.jpa.datatables.parameter.SearchParameter)
	 */
	@Override
	public Specification parseSearch(SearchParameter search) {
		if (search.getValue().isEmpty()) {
			return null;
		}
		SpecDef def = getSpecDef(search);
		search.setValue(def.getGlobalQuery());
		return buildSpecifications(def);
	}
	
	@SuppressWarnings("unchecked")
	public Specification buildSpecifications(SpecDef def) {
		
		if (def == null) return null;
		
		List<Specification> specs = getSpecifications(def);
		if (CollectionUtils.isEmpty(specs)) return null;
 
		Iterator<Specification> it = specs.iterator();
        Specification result = it.next();
        while (it.hasNext()) {
        	result = org.springframework.data.jpa.domain.Specifications.where(result).and(it.next());
        }
        return result;
	}
	
	abstract SpecDef getSpecDef(SearchParameter search);
	
	abstract List<Specification> getSpecifications(SpecDef def);
	
}
