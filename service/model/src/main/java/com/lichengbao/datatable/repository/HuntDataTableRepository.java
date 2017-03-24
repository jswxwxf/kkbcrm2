/**
 * 
 */
package com.lichengbao.datatable.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.lichengbao.domain.event.Hunt;

/**
 * @author jwang
 *
 */
public interface HuntDataTableRepository extends DataTablesRepository<Hunt, Long> {

}
