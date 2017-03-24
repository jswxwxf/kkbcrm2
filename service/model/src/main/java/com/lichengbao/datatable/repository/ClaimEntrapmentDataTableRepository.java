/**
 * 
 */
package com.lichengbao.datatable.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.lichengbao.domain.insurance.ClaimEntrapment;

/**
 * @author jwang
 *
 */
public interface ClaimEntrapmentDataTableRepository extends DataTablesRepository<ClaimEntrapment, Long> {

}
