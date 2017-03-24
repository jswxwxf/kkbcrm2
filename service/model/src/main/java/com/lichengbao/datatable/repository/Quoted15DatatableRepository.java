/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.insurance.Quoted15;


/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface Quoted15DatatableRepository extends DataTablesRepository<Quoted15, Long> {

}
