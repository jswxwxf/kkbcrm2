/**
 * 
 */
package com.lichengbao.datatable.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.lichengbao.domain.event.Autozu;

/**
 * @author jwang
 *
 */
public interface AutozuDataTableRepository extends DataTablesRepository<Autozu, Long> {

}
