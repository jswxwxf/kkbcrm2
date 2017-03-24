/**
 * 
 */
package com.lichengbao.service;

import com.lichengbao.domain.insurance.order.Order;

/**
 * @author jwang
 *
 */
public interface OrderService {

	/**
	 * @param id
	 * @return
	 */
	Order getOrder(Long id);

}
