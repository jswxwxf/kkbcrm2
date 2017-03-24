/**
 * 
 */
package com.lichengbao.datatable.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.lichengbao.domain.insurance.order.OrderEntrapment;

/**
 * @author jwang
 *
 */
public interface OrderEntrapmentDataTableRepository extends DataTablesRepository<OrderEntrapment, Long> {

}
