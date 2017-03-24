/**
 * 
 */
package com.lichengbao.repository;

import org.springframework.stereotype.Repository;

import com.lichengbao.domain.insurance.order.Order;

/**
 * @author jwang
 *
 */
@Repository
public interface OrderRepository extends BaseRepository<Order, Long>, OrderRepositoryEx {

}
