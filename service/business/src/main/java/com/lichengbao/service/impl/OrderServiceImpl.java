/**
 * 
 */
package com.lichengbao.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichengbao.domain.insurance.order.Order;
import com.lichengbao.repository.OrderRepository;
import com.lichengbao.service.OrderService;

/**
 * @author jwang
 *
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	/* (non-Javadoc)
	 * @see com.lichengbao.service.OrderService#getOrder(java.lang.Long)
	 */
	@Override
	public Order getOrder(Long id) {
//		this.orderRepository.doSomething(id);
		return orderRepository.findOneExist(id);
	}

}
