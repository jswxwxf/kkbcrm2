/**
 * 
 */
package com.lichengbao.auth.hia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author jwang
 *
 */
public class MonetaryAmount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185553860083013069L;
	
	private BigDecimal value;
	
	private Currency currency;
	
	/**
	 * 
	 */
	public MonetaryAmount() {}
	
	/**
	 * @param value
	 * @param currency
	 */
	public MonetaryAmount(BigDecimal value, Currency currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonetaryAmount other = (MonetaryAmount) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getValue() + " " + getCurrency();
	}
	
	public static MonetaryAmount fromString(String s) {
		String[] split = s.split(" ");
		return new MonetaryAmount(
				new BigDecimal(split[0]), 
				Currency.getInstance(split[1]));
	}

}
