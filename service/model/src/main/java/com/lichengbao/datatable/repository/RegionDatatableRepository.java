/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.common.Region;

/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface RegionDatatableRepository extends DataTablesRepository<Region, Long> {

}
