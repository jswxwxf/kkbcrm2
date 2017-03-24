/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.assessment.MobileAssessment;

/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface MobileAssessmentDatatableRepository extends DataTablesRepository<MobileAssessment, Long> {

}
