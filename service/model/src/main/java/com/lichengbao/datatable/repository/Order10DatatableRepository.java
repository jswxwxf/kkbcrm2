/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.insurance.order.Order10;


/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface Order10DatatableRepository extends DataTablesRepository<Order10, Long> {

}
