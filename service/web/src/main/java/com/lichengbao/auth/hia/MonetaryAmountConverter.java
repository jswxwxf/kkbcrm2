/**
 * 
 */
package com.lichengbao.auth.hia;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author jwang
 *
 */
@Converter(autoApply = true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 */
	@Override
	public String convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
		return monetaryAmount.toString();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
	 */
	@Override
	public MonetaryAmount convertToEntityAttribute(String dbData) {
		return MonetaryAmount.fromString(dbData);
	}

}

