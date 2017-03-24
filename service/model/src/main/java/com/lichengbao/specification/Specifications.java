/**
 * 
 */
package com.lichengbao.specification;

import org.springframework.data.jpa.datatables.parameter.SearchParameter;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author jwang
 *
 */
@SuppressWarnings("rawtypes")
public interface Specifications {
	
	Specification parseSearch(SearchParameter search);
	
}
