/**
 * 
 */
package com.lichengbao.datatable.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.lichengbao.domain.event.GreenPingan;

/**
 * @author jwang
 *
 */
public interface GreenPinganDataTableRepository extends DataTablesRepository<GreenPingan, Long> {

}
