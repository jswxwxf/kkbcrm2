/**
 * 
 */
package com.lichengbao.datatable.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.lichengbao.domain.assessment.MonthlyAssessment;

/**
 * @author jwang
 *
 */
@Repository
@Transactional
public interface MonthlyAssessmentDatatableRepository extends DataTablesRepository<MonthlyAssessment, Long> {

}
