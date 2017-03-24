/**
 * 
 */
package com.lichengbao.specification;

import java.io.Serializable;

/**
 * @author jwang
 *
 */
public class SpecDef implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2547733783202882562L;

	private String globalQuery;

	/**
	 * @return the global
	 */
	public String getGlobalQuery() {
		return globalQuery;
	}
	
	/**
	 * @param global the global to set
	 */
	public void setGlobalQuery(String globalQuery) {
		this.globalQuery = globalQuery;
	}
	
}
