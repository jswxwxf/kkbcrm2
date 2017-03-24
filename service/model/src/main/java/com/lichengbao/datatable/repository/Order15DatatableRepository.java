/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.insurance.order.Order15;


/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface Order15DatatableRepository extends DataTablesRepository<Order15, Long> {

}
