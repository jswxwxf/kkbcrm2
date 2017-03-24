/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.user.UserBean;


/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface UserBeanDatatableRepository extends DataTablesRepository<UserBean, Long> {

}
