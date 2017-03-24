/**
 * 
 */
package com.lichengbao.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.util.Assert;

import com.lichengbao.domain.insurance.order.Order;

/**
 * @author jwang
 *
 */
public class OrderRepositoryImpl implements OrderRepositoryEx {
	
	@PersistenceUnit(unitName = "kkb")
	private EntityManagerFactory entityManagerFactory;

	@PersistenceContext(unitName = "kkb")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.lichengbao.repository.OrderRepositoryEx#doSomething()
	 */
	@Override
	public Order doSomething(Long id) {
		
		Order order = this.entityManager.find(Order.class, id);
		Assert.isTrue(this.entityManager.contains(order));
		this.entityManager.detach(order);
		Assert.isTrue(!this.entityManager.contains(order));
		
		return null;
	}

}
