/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.user.Reward;


/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface RewardDatatableRepository extends DataTablesRepository<Reward, Long> {

}
