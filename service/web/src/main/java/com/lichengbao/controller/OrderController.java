/**
 * 
 */
package com.lichengbao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lichengbao.domain.insurance.order.Order;
import com.lichengbao.service.OrderService;

/**
 * @author jwang
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Order getOrder(@PathVariable Long id) {
		return this.orderService.getOrder(id);
	}

}
