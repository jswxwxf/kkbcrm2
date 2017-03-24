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
	@AttributeOverride(name = "name", column = @Column(name = "dimensions_name") ),
	@AttributeOverride(name = "symbol", column = @Column(name = "dimensions_symbol") ) })
public class Dimensions extends Measurement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7319220235273392059L;
	
	@NotNull
	private BigDecimal depth;
	
	@NotNull
	private BigDecimal height;
	
	@NotNull
	private BigDecimal width;
	
	/**
	 * @return the depth
	 */
	public BigDecimal getDepth() {
		return depth;
	}
	
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}
	
	/**
	 * @return the height
	 */
	public BigDecimal getHeight() {
		return height;
	}
	
	/**
	 * @param height the height to set
	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	
	/**
	 * @return the width
	 */
	public BigDecimal getWidth() {
		return width;
	}
	
	/**
	 * @param width the width to set
	 */
	public void setWidth(BigDecimal width) {
		this.width = width;
	}

}
