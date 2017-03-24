/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.sun.istack.internal.NotNull;

/**
 * @author jwang
 *
 */
@MappedSuperclass
public abstract class Measurement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2306239884178925636L;
	
	@NotNull
	private String name;
	
	@NotNull
	private String symbol;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
