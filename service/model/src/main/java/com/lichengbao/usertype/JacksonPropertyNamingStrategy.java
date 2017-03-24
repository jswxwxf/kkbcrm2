/**
 * 
 */
package com.lichengbao.usertype;


import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;

/**
 * @author jwang
 *
 */
public class JacksonPropertyNamingStrategy extends PropertyNamingStrategyBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3120048101067924931L;

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase#translate(java.lang.String)
	 */
	@Override
	public String translate(String propertyName) {
		propertyName = StringUtils.join(propertyName.split("(?=\\p{Lu})"), "_").toLowerCase();
		return propertyName;
	}

}
