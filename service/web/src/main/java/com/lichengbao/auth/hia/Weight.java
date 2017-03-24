/**
 * 
 */
package com.lichengbao.auth.hia;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.sun.istack.internal.NotNull;

/**
 * @author jwang
 *
 */
@Embeddable
@AttributeOverrides({ 
	@AttributeOverride(name = "name", column = @Column(name = "weight_name") ),
	@AttributeOverride(name = "symbol", column = @Column(name = "weight_symbol") ) })
public class Weight extends Measurement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5567189018153922030L;
	
	@NotNull
	@Column(name = "weight", nullable = false)
	private BigDecimal value;

}
